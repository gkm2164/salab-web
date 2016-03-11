package kr.ac.kaist.salab.model.helper;

import kr.ac.kaist.salab.model.entity.Member;
import kr.ac.kaist.salab.util.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by gyeongmin on 3/13/16.
 */
public class MemberAlumniHelper {
    public static class AlumniMapper
            implements Mapper<Member, Integer, Member>,
            Reducer<Integer, Member, HashMapLinked<Integer, Member>> {

        @Override
        public void map(Member data, Context<Integer, Member> ctx) {
            ctx.write(data.getGraduatedYear(), data);
        }

        @Override
        public void reduce(Integer key, Member value, HashMapLinked<Integer, Member> output) {
            output.add(key, value);
        }
    }

    public static void constructTable (List<Member> members, HashMapLinked<Integer, Member> table) {
        AlumniMapper am = new AlumniMapper();

        MapReducer<Member, Integer, Member, HashMapLinked<Integer, Member>> mr =
        new MapReducer<>(am, am);

        mr.mapReduce(members, table);
    }
}
