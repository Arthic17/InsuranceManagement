package com.java.insurance.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.java.insurance.model.Payment;

public class PaymentTest {

    @Test
    public void testToString() {
        Date paymentDate = new Date();
        Payment payment = new Payment(1, paymentDate, 2500.0, 101);
        String expected = "Payment [paymentId=1, paymentDate=" + paymentDate +
                          ", paymentAmount=2500.0, clientId=101]";
        assertEquals(expected, payment.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Payment payment = new Payment();
        Date date = new Date();

        payment.setPaymentId(2);
        payment.setPaymentDate(date);
        payment.setPaymentAmount(3500.5);
        payment.setClientId(202);

        assertEquals(2, payment.getPaymentId());
        assertEquals(date, payment.getPaymentDate());
        assertEquals(3500.5, payment.getPaymentAmount(), 0.001);
        assertEquals(202, payment.getClientId());
    }

    @Test
    public void testParameterizedConstructor() {
        Date date = new Date();
        Payment payment = new Payment(3, date, 1200.75, 303);

        assertEquals(3, payment.getPaymentId());
        assertEquals(date, payment.getPaymentDate());
        assertEquals(1200.75, payment.getPaymentAmount(), 0.001);
        assertEquals(303, payment.getClientId());
    }

    @Test
    public void testDefaultConstructor() {
        Payment payment = new Payment();
        assertNotNull(payment);
    }
}
