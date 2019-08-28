package com.rabbit.exercise;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, TimeoutException
    {
        //Send.send();
        //Recv.recv();
    	//NewTask.newTask(args);
    	//Worker.worker(args);
    	EmitLog.emitLog(args);
    	ReceiveLogs.receiveLogs(args);
    }
}
