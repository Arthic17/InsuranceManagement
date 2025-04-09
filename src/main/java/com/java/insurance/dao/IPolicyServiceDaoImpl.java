package com.java.insurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.java.insurance.util.ConnectionHelper;

public class IPolicyServiceDaoImpl implements IPolicyServiceDao {
 static Connection connection;
  PreparedStatement pst;
public IPolicyServiceDaoImpl() throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
    }

    
    public boolean createPolicy(int clientId, String name, String contactInfo, String policy) throws SQLException {
        String cmd = "INSERT INTO client (client_id, client_name, contact_info, policy) VALUES (?, ?, ?, ?)";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, clientId);
        pst.setString(2, name);
        pst.setString(3, contactInfo);
        pst.setString(4, policy);
        int rows = pst.executeUpdate();
        return rows > 0;
    }


    @Override
    public String getPolicy(int clientId) throws SQLException {
        String cmd = "SELECT policy FROM client WHERE client_id = ?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, clientId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return rs.getString("policy");
        }
        return null;
    }

    @Override
    public Collection<String> getAllPolicies() throws SQLException {
        String cmd = "SELECT DISTINCT policy FROM client WHERE policy IS NOT NULL";
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        Collection<String> policies = new ArrayList<>();
        while (rs.next()) {
            policies.add(rs.getString("policy"));
        }
        return policies;
    }

    @Override
    public boolean updatePolicy(int clientId, String newPolicy) throws SQLException {
        String cmd = "UPDATE client SET policy = ? WHERE client_id = ?";
        pst = connection.prepareStatement(cmd);
        pst.setString(1, newPolicy);
        pst.setInt(2, clientId);
        int rows = pst.executeUpdate();
        return rows > 0;
    }

    @Override
    public boolean deletePolicy(int clientId) throws SQLException {
        String cmd = "UPDATE client SET policy = NULL WHERE client_id = ?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, clientId);
        int rows = pst.executeUpdate();
        return rows > 0;
    }
}
