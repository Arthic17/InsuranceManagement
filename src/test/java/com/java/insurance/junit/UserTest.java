package com.java.insurance.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import com.java.insurance.model.User;

public class UserTest {

    @Test
    public void testToString() {
        User user = new User(1, "admin", "admin123", "Administrator");
        String expected = "User [userId=1, userName=admin, password=admin123, role=Administrator]";
        assertEquals(expected, user.toString());
    }

    @Test
    public void testGettersAndSetters() {
        User user = new User();

        user.setUserId(2);
        user.setUserName("john_doe");
        user.setPassword("securePass");
        user.setRole("Manager");

        assertEquals(2, user.getUserId());
        assertEquals("john_doe", user.getUserName());
        assertEquals("securePass", user.getPassword());
        assertEquals("Manager", user.getRole());
    }

    @Test
    public void testParameterizedConstructor() {
        User user = new User(3, "jane_smith", "jane123", "Agent");

        assertEquals(3, user.getUserId());
        assertEquals("jane_smith", user.getUserName());
        assertEquals("jane123", user.getPassword());
        assertEquals("Agent", user.getRole());
    }

    @Test
    public void testDefaultConstructor() {
        User user = new User();
        assertNotNull(user);
    }
}
