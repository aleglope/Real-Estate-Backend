# Aplicación de gestión inmobiliaria

Bienvenido a nuestra aplicación de gestión inmobiliaria: una solución integral diseñada con una perfecta integración de Angular, Java Spring Boot y MySQL.

## Descripción general
[ ![ Captura-de-pantalla-2024-04-12-015145.png ] ( https://i.postimg.cc/YSpRBKZp/Captura-de-pantalla-2024-04-12-015145.png )] ( https://postimg.cc/G45GvNbN )

# Aplicación de gestión inmobiliaria

Bienvenido a nuestra aplicación de gestión inmobiliaria: una solución integral diseñada con una perfecta integración de Angular, Java Spring Boot y MySQL.

Este repositorio alberga el código base de una sofisticada aplicación web diseñada para agilizar las operaciones inmobiliarias. Aprovechamos la solidez de Angular para nuestra experiencia del lado del cliente, junto con un potente backend Java Spring Boot para procesar y administrar datos de manera eficiente. MySQL sirve como columna vertebral para las necesidades de nuestra base de datos, garantizando una persistencia de datos confiable y segura.

## Arquitectura

Nuestra aplicación se divide en dos componentes principales:

### Solicitud de cliente

-  ** Angular Frontend ** : creada con HTML5 y Angular, la aplicación cliente está diseñada para ofrecer una interfaz de usuario intuitiva y receptiva. Se comunica con el servidor a través de solicitudes HTTP, esperando respuestas JSON para actualizar dinámicamente la interfaz de usuario con datos en tiempo real.

### Aplicación remota (servidor)

-  ** Spring REST API ** : la aplicación del lado del servidor está construida sobre Spring Boot y ofrece una API RESTful para manejar solicitudes HTTP del cliente. Consiste en:
  -  ** Controladores ** : Para enrutar las solicitudes a los servicios apropiados.
  -  ** Servicios ** : Capa de lógica empresarial que orquesta las operaciones de datos.
  -  ** Objetos de acceso a datos (DAO) ** : Repositorios para interacciones de bases de datos, aprovechando Spring Data JPA para operaciones CRUD.
-  ** Base de datos MySQL ** : Nuestra elección de base de datos es MySQL, que almacena y sirve los datos requeridos por los servicios backend. Está estructurado para respaldar el ámbito inmobiliario con operaciones CRUD eficientes.

### Flujo de datos

1 .  ** Solicitudes HTTP ** : la aplicación cliente envía solicitudes (GET, POST, UPDATE, DELETE) para interactuar con los recursos del servidor.
2 .  ** Spring REST Controller ** : Procesa la solicitud y delega en la capa de servicio.
3 .  ** Capa de servicio ** : Maneja la lógica empresarial y se comunica con las DAO.
4 .  ** Objetos de acceso a datos (DAO) ** : Interactúa con la base de datos MySQL para realizar operaciones CRUD.
5 .  ** Base de datos MySQL ** : almacena y recupera las entidades de datos requeridas.

## Tecnologías

- Interfaz: Angular
- Backend: Java Spring Boot, Spring Data JPA, Hibernación
- Base de datos: MySQL

## Empezando

Para ejecutar esta aplicación en su máquina local, deberá instalar lo siguiente:

- Node.js y npm: [ Descargar Node.js y npm ] ( https://nodejs.org/en/download/ )
- Java JDK: [ Descargar Java JDK ] ( https://www.oracle.com/java/technologies/javase-jdk11-downloads.html )
- Spring Tools 4 para Eclipse: [ Descargar Spring Tools 4 ] ( https://spring.io/tools )
- Base de datos MySQL: [ Descargar MySQL ] ( https://www.mysql.com/downloads/ )

## Instalación de CLI angular

- instalación npm -g @ angular/cli
- ng nuevo mi-proyecto-angular
- cd mi-proyecto-angular
- ng servir

## Configurando el backend de Spring Boot

1 . Abra Spring Tools 4 (Eclipse).
2 . Importe el proyecto backend:
- Vaya a Archivo > Importar...
- Elija Proyectos Maven existentes o Proyecto Gradle existente según su proyecto.
- Navegue hasta el directorio raíz del proyecto y seleccione el proyecto.
3 . Una vez importada, ejecute la aplicación Spring Boot:
- Haga clic derecho en el proyecto en el Explorador de paquetes.
- Seleccione Ejecutar como > Aplicación Spring Boot.
- El puerto predeterminado para Spring Boot es localhost:8080.

## Conexión a la base de datos MySQL

1 . Asegúrese de que su servicio MySQL esté en funcionamiento.
2 . Configure el archivo application.properties en su proyecto Spring:

- spring.datasource.url=jdbc:mysql://localhost:3306/su-nombre-de-base-de-datos
- spring.datasource.username=tu-nombre de usuario
- spring.datasource.password=tu-contraseña

3 . Reemplace su nombre de base de datos, su nombre de usuario y su contraseña con sus detalles reales de MySQL.

## Contribución

¡Tus contribuciones son bienvenidas! No dude en bifurcar este repositorio, realizar cambios y abrir una solicitud de extracción para fusionar sus funciones o mejoras en la rama principal.

Para cualquier consulta o sugerencia, abra un problema en este repositorio.
