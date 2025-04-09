package com.java.insurance.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.java.insurance.model.Claim;

public class ClaimTest {

    @Test
    public void testToString() {
        Date filedDate = new Date();
        Claim claim = new Claim(1, "CLM12345", filedDate, 5000.0, "Pending", "Health", 101);
        String expected = "Claim [claimId=1, claimNumber=CLM12345, dateFiled=" + filedDate +
                          ", claimAmount=5000.0, status=Pending, policy=Health, clientId=101]";
        assertEquals(expected, claim.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Claim claim = new Claim();
        Date date = new Date();

        claim.setClaimId(2);
        claim.setClaimNumber("CLM54321");
        claim.setDateFiled(date);
        claim.setClaimAmount(7500.0);
        claim.setStatus("Approved");
        claim.setPolicy("Auto");
        claim.setClientId(202);

        assertEquals(2, claim.getClaimId());
        assertEquals("CLM54321", claim.getClaimNumber());
        assertEquals(date, claim.getDateFiled());
        assertEquals(7500.0, claim.getClaimAmount(), 0.001);
        assertEquals("Approved", claim.getStatus());
        assertEquals("Auto", claim.getPolicy());
        assertEquals(202, claim.getClientId());
    }

    @Test
    public void testParameterizedConstructor() {
        Date filedDate = new Date();
        Claim claim = new Claim(3, "CLM99999", filedDate, 9000.0, "Rejected", "Travel", 303);

        assertEquals(3, claim.getClaimId());
        assertEquals("CLM99999", claim.getClaimNumber());
        assertEquals(filedDate, claim.getDateFiled());
        assertEquals(9000.0, claim.getClaimAmount(), 0.001);
        assertEquals("Rejected", claim.getStatus());
        assertEquals("Travel", claim.getPolicy());
        assertEquals(303, claim.getClientId());
    }

    @Test
    public void testDefaultConstructor() {
        Claim claim = new Claim();
        assertNotNull(claim);
    }
}
