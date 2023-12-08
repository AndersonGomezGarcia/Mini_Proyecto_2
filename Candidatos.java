
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Candidatos extends Ciudadano {
    private boolean orientacion_politica;// Si es positivo es de derecha si es negativo es de izquierda
    private String partido_politico;
    private String lista_promesas;
    private int numero_votos;

    public int getNumero_votos() {
        return numero_votos;
    }

    public void setNumero_votos(int numero_votos) {
        this.numero_votos = numero_votos;
    }

    public Candidatos(String nombre, String cedula, String ciudad_origen, boolean orientacionpolitica, String partido_politico, String lista_promesas, int numero_votos) {
        super(nombre, cedula, ciudad_origen);
        this.orientacion_politica = orientacionpolitica;
        this.lista_promesas = lista_promesas;
        this.partido_politico = partido_politico;
        this.numero_votos = numero_votos;

    }
    public static List<Candidatos> generarListaCandidatos() {
        List<Candidatos> candidatos = new ArrayList<>();

        // Datos ficticios para generar candidatos
        String[] nombres = {"Juan", "Maria", "Pedro", "Ana", "Carlos", "Laura", "Diego", "Elena", "Luis", "Sofia", "Roberto", "Isabel", "Fernando", "Carmen", "Pablo", "Rosa", "Javier", "Silvia", "Miguel", "Adriana"};
        String[] cedulas = {"1234567890", "2345678901", "3456789012", "4567890123", "5678901234", "6789012345", "7890123456", "8901234567", "9012345678", "0123456789", "1122334455", "2233445566", "3344556677", "4455667788", "5566778899", "6677889900", "7788990011", "8899001122", "9900112233", "0011223344"};
        String[] ciudades = {"Bogotá", "Medellín", "Cali", "Barranquilla", "Cartagena", "Manizales", "Pereira", "Cúcuta", "Bucaramanga", "Villavicencio", "Pasto", "Ibagué", "Neiva", "Popayán", "Montería", "Santa Marta", "Valledupar", "Armenia", "Riohacha", "Quibdó"};
        boolean[] orientaciones = {true, false};
        String[] partidos = {"Partido A", "Partido B", "Partido C", "Partido D", "Partido E"};
        String[] listasPromesas = {"Promesa 1", "Promesa 2", "Promesa 3", "Promesa 4", "Promesa 5"};

        Random random = new Random();

        // Generar 20 candidatos con datos aleatorios
        for (int i = 0; i < 20; i++) {
            Candidatos candidato = new Candidatos(
                    nombres[random.nextInt(nombres.length)],
                    cedulas[random.nextInt(cedulas.length)],
                    ciudades[random.nextInt(ciudades.length)],
                    orientaciones[random.nextInt(orientaciones.length)],
                    partidos[random.nextInt(partidos.length)],
                    listasPromesas[random.nextInt(listasPromesas.length)],
                    random.nextInt(1000) // Número de votos aleatorio
            );
            candidatos.add(candidato);
        }

        return candidatos;
    }

    public boolean getOrientacion_politica() {
        return orientacion_politica;
    }

    public void setOrientacion_politica(boolean orientacion_politica) {
        this.orientacion_politica = orientacion_politica;
    }

    public class Ciudadano {

        String nombre;
        String cedula;
        String ciudad_origen;

        public Ciudadano() {
        }

        public Ciudadano(String nombre, String cedula, String ciudad_origen) {
            this.nombre = nombre;
            this.cedula = cedula;
            this.ciudad_origen = ciudad_origen;

        }

        @Override
        public String toString() {
            return "Ciudadano [nombre=" + nombre + ", cedula=" + cedula + ", ciudad_origen=" + ciudad_origen + "]";
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCedula() {
            return cedula;
        }

        public void setCedula(String cedula) {
            this.cedula = cedula;
        }

        public String getCiudad_origen() {
            return ciudad_origen;
        }

        public void setCiudad_origen(String ciudad_origen) {
            this.ciudad_origen = ciudad_origen;
        }

    }

    public String getPartido_politico() {
        return partido_politico;
    }

    public void setPartido_politico(String partido_politico) {
        this.partido_politico = partido_politico;
    }

    public String getLista_promesas() {
        return lista_promesas;
    }

    public void setLista_promesas(String lista_promesas) {
        this.lista_promesas = lista_promesas;
    }

    public static boolean seleccionar_Orientacion_Politica(Scanner scanner) {
        int opcion;

        do {
            System.out.println("Selecciona tu orientación política:");
            System.out.println("1. Derecha");
            System.out.println("2. Izquierda");
            System.out.print("Ingresa el número de la opción (1 o 2): ");
            opcion = scanner.nextInt();

            if (opcion != 1 && opcion != 2) {
                System.out.println("Opción no válida. Por favor, elige 1 o 2.");
            }
        } while (opcion != 1 && opcion != 2);
        boolean esDerecha = (opcion == 1);// comprueba si eligio derecha y retorna false o true
        return esDerecha;
    }

    public static String seleccionar_Ciudad_Origen(Scanner scanner) {
        enum city {
            Cali, Palmira, Candelaria, Dagua, ElCerrito,
            Florida, Jamundi, LaCumbre, Pradera, Vijes,
            Yumbo, tulua, buga;
        }
        System.out.println("\nPor favor elige una ciudad entre las siguientes");
        for (city city : city.values()) {
            System.out.println(city.ordinal() + ". " + city);
        }
        while (true) {
            int opcion = scanner.nextInt();
            if (opcion >= 0 && opcion < city.values().length) {
                System.out.println("\nHas seleccionado a " + city.values()[opcion] + " como ciudad de origen");
                return (city.values()[opcion]).toString();
            }
            System.out.println("\nOpción no válida. Por favor ingrese una opciona valida");
        }
    }

    public static String seleccionar_Partido_Politico(Scanner scanner, boolean Derecha) {
        if (Derecha) {
            enum partido {
                Partido_Liberal_Colombiano, Partido_Conservador_Colombiano,
                Liga_de_Gobernantes_Anticorrupción,Movimiento_Autoridades_Indígenas_de_Colombia,
                Partido_Verde_Oxígeno, Unión_Patriótica, Salvación_Nacional,
                Partido_Alianza_Social_Independiente,Partido_Cambio_Radical, Partido_Político_Mira;}
                System.out.println("\nPor favor elige una partido de Derecha entre los siguientes");
        for (partido partido : partido.values()) {
                System.out.println(partido.ordinal() + ". " + partido);
            }
            while (true) {
                int opcion = scanner.nextInt();
                if (opcion >= 0 && opcion < partido.values().length) {
                    System.out.println("\nHas seleccionado a " + partido.values()[opcion] + " como partido de Derecha");
                    return (partido.values()[opcion]).toString();
                }
                System.out.println("\nOpción no válida. Por favor ingrese una opciona valida");
            }
        }else{ 
            enum partido {Partido_de_la_U,Partido_Alianza_Verde,Partido_Polo_Democrático_Alternativo, Colombia_Humana,Partido_Centro_Democrático,Movimiento_Alternativo_Indígena_y_Social,Partido_Colombia_Justa_Libres,Partido_Colombia_Renaciente,Partido_ADA,Partido_Dignidad_y_Compromiso,}
            System.out.println("\nPor favor elige un partido de Izquierda entre las siguientes");
        for (partido partido : partido.values()) {
                System.out.println(partido.ordinal() + ". " + partido);
            }
            do{
                int opcion = scanner.nextInt();
                if (opcion >= 0 && opcion < partido.values().length) {
                    System.out.println("\nHas seleccionado a " + partido.values()[opcion] + " como partido de Izquierda");
                    return (partido.values()[opcion]).toString();
                }
                System.out.println("\nOpción no válida. Por favor ingrese una opciona valida");
            }while(true);
        }
    }
    

    public static String crear_Lista_Promesas(Scanner scanner) {
        List<String> promesasList = new ArrayList<>(); // Creamos una lista para almacenar las promesas.

        System.out.println("Ingrese las promesas del candidato (escriba 'fin' para finalizar):");

        while (true) {
            System.out.print("Promesa: ");
            String promesa = scanner.nextLine();

            if (promesa.equalsIgnoreCase("fin")) {
                break; // Terminar la entrada cuando se escriba 'fin'.
            }

            promesasList.add(promesa); // Agregar la promesa a la lista.
        }

        // Construir un String con las promesas separadas por '\n'
        StringBuilder promesasString = new StringBuilder();
        for (String promesa : promesasList) {
            promesasString.append(promesa).append("\n|| Promesa de campaña:");
        }

        return promesasString.toString();
    }


    public static int Votos( Scanner scanner, String nombre, String cedula) {
        while (true) {
            try {
                System.out.print("\nIngrese el número de votos para " + nombre + " con cedula ("+cedula+"): ");
                int votos = Integer.parseInt(scanner.next());
                if (votos >= 0) {
                    return votos; // Salir del bucle si el valor es válido y retornar votos
                } else {
                    System.out.println("El número de votos debe ser un valor no negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Debe ingresar un número entero.");
                scanner.next(); // Limpiar el búfer del scanner para evitar un bucle infinito
            }
        }
    }
    public static void print_candidato(String nombre, String cedula, String ciudad, boolean orientacion, String partido,String promesas){
        String orientacion_politica;
        if (orientacion){
            orientacion_politica = "Derecha";
        }else {orientacion_politica = "Izquierda";}
    
        System.out.print("\n\n==============================\n||Candidato\n|| Nombre: "+nombre+"\n|| Cedula: "+cedula+"\n|| Ciudad: "+ ciudad +"\n|| Orientacio Politica: "+ orientacion_politica+"\n|| Partido politico: "+partido+"\n|| Promesas de campaña: "+ promesas );
    }
    public static Candidatos datos_Candidatos(Scanner scanner) {// Crear candidatos
        scanner.nextLine();
        System.out.print("Ingrese el nombre del ciudadano: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cedula del ciudadano: ");
        String cedula = scanner.nextLine();
        String ciudad = Candidatos.seleccionar_Ciudad_Origen(scanner);// selecciona la ciudad de origen
        boolean orientacion = Candidatos.seleccionar_Orientacion_Politica(scanner);// selecciona la orientacion politica
        String partido = Candidatos.seleccionar_Partido_Politico(scanner, orientacion);
        String promesas = Candidatos.crear_Lista_Promesas(scanner);// crea las promesas
        //int votos = Candidatos.Votos(scanner, nombre );
        Candidatos candidato = new Candidatos(nombre, cedula, ciudad,  orientacion, partido, promesas, 0);
        // inserta los valores
        Candidatos.print_candidato(nombre, cedula, ciudad, orientacion, partido, promesas);
        
                                                                                             // seleccionados para crear
                                                                                             // un nuevo candidato
        return candidato;
    }
    

    public static List<Candidatos> buscarCandidatosPorNombre(List<Candidatos> candidatos, Scanner scanner) {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombreBuscado = scanner.nextLine();

        List<Candidatos> candidatosEncontrados = new ArrayList<>();

        for (Candidatos candidato : candidatos) {
            if (candidato.getNombre().equalsIgnoreCase(nombreBuscado)) {
                candidatosEncontrados.add(candidato);
            }
        }

        if (!candidatosEncontrados.isEmpty()) {
            System.out.println("Candidatos encontrados con el nombre " + nombreBuscado + ":");
            for (Candidatos candidato : candidatosEncontrados) {
                System.out.println(candidato);
            }
        } else {
            System.out.println("No se encontraron candidatos con el nombre " + nombreBuscado + ".");
        }

        return candidatosEncontrados; // Devuelve la lista de candidatos encontrados.
    }
    public static Candidatos buscarCandidatosPorCedula(List<Candidatos> candidatos, String cedulaabuscar) {
        for (Candidatos candidato : candidatos) {
            if (candidato.getCedula().equalsIgnoreCase(cedulaabuscar)) {
                return candidato;
            }
        }return null;
    }
}
