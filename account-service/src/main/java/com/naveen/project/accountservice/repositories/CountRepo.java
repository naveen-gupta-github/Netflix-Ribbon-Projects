package com.naveen.project.accountservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.naveen.project.accountservice.models.Count;


@Repository
public interface CountRepo extends CrudRepository<Count, Integer>{
	
	
	@Query("SELECT a.status, a.count from Count a")
	List<Object[]> getCount();
}
