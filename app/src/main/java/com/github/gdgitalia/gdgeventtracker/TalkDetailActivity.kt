package com.github.gdgitalia.gdgeventtracker

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class TalkDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talk_detail)
        Log.d(TalkDetailActivity::class.java.simpleName, "L'id del talk è: ${intent.getStringExtra(TALK_ID_KEY)}")
    }
}
