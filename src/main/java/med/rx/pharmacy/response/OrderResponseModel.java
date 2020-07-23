package med.rx.pharmacy.response;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderResponseModel {
	@NotNull
	private int id;
	@NotNull
	private int customerId;
	@NotNull
	private String medicineName;
	private String quantity;
	private Double totalPrice;
}
