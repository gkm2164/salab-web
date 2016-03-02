package kr.ac.kaist.salab.controller.navs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<String, NavNode> childMap = new HashMap<>();
    private String id;
    private int order;

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

    public void addChild(String id, NavNode navNode) {
        childs.add(navNode);
        childMap.put(id, navNode);
        navNode.setParent(this);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public NavNode findId(String id) {
        return childMap.get(id);
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
