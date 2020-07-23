package med.rx.pharmacy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name="Users")
public class UserEntity {
	
	@Id
	private int id;
	@Column(nullable=false)
	private String username;
	@Column(name="email_id",nullable=false)
	private String emailId;
	@Column(nullable=false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="ENUM('ROLE_ORDER','ROLE_CUSTOMER')")
	private Role role;
	
}
