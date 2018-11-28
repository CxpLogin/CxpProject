package cxp.graduate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cxp.graduate.mapper.EmailMapper;
import cxp.graduate.pojo.Email;
import cxp.graduate.service.EmailService;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailMapper emailMapper;

	@Override
	public Email findEmailName(String name) {
		// TODO Auto-generated method stub
		return emailMapper.findEmailByName(name);
	}

	@Override
	public void insertEamil(Email email) {
		// TODO Auto-generated method stub
		emailMapper.insertEmail(email);
	}

	@Override
	public String findEmailCode(String emailName) {
		// TODO Auto-generated method stub
		return emailMapper.findEmailCode(emailName);
	}

	@Override
	public void updateEmailState(String emailName) {
		// TODO Auto-generated method stub
		emailMapper.updateEmailState(emailName);
	}

	@Override
	public void updateEmailUid(int id,String emailName) {
		// TODO Auto-generated method stub
		emailMapper.updateEmailUid(id, emailName);
	}
	
	
}
