package negocio;

import datos.AccesoDatos;
import datos.AccesoDatosImpl;
import dominio.Pelicula;
import dominio.PeliculaAmpliado;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas{

    private final AccesoDatos datos;
    
    public CatalogoPeliculasImpl(){
        this.datos = new AccesoDatosImpl();
    }
    
    @Override 
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        String[] nombre = nombrePelicula.split(";");
       PeliculaAmpliado pelicula = new PeliculaAmpliado(nombre[0], nombre[1]);//nombre de la pelicula
        boolean anexar = false;
        try {//
            anexar = datos.existe(nombreArchivo);//bandera si anexa o no
            datos.escribir(pelicula, nombreArchivo, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {//desplega las peliculas

        try {
            List<PeliculaAmpliado> peliculas = datos.listar(nombreArchivo);//cada linea del archivo lo mete en esta lista
            for(Pelicula pelicula : peliculas){
                System.out.println("Pelicula: "+pelicula);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
        
    }

    @Override
    public void buscarPeliculas(String nombreArchivo, String buscar) {
        String resultado = null;
        try {
            resultado = datos.buscar(nombreArchivo, buscar);//invocamos buscar desde la clase Acceso Datos
        } catch (LecturaDatosEx ex) {
            System.out.println("Error al buscar la peli"+ ex.getMessage());
           
        }
         System.out.println("Resultado Busqueda:"+resultado);//imprimimos el resultado
    
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        
        try {
            if(datos.existe(nombreArchivo)){//Si el archivo existe lo borra y luego lo vuelve a crear
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            } else {
                //En cambio sino existe entonces lo crea
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }

    }
    
}
