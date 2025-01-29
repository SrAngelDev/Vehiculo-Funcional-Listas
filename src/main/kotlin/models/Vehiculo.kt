package srangeldev.models

import java.time.LocalDateTime

abstract class Vehiculo(
    var id: Int = 0,
    var marca: String,
    var matricula: String,
    var kilometros: Int,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    var isDeleted: Boolean = false,
) {
    abstract fun copy(): Vehiculo
}

