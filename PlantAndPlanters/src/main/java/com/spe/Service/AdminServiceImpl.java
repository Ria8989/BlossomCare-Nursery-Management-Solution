package com.spe.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spe.Entity.Admin;
import com.spe.Exception.AdminException;
import com.spe.Repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin addAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		
		Admin currentAdmin = adminRepository.findByUserName(admin.getUserName());
		
		if(currentAdmin != null) throw new AdminException("Admin already exists");
		
		return adminRepository.save(admin);
	}

	

	

}
