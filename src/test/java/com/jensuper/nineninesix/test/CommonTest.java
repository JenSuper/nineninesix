package com.jensuper.nineninesix.test;

import com.custom.PrintService;
import com.custom.service.ConnectionTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author jichao
 * @version V1.0
 * @description:
 * @date 2020/01/14
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CommonTest {

    @Resource
    private PrintService printService;
    @Resource
    private ConnectionTemplate connectionTemplate;

    @Test
    public void test(){
        printService.printService();
    }

    @Test
    public void connectionTemplate() throws SQLException {
        Connection connection = connectionTemplate.connection();
        System.out.println(connection.isClosed());
    }
    
    @Test
    public void test2(){
        String url = "jdbc:mysql://172.26.104.93:3306/mysql?useSSL=false&serverTimezone=GMT%2B8&tinyInt1isBit=false&allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "root";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
