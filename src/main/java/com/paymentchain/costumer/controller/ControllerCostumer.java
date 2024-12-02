package com.paymentchain.costumer.controller;

import com.paymentchain.costumer.model.Costumer;
import com.paymentchain.costumer.service.ServiceCostumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/costumer")
public class ControllerCostumer {

    @Autowired
    ServiceCostumer serviceCostumer;
    @PostMapping("/create-costumer")
    public ResponseEntity<Costumer> saveCostumer(@RequestBody Costumer costumer){
        final Costumer response = serviceCostumer.saveCostumer(costumer);
        return Objects.nonNull(response) ? ResponseEntity.ok(response) : ResponseEntity.internalServerError().body(costumer);
    }
    @GetMapping("/list-all-costumers")
    public List<Costumer> findAll(){
        return serviceCostumer.finAll();
    }
    @GetMapping("/list-costumer/{id}")
    public ResponseEntity<Optional<Costumer>> getCostumerById(@PathVariable Long id){
        final Optional<Costumer> response =  serviceCostumer.getCostumerById(id);
        return Objects.nonNull(response) ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
    @PatchMapping("/update-costumer")
    public ResponseEntity<?> updateCostumer(@RequestBody Costumer costumer){
        final Costumer response = serviceCostumer.update(costumer);
        return Objects.nonNull(response) ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("delete-costumer/{id}")
    public ResponseEntity<?> deleteCostumerById(@PathVariable Long id){
        final long response = serviceCostumer.deleteCostumerById(id);
        return (response == id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
