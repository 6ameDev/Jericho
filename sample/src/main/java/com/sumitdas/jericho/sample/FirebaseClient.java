package com.sumitdas.jericho.sample;

import android.content.Intent;
import android.location.Location;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.sumitdas.jericho.EventTrackingClient;

import java.util.Map;

class FirebaseClient implements EventTrackingClient {

    private final FirebaseAnalytics firebaseAnalytics;

    public FirebaseClient(FirebaseAnalytics firebaseAnalytics) {
        this.firebaseAnalytics = firebaseAnalytics;
    }

    @Override
    public void track(String eventName, Map<String, Object> attributes) {
        Intent intent = new Intent();
        for (Map.Entry<String, Object> attribute : attributes.entrySet()) {
            intent.putExtra(attribute.getKey(), String.valueOf(attribute.getValue()));
        }
        firebaseAnalytics.logEvent(eventName, intent.getExtras());
    }

    @Override
    public void setLocation(Location location) {
        // TODO: 06/11/17 Implement setting location of the user
    }

    @Override
    public void setUserProperty(String key, Object value) {
        firebaseAnalytics.setUserProperty(key, String.valueOf(value));
    }

    @Override
    public void setUserProperties(Map<String, Object> profile) {
        for (Map.Entry<String, Object> profileProperty : profile.entrySet()) {
            firebaseAnalytics.setUserProperty(profileProperty.getKey(),
                    String.valueOf(profileProperty.getValue()));
        }
    }
}
