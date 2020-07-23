package med.rx.pharmacy.service;

import java.util.List;

import med.rx.pharmacy.dto.OrderDTO;

public interface OrderService {
	public OrderDTO createOrder(OrderDTO order);

	public OrderDTO editOrder(OrderDTO order);

	public OrderDTO deleteOrder(Integer orderID);

	public OrderDTO getOrder(int id);

	public List<OrderDTO> findAllOrders(int pageNum);

	public List<OrderDTO> findOrdersByCustomer(int cust_id);
}
