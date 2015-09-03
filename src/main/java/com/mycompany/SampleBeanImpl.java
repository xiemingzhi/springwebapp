/**
 * 
 */
package com.mycompany;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ming
 *
 */
@Component
public class SampleBeanImpl implements SampleBean {
	@Autowired
    FacebookLookupService facebookLookupService;
	
    @Async
    public void doSomething(){
    	// Start the clock
        long start = System.currentTimeMillis();
        
    	// Kick of multiple, asynchronous lookups
        Future<Page> page1 = null;
        Future<Page> page2 = null;
        Future<Page> page3 = null;
		try {
			page1 = facebookLookupService.findPage("PivotalSoftware");
		    page2 = facebookLookupService.findPage("CloudFoundry");
	        page3 = facebookLookupService.findPage("SpringFramework");
	     // Wait until they are all done
	        while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
	            Thread.sleep(10); //10-millisecond pause between each check
	        }

	        // Print results, including elapsed time
	        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
	        System.out.println(page1.get());
	        System.out.println(page2.get());
	        System.out.println(page3.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        
    }

}
