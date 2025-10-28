
package com.crio.buy_buddy_order_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.crio.buy_buddy_order_service.dto.CustomerDTO;

@FeignClient(name = "buy-buddy-customer-service") // Name of the service in Eureka
public interface CustomerClient {
    @GetMapping("api/customers/{id}") // Endpoint in the Customer service
    ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Long id);
}