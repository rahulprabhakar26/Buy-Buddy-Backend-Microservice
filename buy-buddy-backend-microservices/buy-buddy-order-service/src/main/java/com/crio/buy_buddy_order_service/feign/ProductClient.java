
package com.crio.buy_buddy_order_service.feign;

import com.crio.buy_buddy_order_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "buy-buddy-product-service") // Name of the service in Eureka
public interface ProductClient {
    @GetMapping("api/products/{id}") // Endpoint in the Product service
    ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id);
}