package com.biz.grade.exec;

import com.biz.grade.domain.StudentVO;
import com.biz.grade.service.StudentServiceV1;

public class StudentEx01 {

	public static void main(String[] args) {
		StudentServiceV1 ss=new StudentServiceV1();
		String stdFileName="src/com/biz/grade/학생명부.txt";
		
		try {
			ss.read(stdFileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StudentVO vo=ss.getStudent("A010");
		if(vo!=null) {//키 값이 없으면 null 리턴
			System.out.println(vo.toString());
		}else {
			System.out.println("학생 없음");
		}
		System.out.println(ss.getStudent("A005").toString());
	}

}
