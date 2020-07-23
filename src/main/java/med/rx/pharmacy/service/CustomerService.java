package med.rx.pharmacy.service;

import java.util.List;

import med.rx.pharmacy.dto.CustomerDTO;

public interface CustomerService {

	public CustomerDTO createCustomer(CustomerDTO customer);

	public CustomerDTO editCustomer(CustomerDTO customer);

	public CustomerDTO deleteCustomer(Integer custId);

	public CustomerDTO findCustomer(int id);

	public List<CustomerDTO> findAllCustomers(int pageNum);

}
