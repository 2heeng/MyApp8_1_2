package com.cookandroid.myapp8_1_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnRead : Button = findViewById<Button>(R.id.btnRead)
        var btnWrite : Button = findViewById<Button>(R.id.btnWrite)

        btnWrite.setOnClickListener {
            var outFs : FileOutputStream = openFileOutput("file.txt", Context.MODE_PRIVATE)
            var str = "안녕안녕안녕"
            outFs.write(str.toByteArray())
            outFs.close()
            Toast.makeText(applicationContext, "file.txt가 생성됨", Toast.LENGTH_SHORT).show()
        }

        btnRead.setOnClickListener {
            try {
                var inFs : FileInputStream = openFileInput("file.txt")
                var txt = ByteArray(30)
                inFs.read(txt)
                var str = txt.toString(Charsets.UTF_8)
                Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
                inFs.close()
            } catch (e : IOException) {
                Toast.makeText(applicationContext, "파일 없음 예외 발생", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
