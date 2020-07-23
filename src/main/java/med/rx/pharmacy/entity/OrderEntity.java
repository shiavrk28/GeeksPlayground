package med.rx.pharmacy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import med.rx.pharmacy.audit.Auditable;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name="Orders")
public class OrderEntity extends Auditable<Integer> {
	
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	@Column(name="customer_id")
	private int customerId;
	@NotNull
	@Column(name="medicine_name")
	private String medicineName;
	@Column
	@NotNull
	private String quantity;
	@Column(name="total_price")
	@NotNull
	private Double totalPrice;
	

}
