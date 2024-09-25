package com.example.Practice.RateLimiter.Strategy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EvictionStategy {

    public boolean isAllowed(List<Long> timeStamps, int quota) {
        long now = System.currentTimeMillis();

        int i=0;
        for(i=0;i<timeStamps.size();i++) {
            int diff = (int) TimeUnit.MILLISECONDS.toSeconds(now - timeStamps.get(i));
            if(diff<60) {
                break;
            }
        }

        while(i-->0) {
            timeStamps.remove(0);
        }

        return timeStamps.size()<quota;
    }

}
