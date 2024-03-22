package com.company.velogbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class TestReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == "TEST_ACTION") {
            Log.d("haha","내가 만든 쿠키~ 너가 만든 리시버~")
        }
    }
}