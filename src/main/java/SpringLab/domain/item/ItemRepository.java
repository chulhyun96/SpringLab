package SpringLab.domain.item;


import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new ConcurrentHashMap<>();
    /*private static AtomicLong sequence = new AtomicLong();*/
    private static Long sequence = 0L;
}
