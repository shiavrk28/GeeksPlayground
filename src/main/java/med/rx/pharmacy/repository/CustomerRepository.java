package med.rx.pharmacy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import med.rx.pharmacy.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<CustomerEntity, Integer> {
	CustomerEntity findById(int id);
}
