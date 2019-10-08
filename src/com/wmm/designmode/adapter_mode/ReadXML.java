package com.wmm.designmode.adapter_mode;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;

/**
 * @author wangmingming160328
 * @Description 读取xml
 * @date @2019/9/30 11:34
 */
public class ReadXML {
    public static Object getObject() {
        try{
            DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=dFactory.newDocumentBuilder();
            Document doc;
            doc=builder.parse(new File("src/config.xml"));
            NodeList nl=doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName="com.wmm.designmode.adapter_mode.motor.adapter." +classNode.getNodeValue();
            Class<?> c= Class.forName(cName);
            Object obj=c.newInstance();
            return obj;
        } catch (InstantiationException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
