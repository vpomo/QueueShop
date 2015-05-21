/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.vpomo.queueshop.Controller;

import com.vpomo.queueshop.Model.Entity.Purchaser;
import main.java.com.vpomo.queueshop.Model.Factory.PurchaserFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Альбина
 */
public class drawqueue extends HttpServlet {
private static final Logger logger = LoggerFactory.getLogger(drawqueue.class);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public Integer currentStep;
    public Integer numSteps = 30;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //numSteps = (Integer) getServletContext().getAttribute("numSteps");
        String pressButton = "no";
        
        List<Purchaser> resultPurchaser = null;        
        
        try (PrintWriter out = response.getWriter()) {

            String userPath = "http://localhost:8080/QueueShop/resources/image/";
            String userPathServlet = "http://localhost:8080/QueueShop";

            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Отрисовка очередей в магазине</title>");            
            out.println("</head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href="+ userPath +"css/style.css\">");

            out.println("<body>");
            out.println("<img id=\"image1\" src=\"" + userPath + "kassa.jpg\" style=\"display:none;\"/>");
            out.println("<img id=\"image2\" src=\"" + userPath + "man.png\" style=\"display:none;\"/>");
            out.println("<img id=\"image3\" src=\"" + userPath + "woman.png\" style=\"display:none;\"/>");
            out.println("<img id=\"image4\" src=\"" + userPath + "child.png\" style=\"display:none;\"/>");

            out.println("");
pressButton = "no";
            Enumeration<String> parameters = request.getParameterNames();
            while (parameters.hasMoreElements()) {
                String parameter = parameters.nextElement();
                    switch (parameter) {
                        case "retStepNext":
                            pressButton = request.getParameter(parameter);
                        break;
                        case "retStepPrev":
                            pressButton = request.getParameter(parameter);
                        break;
                    }
                }
            switch (pressButton) {
                        case "prv":
                            if (currentStep>1){ currentStep = currentStep -1;} 
                        break;
                        case "nxt":
                            if (currentStep < numSteps){ currentStep = currentStep + 1;} 
                        break;
                        default:
                            currentStep =1;
                        break;
                    }

            int k=currentStep; 
    
            out.println("<p> Шаг № " + k + "</p>");
            out.println("<canvas id='draw' width='600' height='400' style='border:1px solid;'></canvas>");
            out.println("<script type='text/javascript'>");
            out.println("var imgkassa=document.getElementById(\"image1\");");
            out.println("var imgman=document.getElementById(\"image2\");");
            out.println("var imgwoman=document.getElementById(\"image3\");");
            out.println("var imgchild=document.getElementById(\"image4\");");
            out.println("var canvas=document.getElementById(\"draw\")");
            out.println("var x=canvas.getContext(\"2d\");");
            out.println("x.font='10px Verdana';");
            out.println("x.fillStyle='#60016d';");
    

            out.println("x.drawImage(imgkassa,10,40);");
            out.println("x.fillText(\"Касса №1\", 10, 40);");

            out.println("x.drawImage(imgkassa,10,130);");
            out.println("x.fillText(\"Касса №2\", 10, 130);");

            out.println("x.drawImage(imgkassa,10,220);");
            out.println("x.fillText(\"Касса №3\", 10, 220);");
            
            out.println("x.drawImage(imgkassa,10,310);");
            out.println("x.fillText(\"Касса №4\", 10, 310);");

            
    for (int i=1; i<5; i++){
    resultPurchaser = PurchaserFactory.getPurchaserInstance().getPurchaserDAO().currentStepQueue(k, i);
        if (resultPurchaser.size() > 0) {
            for (int j=0; j<resultPurchaser.size(); j++){
                if (resultPurchaser.get(j) != null){

            switch(resultPurchaser.get(j).getTypePurchaser()) {
                case 0: 
                    out.println("x.drawImage(imgman,"+ (10+70*(j+1)) + "," + (40+90*(i-1)) + ");");
                    if (PurchaserFactory.getPurchaserInstance().getPurchaserDAO().currentStepQueueFirst(resultPurchaser.get(j).getId(), k) == "yes"){
                        out.println("x.fillText(\"" + "[new!]" + "\","+ (50+70*(j+1)) + "," + (40+90*(i-1)) + ");");
                    }
                    out.println("x.fillText(\"" + resultPurchaser.get(j).getQuantityGoods() + "\","+ (35+70*(j+1)) + "," + (40+90*(i-1)) + ");");
                    out.println("x.font='10px Verdana';");
                    out.println("x.fillStyle='#60016d';");
                    
                break;
                case 1: 
                    out.println("x.drawImage(imgwoman," + (10+70*(j+1)) +  ","  + (40+90*(i-1)) + ");");
                    if (PurchaserFactory.getPurchaserInstance().getPurchaserDAO().currentStepQueueFirst(resultPurchaser.get(j).getId(), k) == "yes"){
                        out.println("x.fillText(\"" + "[new!]" + "\","+ (50+70*(j+1)) + "," + (40+90*(i-1)) + ");");
                    }
                    out.println("x.fillText(\"" + resultPurchaser.get(j).getQuantityGoods() + "\"," + (35+70*(j+1)) + "," + (40+90*(i-1)) + ");");
                break;
                case 2: 
                    out.println("x.drawImage(imgchild," + (10+70*(j+1)) + ","  + (40+90*(i-1)) + ");");
                    if (PurchaserFactory.getPurchaserInstance().getPurchaserDAO().currentStepQueueFirst(resultPurchaser.get(j).getId(), k) == "yes"){
                        out.println("x.fillText(\"" + "[new!]" + "\","+ (50+70*(j+1)) + "," + (40+90*(i-1)) + ");");
                    }
                    out.println("x.fillText(\"" + resultPurchaser.get(j).getQuantityGoods() + "\"," + (35+70*(j+1)) + "," + (40+90*(i-1)) + ");");
                break;
                default: 
                    //оператор;
                break;
            }
            
                    
                }
            }
        }    
    }

            out.println("</script>");

            out.println("<br>");
            out.println("<form method=\"POST\" action=\""+ userPathServlet+ "/drawqueue\">");
            out.println("<p>");
            out.println("<button type=\"submit\" name=\"retStepPrev\" value=\"prv\">Назад на шаг ...</button>");
            out.println("<button type=\"submit\" name=\"retStepNext\" value=\"nxt\">Перейти на шаг вперед ...</button>");
            out.println("</p>");    
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
