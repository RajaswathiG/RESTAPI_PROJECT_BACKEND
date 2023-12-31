package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

//import com.example.demo.Model.Fruit;
import com.example.demo.Model.Transaction;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Repo extends JpaRepository<Transaction, Integer>{
	@Query(value = "SELECT * FROM transaction_entity ORDER BY transaction_id", nativeQuery = true)
	public List<Transaction> sortbytid();
	@Transactional
	@Modifying
	@Query(value="delete from transaction_entity where transaction_id= :para",nativeQuery = true )
	public void deletemebyid(@Param("para") int id);

	@Transactional
	@Modifying
	@Query(value="update donors set address = 'updated street' where donor_id=6",nativeQuery = true )
	public void updatebyq();
	
}