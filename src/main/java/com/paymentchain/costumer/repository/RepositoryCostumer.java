package com.paymentchain.costumer.repository;

import com.paymentchain.costumer.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCostumer extends JpaRepository<Costumer,Long> {
}
