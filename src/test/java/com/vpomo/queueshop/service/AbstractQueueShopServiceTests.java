package com.vpomo.queueshop.service;

import com.vpomo.queueshop.model.Purchaser;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Here are the methods for testing data features
 *
 * @author Pomogalov Vladimir
 */


public abstract class AbstractQueueShopServiceTests {

    @Autowired
    protected QueueShopService queueShopService;

    public Integer idPurshaser;
    public Purchaser purchaser = new Purchaser();

    @Transactional
    @Before
    public void shouldInsertPurchaser() {
        purchaser.setCashBox(0);
        purchaser.setQuantityGoods(15);
        purchaser.setTypePurchaser(1);
        purchaser.setWaitCashbox(5);

        System.out.println(" ==== Test Save(purchaser) ==== ");
        this.queueShopService.savePurchaser(purchaser);
        idPurshaser = purchaser.getId();
        System.out.println(" ==== Before Test's passed ==== ");
    }

    @After
    public void tearDown() {
        System.out.println(" ==== Test remove(id) ==== ");
        this.queueShopService.removePurchaser(idPurshaser);

        System.out.println(" ==== Test clearAll() ==== ");
        this.queueShopService.clearAllPurchaser();

        System.out.println(" **** After Test's passed *** ");
    }

    @Test
    public void testPurchaserClass() {
        System.out.println(" ==== Test's PurchaserClass begin ==== ");
        assertThat(purchaser.getId().intValue()).isNotEqualTo(0);    
        
        Assert.assertNotNull(purchaser);
        System.out.println(" ==== Test's PurchaserClass passed ==== ");
    }
    
    @Test
    public void testCreate() {
        System.out.println(" ==== Test create(typePurchaser, cashBox, quantityGoods, waitCashbox) started ==== ");
        Purchaser createdPurchaser = null;

        int typePurchaser = 100;
        int cashBox = 100;
        int quantityGoods = 100;
        int waitCashbox = 100;
        createdPurchaser = this.queueShopService.createPurchaser(typePurchaser, cashBox, quantityGoods, waitCashbox);
        
        assertThat(createdPurchaser.getTypePurchaser()).isEqualTo(100);
        assertThat(createdPurchaser.getCashBox()).isEqualTo(100);
        assertThat(createdPurchaser.getQuantityGoods()).isEqualTo(100);
        assertThat(createdPurchaser.getWaitCashbox()).isEqualTo(100);
        
        System.out.println(" ==== Test create() passed ==== ");
    }
    
    @Test
    public void testUpdateStep() {
        System.out.println(" ==== Test updateStep(currentPurchaser, currentStep, currPartQueue) ==== ");
        int currentStep = 2;
        int currPartQueue = 90;
        assertThat(this.queueShopService.getValueStepByIdPurchaser(idPurshaser, currentStep)).isEqualTo(0);
        this.queueShopService.updateStepPurchaser(purchaser, currentStep, currPartQueue);
        assertThat(this.queueShopService.getValueStepByIdPurchaser(idPurshaser, currentStep)).isEqualTo(90);
        currPartQueue = currPartQueue + 30;
        this.queueShopService.updateStepPurchaser(purchaser, currentStep, currPartQueue);
        assertThat(this.queueShopService.getValueStepByIdPurchaser(idPurshaser, currentStep)).isEqualTo(210);
        System.out.println(" ==== Test updateStep() passed ==== ");
    }

    @Test
    public void testCurrentStepQueue() {
        System.out.println(" ==== Test currentStepQueue(currentStep, cashBox) ==== ");
        int currentStep = 3;
        int cashBox = 0;
        List<Purchaser> result = this.queueShopService.currentStepQueue(currentStep, cashBox);
        assertThat(result.contains(purchaser)).isFalse();

        this.queueShopService.updateStepPurchaser(purchaser, 3, 3);
        result = this.queueShopService.currentStepQueue(currentStep, cashBox);
        assertThat(result.contains(purchaser)).isTrue();
        System.out.println(" ==== Test currentStepQueue() passed ==== ");
    }
    
    @Test
    public void testCurrentStepQueueFirst() {
        System.out.println(" ==== Test currentStepQueueFirst(id, currentStep) ==== ");
        int id = idPurshaser;
        int currentStep = 4;
        String expResult = "no";
        String result = this.queueShopService.currentStepQueueFirst(id, currentStep);
        assertEquals(expResult, result);
        
        this.queueShopService.updateStepPurchaser(purchaser, currentStep, 1003);
        result = this.queueShopService.currentStepQueueFirst(id, currentStep);
        expResult = "yes";
        assertEquals(expResult, result);
        
        System.out.println(" ==== Test currentStepQueueFirst() passed ==== ");
    }
    
}
