package med.rx.pharmacy.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;

import med.rx.pharmacy.PharmacyApplication;
import med.rx.pharmacy.controller.OrderController;
import med.rx.pharmacy.entity.OrderEntity;
import med.rx.pharmacy.request.OrderRequestModel;
import med.rx.pharmacy.response.OrderResponseModel;

@SpringBootTest(classes = PharmacyApplication.class)
@Transactional
public class GenericServiceTest {

	@Autowired
	private CustomerService cserv;

	@Autowired
	private OrderService oserv;

	@Autowired
	private OrderController oc;

	@Test
	@WithMockUser(username = "cmp_rep", authorities = { "ROLE_CUSTOMER" })
	public void getCustomer() {
		final int custId = 12;
		assertThat(cserv.findCustomer(custId)).isNotNull();
	}

	@Test
	@WithMockUser(username = "cmp_rep", authorities = { "ROLE_CUSTOMER" })
	public void wrongRoles() {
		try {
			Assertions.assertThrows(AccessDeniedException.class, () -> oc.getOrder(12));
		} catch (Exception ex) {
			System.out.println("Access Denied");
		}
	}
	
	@Test
	@WithMockUser(username = "sales_man", authorities = { "ROLE_CUSTOMER","ROLE_ORDER" })
	public void addOrders() {
		OrderEntity oent=new OrderEntity();
		int oid=oent.getId();
		OrderRequestModel orsp=new OrderRequestModel(0,20, "Oral-B", "12",334.22d);
		BeanUtils.copyProperties(orsp, oent);
		oent.setId(oid);
		assertThat(oc.createOrder(orsp)).isNotNull();
	}

}
