package com.biz.grade.service;

import java.util.Map;
import java.util.Set;

import com.biz.grade.domain.ScoreVO;
import com.biz.grade.domain.StudentVO;
import com.biz.grade.utill.LineMake;

public class GradeServiceV1 {
	private Map<String, StudentVO> stdList;
	private Map<String, ScoreVO> scList;
	
	public GradeServiceV1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GradeServiceV1(Map<String, ScoreVO> scList) {
		super();
		this.scList = scList;
	}
	public GradeServiceV1(Map<String, StudentVO> stdList, Map<String, ScoreVO> scList) {
		super();
		this.stdList = stdList;
		this.scList = scList;
	}
	public Map<String, StudentVO> getStdList() {
		return stdList;
	}
	public void setStdList(Map<String, StudentVO> stdList) {
		this.stdList = stdList;
	}
	public Map<String, ScoreVO> getScList() {
		return scList;
	}
	public void setScList(Map<String, ScoreVO> scList) {
		this.scList = scList;
	}
	@Override
	public String toString() {
		return "GradeServiceV1 [stdList=" + stdList + ", scList=" + scList + "]";
	}
	
	public void list() {
		System.out.println(LineMake.make("=",80));
		System.out.println("성적표");
		System.out.println(LineMake.make("=",80));
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
		System.out.println(LineMake.make("=",80));
		Set<String> scKeys=scList.keySet();
		
		for(String key:scKeys) {
			ScoreVO scVO=scList.get(key);
			StudentVO stVO=stdList.get(scVO.getNum());
			System.out.printf("%s\t",scVO.getNum());
			System.out.printf("%s\t",stVO.getName());
			System.out.printf("%4d\t",scVO.getKorScore());
			System.out.printf("%4d\t",scVO.getEngScore());
			System.out.printf("%4d\t",scVO.getMathScore());
			System.out.printf("%4d\t",scVO.getSumScore());
			System.out.printf("%5.2f\t",scVO.getAvg());
			System.out.printf("%4d\n",scVO.getRank());
		}
		System.out.println(LineMake.make("=",80));
	}
}
