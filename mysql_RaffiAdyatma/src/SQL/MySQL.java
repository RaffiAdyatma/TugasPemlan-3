package SQL;
import java.sql.Statement;

import javax.swing.JTextArea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


// class untuk operasi mysql
public class MySQL {

    Statement statement;
    ResultSet result;

    String tabel;
    public void setTabel(String tabel) {this.tabel = tabel;}

    JTextArea log;
    public void setLog(JTextArea log) {this.log = log;}

    

    public void connect(String database){
         try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/"+database,
                                                         "root",
                                                         ""); 

            //
            statement=con.createStatement(); 

            log.setText(log.getText()+"\nDatabase Connected");
        } catch (Exception e) {
            log.setText(log.getText()+"\nDatabase Not Connected");
            e.printStackTrace();
        }
    }

    public void query(String query){
        try {
            log.setText(log.getText()+"\n/\n"+query+"\n/");
            statement.execute(query);
            log.setText(log.getText()+"\nberhasil");
        } catch (SQLException e) {
            log.setText(log.getText()+"\ntidak berhasil, periksa syntax");
            e.printStackTrace();
        }
    }

    public void see(){
        String query = "SELECT * FROM "+tabel;
        try {
            result = statement.executeQuery(query);
            java.sql.ResultSetMetaData rsmd = result.getMetaData();


            log.setText(log.getText()+"\n========================================================\n");
            for(int i=1; i<=rsmd.getColumnCount(); i++){
                log.setText(log.getText()+rsmd.getColumnName(i)+"     ");
            }
            log.setText(log.getText()+"\n========================================================");


            while (result.next()) {
                log.setText(log.getText()+"\n");
                for(int i=1; i<=rsmd.getColumnCount(); i++){
                    log.setText(log.getText()+result.getObject(rsmd.getColumnName(i))+"     ");
                }   
            }
            log.setText(log.getText()+"\n========================================================");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void see(String query){
        try {

            log.setText(log.getText()+"\n/\n"+query+"\n/");
            result = statement.executeQuery(query);
            java.sql.ResultSetMetaData rsmd = result.getMetaData();


            log.setText(log.getText()+"\n========================================================\n");
            for(int i=1; i<=rsmd.getColumnCount(); i++){
                log.setText(log.getText()+rsmd.getColumnName(i)+"     ");
            }
            log.setText(log.getText()+"\n========================================================");


            while (result.next()) {
                log.setText(log.getText()+"\n");
                for(int i=1; i<=rsmd.getColumnCount(); i++){
                    log.setText(log.getText()+result.getObject(rsmd.getColumnName(i))+"     ");
                }   
            }
            log.setText(log.getText()+"\n========================================================");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void quickAdd(String a){
        try {
            result = statement.executeQuery("SELECT * FROM " + tabel);
            java.sql.ResultSetMetaData rsmd = result.getMetaData();

            String key = "(";

            for(int i=1; i<rsmd.getColumnCount(); i++){
                key += rsmd.getColumnName(i) + ", ";
            }
            key += rsmd.getColumnName(rsmd.getColumnCount()) + ")";

            statement.executeUpdate("INSERT INTO "+tabel+" "+key+" VALUES "+a);

            log.setText(log.getText()+"\ndata berhasil ditambahkan");
        }
        catch (SQLException e) {
            log.setText(log.getText()+"\ndata ke Tidak Berhasil ditambahkan, periksa syntax");
            e.printStackTrace();
        }
    
        
    }

    public void close(){
        
            if(statement!=null){
                try {statement.close();} 
                catch (SQLException e) {}
            }
            if(result!=null){
            try {result.close();} 
            catch (SQLException e) {}
            }


            System.out.println("connection closed");
        
    }
    
}
