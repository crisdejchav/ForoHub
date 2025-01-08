# Proyecto ForoHub

ForoHub es mi solución al último challenge del curso de backend de Alura. Este proyecto tiene como objetivo crear un foro donde los usuarios puedan interactuar, compartir conocimientos y resolver dudas relacionadas con diversos temas de programación y tecnología.


## Características
- Creación de usuarios
- Inicio de sesión
- Creación, actualización, listado y eliminación de posts

## Instalación
Para instalar el proyecto desde GitHub, sigue estos pasos:

```bash
# Clonar el repositorio
git clone https://github.com/tu-usuario/ForoHub.git

# Navegar al directorio del proyecto
cd ForoHub

# Compilar el proyecto
./mvnw clean install
```

## Uso
Para ejecutar el proyecto con Spring Boot, utiliza el siguiente comando:

```bash
./mvnw spring-boot:run
```

El proyecto expone los siguientes endpoints:

### Endpoints

#### Autenticación
- **POST /auth/login**: Iniciar sesión de un usuario
```json
{
    "username": "usuario",
    "password": "contraseña"
}
```

#### Usuarios
- **POST api/users/register**: Registrar un nuevo usuario
```json
{
    "name": "string",
    "email": "string@site.com",
    "password": "string"
}
```
#### Temas
- **GET api/topics**: Listar todos los temas

- **POST api/topics**: Crear un nuevo tema
```json
{
    "title": "string",
    "message": "string",
    "author": "string",
    "course": "JAVA"
}
```
- **PUT api/topics/{id}**: Actualizar un tema existente
```json
{
    "title": "string",
    "message": "string"
}
```
- **DELETE api/topics/{id}**: Eliminar un tema

Cada endpoint requiere un token de autenticación que debe ser incluido en el encabezado de la solicitud.

## Contribuir
Pasos para contribuir al proyecto.

1. Hacer un fork del repositorio
2. Crear una nueva rama (`git checkout -b feature/nueva-caracteristica`)
3. Realizar los cambios y hacer commit (`git commit -m 'Agregar nueva característica'`)
4. Hacer push a la rama (`git push origin feature/nueva-caracteristica`)
5. Abrir un Pull Request

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.