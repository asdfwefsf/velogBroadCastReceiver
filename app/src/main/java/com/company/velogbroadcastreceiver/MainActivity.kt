package com.company.velogbroadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.velogbroadcastreceiver.ui.theme.VelogBroadCastReceiverTheme

class MainActivity : ComponentActivity() {

    private val airPlaneModeReceiver = AirPlaneModeReceiver()
    private val testReceiver = TestReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VelogBroadCastReceiverTheme {
                Button(onClick = { sendTestBroadcast() }) {
                    Text(text = "너가 만든 쿠키~")
                }
            }
        }
    }
    private fun sendTestBroadcast() {
        val intent = Intent("TEST_ACTION")
        sendBroadcast(intent)
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(
                airPlaneModeReceiver,
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )

        val testIntentFilter = IntentFilter("TEST_ACTION")

        registerReceiver(testReceiver, testIntentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(airPlaneModeReceiver)
        unregisterReceiver(testReceiver)
    }
}

