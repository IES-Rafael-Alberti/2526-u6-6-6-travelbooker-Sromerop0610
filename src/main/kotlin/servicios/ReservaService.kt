package servicios

import datos.IRepositorio
import dominio.*

class ReservaService(
    private val repositorio: IRepositorio<Reserva>
) {

    fun crearReservaVuelo(
        descripcion: String,
        origen: String,
        destino: String,
        hora: String
    ) {

        val reserva = ReservaVuelo.creaInstancia(
            descripcion,
            origen,
            destino,
            hora
        )

        repositorio.agregar(reserva)
    }

    fun crearReservaHotel(
        descripcion: String,
        ubicacion: String,
        noches: Int
    ) {

        val reserva = ReservaHotel.crearInstancia(
            descripcion,
            ubicacion,
            noches
        )

        repositorio.agregar(reserva)
    }

    fun listarReservas(): List<Reserva> {
        return repositorio.obtenerTodos()
    }

}