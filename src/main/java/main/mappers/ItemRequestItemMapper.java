package main.mappers;

import main.controllers.dto.ItemRequest;
import main.controllers.dto.ItemResponse;
import main.repository.entity.Item;
import org.springframework.stereotype.Component;


@Component
public class ItemRequestItemMapper {

    public Item map(ItemRequest item) {
        return Item.builder()
                .age(item.getAge())
                .name(item.getName())
                .build();
    }


}
