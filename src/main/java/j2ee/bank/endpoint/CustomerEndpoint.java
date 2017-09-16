package j2ee.bank.endpoint;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import j2ee.bank.entity.Customer;
import j2ee.bank.service.ICustomerService;

@Component
@Path("customer")
public class CustomerEndpoint {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerEndpoint.class);
	
	@Autowired
	private ICustomerService customerService;
	
	@GET
	@Path("/details")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response getArticleDetails() {
		List<Customer> customer = customerService.getAllCustomers();
		return Response.ok(customer).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response getCustomerById(@PathParam("id") Integer id) {
		Customer customer = customerService.getCustomerById(id);
		return Response.ok(customer).build();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Response addCustomer(Customer customer) {
		boolean isAdded = customerService.addCustomer(customer);
		if(!isAdded) {
			logger.info("Customer already exists.");
			return Response.status(Status.CONFLICT).build();
		}
		return Response.created(URI.create("/spring-app/customer/" + customer.getCustomerId())).build();
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Response updateCustomer(Customer customer) {
		customerService.updateCustomer(customer);
		return Response.ok(customer).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Response deleteCustomer(@PathParam("id") Integer id) {
		customerService.deleteCustomer(id);
		return Response.noContent().build();
	}
}
