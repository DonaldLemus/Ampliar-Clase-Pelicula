
package dominio;

/**
 *
 * @author ASUS
 */
public class PeliculaAmpliado extends Pelicula {
    private String Fproduccion;

    public PeliculaAmpliado(String nombre_peli, String fecha_produccion){
        super(nombre_peli);
        this.Fproduccion = fecha_produccion;
    }

    @Override
    public String toString() {
        return this.getNombre()+";"+this.Fproduccion;
    }
    
    
    /*
     * @return the Fproduccion
     */
    public String getFproduccion() {
        return Fproduccion;
    }

    /*
     * @param Fproduccion the Fproduccion to set
     */
    public void setFproduccion(String Fproduccion) {
        this.Fproduccion = Fproduccion;
    }
}
