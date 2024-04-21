package com.example.event

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN->{
                Log.d("MOTION", "누름. x: ${event.x}, rawX: ${event.rawX}")
            }

            MotionEvent.ACTION_UP ->{
                Log.d("MOTION", "뗌. x: ${event.x}, y: ${event.y}")
            }
        }

        return super.onTouchEvent(event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("MOTION", "키 다운")
        when(keyCode){
            KeyEvent.KEYCODE_0 -> Log.d("MOTION", "${KeyEvent.KEYCODE_0}")
            KeyEvent.KEYCODE_A -> Log.d("MOTION", "${KeyEvent.KEYCODE_A}")
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("MOTION", "키 업")
        return super.onKeyUp(keyCode, event)
    }
}