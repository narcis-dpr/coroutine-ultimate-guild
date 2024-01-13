package com.coroutines.advanced.sequencesAndIterators

fun main() {
    val list = listOf(1, 2, 3)
    list.asSequence().filter {
        print("filter, ")
        it > 0
    }.map {
        print("map, ")
    }.forEach {
        print("forEach, ")
    }
}
/**
 * Sequence is similar to Iterable from Java, except it performs lazily whenever possible.
 * The key difference lies in the semantics and the implementation of the Standard Library
 * extension functions for Iterable and Sequence, which both have a method called iterator.
 *
 */
