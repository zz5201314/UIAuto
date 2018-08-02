package com.first.demo;

import com.first.uiframework.TestCase;
import com.first.utils.ExcelUtils;

import java.util.List;

/**
 * Created by Administrator on 2017-08-21.
 */
public class ReadExcelDemo {
    public static void main(String[] args) {
        List<TestCase> testCase= ExcelUtils.getUITestData("UITestData.xlsx");

        System.out.println(testCase.get(2).getCaseName());
        System.out.println(testCase.get(2).getIsCheck());
        System.out.println(testCase.get(2).getExpectedResult());
        System.out.println(testCase.get(2).getTestData().get("username"));
        System.out.println(testCase.get(2).getTestData().get("password"));
        System.out.println(testCase.get(2).getTestData().get("email"));
    }
}
