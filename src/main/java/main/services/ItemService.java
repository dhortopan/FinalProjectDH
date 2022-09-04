package main.services;

import lombok.RequiredArgsConstructor;
import main.controllers.dto.ItemResponse;
import main.mappers.ItemItemResponseMapper;
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

    public List<ItemResponse> findAll(){
        return itemRepository.findAll().stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

}
