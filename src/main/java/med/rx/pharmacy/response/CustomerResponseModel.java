package med.rx.pharmacy.response;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import med.rx.pharmacy.audit.Auditable;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerResponseModel extends Auditable<Integer> {
	@NotNull
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String emailId;
	private Integer age;
	private String mobileNumber;
	private String address;
}
