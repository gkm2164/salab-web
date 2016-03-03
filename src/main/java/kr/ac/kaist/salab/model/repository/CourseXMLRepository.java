package kr.ac.kaist.salab.model.repository;

import kr.ac.kaist.salab.model.entity.Course;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2016-02-23.
 */
public class CourseXMLRepository {
    private final String PATH_CONTEXT_PREFIX = "./src/main/webapp/";
    private final String FILENAME = "/WEB-INF/xmls/courses.xml";
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();

        Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance()
                                .newDocumentBuilder()
                                .parse(new File(PATH_CONTEXT_PREFIX + FILENAME));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NodeList nodeList = document.getElementsByTagName("course");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element elem = (Element)nodeList.item(i);

            Course course = new Course();
            if (elem.getAttribute("id") != null && !elem.getAttribute("id").equals("")) {
                course.setId(Integer.valueOf(elem.getAttribute("id")));
            }
            course.setTitle(elem.getElementsByTagName("title").item(0).getTextContent());
            course.setDescription(elem.getElementsByTagName("description").item(0).getTextContent());

            courses.add(course);
        }
        return courses;
    }
}
