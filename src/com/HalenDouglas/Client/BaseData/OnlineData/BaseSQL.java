package com.HalenDouglas.Client.BaseData.OnlineData;



import com.HalenDouglas.Client.BaseData.Base;
import com.HalenDouglas.Client.Logic.Goods;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.*;
import java.util.HashMap;

/**
 * Created connectBase
 */
public class BaseSQL implements Base {
    private String user;
    private String password;
    private String url;
    private Connection connection;
    private String error;
    private java.sql.Statement statement=null;

    public BaseSQL(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public BaseSQL() {
        user = "root";
        password = "test";
        url = "jdbc:mysql://localhost:3306";
    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public boolean connectBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            error = "Не удалось получить драйвер";
            return false;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error № "+e.getErrorCode());
            switch (e.getErrorCode()){
                case 0:error="Не удалось подключится к серверу"; break;
                case 1045:error="Неправильно указан логин или пароль!"; break;
            }
            return false;
        }
        return true;
    }

    public Goods getGoods(String id){
        Goods goods = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Name, id, Collection, Typ, state, Cost, Image FROM data_user.goods INNER JOIN data_user.goods_state ON " +
                    "id = '"+id+"' AND goods.id = goods_state.id_state;");
            while (resultSet.next()){
                goods = new Goods(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                        resultSet.getString(5),resultSet.getInt(6),"no_image.png");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public HashMap<String,Goods> getAllGoods(){
        HashMap<String,Goods> listGods = new HashMap<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Name, id, Collection, Typ, state, Cost, Image " +
                    "FROM data_user.goods INNER JOIN data_user.goods_state ON goods.id = goods_state.id_state;");
            while (resultSet.next()){
                listGods.put(resultSet.getString(1),new Goods(resultSet.getString(1),resultSet.getString(2)
                        ,resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),"no_image.png"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listGods;
    }

    @Override
    public int getSizeBase(){
        int i=0;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS '' FROM data_user.goods");
            resultSet.next();
            i=resultSet.getInt(1);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean addGoods(Goods goods){
        try {
            statement = connection.createStatement();
            statement.execute("USE data_user;");
            statement.execute("INSERT INTO `data_user`.`goods` (`id`, `Name`, `Collection`, `Typ`,`Cost`) " +
                    "VALUES ('" + goods.getId() + "', '" + goods.getName() + "', '" + goods.getCollection() + "','" + goods.getType() + "', '" + goods.getCost() + "');");
            statement.execute("insert into goods_state (id_state,state) value ('"+goods.getId()+"',1);");
            statement.close();
        }catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Повторение ключа! "+ goods.getId());
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean sellGoods(String id){

        try {
            statement = connection.createStatement();
            statement.execute("UPDATE data_user.goods_state SET state='2' WHERE id_state='"+id+"';");
            statement.execute("insert into data_user.time_sale (id_time,time) value ('"+id+"',current_timestamp());");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return true;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void setGoods(String id) {

    }
}
