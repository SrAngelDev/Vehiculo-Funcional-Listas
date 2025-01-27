package srangeldev

import srangeldev.models.*
import srangeldev.views.*
import srangeldev.factories.*
import srangeldev.extensions.*
import srangeldev.repositories.*


import srangeldev.models.*
import srangeldev.views.*
import srangeldev.factories.*
import srangeldev.extensions.*
import srangeldev.repositories.*

fun main() {
    val vehiculoFactory = VehiculoFactory
    val v1 = vehiculoFactory.random()
    val v2 = vehiculoFactory.random()
    val v3 = vehiculoFactory.random()
    val v4 = vehiculoFactory.random()
    val v5 = vehiculoFactory.random()

    val vehiculos = VehiculosRepositoryImpl()
    vehiculos.create(v1)
    vehiculos.create(v2)
    vehiculos.create(v3)
    vehiculos.create(v4)
    vehiculos.create(v5)

    println("Todos los vehículos:")
    vehiculos.findAll().forEach { println(it) }

    println("\nVehículo por ID:")
    println(vehiculos.findById(1))

    println("\nVehículo por matrícula:")
    println(vehiculos.findAll().firstOrNull { it.matricula == "1234ABC" })

    println("\nGuardar un nuevo vehículo:")
    val nuevoVehiculo = CocheGasolinaImpl("Peugueot", "5433JJB", 53000)
    vehiculos.create(nuevoVehiculo)
    vehiculos.findAll().forEach { println(it) }

    println("\nActualizar un vehículo:")
    val vehiculoActualizado = CocheHibridoImpl("Peugueot", "5433JJB", 53000)
    vehiculos.update(1, vehiculoActualizado)
    println(vehiculos.findById(1))

    println("\nBorrar un vehículo:")
    vehiculos.delete(1)
    vehiculos.findAll().forEach { println(it) }

    println("\nTodos los coches de gasolina:")
    vehiculos.filterBy { it?.tipo == Tipo.COCHE_GASOLINA }.forEach { println(it) }

    println("\nTodas las motocicletas:")
    vehiculos.filterBy { it?.tipo == Tipo.MOTOCICLETA }.forEach { println(it) }

    println("\nTodos los coches eléctricos:")
    vehiculos.filterBy { it?.tipo == Tipo.COCHE_ELECTRICO }.forEach { println(it) }

    println("\nContar vehículos:")
    println("Total de vehículos: ${vehiculos.countBy { true }}")


    println("\nMáximo de kilómetros:")
    println("Máximo de kilómetros: ${vehiculos.maxBy({ it.kilometros }, { true })}")

    println("\nMínimo de kilómetros:")
    println("Mínimo de kilómetros: ${vehiculos.minBy({ it.kilometros }, { true })}")

    println("\nMedia de kilómetros:")
    println("Media de kilometros: ${vehiculos.averageBy({ it.kilometros.toDouble() }, { true })}")


    println("\nOrdenar vehículos por ID ascendente:")
    vehiculos.sortedBy(ModoOrdenamiento.ASCENDENTE) { it.id.toDouble() }.forEach { println(it) }

    println("\nOrdenar vehículos por ID descendente:")
    vehiculos.sortedBy(ModoOrdenamiento.DESCENDENTE) { it.id.toDouble() }.forEach { println(it) }

    println("\nOrdenar vehículos por kilómetros ascendente:")
    vehiculos.sortedBy(ModoOrdenamiento.ASCENDENTE) { it.kilometros.toDouble() }.forEach { println(it) }

    println("\nOrdenar vehículos por kilómetros descendente:")
    vehiculos.sortedBy(ModoOrdenamiento.DESCENDENTE) { it.kilometros.toDouble() }.forEach { println(it) }

}

