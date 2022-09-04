package main.services;

import lombok.RequiredArgsConstructor;
import main.controllers.dto.ItemRequest;
import main.controllers.dto.ItemResponse;
import main.mappers.ItemItemResponseMapper;
import main.mappers.ItemRequestItemMapper;
import main.repository.ItemRepository;
import main.repository.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemItemResponseMapper mapper;
    private final ItemRequestItemMapper itemRequestItemMapper;

    public List<ItemResponse> findAll(){
        return itemRepository.findAll().stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }


    public ItemResponse save(ItemRequest itemRequest) {
        Item item = this.itemRequestItemMapper.map(itemRequest);
        itemRepository.save(item);
        return mapper.map(item);

    }

    public void delete(Integer id) {
        itemRepository.deleteById(id);
    }

}
