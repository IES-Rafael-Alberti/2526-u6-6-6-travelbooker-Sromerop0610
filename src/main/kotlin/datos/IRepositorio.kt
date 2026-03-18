package datos

interface IRepositorio<T> {
    fun agregar(elemento: T)

    fun obtenerTodos(): List<T>
}