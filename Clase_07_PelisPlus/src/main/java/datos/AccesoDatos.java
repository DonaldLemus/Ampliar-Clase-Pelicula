package datos;

import dominio.Pelicula;
import dominio.PeliculaAmpliado;
import excepciones.*;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface AccesoDatos {
    boolean existe (String nombreArchivo) throws AccesoDatosEx;
    public List<PeliculaAmpliado> listar (String nombreArchivo) throws LecturaDatosEx;
    void escribir(Pelicula pelicula, String NombreArchiv, boolean anexar) throws EscrituraDatosEx;
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    public void crear (String nombreArchivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo) throws AccesoDatosEx;
}
