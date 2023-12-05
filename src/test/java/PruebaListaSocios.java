
import com.curso.asoweb.logica.Controladora;
import com.curso.asoweb.logica.Socios;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author luis_
 */
public class PruebaListaSocios {

    public static void main(String[] args) {
        Controladora control = new Controladora();
        List<Socios> lista = control.CtrListarSocios();
        Socios socio = lista.get(0);

        System.out.println(" Nombres es= " + socio.getNombres()+"\n");
        System.out.println("Apellidos es= " + socio.getApellidos()+"\n");
        System.out.println("Email es= " + socio.getEmail()+"\n");
        System.out.println(" Nro Socio es= " + socio.getNroSocio()+"\n");
        System.out.println(" Nro Cedula es= " + socio.getNroCedula()+"\n");
        System.out.println("Fecha Ingreso es= " + socio.getFechaIngreso()+"\n");
        System.out.println(" Estado Actual es= " + socio.getIdEstadoActual()+"\n");
        System.out.println(" Fecha Estado Actual es= " + socio.getFechaEstadoActual()+"\n");
        System.out.println("Fundador es= " + socio.getFundador()+"\n");
        System.out.println("Id Usuario Creacion es= " + socio.getIdUsuarioCreacion()+"\n");
        System.out.println("Fecha Creación es= " + socio.getFechaCreacion()+"\n");
        System.out.println("Id Socio Proponente es= " + socio.getIdSocioProponente()+"\n");
        System.out.println("id Tipo de Socio es= " + socio.getIdTipoSocio());

    }

}
