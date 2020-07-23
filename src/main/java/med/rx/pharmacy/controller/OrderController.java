package med.rx.pharmacy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import med.rx.pharmacy.dto.OrderDTO;
import med.rx.pharmacy.request.OrderRequestModel;
import med.rx.pharmacy.response.OrderResponseModel;
import med.rx.pharmacy.service.OrderService;

@RestController
@PreAuthorize("hasRole('ROLE_ORDER')")
//@EnableGlobalMethodSecurity(prePostEnabled=true)
@RequestMapping("/RxPharma/order/manage")

public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/addOrder")
	@PostMapping
	public OrderResponseModel createOrder(@RequestBody OrderRequestModel orderDetails) {
		OrderResponseModel returnVal = new OrderResponseModel();
		OrderDTO orderDTO = new OrderDTO();
		BeanUtils.copyProperties(orderDetails, orderDTO);
		OrderDTO createdOrder = orderService.createOrder(orderDTO);
		BeanUtils.copyProperties(createdOrder, returnVal);
		return returnVal;
	}

	@RequestMapping(value = "/getOrder", produces = "application/json")
	@GetMapping
	public OrderResponseModel getOrder(@RequestParam("id") Integer id) {
		OrderResponseModel returnVal = new OrderResponseModel();
		OrderDTO fetchedOrder = orderService.getOrder(id);
		BeanUtils.copyProperties(fetchedOrder, returnVal);
		return returnVal;
	}

	@RequestMapping(value = "/getAll/{pageNum}", produces = "application/json")
	@GetMapping
	public List<OrderResponseModel> getAllOrders(@PathVariable("pageNum") Integer pageNum) {
		List<OrderResponseModel> returnList = new ArrayList<OrderResponseModel>();
		List<OrderDTO> fetchedOrders = orderService.findAllOrders(pageNum);
		for (int i = 0; i < fetchedOrders.size(); i++) {
			OrderResponseModel orderResp = new OrderResponseModel();
			BeanUtils.copyProperties(fetchedOrders.get(i), orderResp);
			returnList.add(orderResp);
		}
		return returnList;
	}
	
	@RequestMapping(value = "/getCustOrders", produces = "application/json")
	@GetMapping
	public List<OrderResponseModel> getOrdersByCustomer(@RequestParam("custid") Integer custid) {
		List<OrderResponseModel> returnList = new ArrayList<OrderResponseModel>();
		List<OrderDTO> fetchedOrders = orderService.findOrdersByCustomer(custid);
		for (int i = 0; i < fetchedOrders.size(); i++) {
			OrderResponseModel orderResp = new OrderResponseModel();
			BeanUtils.copyProperties(fetchedOrders.get(i), orderResp);
			returnList.add(orderResp);
		}
		return returnList;
	}

	@RequestMapping(value = "/editOrder")
	@PostMapping
	public OrderResponseModel editOrder(@RequestBody OrderRequestModel orderDetails) {
		OrderResponseModel returnVal = new OrderResponseModel();
		OrderDTO orderDto = new OrderDTO();
		BeanUtils.copyProperties(orderDetails, orderDto);
		OrderDTO createdOrder = orderService.editOrder(orderDto);
		BeanUtils.copyProperties(createdOrder, returnVal);
		return returnVal;
	}

	@RequestMapping(value = "/deleteOrder")
	@PostMapping
	public String deleteOrder(@RequestBody Integer orderId) {
		OrderResponseModel returnVal = new OrderResponseModel();
		OrderDTO deletedOrder = orderService.deleteOrder(orderId);
		BeanUtils.copyProperties(deletedOrder, returnVal);
		return "Order " + returnVal.toString() + " deleted";
	}

}
