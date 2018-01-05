package com.katey2658.web.common;

import com.katey2658.web.entity.Question;

import java.util.*;

/**
 * Created by 11456 on 2016/12/21.
 */
public class PSOAlgo {

    /**
     * 算法构造器
     * @param questions
     */
    public PSOAlgo(Collection<Question> questions){
        this.questions=questions;
    }

    /**
     * 题目源
     */
    private Collection<Question> questions;

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    /**
     * 根据需要的考试点和考试难度所占百分比来
     * @param diffcutyPercent
     * @param testPoints
     * @return
     */
    public Collection<Question> getQuestions(Map<Integer,Integer> diffcutyPercent, Collection<String> testPoints){
        Liziqun pos=new Liziqun();
        pos.setData(questions);
        for (String s:testPoints){
            pos.addarr(s,pos.arr);
        }

        Set<Integer> keySet=diffcutyPercent.keySet();
        for (Integer key:keySet){
            pos.addmap(key,diffcutyPercent.get(key),pos.map);
        }
        pos.point(pos.arr);
        pos.choosediff(pos.map);
        pos.dosearch();

        Random r=new Random();
        for(int j:pos.map.keySet()){
            for(int i =0 ;i<pos.map.get(j)/10 ;i++)
            {
                int n=r.nextInt(50);
                RouletteDice rd=new RouletteDice(n);
                Thread t=new Thread(rd);
                t.start();
            }
        }

        //最后的结果集
        Vector<Question> resultQuestions=Liziqun.output;

        return  resultQuestions;
    };

}
