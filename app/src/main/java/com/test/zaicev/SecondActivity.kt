package com.test.zaicev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.e("qwerty", "Выполняется SecondActivity.onCreate()")
        tvTextSecond.text = this.javaClass.simpleName
        Log.e("qwerty", "Надпись: ${tvTextSecond.text}")

        btnSecond.setOnClickListener {
            Log.e("qwerty", "SA btnSecond onClick")
            tvTextSecond.text = "My name is "
            tvTextSecond.append(State.name)
            tvTextSecond.append(" i'm ")
            tvTextSecond.append(State.age.toString())
            tvTextSecond.append(" years old")
            Log.e("qwerty", "Надпись: ${tvTextSecond.text}")
        }

        btnToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        State.name = "Mikhail"
        Log.e("qwerty", "Выполняется SecondActivity.onStart()")
        Log.e("qwerty", "name = ${State.name}")
    }

    override fun onStop() {
        super.onStop()
        State.name = "Igor"
        Log.e("qwerty", "Выполняется SecondActivity.onStop()")
        Log.e("qwerty", "name = ${State.name}")
    }

    override fun onPause() {
        super.onPause()
        State.age = 21
        Log.e("qwerty", "Выполняется SecondActivity.onPause()")
        Log.e("qwerty", "age = ${State.age}")
    }

    override fun onResume() {
        super.onResume()
        State.age = 22
        Log.e("qwerty", "Выполняется SecondActivity.onResume()")
        Log.e("qwerty", "age = ${State.age}")
    }

}
