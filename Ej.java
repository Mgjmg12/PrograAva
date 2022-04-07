import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class Ej {
	public static void LeerArchivoYGenerarArchivoResultados() {
		try {
			Scanner leer = new Scanner(new File("test.txt"));

			int suma = 0;
			int max = 0;
			int min = 0;
			int cont = 0;
			while (leer.hasNextInt()) {
				int number = leer.nextInt();
				if (number > max)
					max = number;
				else if (number < min)
					min = number;
				suma += number;
				cont++;

			}
			leer.close();
			try {
				generarArchivo(max,min,(float)suma/(float)cont);
			}catch(Exception ex2)
			{
				ex2.printStackTrace();
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void generarArchivo(int max,int min,float promedio)
	{
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("Resultado.txt");
			pw = new PrintWriter(fichero);
			pw.println("+----------+-------+");
			pw.println("| Máximo   | " + max + " |");
			pw.println("+----------+-------+");
			pw.println("| Minimo   |     " + min + " |");
			pw.println("+----------+-------+");
			pw.printf("| Promedio |  %.2f|\n", promedio );
			pw.println("+----------+-------+");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("test.txt");
			pw = new PrintWriter(fichero);
			int numero = (int) Math.floor(Math.random() * (20000 - 10000 + 1) + 10000);
			for (int i = 0; i < numero; i++) {
				int numeroGuardar = (int) Math.floor(Math.random() * (12000 - 0 + 1) + 0);
				pw.println(numeroGuardar);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
				LeerArchivoYGenerarArchivoResultados();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}
