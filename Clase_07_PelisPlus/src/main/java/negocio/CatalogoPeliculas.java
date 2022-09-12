package negocio;

/**
 *
 * @author ASUS
 */
public interface CatalogoPeliculas {
    public void agregarPelicula(String nombrePelicula, String nombreArchivo);
    public void listarPeliculas(String nombreArchivo);
    public void buscarPeliculas(String nombreArchivo, String buscar);
    public void iniciarArchivo(String nombreArchivo);
}
