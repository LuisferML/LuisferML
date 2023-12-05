<%-- 
    Document   : errorLogin
    Created on : 27 nov 2023, 17:21:53
    Author     : luis_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
   <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author"
              content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.88.1">
        
        
        <title>Error</title>

        <link rel="canonical"
              href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
              crossorigin="anonymous">

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media ( min-width : 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>


        <!-- Custom styles for this template -->
        <link href="css/stylesheetLogin.css" rel="stylesheet">
    </head>

    <body class="text-center">


        <main class="form-signin">
            <form action="SvLogin" method="post">

                 
                <img class="mb-4" src="media/imagenes/login/asociacion.png" alt=""
                     width="100" height="100">
                <h1 class="h3 mb-3 fw-normal">Login AsoWeb</h1>

                <div class="form-floating">
                    <label for="floatingInput" name="mensajeErrorLogin">
                        
                        <h2>
                            <%
                                out.print(request.getSession().getAttribute("mensajeErrorLogin")); 
                            %>
                           
                        </h2> 
                        
                        
                        
                    </label>
                </div>
                <div class="form-floating">
                    
                </div>

                <div class="checkbox mb-3">





                </div>
                <button class="w-100 btn btn-lg btn-primary"
                        name="btnVolver" href="index.jsp">volver</button>
                <p class="mt-5 mb-3 text-muted">&copy; 2023</p>
            </form>




        </main>



    </body>
</html>
