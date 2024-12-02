package com.paymentchain.costumer.service;

import com.paymentchain.costumer.model.Costumer;
import com.paymentchain.costumer.repository.RepositoryCostumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServiceCostumer {
    @Autowired
    RepositoryCostumer repositoryCostumer;
    public Costumer saveCostumer(Costumer costumer){
        return repositoryCostumer.save(costumer);
    }
    public List<Costumer> finAll() {
        return repositoryCostumer.findAll();
    }
    public Optional<Costumer> getCostumerById(Long id) {
        return repositoryCostumer.findById(id);
    }
    public Costumer update(Costumer costumer) {
        Optional<Costumer> request = repositoryCostumer.findById(costumer.getId());
        if(request.isPresent()){
           Costumer response = request.get();
           if(costumer.getName() != null){
               response.setName(costumer.getName());
           }
           if(costumer.getPhone() != null){
               response.setPhone(costumer.getPhone());
           }
           return repositoryCostumer.save(response);
        }
        return null;
    }
    public Long deleteCostumerById(Long id) {
        repositoryCostumer.deleteById(id);
        Optional<Costumer> request = repositoryCostumer.findById(id);
        return request.isEmpty() ? id : -1;
    }
}
