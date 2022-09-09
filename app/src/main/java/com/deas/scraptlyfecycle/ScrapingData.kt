package com.deas.scraptlyfecycle

import android.util.Log
import androidx.lifecycle.*

class ScrapingData(private val lifecycle : Lifecycle, private val callback : (String) -> Unit) : DefaultLifecycleObserver{

    private var enabled = false
    var status = ""

    init {
        lifecycle.addObserver(this)
    }

    //option 1 automatically
    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        enabled = true
        status = CONNECTED
        Log.d("#### ---", "onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("#### ---", "onResume")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        status = DISCONNECTED
        if(enabled) status = DISCONNECTED
        Log.d("#### ---", "onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        lifecycle.removeObserver(this)
        Log.d("#### ---", "onDestroyed")
    }

    //when start manually
    fun enabled(){
        if(lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED)) {
            status = CONNECTED
            enabled = true
            Log.d("#### ---", "Started")
        }
    }

    companion object {
        const val CONNECTED = "Connected"
        const val DISCONNECTED = "Disconnected"
    }

}