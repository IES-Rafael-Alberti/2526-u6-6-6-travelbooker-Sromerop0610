package dominio

class ReservaVuelo private constructor(
    descripcion: String,
    val origen: String,
    val destino: String,
    val horaVuelo: String
) : Reserva(descripcion) {

    companion object {
        fun creaInstancia(
            descripcion: String,
            origen: String,
            destino: String,
            horaVuelo: String
        ): ReservaVuelo {
            return ReservaVuelo(descripcion, origen, destino, horaVuelo)
        }
    }

    override val detalle: String
        get() = "$id + $descripcion + $origen -> $destino [$horaVuelo]"

    override fun toString(): String {
        return """
            Reserva de Vuelo:
            ID: $id
            Descripción: $descripcion
            Origen: $origen
            Destino: $destino
            Hora de Vuelo: $horaVuelo
            Creación: $fechaCreacion
        """.trimIndent()
    }
}