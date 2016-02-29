package kr.ac.kaist.salab.controller.navs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyeongmin on 2016. 2. 27..
 */
public class NavNode {
    private NavNode parent;

    private String name;
    private String link;

    private boolean exposeOnGlobalNav = true;
    private boolean exposeOnLocalNav = true;
    private boolean globalExposeChild = true;

    private List<NavNode> childs;

    public NavNode() {
        childs = new ArrayList<>();
    }

    public NavNode(NavNode parent, String name, String link) {
        this.parent = parent;
        this.name = name;
        this.link = link;
        childs = new ArrayList<>();
    }

    public NavNode getParent() {
        return parent;
    }

    public void setParent(NavNode parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPathName() {
        if (parent != null) {
            return parent.getPathName() + link;
        }
        return link;
    }

    public boolean getExposeOnGlobalNav() {
        return exposeOnGlobalNav;
    }

    public void setExposeOnGlobalNav(boolean exposeOnGlobalNav) {
        this.exposeOnGlobalNav = exposeOnGlobalNav;
    }

    public boolean getExposeOnLocalNav() {
        return exposeOnLocalNav;
    }

    public void setExposeOnLocalNav(boolean exposeOnLocalNav) {
        this.exposeOnLocalNav = exposeOnLocalNav;
    }

    public boolean getGlobalExposeChild() {
        return globalExposeChild;
    }

    public void setGlobalExposeChild(boolean globalExposeChild) {
        this.globalExposeChild = globalExposeChild;
    }

    public List<NavNode> getChilds() {
        return childs;
    }

    public void setChilds(List<NavNode> childs) {
        this.childs = childs;
    }

    public void addChild(NavNode navNode) {
        childs.add(navNode);
    }
}
