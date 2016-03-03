package kr.ac.kaist.salab.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by USER on 2016-03-03.
 */
public class HashMapLinked<K, V> extends HashMap<K, List<V>> {
    public void add(K key, V value) {
        List<V> list = this.get(key);
        if (list == null) {
            list = new ArrayList<>();
            this.put(key, list);
        }

        if (!list.contains(value)) {
            list.add(value);
        }
    }
}
