package kr.ac.kaist.salab.controller.navs.annotation;

import kr.ac.kaist.salab.controller.navs.NavNode;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NavigationBuilder {
    private static final Logger l = Logger.getLogger(NavigationBuilder.class.getName());
    private ArrayList<Class<?>> classList;
    private NavNode root;

    public NavigationBuilder(Class<?> basePkg) {

        String pkgName = basePkg.getPackage().getName();
        Reflections reflections = new Reflections(pkgName, new SubTypesScanner(false));

        classList = new ArrayList<>();

        reflections.getSubTypesOf(Object.class).forEach((klazz) -> {

            l.log(Level.INFO, klazz.getName());
            if (klazz.isAnnotation()) return;
            for (Annotation a: klazz.getDeclaredAnnotations()) {
                l.log(Level.INFO, " -> Annotated with: " + a.toString());
            }
            if (klazz.getAnnotation(NavigationTop.class) != null) {
                l.log(Level.INFO, " -> This class is annotated as a navigation element");
                classList.add(klazz);
            }
        });
        System.out.println(classList.size());
        root = new NavNode();
        root.setName("ROOT");
        root.setLink("");
        constructNavBar();
    }

    private void constructNavBar() {
        classList.forEach((klass) -> {
            NavigationTop nt = klass.getAnnotation(NavigationTop.class);
            NavNode nav = new NavNode();
            nav.setDesc(nt.value());
            nav.setExposeOnGlobalNav(nt.exposeOnGlobalNav());

            root.addChild(nav.getId(), nav);

            Arrays.asList(klass.getMethods()).forEach((f) -> {
                NavigationItem ni = f.getAnnotation(NavigationItem.class);
                if (ni != null) {
                    NavNode child = new NavNode();
                    child.setDesc(ni.value());
                    child.setExposeOnGlobalNav(ni.exposeOnGlobalNav());
                    child.setExposeOnLocalNav(ni.exposeOnLocalNav());
                    nav.addChild(child.getId(), child);
                }
            });

            nav.getChilds().sort((a, b) -> a.getOrder() - b.getOrder());
        });
        root.getChilds().sort((a, b) -> a.getOrder() - b.getOrder());
    }

    public NavNode getRoot() {
        return root;
    }
}
