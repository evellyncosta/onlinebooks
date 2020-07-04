package com.agriness.onlinebooks.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.agriness.onlinebooks.model.Book;
import com.agriness.onlinebooks.model.Reservation;
import com.agriness.onlinebooks.repository.BookRepository;
import com.agriness.onlinebooks.service.BookService;
import com.agriness.onlinebooks.service.ReservationService;

@Path("/books")
public class BookResource {
	@Inject
	BookRepository bookRepository;

	@Inject
	BookService bookService;

	@Inject
	ReservationService reservationService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBooks() {
		List<Book> books = bookRepository.findAll();
		return Response.ok(books).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBook(Book book) {
		Book createdBook = bookRepository.saveAndFlush(book);
		return Response.ok(createdBook).entity(createdBook).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/reserve")
	public Response reserveBook(@PathParam("id") String bookId, @QueryParam("clientId") Long clientId) {
		Reservation createdReservation = reservationService.reserveBook( Long.valueOf(bookId),  clientId);
		return Response.ok(200).entity(createdReservation).build();

	}

}
