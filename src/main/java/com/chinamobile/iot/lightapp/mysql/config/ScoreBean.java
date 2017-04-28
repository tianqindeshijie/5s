package com.chinamobile.iot.lightapp.mysql.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Nate on 2017/4/26.
 */

public class ScoreBean {

    public int priority;
    public int score;
    public String itemId;




    public static int compute5SScore(ArrayList<ScoreBean> scorelist) {

        int score = 0;

        Collections.sort(scorelist, new Comparator<ScoreBean>() {
            @Override
            public int compare(ScoreBean lhs, ScoreBean rhs) {
                if(lhs.priority < rhs.priority)
                    return -1;
                else if(lhs.priority > rhs.priority) {
                    return 1;
                } else
                    return 0;
            }
        });

        for(int i = 0; i < scorelist.size(); i++) {
            int s = scorelist.get(i).score;
            if(s < 5)
                break;
            else
                score ++;
        }
        System.out.println(scorelist);
        return score;
    }

    @Override
    public String toString() {
        return "ScoreBean{" +
                "score=" + score +
                ", priority=" + priority +
                '}';
    }
}
