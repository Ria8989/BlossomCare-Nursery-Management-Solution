package com.spe.Service;

import com.spe.Entity.CurrentAdminSession;
import com.spe.Entity.LoginDTO;
import com.spe.Exception.LoginException;

public interface LoginAdminService {

	public CurrentAdminSession logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
}
