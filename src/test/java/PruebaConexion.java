
import com.curso.asoweb.logica.Controladora;
import com.curso.asoweb.logica.Opciones;
import com.curso.asoweb.logica.Socios;
import com.curso.asoweb.logica.Usuarios;
import java.util.Date;

public class PruebaConexion {

    public static void main(String[] args) {
        
        Controladora control = new Controladora();
        Usuarios usuarioCrea=new Usuarios(1);
        Opciones ops=new Opciones(5);
        
        
        
        Date fechaIng = new Date();
        Date fechaCreac= new Date();
        Date  fechaEstAct= new Date();
        Socios elSocio= new Socios(10, "Bart", "Simpson", "bart@gmail,com", 58, 2356559, fechaIng,ops, true, usuarioCrea, fechaCreac, fechaEstAct);
        
       
        control.crearSocios(elSocio);

    }

}
