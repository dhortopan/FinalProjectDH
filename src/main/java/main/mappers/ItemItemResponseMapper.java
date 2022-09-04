package main.mappers;

import main.controllers.dto.ItemResponse;
import main.repository.entity.Item;
import org.springframework.stereotype.Component;


@Component
public class ItemItemResponseMapper {

    public ItemResponse map(Item item) {
        return ItemResponse.builder()
                .id(item.getId())
                .age(item.getAge())
                .name(item.getName())
                .build();
    }


}
