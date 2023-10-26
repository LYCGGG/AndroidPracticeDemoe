package com.lyc.kotlindemo.jetpack

class DSLTest {
}

class Dependency {
    val libraries = ArrayList<String>()

    fun implementation(lib : String) {
        libraries.add(lib)
    }
}

fun dependencies(block : Dependency.() -> Unit) : List<String> {
    val dependency = Dependency()
    dependency.block()
    return dependency.libraries
}