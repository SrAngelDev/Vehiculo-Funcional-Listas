package srangeldev.models

import java.time.LocalDateTime

class MotocicletaImpl(
    marca: String,
    matricula: String,
    kilometros: Int,
    createdAt: LocalDateTime = LocalDateTime.now(),
    updatedAt: LocalDateTime = LocalDateTime.now()
): Vehiculo(marca = marca, matricula = matricula, kilometros = kilometros, createdAt = createdAt, updatedAt = updatedAt), Motocicleta {
    override fun cilindrada() {
        println("La motocicleta tiene una cilindrada de 1200cc")
    }
    override fun toString(): String {
        return ("Motocicleta=(id=$id, marca=$marca, matricula=$matricula, kilometros=$kilometros, createdAt=$createdAt, updatedAt=$updatedAt)")
    }

    override fun copy(): MotocicletaImpl {
        return MotocicletaImpl(marca = marca, matricula = matricula, kilometros = kilometros, createdAt = createdAt, updatedAt = updatedAt)
    }
}