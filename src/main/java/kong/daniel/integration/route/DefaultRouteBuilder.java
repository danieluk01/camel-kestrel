package kong.daniel.integration.route;

import kong.daniel.integration.Consumer;

import org.apache.camel.builder.RouteBuilder;

public class DefaultRouteBuilder extends RouteBuilder{
	
	private Consumer consumer;
	
	public DefaultRouteBuilder(Consumer consumer){
		this.consumer = consumer;
	}
	
	public void setConsumer(Consumer consumer){
		this.consumer = consumer;
	}

	@Override
	public void configure() throws Exception {

		from("direct://pojo/asyn").
			to("kestrel://localhost:22133/demo");
		
		from("direct://pojo/syn").
			to("kestrel://localhost:22133/demo");

		from("kestrel://localhost:22133/demo?concurrentConsumers=10&waitTimeMs=500").
			bean(consumer);

	}
	
}
