package com.leetcode.sort;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

import com.alibaba.fastjson.JSON;

public class SortField {
	
	public static void main(String[] args) throws Exception {
		Student stu = new Student();
		stu.setAddress("asd");
		stu.setAge(13);
		stu.setName("zhoux");
		
		Field[] fields = stu.getClass().getDeclaredFields();
		//生成列表
		ArrayList<String> list = new ArrayList<>();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object obj = field.get(stu);
				if(null!=obj)
					list.add(field.getName());
			} catch (Exception e) {
				throw new Exception();
			} 
		}
		System.out.println(JSON.toJSON(list));
		//对List列表的值进行排序
		Collections.sort(list);
		Class stuClass = stu.getClass();
		for (String str : list) {
			try {
				String methodName = "get"+str.substring(0,1).toUpperCase()+str.substring(1);
				Method method = stuClass.getMethod(methodName);
				Object obj=method.invoke(stu);
				System.out.println("fileName="+str+"; methodName="+methodName+"; value="+obj.toString());
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(JSON.toJSON(list));
	}
}
