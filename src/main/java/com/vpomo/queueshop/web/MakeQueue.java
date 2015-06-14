package com.vpomo.queueshop.web;

import com.vpomo.queueshop.model.Purchaser;
import com.vpomo.queueshop.service.QueueShopService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MakeQueue {

    private final QueueShopService queueShopService;

    @Autowired
    public MakeQueue(QueueShopService queueShopService) {
        this.queueShopService = queueShopService;
    }

    private static final Logger logger = LoggerFactory.getLogger(MakeQueue.class);
    public ArrayList<Purchaser> queueCashbox1 = new ArrayList<>();
    public ArrayList<Purchaser> queueCashbox2 = new ArrayList<>();
    public ArrayList<Purchaser> queueCashbox3 = new ArrayList<>();
    public ArrayList<Purchaser> queueCashbox4 = new ArrayList<>();
//– число шагов работы магазина
    public Integer numSteps = 10;
//– число касс, обслуживающих покупателей
    public Integer numberCashbox = 3;
//– производительность кассы
    public Integer powerCashbox = 3;

    /**
     * Simply selects the home view to render by returning its name.
     *
     * @param principal
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "/index";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorTest(Model model) {
        return "/error";
    }

    @RequestMapping(value = "/createmodel", method = RequestMethod.POST)
    public String createModel(HttpServletRequest request, Model model) {
        Purchaser currentPurchaser = null;
        Random rand = new Random();
        Integer typePurchaser = 4;
        Integer quantityGoods = 0, cashBox = 0, waitCashbox = 0;

        Enumeration<String> parameters = request.getParameterNames();
        while (parameters.hasMoreElements()) {
            String parameter = parameters.nextElement();
            switch (parameter) {
                case "numStep":
                    numSteps = Integer.parseInt(request.getParameter(parameter));
                    break;
                case "numCashBox":
                    numberCashbox = Integer.parseInt(request.getParameter(parameter));
                    break;
                case "powerCashBox":
                    powerCashbox = Integer.parseInt(request.getParameter(parameter));
                    break;
            }
        }

        if (testErrorInputForm(numSteps, numberCashbox, powerCashbox) > 0) {
            model.addAttribute("notif", "Ошибка ввода!!! Пожалуйста, повторите ввод исходных данных для построения модели");
            return "/error";
        }

        queueCashbox1.clear();
        queueCashbox1.trimToSize();
        queueCashbox2.clear();
        queueCashbox2.trimToSize();
        queueCashbox3.clear();
        queueCashbox3.trimToSize();
        queueCashbox4.clear();
        queueCashbox4.trimToSize();

        this.queueShopService.clearAllPurchaser();

        for (int step = 1; step < numSteps + 1; step++) {
            typePurchaser = rand.nextInt(3);
            quantityGoods = 1 + rand.nextInt(20);

            waitCashbox = (int) Math.floor(quantityGoods / powerCashbox);
            if (quantityGoods % powerCashbox > 0) {
                waitCashbox = waitCashbox + 1;
            }

            switch (typePurchaser) {
                case 0:
                    cashBox = manAnalysisQueue();
                    break;
                case 1:
                    cashBox = womanAnalysisQueue();
                    break;
                case 2:
                    cashBox = childAnalysisQueue();
                    break;
                default:
                    //оператор;
                    break;
            }

            currentPurchaser = this.queueShopService.createPurchaser(typePurchaser, cashBox, quantityGoods, waitCashbox - 1);
            switch (cashBox) {
                case 1:
                    queueCashbox1.add(currentPurchaser);
                    this.queueShopService.updateStepPurchaser(currentPurchaser, step, 1000);
                    break;
                case 2:
                    queueCashbox2.add(currentPurchaser);
                    this.queueShopService.updateStepPurchaser(currentPurchaser, step, 1000);
                    break;
                case 3:
                    queueCashbox3.add(currentPurchaser);
                    this.queueShopService.updateStepPurchaser(currentPurchaser, step, 1000);
                    break;
                case 4:
                    queueCashbox4.add(currentPurchaser);
                    this.queueShopService.updateStepPurchaser(currentPurchaser, step, 1000);
                    break;
                default:
                    //оператор;
                    break;
            }

            logger.info("typePurchaser=" + typePurchaser + " cashBox=" + cashBox + " quantityGoods=" + quantityGoods + " waitCashbox=" + waitCashbox);

//PurchaserFactory.getPurchaserInstance().getPurchaserDAO().UpdateStepPurchaserId(currentPurchaser.getId(), 4, 1);
            logger.info("queue #1");
            orderingQueue(1, step);
            logger.info("queue #2");
            orderingQueue(2, step);
            logger.info("queue #3");
            orderingQueue(3, step);
            logger.info("queue #4");
            orderingQueue(4, step);

        }   //for step         
        model.addAttribute("numSteps", numSteps);
        return "/drawstep";
    }

    @RequestMapping(value = "/drawstep", method = RequestMethod.GET)
    public String draw(Model model) {

        model.addAttribute("numSteps", numSteps);
        return "/drawstep";
    }

    private void orderingQueue(int cashbox, int currentStep) {
        Integer lengthQueue1 = 0, waitQueue1 = 0, lengthQueue2 = 0, waitQueue2 = 0,
                lengthQueue3 = 0, waitQueue3 = 0, lengthQueue4 = 0, waitQueue4 = 0;
        Purchaser pur;
        switch (cashbox) {
            case 1:
                lengthQueue1 = queueCashbox1.size();
                if (lengthQueue1 > 0) {
                    waitQueue1 = queueCashbox1.get(0).getWaitCashbox();
                    logger.info("waitQueue1=" + waitQueue1);
                    if (waitQueue1 > 0) {
                        queueCashbox1.get(0).setWaitCashbox(waitQueue1 - 1);
                    }

                    for (int j = 0; j < lengthQueue1; j++) {
                        logger.info(queueCashbox1.get(j).toString() + "  j=" + j);
                        this.queueShopService.updateStepPurchaser(queueCashbox1.get(j), currentStep, j + 1);
                    }

                    if (waitQueue1 == 0) {
                        pur = queueCashbox1.remove(0);
                    }

                }
                break;
            case 2:
                lengthQueue2 = queueCashbox2.size();
                if (lengthQueue2 > 0) {
                    waitQueue2 = queueCashbox2.get(0).getWaitCashbox();
                    logger.info("waitQueue2=" + waitQueue2);
                    if (waitQueue2 > 0) {
                        queueCashbox2.get(0).setWaitCashbox(waitQueue2 - 1);
                    }

                    for (int j = 0; j < lengthQueue2; j++) {
                        logger.info(queueCashbox2.get(j).toString());
                        this.queueShopService.updateStepPurchaser(queueCashbox2.get(j), currentStep, j + 1);
                    }

                    if (waitQueue2 == 0) {
                        pur = queueCashbox2.remove(0);
                    }
                }
                break;
            case 3:
                lengthQueue3 = queueCashbox3.size();
                if (lengthQueue3 > 0) {
                    waitQueue3 = queueCashbox3.get(0).getWaitCashbox();
                    logger.info("waitQueue3=" + waitQueue3);
                    if (waitQueue3 > 0) {
                        queueCashbox3.get(0).setWaitCashbox(waitQueue3 - 1);
                    }

                    for (int j = 0; j < lengthQueue3; j++) {
                        logger.info(queueCashbox3.get(j).toString());
                        this.queueShopService.updateStepPurchaser(queueCashbox3.get(j), currentStep, j + 1);
                    }

                    if (waitQueue3 == 0) {
                        pur = queueCashbox3.remove(0);
                    }

                }
                break;
            case 4:
                lengthQueue4 = queueCashbox4.size();
                if (lengthQueue4 > 0) {
                    waitQueue4 = queueCashbox4.get(0).getWaitCashbox();
                    logger.info("waitQueue4=" + waitQueue4);
                    if (waitQueue4 > 0) {
                        queueCashbox4.get(0).setWaitCashbox(waitQueue4 - 1);
                    }

                    for (int j = 0; j < queueCashbox4.size(); j++) {
                        logger.info(queueCashbox4.get(j).toString());
                        this.queueShopService.updateStepPurchaser(queueCashbox4.get(j), currentStep, j + 1);
                    }

                    if (waitQueue4 == 0) {
                        pur = queueCashbox4.remove(0);
                    }
                }
                break;
            default:
                //оператор;
                break;
        }

    }

    private Integer manAnalysisQueue() {
        Integer lengthQueue1 = queueCashbox1.size(), sumWaitCashbox1 = 0, lengthQueue2 = queueCashbox2.size(), sumWaitCashbox2 = 0,
                lengthQueue3 = queueCashbox3.size(), sumWaitCashbox3 = 0, lengthQueue4 = queueCashbox4.size(), sumWaitCashbox4 = 0;
        if (lengthQueue1 >= 0) {
            for (int j = 0; j < lengthQueue1; j++) {
                sumWaitCashbox1 = sumWaitCashbox1 + queueCashbox1.get(j).getWaitCashbox();
            }
        }
        if (lengthQueue2 >= 0) {
            for (int j = 0; j < lengthQueue2; j++) {
                sumWaitCashbox2 = sumWaitCashbox2 + queueCashbox2.get(j).getWaitCashbox();
            }
        }
        if (lengthQueue3 >= 0) {
            for (int j = 0; j < lengthQueue3; j++) {
                sumWaitCashbox3 = sumWaitCashbox3 + queueCashbox3.get(j).getWaitCashbox();
            }
        }
        if (lengthQueue4 >= 0) {
            for (int j = 0; j < lengthQueue4; j++) {
                sumWaitCashbox4 = sumWaitCashbox4 + queueCashbox4.get(j).getWaitCashbox();
            }
        }

        int[] lengthQueue = {sumWaitCashbox1, sumWaitCashbox2, sumWaitCashbox3, sumWaitCashbox4};

        int min = lengthQueue[0], numberQueue = 1;

        for (int mn = 0; mn != numberCashbox; mn++) {
            if (lengthQueue[mn] < min) {
                min = lengthQueue[mn];
                numberQueue = mn + 1;
            }
        }

        return numberQueue;
    }

    private Integer womanAnalysisQueue() {
        Integer lengthQueue1 = queueCashbox1.size(), lengthQueue2 = queueCashbox2.size(),
                lengthQueue3 = queueCashbox3.size(), lengthQueue4 = queueCashbox4.size();

        int[] lengthQueue = {lengthQueue1, lengthQueue2, lengthQueue3, lengthQueue4};
        int min = lengthQueue[0], numberQueue = 1;
        for (int mn = 0; mn != numberCashbox; mn++) {
            if (lengthQueue[mn] < min) {
                min = lengthQueue[mn];
                numberQueue = mn + 1;
            }
        }
        return numberQueue;
    }

    private Integer childAnalysisQueue() {
        Random randQueue = new Random();
        Integer numberQueue = 1 + randQueue.nextInt(numberCashbox);
        return numberQueue;
    }

    private Integer testErrorInputForm(Integer numStep, Integer numberCashboxs, Integer powerCashboxs) {
        Integer errortest = 0;
        if ((numStep > 30) | (numStep < 2)) {
            errortest = 1;
        }
        if ((numberCashboxs > 4) | (numberCashboxs < 1)) {
            errortest = 2;
        }
        if ((powerCashboxs > 5) | (powerCashboxs < 2)) {
            errortest = 3;
        }
        return errortest;
    }

}
