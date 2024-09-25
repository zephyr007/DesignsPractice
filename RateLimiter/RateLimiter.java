package com.example.Practice.RateLimiter;

import com.example.Practice.RateLimiter.Strategy.EvictionStategy;
import com.example.Practice.RateLimiter.models.Clients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {

    //Thread Safety
    Map<Clients, List<Long>> clientMap;
    int quota;
    EvictionStategy evictionStategy;

    public RateLimiter(int quota) {
        clientMap = new ConcurrentHashMap<Clients, List<Long>>();
        this.quota = quota;
        evictionStategy = new EvictionStategy();
    }

    public Boolean isAllowed(Clients client) {
        if(!clientMap.containsKey(client)) {
            var list = new ArrayList<Long>();
            list.add(System.currentTimeMillis());
            clientMap.put(client, list);
            System.out.println(client.toString()+" is Allowed");
            return true;
        }

        if(evictionStategy.isAllowed(clientMap.get(client), quota)) {
            //update the list
            var list = clientMap.getOrDefault(client, new ArrayList<>());
            list.add(System.currentTimeMillis());
            clientMap.put(client, list);

            System.out.println(client.toString()+" is Allowed");
            return true;
        }

        System.out.println(client.toString()+" Rate Limited");
        return false;
    }

}
