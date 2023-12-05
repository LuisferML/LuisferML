
import com.curso.asoweb.logica.Controladora;
import com.curso.asoweb.logica.Usuarios;


public class PruebaUsuario {
    
    public static void main(String[] args) {
        Controladora control = new Controladora();
      
        String correo="luis@gmail.com";
        
        Usuarios user= control.CtrConsultaUsuarioXEmail(correo);
                      
        System.out.println("el usuario encontrado es "+ user.getUsuario());
        
        
    }
    
     
    
    
    
    
}
