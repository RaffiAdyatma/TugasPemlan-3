package ActionListener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import SQL.MySQL;

public class table implements ActionListener{

    JTextField namaTabel = null;
    MySQL database = null;

    public table(JTextField a, MySQL b){
        namaTabel = a;
        database = b;
    }

    // set tabel dan menunjukkan informasi dalam tabel
    public void actionPerformed(ActionEvent e) {
        database.setTabel(namaTabel.getText());
        database.see();
    }
    
}
