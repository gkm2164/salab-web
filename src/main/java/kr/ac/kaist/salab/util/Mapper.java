package kr.ac.kaist.salab.util;

/**
 * Created by USER on 2016-03-15.
 */
public interface Mapper<D, IK, IV> {
    void map(D data, Context<IK, IV> ctx);
}
