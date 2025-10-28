// package com.crio.buy_buddy_order_service.service.implementation;

// import java.time.LocalDateTime;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.crio.buy_buddy_order_service.exception.ResourceNotFoundException;
// import com.crio.buy_buddy_order_service.model.Customer;
// import com.crio.buy_buddy_order_service.model.Product;
// import com.crio.buy_buddy_order_service.repository.CustomerRepository;
// import com.crio.buy_buddy_order_service.repository.OrderRepository;
// import com.crio.buy_buddy_order_service.repository.ProductRepository;
// import com.crio.buy_buddy_order_service.service.OrderService;
// import com.crio.buy_buddy_order_service.dto.OrderRequest;
// import com.crio.buy_buddy_order_service.model.Order;


// @Service
// public class OrderServiceImpl implements OrderService {

//     @Autowired
//     private OrderRepository orderRepository;
//     @Autowired
//     private CustomerRepository customerRepository;
//     @Autowired
//     private ProductRepository productRepository;

//     @Override
//     public List<Order> getAllOrders() {
//         return orderRepository.findAll();
//     }

//     @Override
//     public Order getOrderById(Long id) {
//         return orderRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
//     }

//     @Override
//     public Order createOrder(OrderRequest orderRequest) {
//         Customer customer = customerRepository.findById(orderRequest.getCustomerId())
//                 .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + orderRequest.getCustomerId()));
//         List<Product> products = productRepository.findAllById(orderRequest.getProductIds());
        
//         if (products.size() != orderRequest.getProductIds().size()) {
//             throw new ResourceNotFoundException("One or more products not found");
//         }

//         Order order = new Order();

//         order.setCustomer(customer);
//         order.setProducts(products);
//         order.setOrderDate(LocalDateTime.now());
//         return orderRepository.save(order);
//     }

//     @Override
//     public void deleteOrder(Long id) {
//         Order order = getOrderById(id);
//         orderRepository.delete(order);
//     }
// }


package com.crio.buy_buddy_order_service.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crio.buy_buddy_order_service.exception.ResourceNotFoundException;
import com.crio.buy_buddy_order_service.feign.CustomerClient;
import com.crio.buy_buddy_order_service.feign.ProductClient;
import com.crio.buy_buddy_order_service.repository.OrderRepository;
import com.crio.buy_buddy_order_service.service.OrderService;
import com.crio.buy_buddy_order_service.dto.CustomerDTO;
import com.crio.buy_buddy_order_service.dto.OrderRequest;
import com.crio.buy_buddy_order_service.dto.OrderResponse;
import com.crio.buy_buddy_order_service.dto.ProductDTO;
import com.crio.buy_buddy_order_service.model.Order;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private ProductClient productClient;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // @Override
    // public OrderResponse getOrderById(Long id) {
    //     Order order = orderRepository.findById(id)
    //             .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    //                     // Fetch customer details
    //     CustomerDTO customer = customerClient.getCustomerById(order.getCustomerId()).getBody();

    //             // Fetch product details for each product ID in the order
    //     List<ProductDTO> products = order.getProductIds().stream()
    //         .map(productId -> {
    //             ResponseEntity<ProductDTO> productResponse = productClient.getProductById(productId);
    //             return productResponse.getBody();
    //         })
    //         .collect(Collectors.toList());

    //         return new OrderResponse(order, customer, products);
    // }

    //     @Override
    // public OrderResponse getOrderById(Long id) {
    //     Order order = orderRepository.findById(id)
    //             .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    //     // Fetch customer details
    //     CustomerDTO customer = null;
    //     System.out.println("----------------------------------------------");
    //     try {
    //         customer = customerClient.getCustomerById(order.getCustomerId()).getBody();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     System.out.println(customer);
    //     // Fetch product details for each product ID in the order
    //     List<ProductDTO> products = order.getProductIds().stream()
    //             .map(productId -> {
    //                 ResponseEntity<ProductDTO> productResponse = productClient.getProductById(productId);
    //                 return productResponse.getBody();
    //             })
    //             .collect(Collectors.toList());

    //     return new OrderResponse(order, customer, products);
    // }


      @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        // CustomerDTO customer = customerRepository.findById(orderRequest.getCustomerId())
        //         .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + orderRequest.getCustomerId()));
        // List<Product> products = productRepository.findAllById(orderRequest.getProductIds());
        
        // if (products.size() != orderRequest.getProductIds().size()) {
        //     throw new ResourceNotFoundException("One or more products not found");
        // }

        Order order = new Order();

        order.setCustomerId(orderRequest.getCustomerId());
        order.setProductIds(orderRequest.getProductIds());
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        orderRepository.delete(order);
    }
}