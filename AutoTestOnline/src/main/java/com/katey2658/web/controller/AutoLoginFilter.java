package com.katey2658.web.controller;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @Description  处理用户自动登录的过滤器
 * Created by 11456 on 2016/11/23.
 */
public class AutoLoginFilter implements Filter {

    private Vector<String> excludePages;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludePages=new Vector<>();
        Enumeration<String> names=filterConfig.getInitParameterNames();

        String page=null;
        while (names.hasMoreElements()){
            page=names.nextElement();
            excludePages.add(filterConfig.getInitParameter(page));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        //获取请求和响应对象
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;



        String page=null;
        String uri=request.getRequestURI();
        if ((uri!=null)&&(!uri.isEmpty())){
            page=uri.substring(uri.lastIndexOf('/')+1);

            //如果是规定放行页面的话也是放行
            if (excludePages.contains(page)) {
                filterChain.doFilter(request,response);
                return;
            }
        }

        //如果已经登录，就直接放行
        if (request.getSession().getAttribute("user")!=null){
            filterChain.doFilter(request,response);
            return;
        }

        /*
        //检验cookie
        //@userName用户名  @userPwd 密码
        String userId=null;
        String userPwd=null;
        //获取用户请求中的cookie,然后获取用户名和密码
        Cookie[] cookies=request.getCookies();
        for (Cookie cookie:cookies){
            if (cookie!=null&&cookie.getName().endsWith("userid")){
                userId=cookie.getValue();
            }else if(cookie!=null&&cookie.getName().endsWith("userpwd")){
                userPwd=cookie.getValue();
            }
        }
        //如用户名和密码都不为空，就检验账号密码
        if(userId!=null&&userPwd!=null){
            //获取用户服务对象
            UserService userService=new UserServiceImpl();
            //检验账号是否存在，存在就获取对象信息放到session中,然后放行
            if(userService.signIn(userId, StringEncryption.getEncryptionString(userPwd))==0){
                User user=userService.findUserById(userId);

                filterChain.doFilter(request,response);
            }
        }
        */

        //用户还没有登录，交给login.jsp处理
        //request.setAttribute("page",page);
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    public void destroy() {
    }



}
