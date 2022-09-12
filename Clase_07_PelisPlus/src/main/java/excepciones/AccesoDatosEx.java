package excepciones;

/**
 *
 * @author ASUS
 */
public class AccesoDatosEx extends Exception{
    String mensaje;
    public AccesoDatosEx(String msg){
        this.mensaje = msg;
    }
}
