package com.example.flowdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //PRODUCER DATA STREAMS
        val myFlow = flow<Int> {
            for (i in 1..100){
                emit(1)
                delay(1000L)
            }
        }
      
       //CONSUMER
        CoroutineScope(Dispatchers.Main).launch {
            myFlow.collect{
                Log.i("MYTAG", "Current index is $it")
            }
        }
    }
}

