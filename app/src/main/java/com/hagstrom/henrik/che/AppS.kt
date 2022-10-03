package com.hagstrom.henrik.che

import android.app.Application
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.identifier.AdvertisingIdClient

import com.onesignal.OneSignal

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppS : Application() {

    companion object {
        const val AF_DEV_KEY = "6LCb5pcAZ8SM6pAXvmsRPU"
        const val jsoupCheck = "3f1f"
        const val ONESIGNAL_APP_ID = "b8258d65-a035-4ede-a89c-c9515ee6883b"

        val linkFilterPart1 = "http://lunar"
        val linkFilterPart2 = "leprechauns.xyz/go.php?to=1&"
        val linkAppsCheckPart1 = "http://lunarlep"
        val linkAppsCheckPart2 = "rechauns.xyz/apps.txt"


        val odone = "sub_id_1="

        var MAIN_ID: String? = ""
        var C1: String? = "c11"
        var D1: String? = "d11"

    }

    override fun onCreate() {
        super.onCreate()

        GlobalScope.launch(Dispatchers.IO) {
            applyDeviceId(context = applicationContext)
        }
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)


    }

    private suspend fun applyDeviceId(context: Context) {
        val advertisingInfo = Adve(context)
        val idInfo = advertisingInfo.getAdvertisingId()

        val prefs = getSharedPreferences("SP", MODE_PRIVATE)
        val editor = prefs.edit()

        editor.putString(MAIN_ID, idInfo)
        editor.apply()
    }
}

class Adve (context: Context) {
    private val adInfo = AdvertisingIdClient(context.applicationContext)
    suspend fun getAdvertisingId(): String =
        withContext(Dispatchers.IO) {
            adInfo.start()
            val adIdInfo = adInfo.info
            Log.d("getAdvertisingId = ", adIdInfo.id.toString())
            adIdInfo.id
        }
}