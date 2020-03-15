package org.example.SimpleMQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleMQ {
    private List<Integer> messageList;
    private Map<String, IntegerConsumer> consumerMap;
    public SimpleMQ(List<Integer> messageList) {
        this.messageList = messageList;
        consumerMap = new HashMap<String, IntegerConsumer>();
    }

    public void RegisterConsumer(String name,IntegerConsumer consumer) {
        consumerMap.put(name, consumer);
    }

    public void Start()  {
        if (messageList == null) {
            messageList = new ArrayList<Integer>();
            for (int i = 0;i<100;i++) messageList.add(i);
        }
        System.out.println("MQ service starting!!! Current Queue Size: "+messageList.size());


        messageList.forEach(msg -> {
            consumerMap.forEach((name, callback)->callback.ConsumeInteger(msg));
        });
    }




}
