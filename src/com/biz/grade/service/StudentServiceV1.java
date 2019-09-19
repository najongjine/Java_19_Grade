package com.biz.grade.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.biz.grade.domain.StudentVO;
import com.biz.grade.utill.StudentIDX;

public class StudentServiceV1 {
	private Map<String, StudentVO> stdList;

	public StudentServiceV1() {
		super();
		// TODO Auto-generated constructor stub
		stdList=new TreeMap<String,StudentVO>();
	}
	
	
	public Map<String, StudentVO> getStdList() {
		return stdList;
	}


	public void setStdList(Map<String, StudentVO> stdList) {
		this.stdList = stdList;
	}


	public void read(String stdFileName) throws Exception {
		FileReader fr=new FileReader(stdFileName);
		BufferedReader buffer=new BufferedReader(fr);
		
		String reader="";
		while(true) {
			reader=buffer.readLine();
			if(reader==null) break;
			String[] _str=reader.split(":");
			StudentVO stdVO=new StudentVO();
			stdVO.setNum(_str[StudentIDX.NUM]);
			stdVO.setName(_str[StudentIDX.NAME]);
			stdVO.setPhone(_str[StudentIDX.PHONE]);
			stdVO.setAddr(_str[StudentIDX.ADDR]);
			stdList.put(stdVO.getNum(), stdVO);

		}
		buffer.close();
		fr.close();
	}// end
	
	public void list() {
		/*
		 * map의 키 부분만 추출해서 리스트로 볼수 있도록 변환
		 */
		Set<String> stdNums=stdList.keySet();
		
		System.out.println("=========================================");
		System.out.println("학생병부");
		System.out.println("=========================================");
		System.out.println("학번\t이름\t전화번호\t주소");
		System.out.println("=========================================");
		for(String key:stdNums) {
			StudentVO vo=stdList.get(key);
			System.out.printf("%s\t",vo.getNum());
			System.out.printf("%s\t",vo.getName());
			System.out.printf("%s\t",vo.getPhone());
			System.out.printf("%s\n",vo.getAddr());
		}
		System.out.println("=========================================");
	}// end
	
	public StudentVO getStudent(String num) {
		return stdList.get(num);
	}
}
