/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpomo.queueshop.Model.Factory;

/**
 *
 * @author Помогалов
 */
import com.vpomo.queueshop.Model.DAO.PurchaserDAOImpl;
import com.vpomo.queueshop.Model.DAO.PurchaserDAO;


public class PurchaserFactory {
      
      private static PurchaserFactory instance = null;
      private static PurchaserDAO PurchaserDAO = null;
      public static synchronized PurchaserFactory getPurchaserInstance(){
            if (instance == null){
              instance = new PurchaserFactory();
            }
            return instance;
      }

      public PurchaserDAO getPurchaserDAO(){
            if (PurchaserDAO == null){
              PurchaserDAO = new PurchaserDAOImpl();
            }
            return PurchaserDAO;
      }   
}
