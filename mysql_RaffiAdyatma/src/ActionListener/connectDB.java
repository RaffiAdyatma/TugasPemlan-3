package ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import SQL.MySQL;

public class connectDB implements ActionListener {

    JTextField namaDatabase = null;
    MySQL database = null;

    public connectDB(JTextField a, MySQL b){
        namaDatabase = a;
        database = b;
    }

    // membuat koneksi ke database
    public void actionPerformed(ActionEvent e) {
        database.connect(namaDatabase.getText());
    }
    
}
