package kong.daniel.integration;

public class Consumer {
	
	public void onMessage(String body){
		
		//do things for the message body
		
		//for demo just print it out
		System.out.println(Thread.currentThread().getName()+"-Message received: "+body);
	}

}
