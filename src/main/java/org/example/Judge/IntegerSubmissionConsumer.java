package org.example.Judge;

public class IntegerSubmissionConsumer extends SubmissionConsumer{
     void ACK(Integer msg){
         System.out.println("JUDGE: Positive ACK for message: "+msg);
     }
     void NACK(Integer msg){
         System.out.println("JUDGE: Negative ACK for message: "+ msg);
     }
     boolean Process(Integer msg){
         int fail = msg % 2;
         if (fail == 0) {
             System.out.println("JUDGE failed to process message: "+msg);
             return false;
         }else {
             System.out.println("JUDGE successfully processed message: "+msg);
             return true;
         }

     }
}
