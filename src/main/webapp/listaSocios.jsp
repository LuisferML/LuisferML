

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.curso.asoweb.logica.Controladora"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.curso.asoweb.logica.Socios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel= "stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">


        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css"/>

        <script defer src="https://code.jquery.com/jquery-3.7.0.js"></script>
        <script defer src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
        <script defer src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>
        <script defer src="js/script.js"></script>










        <title>AsoWeb</title>



    </head>
    <body>

        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">AsoWeb</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                    </ul>

                </div>
            </div>
        </nav>
        <h1>Lista de Socios</h1>


        <table id="example" class="table table-striped" style="width:100%" >
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Email</th>
                    <th>Nro Socio</th>
                    <th>Nro Cedula</th>
                    <th>Fecha Ingreso</th>
                    <th>Estado Actual</th>
                    <th>Fecha Estado Actual</th>
                    <th>Fundador</th>
                    <th>Usuario Creacion</th>
                    <th>Fecha Creación</th>
                    <th>Id Socio Proponente</th>
                    <th>id Tipo de Socio</th>
                    <th>Acciones</th>



                </tr>
            </thead>

           
            <tbody>
                
                 <%
                Controladora control = new Controladora();
                List<Socios> socios = control.CtrListarSocios();

//                    List<Socios> socios = (List<Socios>) request.getAttribute("listaSocios");
                Iterator<Socios> iterador = socios.iterator();
                Socios socio = null;
                if (socios != null) {
                    while (iterador.hasNext()) {
                        socio = iterador.next();

            %>
                
                
                <tr>
                    <td><%= (socio.getId() != null) ? socio.getId() : "N/A"%></td>
                    <td><%= (socio.getNombres() != null) ? socio.getNombres() : "N/A"%></td>
                    <td><%= (socio.getApellidos() != null) ? socio.getApellidos() : "N/A"%></td>
                    <td><%= (socio.getEmail() != null) ? socio.getEmail() : "N/A"%></td>
                    <td><%= socio.getNroSocio()%></td>
                    <td><%= socio.getNroCedula()%></td>
                    <td><%= (socio.getFechaIngreso() != null) ? new SimpleDateFormat("dd-MM-yyyy").format(socio.getFechaIngreso()) : "N/A"%></td>
                    <td><%= (socio.getIdEstadoActual() != null) ? socio.getIdEstadoActual().getEstado() : "N/A"%></td>
                    <td><%= (socio.getFechaEstadoActual() != null) ? new SimpleDateFormat("dd-MM-yyyy").format(socio.getFechaEstadoActual()) : "N/A"%></td>
                    <td><%= socio.getFundador()%></td>
                    <td><%= (socio.getIdUsuarioCreacion() != null) ? socio.getIdUsuarioCreacion().getUsuario() : "N/A"%></td>
                    <td><%= (socio.getFechaCreacion() != null) ? new SimpleDateFormat("dd-MM-yyyy").format(socio.getFechaCreacion()) : "N/A"%></td>
                    <td><%= (socio.getIdSocioProponente() != null) ? socio.getIdSocioProponente() : "N/A"%></td>
                    <td><%= (socio.getIdTipoSocio() != null) ? socio.getIdTipoSocio() : "N/A"%></td>
                    <td></td>


                </tr>
                    <% }%>
                <% }%>
            </tbody>
            <tfoot>
                <tr>
                    <th>ID</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Email</th>
                    <th>Nro Socio</th>
                    <th>Nro Cedula</th>
                    <th>Fecha Ingreso</th>
                    <th>Estado Actual</th>
                    <th>Fecha Estado Actual</th>
                    <th>Fundador</th>
                    <th>Usuario Creacion</th>
                    <th>Fecha Creación</th>
                    <th>Id Socio Proponente</th>
                    <th>id Tipo de Socio</th>
                    <th>Acciones</th>

                </tr>
            </tfoot>
        </table>










        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
