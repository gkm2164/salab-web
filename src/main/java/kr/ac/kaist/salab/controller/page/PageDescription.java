package kr.ac.kaist.salab.controller.page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2016-02-23.
 */
public class PageDescription {
    private String title;
    private String pageFileName;
    private List<String> pageCSS;
    private List<String> pageJS;

    public PageDescription(WebResourceInitializer wri) {
        pageCSS = new ArrayList<>();
        pageJS = new ArrayList<>();

        wri.initResource(pageCSS, pageJS);
    }

    public PageDescription(String pageFileName, String title, WebResourceInitializer wri) {
        this(wri);
        this.title = title;
        this.pageFileName = pageFileName + ".jsp";
    }

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
