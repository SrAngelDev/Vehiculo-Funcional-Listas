package srangeldev.repositories

import org.lighthousegames.logging.logging
import srangeldev.extensions.ModoOrdenamiento
import srangeldev.extensions.ModoRedimension
import srangeldev.extensions.countBy
import srangeldev.extensions.filterBy
import srangeldev.extensions.firstOrNull
import srangeldev.extensions.indexOf
import srangeldev.extensions.maxByOrNull
import srangeldev.extensions.minByOrNull
import srangeldev.extensions.redimensionar
import srangeldev.extensions.sortedBy
import srangeldev.models.Vehiculo
import java.time.LocalDateTime

class VehiculosRepositoryImpl: VehiculosRepository {
    private val logger = logging()
    var maxVehiculos: Int = 10
    private var vehiculos = arrayOfNulls<Vehiculo>(maxVehiculos)
    private var nextId = 1

    private fun generateId(): Int {
        logger.debug { "Generando nuevo ID" }
        return nextId++
    }

    override fun filterBy(predicate: (Vehiculo) -> Boolean): Array<Vehiculo> {
        logger.debug { "Filtrando vehiculos" }
        return vehiculos.filterBy(predicate)
    }

    override fun averageBy(predicate: (Vehiculo) -> Boolean): Double {
        logger.debug { "Calculando el consumo medio" }
        return averageBy(predicate)
    }

    override fun countBy(predicate: (Vehiculo) -> Boolean): Int {
        logger.debug { "Contando vehiculos en base una condicion" }
        return vehiculos.countBy(predicate)
    }

    override fun maxBy(selector: (Vehiculo) -> Int, predicate: (Vehiculo) -> Boolean): Vehiculo? {
        logger.debug { "Max vehiculos" }
        return vehiculos.maxByOrNull(selector, predicate)
    }

    override fun minBy(selector: (Vehiculo) -> Int, predicate: (Vehiculo) -> Boolean): Vehiculo? {
        logger.debug { "Min vehiculos" }
        return vehiculos.minByOrNull(selector, predicate)
    }

    override fun sortedBy(mode: ModoOrdenamiento, condition: (Vehiculo) -> Double): Array<Vehiculo> {
        logger.debug { "Ordenando vehiculos" }
        return vehiculos.sortedBy(mode, condition)
    }

    override fun findAll(): Array<Vehiculo> {
        logger.debug { "Encontrar todos los vehiculos" }
        return vehiculos.filterBy { true }
    }

    override fun findById(id: Int): Vehiculo? {
        logger.debug { "Buscando vehiculo por ID" }
        return vehiculos.firstOrNull { it.id == id }
    }

    override fun create(item: Vehiculo): Vehiculo {
        logger.debug { "Crear vehiculo" }
        val nuevoVehiculo = item.copy(
            id = generateId(),
            marca = item.marca,
            matricula = item.matricula,
            kilometros = item.kilometros,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
            isDeleted = item.isDeleted,
        )

        var pos = vehiculos.indexOf { it == null }
        if (pos != -1) {
            vehiculos[pos] = nuevoVehiculo
        } else {
            logger.error { "No hay espacio disponible para guardar el vehiculo" }
            redimensionar(modo = ModoRedimension.AUMENTAR)
            pos = vehiculos.indexOf { it == null }
            vehiculos[pos] = nuevoVehiculo
        }
        logger.debug { "Vehiculo creado correctamente" }
        return nuevoVehiculo
    }

    override fun update(id: Int, item: Vehiculo): Vehiculo? {
        logger.info { "Actualizando vehiculo" }
        return this.findById(id)?.let {
            val nuevoVehiculo = it.copy(
                id = item.id,
                marca = item.marca,
                matricula = item.matricula,
                kilometros = item.kilometros,
                createdAt = item.createdAt,
                updatedAt = LocalDateTime.now(),
                isDeleted = item.isDeleted,
            )
            val index = vehiculos.indexOfFirst { vehiculo -> vehiculo?.id == id }
            if (index >= 0) {
                vehiculos[index] = nuevoVehiculo
            }
            nuevoVehiculo.also { logger.info { "Vehiculo actualizado" } }
        }
    }

    override fun delete(id: Int): Vehiculo? {
        logger.info { "Borrando vehiculo" }
        return this.findById(id)?.let { vehiculo ->
            val index = vehiculos.indexOfFirst { it?.id == id }
            if (index >= 0) {
                vehiculos[index] = null
            }
            vehiculo.copy(
                id = vehiculo.id,
                marca = vehiculo.marca,
                matricula = vehiculo.matricula,
                kilometros = vehiculo.kilometros,
                createdAt = vehiculo.createdAt,
                updatedAt = LocalDateTime.now(),
                isDeleted = true
            ).also {
                redimensionarSiHaceFalta()
                logger.info { "Vehiculo borrado correctamente" }
            }
        }
    }


    private fun redimensionarSiHaceFalta() {
        logger.debug { "Redimensionando si hace falta" }
        val count = vehiculos.count { true }
        if (count < maxVehiculos / 2) {
            logger.error { "Redimensionando por debajo del 50%" }
            redimensionar(modo = ModoRedimension.DISMINUIR)
        }
    }

    private fun redimensionar(modo: ModoRedimension = ModoRedimension.AUMENTAR) {
        logger.debug { "Redimensionando el array de estudiantes modo: ${modo.name}" }
        if (modo == ModoRedimension.DISMINUIR) {
            maxVehiculos /= 2
            vehiculos = vehiculos.redimensionar(ModoRedimension.DISMINUIR, maxVehiculos)
        } else {
            maxVehiculos *= 2
            vehiculos = vehiculos.redimensionar(ModoRedimension.AUMENTAR, maxVehiculos)
        }
        logger.debug { "Array redimensionado con ${vehiculos.size}" }
    }

}

