package com.spe.Service;

import com.spe.Exception.LoginException;
import com.spe.Entity.*;

public interface LoginService {
	
	public CurrentUserSession logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
