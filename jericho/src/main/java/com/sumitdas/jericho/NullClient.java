package com.sumitdas.jericho;

import android.location.Location;

import java.util.Map;

public class NullClient implements EventTrackingClient {

    @Override
    public void track(String eventName, Map<String, Object> attributes) {

    }

    @Override
    public void setLocation(Location location) {

    }

    @Override
    public void setUserProperty(String key, Object value) {

    }

    @Override
    public void setUserProperties(Map<String, Object> profile) {

    }
}
