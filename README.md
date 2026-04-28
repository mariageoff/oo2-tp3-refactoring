# Objetos 2 - Intro Refactoring

Mejorando el diseño y la legibilidad sin modificar su funcionalidad.

Escribamos código que otro desarrollador pueda entender! Refactorizamos para:

- Simplificar el Código
- Remover Código Duplicado
- Mejorar el Diseño
- Transformar algo procedural en OO
- Reducir acoplamiento
- Mejorar Cohesión
- Separar en capas
- Hacerlo mas expresivo/legible (nombrar el código)
- Remover código muerto

Todo esto puedo hacerse con seguridad únicamente si tengo buena covertura de tests.

Algunos links de interes:

- [Refactoring Catalog](https://refactoring.com/catalog/)
- [Smells](https://sourcemaking.com/refactoring/smells)
- [Technical Debt](https://en.wikipedia.org/wiki/Technical_debt)

## Introducción

- Extract Method: Dándole semántica a conjuntos de colaboraciones
- Números mágicos: Dándole semántica a las constantes
- Simplificando condicionales: Un único nivel de indentación. *else* no es necesario.
- Parámetros
    - De entrada: Objetos Válidos.
    - De salida: No usamos más *null*. Optional o Listas vacias.
- Collecting parameters: Filtrando colleciones polimórficas (Kent Beck's Collecting Parameters).

## Refactors Automatizados (IntelliJ o Eclipse)

- Ver más en https://www.youtube.com/live/VIofGx85kTY (Victor Rentea)
    - Explicación graciosa en Minuto 40:19 sobre "Encapsulate Field". "Getter/Setter no es OO".

## Ejercicios

Algunos ejercicios tienen tests y otros hay que escribirlos. En dos ejercicios propongo los pasos que deben ejecutar
para refactorizar.

- Ejercicio 1: Utilicemos polimorfismo y tell don't ask.
    - Antes de comenzar a refactorizar, escribamos tests.
- Ejercicio 2, Pasos a realizar:
    - Movamos la lectura del archivo csv a otra clase.
    - Mejoremos el for utizando el foreach.
    - Transformemos el método estático en método de instancia (agreguemos constructor e inicialicemos ahi).
    - Removamos código duplicado del foreach, utilizando expresiones lambda o simplemente extraigan en un método.
    - Removamos las constantes duplicadas.
- Ejercicio 3: Utilicemos polimorfismo y tell don't ask.
    - Escribamos tests. Hagamos lo mínimo para que nos permita testear. Por ejemplo, no usar *sysout*, retornar un
      *String* con el reporte. Esto nos permite asertar contra el valor de retorno.
    - Incorporemos la jerarquía de gastos para utilizar polimorfismo.
    - Apliquemos polimorfismo para eliminar el switch.
    - Apliquemos polimorfismo para eliminar preguntar por el tipo para el calculo del monto de
      comida.
    - Apliquemos polimorfismo para eliminar preguntar por el tipo para la marca de exceso.
- Ejercicio 4: Removamos el uso de *null*.
- Ejercicio 5: Utilicemos polimorfismo y tell don't ask.
    - Contiene un test escrito.

El ejercicio 2 fue tomado de [lamchau](https://github.com/lamchau/refactoring-exercise).