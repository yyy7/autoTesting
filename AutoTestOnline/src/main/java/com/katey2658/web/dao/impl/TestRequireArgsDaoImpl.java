package com.katey2658.web.dao.impl;

import com.katey2658.web.common.CollectionConvertTool;
import com.katey2658.web.dao.TestRequireArgsDao;
import com.katey2658.web.entity.TestRequireArgs;
import com.katey2658.web.util.DBPool;


import java.sql.*;

/**
 * Created by 11456 on 2016/12/20.
 */
public class TestRequireArgsDaoImpl implements TestRequireArgsDao {

    /**
     * 添加一个考试要求到表中
     * @param testRequireArgs
     */
    @Override
    public void addTestRequireArgs(TestRequireArgs testRequireArgs) {
        Connection conn=null;
        PreparedStatement ps=null;

        conn=DBPool.getConnection();
        try{
            ps= conn.prepareStatement("INSERT INTO test_args(course_id,test_id,test_points,diffcuty_pencents) VALUE(?,?,?,?)");
            ps.setString(1,testRequireArgs.getCourseId());
            ps.setString(2,testRequireArgs.getTestId());
            ps.setString(3,CollectionConvertTool.CollectionConvertToString(testRequireArgs.getTestPoints()));
            ps.setString(4,CollectionConvertTool.mapConvertToString(testRequireArgs.getDiffcutyPercents()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBPool.release(conn,ps,null);
        }

    }

    /**
     * 根据课程号和测试号来查询一个关于考试规定信息
     * @param courseId
     * @param testId
     * @return
     */
    @Override
    public TestRequireArgs findTestRequireArgsById(String courseId, String testId) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        TestRequireArgs testRequireArgs=null;

        conn= DBPool.getConnection();
        try {
            ps=conn.prepareStatement("SELECT test_points,diffcuty_pencents FROM test_args WHERE course_id=? and test_id=?");
            ps.setString(1,courseId);
            ps.setString(2,testId);
            rs=ps.executeQuery();
            while (rs.next()){
                testRequireArgs=new TestRequireArgs();
                testRequireArgs.setCourseId(courseId);
                testRequireArgs.setTestId(testId);
                testRequireArgs.setTestPoints(CollectionConvertTool.StringConvertToCollection(rs.getString(1)));
                System.out.println(rs.getString(1)+"============="+testRequireArgs.getTestPoints());
                testRequireArgs.setDiffcutyPercents(CollectionConvertTool.stringConvertZToMap(rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.release(conn,ps,rs);
        }
        return testRequireArgs;
    }

    /**
     * 修改考试规定（一般不允许，只能删除重建）
     * @param testRequireArgs
     */
    @Override
    public void updateTestRequireArgs(TestRequireArgs testRequireArgs) {

    }

    /**
     * 课程测试号来删除一个考试信息
     * @param courseId
     * @param testId
     */
    @Override
    public void deleteTestRequireArgsById(String courseId, String testId) {

    }
}
