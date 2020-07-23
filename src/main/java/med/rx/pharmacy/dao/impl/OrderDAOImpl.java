/**
 * 
 */
package med.rx.pharmacy.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import med.rx.pharmacy.dao.OrderDAO;
import med.rx.pharmacy.entity.OrderEntity;
import med.rx.pharmacy.repository.OrderRepository;

/**
 * @author SHIVARAM KRISHNAN
 *
 */
@Component
public class OrderDAOImpl implements OrderDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * med.rx.pharmacy.dao.OrderDAO#addOrder(med.rx.pharmacy.entity.OrderEntity)
	 */

	@Autowired
	OrderRepository repository;

	@Override
	public OrderEntity addOrder(OrderEntity order) {
		if (repository.findById(order.getId()) != null)
			throw new RuntimeException("Order Already Exists");
		return repository.save(order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * med.rx.pharmacy.dao.OrderDAO#editOrder(med.rx.pharmacy.entity.OrderEntity)
	 */
	@Override
	public OrderEntity editOrder(OrderEntity order) {
		if (repository.findById(order.getId()) == null)
			throw new RuntimeException("Order Does Not Exists");
		return repository.save(order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see med.rx.pharmacy.dao.OrderDAO#deleteOrder(int)
	 */
	@Override
	public void deleteOrder(int id) {
		if (repository.findById(id) == null)
			throw new RuntimeException("Order Does Not Exists");
		repository.delete(repository.findById(id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see med.rx.pharmacy.dao.OrderDAO#getOrder(int)
	 */
	@Override
	public OrderEntity getOrder(int id) {
		OrderEntity cust = repository.findById(id);
		if (cust == null)
			throw new RuntimeException("Order does not exists");
		return cust;
	}

	@Override
	public List<OrderEntity> getCustOrders(int custId) {
		List<OrderEntity> custOrders = repository.findByCustomerId(custId);
		return custOrders;
	}

	@Override
	public List<OrderEntity> getAllOrders(Pageable custPage) {
		Page<OrderEntity> pagedCustomerList = repository.findAll(custPage);
		return pagedCustomerList.toList();
	}

}
