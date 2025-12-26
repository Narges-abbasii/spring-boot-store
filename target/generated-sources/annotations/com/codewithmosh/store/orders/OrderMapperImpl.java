package com.codewithmosh.store.orders;

import com.codewithmosh.store.products.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-26T21:48:10+0330",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( order.getId() );
        if ( order.getStatus() != null ) {
            orderDto.setStatus( order.getStatus().name() );
        }
        orderDto.setCreatedAt( order.getCreatedAt() );
        orderDto.setItems( orderItemSetToOrderItemDtoList( order.getItems() ) );
        orderDto.setTotalPrice( order.getTotalPrice() );

        return orderDto;
    }

    protected ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setPrice( product.getPrice() );

        return productDto;
    }

    protected OrderItemDto orderItemToOrderItemDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setProduct( productToProductDto( orderItem.getProduct() ) );
        if ( orderItem.getQuantity() != null ) {
            orderItemDto.setQuantity( orderItem.getQuantity() );
        }
        orderItemDto.setTotalPrice( orderItem.getTotalPrice() );

        return orderItemDto;
    }

    protected List<OrderItemDto> orderItemSetToOrderItemDtoList(Set<OrderItem> set) {
        if ( set == null ) {
            return null;
        }

        List<OrderItemDto> list = new ArrayList<OrderItemDto>( set.size() );
        for ( OrderItem orderItem : set ) {
            list.add( orderItemToOrderItemDto( orderItem ) );
        }

        return list;
    }
}
