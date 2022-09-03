package main.services;

import lombok.RequiredArgsConstructor;
import main.repository.ItemRepository;
import main.repository.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> findAll(){
        return itemRepository.findAll();
    }
}
