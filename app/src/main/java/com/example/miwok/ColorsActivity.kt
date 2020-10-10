package com.example.miwok

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_numbers.*
@Suppress("DEPRECATION")
class ColorsActivity : AppCompatActivity() {
    lateinit var mp:MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)
        var ColorsList = ArrayList<Word>()
        ColorsList.add(Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red))
        ColorsList.add(Word("green","chokokki",R.drawable.color_green,R.raw.color_green))
        ColorsList.add(Word("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown))
        ColorsList.add(Word("gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray))
        ColorsList.add(Word("black","kululli",R.drawable.color_black,R.raw.color_black))
        ColorsList.add(Word("white","kelelli",R.drawable.color_white,R.raw.color_white))
        ColorsList.add(Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow))
        ColorsList.add(Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow))

        var itemsAdapter= WordAdapter(this, ColorsList,R.color.category_colors)
        list.adapter=itemsAdapter
        list.setOnItemClickListener { parent, view, position, id ->
            val musicId = ColorsList[position].getAudioSrc()




                mp = MediaPlayer.create(this, musicId)
                mp.start()
                mp.setOnCompletionListener {
                    release()

            }
        }
    }
    fun release()
    {
        mp.release();

    }
    override fun onStop() {
        super.onStop()
        mp.release()
    }
}
