package com.katey2658.web.dao;

import com.katey2658.web.entity.TestRequireArgs;

/**
 * Created by 11456 on 2016/12/20.
 */
public interface TestRequireArgsDao{

    /**
     * 添加一个考试要求到表中
     * @param testRequireArgs
     */
    public void addTestRequireArgs(TestRequireArgs testRequireArgs);

    /**
     * 根据课程号和测试号来查询一个关于考试规定信息
     * @param courseId
     * @param testId
     * @return
     */
    public TestRequireArgs findTestRequireArgsById(String courseId,String testId);

    /**
     * 修改考试规定（一般不允许，只能删除重建）
     * @param testRequireArgs
     */
    public void updateTestRequireArgs(TestRequireArgs testRequireArgs);


    /**
     * 课程测试号来删除一个考试信息
     * @param courseId
     * @param testId
     */
    public void deleteTestRequireArgsById(String courseId,String testId);
}
