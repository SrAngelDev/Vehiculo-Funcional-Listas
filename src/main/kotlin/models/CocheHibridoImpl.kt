package srangeldev.models

import java.time.LocalDateTime

class CocheHibridoImpl(
    marca: String,
    matricula: String,
    kilometros: Int,
    createdAt: LocalDateTime = LocalDateTime.now(),
    updatedAt: LocalDateTime = LocalDateTime.now()
): CocheElectrico, CocheGasolina, Vehiculo(marca = marca, matricula = matricula, kilometros = kilometros, createdAt = createdAt, updatedAt = updatedAt) {
    override fun tiempoCarga() {
        println("El coche hibrido tiene un tiempo de carga de 1 hora")
    }

    override fun consumo() {
        println("El coche hibrido tiene un consumo de 4,5 Litros a los 100")
    }

    override fun toString(): String {
        return ("CocheHibrido=(id=$id, marca=$marca,matricula=$matricula, kilometros=$kilometros, createdAt=$createdAt, updatedAt=$updatedAt))")
    }

    override fun copy(): CocheHibridoImpl {
        return CocheHibridoImpl(marca = marca, matricula = matricula, kilometros = kilometros, createdAt = createdAt, updatedAt = updatedAt)
    }
}