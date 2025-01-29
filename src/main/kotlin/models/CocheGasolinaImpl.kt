package srangeldev.models

class CocheGasolinaImpl(
    marca: String,
    matricula: String,
    kilometros: Int,
): Vehiculo(marca = marca, matricula = matricula, kilometros = kilometros), CocheGasolina {
    override fun consumo() {
        println("El vehiculo de gasolina tiene un consumo de 6 Litros a los 100")
    }
    override fun toString(): String {
        return ("CocheGasolina=(id=$id, marca=$marca, matricula='$matricula', kilometros=$kilometros)")
    }

    override fun copy(): CocheGasolinaImpl {
        return CocheGasolinaImpl(marca = marca, matricula = matricula, kilometros = kilometros)
    }
}