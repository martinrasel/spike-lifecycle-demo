package de.bembelnaut.spike.lifecycledemo;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void connectListener() {
        Log.i("lifecycle", "On resume event");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void disconnectListener() {
        Log.i("lifecycle", "On pause event");
    }
}
