package presentacion

import datos.RepositorioMemoria
import dominio.Reserva
import servicios.ReservaService

fun main() {

    val repositorio = RepositorioMemoria<Reserva>()

    val servicio = ReservaService(repositorio)

    while (true) {

        println()
        println("1. Crear reserva de vuelo")
        println("2. Crear reserva de hotel")
        println("3. Listar reservas")
        println("4. Salir")
        print("Opción: ")

        when (readLine()) {

            "1" -> {

                print("Descripción: ")
                val descripcion = readLine()!!

                print("Origen: ")
                val origen = readLine()!!

                print("Destino: ")
                val destino = readLine()!!

                print("Hora (HH:mm): ")
                val hora = readLine()!!

                servicio.crearReservaVuelo(
                    descripcion,
                    origen,
                    destino,
                    hora
                )

            }

            "2" -> {

                print("Descripción: ")
                val descripcion = readLine()!!

                print("Ubicación: ")
                val ubicacion = readLine()!!

                print("Número de noches: ")
                val noches = readLine()!!.toInt()

                servicio.crearReservaHotel(
                    descripcion,
                    ubicacion,
                    noches
                )

            }

            "3" -> {

                val reservas = servicio.listarReservas()

                for (reserva in reservas) {
                    println(reserva.detalle)
                }

            }

            "4" -> return

        }
    }
}