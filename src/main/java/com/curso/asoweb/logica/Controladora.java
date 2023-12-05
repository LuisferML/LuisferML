
package com.curso.asoweb.logica;

import com.curso.asoweb.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    ControladoraPersistencia controlPersis= new ControladoraPersistencia();
    
    
    public void crearSocios (Socios soc){
    controlPersis.crearSocios(soc);
    }
    
    
    public Usuarios CtrConsultaUsuarioXEmail(String email) {
       return controlPersis.CtrPrsConsultaUsuariosPorEmail(email);
    }

   public RolesUsuarios CtrConsultaRolesByUs(Usuarios us){
       
       return controlPersis.CtrPrsContultaRolesByUsuario(us);
   
   
   }

    public List<Socios> CtrListarSocios() {
      return controlPersis.CtrPrsListarSocios();
        
    }
    
    
    
}
