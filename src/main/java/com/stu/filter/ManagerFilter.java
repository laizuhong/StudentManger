package com.stu.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 *
 * Created by laizuhong on 2016/7/25.
 */
public class ManagerFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    public void destroy() {

    }

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response,
//                         FilterChain chain) throws IOException, ServletException {
//        // TODO Auto-generated method stub
//        HttpServletRequest req = (HttpServletRequest) request ;
//        HttpServletResponse res = (HttpServletResponse) response;
//        HttpSession session = req.getSession();
//
//        String contextPath = req.getContentType();
//
//		/*if( session.isNew() || session.getAttribute(Constants.SESSION_USER) == null )
//		{
//			User user = (User)session.getAttribute(Constants.SESSION_USER);
//
//			if( !( user instanceof Administrator ))
//			{
//
//
//				res.sendRedirect("http://localhost:8080/Shop/login.jsp");
//
//				System.out.println(contextPath+"/login.jsp" );
//
//				return;
//			}
//		}*/
//
//        if( session.isNew() || session.getAttribute(Constants.SESSION_USER) == null )
//        {
//
//            res.sendRedirect("http://localhost:8080/Shop/login.jsp");
//
//            System.out.println(contextPath+"/login.jsp" );
//
//            return;
//
//        }
//
//
//        else if( session.getAttribute(Constants.SESSION_USER) != null)
//        {
//
//            User user = (User)session.getAttribute(Constants.SESSION_USER);
//
//            //System.out.println( ( user instanceof Administrator ) );
//
//            //if( ( user instanceof Administrator ))
//
//            System.out.println( user.getName() );
//
//            //拦截器bug修改 一直进不了后台界面 2014、8、18
//
//            //if( (user.equals("throne212")))
//
//            //拦截器bug修改 一直进不了后台界面 2014、8、30, 忘了getName 比较
//
//            //if( (user.getName().equals("throne212")) == false  )
//
//            //2014.9.1  修改拦截器bug  如果不是 Administrator,就拦截
//
//            if ( ( user instanceof Administrator ) == false )
//            {
//
//
//                res.sendRedirect("http://localhost:8080/Shop/login.jsp");
//
//                System.out.println(contextPath+"/login.jsp" );
//
//                return;
//            }
//
//        }
//
//
//
//
//        chain.doFilter(request, response);
//
//
//
//    }
//
//    @Override
//    public void destroy() {
//        // TODO Auto-generated method stub
//
//    }

}
