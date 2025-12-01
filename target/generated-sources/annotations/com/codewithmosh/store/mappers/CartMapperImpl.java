package com.codewithmosh.store.mappers;

import com.codewithmosh.store.dtos.CartDto;
import com.codewithmosh.store.dtos.CartItemDto;
import com.codewithmosh.store.dtos.CartProductDto;
import com.codewithmosh.store.entities.Cart;
import com.codewithmosh.store.entities.CartItem;
import com.codewithmosh.store.entities.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-01T10:26:12+0330",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public CartDto toDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setId( cart.getId() );
        cartDto.setItems( cartItemSetToCartItemDtoList( cart.getItems() ) );

        cartDto.setTotalPrice( cart.getTotalPrice() );

        return cartDto;
    }

    @Override
    public CartItemDto toDto(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        CartItemDto cartItemDto = new CartItemDto();

        cartItemDto.setProduct( productToCartProductDto( cartItem.getProduct() ) );
        if ( cartItem.getQuantity() != null ) {
            cartItemDto.setQuantity( cartItem.getQuantity() );
        }

        cartItemDto.setTotalPrice( cartItem.getTotalPrice() );

        return cartItemDto;
    }

    protected List<CartItemDto> cartItemSetToCartItemDtoList(Set<CartItem> set) {
        if ( set == null ) {
            return null;
        }

        List<CartItemDto> list = new ArrayList<CartItemDto>( set.size() );
        for ( CartItem cartItem : set ) {
            list.add( toDto( cartItem ) );
        }

        return list;
    }

    protected CartProductDto productToCartProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        CartProductDto cartProductDto = new CartProductDto();

        cartProductDto.setId( product.getId() );
        cartProductDto.setName( product.getName() );
        cartProductDto.setPrice( product.getPrice() );

        return cartProductDto;
    }
}
