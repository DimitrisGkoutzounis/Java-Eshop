package Project;

import javax.swing.JFrame;
import javax.swing.plaf.FontUIResource;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.*;

@SuppressWarnings("serial")
public class RegisterFrame extends JFrame implements ActionListener {

    //components
    private JLabel name;
    private JLabel email;
    private JLabel username;
    private JLabel password;
    private JLabel birthdate;
    private JLabel address;
    private JLabel telephone;
    private JCheckBox checkbox;
    private JButton submit;
    private JLabel title;
    JTextField tfname, tfemail, tfusername, tfbirthdate, tfaddress, tftelephone;
    JPasswordField passwordfield;

    public RegisterFrame(){
        setVisible(false);
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Register");
        title = new JLabel("Register Form: ");
        title.setForeground(Color.BLUE);
        title.setFont(new FontUIResource("Serif", Font.BOLD, 20));
        name = new JLabel("Name:");
        email = new JLabel("Email:");
        username = new JLabel("Username:");
        password = new JLabel("Password:");
        birthdate = new JLabel("Birthdate:");
        address = new JLabel("Address:");
        telephone = new JLabel("Telephone:");
        tfname = new JTextField();
        tfemail = new JTextField();
        tfusername = new JTextField();
        passwordfield = new JPasswordField();
        tfbirthdate = new JTextField();
        tfaddress = new JTextField();
        tftelephone = new JTextField();
        checkbox = new JCheckBox("Newsletter Updates");
        submit = new JButton("Submit");
        submit.addActionListener(this);
        checkbox.addActionListener(this);

        title.setBounds(100,30,400,30);
        name.setBounds(80,70,200,30);
        email.setBounds(80,100,200,30);
        username.setBounds(80,130,200,30);
        password.setBounds(80,160,200,30);
        birthdate.setBounds(80,190,200,30);
        address.setBounds(80,220,200,30);
        telephone.setBounds(80,250,200,30);

        tfname.setBounds(300,70,200,30);
        tfemail.setBounds(300,100,200,30);
        tfusername.setBounds(300,130,200,30);
        passwordfield.setBounds(300,160,200,30);
        tfbirthdate.setBounds(300,190,200,30);
        tfaddress.setBounds(300,220,200,30);
        tftelephone.setBounds(300,250,200,30);
        checkbox.setBounds(50, 350, 180, 20);
        submit.setBounds(250,350,100,30);

        add(title);
        add(name);
        add(tfname);
        add(email);
        add(tfemail);
        add(username);
        add(tfusername);
        add(password);
        add(passwordfield);
        add(birthdate);
        add(tfbirthdate);
        add(address);
        add(tfaddress);
        add(telephone);
        add(tftelephone);
        add(checkbox);
        add(submit);




    }
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == submit){
            String sname = tfname.getText();
            String semail = tfemail.getText();
            String susername = tfusername.getText();
            char[] passwordFieldArray = passwordfield.getPassword();
            String sbirthdate = tfbirthdate.getText();
            String saddress = tfaddress.getText();
            String stelephone = tftelephone.getText();
            boolean tick = checkbox.isSelected();

            String passowordString = String.valueOf(passwordFieldArray);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String formatedDateTime = now.format(dtf);

            Customer cust1 = new Customer(sname, semail, stelephone, susername, passowordString, formatedDateTime, saddress, sbirthdate, tick);
            EshopData.getUser().add(cust1);

            JOptionPane.showMessageDialog(submit, "Submission Worked!");
            JOptionPane.showMessageDialog(submit, cust1.getDateOfRegister());
            
        }
    }
}



