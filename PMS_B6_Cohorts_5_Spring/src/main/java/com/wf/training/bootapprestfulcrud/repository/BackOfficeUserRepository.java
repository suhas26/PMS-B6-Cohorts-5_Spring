package com.wf.training.bootapprestfulcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapprestfulcrud.entity.BackOfficeUser;

@Repository
public interface BackOfficeUserRepository extends JpaRepository<BackOfficeUser, Integer>{

	BackOfficeUser findByLoginId(int id);
}
