package dominio;

/**
 *
 * @author ASUS
 */
public class Pelicula {
    private String nombre;
    
    public Pelicula(String nombre_peli){
        this.nombre = nombre_peli;
    }

    @Override
    public String toString() {
        return this.getNombre();
        //return "Pelicula{" + "nombre=" + nombre + '}';
    }
    
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
