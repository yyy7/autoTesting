package com.katey2658.web.dao;

import com.katey2658.web.entity.Score;

import java.util.Collection;

/**
 * Created by 11456 on 2016/12/11.
 */
public interface ScoreDao {

    /**
     * 通过学号来查询参加过的考试的成绩
     * @param userId
     * @return
     */
    public Collection<Score> findScoresByStuId(String userId);

    /**
     * 添加一门考试的考试成绩情况
     * @param score
     */
    public boolean addScore(Score score);
}
