package srangeldev.models

class Vehiculo(
    var id: Int = getNextId(),
    var marca: String,
    var matricula: String,
    var kilometros: Int,
) {
    companion object {
        private var nextId = 1
        fun getNextId(): Int {
            return nextId++
        }
    }

    override fun toString(): String {
        return ("Vehiculo=(id=$id, marca=$marca, matricula='$matricula', kilometros=$kilometros)")
    }
}