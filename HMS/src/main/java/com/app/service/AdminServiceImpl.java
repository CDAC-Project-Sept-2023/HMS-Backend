package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdminDao;
import com.app.dto.AdminDto;
import com.app.entities.Admin;
import com.app.entities.Doctor;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Admin addAdmin(Admin admin) {
		   
		return adminDao.save(admin);
	}

	
	@Override
	public void updateAdmin(AdminDto detachedAdmin, Long adminId) {
		Admin admin=adminDao.findById(adminId).orElseThrow();
		mapper.map(detachedAdmin, admin);
		
	}
	

}
