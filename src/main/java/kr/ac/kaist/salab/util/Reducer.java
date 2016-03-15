package kr.ac.kaist.salab.util;

/**
 * Created by USER on 2016-03-15.
 */
public interface Reducer<OK, OV> {
    <IK, IV> void reduce(IK key, IV value, Context<OK, OV> ctx);
}
