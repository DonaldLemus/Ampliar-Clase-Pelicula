package pelisplus;

import java.util.Scanner;
import negocio.CatalogoPeliculas;
import negocio.CatalogoPeliculasImpl;

/**
 *
 * @author ASUS
 */
public class PelisPlus {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "C:\\Users\\ASUS\\Downloads\\mispelis.txt";
    private static final CatalogoPeliculas catalogoPeli = new CatalogoPeliculasImpl();//Creamos un objeto tipo CatalogoPeliculas
    
    public static void main(String[] args) {
        //Mientras la opcion elegida sea 0, preguntamos al usuario
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n1.- Iniciar catalogo peliculas"
                        + "\n2.- Agregar pelicula\n"
                        + "3.- Listar Peliculas\n"
                        + "4.- Buscar Pelicula\n"
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                        //1. Creamos el objeto que administra el catalogo de personas
                        //La creacion del archivo es opcional, de todas maneras se creara 
                        //al escribir por primera vez en el archivo
                        catalogoPeli.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        //2. agregar informacion archivo
                        System.out.println("Introduce el nombre de una pelicula y su ano de estreno separado por ; : ");
                        String nombre = scanner.nextLine();
                        catalogoPeli.agregarPelicula(nombre, nombreArchivo);
                        break;
                    case 3:
                        //3. listar catalogo completo
                        catalogoPeli.listarPeliculas(nombreArchivo);
                        break;
                    case 4:
                        //4. Buscar pelicula
                        System.out.println("Introduce el nombre de una pelicula a buscar:");
                        String buscar = scanner.nextLine();
                        catalogoPeli.buscarPeliculas(nombreArchivo, buscar);
                        break;
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Hubo un error");
            }
        }
   }
}
