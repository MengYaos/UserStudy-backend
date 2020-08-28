package com.firsts.survey.constant;

public class GoalVerifyRegex {

    public static final String GOAL_REGEX=  "^bai[0-9|10]*$";

    public static final String GOAL_MSG= "各项分数应属于[0,10]";
    public static final String SEQUENCE_MSG= "效果图序列中存在重复";
    public static final String SEQUENCE_INDEX_MSG= "效果图序列下标越界";

    public static final Integer COUNT = 3;
}
