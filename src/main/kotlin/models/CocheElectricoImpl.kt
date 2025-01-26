package srangeldev.models

class CocheElectricoImpl(
    marca: String,
    matricula: String,
    kilometros: Int,
): Vehiculo(marca = marca, matricula = matricula, kilometros = kilometros), CocheElectrico {
    override fun tiempoCarga() {
        println("El coche electrico tarda en cargar 2 horas")
    }

    override fun toString(): String {
        return ("CocheElectrico=(id=$id, marca=$marca, matricula='$matricula', kilometros=$kilometros)")
    }
}