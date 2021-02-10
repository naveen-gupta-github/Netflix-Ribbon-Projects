package com.naveen.project.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naveen.project.accountservice.models.AccountEntity;


@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Integer> {

}
