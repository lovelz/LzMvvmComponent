package com.lz.module.main.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * author: lovelz
 * date: on 2020-06-09
 */
abstract class BaseDataActivity : AppCompatActivity() {

    protected var mDrawableList: MutableList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    private fun initData() {
        for (i in 0..2) {
            val drawable = resources.getIdentifier("guide$i", "drawable", packageName)
            mDrawableList.add(drawable)
        }

    }

}