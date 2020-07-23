package med.rx.pharmacy.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@AllArgsConstructor
public class CustomerRequestModel {
	private Integer custid;
	private String name;
	private Integer age;
	private String emailId;
	private String mobileNumber;
	private String address;
	
}
