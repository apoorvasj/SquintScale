package com.example.ninegazes

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.ByteArrayOutputStream

class FirstGazeActivity : AppCompatActivity() {
    private var imageBitmap1: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_gaze)

        val btnTakePicture: Button = findViewById(R.id.btnTakePicture1)
        val takePhotoLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    imageBitmap1 = result.data?.extras?.get("data") as Bitmap
                }
            }
        btnTakePicture.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent.resolveActivity(packageManager) != null) {
                takePhotoLauncher.launch(takePictureIntent)
            }
        }

        val btnNext: Button = findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            val intent = Intent(this, SecondGazeActivity::class.java)
            val byteArray = bitmapToByteArray(imageBitmap1!!)
            intent.putExtra("image1", byteArray)
            startActivity(intent)


        }
    }

    private fun bitmapToByteArray(bitmap: Bitmap): ByteArray? {
        if (bitmap!= null) {
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
            return byteArrayOutputStream.toByteArray()
        }
        return null
    }
}