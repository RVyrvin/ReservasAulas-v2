package org.iesalandalus.programacion.reservasaulas.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dao.Aulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Profesores;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Reservas;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;

public class ModeloReservasAulas implements IModeloReservasAulas {

	private Aulas aulas;
	private Profesores profesores;
	private Reservas reservas;

	public ModeloReservasAulas() {
		this.aulas = new Aulas();
		this.profesores = new Profesores();
		this.reservas = new Reservas();

		// datos para probar
		/*
		 * Aula aula1 = new Aula("aula1"); Aula aula2 = new Aula("aula2");
		 * 
		 * this.aulas.insertar(new Aula(aula1)); this.aulas.insertar(new Aula(aula2));
		 * 
		 * Profesor roman = new Profesor("roman","roman@mail.com","666555444"); Profesor
		 * ramon = new Profesor("ramon","ramon@mail.com","950777444");
		 * 
		 * this.profesores.insertar(roman); this.profesores.insertar(ramon);
		 * 
		 * LocalDate dia1 = LocalDate.of(2000, 12, 12); LocalDate dia2 =
		 * LocalDate.of(2100, 10, 10); LocalDate dia3 = LocalDate.of(2200, 05, 05);
		 * 
		 * Tramo tramoM = Tramo.MANANA; Tramo tramoT = Tramo.TARDE;
		 * 
		 * Permanencia per1 = new Permanencia(dia1, tramoM); Permanencia per2 = new
		 * Permanencia(dia1, tramoT); Permanencia per3 = new Permanencia(dia2, tramoT);
		 * Permanencia per4 = new Permanencia(dia3, tramoM); Permanencia per5 = new
		 * Permanencia(dia3, tramoT);
		 * 
		 * this.reservas.insertar(new Reserva(roman, aula1, per1));
		 * this.reservas.insertar(new Reserva(roman, aula1, per2));
		 * this.reservas.insertar(new Reserva(roman, aula2, per3));
		 * this.reservas.insertar(new Reserva(roman, aula2, per4));
		 * this.reservas.insertar(new Reserva(ramon, aula1, per5));
		 * this.reservas.insertar(new Reserva(ramon, aula1, per3));
		 * this.reservas.insertar(new Reserva(ramon, aula2, per2));
		 */
	}

	// aulas
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getAulas()
	 */
	@Override
	public List<Aula> getAulas() {
		return aulas.getAulas();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getNumAulas()
	 */
	@Override
	public int getNumAulas() {
		return aulas.getNumAulas();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#representarAulas()
	 */
	@Override
	public List<String> representarAulas() {
		return aulas.representar();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#buscarAula(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula)
	 */
	@Override
	public Aula buscarAula(Aula aula) {
		return aulas.buscar(aula);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#insertarAula(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula)
	 */
	@Override
	public void insertarAula(Aula aula) throws OperationNotSupportedException {
		aulas.insertar(aula);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#borrarAula(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula)
	 */
	@Override
	public void borrarAula(Aula aula) throws OperationNotSupportedException {
		aulas.borrar(aula);
	}

	// profesores
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getProfesores()
	 */
	@Override
	public List<Profesor> getProfesores() {
		return profesores.getProfesores();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getNumProfesores()
	 */
	@Override
	public int getNumProfesores() {
		return profesores.getNumProfesores();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#representarProfesores()
	 */
	@Override
	public List<String> representarProfesores() {
		return profesores.representar();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#buscarProfesor(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor)
	 */
	@Override
	public Profesor buscarProfesor(Profesor profesor) {
		return profesores.buscar(profesor);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#insertarProfesor(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor)
	 */
	@Override
	public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException {
		profesores.insertar(profesor);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#borrarProfesor(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor)
	 */
	@Override
	public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException {
		profesores.borrar(profesor);
	}

	// reservas
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getReservas()
	 */
	@Override
	public List<Reserva> getReservas() {
		return reservas.getReservas();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getNumReservas()
	 */
	@Override
	public int getNumReservas() {
		return reservas.getNumReservas();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#representarReservas()
	 */
	@Override
	public List<String> representarReservas() {
		return reservas.representar();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#buscarReserva(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva)
	 */
	@Override
	public Reserva buscarReserva(Reserva reserva) {
		return reservas.buscar(reserva);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#realizarReserva(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva)
	 */
	@Override
	public void realizarReserva(Reserva reserva) throws OperationNotSupportedException {
		reservas.insertar(reserva);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#anularReserva(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva)
	 */
	@Override
	public void anularReserva(Reserva reserva) throws OperationNotSupportedException {
		reservas.borrar(reserva);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getReservasAula(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula)
	 */
	@Override
	public List<Reserva> getReservasAula(Aula aula) {
		return reservas.getReservasAula(aula);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getReservaProfesor(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor)
	 */
	@Override
	public List<Reserva> getReservasProfesor(Profesor profesor) {
		return reservas.getReservasProfesor(profesor);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getReservaPermanencia(org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia)
	 */
	@Override
	public List<Reserva> getReservasPermanencia(Permanencia permanencia) {
		return reservas.getReservasPermanencia(permanencia);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#consultarDisponibilidad(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula, org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia)
	 */
	@Override
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		return reservas.consultarDisponibilidad(aula, permanencia);
	}
}
