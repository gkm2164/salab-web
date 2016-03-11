package kr.ac.kaist.salab.util;

import java.util.*;

/**
 * Created by gyeongmin on 3/13/16.
 */
public class MapReducer<E, K, V, O> {
    private Mapper<E, K, V> mapper;
    private Reducer<K, V, O> reducer;

    private Map<K, List<V>> hash;

    public MapReducer(Mapper<E, K, V> mapper, Reducer<K, V, O> reducer) {
        this.mapper = mapper;
        this.reducer = reducer;

        hash = new Hashtable<>();
    }

    public void map(Iterable<E> data) {
        Iterator<E> it = data.iterator();

        while (it.hasNext()) {
            E element =  it.next();
            Context<K, V> ctx = new Context<>();

            mapper.map(element, ctx);

            List<V> list;
            if ((list = hash.get(ctx.getKey())) == null) {
                list = new ArrayList<>();
                hash.put(ctx.getKey(), list);
            }

            list.add(ctx.getValue());
        }
    }

    public void reduce(O output) {
        hash.keySet().forEach(
                k -> hash.get(k).forEach(
                        v -> reducer.reduce(k, v, output)
                )
        );
    }

    public void mapReduce(Iterable<E> data, O output) {
        map(data);
        reduce(output);
    }
}
