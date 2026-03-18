package com.example;

import redis.clients.jedis.Jedis;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

public class Worker {
    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("redis", 6379);
        Connection conn = DriverManager.getConnection("jdbc:postgresql://postgres:5432/votes", "postgres", "password");

        String sql = "INSERT INTO votes (option_name, count) VALUES (?, ?) ON CONFLICT (option_name) DO UPDATE SET count = votes.count + ?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        while (true) {
            Map<String, String> votes = jedis.hgetAll("votes");
            for (Map.Entry<String, String> entry : votes.entrySet()) {
                String option = entry.getKey();
                int count = Integer.parseInt(entry.getValue());
                stmt.setString(1, option);
                stmt.setInt(2, count);
                stmt.setInt(3, count);
                stmt.executeUpdate();
                jedis.hdel("votes", option);
            }
            Thread.sleep(5000);
        }
    }
}