
public class Hotel {
	private int cantHabitaciones;
	private int[] habitacionesMayores;
	private int[] habitacionesMenores;
	private int habitacionesOcupadas;

	public Hotel() {
		habitacionesOcupadas = 0;
		cantHabitaciones = 10;
		habitacionesMayores = new int[cantHabitaciones];
		habitacionesMenores = new int[cantHabitaciones];
	}

	public void ocuparHabitacionCon(int mayores, int menores) {
		if (mayores + menores > 8 && habitacionesOcupadas<cantHabitaciones) {
			habitacionesMayores[habitacionesOcupadas] = mayores;
			habitacionesMenores[habitacionesOcupadas] = menores;
			habitacionesOcupadas++;
		}
	}

	public int cantPersonasHabitaciones() {
		int cant = 0;
		for (int i = 0; i < habitacionesOcupadas; i++)
			cant = cant + habitacionesMayores[i] + habitacionesMenores[i];
		return cant;
	}

	public int contarHabitacionesCon(int mayores) {
		int cant = 0;
		for (int i = 0; i < habitacionesOcupadas; i++) {
			if (habitacionesMayores[i] >= mayores)
				cant++;
		}
		return cant;
	}
}
