package com.naveen.project.ribbonclient.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="${AccountService.FeignName}")
@RibbonClient(name="${AccountService.FeignName}")
public interface AccountProxy {
	
	 @GetMapping("/accounts")
	 public String getAllAccounts();
	 
}
