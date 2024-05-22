package com.spe.Service;

import com.spe.Entity.Admin;
import com.spe.Exception.AdminException;

public interface AdminService {

	public Admin addAdmin(Admin admin) throws AdminException;

}
