package srangeldev.models

class CocheElectricoImpl(
    marca: String,
    matricula: String,
    kilometros: Int,
    tipo: Tipo = Tipo.COCHE_ELECTRICO
): Vehiculo(marca = marca, matricula = matricula, kilometros = kilometros, tipo = tipo), CocheElectrico {
    override fun tiempoCarga() {
        println("El coche electrico tarda en cargar 2 horas")
    }

    override fun toString(): String {
        return ("CocheElectrico=(id=$id, marca=$marca, matricula='$matricula', kilometros=$kilometros)")
    }
}