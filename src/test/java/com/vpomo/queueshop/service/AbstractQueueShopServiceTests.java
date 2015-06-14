package com.vpomo.queueshop.service;

import com.vpomo.queueshop.model.Purchaser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractQueueShopServiceTests {

    @Autowired
    protected QueueShopService queueShopService;

    public Integer idPurshaser;

    @Transactional
    @Before
    public void shouldInsertPurchaser() {
        Purchaser purchaser = new Purchaser();
        purchaser.setCashBox(0);
        purchaser.setQuantityGoods(15);
        purchaser.setTypePurchaser(1);
        purchaser.setWaitCashbox(5);
        this.queueShopService.savePurchaser(purchaser);
        idPurshaser = purchaser.getId();
        //assertThat(purchaser.getId().intValue()).isNotEqualTo(0);
        //assertThat(purchaser.getId().intValue()).isNotEqualTo(0);
        System.out.println(" ==== Before Test's passed ==== ");
    }

    @After
    public void tearDown() {
        this.queueShopService.removePurchaser(idPurshaser);
        System.out.println(" **** After Test's passed *** ");
    }

    @Test
    public void testFoo() {
        int a = 5;
        Assert.assertNotNull(a);
    }

}
