package srangeldev.repositories

import srangeldev.extensions.ModoOrdenamiento
import srangeldev.models.Vehiculo
import javax.sql.rowset.Predicate

interface VehiculosRepository : CrudRepository<Vehiculo, Int> {
    fun filterBy(predicate: (Vehiculo) -> Boolean = { true }): Array<Vehiculo>
    fun averageBy(selector: (Vehiculo) -> Int, predicate: (Vehiculo) -> Boolean = { true }): Int
    fun countBy(predicate: (Vehiculo) -> Boolean = { true }): Int
    fun maxBy(selector: (Vehiculo) -> Int = { 0 }, predicate: (Vehiculo) -> Boolean = { true }): Vehiculo?
    fun minBy(selector: (Vehiculo) -> Int = { 0 }, predicate: (Vehiculo) -> Boolean = { true }): Vehiculo?
    fun sortedBy(mode: ModoOrdenamiento = ModoOrdenamiento.ASCENDENTE, condition: (Vehiculo) -> Int): Array<Vehiculo>
}
