package com.sumitdas.jericho;

import android.location.Location;

import java.util.Map;

public class Jericho {

    private final Map<String, EventTrackingClient> clients;

    public Jericho(Map<String, EventTrackingClient> clients) {
        this.clients = clients;
    }

    public void track(String eventName, Map<String, Object> attributes) {
        for (Map.Entry<String, EventTrackingClient> entry : clients.entrySet()) {
            EventTrackingClient client = entry.getValue();
            client.track(eventName, attributes);
        }
    }

    public void track(String eventName, Map<String, Object> attributes, Location location) {
        for (Map.Entry<String, EventTrackingClient> entry : clients.entrySet()) {
            EventTrackingClient client = entry.getValue();
            client.setLocation(location);
            client.track(eventName, attributes);
        }
    }

    public void setUserProperty(String key, Object value) {
        for (Map.Entry<String, EventTrackingClient> entry : clients.entrySet()) {
            EventTrackingClient client = entry.getValue();
            client.setUserProperty(key, value);
        }
    }

    public void setUserProperties(Map<String, Object> profile) {
        for (Map.Entry<String, EventTrackingClient> entry : clients.entrySet()) {
            EventTrackingClient client = entry.getValue();
            client.setUserProperties(profile);
        }
    }

    public void setLocation(Location location) {
        for (Map.Entry<String, EventTrackingClient> entry : clients.entrySet()) {
            EventTrackingClient client = entry.getValue();
            client.setLocation(location);
        }
    }

    public EventTrackingClient client(String key) {
        return clients.get(key) == null ? new NullClient() : clients.get(key);
    }

    public interface Keys {
        String MIXPANEL = "Mixpanel";
        String CLEVERTAP = "CleverTap";
    }
}
