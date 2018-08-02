package com.first.uiframework;

/**
 * 作用：元素定位
 * Created by Administrator on 2017-08-18.
 */
public class Locator {
    //枚举类型，元素定位方法使用
    public enum ByType {
        xpath,id,linkText,name,className,cssSelector,partialLinkText,tagName
    }

    private String elementName;//元素名称
    private ByType byType;//定位的方式
    private String locatorInfo;//定位的数据
    private int timeOut;//显示等待超时时间


    public  Locator(String elementName,ByType byType,String locatorInfo,int timeOut){
        this.elementName=elementName;
        this.byType=byType;
        this.locatorInfo=locatorInfo;
        this.timeOut=timeOut;
    }

    public String getElementName() {
        return elementName;
    }

    public ByType getByType() {
        return byType;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public String getLocatorInfo() {

        return locatorInfo;
    }
}
