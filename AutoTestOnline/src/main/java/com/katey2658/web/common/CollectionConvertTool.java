package com.katey2658.web.common;

import java.util.*;

/**
 *
 * 关于集合的工具类
 * Created by 11456 on 2016/12/20.
 */
public class CollectionConvertTool {

    /**
     * 将集合变成字符串
     * @param collection
     * @return
     */
    public static String CollectionConvertToString(Collection<?> collection){
        StringBuilder stringBuilder=new StringBuilder("");
        for (Object object:collection){
            stringBuilder.append(object.toString()+";");
        }
        String s=stringBuilder.toString();
        s=s.substring(0,s.length()-1);
        return s;
    }


    /**
     * 将用；分隔的字符串变成集合
     * @param string
     * @return
     */
    public static Collection<String> StringConvertToCollection(String string){

        Collection<String>  collection=new ArrayList<>();
        if (string.contains(";")){
            String[] s=string.trim().split(";");
            for (String sd:s){
                collection.add(sd);
            }
        }
        return collection;
    }

    /**
     * 将一个Map集合变成字符串
     * @param map
     * @return
     */
    public static String mapConvertToString(Map map){
        java.util.Map.Entry entry;
        StringBuffer sb = new StringBuffer();
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            entry = (java.util.Map.Entry)iterator.next();
            sb.append(entry.getKey().toString()).append( "," ).append(null==entry.getValue()?"":
                    entry.getValue().toString()).append (iterator.hasNext() ? ";" : "");
        }
        return sb.toString();
    }

    /**
     * 将规范字符串变成Map集合(写的不安全*******)
     * @param string
     * @return
     */
    public static Map<Integer,Integer>  stringConvertZToMap(String string){
        Map<Integer,Integer> map=new HashMap<>();
        String[] ms=string.trim().split(";");
        for (int i=0;i<ms.length;i++){
            String[] items=ms[i].split(",");
            map.put(Integer.parseInt(items[0]),Integer.parseInt(items[1]));
        }
        return map;
    }
}
