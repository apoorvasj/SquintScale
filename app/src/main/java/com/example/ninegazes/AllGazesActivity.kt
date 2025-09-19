package com.example.ninegazes

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AllGazesActivity : AppCompatActivity() {
    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var imageView4: ImageView
    private lateinit var imageView5: ImageView
    private lateinit var imageView6: ImageView
    private lateinit var imageView7: ImageView
    private lateinit var imageView8: ImageView
    private lateinit var imageView9: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_all_gazes)
        imageView1=findViewById(R.id.imageView1)
        imageView2=findViewById(R.id.imageView2)
        imageView3=findViewById(R.id.imageView3)
        imageView4=findViewById(R.id.imageView4)
        imageView5=findViewById(R.id.imageView5)
        imageView6=findViewById(R.id.imageView6)
        imageView7=findViewById(R.id.imageView7)
        imageView8=findViewById(R.id.imageView8)
        imageView9=findViewById(R.id.imageView9)

        val byteArray1= intent.getByteArrayExtra("image1")
        val byteArray2=intent.getByteArrayExtra("image2")
        val byteArray3=intent.getByteArrayExtra("image3")
        val byteArray4= intent.getByteArrayExtra("image4")
        val byteArray5=intent.getByteArrayExtra("image5")
        val byteArray6=intent.getByteArrayExtra("image6")
        val byteArray7= intent.getByteArrayExtra("image7")
        val byteArray8=intent.getByteArrayExtra("image8")
        val byteArray9=intent.getByteArrayExtra("image9")

        //display
        byteArray1?.let{
            val bitmap1=BitmapFactory.decodeByteArray(it,0,it.size)
            imageView1.setImageBitmap(bitmap1)
        }

        byteArray2?.let{
            val bitmap2=BitmapFactory.decodeByteArray(it,0,it.size)
            imageView2.setImageBitmap(bitmap2)

        }

        byteArray3?.let{
            val bitmap3= BitmapFactory.decodeByteArray(it,0,it.size)
            imageView3.setImageBitmap(bitmap3)
        }

        byteArray4?.let{
            val bitmap4=BitmapFactory.decodeByteArray(it,0,it.size)
            imageView4.setImageBitmap(bitmap4)
        }

        byteArray5?.let{
            val bitmap5=BitmapFactory.decodeByteArray(it,0,it.size)
            imageView5.setImageBitmap(bitmap5)

        }

        byteArray6?.let{
            val bitmap6= BitmapFactory.decodeByteArray(it,0,it.size)
            imageView6.setImageBitmap(bitmap6)
        }

        byteArray7?.let{
            val bitmap7=BitmapFactory.decodeByteArray(it,0,it.size)
            imageView7.setImageBitmap(bitmap7)
        }

        byteArray8?.let{
            val bitmap8=BitmapFactory.decodeByteArray(it,0,it.size)
            imageView8.setImageBitmap(bitmap8)

        }

        byteArray9?.let{
            val bitmap9= BitmapFactory.decodeByteArray(it,0,it.size)
            imageView9.setImageBitmap(bitmap9)
        }
    }
}