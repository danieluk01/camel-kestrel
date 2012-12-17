package kong.daniel.integration;

import org.apache.camel.InOnly;

public interface OneWaySender {
	
	@InOnly
	void send(String body);
	
}
