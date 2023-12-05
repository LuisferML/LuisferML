
import com.curso.asoweb.logica.Controladora;
import com.curso.asoweb.logica.RolesUsuarios;
import com.curso.asoweb.logica.Usuarios;


public class PruebaRolesUsuarios {
    
    public static void main(String[] args) {
        
    
    Controladora control= new Controladora();
    Integer id= 2;
    Usuarios us= new Usuarios(id);
    
    
    
    
    RolesUsuarios rolesDeUsuarios= control.CtrConsultaRolesByUs(us);
    
    boolean esAdmin=rolesDeUsuarios.getRolAdmin();
    
    
        System.out.println("el usuario es admmin= "+ esAdmin);
    
    
    
    
    
    }
       
    
    
    
    
    
   
    
    
    
    
    
    
            
    
    
    
    
}
