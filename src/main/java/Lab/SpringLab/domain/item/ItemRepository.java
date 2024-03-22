package Lab.SpringLab.domain.item;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }
    public Item findById(Long id) {
        return store.get(id);
    }
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }
    public void updateItem(Long id, Item item) {
        Item findItem = findById(id);
        findItem.setItemName(item.getItemName());
        findItem.setPrice(item.getPrice());
        findItem.setQuantity(item.getQuantity());
    }
    //테스트 시 사용하기 위한 메서드
    public void clearStore() {
        store.clear();
    }
}
