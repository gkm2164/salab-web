package kr.ac.kaist.salab.util;

/**
 * Created by gyeongmin on 3/13/16.
 */
public interface Mapper<D extends Object, K, V> {
    void map(D data, Context<K, V> ctx);
}
