package com.katey2658.web.common;

import com.katey2658.web.entity.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 11456 on 2016/12/10.
 */
public class Canshu {

    public Canshu()
    {

    }
    Canshu(int id,String content,int diffcult,int score,double same,int weight)
    {
        this.id =id;
        this.content=content;
        this.diffcult=diffcult;
        this.score = score;
        this.same = same;
        this.weight = weight;

    }

    private double same = 0;

    public double getSame() {
        return same;
    }
    public void setSame(double same) {
        this.same = same;
    }
    private int id =0;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private String content = "";

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    private int diffcult=0;

    public int getDiffcult() {
        return diffcult;
    }
    public void setDiffcult(int diffcult) {
        this.diffcult = diffcult;
    }
    private int score = 0;
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    private int weight;

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}

