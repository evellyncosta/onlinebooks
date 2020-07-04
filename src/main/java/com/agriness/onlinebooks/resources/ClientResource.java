package com.agriness.onlinebooks.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.agriness.onlinebooks.model.Book;
import com.agriness.onlinebooks.model.Client;
import com.agriness.onlinebooks.model.Reservation;
import com.agriness.onlinebooks.repository.BookRepository;
import com.agriness.onlinebooks.repository.ClientRepository;
import com.agriness.onlinebooks.service.BookService;
import com.agriness.onlinebooks.service.ReservationService;

@Path("/clients")
public class ClientResource {
	@Inject
	ClientRepository clientRepository;
	
	@Inject
	BookService bookService;
	
	@Inject
	ReservationService reservationService;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllClients() {
		List<Client> books = clientRepository.findAll();
		return Response.ok(books).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBokk(Client client) {
		Client createdClient = clientRepository.saveAndFlush(client);
		return Response.ok(createdClient).entity(createdClient).build();
	}

	@GET
	@Path("/{id}/books")
	public Response getReservations(@PathParam("id") Long clientId) {
		List<Reservation> reservationsByClient= reservationService.getReservationByClient(clientId);
	
		return Response.ok(200).entity(reservationsByClient).build();

	}
}
