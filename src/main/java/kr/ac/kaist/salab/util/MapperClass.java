package kr.ac.kaist.salab.util;

import java.util.List;

/**
 * Created by USER on 2016-03-15.
 */
public class MapperClass<D, IK, IV> {
    private Mapper<D, IK, IV> mapper;
    private HashMapLinked<IK, IV> hashMap = new HashMapLinked<>();

    public MapperClass(Mapper<D, IK, IV> mapper) {
        this.mapper = mapper;
    }

    public HashMapLinked<IK, IV> map(List<D> data) {
        Context<IK, IV> ctx = new Context<>();
        HashMapLinked<IK, IV> map = new HashMapLinked<>();

        data.forEach(x -> {
            mapper.map(x, ctx);
            map.add(ctx.getKey(), ctx.getValue());
        });

        return map;
    }
}
