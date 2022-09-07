package com.capgemini.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.Transection;
@Repository
public interface TransectionRepo extends JpaRepository<Transection, Long>{

}
