package appebdframes;

import java.sql.*; //importa a java.sql pra trabalhar com o conjunto
import java.util.logging.Level;
import java.util.logging.Logger;

public class APPeBDframes {

    /*
    CÓDIGO PARA COMMIT NO GITHUB
    
    cd "C:\Users\20221074010005\OneDrive - IFRN\TRABALHOS\Banco de Dados\APPeBDframes"
    git add .
    git commit - m "comentário"
    git push -u origin main
    */
    
    
    public static void main(String[] args) throws SQLException {
Connection con = null; //cria a connection
        
        Customer c = new Customer(2, "DREAMY", "BULL", "ambatukam2050@gmail.com", 3, 1);
        
        CustomerDAO dao = new CustomerDAO();
        
//        dao.insertCustomer(c);
//        dao.updateCustomer(c, 613);
        dao.deleteCustomer(613);
        dao.showCustomers();
    }
    
}
