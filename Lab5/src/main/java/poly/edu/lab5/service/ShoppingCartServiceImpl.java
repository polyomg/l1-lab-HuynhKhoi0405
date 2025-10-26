package poly.edu.lab5.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import poly.edu.lab5.model.Item;
import java.util.*;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    Map<Integer, Item> map = new HashMap<>();

    public Item add(Integer id) {
        Item item = map.get(id);
        if (item == null)
            map.put(id, new Item(id, "Item " + id, 10.0 * id, 1));
        else
            item.setQty(item.getQty() + 1);
        return item;
    }

    public void remove(Integer id) {
        map.remove(id);
    }

    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) item.setQty(qty);
        return item;
    }

    public void clear() {
        map.clear();
    }

    public Collection<Item> getItems() {
        return map.values();
    }

    public int getCount() {
        return map.values().stream().mapToInt(i -> i.getQty()).sum();
    }

    public double getAmount() {
        return map.values().stream().mapToDouble(i -> i.getPrice() * i.getQty()).sum();
    }
}
