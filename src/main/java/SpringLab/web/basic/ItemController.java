package SpringLab.web.basic;


import SpringLab.domain.item.Item;
import SpringLab.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@Slf4j
public class ItemController {
    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        repository.save(new Item("testA", 10000, 10));
        repository.save(new Item("testB", 20000, 20));
    }

    @GetMapping
    public String items(Model model) {
        List<Item> itemList = repository.findAll();
        model.addAttribute("items", itemList);
        return "basic/items";
    }
    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item findItem = repository.findById(itemId);
        model.addAttribute("item", findItem);
        return "basic/item";
    }
    @GetMapping("/add")
    public String addItem(@ModelAttribute String name) {
        return "basic/addForm";
    }
    @PostMapping("/add")
    public String saveItem(@RequestParam String itemName,
                           @RequestParam Integer price,
                           @RequestParam Integer quantity,
                           Model model) {

        Item newItem = new Item(itemName, price, quantity);
        repository.save(newItem);
        model.addAttribute("item", newItem);
        return "basic/item";
    }
}
