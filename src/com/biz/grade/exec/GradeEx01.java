package com.biz.grade.exec;

import java.util.Map;

import com.biz.grade.domain.ScoreVO;
import com.biz.grade.domain.StudentVO;
import com.biz.grade.service.GradeServiceV1;
import com.biz.grade.service.ScoreServiceV1;
import com.biz.grade.service.StudentServiceV1;

public class GradeEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentServiceV1 stService=new StudentServiceV1();
		ScoreServiceV1 scService=new ScoreServiceV1();
		String stdFileName="src/com/biz/grade/학생명부.txt";
		String scoreFileName="src/com/biz/grade/score.txt";
		try {
			stService.read(stdFileName);
			scService.read(scoreFileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,ScoreVO> scList=scService.getScList();
		Map<String,StudentVO> stdList=stService.getStdList();
		
		GradeServiceV1 gs=new GradeServiceV1();
		gs=new GradeServiceV1(scList);
		gs=new GradeServiceV1(stdList,scList);
		gs.list();
	}

}
