package com.sentia.test.utils

import android.content.Context
import android.graphics.Point
import android.view.WindowManager


/**
 * Created by don.chummar on 22/3/18.
 */
class SystemUtils {
    companion object {
        fun getSystemWidth(context: Context): Int {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val size = Point()
            display.getSize(size)
            return size.x
        }

        fun getSystemHeight(context: Context): Int {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val size = Point()
            display.getSize(size)
            return size.y
        }
        fun getScreenOrientation(context: Context): Int {
            return context.resources.configuration.orientation
        }

    }
}