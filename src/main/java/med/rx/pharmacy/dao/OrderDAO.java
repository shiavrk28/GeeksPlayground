package med.rx.pharmacy.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import med.rx.pharmacy.entity.OrderEntity;

public interface OrderDAO {
	public OrderEntity addOrder(OrderEntity order);
	public OrderEntity editOrder(OrderEntity order);
	public void deleteOrder(int id);
	public OrderEntity getOrder(int id);
	public List<OrderEntity> getCustOrders(int custId);
	public List<OrderEntity> getAllOrders(Pageable custPage);
}
