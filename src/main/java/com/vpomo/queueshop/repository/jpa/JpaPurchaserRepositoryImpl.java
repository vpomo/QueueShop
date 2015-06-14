package com.vpomo.queueshop.repository.jpa;

import com.vpomo.queueshop.model.Purchaser;
import com.vpomo.queueshop.repository.PurchaserRepository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Example of usage JPA without spring data
 */
@Repository
@EnableTransactionManagement
public class JpaPurchaserRepositoryImpl implements PurchaserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void remove(int id) {
        Purchaser purchaser = this.entityManager.find(Purchaser.class, id);
        if (purchaser != null) {
            this.entityManager.remove(purchaser);
        }
    }

    @Override
    public void save(Purchaser purchaser) {
        if (purchaser.getId() == null) {
            this.entityManager.persist(purchaser);
        } else {
            this.entityManager.merge(purchaser);
        }
    }

    @Override
    public void clearAll() {
        int deletedCount = entityManager.createQuery("DELETE FROM Purchaser").executeUpdate();
    }

    @Override
    public Purchaser create(int typePurchaser, int cashBox, int quantityGoods, int waitCashbox) {
        Purchaser purchaser = new Purchaser(typePurchaser, cashBox, quantityGoods, waitCashbox);
        save(purchaser);
        return purchaser;
    }

    @Override
    public void updateStep(Purchaser currentPurchaser, int currentStep, int currPartQueue) {

        switch (currentStep) {
                case 1:
                    currentPurchaser.setStep1(currPartQueue + currentPurchaser.getStep1());
                    break;
                case 2:
                    currentPurchaser.setStep2(currPartQueue + currentPurchaser.getStep2());
                    break;
                case 3:
                    currentPurchaser.setStep3(currPartQueue + currentPurchaser.getStep3());
                    break;
                case 4:
                    currentPurchaser.setStep4(currPartQueue + currentPurchaser.getStep4());
                    break;
                case 5:
                    currentPurchaser.setStep5(currPartQueue + currentPurchaser.getStep5());
                    break;
                case 6:
                    currentPurchaser.setStep6(currPartQueue + currentPurchaser.getStep6());
                    break;
                case 7:
                    currentPurchaser.setStep7(currPartQueue + currentPurchaser.getStep7());
                    break;
                case 8:
                    currentPurchaser.setStep8(currPartQueue + currentPurchaser.getStep8());
                    break;
                case 9:
                    currentPurchaser.setStep9(currPartQueue + currentPurchaser.getStep9());
                    break;
                case 10:
                    currentPurchaser.setStep10(currPartQueue + currentPurchaser.getStep10());
                    break;
                case 11:
                    currentPurchaser.setStep11(currPartQueue + currentPurchaser.getStep11());
                    break;
                case 12:
                    currentPurchaser.setStep12(currPartQueue + currentPurchaser.getStep12());
                    break;
                case 13:
                    currentPurchaser.setStep13(currPartQueue + currentPurchaser.getStep13());
                    break;
                case 14:
                    currentPurchaser.setStep14(currPartQueue + currentPurchaser.getStep14());
                    break;
                case 15:
                    currentPurchaser.setStep15(currPartQueue + currentPurchaser.getStep15());
                    break;
                case 16:
                    currentPurchaser.setStep16(currPartQueue + currentPurchaser.getStep16());
                    break;
                case 17:
                    currentPurchaser.setStep17(currPartQueue + currentPurchaser.getStep17());
                    break;
                case 18:
                    currentPurchaser.setStep18(currPartQueue + currentPurchaser.getStep18());
                    break;
                case 19:
                    currentPurchaser.setStep19(currPartQueue + currentPurchaser.getStep19());
                    break;
                case 20:
                    currentPurchaser.setStep20(currPartQueue + currentPurchaser.getStep20());
                    break;
                case 21:
                    currentPurchaser.setStep21(currPartQueue + currentPurchaser.getStep21());
                    break;
                case 22:
                    currentPurchaser.setStep22(currPartQueue + currentPurchaser.getStep22());
                    break;
                case 23:
                    currentPurchaser.setStep23(currPartQueue + currentPurchaser.getStep23());
                    break;
                case 24:
                    currentPurchaser.setStep24(currPartQueue + currentPurchaser.getStep24());
                    break;
                case 25:
                    currentPurchaser.setStep25(currPartQueue + currentPurchaser.getStep25());
                    break;
                case 26:
                    currentPurchaser.setStep26(currPartQueue + currentPurchaser.getStep26());
                    break;
                case 27:
                    currentPurchaser.setStep27(currPartQueue + currentPurchaser.getStep27());
                    break;
                case 28:
                    currentPurchaser.setStep28(currPartQueue + currentPurchaser.getStep28());
                    break;
                case 29:
                    currentPurchaser.setStep29(currPartQueue + currentPurchaser.getStep29());
                    break;
                case 30:
                    currentPurchaser.setStep30(currPartQueue + currentPurchaser.getStep30());
                    break;
                default:
                    //оператор;
                    break;
            }
        Purchaser merge = this.entityManager.merge(currentPurchaser);
        this.entityManager.flush();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Purchaser> currentStepQueue(int currentStep, int cashBox) {
        String strCurrentStep = Integer.toString(currentStep);

        Query query = this.entityManager.createQuery("SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox AND p.step" + strCurrentStep + " > 0");
        query.setParameter("cashBox", cashBox);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public String currentStepQueueFirst(int id, int currentStep) {
        String strCurrentStep = Integer.toString(currentStep);
        String firstPurchaser = "no";

        Query query = this.entityManager.createQuery("SELECT p FROM Purchaser p WHERE p.id = :id AND p.step" + strCurrentStep + " > 1000");
        query.setParameter("id", id);
        List<Purchaser> resultList = query.getResultList();

        if (resultList.size() > 0) {
            firstPurchaser = "yes";
        }

        return firstPurchaser;
    }

    
}
