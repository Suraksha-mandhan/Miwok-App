package com.example.miwok

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.*


//package example.javatpoint.com.kotlincustomlistview
//
//import android.app.Activity
//import android.view.View
//import android.view.ViewGroup
//import android.widget.*
//class MyListAdapter(private val context: Activity, private val title: Array<String>, private val description: Array<String>, private val imgid: Array<Int>)
//    : ArrayAdapter<String>(context, R.layout.custom_list, title) {
//
//    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
//        val inflater = context.layoutInflater
//        val rowView = inflater.inflate(R.layout.custom_list, null, true)
//
//        val titleText = rowView.findViewById(R.id.title) as TextView
//        val imageView = rowView.findViewById(R.id.icon) as ImageView
//        val subtitleText = rowView.findViewById(R.id.description) as TextView
//
//        titleText.text = title[position]
//        imageView.setImageResource(imgid[position])
//        subtitleText.text = description[position]
//
//        return rowView
//    }
//}
class WordAdapter(private val context: Activity, private val wordList: ArrayList<Word>, private val colorId: Int) : ArrayAdapter<Word>(context,R.layout.list_item,wordList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
         val rowView = inflater.inflate(R.layout.list_item, null, true)
        val miwokText = rowView.findViewById(R.id.miwokText) as TextView
        val defaultText = rowView.findViewById(R.id.defaultText) as TextView
        val listText =rowView.findViewById(R.id.listView) as LinearLayout
        val imageSrcId=rowView.findViewById(R.id.image) as ImageView
        listText.setBackgroundResource(colorId)
        miwokText.text=wordList[position].getMiwokTranslation()
        defaultText.text=wordList[position].getDefaultTranslation()
        if(wordList[position].hasImage())
            imageSrcId.setImageResource(wordList[position].getImageId())
        else
            imageSrcId.visibility=View.GONE
        return rowView
    }

}