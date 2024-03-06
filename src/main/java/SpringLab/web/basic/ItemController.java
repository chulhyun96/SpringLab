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
    //리스트페이지 불러오기

    @GetMapping
    public String items(Model model) {
        List<Item> itemList = repository.findAll();
        model.addAttribute("items", itemList);
        return "basic/items";
    }

    //디테일페이지
    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item findItem = repository.findById(itemId);
        model.addAttribute("item", findItem);
        return "basic/item";
    }
    //등록 폼
    @GetMapping("/add")
    public String addItem() {
        return "basic/addForm";
    }
    //등록하기
    @PostMapping("/add")
    public String addItem(@ModelAttribute("item") Item item) {
        repository.save(item);
        return "basic/item";
    }
    //수정 폼
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item findItem = repository.findById(itemId);
        model.addAttribute("item", findItem);
        return "basic/editForm";
    }
    //수정하기
    @PostMapping("/{itemId}/edit")
    public String editItem(@ModelAttribute("item") Item updateItem,@PathVariable Long itemId) {
        repository.updateItem(itemId, updateItem);
        return "redirect:/basic/items/{itemId}";
    }

}
