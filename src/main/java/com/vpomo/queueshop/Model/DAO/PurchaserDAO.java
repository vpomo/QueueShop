/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpomo.queueshop.Model.DAO;

import com.vpomo.queueshop.Model.Entity.Purchaser;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Помогалов
 */
public interface PurchaserDAO {
    public List<Purchaser> getAll();
    public String currentStepQueueFirst(int id, int currentStep);
    public void UpdateStepPurchaser(Purchaser currentPurchaser, int currentStep, int currPartQueue);
    public Purchaser CreatePurchaser(int typePurchaser,int cashBox,int quantityGoods,int waitCashbox); 
    public void clearAll();
    public void removePurchaser(int id);
    public List<Purchaser> currentStepQueue(int currentStep, int cashBox);
}
