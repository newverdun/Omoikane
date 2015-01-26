
 /* Author Phesus        //////////////////////////////
 *  ORC,ACR             /////////////
 *                     /////////////
 *                    /////////////
 *                   /////////////
 * //////////////////////////////                   */

package omoikane.sistema

import omoikane.formularios.*

 import java.awt.Toolkit;

class Dialogos
{
    static def error(String mensaje, Exception detalles) {
        String detallesTxt = Herramientas.getStackTraceString(detalles);
        error(mensaje, detallesTxt, null);
    }
    static def error(mensaje, detalles, parent = null)
    {
        //Recibe tanto detalles en texto como la excepcion directamente
        if(!(detalles instanceof String)) { detalles = Herramientas.getStackTraceString(detalles) }
        lanzarDialogoError(parent, mensaje, detalles)
    }

    static def lanzarDialogoError(parent, mensaje, detalles)
    {
        Toolkit.getDefaultToolkit().beep();
        try {
                String msjXLineas = "";
                int largo = 50, nLetrasLinea = 0;
                if(mensaje == null) mensaje = "Error desconocido";
                String[] palabras  = mensaje.split(" ");

                for(int i = 0; i < palabras.length; i++)
                {
                    if(nLetrasLinea + palabras[i].length() <= largo)
                    {
                        nLetrasLinea += palabras[i].length();
                        msjXLineas += " " + palabras[i];
                    } else {
                    nLetrasLinea = palabras[i].length();
                    msjXLineas += "<br>" + palabras[i];
                    }
                }

                def pm = new omoikane.formularios.Error(parent, true);
                pm.setMensaje("<html>"+msjXLineas+"</html>");
                pm.setTxtDetalles(detalles)
                pm.setVisible(true)
        } catch(e) { println "Error en el mensaje de error! ${e.message}"; e.printStackTrace() } 
    }

    static def lanzarAlerta(mensaje)
    {
        Toolkit.getDefaultToolkit().beep();
        def alerta = new omoikane.formularios.Alerta(null, true)
        alerta.setMensaje(mensaje)
        alerta.setVisible(true)
    }
}
