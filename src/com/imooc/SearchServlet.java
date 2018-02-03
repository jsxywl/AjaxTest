package com.imooc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static List<String> datas=new ArrayList<String>();
	static{
		datas.add("ajax");
		datas.add("ajax post");
		datas.add("becky");
		datas.add("bill");
		datas.add("james");
		datas.add("jerry");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//首先获得输入框的内容
		String keywords=request.getParameter("keyword");
		//获得关键字之后进行处理，得到关联数据
		List<String> listData=getData(keywords);
		//返回json格式
		response.getWriter().write(JSONArray.fromObject(listData).toString());
	}
	//得到关联数据的方法
	public List<String> getData(String keywords){
		List<String> list=new ArrayList<String>();
		for (String data : datas) {
			if(data.contains(keywords)){
				list.add(data);
			}
		}
		return list;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
