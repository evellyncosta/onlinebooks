package com.agriness.onlinebooks.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	@OneToOne
	@JoinColumn(name="id_book")
	private Book book;
	
	@Column(name = "dt_reservation")
	private LocalDate dtReservation;
	
	
	private BigDecimal ticket;
	
	
	@Column(name = "ticket_by_day" )
	private BigDecimal ticketByDay;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getDtReservation() {
		return dtReservation;
	}

	public void setDtReservation(LocalDate dtReservation) {
		this.dtReservation = dtReservation;
	}

	public BigDecimal getTicket() {
		return ticket;
	}

	public void setTicket(BigDecimal ticket) {
		this.ticket = ticket;
	}

	public BigDecimal getTicketByDay() {
		return ticketByDay.setScale(2, RoundingMode.HALF_UP);
	}

	public void setTicketByDay(BigDecimal ticketByDay) {
		this.ticketByDay = ticketByDay;
	}
	
	
	
	
}
