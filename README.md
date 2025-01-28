# Aplicación de gestión inmobiliaria

Bienvenido a nuestra aplicación de gestión inmobiliaria: una solución integral diseñada con una perfecta integración de Angular, Java Spring Boot y MySQL.

## Descripción general

https://i.postimg.cc/YSpRBKZp/Captura-de-pantalla-2024-04-12-015145.png

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
- ng server

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

# Real Estate - Spring Boot y Angular con Docker

Este proyecto es una aplicación de gestión inmobiliaria desarrollada con **Spring Boot** para el backend y **Angular** para el frontend. Utilizamos contenedores Docker para simplificar el despliegue y la ejecución de la aplicación.

## Tecnologías Utilizadas
- **Backend**: Spring Boot (Java)
- **Frontend**: Angular
- **Base de Datos**: MySQL
- **Gestión de Contenedores**: Docker & Docker Compose

## Requisitos Previos
Antes de comenzar, asegúrate de tener lo siguiente instalado en tu sistema:
1. [Docker](https://www.docker.com/)
2. [Docker Compose](https://docs.docker.com/compose/)

## Cómo Ejecutar la Aplicación

Sigue estos pasos para lanzar la aplicación utilizando Docker Compose:

### 1. Clonar el Repositorio
Clona el proyecto en tu máquina local:
```bash
git clone https://github.com/aleglope/Real-Estate-Backend.git
cd Real-Estate-Backend
```
## Crea un archivo .env en la raíz del proyecto y copia .env.template con tus datos
```bash
docker-compose up --build
```
4. Servicios Disponibles
Una vez levantados los contenedores, podrás acceder a los siguientes servicios:

- Frontend: http://localhost
- Backend: http://localhost:8080
- Base de Datos (MySQL): Disponible en el puerto 3306.
- Adminer (opcional): http://localhost:8081 (herramienta para administrar la base de datos).

5 . Scripts de Inicialización
El contenedor de MySQL ejecutará automáticamente los scripts SQL ubicados en la carpeta init-scripts/. Esto incluye la creación de la base de datos, tablas y datos iniciales según el archivo init.sql.

6 . Archivos Estáticos y Media Files
Las imágenes y archivos necesarios para la aplicación se cargan automáticamente desde la carpeta mediafiles en el backend. Estas imágenes estarán disponibles en las rutas configuradas por el servidor Spring Boot, como /media/<nombre-imagen>.

#Comandos Útiles
## Detener los Contenedores
## Para detener y eliminar los contenedores, utiliza:

```bash
docker-compose down
```
## Reconstruir los Contenedores
## Si realizas cambios en el código o configuración, reconstruye los contenedores con:

```bash
docker-compose up --build
```

