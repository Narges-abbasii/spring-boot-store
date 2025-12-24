package com.codewithmosh.store.mappers;

import com.codewithmosh.store.dtos.OrderDto;
import com.codewithmosh.store.dtos.OrderItemDto;
import com.codewithmosh.store.dtos.OrderProductDto;
import com.codewithmosh.store.entities.Order;
import com.codewithmosh.store.entities.OrderItem;
import com.codewithmosh.store.entities.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-24T20:38:22+0330",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25 (Oracle Corporation)"
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

    protected OrderProductDto productToOrderProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        OrderProductDto orderProductDto = new OrderProductDto();

        orderProductDto.setId( product.getId() );
        orderProductDto.setName( product.getName() );
        orderProductDto.setPrice( product.getPrice() );

        return orderProductDto;
    }

    protected OrderItemDto orderItemToOrderItemDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setProduct( productToOrderProductDto( orderItem.getProduct() ) );
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
