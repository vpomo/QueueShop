package com.vpomo.queueshop.repository.jpa;

import com.vpomo.queueshop.model.Purchaser;
import com.vpomo.queueshop.repository.PurchaserRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * JPA implementation of the {@link PurchaserRepository} interface.
 *
 * @author Pomogalov Vladimir
 */
@Repository
@EnableTransactionManagement
public class JpaPurchaserRepositoryImpl implements PurchaserRepository {
    private static final Logger logger = LoggerFactory.getLogger(JpaPurchaserRepositoryImpl.class);
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
        String strCurrentStep = Integer.toString(currentStep);
        String strCurrPartQueue = Integer.toString(currPartQueue);
        int idCurrentPurchaser = currentPurchaser.getId();
        int newValueCurrentStep = getValueStepByIdPurchaser(idCurrentPurchaser, currentStep) + currPartQueue;

        Query query = this.entityManager.createQuery("Update Purchaser p SET p.step" + strCurrentStep + " = :valueStep WHERE p.id = :id");
        query.setParameter("valueStep", newValueCurrentStep);
        query.setParameter("id", idCurrentPurchaser);
        int updatedCount = query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Integer getValueStepByIdPurchaser(int idPurchaser, int currentStep) {
        String strCurrentStep = Integer.toString(currentStep);
        
        Query query = this.entityManager.createQuery("SELECT p.step" + strCurrentStep + " FROM Purchaser p WHERE p.id = :id");
        query.setParameter("id", idPurchaser);
        List<Integer> valueCurrentStep = query.getResultList();

        if (valueCurrentStep.size() > 0) {
            return valueCurrentStep.get(0);
        } else {
            return 0;
        }
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
