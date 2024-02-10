package com.app.service;

import com.app.dto.AdminDto;
import com.app.entities.Admin;

public interface AdminService {

	Admin addAdmin(Admin admin);

	void updateAdmin(AdminDto detachedAdmin, Long adminId);

}
