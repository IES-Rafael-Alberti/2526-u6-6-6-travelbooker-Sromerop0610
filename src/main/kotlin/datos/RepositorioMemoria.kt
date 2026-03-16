package datos

class RepositorioMemoria<T> : IRepositorio<T> {

    private val elementos = mutableListOf<T>()

    override fun agregar(elemento: T) {
        elementos.add(elemento)
    }

    override fun obtenerTodos(): List<T> {
        return elementos
    }

}