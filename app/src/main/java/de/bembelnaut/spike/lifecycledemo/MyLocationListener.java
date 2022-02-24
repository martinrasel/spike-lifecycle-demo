package de.bembelnaut.spike.lifecycledemo;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import static androidx.lifecycle.Lifecycle.State.STARTED;

class MyLocationListener implements LifecycleObserver {
    private final Context context;
    private final Lifecycle lifecycle;
    private final Runnable runnable;
    private boolean enabled = false;

    public MyLocationListener(Context context, Lifecycle lifecycle, Runnable runnable) {
        this.context = context;
        this.lifecycle = lifecycle;
        this.runnable = runnable;

        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start() {
        if (enabled) {
            // open up connection
            runnable.run();
        }
    }

    public void enable() {
        enabled = true;
        if (lifecycle.getCurrentState().isAtLeast(STARTED)) {
            // connect if not connected
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() {
        // disconnect if connected
    }
}