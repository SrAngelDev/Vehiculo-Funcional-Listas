package srangeldev.models

class CocheHibridoImpl(
    marca: String ,
    matricula: String,
    kilometros: Int,
    tipo: Tipo = Tipo.COCHE_HIBRIDO
): CocheElectrico, CocheGasolina, Vehiculo(marca = marca, matricula = matricula, kilometros = kilometros, tipo = tipo) {
    override fun tiempoCarga() {
        println("El coche hibrido tiene un tiempo de carga de 1 hora")
    }

    override fun consumo() {
        println("El coche hibrido tiene un consumo de 4,5 Litros a los 100")
    }

    override fun toString(): String {
        return ("CocheHibrido=(id=$id, marca=$marca,matricula=$matricula, kilometros=$kilometros)")
    }
}