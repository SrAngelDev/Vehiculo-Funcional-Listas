package srangeldev.extensions

import srangeldev.models.Vehiculo


inline fun <T> List<T>.countBy(predicate: (T) -> Boolean = { true }): Int {
    var count = 0
    for (element in this) {
        if (predicate(element)) {
            count++
        }
    }
    return count
}

inline fun <reified T> List<T>.filterBy(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}

fun <T> List<T>.forEach(action: (T) -> Unit) {
    for (item in this) {
        action(item)
    }
}

fun <T> List<T>.indexOf(condition: (T?) -> Boolean): Int {
    for (index in this.indices) {
        if (condition(this[index])) {
            return index
        }
    }
    return -1
}

fun <T> List<T>.averageBy(selector: (T) -> Int, predicate: (T) -> Boolean): Int {
    var count = 0
    var total = 0
    for (element in this) {
        if (predicate(element)) {
            total += selector(element)
            count++
        }
    }
    return if (count == 0) 0 else total / count
}

fun <T> List<T>.firstOrNull(predicate: (T) -> Boolean = { true }): T? {
    for (element in this) {
        if (predicate(element)) {
            return element
        }
    }
    return null
}

fun <T> List<T>.maxByOrNull(selector: (Vehiculo) -> Int, predicate: (T) -> Boolean): T? {
    var maxElement: T? = null
    var maxValue: Int? = null
    for (element in this) {
        if (predicate(element)) {
            val value = selector(element as Vehiculo)
            if (maxValue == null || value > maxValue) {
                maxValue = value
                maxElement = element
            }
        }
    }
    return maxElement
}

fun <T> List<T>.minByOrNull(selector: (T) -> Int, predicate: (T) -> Boolean): T? {
    var minElement: T? = null
    var minValue: Int? = null
    for (element in this) {
        if (predicate(element)) {
            val value = selector(element)
            if (minValue == null || value < minValue) {
                minValue = value
                minElement = element
            }
        }
    }
    return minElement
}


inline fun <reified T> List<T>.sortedBy(
    mode: ModoOrdenamiento = ModoOrdenamiento.DESCENDENTE,
    selector: (T) -> Int
): List<T> {
    val result = this.filterBy { true }.toMutableList()
    val compare: (Int, Int) -> Boolean =
        if (mode == ModoOrdenamiento.ASCENDENTE) { a, b -> a > b } else { a, b -> a < b }

    for (i in result.indices) {
        for (j in 0..<result.size - 1 - i) {
            if (compare(selector(result[j]), selector(result[j + 1]))) {
                result[j] = result[j + 1].also { result[j + 1] = result[j] }
            }
        }
    }
    return result
}


enum class ModoOrdenamiento {
    ASCENDENTE, DESCENDENTE
}