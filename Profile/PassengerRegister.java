import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PassengerRegister {
	public static void registPassenger(Passenger p){
        
        try {
            Class.forName(" ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = " ";
        String user = " ";
        String password = " ";
        Connection conn = null;
        String sql = "Insert Into passenger values(?,?,?,?,?,?,?)";
        PreparedStatement pst = null;
         
        //�жϵ�½���Ƿ��Ѿ�����
        Statement s = null;
        ResultSet rs = null;
        String sql_ck = "Select uName FROM passenger";
        try {
            conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement(sql);
            pst.setString(1, p.getuName());
            pst.setString(2, p.getfName());
            pst.setString(3, p.getlName());
            pst.setBoolean(4, p.getsmoker());
            pst.setInt(5, p.getgender());
            pst.setString(6, p.getemail());
            pst.setString(7, p.getpassword());
            //�жϵ�½���Ƿ��Ѿ�����
            s = conn.createStatement();
            rs = s.executeQuery(sql_ck);
            while(rs.next()){//Ϊʲô�� rs.getString(2)����ʾ ��Ч��������
                if( rs.getString("uName").equals(p.getuName()) ){
                    System.out.println("The username is existed. Please change another one");
                    break;
                }else{
                    pst.executeUpdate();
                    System.out.println("Successfully sign in");
                    break;
                }
            }   
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                pst.close();
                s.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         
         
    }
}
