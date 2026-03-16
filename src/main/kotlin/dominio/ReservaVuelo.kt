package dominio

class ReservaVuelo private constructor(
    descripcion: String,
    val origen: String,
    val destino: String,
    val horaVuelo: String
) : Reserva(descripcion) {

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