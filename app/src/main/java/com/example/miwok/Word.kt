package com.example.miwok


class Word(defaultTranslation: String, miwokTranslation: String,imageId:Int,audioId:Int)
{

    private val mDefaultTranslation = defaultTranslation
    private val mMiwokTranslation = miwokTranslation
    private val imageSrc=imageId
    private val audioSrc=audioId
    fun getImageId(): Int {
        return imageSrc
    }
    fun getDefaultTranslation(): String? {
        return mDefaultTranslation
    }
    fun getMiwokTranslation(): String? {
        return mMiwokTranslation
    }
    fun getAudioSrc():Int{
        return audioSrc
    }
    fun hasImage(): Boolean{
        if(imageSrc==0)
            return false
        else
            return true
    }
}