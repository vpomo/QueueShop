package com.vpomo.queueshop.service;

import com.vpomo.queueshop.model.Purchaser;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Pomogalov Vladimir
 */

public interface QueueShopService {

    public void removePurchaser(int id) throws DataAccessException;
    public void savePurchaser(Purchaser purchaser) throws DataAccessException;
    public void clearAllPurchaser() throws DataAccessException;
    public Purchaser createPurchaser(int typePurchaser, int cashBox, int quantityGoods, int waitCashbox)  throws DataAccessException;
    public void updateStepPurchaser(Purchaser currentPurchaser, int currentStep, int currPartQueue) throws DataAccessException;
    public List<Purchaser> currentStepQueue(int currentStep, int cashBox)  throws DataAccessException;
    public String currentStepQueueFirst(int id, int currentStep)  throws DataAccessException;   
    public Integer getValueStepByIdPurchaser(int idPurchaser, int currentStep) throws DataAccessException;
            
}
