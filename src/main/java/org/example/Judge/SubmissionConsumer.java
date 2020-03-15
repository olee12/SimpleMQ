package org.example.Judge;

import org.example.SimpleMQ.IntegerConsumer;

public abstract class SubmissionConsumer implements IntegerConsumer {
    abstract void ACK(Integer msg);
    abstract void NACK(Integer msg);
    abstract boolean Process(Integer msg);
    @Override
    public void ConsumeInteger(Integer intMsg) {
        System.out.println("SubmissionConsumer abstract class: just consume message: msgID"+intMsg);
        boolean successful = Process(intMsg);
        if (successful) {
            System.out.println("SubmissionConsumer abstract class: message successfully processed: msgID"+ intMsg);
            ACK(intMsg);
        }else {
            System.out.println("[ERROR] SubmissionConsumer abstract class: message successfully processed: msgID"+ intMsg);
            NACK(intMsg);
        }
    }
}
