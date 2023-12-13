# Servicio de valuación de prendas

Este proyecto implementa un servicio de valuación de prendas de empeño.

## Características

- Implementación del flujo de autorización OAuth 2.0.
- Gestión de tokens de acceso y tokens de actualización.

## Requisitos Previos

Asegúrese de tener instalado en su sistema:

- Java JDK 17 o superior
- Maven

## Configuración

1. Clone este repositorio:

    ```bash
    git clone https://github.com/zamarronstein/valuacion.git
    ```

2. Navegue al directorio del proyecto:

    ```bash
    cd valuacion
    ```

3. Configure las propiedades del servidor en el archivo `application.properties`.

## Variables de Ambiente

| ID | Nombre de la Variable | Descripción                       | Valor                                                                                             |
|----|-----------------------|-----------------------------------|---------------------------------------------------------------------------------------------------|
| 1  | ISSUER_URI            | URI del emisor del token JWT      | https://authorization-server.azurewebsites.net                                                    |
| 2  | MONGODB_URI           | URI de la conexión a MONGODB      | mongodb+srv://<user>:<passwd>@cluster0.2tdxlqs.mongodb.net/<database>?retryWrites=true&w=majority |
| 3  | PORCENTAJE            | Porcentaje del valor del préstamo | 80                                                                                                |

## Ejecución Local

Siga estos pasos para ejecutar el servidor de autorización localmente:

1. Compile el proyecto con Maven:

    ```bash
    mvn clean install
    ```

2. Ejecute la aplicación:

    ```bash
    mvn spring-boot:run
    ```

Este servicio se conecta a un servidor de autentificación por lo que es necesario enviar un Bearer Token para consumir los endpoints de este microservicio.

## Uso

Para obtener un token de acceso siga los siguientes pasos:

1. Acceda a través de su navegador a la url https://oauthdebugger.com/

2. En esta página, aparecerá un formulario que necesitaremos para obtener dos cosas, el código verificador y un código, los cuales necesitamos en la petición para obtener el token y posteriormente consumir los endpoints de este microservicio.

| ID | Campo         | Descripción                                           | Valor                                                           |
|----|---------------|-------------------------------------------------------|-----------------------------------------------------------------|
| 1  | Authorize URI | URI de autorización                                   | https://authorization-server.azurewebsites.net/oauth2/authorize |
| 2  | Redirect URI  | URI a la que redirecciona en caso de éxito            | https://oauthdebugger.com/debug                                 |
| 3  | Client ID     | id del cliente                                        | oidc-client                                                     |
| 4  | Use PKCE      | Establece el algoritmo Sha256 y otras configuraciones | Checked                                                         |
| 5  | Token URI     | URI para obtener el TOKEN                             | https://authorization-server.azurewebsites.net/oauth2/token     |

Antes de presionar el botón `Send Request` copie del formulario el valor del campo `Code Verifier`

3. Presione `Send Request`
4. Redireccionará a la página: https://authorization-server.azurewebsites.net/login
5. Introduzca como usuario: usuario y como contraseña: usuario y presione `Sign In`.
6. Redireccionará aquí: https://oauthdebugger.com/debug
7. Copie el valor de `Authorization Code`
8. Establezca los campos code y code_verifier en el body del request https://authorization-server.azurewebsites.net/oauth2/token
9. Copie el access token y agreguelo al Authorization Bearer del endpoint a consumir.

## Contribuciones

¡Las contribuciones son bienvenidas! Si desea contribuir a este proyecto, abra un problema o envíe una solicitud de extracción.

## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](LICENSE).

---
