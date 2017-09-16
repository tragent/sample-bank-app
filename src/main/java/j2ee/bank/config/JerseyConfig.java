package j2ee.bank.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import j2ee.bank.endpoint.CustomerEndpoint;

@Component
@ApplicationPath("/bank")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(CustomerEndpoint.class);
	}
}
