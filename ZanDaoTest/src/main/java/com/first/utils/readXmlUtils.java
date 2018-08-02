package com.first.utils;

import com.first.uiframework.Locator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-08-18.
 */
public class readXmlUtils {
    public static HashMap<String,Locator> readElementInfo(String filePath) throws DocumentException {
        Map<String, Locator> elementInfos = new HashMap<String, Locator>();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(filePath));
        Element root = document.getRootElement();
        List<Element> chidlist = root.elements("locator");
        for (Element e : chidlist) {
            String value = e.attributeValue("value").toString();
            int timeout = Integer.parseInt(e.attributeValue("timeout"));
            String type = e.attributeValue("type").toString();
            String name = e.attributeValue("name").toString();
            Locator locator = new Locator(name, getType(type), value, timeout);
            String keyName = e.getText();//键名

            elementInfos.put(keyName, locator);//往map中插入数据

        }
        return (HashMap<String, Locator>) elementInfos;
    }
        public static Locator.ByType getType(String value) {
            Locator.ByType byType = null;
            if (value.equals("id")) {
                byType = byType.id;

            } else if (value.equals("css")) {
                byType = byType.cssSelector;

            } else if (value.equals("xpath")) {
                byType = byType.xpath;

            } else if (value.equals("linkText")) {
                byType = byType.linkText;

            } else if (value.equals("name")) {
                byType = byType.name;

            } else if (value.equals("partialLinkText")) {
                byType = byType.partialLinkText;

            } else if (value.equals("tagName")) {
                byType = byType.tagName;

            }
            return byType;
        }
}
