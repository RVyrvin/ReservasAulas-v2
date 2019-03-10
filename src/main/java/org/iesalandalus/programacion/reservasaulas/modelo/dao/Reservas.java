package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorHora;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorTramo;

public class Reservas {

	private static float MAX_PUNTOS_PROFESORES_MES = 200f;
	private List<Reserva> coleccionReservas;

	public Reservas() {
		this.coleccionReservas = new ArrayList<>();
	}

	public Reservas(Reservas reservas) {
		setReservas(reservas);
	}

	private void setReservas(Reservas reservas) {
		if (reservas == null) {
			throw new IllegalArgumentException("No se pueden copiar reservas nulas.");
		} else {
			this.coleccionReservas = copiaProfundaReservas(reservas.coleccionReservas);
		}
	}

	private List<Reserva> copiaProfundaReservas(List<Reserva> reservas) {
		List<Reserva> cpyReservas = new ArrayList<>();
		for (Reserva reserva : reservas) {
			cpyReservas.add(new Reserva(reserva));
		}
		return cpyReservas;
	}

	public List<Reserva> getReservas() {
		return copiaProfundaReservas(this.coleccionReservas);
	}

	public int getNumReservas() {
		return this.coleccionReservas.size();
	}

	public void insertar(Reserva reserva) throws OperationNotSupportedException {

		if (reserva == null)
			throw new IllegalArgumentException("No se puede realizar una reserva nula.");

		if (!esMesSiguienteOPosterior(reserva))
			throw new OperationNotSupportedException(
					"Sólo se pueden hacer reservas para el mes que viene o posteriores.");

		if (reserva.getPuntos() + getPuntosGastadosReserva(reserva) > MAX_PUNTOS_PROFESORES_MES)
			throw new OperationNotSupportedException(
					"Esta reserva excede los puntos máximos por mes para dicho profesor.");		
		
		if (coleccionReservas.contains(reserva))
			throw new OperationNotSupportedException("La reserva ya existe.");

		Reserva res = getReservaDia(reserva.getPermanencia().getDia());
		
		/*if (res != null) {
			if (res.getPermanencia() instanceof PermanenciaPorTramo) {
				PermanenciaPorTramo resPermanenciaPorTramo = new PermanenciaPorTramo(
						(PermanenciaPorTramo) res.getPermanencia());
				PermanenciaPorTramo reservaPermanenciaPorTramo = new PermanenciaPorTramo(
						(PermanenciaPorTramo) reserva.getPermanencia());
				if (resPermanenciaPorTramo.getTramo().equals(reservaPermanenciaPorTramo.getTramo())
						&& res.getAula().equals(reserva.getAula()))
					throw new OperationNotSupportedException(
							"Ya se ha realizado una reserva por tramo para este día y aula.");
			}

			if (res.getPermanencia() instanceof PermanenciaPorHora) {
				if (res.getPermanencia() instanceof PermanenciaPorHora) {
					PermanenciaPorHora resPermanenciaPorHora = new PermanenciaPorHora(
							(PermanenciaPorHora) res.getPermanencia());
					PermanenciaPorHora reservaPermanenciaPorHora = new PermanenciaPorHora(
							(PermanenciaPorHora) res.getPermanencia());
					if (resPermanenciaPorHora.getHora().equals(reservaPermanenciaPorHora.getHora())
							&& res.getAula().equals(reserva.getAula()))
						throw new OperationNotSupportedException(
								"Ya se ha realizado una reserva por hora para este día y aula.");
				}

			}
		}*/		
		
		coleccionReservas.add(new Reserva(reserva));

	}

	private boolean esMesSiguienteOPosterior(Reserva reserva) {
		return reserva.getPermanencia().getDia().isAfter(LocalDate.now());
	}

	private float getPuntosGastadosReserva(Reserva reserva) {
		float puntos = 0f;
		for (Reserva res : getReservasProfesorMes(reserva.getProfesor(), reserva.getPermanencia().getDia())) {
			puntos += res.getPuntos();
		}
		return puntos;
	}

	private List<Reserva> getReservasProfesorMes(Profesor profesor, LocalDate dia) {
		List<Reserva> reservas = new ArrayList<>();
		for (Reserva reserva : coleccionReservas) {
			if (reserva.getProfesor().equals(profesor)
					&& reserva.getPermanencia().getDia().getMonthValue() == dia.getMonthValue())
				reservas.add(new Reserva(reserva));
		}
		return reservas;
	}

	private Reserva getReservaDia(LocalDate dia) {
		Reserva reserva = null;
		for (Reserva res : coleccionReservas) {
			if (res.getPermanencia().getDia().equals(dia))
				reserva = res;
		}
		return reserva;
	}

	public Reserva buscar(Reserva reserva) {
		int index = coleccionReservas.indexOf(reserva);
		if (index != -1) {
			return new Reserva(this.coleccionReservas.get(index));
		} else {
			return null;
		}
	}

	public void borrar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new IllegalArgumentException("No se puede anular una reserva nula.");
		} else {
			if (!coleccionReservas.remove(reserva)) {
				throw new OperationNotSupportedException("La reserva a anular no existe.");
			}
		}
	}

	public List<String> representar() {
		List<String> str = new ArrayList<>();
		for (Reserva reserva : coleccionReservas) {
			str.add(reserva.toString());
		}
		return str;
	}

	public List<Reserva> getReservasProfesor(Profesor profesor) {
		List<Reserva> reservaProfesor = new ArrayList<>();
		for (Reserva reserva : coleccionReservas) {
			if (reserva.getProfesor().equals(profesor)) {
				reservaProfesor.add(new Reserva(reserva));
			}
		}
		return reservaProfesor;
	}

	public List<Reserva> getReservasAula(Aula aula) {
		List<Reserva> reservaAula = new ArrayList<>();
		for (Reserva reserva : coleccionReservas) {
			if (reserva.getAula().equals(aula)) {
				reservaAula.add(new Reserva(reserva));
			}
		}
		return reservaAula;
	}

	public List<Reserva> getReservasPermanencia(Permanencia permanencia) {
		List<Reserva> reservaPermanencia = new ArrayList<>();
		for (Reserva reserva : coleccionReservas) {
			if (reserva.getPermanencia().equals(permanencia)) {
				reservaPermanencia.add(new Reserva(reserva));
			}
		}
		return reservaPermanencia;
	}

	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		boolean isDisponible = true;

		if (aula == null)
			throw new IllegalArgumentException("No se puede consultar la disponibilidad de un aula nula.");
		if (permanencia == null)
			throw new IllegalArgumentException("No se puede consultar la disponibilidad de una permanencia nula.");

		for (Reserva reserva : coleccionReservas) {
			if (reserva.getAula().equals(aula) && reserva.getPermanencia().equals(permanencia))
				isDisponible = false;
		}
		return isDisponible;
	}
}
