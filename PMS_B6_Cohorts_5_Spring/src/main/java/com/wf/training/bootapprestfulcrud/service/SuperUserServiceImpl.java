package com.wf.training.bootapprestfulcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapprestfulcrud.dto.BackofficeInputDto;
import com.wf.training.bootapprestfulcrud.dto.BackofficeOutputDto;
import com.wf.training.bootapprestfulcrud.entity.BackOfficeUser;
import com.wf.training.bootapprestfulcrud.entity.SuperUser;
import com.wf.training.bootapprestfulcrud.repository.BackOfficeUserRepository;
import com.wf.training.bootapprestfulcrud.repository.SuperUserRepository;

@Service
public class SuperUserServiceImpl implements SuperUserService {

	@Autowired
	private SuperUserRepository repo;
	
	@Autowired
	private BackOfficeUserRepository borepo;
	
	
	public SuperUser get(Integer id) {
		return repo.findById(id).get();
	}
	
	@Override
	public boolean addBackOfficeUser(BackofficeInputDto user) {
		BackOfficeUser buser=new BackOfficeUser();
		buser.setEmailId(user.getEmailId());
		buser.setFirstName(user.getFirstName());
		buser.setLastName(user.getLastName());
		buser.setPassword(user.getPassword());
		this.borepo.save(buser);
		user.setLoginId(buser.getLoginId());
		
		return true;
	}
	
}
