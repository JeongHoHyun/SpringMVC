package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // 실무에서는 HashMap으로 사용하면 안됨.. 멀티 스레드 환, 동시에 여러 쓰레드가 접근하면 ConcurrentHashMap<>() 으로 선언해서 사용해야 한다.
    private static final Map<Long, Item> store = new HashMap<>();
    // 이거 또한 멀티 스레드 환경에서는 AtomicLong 고려
    private static long sequence = 0L;

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

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
