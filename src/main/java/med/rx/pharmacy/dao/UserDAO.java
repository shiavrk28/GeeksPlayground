package med.rx.pharmacy.dao;

import java.util.List;

import med.rx.pharmacy.entity.UserEntity;

public interface UserDAO {
	public List<UserEntity> findByUsername(String username);
	public Integer fetchUserId(String username);
}
