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

class SecondGazeActivity : AppCompatActivity() {
    private var imageBitmap2: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_gaze)
        val btnTakePicture: Button = findViewById(R.id.btnTakePicture2)

        val takePhotoLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    imageBitmap2 = result.data?.extras?.get("data") as Bitmap
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
            val byteArray1=intent.getByteArrayExtra("image1")

            val byteArray2 = bitmapToByteArray(imageBitmap2!!)
            val intent = Intent(this, ThirdGazeActivity::class.java)

            intent.putExtra("image1", byteArray1)
            intent.putExtra("image2", byteArray2)
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