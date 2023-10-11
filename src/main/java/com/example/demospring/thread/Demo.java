package com.example.demospring.thread;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// tesst master
@Log4j2
public class Demo {
    private static final List<String> USERNAMES = new ArrayList<>();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);
    private static final ExecutorService executorService2 = Executors.newFixedThreadPool(2);
    private static final List<String> USERNAMES_DELAY = new ArrayList<>();
    private static final List<String> USERNAMES_PROCESSING = new ArrayList<>();

    static {
        USERNAMES.add("Hieu");
        USERNAMES.add("Hieu");
        USERNAMES.add("Hang");
        USERNAMES.add("Hung");
    }

    public static void main(String[] args) {
        int size = USERNAMES.size();
        int i = 0;
        while(i< size){
            String username = USERNAMES.get(i);
            putout(username);
            i++;
        }
    }

    public static void putout(String username){
        log.info("(putout): {}", username);
        if(USERNAMES_PROCESSING.contains(username)){
            add_to_delay(username);
            return;
        }
        USERNAMES_PROCESSING.add(username);
        executorService.execute(() ->{
            doProcessing(username);
            USERNAMES_PROCESSING.remove(username);
            doProcessingDelay(username);
        });
    }

    private static void doProcessingDelay(String username) {
        if(USERNAMES_DELAY.contains(username)){
            executorService2.execute(() ->{
                doProcessing(username);
                USERNAMES_DELAY.remove(username);
                doProcessingDelay(username);
            });
        }
    }

    private static void doProcessing(String username) {
        log.info("(process) start process: {}", username);
        try{
            //TODO
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
            //to do
        }
        log.info("(process) end process: {}", username);
    }

    private static void add_to_delay(String username) {
        // to do
        USERNAMES_DELAY.add(username);
        log.info("(add_to_delay) add: {}", username);
    }
}
