class Pila {
    private int cantidad; // Cantidad de contadores en la pila

    // Constructor que inicializa la cantidad de contadores en la pila
    public Pila(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método para quitar una cantidad especificada de contadores de la pila
    public void quitarContadores(int cantidad) {
        this.cantidad -= cantidad;
        if (this.cantidad < 0) {
            this.cantidad = 0;
        }
    }

    // Método para obtener la cantidad de contadores en la pila
    public int getCantidad() {
        return cantidad;
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return cantidad == 0;
    }

    // Método para convertir la cantidad de contadores en la pila a una cadena de texto
    @Override
    public String toString() {
        return Integer.toString(cantidad);
    }}