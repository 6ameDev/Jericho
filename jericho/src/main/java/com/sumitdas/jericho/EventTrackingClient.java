package com.sumitdas.jericho;

import android.location.Location;

import java.util.Map;

public interface EventTrackingClient {

    void track(String eventName, Map<String, Object> attributes);

    void setLocation(Location location);

    void setUserProperty(String key, Object value);

    void setUserProperties(Map<String, Object> profile);
}
