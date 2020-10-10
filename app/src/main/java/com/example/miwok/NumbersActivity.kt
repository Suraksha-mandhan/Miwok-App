package com.example.miwok

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_numbers.*




class NumbersActivity : AppCompatActivity() {

    lateinit var mp:MediaPlayer





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_numbers)
        var numberList = ArrayList<Word>()
        numberList.add(Word("one","lutti",R.drawable.number_one,R.raw.number_one))
        numberList.add(Word("two","otiiko",R.drawable.number_two,R.raw.number_two))
        numberList.add(Word("three","tolookosu",R.drawable.number_three,R.raw.number_three))
        numberList.add(Word("four","oyyisa",R.drawable.number_four,R.raw.number_four))
        numberList.add(Word("five","massokka",R.drawable.number_five,R.raw.number_five))
        numberList.add(Word("six","temmokka",R.drawable.number_six,R.raw.number_six))
        numberList.add(Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven))
        numberList.add(Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight))
        numberList.add(Word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine))
        numberList.add(Word("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten))


       var itemsAdapter= WordAdapter(this,numberList,R.color.category_numbers)
        list.adapter=itemsAdapter
        list.setOnItemClickListener { parent, view, position, id ->
           val musicId=numberList[position].getAudioSrc()


            // Request audio focus for playback

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
