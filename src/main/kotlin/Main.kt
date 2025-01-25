package srangeldev

import srangeldev.factories.VehiculoFactory

fun main() {
    val v1 = VehiculoFactory.random()
    println(v1)

    val v2 = VehiculoFactory.random()
    println(v2)

    val v3 = VehiculoFactory.random()
    println(v3)

    val v4 = VehiculoFactory.random()
    println(v4)

    val v5 = VehiculoFactory.random()
    println(v5)

    val v6 = VehiculoFactory.random()
    println(v6)
}