package com.sumitdas.sample;

import android.location.Location;

import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.sumitdas.jericho.EventTrackingClient;

import org.json.JSONObject;

import java.util.Map;

class MixpanelClient implements EventTrackingClient {

    private final MixpanelAPI mixpanelAPI;
    private MixpanelAPI.People people;

    public MixpanelClient(MixpanelAPI mixpanelAPI) {
        this.mixpanelAPI = mixpanelAPI;
        this.people = mixpanelAPI.getPeople();
    }

    @Override
    public void track(String eventName, Map<String, Object> attributes) {
        JSONObject jsonAttributes = new JSONObject(attributes);
        mixpanelAPI.track(eventName, jsonAttributes);
    }

    @Override
    public void setLocation(Location location) {
        // TODO: 06/11/17 Implement setting location of the user
    }

    @Override
    public void setUserProperty(String key, Object value) {
        people.set(key, value);
    }

    @Override
    public void setUserProperties(Map<String, Object> profile) {
        people.setMap(profile);
    }
}
