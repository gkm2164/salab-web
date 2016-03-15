package kr.ac.kaist.salab.util;

import java.util.List;

/**
 * Created by USER on 2016-03-15.
 */
public class MapReduce<D, IK, IV, OK, OV> {
    private Mapper<D, IK, IV> mapper;
    private Reducer<OK, OV> reducer;
    private HashMapLinked<IK, IV> linkedMap = new HashMapLinked<>();

    public void mapReduce(List<D> dataList) {
        dataList.forEach(x -> {
            Context<IK, IV> ctx = new Context<>();
            mapper.map(x, ctx);

            linkedMap.add(ctx.getKey(), ctx.getValue());


        });
    }
}
