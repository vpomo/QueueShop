/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.vpomo.queueshop.Model.DAO;

import com.vpomo.queueshop.Model.Entity.Purchaser;
import com.vpomo.queueshop.Util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Помогалов
 */
public class PurchaserDAOImpl implements PurchaserDAO {

@Override
public Purchaser CreatePurchaser(int typePurchaser,int cashBox,int quantityGoods,int waitCashbox) {
Purchaser purchaser = new Purchaser(typePurchaser, cashBox, quantityGoods, waitCashbox);
        Session session = null;
        Transaction transaction = null;        

        try {
                session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                session.save(purchaser);
                transaction.commit();
            } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }                
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        return purchaser;
    }

    @Override
    public void UpdateStepPurchaser(Purchaser currentPurchaser, int currentStep, int currPartQueue){
    Session session = null;
    Transaction transaction = null;  
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        switch(currentStep) {
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

        session.update(currentPurchaser);
        transaction.commit();
            } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }                
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    
        
    }

    
    @Override
    public List<Purchaser> getAll() {
    Query query = null;
    Session session = null;
    Transaction transaction = null;        
    List<Purchaser> resultlist = null;
    String queryString="SELECT u FROM Purchaser u";

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        query= session.createQuery(queryString);
        resultlist = query.list();
        transaction.commit();
            } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }                
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    return resultlist;
    }
    
    @Override
    public void clearAll() {
    Query query = null;
    Session session = null;
    Transaction transaction = null;        
    List<Purchaser> resultlist = null;
    String queryString="SELECT u FROM Purchaser u";
    int id;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        query= session.createQuery(queryString);
        resultlist = query.list();
        
        
        for (int i=0; i<resultlist.size(); i++){
            id=resultlist.get(i).getId();
            removePurchaser(id);
        
        }

            transaction.commit();
        
                } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }                
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    
    @Override
    public void removePurchaser(int id) {
        Purchaser purchaser;
        Session session = null;
        Transaction transaction = null;        

        try {
                session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                purchaser = (Purchaser) session.get(Purchaser.class, id);
                if (purchaser != null){
                    session.delete(purchaser);
                    transaction.commit();
                }
            } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }                
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
    }

    
    @Override
    public List<Purchaser> currentStepQueue(int currentStep, int cashBox){
    Query query;
    Session session = null;
    Transaction transaction = null;   
    String queryString = null;
    String strCurrentStep = Integer.toString(currentStep);
    List<Purchaser> resultlist = null;
    
    queryString="SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox AND p.step" + strCurrentStep + " > 0";
    /*    switch(currentStep) {
        case 1: 
            queryString="SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox AND p.step1 > 0";
	break;
        case 2: 
            queryString="SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox AND p.step2 > 0";
	break;
        case 3: 
            queryString="SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox AND p.step3 > 0";
	break;
        case 4: 
            queryString="SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox AND p.step4 > 0";
	break;
        case 5: 
            queryString="SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox AND p.step5 > 0";
	break;
        case 6: 
            queryString="SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox AND p.step6 > 0";
	break;
        case 7: 
            queryString="SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox AND p.step7 > 0";
	break;
        case 8: 
            queryString="SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox AND p.step8 > 0";
	break;
        case 9: 
            queryString="SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox AND p.step9 > 0";
	break;
        case 10: 
            queryString="SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox AND p.step10 > 0";
	break;
        default: 
	    //оператор;
	break;
        }
    */
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        query= session.createQuery(queryString);
        query.setParameter("cashBox", cashBox);
        //query.setParameter("step1", currentStep);

        resultlist = query.list();
        transaction.commit();
            } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }                
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    return resultlist;    
    }

    @Override
    public String currentStepQueueFirst(int id, int currentStep){
    String firstPurchaser;
    List<Purchaser> resultlist = null;
    Session session = null;
    Transaction transaction = null;        
    Query query;
    String strCurrentStep = Integer.toString(currentStep);
    String queryString="SELECT p FROM Purchaser p WHERE p.id = :id AND p.step" + strCurrentStep + " > 1000";

    firstPurchaser = "no"; 
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        query= session.createQuery(queryString);
        query.setParameter("id", id);
        resultlist = query.list();
        transaction.commit();

        if (resultlist.size() > 0){
            firstPurchaser = "yes";} 
        }        
            
        catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }                
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
    return firstPurchaser;
    }
    
}
