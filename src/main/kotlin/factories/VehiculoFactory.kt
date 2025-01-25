package srangeldev.factories

import srangeldev.models.Vehiculo

class VehiculoFactory {
    companion object {
        fun random(): Vehiculo {
            var marca = arrayOf("Peugueot", "Audi", "BMW", "Citroen", "Mini", "Ferrari", "Lamborguini")
            var matricula = arrayOf("1234ABC", "9876DCG", "2347FGC", "3456DDC", "6379AHC","4921GGG","4239HHD")
            var kilometros = (100000..1000000).random()
            return Vehiculo(marca = marca.random(), matricula = matricula.random(), kilometros = kilometros)
        }
    }
}