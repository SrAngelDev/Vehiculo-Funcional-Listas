package srangeldev.repositories

interface CrudRepository<T, ID> {
    fun findAll(): List<T>
    fun findById(id: ID): T?
    fun create(item: T): T
    fun update(id: ID, item: T): T?
    fun delete(id: ID): T?
}