package kr.ac.kaist.salab.util;

/**
 * Created by USER on 2016-03-15.
 */
public class Context<K, V> {
    private K key;
    private V value;

    public Context() {
    }

    public Context(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void write(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
