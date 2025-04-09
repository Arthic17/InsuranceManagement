package com.java.insurance.dao;


import java.sql.SQLException;
import java.util.Collection;

public interface IPolicyServiceDao {

    //boolean createPolicy(int clientId, String policy) throws SQLException;
	boolean createPolicy(int clientId, String name, String contactInfo, String policy) throws SQLException;

    String getPolicy(int clientId) throws SQLException;

    Collection<String> getAllPolicies() throws SQLException;

    boolean updatePolicy(int clientId, String newPolicy) throws SQLException;

    boolean deletePolicy(int clientId) throws SQLException;
}

