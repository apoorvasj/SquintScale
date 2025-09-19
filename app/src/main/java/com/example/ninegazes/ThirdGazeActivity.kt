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

class ThirdGazeActivity : AppCompatActivity() {
    private var imageBitmap3: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third_gaze)
        val btnTakePicture: Button = findViewById(R.id.btnTakePicture3)
        val takePhotoLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    imageBitmap3 = result.data?.extras?.get("data") as Bitmap
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
            val byteArray1= intent.getByteArrayExtra("image1")
            val byteArray2=intent.getByteArrayExtra("image2")
            val byteArray3 = bitmapToByteArray(imageBitmap3!!)
            val intent = Intent(this, FourthGaze::class.java)

            intent.putExtra("image1", byteArray1)
            intent.putExtra("image2", byteArray2)
            intent.putExtra("image3", byteArray3)
            startActivity(intent)


        }
    }

    private fun bitmapToByteArray(bitmap: Bitmap): ByteArray? {
        if (bitmap != null) {
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
            return byteArrayOutputStream.toByteArray()
        }
        return null
    }
}
