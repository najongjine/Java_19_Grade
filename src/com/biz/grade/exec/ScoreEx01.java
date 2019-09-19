package com.biz.grade.exec;

import com.biz.grade.service.ScoreServiceV1;

public class ScoreEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScoreServiceV1 scs=new ScoreServiceV1();
		String scoreFileName="src/com/biz/grade/score.txt";
		try {
			scs.read(scoreFileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scs.list();

	}

}
