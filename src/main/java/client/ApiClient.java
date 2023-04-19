package client;

import org.springframework.web.service.annotation.GetExchange;
import model.ApiResponse;
public interface ApiClient {
	@GetExchange("/")
	ApiResponse random();
	
}
