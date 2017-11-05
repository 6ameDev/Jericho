package com.sumitdas.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.sumitdas.jericho.EventTrackingClient;
import com.sumitdas.jericho.Jericho;
import com.sumitdas.jericho.sample.R;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MixpanelAPI mixpanelAPI = MixpanelAPI.getInstance(this, getString(R.string.mixpanel_token));

        Map<String, EventTrackingClient> clients = new HashMap<>();
        clients.put(Jericho.Keys.MIXPANEL, new MixpanelClient(mixpanelAPI));
        Jericho jericho = new Jericho(clients);

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("Gender", "Female");
        attributes.put("Logged in", false);
        jericho.track("MainActivity:onCreate", attributes);
    }
}
