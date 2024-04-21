package com.example.event

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.CompoundButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkBox.setOnCheckedChangeListener(object: CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                Log.d("MOTION", "체크 변경됨")
            }
        })

        // SAM(Single Abstract Method) 기법. 추상 메서드가 하나일때 클래스 객체를 안만들고 바로 재정의 가능
        binding.button.setOnClickListener{
            Log.d("MOTION", "짧게 클릭")
        }

        binding.button.setOnLongClickListener{
            Log.d("MOTION", "길게 클릭")
            // 리턴값이 true이면 LongClick리스너 함수만 실행. 클릭x
            // false면 둘다 실행
            true
        }
    }
    
}