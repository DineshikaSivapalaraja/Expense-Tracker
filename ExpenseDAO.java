import java.sql.Date;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;

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
                System.out.printf("ID: %d Description: %s Amount: %.2f Date: %s",
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
}
