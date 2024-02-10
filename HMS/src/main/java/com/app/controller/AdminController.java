package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AdminDto;
import com.app.dto.DoctorDto;
import com.app.entities.Admin;
import com.app.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
		
	}
	
	@PutMapping("adminId/{adminId}")
	public void UpdatePatient(@PathVariable Long adminId,@RequestBody AdminDto detachedAdmin)
	{
		adminService.updateAdmin(detachedAdmin,adminId);
	}
}
