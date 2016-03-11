package kr.ac.kaist.salab.util;

/**
 * Created by gyeongmin on 3/13/16.
 */
public interface Reducer<K, V, O> {
    void reduce(K key, V value, O output);
}
