package de.bembelnaut.spike.lifecycledemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;

import android.os.Bundle;
import android.widget.Toast;

import de.bembelnaut.lifecycledemo.R;

public class MainActivity extends AppCompatActivity {

    private LifecycleRegistry lifecycleRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add observer to lifecycle
        getLifecycle().addObserver(new MyObserver());

        // create a lifecycle aware listener
        MyLocationListener myLocationListener = new MyLocationListener(this, getLifecycle(), () -> {
            Toast.makeText(MainActivity.this, "Helloooo", Toast.LENGTH_SHORT).show();
        });

        // enable listener, e.g. triggered by a button or something else
        myLocationListener.enable();

        // create my own lifecycle object
        lifecycleRegistry = new LifecycleRegistry(this);
        // add observer
        lifecycleRegistry.addObserver(new MyObserver());
        // must be forwarded
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
    }
}