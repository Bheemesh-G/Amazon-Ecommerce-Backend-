package com.Amazon.Amazon.Controller;


import com.Amazon.Amazon.RequestDtos.AddCardRequestDto;
import com.Amazon.Amazon.ResponseDtos.AddCardResponseDto;
import com.Amazon.Amazon.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;


    @PostMapping("/add-card")
    public ResponseEntity addCard(@RequestBody AddCardRequestDto addCardRequestDto)
    {
        String ans;
        try{
          ans =  cardService.addCard(addCardRequestDto);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(ans,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all-cards/{id}")
    public ResponseEntity getAllCardsById(@PathVariable int id) {
        AddCardResponseDto addCardResponseDto = null;
        try {
            addCardResponseDto = cardService.getAllCardsById(id);
        } catch (Exception e) {

            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity(addCardResponseDto,HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete-card-by-id/{id}")
    public String removeCard(@PathVariable int id){

        return cardService.removeCard(id);
    }


    @DeleteMapping("/delete-all-cards-by-id/{customerId}")
    public String removeAllCards(@PathVariable int customerId){

        return cardService.removeAllCards(customerId);

    }



}
