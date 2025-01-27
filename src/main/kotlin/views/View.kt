package srangeldev.views

import com.github.ajalt.mordant.rendering.TextColors
import org.lighthousegames.logging.logging
import srangeldev.models.Vehiculo
import srangeldev.repositories.VehiculosRepositoryImpl

typealias color = TextColors

class View(
    private val vehiculos: VehiculosRepositoryImpl
) {
    private val logger = logging()

    fun mostrarMenuGestion() {
        println(color.brightYellow("Bienvenido al Concesionario de Vehiculos"))

        var opcion = -1

        do {
            println("Menu de Gestion del Concesionario")
            println("1. Obtener todos los vehiculos disponibles")
            println("2. Buscar vehiculo por ID")
            println("3. Añadir Vehiculo")
            println("4. Actualizar Vehiculo")
            println("5. Eliminar Vehiculo")
            println("6. Obtener Informe de los Vehiculos")
            println("0. Salir")

            println("Opcion elegida: ")
            opcion = readln().toInt() ?: -1
            when (opcion) {
                1 -> obtenerVehiculos()
                2 -> buscarVehiculoPorId()
                3 -> añadirVehiculo()
                4 -> actualizarVehiculo()
                5 -> eliminarVehiculo()
                6 -> informeVehiculo()
                0 -> println("Saliendo del menu...")
            }
        } while (opcion != 0)
    }

    private fun informeVehiculo() {
       TODO()
    }

    private fun eliminarVehiculo() {
        TODO()
    }

    private fun actualizarVehiculo() {
       TODO()
    }

    private fun añadirVehiculo() {
        TODO()
    }

    private fun buscarVehiculoPorId() {
       TODO()
    }


    fun obtenerVehiculos() {
        TODO()
    }
}

