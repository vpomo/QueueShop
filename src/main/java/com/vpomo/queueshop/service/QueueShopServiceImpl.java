package com.vpomo.queueshop.service;

import com.vpomo.queueshop.model.Purchaser;
import com.vpomo.queueshop.repository.PurchaserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.dao.DataAccessException;

@Service
//@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
public class QueueShopServiceImpl implements QueueShopService {
private final PurchaserRepository purchaserRepository;

    @Autowired
    public QueueShopServiceImpl(PurchaserRepository purchaserRepository) throws DataAccessException{
        this.purchaserRepository = purchaserRepository;
    }

    @Override
    @Transactional
    public void removePurchaser(int id)  throws DataAccessException {
        purchaserRepository.remove(id);
    }
    
    @Override
    @Transactional
    public void savePurchaser(Purchaser purchaser)  throws DataAccessException {
        purchaserRepository.save(purchaser);
    }
    
    @Override
    @Transactional
    public void clearAllPurchaser()  throws DataAccessException {
        purchaserRepository.clearAll();
    }

    @Override
    @Transactional
    public Purchaser createPurchaser(int typePurchaser, int cashBox, int quantityGoods, int waitCashbox) throws DataAccessException {
        return purchaserRepository.create(typePurchaser, cashBox, quantityGoods, waitCashbox);
    }

    @Override
    @Transactional
    public void updateStepPurchaser(Purchaser currentPurchaser, int currentStep, int currPartQueue)  throws DataAccessException {
        purchaserRepository.updateStep(currentPurchaser, currentStep, currPartQueue);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Purchaser> currentStepQueue(int currentStep, int cashBox)  throws DataAccessException {
        return purchaserRepository.currentStepQueue(currentStep, cashBox);
    }

    @Override
    @Transactional(readOnly = true)
    public String currentStepQueueFirst(int id, int currentStep)  throws DataAccessException {
        return purchaserRepository.currentStepQueueFirst(id, currentStep);
    }

}
