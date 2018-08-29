package com.github.gdgitalia.gdgeventtracker

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.github.gdgitalia.gdgeventtracker.navigator.TalkItemNavigator
import kotlinx.android.synthetic.main.activity_main.*

const val TALK_ID_KEY = "TALK_ID"

class MainActivity : AppCompatActivity(), TalkItemNavigator {
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        val taskList = TalkListFragment()
        transaction.replace(R.id.container, taskList)
        transaction.commit()
    }

    override fun openTaskDetail(talkId: String) {
        val intent = Intent(this, TalkDetailActivity::class.java)
        intent.putExtra(TALK_ID_KEY, talkId)
        startActivity(intent)
    }
}
