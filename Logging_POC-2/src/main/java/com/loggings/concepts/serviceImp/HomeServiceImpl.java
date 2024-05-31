package com.loggings.concepts.serviceImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.loggings.concepts.serviceI.HomeServiceInterfaces;

@Service
public class HomeServiceImpl implements HomeServiceInterfaces{

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeServiceImpl.class);
	
	@Override
	public void loginAuth(String username, String password) {
		
		LOGGER.error("User Not Found");
		LOGGER.warn("Password To Weak");
		LOGGER.info("UserName : "+ username + "Password : " + password);
		LOGGER.debug("In Login authentication ");
	}

}
