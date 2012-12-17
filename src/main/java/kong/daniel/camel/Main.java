package kong.daniel.camel;

import kong.daniel.integration.Producer;
import kong.daniel.integration.exception.CamleContainerException;

import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private SpringCamelContext container;
	
	public Main(){
		container = new SpringCamelContext(new ClassPathXmlApplicationContext("camel_context.xml"));
		try{
			container.start();
		}catch(Exception cause){
			throw new CamleContainerException("Error happened during initiate the camel routes!", cause);
		}		
	}
	
	public Object getBean(String name){
		return container.getRegistry().lookup(name);
	}
	
	public static void main (String [] args) throws Exception{
		Main demo = new Main();
		Producer producer = (Producer) demo.getBean("producer");
		System.out.println("Send 10 synchronized messages.");
		for(int i=0; i<10; i++){
			String response = producer.call("synchronized message-"+i);
			System.out.println(Thread.currentThread().getName()+"-response for synchronized message-"+i+" is:"+response);
		}
		System.out.println("Send 30 asynchronized messages.");
		for(int i=0; i<30; i++){
			producer.produce("asynchronized message-"+i);
		}
		Thread.sleep(3000);		
	}
		
}
