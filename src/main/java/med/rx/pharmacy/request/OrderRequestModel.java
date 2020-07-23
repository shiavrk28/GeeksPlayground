package med.rx.pharmacy.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@AllArgsConstructor
public class OrderRequestModel {
	private int orderid;
	private int customerId;
	private String medicineName;
	private String quantity;
	private Double totalPrice;

}
