package com.katey2658.web.common;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by 11456 on 2016/11/23.
 */
public class SessionScanTask extends TimerTask {
    /**
     * 使得session失效的时间差，以上一次访问为根据,以秒为单位
     */
    private final int TIME_SESSION_TO_INVALIDATE=15;
    /**
     * 对session集合的引用对象
     */
    private List<HttpSession> sessionList;

    /**
     * 对锁对象的引用
     */
    private Object lock;

    /**
     * 有参构造方法
     * @param sessionList session集合
     * @param lock 锁对象
     */
    public SessionScanTask(List<HttpSession> sessionList, Object lock){
        this.sessionList=sessionList;
        this.lock=lock;
    }

    /**
     * 任务执行：检查每一个session，如果符合失效时间间隔就失效
     */
    @Override
    public void run() {

        HttpSession session=null;
        //获得锁
        synchronized (lock){
            //获得集合的迭代器
            Iterator<HttpSession> iterator=sessionList.listIterator();
            while(iterator.hasNext()){
                session=iterator.next();

                //判定session最后访问时间,和现在已经相差大于规定的时间s
                if (System.currentTimeMillis()-session.getLastAccessedTime()>TIME_SESSION_TO_INVALIDATE*1000){
                    //使得该session失效
                    session.invalidate();
                    //从sessionList集合中移除
                    iterator.remove();
                }
            }
        }
    }
}
