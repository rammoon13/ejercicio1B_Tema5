# Proyecto: Aplicación de Gestión de Pedidos

## Descripción
Esta aplicación permite gestionar pedidos y clientes en una base de datos SQLite. Los usuarios pueden registrar clientes, asignarles pedidos y consultar las zonas de envío disponibles.

## Funcionalidades
- **Ver Zonas de Envío**: Muestra todas las zonas de envío registradas en la base de datos.
- **Ver Clientes**: Lista todos los clientes registrados.
- **Ver Pedidos de un Cliente**: Permite consultar los pedidos asociados a un cliente específico.
- **Agregar Cliente**: Permite registrar un nuevo cliente en la base de datos.
- **Borrar Cliente**: Elimina un cliente de la base de datos.
- **Agregar Pedido**: Registra un nuevo pedido para un cliente.
- **Borrar Pedido**: Elimina un pedido existente de la base de datos.

## Estructura del Proyecto
El proyecto está organizado en varias clases:

- `Main`: Clase principal que ejecuta la aplicación y gestiona la conexión con la base de datos.
- `DatabaseManager`: Clase que gestiona la conexión con la base de datos y ejecuta scripts iniciales.
- `Menu`: Clase que muestra el menú principal y captura las opciones del usuario.
- `MenuHandler`: Clase que gestiona la lógica del negocio y las interacciones con la base de datos.
- `Cliente`: Clase que representa a un cliente, con atributos como ID, nombre, email, teléfono e ID de zona de envío.
- `Pedido`: Clase que representa un pedido con ID, fecha, importe total e ID del cliente asociado.
- `ZonaEnvio`: Clase que representa una zona de envío con ID, nombre y tarifa de envío.
- `ClienteDAO`: Clase DAO encargada de la gestión de clientes en la base de datos.
- `PedidoDAO`: Clase DAO que maneja la gestión de pedidos en la base de datos.
- `ZonaEnvioDAO`: Clase DAO que gestiona las zonas de envío en la base de datos.

## Requisitos
- Java 8 o superior
- SQLite (Base de datos integrada en el proyecto)

## Instalación y Ejecución
1. Clonar este repositorio.
2. Compilar el proyecto con `javac` o una herramienta como Maven o Gradle.
3. Ejecutar la aplicación con `java ies.castillodeluna.Main`.

## Autor
Proyecto desarrollado por Ramon Herrera Robles (2º DAM).

