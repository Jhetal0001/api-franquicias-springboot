# API de Gestión de Franquicias

API RESTful desarrollada con Spring Boot y MongoDB para gestionar franquicias, sucursales y el stock de sus productos. Este proyecto fue creado como para la realización de la prueba técnica para desarrollador Backend.

---

## 🚀 Requisitos Previos

Antes de empezar, asegurarse de tener instalado lo siguiente:

* **Java 17** (o la versión que usaste)
* **Maven 3.8** (o superior)
* **Docker** (para levantar la base de datos de MongoDB)

---

## ⚙️ Despliegue Local

Sigue estos pasos para levantar el proyecto en su entorno local.

### 1. Clonar el Repositorio
```bash
git clone [https://github.com/Jhetal0001/api-franquicias-springboot.git](https://github.com/Jhetal0001/api-franquicias-springboot.git)
cd api-franquicias-springboot
```
### 2. Levantar la Base de Datos con Docker

El proyecto está configurado para conectarse a una base de datos MongoDB. Puedes levantar una instancia fácilmente con Docker:

```bash
docker run -d -p 27017:27017 --name mongo-franquicias mongo
```

Esto iniciará un contenedor de MongoDB al que la aplicación podrá conectarse.

### 3. Ejecutar la Aplicación

Puedes ejecutar la aplicación usando el wrapper de Maven incluido en el proyecto. No es necesario realizar cambios de configuración si sigues el paso anterior.

```bash
./mvnw spring-boot:run
```
La API estará disponible en http://localhost:8080.

---

## 📖 Endpoints de la API

A continuación se detallan los endpoints disponibles para interactuar con la API.

##### Franquicias

| Método HTTP | Ruta | Descripción |
|:---|:---|:---|
| `POST` | `/franquicias` | Crea una nueva franquicia. |
| `PUT` | `/franquicias/{id}` | Actualiza el nombre de una franquicia. |

##### Sucursales

| Método HTTP | Ruta | Descripción |
|:---|:---|:---|
| `POST` | `/franquicias/{id}/sucursales` | Agrega una nueva sucursal a una franquicia. |
| `PUT` | `/sucursales/{id}` | Actualiza el nombre de una sucursal. |

##### Productos

| Método HTTP | Ruta | Descripción |
|:---|:---|:---|
| `POST` | `/sucursales/{id}/productos` | Agrega un nuevo producto a una sucursal. |
| `PUT` | `/productos/{id}` | Actualiza el nombre de un producto. |
| `PUT` | `/productos/{id}/stock` | Modifica el stock de un producto. |
| `DELETE` | `/sucursales/{idSucursal}/productos/{idProducto}` | Elimina un producto de una sucursal. |

##### Consultas

| Método HTTP | Ruta | Descripción |
|:---|:---|:---|
| `GET` | `/franquicias/{id}/productos/mayor-stock` | Obtiene el producto con más stock de cada sucursal para una franquicia dada. |