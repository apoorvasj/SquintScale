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
class SixthGazeActivity : AppCompatActivity() {
    private var imageBitmap6: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sixth_gaze)
        val btnTakePicture: Button = findViewById(R.id.btnTakePicture)
        val takePhotoLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    imageBitmap6 = result.data?.extras?.get("data") as Bitmap
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
            val byteArray3=intent.getByteArrayExtra("image3")
            val byteArray4=intent.getByteArrayExtra("image4")
            val byteArray5=intent.getByteArrayExtra("image5")

            val byteArray6 = bitmapToByteArray(imageBitmap6!!)
            val intent = Intent(this, SeventhGazeActivity::class.java)

            intent.putExtra("image1", byteArray1)
            intent.putExtra("image2", byteArray2)
            intent.putExtra("image3", byteArray3)
            intent.putExtra("image4", byteArray4)
            intent.putExtra("image5", byteArray5)
            intent.putExtra("image6", byteArray6)

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

