package com.katey2658.web.dao.impl;

import com.katey2658.web.dao.TestInfoDao;
import com.katey2658.web.entity.TestInfo;
import com.katey2658.web.util.DBPool;

import java.sql.*;
import java.util.Collection;
import java.util.Vector;

/**
 * Created by 11456 on 2016/12/11.
 */
public class TestInfoDaoImpl implements TestInfoDao {

    /**
     * 通过课程编号来查询测试信息
     *
     * @param courseId
     * @return
     */
    @Override
    public Collection<TestInfo> findTestsByCourseId(String courseId) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Collection<TestInfo> testInfos = new Vector<>();
        String sql = String.format("SELECT test_id,num,time,date_start,date_end from test WHERE  course_id='%s'"
                + "AND test_id NOT  IN"
                + " (select test.test_id from test,score where score.course_id=test.course_id and test.test_id=score.test_id and test.course_id='%s')", courseId, courseId);

        System.out.println(sql);
        try {
            conn = DBPool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            TestInfo testInfo = null;
            while (rs.next()) {
                testInfo = new TestInfo();
                testInfo.setCourseId(courseId);
                testInfo.setTestId(rs.getString(1));
                testInfo.setJoinNum(rs.getInt(2));
                testInfo.setTime(rs.getInt(3));
                testInfo.setStartTime(rs.getDate(4));
                testInfo.setEndTime(rs.getDate(5));
                testInfos.add(testInfo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.release(conn, st, rs);
        }
        return testInfos;
    }


    /**
     * 通过测试编号来查询测试信息
     *
     * @param testId
     * @return
     */
    @Override
    public Collection<TestInfo> findTestsByTestId(String testId) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Collection<TestInfo> testInfos = new Vector<>();
        String sql = String.format("SELECT course_id,num,time,date_start,date_end from test WHERE test_id=%s", testId);

        try {
            conn = DBPool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            TestInfo testInfo = null;
            while (rs.next()) {
                testInfo = new TestInfo();
                testInfo.setCourseId(rs.getString(1));
                testInfo.setTestId(testId);
                testInfo.setJoinNum(rs.getInt(2));
                testInfo.setTime(rs.getInt(3));
                testInfo.setStartTime(rs.getDate(4));
                testInfo.setEndTime(rs.getDate(5));
                testInfos.add(testInfo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.release(conn, st, rs);
        }
        return testInfos;
    }

    /**
     * 添加一门测试
     *
     * @param testInfo
     * @return
     */
    @Override
    public boolean addTestInfo(TestInfo testInfo) {
        Connection conn = null;
        PreparedStatement ps = null;
        Boolean flag = false;
        String sql = "insert into test(course_id,test_id,time,data_start,data_end,num,num_actual) values(?,?,?,?,?,?,?)";

        try {
            conn = DBPool.getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, testInfo.getCourseId());
            ps.setString(2, testInfo.getTestId());
            ps.setInt(3, testInfo.getTime());
            ps.setDate(4, (Date) testInfo.getStartTime());
            ps.setDate(5, (Date) testInfo.getEndTime());
            ps.setInt(6,testInfo.getJoinNum());
            ps.setInt(7,testInfo.getNumActual());

            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        } finally {
            DBPool.release(conn, ps, null);
        }
        return flag;
    }

    /**
     * 根据教师编号来查询相关课程考试的信息状态已经过了时间限制的
     *
     * @param tecId
     * @return
     */
    @Override
    public Collection<TestInfo> findTestInfosOverTimeByTecId(String tecId) {
        return null;
    }

    /**
     * 根据教师编号来查询所有课程，全部学生已经参与（时间没有到的）
     *
     * @param tecId
     * @return
     */
    @Override
    public Collection<TestInfo> findTestInfosNumIsAllByTecId(String tecId) {
        return null;
    }


    /**
     * 查询所有正在进行中的测试
     *
     * @param tecId
     * @return
     */
    @Override
    public Collection<TestInfo> findTestInfosIsEndByTecId(String tecId) {
        Connection conn = null;
        Statement st=null;
        ResultSet rs = null;
        Collection<TestInfo> testInfos = null;

        final String sql = String.format("SELECT test.course_id,test_id,num,time,date_start,date_end,num_actual " +
                "from test,course_teacher " +
                "WHERE test.course_id=course_teacher.course_id " +
                "and teacher_id='%s'  " +
                "and (TIMESTAMPDIFF(DAY,now(),date_end)>0 " +
                "or num-num_actual=0)",tecId);

        System.out.println(sql);
        try {
            conn = DBPool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            testInfos = new Vector<>();
            TestInfo testInfo = null;
            while (rs.next()) {
                testInfo = new TestInfo();
                testInfo.setCourseId(rs.getString(1));
                testInfo.setTestId(rs.getString(2));
                testInfo.setJoinNum(rs.getInt(3));
                testInfo.setNumActual(rs.getInt(7));
                testInfo.setTime(rs.getInt(4));
                testInfo.setStartTime(rs.getDate(5));
                testInfo.setEndTime(rs.getDate(6));
                testInfos.add(testInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.release(conn, st, rs);
        }
        return testInfos;
    }

    /**
     * 根据教师编号来查询所有正在进行的考试
     *
     * @param tecId
     * @return
     */
    @Override
    public Collection<TestInfo> findTestInfosNowByTecId(String tecId) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Collection<TestInfo> testInfos = null;

        final String sql = String.format("SELECT test.course_id,test_id,num,time,date_start,date_end,num_actual " +
                "from test,course_teacher " +
                "WHERE test.course_id=course_teacher.course_id " +
                "and teacher_id='%s' " +
                "and TIMESTAMPDIFF(DAY,now(),date_end)<=0 " +
                "and num-num_actual>0",tecId);

        System.out.println(sql);
        try {
            conn = DBPool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            testInfos = new Vector<>();
            TestInfo testInfo = null;
            while (rs.next()) {
                testInfo = new TestInfo();
                testInfo.setCourseId(rs.getString(1));
                testInfo.setTestId(rs.getString(2));
                testInfo.setJoinNum(rs.getInt(3));
                testInfo.setNumActual(rs.getInt(7));
                testInfo.setTime(rs.getInt(4));
                testInfo.setStartTime(rs.getDate(5));
                testInfo.setEndTime(rs.getDate(6));
                testInfos.add(testInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.release(conn, st, rs);
        }
        return testInfos;
    }

    /**
     * 根据课程编号和测试编号来查询
     * @param courseId
     * @param testId
     * @return
     */
    @Override
    public TestInfo findTestInfoByIds(String courseId, String testId) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        TestInfo testInfo=null;
        String sql = String.format("SELECT course_id,num,time,date_start,date_end from test WHERE test_id='%s' and course_id='%s'", testId,courseId);

        try {
            conn = DBPool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                testInfo = new TestInfo();
                testInfo.setCourseId(rs.getString(1));
                testInfo.setTestId(testId);
                testInfo.setJoinNum(rs.getInt(2));
                testInfo.setTime(rs.getInt(3));
                testInfo.setStartTime(rs.getDate(4));
                testInfo.setEndTime(rs.getDate(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.release(conn, st, rs);
        }
        return testInfo;
    }
}
