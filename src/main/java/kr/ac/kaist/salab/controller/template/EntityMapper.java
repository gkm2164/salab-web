package kr.ac.kaist.salab.controller.template;

/**
 * Created by USER on 2016-03-16.
 */
public interface EntityMapper<I, O> {
    void mapping(I input, O output);
}
