package com.my.utils;

import java.sql.*;

public class DatabaseConnection {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DBURL = "jdbc:mysql://localhost:3306/test?useUnicode=true" +
            "&characterEncoding=UTF-8&serverTimezone=UTC";
    private static String DBUSER = "root";
    private static String DBPASSWORD = "123456";
    private Connection connection = null;
    public DatabaseConnection() throws Exception{//通过构造方法链接数据库
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        } catch (Exception e) {
            throw e;
        }
    }
    //获得数据库连接

    /**
     * @return 数据库连接
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * 数据库链接关闭操作
     * @throws SQLException
     */
    public static void close(Connection connection){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement preparedStatement){
        if(preparedStatement!=null){
            try{
                preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
