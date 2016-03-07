package kr.ac.kaist.salab.controller.page;

import java.util.List;

/**
 * Created by gyeongmin on 3/7/16.
 */
public interface WebResourceInitializer {
    void initResource(List<String> pageCSS, List<String> pageJS);
}
