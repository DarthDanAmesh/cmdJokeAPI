package secura.analyst.cmdAPI;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import client.ApiClient;

@SpringBootApplication
public class CmdApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CmdApiApplication.class);
				app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
				app.run(args);
	}
	@Component
	public class ServerPortCustomizer
	implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{

		@Override
		public void customize(ConfigurableWebServerFactory factory) {
			factory.setPort(8086);
		}
		
	}
	
	@Bean
	ApiClient apiClientObj() {
		WebClient webClientObj = WebClient.builder()
				.baseUrl("https://icanhazdadjoke.com")
				.defaultHeader("Accept", "application/json")
				.build();
		HttpServiceProxyFactory factoryObj = HttpServiceProxyFactory.builder(
				WebClientAdapter.forClient(webClientObj)).build();
				return factoryObj.createClient(ApiClient.class);
	}
}

