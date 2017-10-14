package com.sumitdas.jericho;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import android.location.Location;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;

@RunWith(MockitoJUnitRunner.class)
public class JerichoTest {

    private static final String KEY_CLIENT_ONE = "one";
    private static final String KEY_CLIENT_TWO = "two";

    @Mock
    EventTrackingClient clientOne;
    @Mock
    EventTrackingClient clientTwo;

    private Location location;
    private Jericho jericho;

    @Before
    public void setUp() throws Exception {
        HashMap<String, EventTrackingClient> clients = new HashMap<>();
        clients.put(KEY_CLIENT_ONE, clientOne);
        clients.put(KEY_CLIENT_TWO, clientTwo);
        jericho = new Jericho(clients);

        location = new Location("");
    }

    @Test
    public void shouldTrackOnAllClients() throws Exception {
        String eventName = "event";
        HashMap<String, Object> attributes = new HashMap<>();

        jericho.track(eventName, attributes);

        verify(clientOne, times(1)).track(eventName, attributes);
        verify(clientTwo, times(1)).track(eventName, attributes);
        verifyNoMoreInteractions(clientOne, clientTwo);
    }

    @Test
    public void shouldSetLocationAndTrackOnAllClients() throws Exception {
        String eventName = "event";
        HashMap<String, Object> attributes = new HashMap<>();

        jericho.track(eventName, attributes, location);

        InOrder inOrder = inOrder(clientOne, clientTwo);

        inOrder.verify(clientOne, times(1)).setLocation(location);
        inOrder.verify(clientOne, times(1)).track(eventName, attributes);
        inOrder.verify(clientTwo, times(1)).setLocation(location);
        inOrder.verify(clientTwo, times(1)).track(eventName, attributes);
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void shouldSetUserPropertyOnAllClients() throws Exception {
        jericho.setUserProperty("key", "value");

        InOrder inOrder = inOrder(clientOne, clientTwo);

        inOrder.verify(clientOne, times(1)).setUserProperty("key", "value");
        inOrder.verify(clientTwo, times(1)).setUserProperty("key", "value");
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void shouldSetUserPropertiesOnAllClients() throws Exception {
        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("key-one", "value-one");
        attributes.put("key-two", "value-two");
        attributes.put("key-three", "value-three");

        jericho.setUserProperties(attributes);

        InOrder inOrder = inOrder(clientOne, clientTwo);

        inOrder.verify(clientOne, times(1)).setUserProperties(attributes);
        inOrder.verify(clientTwo, times(1)).setUserProperties(attributes);
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void shouldSetLocationOnAllClients() throws Exception {
        jericho.setLocation(location);

        verify(clientOne, times(1)).setLocation(location);
        verify(clientTwo, times(1)).setLocation(location);
        verifyNoMoreInteractions(clientOne, clientTwo);
    }

    @Test
    public void shouldReturnNullClientWhenKeyValueDoesNotExist() throws Exception {
        assertTrue(jericho.client("some_key") instanceof NullClient);
    }

    @Test
    public void shouldReturnClientWhenKeyValueExists() throws Exception {
        assertFalse(jericho.client(KEY_CLIENT_ONE) instanceof NullClient);
    }
}
