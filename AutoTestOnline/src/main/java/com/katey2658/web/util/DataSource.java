package com.katey2658.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 读取数据库配置文件，然后创建要给数据库连接池
 * Created by 11456 on 2016/12/4.
 */
public class DataSource implements javax.sql.DataSource {

    /**
     * 创建一个链表集合来存放数据库连接对象
     * 因为要不断操作增加和删除集合中元素，所以LinkedList来存储个更为合适
     */
    private static LinkedList<Connection> connList=new LinkedList<Connection>();


    /**
     * 根据配置文件来进行初始化创建连接池
     */
    static {
        //创建一个配置文件输入流
        InputStream in=DataSource
                .class
                .getClassLoader()
                .getResourceAsStream("dbConfig.properties");
        //创建一个Propeties对象（一种特殊的对象）
        Properties properties=new Properties();
        try{
            //加载配置文件
            properties.load(in);
            System.out.println("-------------------ii");
            //驱动，url和用户名和密码
            String driver=properties.getProperty("driver");
            String url=properties.getProperty("url");
            String userName=properties.getProperty("username");
            String password=properties.getProperty("password");
            //初始连接池大小
            int connPoolInitSize=Integer.parseInt(properties.getProperty("connectionPoolInitSize"));

            System.out.println("-------------------"+driver+":"+url);
            //加载数据库驱动
            Class.forName(driver);

            //创建初始连接池大小，并且放进连接对象集合中
            Connection connection=null;
            for (int i=0;i<connPoolInitSize;i++){
                connection= DriverManager.getConnection(url,userName,password);
                connList.add(connection);
                System.out.println("创建数据库"+connection);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("数据库连接池工作结束！创建连接池："+connList.size());
        }
    }


    /**
     * 从数据库连接对象池中取出一个连接对象的代理
     * @return 一个数据库连接代理对象
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {

        //如连接池对象个数大于0，就从连接池取出一个
        if (connList.size()>0){
            final Connection conn=connList.removeFirst();
            System.out.print("当前连接池大小是："+connList.size());

            //返回连接的代理对象
            return (Connection) Proxy.newProxyInstance(DataSource.class.getClassLoader()
                    ,conn.getClass().getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (!method.getName().endsWith("close")){
                        return method.invoke(conn,args);
                    }else {
                        //调用的是管理数据库，这就要收回数据库连接对象到池
                        connList.add(conn);
                        System.out.println(conn+":还给数据库连接池");
                        System.out.println("当前连接池大小："+connList.size());
                        return null;
                    }
                }
            });
        }else{
            throw new RuntimeException("数据库忙！稍等");
        }
    }

    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    public void setLoginTimeout(int seconds) throws SQLException {

    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
