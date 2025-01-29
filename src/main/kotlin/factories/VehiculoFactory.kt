package srangeldev.factories

import srangeldev.models.CocheElectricoImpl
import srangeldev.models.CocheGasolinaImpl
import srangeldev.models.CocheHibridoImpl
import srangeldev.models.MotocicletaImpl
import srangeldev.models.Vehiculo

import kotlin.random.Random

class VehiculoFactory {
    companion object {
        private val marcas = arrayOf("Peugeot", "Audi", "BMW", "Citroen", "Mini", "Ferrari", "Lamborghini")
        private val consonantes = arrayOf('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z')

        private fun generarMatricula(): String {
            val numeros = (1000..9999).random().toString()
            val letras = (1..3).map { consonantes.random() }.joinToString("")
            return "$numeros$letras"
        }

        fun random(): Vehiculo {
            val kilometros = (0..1000000).random()
            val numRandom = (0..100).random()

            val marca = marcas.random()
            val matricula = generarMatricula()

            return when (numRandom) {
                in 0..25 -> CocheGasolinaImpl(marca = marca, matricula = matricula, kilometros = kilometros)
                in 26..50 -> MotocicletaImpl(marca = marca, matricula = matricula, kilometros = kilometros)
                in 51..75 -> CocheElectricoImpl(marca = marca, matricula = matricula, kilometros = kilometros)
                else -> CocheHibridoImpl(marca = marca, matricula = matricula, kilometros = kilometros)
            }
        }
    }
}

