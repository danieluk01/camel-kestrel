package kong.daniel.integration;

import org.apache.camel.Produce;

public class Producer {
	
	@Produce(uri = "direct://pojo/asyn")
	private OneWaySender asynSender;
	
	@Produce(uri = "direct://pojo/syn")
	private Sender synSender;
	
	public void produce(String body){
		asynSender.send(body);
	}
	
	public String call(String body){
		return synSender.send(body);
	}
	
}
