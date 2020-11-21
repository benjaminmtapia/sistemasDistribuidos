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

### Características de un Sistema Distribuido


- Transparencia: Está dirigida a ocultar los componentes del Sistema al usuario, para que este lo vea como un todo, en lugar de distintos componentes  independientes conectados. La transparencia se puede subdidividir en:
- - Transparencia de
- - Transparencia de
- - Transparencia de
- - Transparencia de
 
- Escalabilidad: Capacidad de adaptación y respuesta del sistema respecto a su propio rendimiento para mejorar la capacidad de trabajo. Esta se divide en vertical (división de capacidad de recursos) y horizontal (división de cantidad de recursos). 
- Apertura: Es la característica de un sistema que permite añadirle nuevas características y servicios de forma dinámica. Se consigue mediante una buena especificación y la publicación de las interfaces de los componentes.
- Disponibilidad Se refiere a la disponibilidad de recursos del sistema. Éste debe ser capaz de acceder a los recursos en todo momento. Si se presentan fallos, el sistema debe ser capaz de acceder a recursos replicados para combatir la pérdida de datos. 
### Análisis del Sistema Implementado

### Capacidad de Procesamiento del Sistema