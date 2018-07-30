package com.app.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

	List<String> noCkeckUris=null;

	@Override
	public void init(FilterConfig fc) throws ServletException {
		noCkeckUris=new ArrayList<String>();
		String uris=fc.getInitParameter("avoidUris");
		StringTokenizer str=new StringTokenizer(uris, ",");

		while(str.hasMoreTokens()){
			noCkeckUris.add(str.nextToken());
		}

	}

	@Override
	public void doFilter(
			ServletRequest request, 
			ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		try {
			HttpServletRequest req=(HttpServletRequest) request;
			HttpServletResponse res=(HttpServletResponse) response;

			//clear cache
			res.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
			res.setHeader("Pragma","no-cache");	
			res.setDateHeader("Expires", 0);

			//read request URI
			String reqUri=req.getRequestURI();
			//check with above list
			if(!noCkeckUris.contains(reqUri)){
				//if not in list do session check

				//read current session
				HttpSession ses= req.getSession(false);
				if(ses==null || ses.getAttribute("un")==null){
					res.sendRedirect(req.getContextPath()+"/mvc/login");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//else goto same request
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
