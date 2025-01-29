package srangeldev.repositories

import org.lighthousegames.logging.logging
import srangeldev.extensions.*
import srangeldev.models.Vehiculo
import java.time.LocalDateTime

class VehiculosRepositoryImpl: VehiculosRepository {
    private val logger = logging()
    private var vehiculos = mutableListOf<Vehiculo>()
    private var nextId = 1

    private fun generateId(): Int {
        logger.debug { "Generando nuevo ID" }
        return nextId++
    }

    override fun filterBy(predicate: (Vehiculo) -> Boolean): List<Vehiculo> {
        logger.debug { "Filtrando vehiculos" }
        return vehiculos.filterBy(predicate)
    }

    override fun averageBy(selector: (Vehiculo) -> Int, predicate: (Vehiculo) -> Boolean): Int {
        logger.debug { "Calculando la media" }
        return vehiculos.averageBy(selector, predicate)
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

    override fun sortedBy(mode: ModoOrdenamiento, condition: (Vehiculo) -> Int): List<Vehiculo> {
        logger.debug { "Ordenando vehiculos" }
        return vehiculos.sortedBy(mode, condition)
    }

    override fun findAll(): List<Vehiculo> {
        logger.debug { "Encontrar todos los vehiculos" }
        return vehiculos.filterBy { true }
    }

    override fun findById(id: Int): Vehiculo? {
        logger.debug { "Buscando vehiculo por ID" }
        return vehiculos.firstOrNull { it.id == id }
    }

    override fun create(item: Vehiculo): Vehiculo {
        logger.debug { "Crear vehiculo" }
        val nuevoVehiculo = item.copy()
        nuevoVehiculo.id = generateId()
        nuevoVehiculo.createdAt = LocalDateTime.now()
        nuevoVehiculo.updatedAt = LocalDateTime.now()

        if (!vehiculos.contains(nuevoVehiculo)) {
            vehiculos.add(nuevoVehiculo)
        }
        return nuevoVehiculo.also { logger.debug { "Vehiculo creado correctamente ✅" } }
    }

    override fun update(id: Int, item: Vehiculo): Vehiculo? {
        logger.info { "Actualizando vehiculo" }
        return this.findById(id)?.let {
            val nuevoVehiculo = it.copy()
            nuevoVehiculo.id = generateId()
            nuevoVehiculo.updatedAt = LocalDateTime.now()
            val index = vehiculos.indexOf { it?.id == id }
            vehiculos[index] = nuevoVehiculo
            nuevoVehiculo.also { logger.info { "Vehiculo actualizado" } }
        }
    }

    override fun delete(id: Int): Vehiculo? {
        logger.info { "Borrando vehiculo" }
        return this.findById(id)?.let { vehiculo ->
            vehiculos.removeAt(vehiculos.indexOf { it?.id == id })
            vehiculo.copy().also {
                vehiculo.isDeleted = true
                logger.info { "Vehiculo borrado correctamente" }
            }
        }
    }
}

