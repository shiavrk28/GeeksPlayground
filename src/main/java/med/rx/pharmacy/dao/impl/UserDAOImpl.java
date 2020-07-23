package med.rx.pharmacy.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.rx.pharmacy.dao.UserDAO;
import med.rx.pharmacy.entity.UserEntity;
import med.rx.pharmacy.repository.UserRepository;

@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	UserRepository repository;

	@Override
	public List<UserEntity> findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public Integer fetchUserId(String username) {
		return repository.fetchUserId(username);
	}

}
