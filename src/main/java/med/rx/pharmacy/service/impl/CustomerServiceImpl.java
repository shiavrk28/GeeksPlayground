package med.rx.pharmacy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import med.rx.pharmacy.dao.CustomerDAO;
import med.rx.pharmacy.dao.OrderDAO;
import med.rx.pharmacy.dto.CustomerDTO;
import med.rx.pharmacy.entity.CustomerEntity;
import med.rx.pharmacy.entity.OrderEntity;
import med.rx.pharmacy.service.CustomerService;
import med.rx.utils.RxPharmacyConstants;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	public CustomerDAO custDAO;
	
	@Autowired
	public OrderDAO orderDAO;

	@Override
	public CustomerDTO createCustomer(CustomerDTO customer) {
		CustomerEntity custEntity = new CustomerEntity();
		BeanUtils.copyProperties(customer, custEntity);
		CustomerEntity storedCustomerEntity = custDAO.addCustomer(custEntity);
		CustomerDTO returnval = new CustomerDTO();
		BeanUtils.copyProperties(storedCustomerEntity, returnval);
		return returnval;
	}

	@Override
	public CustomerDTO findCustomer(int id) {
		CustomerDTO returnval = new CustomerDTO();
		BeanUtils.copyProperties(custDAO.getCustomer(id), returnval);
		return returnval;
	}

	@Override
	public CustomerDTO editCustomer(CustomerDTO customer) {
		CustomerEntity custEntity = custDAO.getCustomer(customer.getCustid());
		customer.setId(customer.getCustid());
		BeanUtils.copyProperties(customer, custEntity);
		CustomerEntity storedCustomerEntity = custDAO.editCustomer(custEntity);
		CustomerDTO returnval = new CustomerDTO();
		BeanUtils.copyProperties(storedCustomerEntity, returnval);
		return returnval;
	}

	@Override
	public CustomerDTO deleteCustomer(Integer custId) {
		CustomerEntity custEntity = custDAO.getCustomer(custId);
		try {
			for(OrderEntity referencedOrder : orderDAO.getCustOrders(custId)) {
				orderDAO.deleteOrder(referencedOrder.getId());
			}
		}
		catch(Exception ex) {ex.printStackTrace();}
		custDAO.deleteCustomer(custId);
		CustomerDTO returnval = new CustomerDTO();
		BeanUtils.copyProperties(custEntity, returnval);
		return returnval;
	}

	@Override
	public List<CustomerDTO> findAllCustomers(int pageNum) {
		Pageable custPage = PageRequest.of(pageNum, RxPharmacyConstants.CUST_PAGE_SIZE);
		List<CustomerEntity> pageRes = custDAO.getAllCustomers(custPage);
		List<CustomerDTO> retList = new ArrayList<CustomerDTO>();
		for (int i = 0; i < pageRes.size(); i++) {
			CustomerDTO custDTO = new CustomerDTO();
			BeanUtils.copyProperties(pageRes.get(i), custDTO);
			retList.add(custDTO);
		}
		// pageRes.stream().forEach(e->BeanUtils.copyProperties(e, new
		// CustomerDTO());retList.add(e));
		return retList;
	}
}
