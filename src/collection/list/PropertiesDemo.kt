package collection.list

import java.util.*


fun main() {


    val numbers = listOf(1, 2, 2, 3, 3)

    val number = numbers.myFirstOrNull { it > 3 }
    println(number)


}


/**
 * Returns the first element matching the given [predicate], or `null` if element was not found.
 */
inline fun <T> Iterable<T>.myFirstOrNull(predicate: (T) -> Boolean): T? {
    for (element in this)
        if (predicate(element))
            return element
    return null
}
