package com.lyc.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val REQUEST_OK = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mehtodTest()
        // OptionsMenu

        // Kotlin可以使用xxx.name的方式直接调用get/set方法赋值和获取，xxx.name = 1 == xxx.setName(1)

        // startActivity
        // val intent  = Intent(Intent.ACTION_VIEW)

        btn_jump2second.setOnClickListener {
            val intent : Intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("Second", "get Value is ok")
            startActivityForResult(intent,REQUEST_OK)
        }

        btn_jump2third.setOnClickListener {
            val intent = Intent(this,UiActivity::class.java)
            startActivity(intent)
        }

        btn_jump2forth.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        getMenuInflater().inflate(R.menu.main,menu) // ==
        menuInflater. inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add -> Toast.makeText(this,"Click Add", Toast.LENGTH_SHORT).show()
            R.id.menu_delete -> Toast.makeText(this, "Click Delete", Toast.LENGTH_SHORT).show()
        }
        return true
    }

//    private fun mehtodTest() {
//        var clazz = Class2("MainA1", 1)
//    }

    // 可以获取指定Activity返回的数据，这个是指定传递的请求码,但是似乎被指定的Activity不需要知道请求码是什么，反而是指定的Activity需要根据请求码来确认是哪个业务被实现了
    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        when (requestCode) {
            REQUEST_OK -> {
                println("Request code is 1")
            }
        }
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
    }

    // 请求码是本类发送过去的，用于标记被请求的需要实现什么业务，结果码是被请求的返回的，用于标记业务实现情况
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            REQUEST_OK -> if (resultCode == RESULT_OK) {
                println("Can Get Second Activity Message")
            }
        }
    }

    // 用于保存数据，
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }
}