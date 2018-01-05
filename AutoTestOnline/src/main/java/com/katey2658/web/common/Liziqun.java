package com.katey2658.web.common;

import com.katey2658.web.entity.Question;

import java.util.*;

/**
 * Created by 11456 on 2016/12/21.
 */
class Liziqun {
    public final int step=10000; //迭代次数
    public int PosNum; //粒子数
    public final double w=0.9;//惯性权重
    public final double c1=2;//局部权重参数
    public final double c2=2;//全局权重参数
    public static int g_best; //全局最优解
    public static int sum;
    public ArrayList<String> arr =new ArrayList<String>();
    //把界面传进来的知识点参数放到ArrayList中
    public Map<Integer, Integer> map =new HashMap<Integer, Integer>();
    public static int account;//轮盘赌总分变量
    public int[] p_best;;//粒子本身历史最优解
    public int[] p_v;;//粒子速度
    public int[] p_pos;//粒子位置
    public static Vector<Question> vec = new Vector<Question>();
    public static Vector<Question> temp = new Vector<Question>();
    public static Vector<Question> list = new Vector<Question>();
    public static Vector<Question> addmap = new Vector<Question>();
    public static Vector<Question> output = new Vector<Question>();
    public Random random = new Random();


    //根据知识点筛选出部分
    public Map<Integer, Integer> addmap(int diff,int percent,Map<Integer, Integer> map)
    {
        map.put(diff, percent);
        return map;

    }
    public Vector<Question> choosediff(Map<Integer, Integer> map){
        for(int i=0;i<list.size();i++)
        {
            for(int j:map.keySet()){
                if(list.get(i).getDiffDegree()==j) //非指定难度系数部分删掉
                {
                    addmap.add(list.get(i));
                }
                else continue;
            }
        }
        return addmap;

    }
    public void dosearch(){
        int num = addmap.size();
        for(int i=0;i<num;i++)
        {
            Initialize();
            Search();
        }
    }
    public ArrayList<String> addarr(String s1,ArrayList<String> arr){
        arr.add(s1);
        return arr;
    }
    public Vector<Question> point(ArrayList<String> arr)
    {
        for(int i=0;i<vec.size();i++)
        {
            for(String sr:arr){
                if(vec.get(i).getTestPoint().equals(sr)) //非选中知识点部分删掉
                {
                    list.add(vec.get(i));
                }
                else continue;
            }
        }
        return list;
    }

    public void Initialize()
    {
        for(int i=0;i<addmap.size();i++)
        {
            Random rd = new Random();
            int n = rd.nextInt(addmap.size());
            p_pos[i]=n;
            p_v[i]=p_best[i]=p_pos[i];
            if(g_best<=addmap.size()) g_best=0; //防止数组越界

            if(1-function(g_best)>1-function(p_best[i]))
            {
                g_best=p_best[i];
            }
        }
    }
    public Vector<Question> Search()
    {
        for(int j=0;j<step;j++)  //迭代
        {
            for(int i=0;i<addmap.size();i++)  //更新
            {
                p_v[i]=(int) (w*p_v[i]+c1*random.nextDouble()*(p_best[i]-p_pos[i])+c2*random.nextDouble()*(g_best-p_pos[i]));
                if(0<(p_pos[i]+p_v[i])&&(p_pos[i]+p_v[i])<addmap.size())
                    p_pos[i]+=p_v[i];
                if(1-function(p_best[i])>1-function(p_pos[i]))
                {
                    p_best[i]=p_pos[i];
                }
                if(1-function(g_best)>1-function(p_best[i]))
                {
                    g_best=p_best[i];
                }

            }
        }
        temp.add(addmap.get(g_best));
        addmap.remove(g_best);
        return temp;
    }

    public double function(int x)
    {
        return addmap.get(x).getSameDegree();
    }

    /**
     * 添加数据
     * @param questions
     */
    public void setData(Collection<Question> questions){
        for (Question question:questions){
            vec.add(question);
        }

        this.PosNum=vec.size();
        this.p_best=new int[PosNum];
        this.p_v=new int[PosNum];
        this.p_pos=new int[PosNum];
    }

}
