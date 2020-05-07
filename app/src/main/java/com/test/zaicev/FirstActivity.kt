package com.test.zaicev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        Log.e("qwerty", "Выполняется FirstActivity.onCreate()")
        tvTextFirst.text = this.javaClass.simpleName
        Log.e("qwerty", "Надпись: ${tvTextFirst.text}")

        btnFirst.setOnClickListener {
            Log.e("qwerty", "FA btnFirst onClick")
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        State.name = "Dmitriy"
        Log.e("qwerty", "Выполняется FirstActivity.onStart()")
        Log.e("qwerty", "name = ${State.name}")
    }

    override fun onStop() {
        super.onStop()
        State.name = "Daria"
        Log.e("qwerty", "Выполняется FirstActivity.onStop()")
        Log.e("qwerty", "name = ${State.name}")
    }

    override fun onPause() {
        super.onPause()
        State.age = 19
        Log.e("qwerty", "Выполняется FirstActivity.onPause()")
        Log.e("qwerty", "age = ${State.age}")
    }

    override fun onResume() {
        super.onResume()
        State.age = 20
        Log.e("qwerty", "Выполняется FirstActivity.onResume()")
        Log.e("qwerty", "age = ${State.age}")
    }
}
