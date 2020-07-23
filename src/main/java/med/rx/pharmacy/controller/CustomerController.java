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

import med.rx.pharmacy.dto.CustomerDTO;
import med.rx.pharmacy.request.CustomerRequestModel;
import med.rx.pharmacy.response.CustomerResponseModel;
import med.rx.pharmacy.service.CustomerService;

@RestController

@PreAuthorize("hasAnyRole('ROLE_CUSTOMER','ROLE_ORDER')")
@RequestMapping("/RxPharma/customer/manage")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/addCustomer")
	@PostMapping
	public CustomerResponseModel createCustomer(@RequestBody CustomerRequestModel custDetails) {
		CustomerResponseModel returnVal = new CustomerResponseModel();
		CustomerDTO custDto = new CustomerDTO();
		BeanUtils.copyProperties(custDetails, custDto);
		CustomerDTO createdCustomer = customerService.createCustomer(custDto);
		BeanUtils.copyProperties(createdCustomer, returnVal);
		return returnVal;
	}

	@RequestMapping(value = "/getCustomer", produces = "application/json")
	@GetMapping
	public CustomerResponseModel getCustomer(@RequestParam("id") Integer id) {
		CustomerResponseModel returnVal = new CustomerResponseModel();
		CustomerDTO fetchedCustomer = customerService.findCustomer(id);
		BeanUtils.copyProperties(fetchedCustomer, returnVal);
		return returnVal;
	}

	@RequestMapping(value = "/getAll/{pageNum}", produces = "application/json")
	@GetMapping
	public List<CustomerResponseModel> getAllCustomers(@PathVariable("pageNum") Integer pageNum) {
		List<CustomerResponseModel> returnList = new ArrayList<CustomerResponseModel>();
		List<CustomerDTO> fetchedCustomers = customerService.findAllCustomers(pageNum);
		for (int i = 0; i < fetchedCustomers.size(); i++) {
			CustomerResponseModel custResp = new CustomerResponseModel();
			BeanUtils.copyProperties(fetchedCustomers.get(i), custResp);
			returnList.add(custResp);
		}
		return returnList;
	}

	@RequestMapping(value = "/editCustomer")
	@PostMapping
	public CustomerResponseModel editCustomer(@RequestBody CustomerRequestModel custDetails) {
		CustomerResponseModel returnVal = new CustomerResponseModel();
		CustomerDTO custDto = new CustomerDTO();
		BeanUtils.copyProperties(custDetails, custDto);
		CustomerDTO createdCustomer = customerService.editCustomer(custDto);
		BeanUtils.copyProperties(createdCustomer, returnVal);
		return returnVal;
	}

	@RequestMapping(value = "/deleteCustomer")
	@PostMapping
	public String deleteCustomer(@RequestBody Integer custId) {
		CustomerResponseModel returnVal = new CustomerResponseModel();
		CustomerDTO deletedCustomer = customerService.deleteCustomer(custId);
		BeanUtils.copyProperties(deletedCustomer, returnVal);
		return "Customer " + returnVal.toString() + " deleted";
	}

}
