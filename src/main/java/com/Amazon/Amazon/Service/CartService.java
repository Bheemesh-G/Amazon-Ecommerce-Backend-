package com.Amazon.Amazon.Service;


import com.Amazon.Amazon.Entity.*;
import com.Amazon.Amazon.Enum.ProductStatus;
import com.Amazon.Amazon.Repository.CustomerRepository;
import com.Amazon.Amazon.Repository.ProductRepository;
import com.Amazon.Amazon.RequestDtos.OrderRequestDto;
import com.Amazon.Amazon.ResponseDtos.OrderedResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {


    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;


    @Autowired
    OrderedService orderService;


    public String addToCart(OrderRequestDto orderRequestDto) throws Exception {

        Customer customer;
        try{
            customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        }
        catch(Exception e){
            throw new Exception("Invalid Customer id !!!");
        }

        Product product;
        try{
            product = productRepository.findById(orderRequestDto.getProductId()).get();
        }
        catch (Exception e){
            throw new Exception("Invalid Product Id");
        }

        if(product.getProductQuantity()<orderRequestDto.getRequiredQuantity()){
            throw new Exception("Sorry! Required quantity not available");
        }

        Cart cart = customer.getCart();

        int newCost = cart.getCardTotal() + orderRequestDto.getRequiredQuantity()*product.getProductPrice();
        cart.setCardTotal(newCost);

        // Add item to current cart
        Item item = new Item();
        item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
        item.setCart(cart);
        item.setProduct(product);
        cart.getItemList().add(item);

        customerRepository.save(customer);

        return "Item has been added to your Cart!!";
    }

    public List<OrderedResponseDto> checkout(int customerId) throws Exception {

        Customer customer;
        try{
            customer = customerRepository.findById(customerId).get();
        }
        catch(Exception e){
            throw new Exception("Invalid Customer id !!!");
        }

        List<OrderedResponseDto> orderResponseDtos = new ArrayList<>();
        int totalCost = customer.getCart().getCardTotal();
        Cart cart = customer.getCart();
        for(Item item: cart.getItemList()){
            Ordered order = new Ordered();
            order.setTotalCost(item.getRequiredQuantity()*item.getProduct().getProductPrice());
            order.setDeliveryCharge(0);
            order.setCustomer(customer);
            order.getItemList().add(item);

            Card card = customer.getCardList().get(0);
            String cardNo = "";
            for(int i=0;i<card.getCardNo().length()-4;i++)
                cardNo += 'X';
            cardNo += card.getCardNo().substring(card.getCardNo().length()-4);
            order.setCardUsedForPayment(cardNo);

            int leftQuantity = item.getProduct().getProductQuantity()-item.getRequiredQuantity();
            if(leftQuantity<=0)
                item.getProduct().setProductStatus(ProductStatus.NOTAVAILABLE);
            item.getProduct().setProductQuantity(leftQuantity);

            customer.getOrderedList().add(order);

            // prepare response dto
            OrderedResponseDto orderResponseDto = OrderedResponseDto.builder()
                    .productName(item.getProduct().getProductName())
                    .orderedDate(order.getDate())
                    .quantityOrdered(item.getRequiredQuantity())
                    .cardUsedForPayment(cardNo)
                    .itemPrice(item.getProduct().getProductPrice())
                    .totalCost(order.getTotalCost())
                    .deliveryCharge(0)
                    .build();

            orderResponseDtos.add(orderResponseDto);
        }

        cart.setItemList(new ArrayList<>());
        cart.setCardTotal(0);
        customerRepository.save(customer);


        return orderResponseDtos;
    }


}
