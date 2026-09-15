// La clase "ListaIterable<T>"es el resultado de Escuderias para poder manejar
// cualquier tipo de listado de
// objetos, no solo escuderias.
// esto mediante generics

// Para poder iterar mediante foreach se debe definir un iterator (interfaz) -
// el foreach solo funciona para lectura ya que se maneja por referencia dado a
// que el lenguaje es fuertemente tipado
// (posicion en memoria) en cambio el iterator es mas flexible
// patron singleton (profundizar, lo veremos en profundidad para el tercer
// parcial de DSI)

//---------------------------------------------------------------------------------------------------------------
// Jerarquia: Colection<E> -->  List ^ --> (Stack) - admite duplicados
//                              Set  ^ --> (TreeSet - HoshSet) - no admite duplicados
//                              Queue^ - colas de prioridades

//            Raiz              Nodo        subnodo

// estos metodos manejan arboles binarios
// todos van a tener un metodo empty, size, add
//---------------------------------------------------------------------------------------------------------------
// Jerarquía: Map --> HashMap<k, v>  - admite cualquier orden el hashmap Ej: Hashmap<categoria, List<Escuderia>> 
// (los atributos contenidos en <> se llaman keyValues)
//---------------------------------------------------------------------------------------------------------------


// Nota: Revisar como puede lograrse esto, además de revisar la creacion de
// objetos iteradores (Clase iteradora).
// en la mayoria de los casos se va a estar utilizando hashmap o arraylist, ya que son los mas utilizados y los mas rapidos

// MUY IMPORTANTE: Revisar concepto de generics, es muy útil e importante.
