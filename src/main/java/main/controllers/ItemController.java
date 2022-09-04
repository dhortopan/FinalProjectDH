package main.controllers;

import lombok.RequiredArgsConstructor;
import main.controllers.dto.ItemRequest;
import main.controllers.dto.ItemResponse;
import main.repository.entity.Item;
import main.services.ItemService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("item")
@RequiredArgsConstructor
@Validated
public class ItemController {

    private final ItemService itemService;

    @GetMapping(value = "all")
    public List<ItemResponse> findAll(){
        return itemService.findAll();
    }

    @PostMapping
//    @PatchMapping
    // @PatchMapping e similar cu @PostMapping - clientul e respononsabil sa trimita un json (payload) la server
    // trebui sa specifice id-ul + noul continut care il rescrie pe cel actual
    public ItemResponse save(@Valid @RequestBody ItemRequest itemRequest) {
        return itemService.save(itemRequest);
    }

    @DeleteMapping(value ="{nume}")
    public void delete(@PathVariable(value = "nume") Integer id){
        itemService.delete(id);
    }

}
