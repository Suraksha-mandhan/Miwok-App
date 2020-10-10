package com.example.miwok

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openNumbersActivity(view: View) {
        val i = Intent(this, NumbersActivity::class.java)
        startActivity(i)
    }
    fun openFamilyMembersActivity(view: View) {
        val i = Intent(this, FamilyMembersActivity::class.java)
        startActivity(i)
    }
    fun openColorsActivity(view: View) {
        val i = Intent(this, ColorsActivity::class.java)
        startActivity(i)
    }
    fun openPhrasesActivity(view: View) {
        val i = Intent(this, PhrasesActivity::class.java)
        startActivity(i)
    }
}
