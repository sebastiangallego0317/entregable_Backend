import javax.swing.JOptionPane;

public class Proceso {
	
	String nombres[];
	int edades[];
	int eleccion;
	public void iniciar () {
	String menu = "Bienvenido \n";
		   menu+= "1. llena los estudiantes\n";
		   menu+= "2. promedio de edades\n";
		   menu+= "3. estudiante(s) mayor(es)\n";
		   menu+= "4. estudiante(s) menor(es)\n";
		   menu+= "5. mayores de edad\n";
		   menu+= "6. buscar por nombre\n";
		   menu+= "7. buscar por edad\n";
		   menu+= "8. salir\n";
		   
		   do {
			   eleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			   switch (eleccion) {
			case 1:
				ingresarDatosEstudiantes();
				break;
			case 2:
				if (isNotNull(nombres)) {
					ageAvg(edades);
				}
				break;
			case 3:
				if (isNotNull(nombres)) {
					mayor(edades);
				}
				break;
			case 4:
				if (isNotNull(nombres)) {
					menor(edades);
				}
				break;
			case 5:
				if (isNotNull(nombres)) {
					mayoresDeEdad(edades);
				}
				break;
			case 6:
				if (isNotNull(nombres)) {
					buscarPorNombre(nombres);
				}
				break;
			case 7:
				
				break;
			default:
				break;
			}
		   } while (eleccion != 8);
		
		
		
		
	}
	
	public void buscarPorNombre(String[] a) {
	    String nombreBuscado = JOptionPane.showInputDialog("Ingrese el nombre del estudiante a buscar:");
	    int cantidad = 0;
	    for (int i = 0; i < a.length; i++) {
	        if (a[i].equalsIgnoreCase(nombreBuscado)) {
	            cantidad++;
	            System.out.println("Estudiante #" + (i+1) + " - Nombre: " + a[i] + " - Edad: " + edades[i]);
	        }
	    }
	    if (cantidad == 0) {
	        System.out.println("No se encontraron estudiantes con ese nombre.");
	    } else {
	        System.out.println("Se encontraron " + cantidad + " estudiantes con el nombre " + nombreBuscado + ".");
	    }
	}

	
	public void mayoresDeEdad(int[] a) {
	    System.out.println("Estudiantes mayores de 18 años:");
	    for (int i = 0; i < a.length; i++) {
	        if (a[i] > 18) {
	            System.out.println(nombres[i] + " tiene " + a[i] + " años");
	        }
	    }
	}

	
	public void menor(int[] a) {
		int menor = a[0];
		for (int i = 1; i < a.length; i++) {
		if (a[i] < menor) {
		menor = a[i];
		}
		}
		for (int i = 0; i < a.length; i++) {
		if (a[i] == menor) {
		System.out.println(nombres[i] + " que tiene " + menor);
		}
		}
		}
	
	public void mayor (int[] a) {
		int mayor = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i]>mayor) {
				mayor = a[i];
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == mayor) {
				System.out.println(nombres[i] + " que tiene " + mayor);
			}
		}
	}
	
	
	public void ageAvg (int[] a) {
		double prom = 0;
		for (int i = 0; i < a.length; i++) {
			prom+=a[i];
		}
		prom/=a.length;
		System.out.println(prom);
	}
	
	
	public boolean isNotNull(String[] a) {
		if (a != null) {
			return true;
		} else {
		System.out.println("Primero debe ingresar los estudiantes.");
			return false;
		}
		}
	
	
	public void ingresarDatosEstudiantes() {
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog(
		"Ingrese la cantidad de estudiantes"
		));
		nombres = new String[cantidad];
		edades = new int[cantidad];
		for (int i = 0; i < nombres.length; i++) {
		nombres[i] = JOptionPane.showInputDialog(
		"Ingrese el nombre del estudiante numero " + (i+1)
		);
		edades[i] = Integer.parseInt(JOptionPane.showInputDialog(
		"Ingrese la edad de " + nombres[i])
		);
		}
		}
}
