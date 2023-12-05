<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet'
              href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css'>
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
        <title>Crear Nuevo Socio</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="mainUsuario.jsp">AsoWeb</a>
                <button class="navbar-toggler" type="button"
                        data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                    </ul>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search"
                               aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        <div class="container-fluid" action="SvCrearSocio" method="post">

            <div class="container">
                <!-- Title -->
                <div
                    class="d-flex justify-content-between align-items-lg-center py-3 flex-column flex-lg-row">
                    <h2 class="h5 mb-3 mb-lg-0">

                        <!-- PREGUNTAR QUE HACE href="../../pages/admin/customers.html" -->
                        <a href="../../pages/admin/customers.html" class="text-muted"><i
                                class="bi bi-arrow-left-square me-2"></i></a> Crear Nuevo Socio
                    </h2>
                    <div class="hstack gap-3">
                        <button class="btn btn-light btn-sm btn-icon-text">
                            <i class="bi bi-x"></i> <span class="text">Cancelar</span>
                        </button>
                        <button class="btn btn-primary btn-sm btn-icon-text" type="submit">
                            <i class="bi bi-save"></i> <span class="text">Guardar</span>
                        </button>
                    </div>
                </div>

                <!-- Main content -->
                <div class="row">
                    <!-- Left side -->
                    <div class="col-lg-8">
                        <!-- Basic information -->
                        <div class="card mb-4">
                            <div class="card-body">
                                <h3 class="h6 mb-4">Información Básica</h3>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="mb-3">
                                            <label class="form-label">Nombres</label> <input type="text"
                                                                                             name="nombres" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="mb-3">
                                            <label class="form-label">Apellidos</label> <input type="text"
                                                                                               name="apellidos" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="mb-3">
                                            <label class="form-label">Email</label> <input type="email"
                                                                                           name="email" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="mb-3">
                                            <label class="form-label">Número de cédula</label> <input
                                                type="text" name="numerocedula" class="form-control">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Address -->

                    </div>
                    <!-- Right side -->
                    <div class="col-lg-4">
                        <!-- Status -->
                        <div class="card mb-4">

                            <div class="card-body">

                                <h3 class="h6">
                                    Usuario:
                                    <%
                                        out.print(request.getSession().getAttribute("nombreUsuario"));
                                    %>

                                </h3>
                                    <h3 class="h6">
                                    Usuario ID:
                                    <%
                                        out.print(request.getSession().getAttribute("usuarioId"));
                                    %>

                                </h3>


                            </div>
                        </div>



                        <div class="card mb-4">
                            <div class="card-body">
                                <h3 class="h6">Estado</h3>
                                <select class="form-select">
                                    <option value="pendiente">Pendiente</option>
                                    <option value="activo" selected="">Activo</option>
                                    <option value="suspendido">Suspendido</option>
                                </select>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-body">
                                <h3 class="h6">Es Socio Fundador</h3>
                                <select class="form-select">
                                    <option value="si">si</option>
                                    <option value="no" selected="">no</option>
                                </select>
                            </div>
                        </div>
                     

                    </div>
                </div>
            </div>

        </div>
        <script
        src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'></script>
    </body>
</html>