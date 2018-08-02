package com.first.uiframework;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-08-21.
 */
public class TestCase {
    private String caseName=null;
    private String isCheck=null;
    private String expectedResult=null;
    private Map<String,String> testData=new HashMap<String, String>();

    public TestCase( String caseName,String isCheck, String expectedResult,Map<String,String> testData){
        this.caseName=caseName;
        this.isCheck=isCheck;
        this.expectedResult=expectedResult;
        this.testData=testData;
    }

    public String getCaseName() {
        return caseName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getIsCheck() {

        return isCheck;
    }

    public Map<String, String> getTestData() {
        return testData;
    }
}
