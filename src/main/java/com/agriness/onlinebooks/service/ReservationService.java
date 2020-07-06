package com.agriness.onlinebooks.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;

import com.agriness.onlinebooks.enums.Available;
import com.agriness.onlinebooks.exception.BusinessException;
import com.agriness.onlinebooks.model.Book;
import com.agriness.onlinebooks.model.Client;
import com.agriness.onlinebooks.model.Reservation;
import com.agriness.onlinebooks.repository.BookRepository;
import com.agriness.onlinebooks.repository.ClientRepository;
import com.agriness.onlinebooks.repository.ReservationRepository;

@Stateless
public class ReservationService {
	private static final BigDecimal TICKETPRICE = BigDecimal.TEN;
	private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);


	@Inject
	BookRepository bookRepository;

	@Inject
	ClientRepository clientRepository;

	@Inject
	ReservationRepository reservationRepository;

	public Reservation reserveBook(Long bookId, Long clientId) throws BusinessException {
		LocalDate currentDate = LocalDate.now();

		Optional<Book> bookOptional = bookRepository.findOptionalBy(bookId);
		Optional<Client> clientOptional = clientRepository.findOptionalBy(clientId);

		if (!clientOptional.isPresent()) {
			throw new BusinessException("Cliente não encontrado");
		}

		if (!bookOptional.isPresent()) {
			throw new BusinessException("Livro não encontrado");
		}
		
		if (bookOptional.get().getAvailable().getValue()==Available.EMPRESTADO.getValue()) {
			throw new BusinessException("Livro não disponível para reserva");
		}

		bookOptional.get().setAvailable(Available.EMPRESTADO);

		Reservation reserve = new Reservation();
		reserve.setBook(bookOptional.get());
		reserve.setClient(clientOptional.get());
		reserve.setDtReservation(currentDate);
		Reservation createdResesrvation = reservationRepository.save(reserve);
		return createdResesrvation;
	}

	public List<Reservation> getReservationByClient(Long clientId) {
		List<Reservation> reservations = reservationRepository.findByClient(clientId);
		reservations.forEach(reservation -> {
			this.calculateTicketTotal(reservation);
		});
		return reservations;

	}

	private Reservation calculateTicketTotal(Reservation reservation) {

		LocalDate currentDate = LocalDate.now();

		Long days = ChronoUnit.DAYS.between(reservation.getDtReservation(), currentDate);

		if (days == 0) {
			reservation.setTicket(new BigDecimal("0"));
			reservation.setTicketByDay(new BigDecimal("0"));

		}

		if (days > 0 && days <= 3) {
			reservation.setTicket(calculateTicket(TICKETPRICE, 3));
			reservation.setTicketByDay(calculateTicketByDay(TICKETPRICE, 0.2));
		}

		if (days > 3 && days <= 5) {
			reservation.setTicket(calculateTicket(TICKETPRICE, 5));
			reservation.setTicketByDay(calculateTicketByDay(TICKETPRICE, 0.4));
		}

		if (days > 5) {
			reservation.setTicket(calculateTicket(TICKETPRICE, 7));
			reservation.setTicketByDay(calculateTicketByDay(TICKETPRICE, 0.6));
		}

		return reservation;
	}

	private BigDecimal calculateTicket(BigDecimal value, double percentage) {
		return value.multiply(new BigDecimal(percentage)).divide(ONE_HUNDRED);
	}

	private BigDecimal calculateTicketByDay(BigDecimal value, double percentage) {
		return value.multiply(new BigDecimal(percentage)).divide(ONE_HUNDRED).multiply(TICKETPRICE);
	}

}
