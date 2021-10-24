package EhsanFrame.Pakage;
import java.sql.*;
import javax.swing.JOptionPane;

class DbConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private int flag;

    public DbConnect() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sec8d","root","");
            st= con.createStatement();

        }catch (Exception e){
            System.err.println("Error: " +e);
        }
    }
    public void RegisterInsert(String queryInsert){
        try{
            st.executeUpdate(queryInsert);
            JOptionPane.showMessageDialog(null,"Registration Complete!! ");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Not Inserted!!" +ex);
        }
    }
    void Login(String loginQuery, String loginUsername, String loginPass) {
        try{
            rs = st.executeQuery(loginQuery);
            while(rs.next()){
                String tableUsername = rs.getString(2);
                String tablePass = rs.getString(4);

                if(loginUsername.equals(tableUsername)&& loginPass.equals(tablePass)){
                    flag=1;
                    break;
                }
            }
            if(flag== 0){
                JOptionPane.showMessageDialog(null,"Username and password not matching!!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Login Successfull");
            }

        }catch(SQLException e){
        }
    }

}
