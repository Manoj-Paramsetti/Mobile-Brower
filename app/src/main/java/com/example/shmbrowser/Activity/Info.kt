package com.example.shmbrowser.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.shmbrowser.Fragments.AboutDevelopers
import com.example.shmbrowser.Fragments.AboutSRP
import com.example.shmbrowser.Fragments.InfoFragment
import com.example.shmbrowser.R


class Info : AppCompatActivity() {
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var frame: FrameLayout
    lateinit var aboutSRP: Button
    lateinit var aboutDevelopers: Button
    lateinit var backToMain: ImageButton
    lateinit var cardView: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        frame = findViewById(R.id.frame)
        backToMain = findViewById(R.id.backToMain)
        aboutDevelopers = findViewById(R.id.aboutDevelopers)
        aboutSRP = findViewById(R.id.aboutSRP)
        cardView = findViewById(R.id.cardView)

        cardView.visibility = View.VISIBLE

        supportFragmentManager.beginTransaction()
                .replace(
                        R.id.frame,
                        InfoFragment()
                )
                .commit()

        aboutSRP.setOnClickListener {
            cardView.visibility = View.GONE
            supportFragmentManager.beginTransaction()
                    .replace(
                            R.id.frame,
                            AboutSRP()
                    )
                    .commit()
        }

        aboutDevelopers.setOnClickListener {
            cardView.visibility = View.GONE
            supportFragmentManager.beginTransaction()
                    .replace(
                            R.id.frame,
                            AboutDevelopers()
                    )
                    .commit()
        }

        backToMain.setOnClickListener {
            val frag = supportFragmentManager.findFragmentById(R.id.frame)
            when (frag) {
                !is InfoFragment -> {
                    cardView.visibility = View.VISIBLE
                    supportFragmentManager.beginTransaction()
                            .replace(
                                    R.id.frame,
                                    InfoFragment()
                            )
                            .commit()
                }
                else -> {
                    startActivity(Intent(this@Info, MainActivity::class.java))
                    finish()
                }
            }
        }
    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)
        when (frag) {
            !is InfoFragment -> {
                cardView.visibility = View.VISIBLE
                supportFragmentManager.beginTransaction()
                        .replace(
                                R.id.frame,
                                InfoFragment()
                        )
                        .commit()
            }
            else -> {
                startActivity(Intent(this@Info, MainActivity::class.java))
                finish()
            }
        }
    }
}