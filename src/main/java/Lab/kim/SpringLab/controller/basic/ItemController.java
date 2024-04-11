package Lab.kim.SpringLab.controller.basic;


import Lab.kim.SpringLab.domain.item.DeliveryCode;
import Lab.kim.SpringLab.domain.item.DeliveryCodeFactory;
import Lab.kim.SpringLab.domain.item.Item;
import Lab.kim.SpringLab.domain.item.ItemRepository;
import Lab.kim.SpringLab.type.ItemType;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @ModelAttribute("regions")
    public Map<String,String> regions() {
        Map<String, String> region = new LinkedHashMap<>();
        region.put("SEOUL", "서울");
        region.put("BUSAN", "부산");
        region.put("JEJU", "제주");
        return region;
    }
    @ModelAttribute("deliveryCodes")
    public List<DeliveryCode> deliveryCodes() {
        return DeliveryCodeFactory.getDeliveryCodes();
    }
    @ModelAttribute("itemTypes")
    public ItemType[] itemTypes() {
        return ItemType.values();
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
    public String item(@PathVariable Long itemId, Model model) {
        Item findItem = repository.findById(itemId);
        model.addAttribute("item", findItem);
        return "basic/item";
    }
    @PostMapping("/add")
    public String addItem(@ModelAttribute Item item, RedirectAttributes ra) {
        Item savedItem = repository.save(item);
        log.info("TestItem = {}", item);
        log.info("Item regions= {}", item.getRegions());
        log.info("Item type= {}", item.getItemType());
        ra.addAttribute("itemId", savedItem.getId());
        ra.addAttribute("save",true);
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item findItem = repository.findById(itemId);
        model.addAttribute("item", findItem);
        return "basic/editForm";
    }
    //수정하기
    @PostMapping("/{itemId}/edit")
    public String editItem(@ModelAttribute("item") Item updateItem, @PathVariable Long itemId) {
        repository.updateItem(itemId, updateItem);
        return "redirect:/basic/items/{itemId}";
    }
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "basic/addForm";
    }
    @GetMapping("/addItem")
    public String testAdd(Model model) {
        model.addAttribute("item", new Item());
        log.info("Item = {}", model);
        return "basic/test";
    }
}
