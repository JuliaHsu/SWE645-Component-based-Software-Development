package com.main;

import java.util.List;

import com.entity.Survey;
import com.restful.*;

public class MainTest {
	public static void main(String[] args) {
		System.out.print("test");
		SurveyResource test = new SurveyResource();
		List<Survey> surveyList = test.findAll();
		for(Survey temp : surveyList) {
			System.out.printf("%s \n",temp.getInfo());
		}
//		test.createSurvey("test22", "test3", "test2");
	}
}
