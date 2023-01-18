package com.example.mindsharpener

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var easy: RadioButton
    lateinit var medium: RadioButton
    lateinit var hard: RadioButton
    lateinit var value1:TextView
    lateinit var value2:TextView
    lateinit var operator: TextView
    lateinit var answer: EditText
    lateinit var point: TextView
    lateinit var check: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//set view to each id for button,edit text,text,and radio button
        easy=(findViewById(R.id.easy))
        medium= (findViewById(R.id.medium))
        hard=(findViewById(R.id.hard))
        value1= (findViewById(R.id.value1))
        value2=(findViewById(R.id.value2))
        operator=(findViewById(R.id.operator))
        answer=(findViewById(R.id.answer))
        check=(findViewById(R.id.submit))
        point=(findViewById(R.id.point))
//declare operator use in this calculator
        var randomOperator = "+-*/"
        //generate operator
        var generator = randomOperator.random()

        var random1 = Random.nextInt(0,9)
        var random2 = Random.nextInt(0,9)

        //put value to the layout page when random numbers are generated
        value1.setText(random1.toString())
        operator.setText(generator.toString())
        value2.setText(random2.toString())
        point.text = "0"

        var jawapan = 0
        var currentPoint = 0

        //set +points when answer correct and -points when answer wrong
        check.setOnClickListener(){
            jawapan = calculate(random1,generator,random2)

            if(answer.text.toString().toInt() == jawapan){
                currentPoint++
            }else{
                currentPoint--
            }
            point.setText(currentPoint.toString())

            generator = randomOperator.random()
//when easy generate 1 digit number, medium generate 2digits number hard generate 3 digits number
            if(easy.isChecked){
                random1 = Random.nextInt(0,9)
                random2 = Random.nextInt(1,9)
            }else if(medium.isChecked){
                random1 = Random.nextInt(10,99)
                random2 = Random.nextInt(10,99)
            }else if(hard.isChecked){
                random1 = Random.nextInt(100,999)
                random2 = Random.nextInt(100,999)
            }
//show number in text view
            value1.setText(random1.toString())
            operator.setText(generator.toString())
            value2.setText(random2.toString())

        }
    }
//calculation method
    fun calculate(value1:Int,operator:Char,value2:Int) : Int{
        var result = 999999999
        if(operator == '+'){
            result = value1 + value2
        }else if(operator == '-'){
            result = value1 - value2
        }else if(operator == '*'){
            result = value1 *value2
        }else if(operator == '/'){
            result = value1 / value2
        }else{

        }
        return result
    }
}