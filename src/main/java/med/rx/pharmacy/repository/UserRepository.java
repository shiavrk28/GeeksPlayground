/**
 * 
 */
package med.rx.pharmacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import med.rx.pharmacy.entity.UserEntity;

/**
 * @author SHIVARAM KRISHNAN
 *
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	//@Query("select u from UserEntity u where u.username like %?1")
	List<UserEntity> findByUsername(String username);
	
	@Query("select u.id from UserEntity u where u.username = ?1")
	int fetchUserId(String username);
}
