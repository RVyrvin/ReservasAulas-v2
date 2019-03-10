package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.Objects;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorHora;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorTramo;

public class Reserva {

	private Profesor profesor;
	private Aula aula;
	private Permanencia permanencia;

	public Reserva(Profesor profesor, Aula aula, Permanencia permanencia) {
		this.setProfesor(profesor);
		this.setAula(aula);
		this.setPermanencia(permanencia);
	}

	public Reserva(Reserva reserva) {
		if (reserva == null)
			throw new IllegalArgumentException("No se puede copiar una reserva nula.");
		else {
			this.setProfesor(reserva.profesor);
			this.setAula(reserva.aula);
			this.setPermanencia(reserva.permanencia);
		}

	}

	public Profesor getProfesor() {
		return profesor;
	}

	private void setProfesor(Profesor profesor) {
		if (profesor == null)
			throw new IllegalArgumentException("La reserva debe estar a nombre de un profesor.");
		else
			this.profesor = profesor;
	}

	public Aula getAula() {
		return aula;
	}

	private void setAula(Aula aula) {
		if (aula == null)
			throw new IllegalArgumentException("La reserva debe ser para un aula concreta.");
		else
			this.aula = aula;
	}

	public Permanencia getPermanencia() {
		if (permanencia instanceof PermanenciaPorHora)
			return new PermanenciaPorHora((PermanenciaPorHora) permanencia);
		else
			return new PermanenciaPorTramo((PermanenciaPorTramo) permanencia);
	}

	private void setPermanencia(Permanencia permanencia) {
		if (permanencia == null)
			throw new IllegalArgumentException("La reserva se debe hacer para una permanencia concreta.");
		if (permanencia instanceof PermanenciaPorHora) {
			this.permanencia = new PermanenciaPorHora((PermanenciaPorHora) permanencia);
		} else if (permanencia instanceof PermanenciaPorTramo)
			this.permanencia = new PermanenciaPorTramo((PermanenciaPorTramo) permanencia);
	}

	public float getPuntos() {
		return aula.getPuntos() + permanencia.getPuntos();
	}	


	@Override
	public String toString() {
		return "[profesor=" + profesor + ", aula=" + aula + ", permanencia=" + permanencia + ", puntos=" + getPuntos()
				+ "]";
	}
/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aula == null) ? 0 : aula.hashCode());
		result = prime * result + ((permanencia == null) ? 0 : permanencia.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Reserva))
			return false;
		Reserva other = (Reserva) obj;
		if (aula == null) {
			if (other.aula != null)
				return false;
		} else if (!aula.equals(other.aula))
			return false;
		if (permanencia == null) {
			if (other.permanencia != null)
				return false;
		} else {
			if (permanencia instanceof PermanenciaPorHora) {
				if (!((PermanenciaPorHora) permanencia).equals((PermanenciaPorHora) other.permanencia))
					return false;
			} else if (permanencia instanceof PermanenciaPorTramo) {
				if (!((PermanenciaPorTramo) permanencia).equals((PermanenciaPorTramo) other.permanencia))
					return false;
			}
		}
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		return true;
	}
*/

	@Override
	public int hashCode() {
		return Objects.hash(aula, permanencia, profesor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(aula, other.aula) && Objects.equals(permanencia, other.permanencia)
				&& Objects.equals(profesor, other.profesor);
	}
	
	
}
