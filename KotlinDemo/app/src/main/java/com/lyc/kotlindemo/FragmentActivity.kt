package com.lyc.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lyc.kotlindemo.fragment.FragmentTest
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        addFragmentTest.setOnClickListener {
            addFragment()
        }

    }

    // 实际测试，fragment是添加到布局中，而非替代，因此replace这个待考察
    private fun addFragment() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.test_fragment, FragmentTest())
//        给Fragment添加返回栈
//        transaction.addToBackStack(null)
        transaction.commit()
    }
}