package Ejercicio10Tarea1;

public class B extends A {

    @Override
    public void metodoHeredable1() {
        // Hacemos algo nuevo propio de Ejercicio10Tarea1.B
        System.out.println("Lógica extra de la clase hija");

        // b. OBLIGAMOS el uso de super para llamar al metodo original de Ejercicio10Tarea1.A.
        // Si pusiéramos solo 'metodoHeredable1()', sería una llamada recursiva infinita a este mismo método.
        super.metodoHeredable1();
    }

}

/*Pregunta a. del 10
El compilador de Java realiza los siguientes pasos internamente para garantizar
que el objeto se inicialice completamente: crea el constructor por defecto en Ejercicio10Tarea1.B
(el compilador inyecta automáticamente un constructor público sin argumentos,
la primera línea de cualquier constructor (explícito o por defecto) siempre es
una llamada al constructor de la clase padre (como no escribimos nada el compilador
inserta super()),
al llegar a la clase Ejercicio10Tarea1.A vía super, como tampoco tiene constructor el compilador vuelve
a inyectar uno por defecto.

La ejecución real fluye así: Object() se inicializa primero -> luego se inicializan los atributos de Ejercicio10Tarea1.A ->
luego se ejecuta el cuerpo del constructor de Ejercicio10Tarea1.A -> luego se inicializan los atributos específicos de Ejercicio10Tarea1.B (si los hubiera) ->
finalmente termina la ejecución del constructor de Ejercicio10Tarea1.B.
 */
