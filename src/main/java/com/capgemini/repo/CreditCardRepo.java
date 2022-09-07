package com.capgemini.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.CreditCard;
@Repository
public interface CreditCardRepo extends JpaRepository<CreditCard, Long>{

}
