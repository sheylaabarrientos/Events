package com.example.events.ui.utils

import java.util.*

class AutoScroll(private val autoScroll: () -> Unit) : TimerTask() {

    override fun run() {
        autoScroll.invoke()
    }
}
