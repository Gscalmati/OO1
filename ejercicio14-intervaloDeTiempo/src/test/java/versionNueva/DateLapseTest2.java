package versionNueva;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateLapseTest2 {
	
	private DateLapse2 fecha;
	private LocalDate fechaInternaFrom;
	private LocalDate fechaInternaTo;
	private LocalDate fechaInternaInexistente;
	
	@BeforeEach
	public void setUp() {
		fecha = new DateLapse2(LocalDate.of(2022, 10, 15), 16);
		fechaInternaFrom = LocalDate.of(2022, 10, 15);
		fechaInternaTo = LocalDate.of(2022, 10, 31);
		fechaInternaInexistente = LocalDate.of(2022, 05, 12);
	}

	@Test
	public void initializer() {
		assertEquals(LocalDate.of(2022, 10, 15), this.fecha.getFrom());
		assertEquals(LocalDate.of(2022, 10, 31), this.fecha.getTo());
	}
	
	@Test
	public void sizeInDays () {
		assertEquals (16, this.fecha.sizeInDays());
		assertNotEquals (10, this.fecha.sizeInDays());
	}
	
	@Test
	public void includesDate () {
		assertTrue(this.fecha.includesDate(fechaInternaFrom));
		assertTrue(this.fecha.includesDate(fechaInternaTo));
		assertFalse(this.fecha.includesDate(fechaInternaInexistente));
	}
}
