package srangeldev.models

import java.time.LocalDateTime

class CocheElectricoImpl(
    marca: String,
    matricula: String,
    kilometros: Int,
    createdAt: LocalDateTime = LocalDateTime.now(),
    updatedAt: LocalDateTime = LocalDateTime.now()
): Vehiculo(marca = marca, matricula = matricula, kilometros = kilometros, createdAt = createdAt, updatedAt = updatedAt), CocheElectrico {
    override fun tiempoCarga() {
        println("El coche electrico tarda en cargar 2 horas")
    }

    override fun toString(): String {
        return ("CocheElectrico=(id=$id, marca=$marca, matricula='$matricula', kilometros=$kilometros, createdAt=$createdAt, updatedAt=$updatedAt))")
    }

    override fun copy(): CocheElectricoImpl {
        return CocheElectricoImpl(marca = marca, matricula = matricula, kilometros = kilometros, createdAt = createdAt, updatedAt = updatedAt)
    }
}

