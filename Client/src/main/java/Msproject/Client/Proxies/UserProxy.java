package Msproject.Client.Proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Msproject.Client.Model.Auteur;

@FeignClient(name="User")
@RibbonClient(name= "User")
public interface UserProxy {
	
	@PostMapping(value="/login")
	public boolean login(@RequestBody User u);
	
	@PostMapping(value="/add")
	public void addUser(@RequestBody User u);

	public boolean existUsername(String username);
}
