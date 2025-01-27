package srangeldev.models

import java.time.LocalDateTime

open class Vehiculo(
    var id: Int = getNextId(),
    var marca: String,
    var matricula: String,
    var kilometros: Int,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val isDeleted: Boolean = false,
    val tipo: Tipo
) {
    companion object {
        private var nextId = 1
        fun getNextId(): Int {
            return nextId++
        }
    }

    fun copy(id: Int, marca: String, matricula: String, kilometros: Int, createdAt: LocalDateTime, updatedAt: LocalDateTime, isDeleted: Boolean): Vehiculo {
        return Vehiculo(id, marca, matricula, kilometros, createdAt, updatedAt, isDeleted, tipo)
    }

    override fun toString(): String {
        return ("Vehiculo=(id=$id, marca=$marca, matricula='$matricula', kilometros=$kilometros, createdAt=$createdAt, updatedAt=$updatedAt, isDeleted=$isDeleted, tipo=$tipo)")
    }
}