package med.rx.pharmacy.service;

import java.util.List;

import med.rx.pharmacy.entity.UserEntity;

public interface UserService {
	public List<UserEntity> findByUsername(String userName);

	public int fetchUserId(String username);
}
