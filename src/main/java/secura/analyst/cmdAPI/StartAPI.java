package secura.analyst.cmdAPI;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import client.ApiClient;
import model.ApiResponse;

@ShellComponent
public class StartAPI {
	
	private final ApiClient apiClientObj;
	
	public StartAPI(ApiClient apiClientObj){
		this.apiClientObj = apiClientObj;
	}
	
	@ShellMethod(key = "random", value = "random joke!")
	public String getRandResponse(){
		ApiResponse random = apiClientObj.random();
		return random.joke();
	}
}
