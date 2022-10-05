package com.tworoot2.jetpackcomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.tworoot2.jetpackcomponents.ObserverClass.Observer
import com.tworoot2.jetpackcomponents.ViewModel.MainViewModel
import com.tworoot2.jetpackcomponents.ViewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var incButton: Button
    lateinit var button2: Button
    lateinit var textCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2 = findViewById(R.id.button2)
        incButton = findViewById(R.id.incButton)
        textCounter = findViewById(R.id.textCounter)

        button2.setOnClickListener {
            val i = Intent(this, NextActivity::class.java)
            startActivity(i)
        }

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(10))[MainViewModel::class.java]
//        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setText()
        // for lifecycle aware components
        lifecycle.addObserver(Observer())
        Log.d("MAIN", "Activity OnCreate")
    }

    fun setText() {
        textCounter.text = mainViewModel.count.toString()
    }

    fun increment(view: View) {
        mainViewModel.increment()
        setText()
    }


    override fun onStop() {
        super.onStop()
        Log.d("MAIN", "Activity onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MAIN", "Activity onPause")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MAIN", "Activity onRestart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("MAIN", "Activity onResume")

    }

    override fun onStart() {
        super.onStart()
        Log.d("MAIN", "Activity onStart")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MAIN", "Activity onDestroy")

    }


}