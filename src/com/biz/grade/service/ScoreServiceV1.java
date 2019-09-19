package com.biz.grade.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.biz.grade.domain.ScoreVO;
import com.biz.grade.utill.ScoreIDX;

public class ScoreServiceV1 {
	private Map<String, ScoreVO> scList;

	public ScoreServiceV1() {
		super();
		// TODO Auto-generated constructor stub
		scList=new HashMap<String, ScoreVO>();
	}
	
	
	
	public Map<String, ScoreVO> getScList() {
		return scList;
	}



	public void setScList(Map<String, ScoreVO> scList) {
		this.scList = scList;
	}



	public void read(String scoreFileName) throws Exception {
		FileReader fr=new FileReader(scoreFileName);
		BufferedReader buffer=new BufferedReader(fr);
		
		while(true) {
			String _strBuffer=buffer.readLine();
			if(_strBuffer==null) break;
			String[] _str=_strBuffer.split(":");
			ScoreVO vo=new ScoreVO();
			try {
				vo.setNum(_str[ScoreIDX.NUM]);
				vo.setKorScore(Integer.valueOf(_str[ScoreIDX.KOR]));
				vo.setEngScore(Integer.valueOf(_str[ScoreIDX.ENG]));
				vo.setMathScore(Integer.valueOf(_str[ScoreIDX.MATH]));
				vo.setSumScore(Integer.valueOf(_str[ScoreIDX.MATH])+Integer.valueOf(_str[ScoreIDX.ENG])+Integer.valueOf(_str[ScoreIDX.KOR]));
				vo.setAvg((float)vo.getSumScore()/3);
				scList.put(_str[ScoreIDX.NUM], vo);
			} catch (Exception e) {
				System.out.println(_str[ScoreIDX.NUM]+"학생 데이터가 잘못됬음");
				break;
			}
		}
		buffer.close();
		fr.close();
		rank();
	}// end
	
	/*
	 * 1. Map의 전체를 추철하여 list로 변환
	 * 2. list를 정렬
	 * 3.다시 list를 map에 업뎃
	 */
	public void rank() {
		//Map<String,ScoreVO> type으로 데이터를 가지고 있는 scList값을 
		//List type인 sortList로 변환하는 방법
		//List<general>: List가 어떤 type의 데이터들을 가지고 있을것인가를 명시.
		/*
		 * Map형태를 List로 변환시킬때는 List<Map.Entry<>> 형태로 선언을 해 주어야 한다.
		 */
		List<Map.Entry<String,ScoreVO>> sortList=new LinkedList<Map.Entry<String,ScoreVO>>(scList.entrySet());
		Collections.sort(sortList, new Comparator<Map.Entry<String, ScoreVO>>() {

			@Override
			public int compare(Entry<String, ScoreVO> o1, Entry<String, ScoreVO> o2) {
				/*
				 * o2.getValue()
				 * List형태로 바뀐 Map에서 VO를 추출하는 method.
				 */
				return o2.getValue().getSumScore()- o1.getValue().getSumScore();
			}
		});
		
		int rank=0;
		for(Map.Entry<String, ScoreVO> vo:sortList) {
			//ScoreVO vo=sortList.getValue();
			vo.getValue().setRank(++rank);
		}
		
	}// end
	
	public void list() {
		System.out.println("=========================================");
		System.out.println("성적표");
		System.out.println("==========================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t석차");
		System.out.println("===========================================");
		Set<String> nums=scList.keySet();
		
		for(String key:nums) {
			ScoreVO vo=scList.get(key);
			System.out.printf("%s\t",vo.getNum());
			System.out.printf("%d\t",vo.getKorScore());
			System.out.printf("%d\t",vo.getEngScore());
			System.out.printf("%d\t",vo.getMathScore());
			System.out.printf("%d\t",vo.getSumScore());
			System.out.printf("%5.2f\t",vo.getAvg());
			System.out.printf("%d\n",vo.getRank());
		}
		System.out.println("============================================");
	}
}
