package kr.ac.kaist.salab.controller.page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2016-02-23.
 */
public abstract class PageDescription {
    private String title;
    private String pageFileName;
    private List<String> pageCSS;
    private List<String> pageJS;

    private PageDescription() {
        pageCSS = new ArrayList<>();
        pageJS = new ArrayList<>();
    }

    protected PageDescription(String pageFileName, String title) {
        this();
        this.title = title;
        this.pageFileName = pageFileName + ".jsp";
        initCSS(pageCSS);
        initJS(pageJS);
    }

    abstract void initCSS(List<String> pageCSS);
    abstract void initJS(List<String> pageJS);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPageFileName() {
        return pageFileName;
    }

    public void setPageFileName(String pageFileName) {
        this.pageFileName = pageFileName;
    }

    public List<String> getPageCSS() {
        return pageCSS;
    }

    public void setPageCSS(List<String> pageCSS) {
        this.pageCSS = pageCSS;
    }

    public List<String> getPageJS() {
        return pageJS;
    }

    public void setPageJS(List<String> pageJS) {
        this.pageJS = pageJS;
    }
}
