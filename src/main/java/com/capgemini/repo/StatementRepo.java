package com.capgemini.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.Statement;
@Repository
public interface StatementRepo extends JpaRepository<Statement, Long>{

}
