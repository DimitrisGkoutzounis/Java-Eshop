package Project.Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Project.Entities.*;
import java.awt.event.*;  


@SuppressWarnings("serial")
public class ProductInOrderPanel extends JPanel implements ActionListener{

    
    private JLabel title, price, quantity, totalPrice;
    ProductInOrder product;
    private JButton remove, addBtn, subBtn;
    private JPanel mypanel;

    public ProductInOrderPanel(ProductInOrder product){

        setLayout(null);
        setSize(400,80);
        this.title = new JLabel(product.getProduct().getTitle());
        this.price = new JLabel(String.valueOf(product.getProduct().getPrice()));
        this.quantity = new JLabel(String.valueOf(product.getQuantity()));
        this.totalPrice = new JLabel(String.valueOf(product.getTotalPrice()));

        //UI CREATOR
        this.title.setBounds(12, 31, 42, 15);
        this.price.setBounds(53,31,42,15);
        this.quantity.setBounds(93,31,70,15);
        this.totalPrice.setBounds(159,31,82,15);
        addBtn = new JButton("+1");
        subBtn = new JButton("-1");
        remove = new JButton("Remove");


        this.addBtn.setBounds(248,31,34,15);
        this.addBtn.setFont(new Font("Dialog", Font.BOLD,12));
        this.subBtn.setBounds(290,31,34,15);
        this.subBtn.setFont(new Font("Dialog", Font.BOLD, 12));

        this.remove.setBounds(331,31,58,15);
        this.remove.setMargin(new Insets(0,0,0,0));
        this.addBtn.setMargin(new Insets(0,0,0,0));
        this.subBtn.setMargin(new Insets(0,0,0,0));

        remove.addActionListener(this);
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);

        add(title);
        add(price);
        add(quantity);
        add(totalPrice);
        add(addBtn);
        add(subBtn);
        add(remove);

    }
     
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addBtn){
            addButton();
        }
        if(e.getSource() == subBtn){
            subButton();
        }
        if(e.getSource() == remove){
            MainUi.cart.removeProductFromShoppingCart(ProductInOrderPanel.this);
            System.out.println("Remove Pressed");
        }
    }

    public void addButton(){
        product.setQuantity(+1);
        product.getTotalPrice();
    }

    public void subButton(){
        product.setQuantity(-1);
        product.getTotalPrice();
    }


}