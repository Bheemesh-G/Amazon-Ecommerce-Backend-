package com.Amazon.Amazon.Service;


import com.Amazon.Amazon.Entity.Item;
import com.Amazon.Amazon.Entity.Product;
import com.Amazon.Amazon.Repository.ItemRepository;
import com.Amazon.Amazon.Repository.ProductRepository;
import com.Amazon.Amazon.ResponseDtos.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ProductRepository productRepository;

    public ItemResponseDto viewItem(int productId) throws Exception {
        Product product;
        try{
            product = productRepository.findById(productId).get();
        }
        catch(Exception e)
        {
            throw new Exception("Invalid Product Id");
        }

        Item item = new Item();
        item.setProduct(product);
        item.setRequiredQuantity(0);
        product.setItem(item);

        productRepository.save(product);

        ItemResponseDto itemResponseDto = new ItemResponseDto();
        itemResponseDto.setProductId(product.getProductId());
        itemResponseDto.setPrice(product.getProductPrice());
        itemResponseDto.setProductCatagory(product.getCatagory());
        itemResponseDto.setProductStatus(product.getProductStatus());


        return itemResponseDto;
    }
}
