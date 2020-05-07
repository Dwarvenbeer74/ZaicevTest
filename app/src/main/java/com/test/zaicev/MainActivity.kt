package com.test.zaicev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IntRange
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.floor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //пример 1
        val tester = User(7, Vacancy("Developer"))
        tvResult1.append(tester.id.toString())
        tvResult1.append("\n")
        tvResult1.append(tester.vacancy)

        //пример 2
        val price: IntArray = intArrayOf(5, 100, 20, 66, 16)//исходные цены
        val decryptedPrice = decryptData(price, 50, 1, 3)

        var first = true
        price.forEach {
            if (!first) tvInputData.append(", ")
            tvInputData.append(it.toString())
            first = false
        }

        first = true
        decryptedPrice?.forEach {
            if (!first) tvResult2.append(", ")
            tvResult2.append(it.toString())
            first = false
        }

        //пример 3
        btnMain.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

    }

    private fun decryptData(
        price: IntArray,
        @IntRange(from = 1) discount: Int,
        @IntRange(from = 0) offset: Int,
        @IntRange(from = 1) readLength: Int
    ): IntArray? {

        return if (offset + readLength <= price.size) {//если не выходим за пределы массива - считаем, иначе функция вернет null
            val result = IntArray(readLength)//устанавливаем размер возвращаемого массива
            var discountK = (100f - discount) / 100f//считаем коэффициент скидки
            if (discountK < 0) discountK = 0f//скидка не может быть больше 100%
            for (i in 0 until readLength) {
                //умножаем цену на коэффициент скидки, округляем вниз до целого, преобразуем в Int и записываем в возвращаемый массив
                result[i] = floor((price[offset + i] * discountK).toDouble()).toInt()
            }
            result
        } else null

    }
}
