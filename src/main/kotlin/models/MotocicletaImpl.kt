package srangeldev.models

class MotocicletaImpl(
    marca: String,
    matricula: String,
    kilometros: Int,
    tipo: Tipo = Tipo.MOTOCICLETA
): Vehiculo(marca = marca, matricula = matricula, kilometros = kilometros, tipo = tipo), Motocicleta {
    override fun cilindrada() {
        println("La motocicleta tiene una cilindrada de 1200cc")
    }
    override fun toString(): String {
        return ("Motocicleta=(id=$id, marca=$marca, matricula=$matricula, kilometros=$kilometros)")
    }
}