package com.company.velogbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.util.Log

class AirPlaneModeReceiver : BroadcastReceiver(){
    override fun onReceive(context : Context?, intent : Intent?) {
        if(intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            // Settings.Global.getInt()는 안드로이드 시스템 설정 중 하나의 값을 정수형으로 반환한다.
            // 아래코드에서는 비행기 모드가 켜져 있으면 1 , 꺼져 있으면 0으로 반환된다.
            val isTurnedOn = Settings.Global.getInt(
                context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON
            ) != 0
            Log.d("haha", "비행기모드가 $isTurnedOn")
        }
    }
}