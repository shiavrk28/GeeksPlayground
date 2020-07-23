/**
 * 
 */
package med.rx.pharmacy.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author SHIVARAM KRISHNAN
 *
 */
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = -3512171641862653027L;
	private int id;
	private int custid;
	private String name;
	private int age;
	private String emailId;
	private String mobileNumber;
	private String address;
	private int createdBy;
	private Date createdTime;
	private int updatedBy;
	private Date updatedTime;

}
