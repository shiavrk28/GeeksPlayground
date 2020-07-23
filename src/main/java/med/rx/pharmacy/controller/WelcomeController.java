package med.rx.pharmacy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/RxPharma/welcome/")
/**This is necessary to generate a CSRF Token to be used with PostMan
 * in your PostMan Create this request and other requests in a PostMan environment 'Tests' tab paste the below line 
 * pm.environment.set("xsrf-token", decodeURIComponent(pm.cookies.get("XSRF-TOKEN")));
 * And all your requests for the particular session would be appended with XSRF-Token
 * @author SHIVARAM KRISHNAN
 *
 */
public class WelcomeController {
	
	
	@GetMapping
	public String welcome() {
		return "Welcome to RxPharmacy\nThis request is necessary to generate a CSRF Token per session to be used with PostMan\r\n" + 
				" *in your PostMan Create this request and other requests in a PostMan environment, Under the 'Tests' tab paste the below line \r\n" + 
				" pm.environment.set(\"xsrf-token\", decodeURIComponent(pm.cookies.get(\"XSRF-TOKEN\")));\r\n" + 
				" And all your subsequent requests for the particular session would be appended with XSRF-Token";
	}

}
