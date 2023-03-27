package com.Amazon.Amazon.Service;


import com.Amazon.Amazon.Entity.*;
import com.Amazon.Amazon.Enum.ProductStatus;
import com.Amazon.Amazon.Repository.CustomerRepository;
import com.Amazon.Amazon.Repository.OrderedRepository;
import com.Amazon.Amazon.Repository.ProductRepository;
import com.Amazon.Amazon.RequestDtos.OrderRequestDto;
import com.Amazon.Amazon.ResponseDtos.OrderedResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedService {


    @Autowired
    OrderedRepository orderedRepository;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

    public OrderedResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception {
        //check for customer is available or not
        Customer customer;
        try{
            customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        }
        catch(Exception e)
        {
         throw new Exception("Invalid Customer Id");
        }
        Product product;
        try{
            product = productRepository.findById(orderRequestDto.getProductId()).get();
        }
        catch(Exception e)
        {
            throw new Exception("Invalid Product Id");
        }

            if(orderRequestDto.getRequiredQuantity()>product.getProductQuantity())
            {
                throw new Exception("Your quantity is more then the available quantity");
            }

            Ordered ordered = new Ordered();
          //  int totalcost = product.getProductPrice()* orderRequestDto.getProductId();
            ordered.setTotalCost(orderRequestDto.getRequiredQuantity()* product.getProductPrice());
            ordered.setDeliveryCharge(30);
        Card card = customer.getCardList().get(0);
        String cardNo = "";
        for(int i=0;i<card.getCardNo().length()-4;i++)
            cardNo += 'X';
        cardNo += card.getCardNo().substring(card.getCardNo().length()-4);
        ordered.setCardUsedForPayment(cardNo);

        Item item = new Item();
        item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
        item.setProduct(product);
        item.setOrder(ordered);
        ordered.getItemList().add(item);
        ordered.setCustomer(customer);

        int leftQuantity = product.getProductQuantity()-orderRequestDto.getRequiredQuantity();
        if(leftQuantity<=0) {
            product.setProductStatus(ProductStatus.NOTAVAILABLE);
        }
        product.setProductQuantity(leftQuantity);

        customer.getOrderedList().add(ordered);
        Customer savedCustomer = customerRepository.save(customer);
        Ordered savedOrder = savedCustomer.getOrderedList().get(savedCustomer.getOrderedList().size()-1);

        OrderedResponseDto orderResponseDto = OrderedResponseDto.builder()
                .productName(product.getProductName())
                .orderedDate(savedOrder.getDate())
                .quantityOrdered(orderRequestDto.getRequiredQuantity())
                .cardUsedForPayment(cardNo)
                .itemPrice(product.getProductPrice())
                .totalCost(ordered.getTotalCost())
                .deliveryCharge(40)
                .build();


        return orderResponseDto;



    }







}
