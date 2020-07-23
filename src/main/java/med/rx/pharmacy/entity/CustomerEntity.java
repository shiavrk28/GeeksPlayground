package med.rx.pharmacy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import med.rx.pharmacy.audit.Auditable;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name = "Customers")
public class CustomerEntity extends Auditable<Integer> {

	@Id
	@GeneratedValue
	private int id;
	@Column
	@NotNull
	private String name;
	@Column
	@NotNull
	private int age;
	@Column(name = "email_id")
	@NotNull
	private String emailId;
	@Column(name = "mobile_number")
	@NotNull
	private String mobileNumber;
	@Column
	@NotNull
	private String address;

}
