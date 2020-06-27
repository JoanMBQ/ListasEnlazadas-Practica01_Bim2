package practicaListasEnlazadas;

class Nodo{
    public int valor;
    public Nodo siguiente;

    public void setSiguiente(Nodo sig){
        siguiente = sig;
    }

    public Nodo (int valor, Nodo nodo){
        this.valor = valor;
        this.siguiente = nodo;
    }
}

// ---------------------------------------------- CLASE LISTA ENLAZADA ----------------------------------------------

class Lista_Enlazada {

    private Nodo primero;

    public Lista_Enlazada(){
        primero = null;
    }

    public static void main(String[] args) {

        Lista_Enlazada listaE = new Lista_Enlazada();
        // Insertamos valores al inicio de la lista
        listaE.insertarInicio(8);
        listaE.insertarInicio(5);
        listaE.insertarInicio(3);
        listaE.insertarInicio(7);
        // Insertamos valores al final de la lista
        listaE.insertarFinal(1);
        listaE.insertarFinal(2);
        // Eliminamos los elementos:
        listaE.eliminar(8);
        listaE.eliminar(9);
        // Imprimimos la lista
        listaE.imprimir();
    }

    //---------------------------------------------- METODOS ---------------------------------------------------

    // Metodo para insertar un elemento al inicio de la lista
    public void insertarInicio(int valor){
        Nodo nuevo = new Nodo (valor, primero);
        primero = nuevo;
    }

    // Metodo para insertar un valor al final de la lista
    public void insertarFinal(int valor){
        Nodo nuevo = new Nodo(valor, null);
        if (primero == null)
            primero = nuevo;
        else {
            Nodo actual = primero;
            while (actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.setSiguiente(nuevo);
        }
    }

    // Metodo para borrar un elemento
    public void eliminar(int valor){
        if (primero == null)
            System.out.println("**La lista está vacía**");
        // Condicion en caso de que el nodo a eliminar sea el primero
        else if (primero.valor == valor){
            primero = primero.siguiente;
            System.out.println ("--Nodo con el valor ("+valor+") eliminado--");
        } else {
            Nodo actual = primero;
            while (actual.siguiente != null && actual.siguiente.valor != valor)
                actual = actual.siguiente;
            if (actual.siguiente == null)
                System.out.println ("**No se encontró el nodo con el valor: ("+valor+") **");
            // Condicion para eliminar cualquier nodo
            else{
                actual.setSiguiente(actual.siguiente.siguiente);
                System.out.println ("--Nodo con el valor ("+valor+") eliminado--");
            }
        }
    }

    // Metodo para imprimir la lista enlazada
    public void imprimir(){
        System.out.println("La lista es:");
        Nodo actual = primero;
        while (actual != null){
            System.out.format("valor: = %d \t Nodo = %s \t Nodo sgt = %s\n", actual.valor, actual, actual.siguiente);
            actual = actual.siguiente;
        }
    }
}
