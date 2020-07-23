package med.rx.pharmacy.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import med.rx.pharmacy.dao.UserDAO;
import med.rx.pharmacy.entity.UserEntity;
import med.rx.pharmacy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;

	@Override
	public List<UserEntity> findByUsername(String userName) {
		return dao.findByUsername(userName);
	}

	@Override
	public int fetchUserId(String username) {
		return dao.fetchUserId(username);
	}

}
