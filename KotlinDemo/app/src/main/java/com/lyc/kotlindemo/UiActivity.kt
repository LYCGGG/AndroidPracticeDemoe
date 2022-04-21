package com.lyc.kotlindemo

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lyc.kotlindemo.recycler.FruitAdapter
import kotlinx.android.synthetic.main.activity_ui.*

class UiActivity : AppCompatActivity() {
    private val data = listOf<String>("Apple","Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Cherry")

    // val修饰变量时是不可变的，但是对于类时只是不可重新指定，而类的值是可以改变的
    private val fruitList = ArrayList<Fruit>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui)

        // 隐藏ActionBar
        supportActionBar?.hide()

        // 这个id是系统内置，系统内置了一些已经写好的布局方案，不过不能满足工厂需求，因此需要自定义
//        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
//        listTest.adapter = adapter

        // ListView
        initFruits()
//        val adapter = FruitAdapter(this,R.layout.list_item,fruitList)
//        listTest.adapter = adapter
//        // 可以给listView设置点击监听
//        listTest.setOnItemClickListener { parent, view, position, id ->
//            val fruit = fruitList[position]
//            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
//        }

        // recycleView
        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycleTest.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        recycleTest.adapter = adapter

    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit("Apple", R.mipmap.test))
            fruitList.add(Fruit("Orange", R.mipmap.test))
            fruitList.add(Fruit("Watermelon", R.mipmap.test))
            fruitList.add(Fruit("Pineapple", R.mipmap.test))
            fruitList.add(Fruit("Banana", R.mipmap.test))
        }
    }
}

class Fruit(val name : String, val imageId : Int)

class FruitAdapter(val context1: Activity, val resourceId : Int, var data : List<Fruit>) : ArrayAdapter<Fruit>(context1,resourceId , data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view : View
        val viewHolder : ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context1).inflate(resourceId, parent, false)
            val fruitImage : ImageView = view.findViewById(R.id.fruitImage)
            val fruitName : TextView = view.findViewById(R.id.fruitName)
            viewHolder = ViewHolder(fruitImage, fruitName)
            view.tag = viewHolder
        } else {
            view  = convertView
            viewHolder = view.tag as ViewHolder
        }

        val fruit = getItem(position)
        if (fruit != null) {
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
        }
        // 下面这种点击事件居然是可以的，但是直观明显不合适
//        viewHolder.fruitName.setOnClickListener {
//            Toast.makeText(context1,"内部点击事件测试", Toast.LENGTH_LONG).show()
//        }
        return view
    }



    inner class ViewHolder(val fruitImage : ImageView, val fruitName : TextView)
}