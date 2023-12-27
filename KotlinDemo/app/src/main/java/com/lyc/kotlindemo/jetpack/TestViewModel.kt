package com.lyc.kotlindemo.jetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class TestViewModel(countReserved : Int) : ViewModel() {
    var counter = MutableLiveData<Int>()

    init {
        counter.value = countReserved
    }

    fun plusOne() {
        val count = counter.value ?: 0
        counter.value = count+1
    }

    fun clear(){
        counter.value = 0
    }

    override fun onCleared() {
        super.onCleared()
    }
}

// 更好的语法
class TestViewModel2(countReserved : Int) : ViewModel() {
    val counter : LiveData<Int>
    get() = _counter

    private val _counter = MutableLiveData<Int>()

    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = _counter.value ?: 0
        _counter.value = count+1
    }

    fun clear(){
        _counter.value = 0
    }

    override fun onCleared() {
        super.onCleared()
    }
}

// LiveData还可以被转换，使其拥有更高的普适性
data class User(var firstName: String, var lastName: String, var age : Int)
class TestViewModel3(countReserved: Int) : ViewModel() {
    private val userLiveData = MutableLiveData<User>()

    val userName : LiveData<String> = Transformations.map(userLiveData) {
//        user -> "${user.firstName} ${user.lastName}"
        "${it.firstName} ${it.lastName}"
    }
}