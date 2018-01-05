package com.katey2658.web.controller;


import com.katey2658.web.service.SearchService;
import com.katey2658.web.service.impl.SearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 11456 on 2016/12/5.
 */
public class SearchHelperServlet extends HttpServlet {
    /**
     * 实现导航栏搜索功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数值
        String searchStr=req.getParameter("searchStr");
        //转码
        searchStr=new String(searchStr.getBytes("ISO8859-1"),"UTF-8");

        //创建一个搜索服务对象
        SearchService searchService=new SearchServiceImpl();

        //调用服务对象进行搜索

        //返回搜索结果集
    }
}
