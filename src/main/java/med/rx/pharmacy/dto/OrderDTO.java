package med.rx.pharmacy.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
public class OrderDTO implements Serializable {
	private static final long serialVersionUID = -3512171641862653527L;

	private int id;
	private int orderid;
	private int customerId;
	private String medicineName;
	private String quantity;
	private Double totalPrice;
	private int createdBy;
	private Date createdTime;
	private int updatedBy;
	private Date updatedTime;
}
