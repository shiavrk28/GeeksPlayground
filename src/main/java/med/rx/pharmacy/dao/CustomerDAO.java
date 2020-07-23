package med.rx.pharmacy.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import med.rx.pharmacy.entity.CustomerEntity;

public interface CustomerDAO {
	public CustomerEntity addCustomer(CustomerEntity customer);

	public CustomerEntity editCustomer(CustomerEntity customer);

	public void deleteCustomer(int id);

	public CustomerEntity getCustomer(int id);

	public List<CustomerEntity> getAllCustomers(Pageable custPage);
}
