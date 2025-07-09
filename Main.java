public class Main {
    public static void main(String[] args){
        System.out.println("Expense Tracker!");

        ExpenseDAO ExpDAO = new ExpenseDAO();
        ExpDAO.addExpense("Academic fee", 375000.00, "2025-07-01");

        ExpDAO.getAllExpenses();

        ExpDAO.getTotalExpenseAmount();
    }
}
