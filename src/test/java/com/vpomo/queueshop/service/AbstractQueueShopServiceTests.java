package com.vpomo.queueshop.service;

import com.vpomo.queueshop.model.Purchaser;
import com.vpomo.queueshop.repository.jpa.JpaPurchaserRepositoryImpl;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
        System.out.println(" ==== Test create() started ==== ");
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
    
}
