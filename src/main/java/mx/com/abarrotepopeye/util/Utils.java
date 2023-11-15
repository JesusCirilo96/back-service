package mx.com.abarrotepopeye.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    private Utils(){};

    /**
     * metodo para convertir la fecha en formato mysql YYYY-MM-DD hh:mm:ss a Date
     * @param fecha La fecha string a convertir
     * @return La fecha convertida a Date
     * @throws ParseException Excepcion lanzada en caso de error al convertir la fecha
     */
    public static Date convertirFecha(String fecha) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fechaHoraActual = formatter.parse(fecha);
        return fechaHoraActual;
    }

    /**
     * Metodo para obtener la fecha y hora actual del sistema
     * @return Retornamos un string de la fecha y hora actual en formato: yyyy-MM-dd HH:mm:ss
     */
    public static String fechaHoraActual(){
        Date fechaActual = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fecha = formatter.format(fechaActual);
        return fecha;
    }

    /**
     * Obtenemos el dia de la semana que es hoy.
     * @return el numero del dia correspondiente a hoy
     */
    public static String hoy(){
        Calendar hoy = Calendar.getInstance();
        // Array con los dias de la semana
        String[] strDays = new String[]{"1", "2", "3", "4", "5", "6", "7"};
        // El dia de la semana inicia en el 1 mientras que el array empieza en el 0
        return strDays[hoy.get(Calendar.DAY_OF_WEEK) - 1];
    }

}
