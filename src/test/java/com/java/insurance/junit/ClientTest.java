package com.java.insurance.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import com.java.insurance.model.Client;

public class ClientTest {

    @Test
    public void testToString() {
        Client client = new Client(1, "John Doe", "987-654-3210", "Life Insurance");
        String expected = "Client [clientId=1, clientName=John Doe, contactInfo=987-654-3210, policy=Life Insurance]";
        assertEquals(expected, client.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Client client = new Client();

        client.setClientId(2);
        client.setClientName("Jane Smith");
        client.setContactInfo("123-456-7890");
        client.setPolicy("Health Insurance");

        assertEquals(2, client.getClientId());
        assertEquals("Jane Smith", client.getClientName());
        assertEquals("123-456-7890", client.getContactInfo());
        assertEquals("Health Insurance", client.getPolicy());
    }

    @Test
    public void testParameterizedConstructor() {
        Client client = new Client(3, "Alice Brown", "555-555-5555", "Vehicle Insurance");

        assertEquals(3, client.getClientId());
        assertEquals("Alice Brown", client.getClientName());
        assertEquals("555-555-5555", client.getContactInfo());
        assertEquals("Vehicle Insurance", client.getPolicy());
    }

    @Test
    public void testDefaultConstructor() {
        Client client = new Client();
        assertNotNull(client);
    }
}
