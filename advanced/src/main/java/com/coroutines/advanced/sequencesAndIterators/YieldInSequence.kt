package com.coroutines.advanced.sequencesAndIterators

fun main() {
    val sequence = singleValueExample()
    sequence.forEach {
        println(it)
    }
}

fun singleValueExample() = sequence {
    println("Printing first value")
    yield("Apple")

    println("printing second value")
    yield("Orange")

    println("printing third value")
    yield("Banana")
}
