package jjon.gangsan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/views")
	public String test() {
		return "MainPage";
	}
}
