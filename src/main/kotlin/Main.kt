package srangeldev

import srangeldev.factories.VehiculoFactory
import srangeldev.repositories.VehiculosRepositoryImpl
import srangeldev.views.View

fun main() {
    val vehiculosRepository = VehiculosRepositoryImpl()

    val v1 = VehiculoFactory.random()
    vehiculosRepository.create(v1)
    println(v1)

    val v2 = VehiculoFactory.random()
    vehiculosRepository.create(v2)
    println(v2)

    val v3 = VehiculoFactory.random()
    vehiculosRepository.create(v3)
    println(v3)

    val v4 = VehiculoFactory.random()
    vehiculosRepository.create(v4)
    println(v4)

    val v5 = VehiculoFactory.random()
    vehiculosRepository.create(v5)
    println(v5)

    val v6 = VehiculoFactory.random()
    vehiculosRepository.create(v6)
    println(v6)

    val view = View(
        vehiculos = vehiculosRepository
    )

    view.mostrarMenuGestion()
}