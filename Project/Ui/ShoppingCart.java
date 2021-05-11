package Project.Ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import Project.Entities.Product;
import Project.Entities.ProductInOrder;
import java.awt.event.*; 
import java.awt.BorderLayout;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class ShoppingCart extends JFrame implements ActionListener{

    private JPanel contentPanel, viewportPanel;
    private JScrollPane myScrollPane, scrollPane;
    private JPanel southPanel;
    private JButton procced, removeall;
    JList<ProductInOrderPanel> list;



    public ShoppingCart(){

        setVisible(false);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        setTitle("Shopping Cart");

        contentPanel = new JPanel();
        southPanel = new JPanel();

        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        contentPanel.setLayout(new BorderLayout(0,0));
        setContentPane(contentPanel);

        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        contentPanel.add(southPanel, BorderLayout.SOUTH);

        procced = new JButton("Procced Order");
        removeall = new JButton("Remove All");
        
        procced.addActionListener(this);
        removeall.addActionListener(this);

        southPanel.add(procced);
        southPanel.add(removeall);
        

        list = new JList<>();
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        
        myScrollPane = new JScrollPane(list);
        myScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentPanel.add(myScrollPane, BorderLayout.CENTER);
        
        //viewportPanel = new JPanel();
        //myScrollPane.setViewportView(viewportPanel);
        
        myScrollPane.setViewportView(list);

       

    }
    //ADD TO SHOPPING CART PANEL

    public void addProductToShoppingCart(Product productPanel){
        ProductInOrder productinorder = new ProductInOrder(productPanel);
        ProductInOrderPanel productinorderpanel = new ProductInOrderPanel(productinorder);
        
        //viewportPanel.revalidate();
        //myScrollPane.setViewportView(productinorderpanel);
        //productinorderpanel.setVisible(true);
        list.add(productinorderpanel);
        myScrollPane.setViewportView(list);
        myScrollPane.revalidate();
        
    }

    public void removeProductFromShoppingCart(ProductInOrderPanel productPanel){
        //myScrollPane.remove(productPanel);
        //myScrollPane.setViewportView(viewportPanel);
        //myScrollPane.revalidate();
        list.remove(productPanel);
        myScrollPane.setViewportView(list);
        list.revalidate();

    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == removeall){
            System.out.println("REMOVE ALL PRESSED");
            myScrollPane.removeAll();
            myScrollPane.repaint();
            myScrollPane.revalidate();
        }
        if(e.getSource() == procced){
            System.out.println("ORDER COMPLETED!!!");
        }
    }



    
}