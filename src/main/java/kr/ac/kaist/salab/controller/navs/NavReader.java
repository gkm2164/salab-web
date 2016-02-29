package kr.ac.kaist.salab.controller.navs;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by gyeongmin on 2016. 2. 27..
 */
public class NavReader {

    public class SAXNavParser extends DefaultHandler {

        private Stack<NavNode> stack;
        private NavNode currentNode;
        private List<NavNode> nodeList;
        private NavReverseMap reverseMap = new NavReverseMap();

        boolean isNameWriting = false;
        String nameBuffer;

        public SAXNavParser() {
            stack = new Stack<>();
            nodeList = new ArrayList<>();
        }

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
        }


        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            switch (qName) {
                case "navigation":
                    currentNode = new NavNode(null, "ROOT", "");
                    break;
                case "node":
                    stack.push(currentNode);
                    currentNode = new NavNode();
                    currentNode.setId(attributes.getValue("id"));
                    break;
                case "link":
                    currentNode.setLink(attributes.getValue("href"));
                    break;
                case "name":
                    isNameWriting = true;
                    nameBuffer = "";
                    break;
                case "childs":
                    break;
                default:
                    break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch (qName) {
                case "navigation":
                    break;
                case "node":
                    NavNode parent = stack.pop();
                    parent.addChild(currentNode);
                    currentNode.setParent(parent);
                    reverseMap.put(currentNode.getId(), currentNode);

                    currentNode = parent;
                    break;
                case "link":
                    break;
                case "name":
                    isNameWriting = false;
                    currentNode.setName(nameBuffer);
                    break;
                case "childs":
                    break;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isNameWriting) {
                String buf = new String(ch, start, length).trim();
                nameBuffer += buf;
            }
        }

        public NavNode getCurrentNode() {
            return currentNode;
        }

        public NavNode getNodeById(String id) {
            return reverseMap.get(id);
        }
    }

    private SAXNavParser saxNavParser = new SAXNavParser();

    public NavNode readFile(String fileName) throws SAXException, IOException {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        parser.setContentHandler(saxNavParser);

        InputSource source = new InputSource(new FileInputStream(new File(fileName)));
        parser.parse(source);

        return saxNavParser.getCurrentNode();
    }

    public NavNode getNodeById(String id) {
        return saxNavParser.getNodeById(id);
    }

    public NavReverseMap getReverseMap() {
        return saxNavParser.reverseMap;
    }

    public static void main(String[] args) throws IOException, SAXException {
        NavReader nr = new NavReader();

        NavNode root = nr.readFile("prop/salab-nav.xml");

        root.getChilds().forEach((nav) -> {
            System.out.println(nav.getName() + "(" + nav.getPathName() + ")");
            nav.getChilds().forEach((nav2) -> {
                System.out.println(nav2.getName() + "(" + nav2.getPathName() + ")");
            });
        });
    }
}
