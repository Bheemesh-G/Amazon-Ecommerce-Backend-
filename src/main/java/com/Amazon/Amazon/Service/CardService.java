package com.Amazon.Amazon.Service;


import com.Amazon.Amazon.Entity.Card;
import com.Amazon.Amazon.Entity.Customer;
import com.Amazon.Amazon.Repository.CardRepository;
import com.Amazon.Amazon.Repository.CustomerRepository;
import com.Amazon.Amazon.RequestDtos.AddCardRequestDto;
import com.Amazon.Amazon.ResponseDtos.AddCardResponseDto;
import com.Amazon.Amazon.ResponseDtos.CardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    CustomerRepository customerRepository;
    public String addCard(AddCardRequestDto addCardRequestDto) throws Exception {
        Customer customer;
        // first check whether customer is present or not
        try{
            customer = customerRepository.findById(addCardRequestDto.getCustomerId()).get();
        }
        catch(Exception e)
        {
            throw new Exception("Invalid Customer Id");
        }

        //if present then set card
         Card card = new Card();
        card.setCardNo(addCardRequestDto.getCardNo());
        card.setCvv(addCardRequestDto.getCvv());
        card.setCardType(addCardRequestDto.getCardType());
        card.setCustomer(customer);

        customer.getCardList().add(card);

        customerRepository.save(customer);

      /*  //setting the ResponseDto
        AddCardResponseDto addCardResponseDto = new AddCardResponseDto();
        addCardResponseDto.setName(customer.getCustomerName());
        List<CardResponse> list = new ArrayList<>();
        List<Card> cardList = customer.getCardList();
        for(Card i:cardList)
        {
           CardResponse cardResponse = new CardResponse() ;
           cardResponse.setCardType(i.getCardType());
           cardResponse.setCardNo(i.getCardNo());
           list.add(cardResponse);
        }
        addCardResponseDto.setList(list);


        return addCardResponseDto;  */
return "Your Card has been added";
    }

    public AddCardResponseDto getAllCardsById(int customerId) throws Exception {
        Customer customer;
        // first check whether customer is present or not
        try{
            customer = customerRepository.findById(customerId).get();
        }
        catch(Exception e)
        {
            throw new Exception("Invalid Customer Id");
        }

        AddCardResponseDto addCardResponseDto = new AddCardResponseDto();
        addCardResponseDto.setName(customer.getCustomerName());
        List<CardResponse> list = new ArrayList<>();
        List<Card> cardList = customer.getCardList();
        for(Card i:cardList)
        {
            CardResponse cardResponse = new CardResponse() ;
            cardResponse.setCardType(i.getCardType());
            cardResponse.setCardNo(i.getCardNo());
            list.add(cardResponse);
        }
        addCardResponseDto.setList(list);


        return addCardResponseDto;
    }

    public String removeCard(int id)
    {
        cardRepository.deleteById(id);

        return "Card removed Successfully";
    }

   public String removeAllCards(int customerId)
   {
       cardRepository.removeById(customerId);

       return"All cards removed Successfully";
   }
}
