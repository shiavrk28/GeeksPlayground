/**
 * 
 */
package med.rx.pharmacy.repository;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import med.rx.pharmacy.entity.OrderEntity;

/**
 * @author SHIVARAM KRISHNAN
 *
 */
@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity, Integer> {
	List<OrderEntity> findByCustomerId(int customerId);
	OrderEntity findById(int id);
}
