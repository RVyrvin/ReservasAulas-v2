package org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Permanencia {

	protected static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	protected LocalDate dia;

	protected Permanencia() {

	}

	protected Permanencia(LocalDate dia) {
		setDia(dia);
	}

	protected Permanencia(String dia) {
		setDia(dia);
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		if (dia == null)
			throw new NullPointerException("El día de una permanencia no puede ser nulo.");
		this.dia = dia;
	}

	public void setDia(String dia) {
		if (dia.trim().isEmpty())
			throw new IllegalArgumentException("El día de una permanencia no puede ser vacio.");
		this.dia = LocalDate.parse(dia, FORMATO_DIA);
	}

	public abstract int getPuntos();

	public abstract String toString();

	public abstract int hashCode();

	public abstract boolean equals(Object object);	

}
