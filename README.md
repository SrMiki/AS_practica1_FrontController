Actualizado: 2020-12-12

# AS_practica1_FrontController
Práctica 1 de la asginatura "Arquitectura del Software" del plan 2010 de la Escuela de Ingeniería Informática de la Universidad de Las Palmas de Gran Canaria.

El objetivo de esta práctica es el de implementar el patrón Front Controller y el control de sesiones. Se hará uso de las tecnologías de Java EE: Servlet y JSP.
Para llevar a cabo el trabajo había que escoger una "idea de proyecto" entres la cuales escogí "Web 2.0 para la compra y descarga de e-libros".

## Herramientas utilizadas

- Base de datos: SQL utilizando ![phpmyadmin](https://www.phpmyadmin.net/)
- Servidor: ![glashfish](https://www.oracle.com/middleware/technologies/glassfish-server.html)
- Entorno de desarrollo: ![Netbeans 8.2](https://netbeans.org/downloads/8.2/rc/) (tip: instalarlo con todo)
- Heramienta de despligue de la BD de phpmyadmin: ![XAMPP](https://www.apachefriends.org/es/index.html)


## "Como hacer que funcione"

1) Descargar las herramientas indicadas e intalarlas:
  - Con netbeans si utilizamos la instalación con todo (all) solamente habría que activar los plugins correspondientes; si utilizas otro diferente tendrás que añadir java EE y glasfish por tu cuenta. 

2) Descargar el proyecto y abrirlo con Netbeans. 
  - Verifica que las librerias javax.servlet y mysql-conector están agregadas al proyecto, en caso contrario, en la carpeta "librerias" están los .jar
  - Si no puedes abrir el proyecto comprueba si tienes activado java EE
  - Si te da un error con el glasfish deberás instalarlo y añadirlo manualmente (con la instalación de Netbeans (all) no da este error) 

3) Una vez puedas visualizar el proyecto hacer un "clean&build" y comprobamos si hay algún fallo (no debería) 

4) Abrir la herramienta XAMPP e iniciar el módulo de Apache y MySQL (nunca encender el módulo tomcat) 

5) Accedemos a phpMyAdmin:
  - opción 1) Escribiendo en el navegador: http://localhost/phpmyadmin/
  - opcion 2) Haciendo "click" en el botón "admin" del módulo de MySQL

6) Agregamos la Base de Datos 
  - opción 1) Utilizando la opción de importar y seleccionamos el fichero "digitalreading.sql"
  - opción 2) Creamos un nueva BBDD llamada "digitalreading" y agregamos, a través de comando SQL, las diferentes tablas del fichero "digitalreading.sql" (ojo con las comillas)
  - Si creamos solo la Base de Datos con las tablas correspondientes ya funcionaría pero, lógicamente, no habría catálogo ni usuarios.

7) Ejecutamos la applicación (run) en Netbeans. Esperamos a que termine de compilar y cuando el glasfish indique "Loading application DigitalReadingFC1 done" abrimos el navegador http://localhost:8080/DigitalReadingFC1/


### Anotaciones

 - Para que esta práctica pueda funcionar hay que utilizar las herramientas indicadas y cargar la base de datos
 - Revisar imports, enlaces y plugins
 - En el "Informe de práctica.pdf" se detallan los diferentes apartados de la práctica
 
