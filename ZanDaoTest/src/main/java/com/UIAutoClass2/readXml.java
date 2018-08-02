package com.UIAutoClass2;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017-08-15.
 */
public class readXml {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read("src/main/java/student.xml");
        //获取根节点
        Element root=document.getRootElement();
        System.out.println("Root:"+root.getName());

        //打印子元素名称和属性
        List<Element> childList = root.elements();
        System.out.println("total child count: " + childList.get(3).getName());
        System.out.println("total child count: " + childList.get(3).attributeValue("name"));

       //打印子元素文本
        System.out.println("total child count: " + childList.get(3).getText());

        //提取部分节点
        List<Element> elsList=root.elements("stua");

        //遍历
        for(Iterator iter=elsList.iterator();iter.hasNext();){
            Element e=(Element)iter.next();
            System.out.println(e.attributeValue("name"));
        }
    }
}
