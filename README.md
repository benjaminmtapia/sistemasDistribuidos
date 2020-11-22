# Pep 1: Creación y Análisis del Sistema Legado
- Andres Alcaíno (Frontend)
- Benjamín Muñoz (Backend)

### Contexto del problema
Se requiere la implementación de una aplicación web que permita generar permisos de salida en cuarentena a los usuarios. Este permiso deberá ser enviado al correo indicado en el formulario.

### Arquitectura del Sistema
El objetivo del Sistema es recrear la página [comisariavirtual](https://comisariavirtual.cl/) y lograr analizar dicho sistema desde la perspectiva de los Sistemas Distribuidos. Cuya arquitectura se ve reflejada en el   siguiente diagrama.

![Arquitectura de sistema](/images/Arquitectura_Pep1.png)

#### Tecnologías:
- Backend: Java Spring-Boot
- Frontend: Vuejs
- Base de Datos: Postgresql

### Características de un Sistema Distribuido


- **Transparencia:** Está dirigida a ocultar los componentes del Sistema al usuario, para que este lo vea como un todo, en lugar de distintos componentes  independientes conectados.
- **Escalabilidad:** Capacidad de adaptación y respuesta del sistema respecto a su propio rendimiento para mejorar la capacidad de trabajo. Esta se divide en vertical (división de capacidad de recursos) y horizontal (división de cantidad de recursos). 
- **Apertura:** Es la característica de un sistema que permite añadirle nuevas características y servicios de forma dinámica. Esto se logra con el uso de protocolos estándar para la interoperabilidad.
- **Disponibilidad:** Se refiere a la disponibilidad de recursos del sistema. Éste debe ser capaz de acceder a los recursos en todo momento. Si se presentan fallos, el sistema debe ser capaz de acceder a recursos replicados para combatir la pérdida de datos. 

### Análisis del Sistema Implementado

- **Transparencia:** No existe transparencia en el sistema implementado, debido a que se implementó en un solo equipo y no en distintas componentes. Por lo tanto, al no estar distribuido, no puede considerarse transparente.
  - **Acceso:** En este proyecto se utiliza el gestor de paquetes NPM, lo cuál permite ejecutar frontend utilizando los comandos respectivos: "npm install" y "npm run serve". Por el lado de backend es necesario instalar Maven con "sudo apt install maven" y ejecutar el cliente con "mvn spring-boot:run".
  - **Ubicación:** El proyecto no cuenta con un servidor en donde alojarlo, por lo que todo debe ser ejecutado en local. Al carecer de servidor, también carece de un dominio.
  - **Migración:** El recurso puede migrar a un servidor mediante el uso de docker, y en ese caso sería facil cambiarlo de ubicación, ya que docker tiene muchas herramientas que lo permiten.
  - **Re-localización:** No está disponible cuando se realiza una migración.
  - **Replicación:** Como se sigue la arquitectura mencionada anteriormente no existen réplicas de los recursos.
  - **Concurrencia:** Al ser un único formulario, los usuarios solo reciben feedback de si fue enviado o rechazado. Por lo tanto, no saben que están accediendo al mismo recurso de forma concurrente.
  - **Falla:** El usuario notará de inmediato si el sistema falla, ya que si el backend o la base de datos deja de ejecutarse entonces no se podrán hacer consultas mediante las vistas.
- **Escalabilidad:** No existe escalabilidad tanto horizontal como vertical ya que no se utilizan varios servidores o computadores, y al ejecutarse localmente no existe una escalabilidad vertical con mejoras de hardware. Una forma de escalar este software sería replicandolo en varios servidores, de modo que si el servidor maestro se cae, otro tome su lugar (un servidor Shadow Master).
- **Apertura:** El sistema es abierto ya que usa los estándares de REST API para su funcionamiento, y se utiliza el protocolo HTTP, mientras que las peticiones a la API se realizan en formato JSON.
- **Disponibilidad:** Como actualmente no existe servidor ni réplicas el sistema de software es muy propenso a fallas. Esto se deberá solucionar en futuros trabajos mediante un escalado horizontal. Como se mencionó anteriormente, mediante el uso de contenedores docker se podrá realizar facilmente esta acción gracias a sus herramientas de migración y replicación.

### Capacidad de Respuesta del Sistema

Para las pruebas se utiliza Artillery.io, el cual permite simular las peticiones POST al backend del Sistema. Se realiza una prueba de 60 segundos con una tasa de 10 usuarios por segundo, lo cual dará como resultado 600 solicitudes, obteniendo lo siguiente: 

![Capacidad de respuesta](/images/test_carga.png)

Respecto a los resultados se puede concluir que:
- Se realizaron 600 solicitudes y todas se cumplieron con éxito.
- Respecto a los tiempos, comparando media, mínimo y máximo, por lo que los tiempos son consistentes.

Por otro lado, se evalúa el caso en que en un mismo segundo lleguen distintas cantidades de usuarios al mismo tiempo. Los resultados se ven reflejados en la siguiente tabla:

Numero de Usuarios | Solicitudes completadas |
--|--
50 | 50
100 | 100
500 | 500 
1000 |1000
5000 | 4960
6000 | 5758
8000 | 5684

Ya al presentar más de 5000 solicitudes en un segundo el sistema comienza a presentar fallas, no pudiendo lograr todas las solicitudes. En el caso de tener ya 8000 solicitudes en el mismo instante solo se obtiene un éxito en el 70% aproximadamente de éstas, y se debe considerar además que el sistema está corriendo en una máquina local, por lo que si se usara un servidor debería ser uno con elevadas características.
