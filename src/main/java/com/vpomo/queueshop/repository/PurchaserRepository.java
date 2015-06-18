package com.vpomo.queueshop.repository;

import com.vpomo.queueshop.model.Purchaser;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * Repository interface for <code>Purchaser</code> domain objects
 *
 * @author Pomogalov Vladimir
 */
public interface PurchaserRepository {
    void remove(int id) throws DataAccessException;
    void save(Purchaser purchaser) throws DataAccessException;
    void clearAll() throws DataAccessException;
    Purchaser create(int typePurchaser, int cashBox, int quantityGoods, int waitCashbox)  throws DataAccessException;
    Integer getValueStepByIdPurchaser(int idPurchaser, int currentStep) throws DataAccessException;
    void updateStep(Purchaser currentPurchaser, int currentStep, int currPartQueue) throws DataAccessException;   
    List<Purchaser> currentStepQueue(int currentStep, int cashBox)  throws DataAccessException;
    String currentStepQueueFirst(int id, int currentStep)  throws DataAccessException;   
}
