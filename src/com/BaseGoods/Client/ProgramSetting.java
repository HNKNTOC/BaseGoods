package com.BaseGoods.Client;

/**
 *
 */
public interface ProgramSetting {
    interface Connect {
        String IP = "localhost";
        int PORT = 3306;
    }

    class User{
        public static String NAME = "";
        public static String PASSWORD = "";
    }
}
