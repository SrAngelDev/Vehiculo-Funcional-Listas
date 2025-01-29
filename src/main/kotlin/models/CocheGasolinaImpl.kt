package srangeldev.models

import java.time.LocalDateTime

class CocheGasolinaImpl(
    marca: String,
    matricula: String,
    kilometros: Int,
    createdAt: LocalDateTime = LocalDateTime.now(),
    updatedAt: LocalDateTime = LocalDateTime.now()
): Vehiculo(marca = marca, matricula = matricula, kilometros = kilometros, createdAt = createdAt, updatedAt = updatedAt), CocheGasolina {
    override fun consumo() {
        println("El vehiculo de gasolina tiene un consumo de 6 Litros a los 100")
    }
    override fun toString(): String {
        return ("CocheGasolina=(id=$id, marca=$marca, matricula='$matricula', kilometros=$kilometros, createdAt=$createdAt, updatedAt=$updatedAt))")
    }

    override fun copy(): CocheGasolinaImpl {
        return CocheGasolinaImpl(marca = marca, matricula = matricula, kilometros = kilometros, createdAt = createdAt, updatedAt = updatedAt)
    }
}

