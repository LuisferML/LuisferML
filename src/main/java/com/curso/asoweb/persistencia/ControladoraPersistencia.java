package com.curso.asoweb.persistencia;
//preguntar por que existe la una tabla menu y otra menus en base de datos

import com.curso.asoweb.logica.RolesUsuarios;
import com.curso.asoweb.logica.Socios;
import com.curso.asoweb.logica.Usuarios;
import com.curso.asoweb.persistencia.exceptions.IllegalOrphanException;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {

    CodigoDeSeguridadJpaController codDeSegContr = new CodigoDeSeguridadJpaController();
    DominiosJpaController domContr = new DominiosJpaController();
    EstadosSociosJpaController estContr = new EstadosSociosJpaController();
    ExposicionesJpaController expoContr = new ExposicionesJpaController();
    MensajesEnviadosSociosJpaController mensEnviSocContr = new MensajesEnviadosSociosJpaController();
    MenuJpaController menuContr = new MenuJpaController();
    MenusJpaController menusContr = new MenusJpaController();
    MontosCuotaJpaController montCuotaContr = new MontosCuotaJpaController();
    MovimientosSociosJpaController movSocContr = new MovimientosSociosJpaController();
    OpcionesJpaController opcContr = new OpcionesJpaController();
    PagosCuotasSociosJpaController pagosCuoSocContr = new PagosCuotasSociosJpaController();
    PagosOtrosConceptosJpaController pagosOtrConcContr = new PagosOtrosConceptosJpaController();
    ParticExpoSociosJpaController particExpoSocContr = new ParticExpoSociosJpaController();
   // RolesJpaController rolesContr = new RolesJpaController();
    SociosJpaController socContr = new SociosJpaController();
    TematicaParticExpoSociosJpaController temaPartExpoSocContr = new TematicaParticExpoSociosJpaController();
    TiposMovimientoJpaController tipoMovContr = new TiposMovimientoJpaController();
    UsuariosJpaController usuarioContr = new UsuariosJpaController();
    RolesUsuariosJpaController rolesUsContr= new RolesUsuariosJpaController();

    //METODOS SOCIOS
    public void crearSocios(Socios soc) {

        try {
            socContr.create(soc);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //METODOS USUARIOS
    
    
     public Usuarios CtrPrsConsultaUsuariosPorEmail(String email) {
    	 return usuarioContr.findUsuariosEmail(email);
     }
     
     
     //METODOS ROLES
     public RolesUsuarios CtrPrsContultaRolesByUsuario(Usuarios us){
     return rolesUsContr.findRolesByUsId(us);
     }

    public List<Socios> CtrPrsListarSocios() {
       return socContr.findSociosEntities();
    
    
    }
    



}
