package org.example;

import org.example.Judge.IntegerSubmissionConsumer;
import org.example.Judge.SubmissionConsumer;
import org.example.SimpleMQ.SimpleMQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Random rand = new Random();
        List<Integer> staticRandomMessageList = new ArrayList<>();

        for(int i = 0;i<10;i++){
            staticRandomMessageList.add(rand.nextInt());
        }

        SimpleMQ mySimpleMQ = new SimpleMQ(staticRandomMessageList);

        SubmissionConsumer intgerJudge = new IntegerSubmissionConsumer();

        mySimpleMQ.RegisterConsumer("integerJudge", intgerJudge);

        mySimpleMQ.Start();


    }
}
