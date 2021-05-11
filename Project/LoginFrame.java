package Project;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Project.Ui.*;

import java.awt.event.*;
import java.util.Arrays;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JPanel myPanel = new JPanel();
    // LABELS
    private JLabel username;
    private JLabel password;
    private JTextField usernameText; // usernamefield
    private JPasswordField jpassword; // passwordfield
    private JButton submit;
    private JButton register;
    private JLabel labelStatus;

    public LoginFrame() {
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setTitle("Login");
        username = new JLabel("Username");
        password = new JLabel("Password");
        usernameText = new JTextField();
        jpassword = new JPasswordField();
        submit = new JButton("Login");
        register = new JButton("Register");
        labelStatus = new JLabel(" ");
        labelStatus.setHorizontalAlignment(SwingConstants.CENTER);
        labelStatus.setForeground(Color.RED);

        frame.add(username);
        frame.add(password);
        frame.add(usernameText);
        frame.add(jpassword);
        frame.add(submit);
        frame.add(register);
        frame.add(labelStatus);

        username.setBounds(33, 40, 88, 39);
        password.setBounds(33, 101, 88, 39);
        usernameText.setBounds(139, 45, 114, 29);
        jpassword.setBounds(139, 106, 114, 29);
        submit.setBounds(155, 172, 98, 29);
        register.setBounds(33, 172, 98, 29);
        labelStatus.setBounds(29, 147, 235, 15);

        submit.addActionListener(this);
        register.addActionListener(this);
    }
    

    public void actionPerformed(ActionEvent e) {

       
        if (e.getSource() == submit) {
                
            ArrayList<User> tempUser = new ArrayList<User>();
            tempUser = EshopData.getUser();
            boolean flag = false;
            Administrator admin = new Administrator("Dimitris", "th20039", "6949641960", "admin", "123", "nodate"); //test account
            tempUser.add(admin);
            int counter;

            
            for (counter=0; counter < EshopData.getUser().size(); counter++) {

                //check validity of the username


                if(Arrays.equals(tempUser.get(counter).getUsername().toCharArray(), usernameText.getText().toCharArray())){

                    //check the password

                    if(Arrays.equals(tempUser.get(counter).getPassword().toCharArray(),jpassword.getPassword())){
                        
                        flag = true;
                        System.out.println("Logged in!");
                    }
                   
                }
               
                
            }
            
            
            if(flag == true){
                //labelStatus.setText("Correct");
                ShoppingCart cart = new ShoppingCart();
                MainUi mymainui = new MainUi(cart);
                mymainui.fileReader();
                mymainui.generateViewWithProducts(EshopData.getProducts());
                mymainui.setVisible(true);
                frame.dispose();
            }
            else if(flag == false){
                labelStatus.setText("Invalid Password or Username");
            }
            
           
           
        } 
        else if (e.getSource() == register) {
            RegisterFrame registerFrame = new RegisterFrame();
            registerFrame.setVisible(true);
            
        }

    }
       
        

}