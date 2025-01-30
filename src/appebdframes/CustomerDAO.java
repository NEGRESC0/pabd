package appebdframes;

import java.sql.*;

public class CustomerDAO {
    private Connection con;

    public CustomerDAO() throws SQLException {

        this.con = new ConnectionFactory().getConnection();
        System.out.println("Connection OK!");

    }

    public void insertCustomer(Customer c) throws SQLException {
        String sql = "insert into customer "
                + "(store_id, first_name, last_name, email, address_id, active) "
                + "values "
                + "(?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, c.getStore_id());
        pst.setString(2, c.getFirst_name());
        pst.setString(3, c.getLast_name());
        pst.setString(4, c.getEmail());
        pst.setInt(5, c.getAddress_id());
        pst.setInt(6, c.getActive());

        pst.execute();
        pst.close();
        System.out.println("Customer ADDED!");
    }

    public void deleteCustomer(int id) throws SQLException {
        String sql = "delete from customer "
                + "where customer_id = " + id;
        PreparedStatement pst = con.prepareStatement(sql);
        pst.execute();
        pst.close();
        System.out.println("Customer DELETED!");
    }

    public void updateCustomer(Customer c, int id) throws SQLException {
        String sql = "update customer "
                + "set store_id = ?, first_name = ?, last_name = ?, email = ?, address_id = ?, active = ? "
                + "where customer_id = " + id;
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setInt(1, c.getStore_id());
        pst.setString(2, c.getFirst_name());
        pst.setString(3, c.getLast_name());
        pst.setString(4, c.getEmail());
        pst.setInt(5, c.getAddress_id());
        pst.setInt(6, c.getActive());
        
        pst.execute();
        pst.close();
        System.out.println("Customer UPDATED!");
    }

    public void showCustomers() throws SQLException {
        Statement st = con.createStatement();

        String query = "select * from customer "
                + "order by customer_id desc "
                + "limit 5";

        ResultSet rs = st.executeQuery(query);

        ResultSetMetaData md = rs.getMetaData();
        int col = md.getColumnCount();

        System.out.println("Tabela: " + md.getTableName(1)); //Nome da tabela

        for (int i = 1; i <= col; i++) {
            System.out.println(md.getColumnName(i) + "\t" + md.getColumnTypeName(i)); // Nome da coluna + Tipo de dado da linha

        }

        System.out.println("");

        for (int i = 1; i <= col; i++) {
            System.out.print(md.getColumnName(i) + "\t");// Nome da coluna

        }

        System.out.println("");

        while (rs.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println("");
        }
    }
}
