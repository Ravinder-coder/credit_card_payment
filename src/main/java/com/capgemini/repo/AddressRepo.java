package com.capgemini.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{

}
