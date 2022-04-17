package com.crushtech.composelearning.ui

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.runBlocking

val myFlow = flow {
    for (i in 1..10) {
        if (i == 1) throw InternalError("an internal error occurred")
        emit("Hello world $i")
        delay(1000L)
    }
}

fun processRequest() = runBlocking {
    myFlow.onStart { println("starting") }
        .catch { emit(it.message ?: "error") }
        .collect { println(it) }
}

fun main() {
    processRequest()
}
