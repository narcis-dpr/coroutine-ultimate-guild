package com.coroutines.advanced.sequencesAndIterators

fun main() {
    val list = listOf(1, 2, 3)
    list.filter {
        print("filter,")
        it > 0
    }.map {
        print("map, ")
        it.toString()
    }.forEach {
        print("forEach, ")
    }
}
/**
 *  Collection interface inherits from Iterable interface.
 *  Iterable<E> is non-lazy by default or eager-evaluated.
 *  Thus, all collections are eager-evaluated.
 */
