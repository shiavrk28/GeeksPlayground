package med.rx.pharmacy.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import med.rx.pharmacy.dao.CustomerDAO;
import med.rx.pharmacy.entity.CustomerEntity;
import med.rx.pharmacy.repository.CustomerRepository;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	CustomerRepository repository;

	@Override
	public CustomerEntity addCustomer(CustomerEntity customer) {
		if (repository.findById(customer.getId()) != null)
			throw new RuntimeException("Customer Already Exists");
		return repository.save(customer);
	}

	@Override
	public CustomerEntity editCustomer(CustomerEntity customer) {
		if (repository.findById(customer.getId()) == null)
			throw new RuntimeException("Customer Does Not Exists");
		return repository.save(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		if (repository.findById(id) == null)
			throw new RuntimeException("Customer Does Not Exists");
		repository.delete(repository.findById(id));
	}

	@Override
	public CustomerEntity getCustomer(int id) {
		CustomerEntity cust = repository.findById(id);
		if (cust == null)
			throw new RuntimeException("Customer does not exists");
		return cust;
	}

	@Override
	public List<CustomerEntity> getAllCustomers(Pageable custPage) {
		Page<CustomerEntity> pagedCustomerList = repository.findAll(custPage);
		return pagedCustomerList.toList();
	}

}
