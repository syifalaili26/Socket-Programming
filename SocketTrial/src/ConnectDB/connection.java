package ConnectDB;

import java.sql.*;

public class connection {
	private Connection connect;
	private Statement statement;

	public void Connect(){
		try{
			String database = "jdbc:mysql://localhost:3306/tb_socket";
			String user = "root";
			String password = "";
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(database, user, password);
			statement = connect.createStatement();
		}
		catch(Exception x){
			System.out.println("Can't connect to Database "+x);
		}
	}//connect
    
	public void Disconnect(ResultSet rs){
		try{
            if (rs != null){
                rs.close();
            }
            statement.close();
            connect.close();
        }
        catch(Exception x){
            System.out.println("Can't disconnect from Database "+x);
        }
    }//disconnect
    
    public ResultSet getData(String sql){
        ResultSet rs = null;
        try{
            Connect();
            rs = statement.executeQuery(sql);
        }
        catch(Exception x){
            System.out.println("Can't get data from database "+x);
        }
        return rs;
    }//getData
    
    public void saveData(String sql){
        try{
            Connect();
            statement.executeUpdate(sql);
        }
        catch(Exception x){
            System.out.println("Can't save data to database "+x);
        }
    }
    
    public static void main(String[] args) throws SQLException {
    	connection connect = new connection();
    	connect.Connect();
    }
}
