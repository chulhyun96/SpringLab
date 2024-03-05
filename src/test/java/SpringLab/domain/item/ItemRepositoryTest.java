package SpringLab.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();


    @AfterEach
    void afterEach() throws Exception {
        itemRepository.clearStore();
    }
    @Test
    void save() {
        // given
        Item item = new Item("itemA",200000,20);
        // when
        Item savedItem = itemRepository.save(item);

        // then
        Item findItem = itemRepository.findById(item.getId());

        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        // given
        Item item1 = new Item("itemA",200000,20);
        Item item2 = new Item("itemB",200000,20);
        Item savedItem1 = itemRepository.save(item1);
        Item savedItem2 = itemRepository.save(item2);

        List<Item> itemList = new ArrayList<>();
        itemList.add(savedItem1);
        itemList.add(savedItem2);
        // when
        List<Item> result = itemRepository.findAll();


        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1, item2);

    }

    @Test
    void updateItem() {
    }

    @Test
    void clearStore() {
    }
}