package com.example.miwok

import android.content.Context
import android.media.AudioManager
import android.media.CamcorderProfile.get
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_numbers.*
import kotlinx.android.synthetic.main.list_item.*

class PhrasesActivity : AppCompatActivity() {

    lateinit var mp:MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phrases)
        val PhrasesList = ArrayList<Word>()
        PhrasesList.add(Word("Where are you going?","minto wuksus",0,R.raw.phrase_where_are_you_going))
        PhrasesList.add(Word("What is your name?","tinnә oyaase'nә",0,R.raw.phrase_what_is_your_name))
        PhrasesList.add(Word("My name is...","oyaaset...",0,R.raw.phrase_my_name_is))
        PhrasesList.add(Word("How are you feeling?","michәksәs?",0,R.raw.phrase_how_are_you_feeling))
        PhrasesList.add(Word("I’m feeling good.","kuchi achit",0,R.raw.phrase_im_feeling_good))
        PhrasesList.add(Word("Are you coming?","әәnәs'aa?",0,R.raw.phrase_are_you_coming))
        PhrasesList.add(Word("Yes, I’m coming.","hәә’ әәnәm",0,R.raw.phrase_yes_im_coming))
        PhrasesList.add(Word("I’m coming.","әәnәm",0,R.raw.phrase_im_coming))
        PhrasesList.add(Word("Let’s go.","voowutis",0,R.raw.phrase_lets_go))
        PhrasesList.add(Word("Come here.","әnni'nem",0,R.raw.phrase_come_here))

        var itemsAdapter= WordAdapter(this,PhrasesList,R.color.category_phrases)
        list.adapter=itemsAdapter
        list.setOnItemClickListener { parent, view, position, id ->
            val musicId = PhrasesList[position].getAudioSrc()

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
