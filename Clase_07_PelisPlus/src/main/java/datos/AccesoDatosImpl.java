package datos;

import dominio.Pelicula;
import dominio.PeliculaAmpliado;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AccesoDatosImpl implements AccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo  = new File(nombreArchivo);
        return archivo.exists();
      }

    private List<PeliculaAmpliado> peliFecha = new ArrayList();
    @Override
    public List<PeliculaAmpliado> listar(String nombreArchivo) throws LecturaDatosEx {
         peliFecha = new ArrayList<PeliculaAmpliado>();
        try {
            BufferedReader entrada = null; 
            File archivo = new File(nombreArchivo);
           
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                String nombrePe;
                String Year;
                String[] arreglo = linea.split(";");
                nombrePe = arreglo[0];
                Year = arreglo[1];
                //sugerir cómo validar que no de errores esto
                PeliculaAmpliado pelicula = new PeliculaAmpliado(nombrePe, Year);
                peliFecha.add(pelicula);
                linea = entrada.readLine();
            }   
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) { 
            ex.printStackTrace(System.out);
        }
         return peliFecha;
    }

    @Override
    public void escribir(Pelicula pelicula, String NombreArchivo, boolean anexar) throws EscrituraDatosEx {
        PrintWriter salida = null;//Ayuda a escribir dentro de archivos
        try{
            File archivo = new File(NombreArchivo);//File es un objeto que ayuda a manipular archivos
            salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.toString());//Escribe el nombre de la pelicula en el archivo
            salida.close();
        }catch(IOException e){
            System.out.println("Problema al escribir en el archivo"+e.getMessage());//le mandamos la excepcion
        }finally{//por si pasa algun otro error se dispara finally
            salida.close();
        }
    }
    @Override
    public String buscar(String nombreArchivo,String buscar){
        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreArchivo);
            
            entrada = new BufferedReader(new FileReader(archivo));//Le agregamos todos los datos de archivo a entrada
            String linea = null;
            int i=1;//los archivos no empiezan de 0
            linea = entrada.readLine();//lee lo que tenemos en nuestro archivo
            while (linea != null){//Si el archivo está vacío no entra
                if(buscar != null && buscar.equalsIgnoreCase(linea)){//si buscar no es vacío entra, EqualsIgnoreCase ignora si es mayuscula o miniscula
                    resultado = "Pelicula: "+ linea + " encontrada en la linea: " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }   entrada.close();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                 ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {//Crea un archivo y si existe lo pone en blanco
         PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
          } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha borrado la pelicula");
    }
    
}
