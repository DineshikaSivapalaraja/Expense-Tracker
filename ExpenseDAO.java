//import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.*;
//import java.util.*;

public class ExpenseDAO {

    //1.add expense
    public void addExpense(String description, double amount, String date){
        String sql = "INSERT INTO expenses (description,amount,expense_date) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement st = conn.prepareStatement(sql)
        ) {
            st.setString(1, description);
            st.setDouble(2, amount);
            st.setDate(3, Date.valueOf(date));
            st.executeUpdate();
            System.out.println("Expense added!");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    //2. get all expenses
    public void getAllExpenses() {
        String sql = "SELECT * FROM expenses";
        try ( Connection conn = DBConnection.getConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
        ) {
            while (rs.next()) {
                System.out.printf("ID: %d Description: %s Amount: %.2f Date: %s\n",
                    rs.getInt("id"),
                    rs.getString("description"),
                    rs.getDouble("amount"),
                    rs.getDate("expense_date")
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    //3. get total amount of the expenses
    public double getTotalExpenseAmount(){
        String sql = "SELECT SUM(amount) as total FROM expenses";
        try(Connection conn = DBConnection.getConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
        )
        {
            if(rs.next()) {
                System.out.println("Total amount of expense is: "+ rs.getDouble("total"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0.0;
    }

    //4. remove expense from expenses table
    public void removeExpense(int id){
        String sql = "DELETE FROM expenses where id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setInt(1, id);
            int row = ps.executeUpdate();
            if(row>0){
                System.out.println("Expense id: "+id+" removed");
            }
            else{
                System.out.println("Expense id: "+id+" removed or not found");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
