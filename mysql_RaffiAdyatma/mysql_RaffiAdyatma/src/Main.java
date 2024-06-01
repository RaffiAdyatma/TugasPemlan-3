

// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import ActionListener.*;
import SQL.MySQL;

public class Main extends JFrame implements WindowListener{
    
    static MySQL database = new MySQL();

    public static void main(String[] args) {

        

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // BAGIAN KONEKSI DATABASE
        JPanel connect = new JPanel();
            connect.setLayout(new BoxLayout(connect, BoxLayout.X_AXIS));

        JLabel labelKoneksi = new JLabel("Database : ");

        Dimension LKDimension = new Dimension(80, 25);
            labelKoneksi.setPreferredSize(LKDimension);
            labelKoneksi.setMaximumSize(LKDimension);


        JTextField textFieldKoneksi = new JTextField();

        Dimension TFKDimension = new Dimension(150, 25);
            textFieldKoneksi.setPreferredSize(TFKDimension);
            textFieldKoneksi.setMaximumSize(TFKDimension);


        JButton buttonKoneksi = new JButton("connect");
            buttonKoneksi.addActionListener(new connectDB(textFieldKoneksi, database));

        Dimension BKDimension = new Dimension(80, 25);
            buttonKoneksi.setPreferredSize(BKDimension);
            buttonKoneksi.setMaximumSize(BKDimension);


            connect.add(labelKoneksi);
            connect.add(textFieldKoneksi);
            connect.add(buttonKoneksi);
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //BAGIAN TABEL
        JPanel table = new JPanel();
            table.setLayout(new BoxLayout(table, BoxLayout.X_AXIS));

        JLabel labelTabel = new JLabel("Tabel : ");

        Dimension LTDimension = new Dimension(80, 25);
            labelTabel.setPreferredSize(LTDimension);
            labelTabel.setMaximumSize(LTDimension);


        JTextField textFieldTabel = new JTextField();

        Dimension TFTDimension = new Dimension(150, 25);
            textFieldTabel.setPreferredSize(TFTDimension);
            textFieldTabel.setMaximumSize(TFTDimension);


        JButton buttonTabel = new JButton("pilih");
            buttonTabel.addActionListener(new table(textFieldTabel, database));

        Dimension BTDimension = new Dimension(80, 25);
            buttonTabel.setPreferredSize(BTDimension);
            buttonTabel.setMaximumSize(BTDimension);


            table.add(labelTabel);
            table.add(textFieldTabel);
            table.add(buttonTabel);
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //BAGIAN LOG 
        JTextArea TALog = new JTextArea();
        Dimension TALogDimension = new Dimension(950, 300);
            TALog.setMaximumSize(TALogDimension);

            TALog.setLineWrap(true);
            TALog.setEditable(false);

        database.setLog(TALog);

        JScrollPane log = new JScrollPane(TALog);
            log.setMaximumSize(TALogDimension);
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //BAGIAN MANUAL QUERY
        
        JLabel labelQuery = new JLabel("Query : ");

            Dimension LQDimension = new Dimension(80, 30);
            labelQuery.setPreferredSize(LQDimension);
            labelQuery.setMaximumSize(LQDimension);

        JTextField textFieldQuery = new JTextField();

            Dimension TFQDimension = new Dimension(800, 30);
            textFieldQuery.setPreferredSize(TFQDimension);
            textFieldQuery.setMaximumSize(TFQDimension);

        JButton buttonQuery = new JButton("run");
            buttonQuery.addActionListener(new runQuery(textFieldQuery, database));

            Dimension BQDimension = new Dimension(60, 30);
            buttonQuery.setPreferredSize(BQDimension);
            buttonQuery.setMaximumSize(BQDimension);

        JPanel queryPanel = new JPanel();
            queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.X_AXIS));
            queryPanel.add(labelQuery);
            queryPanel.add(textFieldQuery);
            queryPanel.add(buttonQuery);
        


        
        //setting panel utama
        JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

            mainPanel.add(Box.createVerticalStrut(20));
            mainPanel.add(connect);
            mainPanel.add(Box.createVerticalStrut(10));
            mainPanel.add(table);
            mainPanel.add(Box.createVerticalStrut(25));
            mainPanel.add(log);
            mainPanel.add(Box.createVerticalStrut(5));
            mainPanel.add(queryPanel);


        //membuat window
        Main frame = new Main("mySQL app");
            frame.add(mainPanel);
    }

    // constructor
    Main(String title){
        super(title);
        setSize(1000, 600);
        addWindowListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }


    // dikerjakan saat window ditutup
    public void windowClosing(WindowEvent e) {
        database.close();
    }

    // tidak dipakai, ignore
    public void windowClosed(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

    
}
