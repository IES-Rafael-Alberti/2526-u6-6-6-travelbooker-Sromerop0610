package dominio

class ReservaHotel private constructor(
    descripcion: String,
    val ubicacion: String,
    val numeroNoches: Int
) : Reserva(descripcion) {
    companion object {
        fun crearInstancia(
            descripcion: String,
            ubicacion: String,
            numeroNoches: Int
        ) : ReservaHotel {
            return ReservaHotel(descripcion, ubicacion, numeroNoches)
        }
    }

    override val detalle: String
        get()= "$id + $descripcion -> $ubicacion [$numeroNoches]"

    override fun toString(): String {
        return """
            Reserva de Hotel:
            ID: $id
            Descripción: $descripcion
            Ubicación: $ubicacion
            Número de noches: $numeroNoches
            Creación: $fechaCreacion
        """.trimIndent()
    }
}