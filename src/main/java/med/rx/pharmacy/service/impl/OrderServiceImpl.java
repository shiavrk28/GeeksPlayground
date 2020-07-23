package med.rx.pharmacy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import med.rx.pharmacy.dao.OrderDAO;
import med.rx.pharmacy.dto.OrderDTO;
import med.rx.pharmacy.entity.OrderEntity;
import med.rx.pharmacy.service.OrderService;
import med.rx.utils.RxPharmacyConstants;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDAO;

	@Override
	public OrderDTO createOrder(OrderDTO order) {
		OrderEntity orderEntity = new OrderEntity();
		BeanUtils.copyProperties(order, orderEntity);
		OrderEntity storedOrderEntity = orderDAO.addOrder(orderEntity);
		OrderDTO returnval = new OrderDTO();
		BeanUtils.copyProperties(storedOrderEntity, returnval);
		return returnval;
	}

	@Override
	public OrderDTO editOrder(OrderDTO order) {
		OrderEntity orderEntity = orderDAO.getOrder(order.getOrderid());
		order.setId(order.getOrderid());
		BeanUtils.copyProperties(order, orderEntity);
		OrderEntity storedOrderEntity = orderDAO.editOrder(orderEntity);
		OrderDTO returnval = new OrderDTO();
		BeanUtils.copyProperties(storedOrderEntity, returnval);
		return returnval;
	}

	@Override
	public OrderDTO deleteOrder(Integer orderID) {
		OrderEntity orderEntity = orderDAO.getOrder(orderID);
		orderDAO.deleteOrder(orderID);
		OrderDTO returnval = new OrderDTO();
		BeanUtils.copyProperties(orderEntity, returnval);
		return returnval;
	}

	@Override
	public OrderDTO getOrder(int id) {
		OrderDTO returnval = new OrderDTO();
		BeanUtils.copyProperties(orderDAO.getOrder(id), returnval);
		return returnval;
	}

	@Override
	public List<OrderDTO> findAllOrders(int pageNum) {
		Pageable orderPage = PageRequest.of(pageNum, RxPharmacyConstants.ORDER_PAGE_SIZE);
		List<OrderEntity> pageRes = orderDAO.getAllOrders(orderPage);
		List<OrderDTO> retList = new ArrayList<OrderDTO>();
		for (int i = 0; i < pageRes.size(); i++) {
			OrderDTO orderDTO = new OrderDTO();
			BeanUtils.copyProperties(pageRes.get(i), orderDTO);
			retList.add(orderDTO);
		}
		// pageRes.stream().forEach(e->BeanUtils.copyProperties(e, new
		// CustomerDTO());retList.add(e));
		return retList;
	}

	@Override
	public List<OrderDTO> findOrdersByCustomer(int custId) {
		List<OrderEntity> custOrders = orderDAO.getCustOrders(custId);
		List<OrderDTO> retList = new ArrayList<OrderDTO>();
		for (int i = 0; i < custOrders.size(); i++) {
			OrderDTO orderDTO = new OrderDTO();
			BeanUtils.copyProperties(custOrders.get(i), orderDTO);
			retList.add(orderDTO);
		}
		// pageRes.stream().forEach(e->BeanUtils.copyProperties(e, new
		// CustomerDTO());retList.add(e));
		return retList;
	}

}
