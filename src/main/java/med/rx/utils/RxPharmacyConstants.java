/**
 * 
 */
package med.rx.utils;

import org.springframework.stereotype.Component;

/**
 * @author SHIVARAM KRISHNAN
 *
 */
@Component
public class RxPharmacyConstants {
	public static final String AUTH_USERNAME_QUERY="select username,CONCAT('{noop}',password),true from users where username=?";
	public static final String AUTH_AUTHORITIES_QUERY="select username,role from users where username=?";
	public static final String ROLE_CUSTOMER="CUSTOMER";
	public static final String ROLE_ORDER="ORDER";
	public static final String AUTH_ALL_MATCHER="**/welcome/**";
	public static final String AUTH_CUSTOMER_MATCHER="**/customer/**";
	public static final String AUTH_ORDER_MATCHER="**/order/**";
	public static final Integer CUST_PAGE_SIZE=10;
	public static final Integer ORDER_PAGE_SIZE=10;
	
//	public RxPharmacyConstants() {}

}
