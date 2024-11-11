package interfaz;

import entidad.Paciente;

import java.util.Arrays;

public class App {
  //* public static void main(String[] args) {
            //Paciente paciente1 = new Paciente();
     //       double[] peso = {30,65,80,99};
       //     double[] altura = {30,65,80,99};
         //   Paciente paciente2= new Paciente(30804175, "Constanza", 40, 'F', altura , peso);
       // System.out.println("Por favor ingrese Nombre del Paciente");
        //String nombre = Leer.dato();

       // System.out.println("El mes en que el paciente " +paciente2.getNombre() + " " + "peso menos kilos es "+paciente2.menorPeso() );

       // System.out.println("El índice de masa corporal del paciente " +paciente2.getNombre() + " " + "en el mes: "+paciente2.imc());

       // System.out.println("El mes en que el paciente " +paciente2.getNombre() + " " + "peso menos de: "+paciente2.menosDeXKilos() );

       // System.out.println("El paciente " +paciente2.getNombre() + " " + "es "+paciente2.pesoMesX() );



        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Paciente paciente = null;
            boolean salir = false;

            while (!salir) {
                System.out.println("\nMenú de opciones:");
                System.out.println("1) Crear un objeto de tipo Paciente");
                System.out.println("2) Mostrar todos los atributos del paciente registrado");
                System.out.println("3) Mostrar el mes con menor peso del paciente registrado");
                System.out.println("4) Comparar peso con los registrados");
                System.out.println("5) Mostrar condición del paciente en noviembre");
                System.out.println("6) Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        // Crear un nuevo objeto Paciente
                        System.out.print("Ingrese DNI: ");
                        int dni = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Ingrese nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese edad: ");
                        int edad = scanner.nextInt();
                        System.out.print("Ingrese sexo (M/F): ");
                        char sexo = scanner.next().charAt(0);

                        double[] alturas = new double[12];
                        double[] pesos = new double[12];
                        System.out.println("Ingrese la altura y peso para cada mes:");

                        for (int i = 0; i < 12; i++) {
                            System.out.print("Altura en el mes " + (i + 1) + ": ");
                            alturas[i] = scanner.nextDouble();
                            System.out.print("Peso en el mes " + (i + 1) + ": ");
                            pesos[i] = scanner.nextDouble();
                        }

                        paciente = new Paciente(dni, nombre, edad, sexo, alturas, pesos);
                        System.out.println("Paciente registrado con éxito.");
                        break;

                    case 2:
                        // Mostrar todos los atributos del paciente registrado
                        if (paciente != null) {
                            System.out.println("Datos del paciente:");
                            System.out.println("DNI: " + paciente.getDni());
                            System.out.println("Nombre: " + paciente.getNombre());
                            System.out.println("Edad: " + paciente.getEdad());
                            System.out.println("Sexo: " + paciente.getSexo());
                            System.out.println("Alturas: " + Arrays.toString(paciente.getAltura()));
                            System.out.println("Pesos: " + Arrays.toString(paciente.getPeso()));
                        } else {
                            System.out.println("Primero debe registrar un paciente.");
                        }
                        break;

                    case 3:
                        // Mostrar el mes con menor peso del paciente
                        if (paciente != null) {
                            int mesMenorPeso = paciente.menorPeso();
                            System.out.println("El mes con menor peso es: " + (mesMenorPeso + 1));
                        } else {
                            System.out.println("Primero debe registrar un paciente.");
                        }
                        break;

                    case 4:
                        // Comparar peso con los registrados
                        if (paciente != null) {
                            System.out.print("Ingrese el peso para comparar: ");
                            double pesoComparar = scanner.nextDouble();
                            int[] mesesConMenorPeso = paciente.menosDeXKilos(pesoComparar);

                            if (mesesConMenorPeso.length > 0) {
                                System.out.print("Meses en los que el paciente pesó menos que " + pesoComparar + " kg: ");
                                for (int mes : mesesConMenorPeso) {
                                    System.out.print((mes + 1) + " ");
                                }
                                System.out.println();
                            } else {
                                System.out.println("No hay meses en los que el paciente haya pesado menos que " + pesoComparar + " kg.");
                            }
                        } else {
                            System.out.println("Primero debe registrar un paciente.");
                        }
                        break;

                    case 5:
                        // Mostrar condición del paciente en noviembre
                        if (paciente != null) {
                            System.out.print("Ingrese la altura del paciente en noviembre: ");
                            double alturaNoviembre = scanner.nextDouble();
                            String condicion = paciente.pesoMesX(10, alturaNoviembre); // Noviembre es el índice 10
                            System.out.println("Condición en noviembre: " + condicion);
                        } else {
                            System.out.println("Primero debe registrar un paciente.");
                        }
                        break;

                    case 6:
                        // Salir
                        salir = true;
                        System.out.println("Saliendo de la aplicación...");
                        break;

                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                        break;
                }
            }

            scanner.close();
        }
    }



}
}
