package demo;

import java.sql.*;

public class BankTransactionDemo {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
             PreparedStatement find_saving_account_by_id=connection
                     .prepareStatement("select amount from saving_account where saving_account_id=?");
             PreparedStatement deposit_withdraw_saving_account = connection
                     .prepareStatement("update saving_account set amount=? where saving_account_id=?")) {

            int transferAmount = 1500;

            connection.setAutoCommit(false);
            withDrawSavingAccount(1, find_saving_account_by_id, deposit_withdraw_saving_account, transferAmount);
//            System.out.println(6/0);
            depositSavingAccount(2, find_saving_account_by_id, deposit_withdraw_saving_account, transferAmount);
            connection.commit();

            System.out.println("John's amount in Saving Account: " + findSavingAmountById(1, find_saving_account_by_id));
            System.out.println("Mary's amount in Saving Account: " + findSavingAmountById(2, find_saving_account_by_id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int depositSavingAccount(int id, PreparedStatement find, PreparedStatement update, int amount) throws SQLException{
        int existingAmount = findSavingAmountById(id, find);
        int updateAmount = existingAmount + amount;

        update.setInt(1, updateAmount);
        update.setInt(2, id);
        update.executeUpdate();

        return updateAmount;
    }

    public static int withDrawSavingAccount(int id, PreparedStatement find, PreparedStatement update, int amount) throws SQLException{
        int existingAmount = findSavingAmountById(id, find);
        int updateAmount = existingAmount - amount;
        if(updateAmount < 0) {
            throw new IllegalArgumentException(amount + "insuffient amount");
        }
        update.setInt(1, updateAmount);
        update.setInt(2, id);
        update.executeUpdate();

        return updateAmount;
    }

    public static int findSavingAmountById(int id, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        int amount = 0;
        while (resultSet.next()) {
            amount = resultSet.getInt("amount");
        }
        return amount;
    }
}
