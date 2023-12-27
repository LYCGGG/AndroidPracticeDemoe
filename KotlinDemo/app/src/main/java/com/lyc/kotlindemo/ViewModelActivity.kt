package com.lyc.kotlindemo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lyc.kotlindemo.jetpack.MyObserver
import com.lyc.kotlindemo.jetpack.TestViewModel
import kotlinx.android.synthetic.main.activity_view_model.*

// 学习ViewModel
class ViewModelActivity : AppCompatActivity() {
    lateinit var viewModel : TestViewModel
    lateinit var sp : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        viewModel = ViewModelProvider(this,TestViewModelFactory(countReserved)).get(TestViewModel::class.java)
        addCount_btn.setOnClickListener {
            viewModel.plusOne()
        }
        clearCount_btn.setOnClickListener {
            viewModel.clear()
        }
        viewModel.counter.observe(
            this, Observer {
                count -> println("${viewModel.counter.value} + OK")
            }
        )

        // lifecycle只需要这样声明，就可以感知和监控该Activity的生命周期了
        lifecycle.addObserver(MyObserver())
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter.value?:0)
        }
    }
}

class TestViewModelFactory(private val countReserved : Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TestViewModel(countReserved) as T
    }

}