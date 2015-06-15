/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpomo.queueshop.repository.jpa;

import com.vpomo.queueshop.model.Purchaser;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pomogalov
 */
public class JpaPurchaserRepositoryImplTest {
    
    public JpaPurchaserRepositoryImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of remove method, of class JpaPurchaserRepositoryImpl.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int id = 0;
        JpaPurchaserRepositoryImpl instance = new JpaPurchaserRepositoryImpl();
        instance.remove(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class JpaPurchaserRepositoryImpl.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Purchaser purchaser = null;
        JpaPurchaserRepositoryImpl instance = new JpaPurchaserRepositoryImpl();
        instance.save(purchaser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearAll method, of class JpaPurchaserRepositoryImpl.
     */
    @Test
    public void testClearAll() {
        System.out.println("clearAll");
        JpaPurchaserRepositoryImpl instance = new JpaPurchaserRepositoryImpl();
        instance.clearAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class JpaPurchaserRepositoryImpl.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Purchaser createdPurchaser = null;
        int typePurchaser = 0;
        int cashBox = 0;
        int quantityGoods = 0;
        int waitCashbox = 0;
        JpaPurchaserRepositoryImpl instance = new JpaPurchaserRepositoryImpl();
        Purchaser expResult = null;
        Purchaser result = instance.create(typePurchaser, cashBox, quantityGoods, waitCashbox);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStep method, of class JpaPurchaserRepositoryImpl.
     */
    @Test
    public void testUpdateStep() {
        System.out.println("updateStep");
        Purchaser currentPurchaser = null;
        int currentStep = 0;
        int currPartQueue = 0;
        JpaPurchaserRepositoryImpl instance = new JpaPurchaserRepositoryImpl();
        instance.updateStep(currentPurchaser, currentStep, currPartQueue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of currentStepQueue method, of class JpaPurchaserRepositoryImpl.
     */
    @Test
    public void testCurrentStepQueue() {
        System.out.println("currentStepQueue");
        int currentStep = 0;
        int cashBox = 0;
        JpaPurchaserRepositoryImpl instance = new JpaPurchaserRepositoryImpl();
        List<Purchaser> expResult = null;
        List<Purchaser> result = instance.currentStepQueue(currentStep, cashBox);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of currentStepQueueFirst method, of class JpaPurchaserRepositoryImpl.
     */
    @Test
    public void testCurrentStepQueueFirst() {
        System.out.println("currentStepQueueFirst");
        int id = 0;
        int currentStep = 0;
        JpaPurchaserRepositoryImpl instance = new JpaPurchaserRepositoryImpl();
        String expResult = "";
        String result = instance.currentStepQueueFirst(id, currentStep);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
