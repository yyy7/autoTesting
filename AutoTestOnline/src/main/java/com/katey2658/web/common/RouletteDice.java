package com.katey2658.web.common;

import com.katey2658.web.entity.Question;

import java.util.Vector;

/**
 * Created by 11456 on 2016/12/21.
 */
class RouletteDice extends Liziqun implements Runnable{

    int randomNum;
    public RouletteDice(int randomNum){

        this.randomNum=randomNum;
    }
    private static synchronized Vector<Question> printNum(int randomNum){
        for(int i=0;i<temp.size();i++){

            account+=temp.get(i).getQuesWeight();
            //当前给定的随机数，必须小于等于该随机数所对应的权重数组的值以及它前面所有值的累加
            if(randomNum<=account){
                System.out.println(temp.get(i).getQuesId()+" "+temp.get(i).getQuesContent() );
                output.add(temp.get(i));
                temp.remove(i);
                break;
            }
        }
        return output;
    }
    public void run() {
        printNum(randomNum);
    }
}
