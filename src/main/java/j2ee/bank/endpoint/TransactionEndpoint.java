package j2ee.bank.endpoint;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import j2ee.bank.entity.Transaction;
import j2ee.bank.service.ITransactionService;

@Component
@Path("transactions")
public class TransactionEndpoint {
	
	@Autowired
	private ITransactionService transactionService;

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response getStatementsByUsername(@PathParam("username") String username) {
		List<Transaction> statements = transactionService.getAllTransactionsByUsername(username);
		return Response.ok(statements).build();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Response transferMoney(Transaction transaction) {
		transactionService.addTransaction(transaction);
		return Response.created(URI.create("/bank/transactions/" + transaction.getTransactionId())).build();
		
	}
	
}
