# Actividad: Desarrollo de Proyecto Software en Kotlin

**ID actividad:** 2425_PRO_u4u5u6_taskManager

**Agrupamiento de la actividad**: Individual 

---

### Descripción: **Ejercicio: Gestor de Reservas para una Agencia de Viajes**

En este ejercicio, crearás una plicación en la que aplicarás los conceptos de Programación Orientada a Objetos (POO) en Kotlin, incluyendo herencia, interfaces, clases abstractas, principios SOLID y arquitectura en capas. La aplicación simula un gestor de reservas para una agencia de viajes, permitiendo la creación y consulta de reservas de vuelo y de hotel. 

#### **Contexto y Objetivo**

Desarrolla una aplicación de consola en Kotlin que permita gestionar **reservas** en una agencia de viajes. Estas reservas se dividen en dos tipos: **Reserva de Vuelo** y **Reserva de Hotel**. Ambas derivan de una superclase o interfaz denominada **Reserva**.

La aplicación debe seguir una **arquitectura en capas**, separando claramente:
- **La capa de presentación (UI):** se encarga de la interacción con el usuario a través de la consola.
- **La capa de lógica de aplicación:** gestiona la lógica de negocio (creación, almacenamiento y manejo de reservas).
- **La capa de acceso a datos:** aunque en este ejercicio se puede utilizar un repositorio en memoria, se debe abstraer su acceso mediante interfaces, aplicando el principio de inversión de dependencias.

#### **Requerimientos Funcionales y No Funcionales**

1. **Arquitectura en Capas y Principio de Inversión de Dependencias**
  - La lógica de negocio debe depender de abstracciones (por ejemplo, interfaces de repositorios) y no de implementaciones concretas.
  - La comunicación entre la interfaz de usuario y la lógica de negocio debe estar claramente separada.

2. **Modelo de Dominio: Reserva, Reserva de Vuelo y Reserva de Hotel**
  - **Reserva (Superclase o Interfaz):**
    - Contendrá la lógica común a todas las reservas, aunque no se permitirá la creación de una instancia de la misma.
    - Posee un **id**. Se asigna automáticamente al crear la instancia. No puede ser nula y no se puede modificar.
    - Posee una **fechaCreacion**. Se asigna automáticamente al crear la instancia. No puede ser nula y no se puede modificar.
    - Posee una **descripcion**. No puede ser nula (por ejemplo, descripción del itinerario o servicio).
    - Debe incluir una propiedad `detalle`, cuyo getter utilice la lógica común para concatenar el *id* y la descripción.
  - **Reserva de Vuelo:**
    - Hereda las propiedades de Reserva.
    - Posee atributos propios: **origen**, **destino** y **horaVuelo**.
    - La propiedad **detalle** se genera dinámicamente, por ejemplo:  
      `id + " - " + descripcion + " - " + origen + " -> " + destino [horaVuelo]`.
    - Su constructor es **privado**. Se debe disponer de un método de clase (companion object) llamado `creaInstancia` para generar una nueva instancia.
    - Sobreescribe `toString` para mostrar formateada toda la información de la reserva de vuelo.
  - **Reserva de Hotel:**
    - Hereda las propiedades de Reserva.
    - Posee atributos propios: **ubicacion** y **numeroNoches**.
    - La propiedad **detalle** se genera dinámicamente, por ejemplo:  
      `id + " - " + descripcion + " - " + ubicacion (numeroNoches)`.
    - Al igual que Reserva de Vuelo, su constructor es privado y se debe utilizar el método `creaInstancia` para crear instancias.
    - Sobreescribe `toString` para mostrar formateada toda la información de la reserva de hotel.

3. **Buenas Prácticas y Principios SOLID**
  - Utiliza el principio de **inversión de dependencias**: la lógica de negocio no debe depender de clases concretas para el almacenamiento de las reservas.
  - Documenta y comenta el código de forma clara, explicando las decisiones de diseño, especialmente aquellas que no están explícitamente indicadas en la descripción.
  - Separa los métodos estáticos (en Kotlin se implementan mediante *companion objects*) y asegúrate de que la creación de instancias se haga mediante el método `creaInstancia`.
  - Integra el uso de **clases genéricas** (por ejemplo, en la implementación del repositorio) y **expresiones regulares** para validar ciertos formatos de entrada (por ejemplo, el formato de la hora en la Reserva de Vuelo).

4. **Interfaz de Usuario (Consola)**
  - La aplicación debe interactuar con el usuario a través de la consola, mostrando un menú que permita:
    - Crear una nueva reserva (seleccionando entre Reserva de Vuelo o Reserva de Hotel).
    - Listar todas las reservas registradas, mostrando el detalle de cada reserva mediante polimorfismo.
  - La capa de presentación debe comunicarse con la lógica de negocio a través de interfaces o abstracciones.

5. **Lógica de Aplicación**
  - Implementa un servicio (por ejemplo, `ReservaService`) que gestione la creación, almacenamiento (en memoria) y consulta de reservas.
  - Este servicio debe depender de una interfaz de repositorio (por ejemplo, `IReservaRepository`), permitiendo cambiar la implementación del almacenamiento sin afectar la lógica de negocio. Es decir, debéis aplicar el ppio DIP e inyectar en esta clase `ReservaService` un repositorio a través de la abstracción `IReservaRepository`.

#### **Objetivos del Ejercicio**

- Demostrar la comprensión de los fundamentos de la Programación Orientada a Objetos mediante la instanciación y uso de objetos.
- Aplicar conceptos avanzados de POO como herencia, clases abstractas e interfaces.
- Crear y utilizar clases que hagan uso de genéricos.
- Aplicar principios SOLID, especialmente la inversión de dependencias.
- Emplear expresiones regulares para la validación de entradas.
- Integrar y utilizar librerías externas para extender la funcionalidad del proyecto.
- Documentar y presentar el código de manera clara y comprensible.

#### **Trabajo a Realizar**

1. **Definición de Clases y Estructura del Proyecto**
  - Organiza el proyecto en paquetes (o módulos) que representen cada capa:
    - `presentacion` para la interfaz de usuario.
    - `servicios` (o `aplicacion`) para la lógica de negocio.
    - `datos` para la implementación del repositorio (en memoria).
    - `dominio` para definir las clases **Reserva**, **Reserva de Vuelo** y **Reserva de Hotel**.

2. **Implementación del Modelo de Dominio**
  - Define la superclase o interfaz `Reserva` que incluya:
    - Las propiedades comunes (`id`, `fechaCreacion`, `descripcion` y `detalle`).
    - La lógica compartida que consideres necesaria.
  - Implementa las clases `Reserva de Vuelo` y `Reserva de Hotel` siguiendo las especificaciones:
    - Campos inmutables (por ejemplo, `id` y `fechaCreacion` generados automáticamente).
    - Las propiedades específicas de cada una (`origen`, `destino`, `horaVuelo`) y (`ubicacion`, `numeroNoches`)
    - Constructores privados con el método `creaInstancia` en el *companion object*.
    - Propiedad `detalle` que concatene la información de forma dinámica.

3. **Desarrollo de la Lógica de Aplicación**
  - Implementa un servicio (`ReservaService`) que:
    - Utilice una interfaz de repositorio (`IReservaRepository`) para almacenar y recuperar reservas (`agregar` y `obtenerTodas`).
    - Permita la creación de nuevas reservas mediante métodos que invoquen `creaInstancia` de cada clase.
  - Aplica el principio de inversión de dependencias, de modo que el servicio dependa de la abstracción, no de una implementación concreta.

4. **Interfaz de Usuario (Consola)**
  - Desarrolla una interfaz de usuario en consola que muestre un menú con las siguientes opciones:
    - **Opción 1:** Crear nueva reserva (se debe preguntar al usuario si desea crear una Reserva de Vuelo o de Hotel, y solicitar los datos requeridos).
    - **Opción 2:** Listar todas las reservas registradas, mostrando el detalle (id y descripción) de cada reserva.
  - La capa de presentación debe comunicarse con el servicio para realizar las operaciones solicitadas.

5. **Documentación y Pruebas**
  - Comenta el código de forma clara, explicando las decisiones de diseño y la aplicación de los principios SOLID.
  - Realiza pruebas y depura la aplicación para asegurar su correcto funcionamiento.

### Recursos

- Apuntes dados en clase sobre programación orientada a objetos, Kotlin, uso de IDEs, y manejo de librerías.
- Recursos vistos en clase, incluyendo ejemplos de código, documentación de Kotlin, y guías de uso de librerías.

### Evaluación y calificación

**RA y CE evaluados**: Resultados de Aprendizaje 2, 4, 6, 7 y Criterios de Evaluación asociados.

**Conlleva presentación**: SI

**Rúbrica**: Más adelante se enviará o mostrará la rúbrica de esta práctica.

### Entrega

> **La entrega tiene que cumplir las condiciones de entrega para poder ser calificada. En caso de no cumplirlas podría calificarse como no entregada.**
>
- **Conlleva la entrega de URL a repositorio:** El contenido se entregará en un repositorio GitHub. 
- **Respuestas a las preguntas:** Deben contestarse, de manera clara y detallada en este fichero, README.md

    - Al final del documento, incluid un nuevo apartado, que se llame: "Entrega de la Práctica", dónde nos realicéis una pequeña introducción explicativa de vuestro tema, es decir, el problema que vais a solucionar y cómo lo habéis resuelto. Podéis incluir los subapartados que consideréis necesarios (estructura de carpetas, explicación y organización de clases, instrucciones de instalación, manual de usuario, ejemplos de funcionamiento, etc.)

    - **MUY IMPORTANTE!!** Incluir un subapartado ("Respuestas a las preguntas planteadas") dónde se resuelvan las preguntas de evaluación que os realizamos a continuación. De forma clara y detallada, incluyendo enlaces al código que justifica vuestra respuesta si es necesario.

# Preguntas para la Evaluación

Este conjunto de preguntas está diseñado para ayudarte a reflexionar sobre cómo has aplicado los criterios de evaluación en tu proyecto. Al responderlas, [**asegúrate de hacer referencia y enlazar al código relevante**](https://docs.github.com/es/get-started/writing-on-github/working-with-advanced-formatting/creating-a-permanent-link-to-a-code-snippet) en tu `README.md`, facilitando así la evaluación de tu trabajo.

#### **Criterio global 1: Instancia objetos y hacer uso de ellos**
- **(2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.e, 4.f)**: Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? Proporciona ejemplos específicos de tu código.

#### **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.h)**: ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?
- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?

#### **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa.

#### **Criterio global 4: Definir clases y su contenido**
- **(4.a, 4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?

#### **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.g, 7.a, 7.b, 7.c, 7.i, 7.j)**: Describe sobre tu código cómo has implementado la herencia y/o utilizado interfaces en tu proyecto. ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? Mostrando tu código, contesta qué principios has utilizado y qué beneficio has obtenido.

#### **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?

#### **Criterio global 7: Librerías de clases**
- **(2.g, 4.i)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.

#### **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?

#### **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido?

#### **Criterio global 10: Expresiones Regulares**
- **(6.g)**: Muestra ejemplos de tu código donde hayas utilizado las expresiones regulares. ¿Qué beneficio has obtenido?

## Entrega de la práctica


### 1. Introducción

En esta práctica se ha desarrollado una aplicación en Kotlin para la **gestión de reservas**, concretamente de **vuelos y hoteles**.

El problema que se pretende solucionar es la necesidad de **crear, almacenar y consultar reservas** de distintos tipos de forma estructurada, manteniendo un diseño limpio y escalable.

Para resolverlo, se ha implementado una arquitectura en capas que separa responsabilidades:

* **Presentación**: interacción con el usuario (menú por consola).
* **Servicios**: lógica de negocio.
* **Dominio**: definición de las entidades (reservas).
* **Datos**: almacenamiento (repositorio en memoria).

Este enfoque permite que el sistema sea fácilmente ampliable (por ejemplo, añadiendo nuevos tipos de reservas sin modificar el resto del código).

---

### 2. Estructura de carpetas

El proyecto está organizado en cuatro paquetes principales:

* **presentacion**
  Contiene el `main`, que gestiona el menú y la interacción con el usuario.

* **servicios**
  Incluye la clase `ReservaService`, que actúa como intermediaria entre la presentación y el dominio.

* **dominio**
  Contiene las clases del modelo:

    * `Reserva` (clase abstracta)
    * `ReservaHotel`
    * `ReservaVuelo`

* **datos**
  Define el acceso a datos:

    * `IRepositorio<T>` (interfaz)
    * `RepositorioMemoria<T>` (implementación en memoria)

---

### 3. Organización y explicación de clases

#### 3.1 Clase abstracta `Reserva`

Es la clase base de todas las reservas:

```kotlin
abstract class Reserva(val descripcion: String) {
    val id: Int
    val fechaCreacion: LocalDateTime = LocalDateTime.now()
}
```

* Genera automáticamente un **ID único**.
* Guarda la **fecha de creación**.
* Define una propiedad `detalle` que se sobrescribe en las subclases.

---

#### 3.2 Subclases

##### ReservaHotel

```kotlin
class ReservaHotel private constructor(
    descripcion: String,
    val ubicacion: String,
    val numeroNoches: Int
) : Reserva(descripcion)
```

* Representa reservas de hotel.
* Usa una **factoría (`crearInstancia`)** para controlar la creación.

Ejemplo de detalle:

```kotlin
"$id + $descripcion -> $ubicacion [$numeroNoches]"
```

---

##### ReservaVuelo

```kotlin
class ReservaVuelo private constructor(
    descripcion: String,
    val origen: String,
    val destino: String,
    val horaVuelo: String
) : Reserva(descripcion)
```

* Representa reservas de vuelos.
* Valida el formato de la hora con una expresión regular:

```kotlin
require(regexHora.matches(horaVuelo)) {
    "La hora debe tener formato HH:mm"
}
```

---

#### 3.3 Servicio (`ReservaService`)

Gestiona la lógica de negocio:

```kotlin
fun crearReservaVuelo(...) {
    val reserva = ReservaVuelo.creaInstancia(...)
    repositorio.agregar(reserva)
}
```

* Se encarga de:

    * Crear objetos del dominio
    * Guardarlos en el repositorio
    * Obtener todas las reservas

---

#### 3.4 Repositorio

Interfaz:

```kotlin
interface IRepositorio<T> {
    fun agregar(elemento: T)
    fun obtenerTodos(): List<T>
}
```

Implementación en memoria:

```kotlin
class RepositorioMemoria<T> : IRepositorio<T> {
    private val elementos = mutableListOf<T>()
}
```

* Permite almacenar datos sin depender de base de datos.
* Facilita cambiar la implementación en el futuro.

---

### 4. Manual de usuario

El programa funciona mediante consola con un menú interactivo:

```
1. Crear reserva de vuelo
2. Crear reserva de hotel
3. Listar reservas
4. Salir
```

#### Ejemplo de uso:

* Opción 1 → crear vuelo
* Opción 2 → crear hotel
* Opción 3 → mostrar reservas

---

### 5. Ejemplo de funcionamiento

#### Crear reserva de vuelo:

Entrada:

```
Descripción: Viaje a Madrid
Origen: Cádiz
Destino: Madrid
Hora: 14:30
```

Se ejecuta:

```kotlin
servicio.crearReservaVuelo(
    descripcion,
    origen,
    destino,
    hora
)
```

---

#### Listar reservas:

```kotlin
val reservas = servicio.listarReservas()

for (reserva in reservas) {
    println(reserva.detalle)
}
```

Salida esperada:

```
1 + Viaje a Madrid + Cádiz -> Madrid [14:30]
2 + Hotel vacaciones -> Sevilla [3]
```

---

### 6. Conclusión

Se ha desarrollado una aplicación modular y bien estructurada que permite gestionar reservas de forma sencilla.

El uso de:

* **Herencia (Reserva)**
* **Patrón repositorio**
* **Separación en capas**

Permite que el sistema sea **escalable, mantenible y fácil de entender**.


## RESPUESTA A LAS PREGUNTAS
### Criterio global 1: Instancia objetos y uso de los mismos

En este proyecto se ha trabajado intensamente con la **instanciación de objetos**, aplicando buenas prácticas como el uso de **constructores privados**, **métodos factoría** y el paso de parámetros entre capas (presentación → servicio → dominio → datos).

---

#### 1. Instanciación de objetos

La creación de objetos no se hace directamente con el constructor, sino mediante **métodos factoría definidos en las clases del dominio**. Esto permite controlar la creación y validar datos.

##### Ejemplo: creación de una reserva de vuelo

```kotlin
val reserva = ReservaVuelo.creaInstancia(
    descripcion,
    origen,
    destino,
    hora
)
```

En este caso:

* No se usa el constructor directamente (`private constructor`)
* Se usa el método `creaInstancia`, que valida los datos antes de crear el objeto

```kotlin
require(regexHora.matches(horaVuelo)) {
    "La hora debe tener formato HH:mm"
}
```

Esto garantiza que todos los objetos creados sean válidos.

---

#### 2. Uso de constructores

Se han utilizado **constructores privados** en las clases del dominio:

```kotlin
class ReservaVuelo private constructor(...)
```

Esto obliga a que la creación de objetos pase por la lógica definida en el `companion object`, mejorando el control y la seguridad.

Además, en la clase base `Reserva` se utiliza el constructor para inicializar atributos comunes:

```kotlin
abstract class Reserva(val descripcion: String)
```

Y dentro del `init`:

```kotlin
init {
    contador += 1
    id = contador
}
```

Aquí se asigna automáticamente un **ID único** a cada objeto instanciado.

---

#### 3. Paso de parámetros entre métodos

El paso de parámetros se realiza en varias capas del sistema:

##### Desde presentación → servicio

En el `main`, el usuario introduce datos que se pasan al servicio:

```kotlin
servicio.crearReservaVuelo(
    descripcion,
    origen,
    destino,
    hora
)
```

---

##### Desde servicio → dominio

El servicio recibe esos parámetros y los usa para crear el objeto:

```kotlin
fun crearReservaVuelo(
    descripcion: String,
    origen: String,
    destino: String,
    hora: String
)
```

---

##### Desde servicio → repositorio

Una vez creado el objeto, se pasa como parámetro al repositorio:

```kotlin
repositorio.agregar(reserva)
```

Aquí se está utilizando un objeto del tipo `Reserva` ya instanciado.

---

#### 4. Uso de objetos

Los objetos creados se utilizan principalmente para:

##### Almacenamiento

```kotlin
private val elementos = mutableListOf<T>()
```

Se almacenan en memoria mediante una lista en el repositorio.

### Criterio global 2: Crear y llamar métodos estáticos

#### Métodos y propiedades estáticas definidas

En el proyecto se han definido elementos estáticos mediante `companion object` en varias clases del dominio.

##### 1. Método estático en `ReservaVuelo`

```kotlin
companion object {

    private val regexHora = Regex("^([01]?\\d|2[0-3]):[0-5]\\d$")

    fun creaInstancia(
        descripcion: String,
        origen: String,
        destino: String,
        horaVuelo: String
    ): ReservaVuelo {
        require(regexHora.matches(horaVuelo)) {
            "La hora debe tener formato HH:mm"
        }
        return ReservaVuelo(descripcion, origen, destino, horaVuelo)
    }
}
```

**Objetivo:**

* Permitir crear objetos validando previamente los datos.
* Centralizar la lógica de creación en un único punto.

**Por qué es estático:**

* No depende de ningún objeto previo de `ReservaVuelo`.
* Se necesita llamar antes de que exista la instancia.
* Permite controlar la creación al tener el constructor como `private`.

---

##### 2. Método estático en `ReservaHotel`

```kotlin
companion object {
    fun crearInstancia(
        descripcion: String,
        ubicacion: String,
        numeroNoches: Int
    ) : ReservaHotel {
        return ReservaHotel(descripcion, ubicacion, numeroNoches)
    }
}
```

**Objetivo:**

* Crear instancias de la clase de forma controlada.

**Por qué es estático:**

* Igual que en el caso anterior, no depende de una instancia existente.
* Se utiliza como punto de acceso para crear objetos.

---

##### 3. Propiedad estática en `Reserva`

```kotlin
companion object {
    private var contador = 0
}
```

**Objetivo:**

* Mantener un contador común para generar identificadores únicos.

**Por qué es estática:**

* El valor debe ser compartido entre todas las instancias.
* Si no fuera estática, cada objeto tendría su propio contador y no se generarían IDs únicos.

---

#### Uso de métodos y propiedades estáticas

##### 1. Llamada a métodos estáticos

Los métodos estáticos se utilizan desde la clase `ReservaService`.

Ejemplo:

```kotlin
val reserva = ReservaVuelo.creaInstancia(
    descripcion,
    origen,
    destino,
    hora
)
```

Y:

```kotlin
val reserva = ReservaHotel.crearInstancia(
    descripcion,
    ubicacion,
    noches
)
```

En ambos casos:

* Se llama al método directamente desde la clase
* No es necesario crear un objeto previo

---

##### 2. Uso de la propiedad estática

La propiedad `contador` se utiliza en el bloque `init` de la clase `Reserva`:

```kotlin
init {
    contador += 1
    id = contador
}
```

Aquí:

* Cada vez que se crea una nueva instancia, se incrementa el contador común
* Se asigna un ID único al objeto
---

## Criterio global 3: Uso de entornos

Para el desarrollo del proyecto se ha utilizado el IDE **IntelliJ IDEA**, que ha permitido gestionar todo el ciclo de desarrollo: creación, compilación y pruebas del programa.

---

### 1. Creación del proyecto

El proyecto se creó desde IntelliJ seleccionando un proyecto de **Kotlin/JVM**.

Dentro del IDE se organizaron los paquetes manualmente siguiendo una estructura en capas:

* `presentacion`
* `servicios`
* `dominio`
* `datos`

También se crearon las clases necesarias desde el propio entorno, como por ejemplo:

* `ReservaService`
* `Reserva`, `ReservaHotel`, `ReservaVuelo`
* `RepositorioMemoria`

El IDE facilita esto mediante asistentes para crear clases y paquetes automáticamente.

---

### 2. Escritura y edición de código

IntelliJ se ha utilizado para programar el código aprovechando:

* Autocompletado
* Detección de errores en tiempo real
* Formateo automático

Por ejemplo, al escribir métodos como:

```kotlin
fun crearReservaVuelo(...)
```

el IDE sugiere tipos, parámetros y posibles errores, lo que agiliza el desarrollo.

---

### 3. Compilación y ejecución

La compilación y ejecución del programa se ha realizado directamente desde IntelliJ, ejecutando la clase `main`:

```kotlin
fun main() {
    val repositorio = RepositorioMemoria<Reserva>()
    val servicio = ReservaService(repositorio)
}
```

El IDE se encarga automáticamente de:

* Compilar el código
* Ejecutar el programa en la consola integrada

---

### 4. Pruebas del programa

Las pruebas se han realizado ejecutando el programa y utilizando el menú interactivo:

```text
1. Crear reserva de vuelo
2. Crear reserva de hotel
3. Listar reservas
4. Salir
```

Se han probado distintos casos:

* Creación correcta de reservas
* Validación de la hora en vuelos (formato HH:mm)
* Visualización de reservas almacenadas

Por ejemplo, al introducir una hora incorrecta, el programa lanza un error debido a:

```kotlin
require(regexHora.matches(horaVuelo))
```

---

## Criterio global 4: Definir clases y su contenido

En el proyecto se han definido varias clases para representar el problema de la gestión de reservas. Un ejemplo claro es la jerarquía formada por `Reserva`, `ReservaHotel` y `ReservaVuelo`.

---

### 1. Definición de clases y representación del mundo real

Se identificó la clase `Reserva` como elemento común del dominio, ya que tanto los vuelos como los hoteles comparten características como una **descripción, un identificador y una fecha de creación**.

```kotlin id="q2y5a7"
abstract class Reserva(val descripcion: String) {
    val id: Int
    val fechaCreacion: LocalDateTime = LocalDateTime.now()
}
```

Esta clase representa una reserva genérica del mundo real.

A partir de ella se definieron clases más específicas:

* `ReservaHotel` → reservas de alojamiento
* `ReservaVuelo` → reservas de transporte

---

### 2. Propiedades

Las propiedades se definieron según la información necesaria de cada tipo de reserva.

Ejemplo en `ReservaHotel`:

```kotlin id="2em3t0"
val ubicacion: String
val numeroNoches: Int
```

Ejemplo en `ReservaVuelo`:

```kotlin id="ts6wz8"
val origen: String
val destino: String
val horaVuelo: String
```

Estas propiedades representan directamente datos del mundo real (lugar, duración, origen, etc.).

---

### 3. Métodos

Se definieron métodos para:

* Crear objetos (`crearInstancia`, `creaInstancia`)
* Obtener información (`detalle`)
* Representar el objeto (`toString`)

Ejemplo:

```kotlin id="k6bq6p"
override val detalle: String
    get() = "$id + $descripcion + $origen -> $destino [$horaVuelo]"
```

Este método permite mostrar la información de la reserva de forma clara.

---

### 4. Constructores

Se han utilizado constructores para inicializar los objetos con sus datos:

```kotlin id="f0p7hv"
class ReservaVuelo private constructor(
    descripcion: String,
    val origen: String,
    val destino: String,
    val horaVuelo: String
) : Reserva(descripcion)
```

Además:

* El constructor es `private` para evitar crear objetos sin control
* Se fuerza el uso de métodos específicos para la creación

---

### 5. Modificadores de acceso

Se han utilizado modificadores para controlar el acceso:

* `private constructor` → evita instanciación directa
* `private` en propiedades como el contador → evita acceso externo

Ejemplo:

```kotlin id="hqlgta"
companion object {
    private var contador = 0
}
```

Esto garantiza que el ID solo se gestione dentro de la clase.

---

### 6. Contribución a la solución del problema

Estas clases permiten:

* Representar correctamente distintos tipos de reservas
* Organizar la información de forma clara
* Reutilizar código mediante herencia (`Reserva`)

Gracias a esta estructura:

* Se pueden crear diferentes tipos de reservas sin duplicar lógica
* El sistema es más fácil de mantener y ampliar

Por ejemplo, tanto `ReservaHotel` como `ReservaVuelo` pueden almacenarse y mostrarse de la misma forma, ya que ambas son de tipo `Reserva`.
---

## Criterio global 5: Herencia y uso de clases abstractas e interfaces

### 1. Uso de herencia y clases abstractas

En el proyecto se ha utilizado herencia mediante una clase abstracta `Reserva`, que actúa como base común para los distintos tipos de reservas.

```kotlin id="v5x4n8"
abstract class Reserva(val descripcion: String) {
    val id: Int
    val fechaCreacion: LocalDateTime = LocalDateTime.now()

    open val detalle: String
        get() = "$id + $descripcion"
}
```

A partir de esta clase se han definido subclases:

```kotlin id="nq2b3k"
class ReservaHotel(...) : Reserva(descripcion)
```

```kotlin id="k1l9mz"
class ReservaVuelo(...) : Reserva(descripcion)
```

**Motivo de este enfoque:**

* Evitar duplicación de código (id, descripción, fecha)
* Definir una estructura común para todas las reservas

**Beneficio:**

* Permite tratar todos los objetos como `Reserva`, independientemente de su tipo concreto

---

### 2. Uso de interfaces

Se ha definido la interfaz genérica `IRepositorio<T>`:

```kotlin id="z8x3we"
interface IRepositorio<T> {
    fun agregar(elemento: T)
    fun obtenerTodos(): List<T>
}
```

Y su implementación:

```kotlin id="u4c7pj"
class RepositorioMemoria<T> : IRepositorio<T> {
    private val elementos = mutableListOf<T>()
}
```

**Motivo de este enfoque:**

* Separar la definición del repositorio de su implementación

**Beneficio:**

* Permite cambiar la forma de almacenamiento sin afectar al resto del código

---

### 3. Uso en el servicio

El servicio depende de la interfaz, no de la implementación concreta:

```kotlin id="y6t2qb"
class ReservaService(
    private val repositorio: IRepositorio<Reserva>
)
```

Esto permite trabajar con cualquier tipo de repositorio que implemente la interfaz.

---

### 4. Principios SOLID aplicados

#### a) Principio de responsabilidad única (SRP)

Cada clase tiene una única responsabilidad:

* `Reserva` → representar datos de una reserva
* `ReservaService` → lógica de negocio
* `RepositorioMemoria` → almacenamiento

**Beneficio:**
Código más organizado y fácil de mantener.

---

#### b) Principio abierto/cerrado (OCP)

Las clases están abiertas a extensión pero cerradas a modificación.

Ejemplo:

* Se pueden añadir nuevas clases como `ReservaCoche` sin modificar `Reserva`

```kotlin id="c2m7ax"
class ReservaCoche(...) : Reserva(descripcion)
```

**Beneficio:**
Facilidad para ampliar el sistema sin romper código existente.

---

#### c) Principio de sustitución de Liskov (LSP)

Las subclases pueden sustituir a la clase base:

```kotlin id="v7f9pq"
val reservas: List<Reserva> = servicio.listarReservas()
```

Aquí pueden aparecer objetos de tipo:

* `ReservaHotel`
* `ReservaVuelo`

**Beneficio:**
Uso uniforme de diferentes tipos de objetos.

---

#### d) Principio de segregación de interfaces (ISP)

La interfaz `IRepositorio` es simple y contiene solo los métodos necesarios:

```kotlin id="p9w3lm"
fun agregar(elemento: T)
fun obtenerTodos(): List<T>
```

**Beneficio:**
Evita obligar a implementar métodos innecesarios.

---

#### e) Principio de inversión de dependencias (DIP)

El servicio depende de una abstracción:

```kotlin id="q1z8ne"
private val repositorio: IRepositorio<Reserva>
```

Y no de una clase concreta.

**Beneficio:**
Mayor flexibilidad y facilidad para cambiar implementaciones.

---

## Criterio global 6: Diseño de jerarquía de clases

### 1. Jerarquía de clases diseñada

La jerarquía principal del proyecto se basa en la clase abstracta `Reserva`, de la que heredan las clases concretas:

* `Reserva` (clase abstracta)

    * `ReservaHotel`
    * `ReservaVuelo`

Ejemplo de la clase base:

```kotlin
abstract class Reserva(val descripcion: String)
```

Ejemplo de una subclase:

```kotlin
class ReservaVuelo(...) : Reserva(descripcion)
```

Esta jerarquía permite representar distintos tipos de reservas que comparten características comunes.

---

### 2. Pruebas y depuración

La jerarquía se ha probado mediante la ejecución del programa desde `main`, creando diferentes tipos de reservas y comprobando su comportamiento.

#### Creación de objetos de distintas subclases

```kotlin
servicio.crearReservaVuelo(
    descripcion,
    origen,
    destino,
    hora
)
```

```kotlin
servicio.crearReservaHotel(
    descripcion,
    ubicacion,
    noches
)
```

#### Comprobación mediante listado

```kotlin
val reservas = servicio.listarReservas()

for (reserva in reservas) {
    println(reserva.detalle)
}
```

Con esto se verifica que:

* Ambas subclases se almacenan correctamente como `Reserva`
* Cada una utiliza su propia implementación de `detalle`

#### Depuración

Se ha comprobado el correcto funcionamiento:

* Verificando que el ID se incrementa correctamente (en `Reserva`)
* Validando datos en `ReservaVuelo`:

```kotlin
require(regexHora.matches(horaVuelo))
```

* Revisando la salida por consola para confirmar que cada tipo muestra su información correctamente

---

### 3. Tipo de herencia utilizada

En el proyecto se ha utilizado principalmente **herencia por especialización**.

* `Reserva` representa un concepto general
* `ReservaHotel` y `ReservaVuelo` son versiones más específicas

Ejemplo:

```kotlin
abstract class Reserva(...)
class ReservaHotel(...) : Reserva(...)
class ReservaVuelo(...) : Reserva(...)
```

**Justificación:**

* Cada subclase añade información específica (ubicación, noches, origen, destino, etc.)
* Mantienen la estructura común definida en la clase base

---

## Criterio global 7: Librerías de clases

En este proyecto no se han utilizado **librerías externas**, pero sí se han utilizado **librerías estándar de Kotlin/Java**, concretamente la API de fechas.

---

### 1. Librería utilizada

Se ha utilizado la librería estándar de Java:

```kotlin
import java.time.LocalDateTime
```

---

### 2. Motivo de uso

Se eligió `LocalDateTime` para poder:

* Registrar automáticamente la **fecha y hora de creación** de cada reserva
* Evitar tener que implementar manualmente la gestión de fechas

Es una solución fiable y ya integrada en el lenguaje.

---

### 3. Uso en el proyecto

Se utiliza en la clase `Reserva`:

```kotlin id="e1m7qv"
val fechaCreacion: LocalDateTime = LocalDateTime.now()
```

Cada vez que se crea una instancia de `Reserva` (o de sus subclases), se asigna automáticamente la fecha actual.

---

### 4. Cómo se incorporó

No fue necesario añadir dependencias externas, ya que:

* `java.time` forma parte de la biblioteca estándar
* Solo se necesitó importar la clase con `import`

---

### 5. Funcionalidad añadida

El uso de esta librería permite:

* Asociar una fecha real a cada reserva
* Mostrar información más completa del objeto

Ejemplo en el método `toString` de `ReservaHotel`:

```kotlin id="d4k9pt"
Creación: $fechaCreacion
```

---

## Criterio global 8: Documentado

### 1. Documentación y comentarios en el código

En el proyecto no se ha realizado una documentación extensa con comentarios, pero el código se ha escrito de forma **clara y legible**, utilizando nombres descriptivos en clases, métodos y variables que facilitan su comprensión sin necesidad de muchos comentarios.

Por ejemplo:

```kotlin
fun crearReservaVuelo(
    descripcion: String,
    origen: String,
    destino: String,
    hora: String
)
```

Los nombres indican claramente qué hace el método y qué representa cada parámetro.

---

Otro ejemplo:

```kotlin
val fechaCreacion: LocalDateTime = LocalDateTime.now()
```

El nombre de la variable describe directamente su función.

---

### 2. Herramientas utilizadas

Se ha utilizado **IntelliJ IDEA**, que proporciona:

* Resaltado de sintaxis
* Autocompletado
* Estructura visual del código

Esto ayuda a entender el código sin necesidad de documentación externa adicional.

---

### 3. Cómo se asegura la comprensión del código

Para facilitar la comprensión y mantenimiento, se han aplicado varias prácticas:

* **Nombres descriptivos** en clases (`ReservaHotel`, `ReservaVuelo`)
* Métodos con nombres claros (`crearReservaHotel`, `listarReservas`)
* Separación en paquetes (`presentacion`, `servicios`, `dominio`, `datos`)

Ejemplo de uso claro:

```kotlin
val reservas = servicio.listarReservas()
```

Se entiende directamente qué hace sin necesidad de comentarios.

---

### 4. Valor para mantenimiento y depuración

El código aporta valor para mantenimiento porque:

* Es fácil identificar qué hace cada parte
* Está organizado por responsabilidades
* Permite localizar errores rápidamente

Por ejemplo, la validación en:

```kotlin
require(regexHora.matches(horaVuelo))
```

facilita detectar errores en la entrada de datos.

---

## Uso de clases con genéricos

### 1. Clase genérica definida

En el proyecto se ha utilizado una **clase genérica** para el repositorio:

```kotlin id="r8s1vw"
class RepositorioMemoria<T> : IRepositorio<T> {

    private val elementos = mutableListOf<T>()

    override fun agregar(elemento: T) {
        elementos.add(elemento)
    }

    override fun obtenerTodos(): List<T> {
        return elementos
    }
}
```

* `<T>` indica que la clase puede trabajar con **cualquier tipo de objeto**.
* `IRepositorio<T>` es también genérica, permitiendo implementar el mismo patrón de almacenamiento para diferentes tipos de datos.

---

### 2. Uso de la clase genérica

Se utiliza en el `main` de la aplicación:

```kotlin id="mj2c7p"
val repositorio = RepositorioMemoria<Reserva>()
val servicio = ReservaService(repositorio)
```

Aquí:

* Se especifica que `T` es `Reserva`
* El repositorio puede almacenar **tanto `ReservaHotel` como `ReservaVuelo`**, gracias al polimorfismo y los genéricos.

---

### 3. Beneficio obtenido

El uso de genéricos aporta varias ventajas:

1. **Reutilización de código**

    * La misma clase `RepositorioMemoria` sirve para cualquier tipo de objeto.

2. **Seguridad de tipos**

    * Se asegura en tiempo de compilación que solo se agregan objetos del tipo correcto.

3. **Flexibilidad**

    * Permite que el repositorio almacene distintas subclases de `Reserva` sin necesidad de crear repositorios específicos para cada una.

---

### 4. Ejemplo de beneficio en acción

Creando reservas de distintos tipos:

```kotlin id="9l5tqw"
servicio.crearReservaVuelo("Viaje a Madrid", "Cádiz", "Madrid", "14:30")
servicio.crearReservaHotel("Hotel vacaciones", "Sevilla", 3)
```

Luego, al listar reservas:

```kotlin id="x4v9nj"
val reservas = servicio.listarReservas()
for (reserva in reservas) {
    println(reserva.detalle)
}
```

* Funciona sin problemas para **ambos tipos** (`ReservaVuelo` y `ReservaHotel`) usando un único repositorio genérico.

---

## Criterio global 10: Expresiones Regulares

### 1. Uso de expresiones regulares en el proyecto

Se han utilizado **expresiones regulares** para validar el formato de la hora en las reservas de vuelo (`ReservaVuelo`):

```kotlin id="k9utsl"
private val regexHora = Regex("^([01]?\\d|2[0-3]):[0-5]\\d$")
```

* Esta expresión valida que la hora esté en formato **HH:mm**
* Acepta horas de `00:00` a `23:59`

---

### 2. Aplicación en el código

Se usa dentro del método estático `creaInstancia`:

```kotlin id="v89z0v"
fun creaInstancia(
    descripcion: String,
    origen: String,
    destino: String,
    horaVuelo: String
): ReservaVuelo {
    require(regexHora.matches(horaVuelo)) {
        "La hora debe tener formato HH:mm"
    }
    return ReservaVuelo(descripcion, origen, destino, horaVuelo)
}
```

* `regexHora.matches(horaVuelo)` devuelve `true` si la hora cumple el formato
* Si no, lanza una excepción y evita crear un objeto con datos inválidos

---

### 3. Beneficios obtenidos

1. **Validación automática de datos**

    * Se asegura que todas las reservas de vuelo tengan una hora válida antes de crear el objeto.

2. **Evitar errores en ejecución**

    * Prevenir entradas incorrectas evita fallos posteriores en la aplicación.

3. **Código más limpio y seguro**

    * La validación se realiza de forma centralizada en el método de creación, sin necesidad de condicionales repetidos en `main` o en `ReservaService`.

---

### 4. Ejemplo de uso práctico

Al crear una reserva:

```kotlin id="mswdek"
servicio.crearReservaVuelo("Viaje a Madrid", "Cádiz", "Madrid", "14:30") // Correcto
servicio.crearReservaVuelo("Viaje a Barcelona", "Cádiz", "Barcelona", "25:00") // Lanza excepción
```

* La primera reserva se crea correctamente
* La segunda no, porque la hora `25:00` no cumple la expresión regular

