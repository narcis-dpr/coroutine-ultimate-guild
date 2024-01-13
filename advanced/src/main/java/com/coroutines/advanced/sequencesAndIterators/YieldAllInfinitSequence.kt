package com.coroutines.advanced.sequencesAndIterators

fun main() {
    val sequence = sequenceExample().take(10)
    sequence.forEach {
        print("$it ")
    }
}

fun sequenceExample() = sequence {
    yieldAll(generateSequence(2) { it * 2 })
}
