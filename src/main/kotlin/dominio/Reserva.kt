package dominio

import java.time.LocalDateTime

abstract class Reserva(val descripcion: String) {
    val id: Int
    val fechaCreacion: LocalDateTime = LocalDateTime.now()

    companion object {
        private var contador = 0
    }

    init {
        contador += 1
        id = contador
    }

    open val detalle: String
        get() = "$id + $descripcion"
}