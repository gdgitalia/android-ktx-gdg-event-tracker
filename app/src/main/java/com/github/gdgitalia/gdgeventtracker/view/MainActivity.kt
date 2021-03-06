package com.github.gdgitalia.gdgeventtracker.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.github.gdgitalia.gdgeventtracker.R
import com.github.gdgitalia.gdgeventtracker.navigator.TalkItemNavigator
import kotlinx.android.synthetic.main.activity_main.*

const val TALK_ID_KEY = "TALK_ID"

class MainActivity : AppCompatActivity(), TalkItemNavigator {
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_list -> {
                    showTaskList()
                    item.isChecked = true
                    true
                }
                R.id.navigation_about -> {
                    showAbout()
                    item.isChecked = true
                    true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            showTaskList()
        }
    }

    override fun openTaskDetail(talkId: String) {
        val intent = Intent(this, TalkDetailActivity::class.java)
        intent.putExtra(TALK_ID_KEY, talkId)
        startActivity(intent)
    }

    private fun showTaskList() {
        changeFragment(TalkListFragment())
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun showAbout() {
        changeFragment(AboutFragment())
    }
}
