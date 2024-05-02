import modelo.Pelicula;
import modelo.Serie;

import java.util.Scanner;

public class Principal {
    Scanner teclado; // Declaración del objeto teclado

    public Principal() {
        teclado = new Scanner(System.in); // Inicialización del objeto teclado en el constructor
    }

    public void muestraElMenu() {
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);
        while (opcion != 9) {
            String menu = """
                                    
                *********************************************
                Bienvenido(a) al programa Screenmatch
                *********************************************
                1) Registrar una nueva película
                2) Registrar una nueva serie
                3) Calcular duración total Maratón Películas
                4) Calcular duración total Maratón Series
                                    
                *********************************************
                9) Salir del programa
                *********************************************
                                    
                """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la película");
                    String nombre = teclado.nextLine();
                    System.out.println("Ingrese el año de lanzamiento de la película");
                    int fechaDeLanzamiento = teclado.nextInt(); // Cambia a nextInt()
                    teclado.nextLine();
                    System.out.println("Ingrese la duración en minutos de la película");
                    int duracionEnMinutos = teclado.nextInt();
                    teclado.nextLine();
                    Pelicula peliculaUsuario = new Pelicula();
                    peliculaUsuario.setNombre(nombre);
                    peliculaUsuario.setFechaDeLanzamiento(fechaDeLanzamiento);
                    peliculaUsuario.setTiempoDeDuracionEnMinutos(duracionEnMinutos);
                    peliculaUsuario.muestraFichaTecnica();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la serie");
                    String nombreSerie = teclado.nextLine();
                    System.out.println("Ingrese el número de temporadas de la serie");
                    int temporadas = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Ingrese el número de episodios por temporada");
                    int episodiosPorTemporada = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Ingrese la duración en minutos por episodio");
                    int duracionEnMinutosPorEpisodio = teclado.nextInt();
                    teclado.nextLine();
                    Serie serieUsuario = new Serie();
                    serieUsuario.setNombre(nombreSerie);
                    serieUsuario.setTemporadas(temporadas);
                    serieUsuario.setEpisodiosPorTemporada(episodiosPorTemporada);
                    serieUsuario.setDuracionEnMinutosPorEpisodio(duracionEnMinutosPorEpisodio);
                    serieUsuario.muestraFichaTecnica();
                    break;
                case 3:
                    calcularDuracionTotal(true);
                    break;
                case 4:
                    calcularDuracionTotal(false);
                    break;
                case 9:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida. Ingrese una opción válida");
            }
        }
    }

    public void calcularDuracionTotal(boolean esPelicula) {
        System.out.println("Ingrese la cantidad de " + (esPelicula ? "películas" : "series") + " que planea ver durante el fin de semana");
        int cantidad = teclado.nextInt();
        teclado.nextLine();

        int duracionTotal = 0;
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese la duración en minutos " + (esPelicula ? "de la película" : "por episodio de la serie") + " " + (i + 1));
            int duracion = teclado.nextInt();
            teclado.nextLine();
            if (esPelicula) {
                duracionTotal += duracion;
            } else {
                System.out.println("Ingrese el número de episodios por temporada de la serie " + (i + 1));
                int episodiosPorTemporada = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Ingrese el número de temporadas de la serie " + (i + 1));
                int temporadas = teclado.nextInt();
                teclado.nextLine();
                duracionTotal += duracion * episodiosPorTemporada * temporadas;
            }
        }

        System.out.println("La duración total de la maratón de " + (esPelicula ? "películas" : "series") + " es de " + duracionTotal + " minutos.");
    }
}
