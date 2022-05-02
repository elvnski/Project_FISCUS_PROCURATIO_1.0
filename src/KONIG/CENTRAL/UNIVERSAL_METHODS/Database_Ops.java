package KONIG.CENTRAL.UNIVERSAL_METHODS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_Ops {
    public String host = "jdbc:mysql://localhost:3306/fiscus_procuratio?allowMultiQueries=true&useUnicode=true&characterEncoding=utf8";
    public String database_user = "root";
    public String password = "Hermano1738!";
    public Statement Database_Command;
    public Connection DB_Connection;

    public void Create_DB_Connection() {
        try {
            DB_Connection = DriverManager.getConnection(host, database_user, password);
            Database_Command = DB_Connection.createStatement();
            System.out.println("-- Connection was successful! --");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Close_DB_Connection() {
        try {
            DB_Connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void Save_to_DB(String sql) {
        try {
            Database_Command.execute(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
