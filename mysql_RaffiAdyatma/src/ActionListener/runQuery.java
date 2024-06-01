package ActionListener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import SQL.MySQL;

public class runQuery implements ActionListener{

    JTextField ketikkan = null;
    MySQL database = null;

    public runQuery(JTextField a, MySQL b){
        ketikkan = a;
        database = b;
    }

    // menjalankan query yang diketikkan di textField
    public void actionPerformed(ActionEvent e) {
        String a = ketikkan.getText();
        if(a.replaceAll(" ", "").substring(0, 6).equalsIgnoreCase("select")){
            database.see(a);
        }
        if(a.replaceAll(" ", "").substring(0, 3).equalsIgnoreCase("add")){
            database.quickAdd(format(a.substring(3, a.length())));
        }
        else{
            database.query(a);
        }
    }

    private String format(String a){
        String output = "";
        a = a.replaceAll(" ", "");

        int index;
        do {
            output+= "("+ a.substring(a.indexOf('(')+1, a.indexOf(')')).replaceAll(",", ", ") 
                    +"), ";
            index = a.indexOf(')');
            a = a.substring(index+1, a.length());
        } while (a.indexOf(')')!=a.lastIndexOf(')'));
        return output+= "("+ a.substring(a.indexOf('(')+1, a.indexOf(')')).replaceAll(",", ", ") 
                    +")";
    }


    
}
