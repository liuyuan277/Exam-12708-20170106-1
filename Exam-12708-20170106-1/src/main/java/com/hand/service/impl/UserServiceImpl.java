package com.hand.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.dto.Customer;
import com.hand.mapper.UserMapper;
import com.hand.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Boolean selectUserById(Customer c) {
		Customer cu=userMapper.selectUserById(c);
		System.out.println(cu.getFirst_name());
		if (cu!=null) {
			return true;
		}
		return false;
	}

}
