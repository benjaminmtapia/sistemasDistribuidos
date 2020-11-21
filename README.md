# Pep 1: Creación y Análisis del Sistema Legado
- Andres Alcaíno
- Benjamín Muñoz

### Arquitectura del Sistema
El objetivo del Sistema es recrear la página [comisariavirtual](https://comisariavirtual.cl/) y lograr analizar dicho sistema desde la perspectiva de los Sistemas Distribuidos.
#### Tecnologías:
- Backend: Java Spring-Boot
- Frontend: Vuejs
- Base de Datos: Postgresql

Luego de implementar el sistema, se tiene una arquitectura como la siguiente
![Arquitectura de sistema](/images/Arquitecutra_Pep1.png)
### Características de un Sistema Distribuido


- Transparencia: Está dirigida a ocultar los componentes del Sistema al usuario, para que este lo vea como un todo, en lugar de distintos componentes  independientes conectados. 
- Escalabilidad: Capacidad de adaptación y respuesta del sistema respecto a su propio rendimiento para mejorar la capacidad de trabajo. Esta se divide en vertical (división de capacidad de recursos) y horizontal (división de cantidad de recursos). 
- Apertura: Es la característica de un sistema que permite añadirle nuevas características y servicios de forma dinámica. Esto se logra con el uso de protocolos estándar para la interoperabilidad.
- Disponibilidad Se refiere a la disponibilidad de recursos del sistema. Éste debe ser capaz de acceder a los recursos en todo momento. Si se presentan fallos, el sistema debe ser capaz de acceder a recursos replicados para combatir la pérdida de datos. 
### Análisis del Sistema Implementado

- Transparencia: No existe transparencia en el sistema implementado, debido a que se implementó en un solo equipo y no en distintas componentes. Por lo tanto, al no estar distribuido, no puede considerarse transparente.
- Escalabilidad:
- Apertura: El sistema es abierto ya que usa los estándares de REST API para su funcionamiento, y se utiliza el protocolo HTTP, mientras que las peticiones a la API se realizan en formato JSON.
- Disponibilidad:
### Capacidad de Respuesta del Sistema
Para las pruebas se utiliza Artillery.io, el cual permite simular las peticiones POST al backend del Sistema. 