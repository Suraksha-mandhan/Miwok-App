package com.example.miwok

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_numbers.*
@Suppress("DEPRECATION")
class FamilyMembersActivity : AppCompatActivity() {
        lateinit var mp:MediaPlayer
   




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_members)
        var FamilyList = ArrayList<Word>()
        FamilyList.add(Word("father","әpә",R.drawable.family_father,R.raw.family_father))
        FamilyList.add(Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother))
        FamilyList.add(Word("son","angsi",R.drawable.family_son,R.raw.family_son))
        FamilyList.add(Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter))
        FamilyList.add(Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother))
        FamilyList.add(Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother))
        FamilyList.add(Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister))
        FamilyList.add(Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister))
        FamilyList.add(Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother))
        FamilyList.add(Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather))

        var itemsAdapter= WordAdapter(this,FamilyList,R.color.category_family)
        list.adapter=itemsAdapter
        list.setOnItemClickListener { parent, view, position, id ->
            val musicId=FamilyList[position].getAudioSrc()




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
