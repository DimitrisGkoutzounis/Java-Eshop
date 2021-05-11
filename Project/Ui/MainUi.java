package Project.Ui;

import javax.swing.JFrame;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import Project.EshopData;
import Project.Entities.*;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;







@SuppressWarnings("serial")
public class MainUi extends JFrame implements ActionListener{
    
    public static ShoppingCart cart;
    private JPanel contentPane, productPanel, buttonPanel;
    private JLabel  categories;
    private JRadioButton smartPhoneBtn, laptopsBtn, tabletsBtn;
    private JButton shoppingCartBtn;
    //product buttons
    EshopData productData;


    public MainUi(ShoppingCart cart){

        setVisible(false);
        setBounds(100, 100, 600, 400);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Eshop");
        this.cart = cart;
        this.cart.setVisible(false);

		contentPane = new JPanel();             //MAIN PANEL
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		buttonPanel = new JPanel();      //BUTTON PANEL
		buttonPanel.setBounds(12, 0, 163, 358);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		

        //BUTTON PANEL BUTTONS AND LABELS
        ButtonGroup group = new ButtonGroup();
        categories = new JLabel("Categories");
        smartPhoneBtn = new JRadioButton("Smart Phones");
        laptopsBtn = new JRadioButton("Laptops");
        tabletsBtn = new JRadioButton("Tablets");
        shoppingCartBtn = new JButton("Shopping Cart");
        group.add(smartPhoneBtn);
        group.add(laptopsBtn);
        group.add(tabletsBtn);
        shoppingCartBtn.addActionListener(this);
        smartPhoneBtn.addActionListener(this);
        laptopsBtn.addActionListener(this);
        tabletsBtn.addActionListener(this);
        //BOUNDS FOR BUTTON PANEL
        categories.setBounds(12, 49, 117, 30);
        smartPhoneBtn.setBounds(0, 110, 129, 23);
        laptopsBtn.setBounds(0, 150, 129, 23);
        tabletsBtn.setBounds(0, 190, 129, 23);
        shoppingCartBtn.setBounds(0, 252, 151, 30);


        //ADDING TO BUTTON PANEL
        buttonPanel.add(categories);
        buttonPanel.add(smartPhoneBtn);
        buttonPanel.add(laptopsBtn);
        buttonPanel.add(tabletsBtn);
        buttonPanel.add(shoppingCartBtn);
        
        //CREATING PRODUCT PANEL
        productPanel = new JPanel();
        productPanel.setBounds(180, 12, 408, 346);
        contentPane.add(productPanel);

        productPanel.setLayout(new GridLayout(3, 3,40,30));
       

        

    }

    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == shoppingCartBtn){
            changeShoppingCartVisibility(true);
        }
        if(e.getSource() == smartPhoneBtn){
            System.out.println("Smartphone Button Pressed");
            generateViewForSmartPhones();
            revalidate();
        }
        if(e.getSource() == laptopsBtn){
            System.out.println("Laptop Button Pressed");
            generateViewForLaptops();
            revalidate();
        }
        if(e.getSource() == tabletsBtn){
            System.out.println("Tabet Button Pressed");
            generateViewForTablets();
            revalidate();
        }
    }
    public void generateViewWithProducts(ArrayList<Product>products){
        
        JPanel productButton;
        GridBagLayout gridBagLayout;
        JLabel titleLabel, priceLabel;
        GridBagConstraints grdbconstrainTitle, gridconstrainPrice;

        for(Product p: products){

            //PRODUCT BUTTON GENERATOR 
            productButton = new JPanel();
            gridBagLayout = new GridBagLayout();
            productButton.setBorder(new EmptyBorder(10,10,10,10));
            gridBagLayout.columnWidths = new int[]{30,30,0,0};
            productButton.setLayout(gridBagLayout);

            //TITLE LABEL
            titleLabel = new JLabel(p.getTitle());
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            grdbconstrainTitle = new GridBagConstraints();
            grdbconstrainTitle.insets = new Insets(0,0,5,0);
            grdbconstrainTitle.gridx = 2;
            grdbconstrainTitle.gridy = 5;
            productButton.add(titleLabel, grdbconstrainTitle);

            //PRICE LABEL
            priceLabel = new JLabel(p.getPrice()+"");
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            gridconstrainPrice = new GridBagConstraints();
            gridconstrainPrice.insets = new Insets(0,0,5,0);
            gridconstrainPrice.gridx = 2;
            gridconstrainPrice.gridy = 7;
            productButton.add(priceLabel,gridconstrainPrice);

            //ADD MOUSELISTENER
            productButton.addMouseListener(new MouseInputListener(){
            
                @Override
                public void mouseMoved(MouseEvent arg0) {
                    
                }
            
                @Override
                public void mouseDragged(MouseEvent arg0) {
                    
                    
                }
            
                @Override
                public void mouseReleased(MouseEvent arg0) {
                    
                    
                }
            
                @Override
                public void mousePressed(MouseEvent arg0) {
                    
                    
                }
            
                @Override
                public void mouseExited(MouseEvent arg0) {
                    
                    
                }
            
                @Override
                public void mouseEntered(MouseEvent arg0) {
                   
                    
                }
            
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    System.out.println(p.getTitle() + p.getPrice() + p.getDescription());
                    int n = JOptionPane.showConfirmDialog(null, "Add product to shopping cart?", "Add product", JOptionPane.YES_NO_CANCEL_OPTION);
                    if(n==JOptionPane.YES_OPTION){
                        cart.addProductToShoppingCart(p);
                        System.out.println("ADDED: " + p.getTitle());
                        cart.revalidate();
                    }
                }
            });


            //ADD IT TO GRID PANEL
            productPanel.add(productButton);

        }
        for(Product m: EshopData.getProducts()){
            System.out.println("TITLE:" + m.getTitle() +"  " + m.getCategory());
        }

    }

    public void generateViewForSmartPhones(){
        
        ArrayList<Product> smartphones = new ArrayList<Product>();

        for(Product p:EshopData.getProducts()){

            //TEST CODE
  
            if(p.getCategory().equalsIgnoreCase("Smartphone")){
                smartphones.add(p);
                System.out.println("ADDED TO ARRAYLIST[SMARTPHONES] :" + p.getCategory());
            }
            if(p.getCategory().equalsIgnoreCase("Tablet")){
                smartphones.remove(p);
            }
            if(p.getCategory().equalsIgnoreCase("Laptop")){
                smartphones.remove(p);
            }
        }

        panelRemover(productPanel);
        generateViewWithProducts(smartphones);
        revalidate();

    }

    public void generateViewForLaptops(){
        ArrayList<Product> laptops = new ArrayList<Product>();


        for(Product p:EshopData.getProducts()){

            if(p.getCategory().equalsIgnoreCase("Laptop")){
                laptops.add(p);
                System.out.println("ADDED TO ARRAYLIST[LAPTOPS] :" + p.getCategory());
            }
            if(p.getCategory().equalsIgnoreCase("Smartphones")){
                laptops.remove(p);
            }
            if(p.getCategory().equalsIgnoreCase("Tablet")){
                laptops.remove(p);
            }
        }
        panelRemover(productPanel);
        generateViewWithProducts(laptops);
        revalidate();
    }

    public void generateViewForTablets(){
        ArrayList<Product> tablets = new ArrayList<Product>();
        //fileReader();
        for(Product p: EshopData.getProducts()){
            if(p.getCategory().equalsIgnoreCase("Tablet")){
                tablets.add(p);
                System.out.println("ADDEDTO ARRAYLIST[TABLETS] : " + p.getCategory());
            }
            if(p.getCategory().equalsIgnoreCase("Smartphones")){
                tablets.remove(p);

            }
            if(p.getCategory().equalsIgnoreCase("Laptop")){
                tablets.remove(p);
            }
        }
        panelRemover(productPanel);
        generateViewWithProducts(tablets);
        revalidate();
        
    }

    public void changeShoppingCartVisibility(boolean visibility){
        cart.setVisible(visibility);
    }

    public void fileReader(){

        FileInputStream inputStream;
        BufferedReader buffer;

        try{
            inputStream = new FileInputStream("Project/products.txt");
            buffer = new BufferedReader(new InputStreamReader(inputStream));

            int counter =1;

            while(true){
                String line = buffer.readLine();
                if(line == null) break;

                String[] stringArr = line.split("\t");
                createAndAddProductToArray(stringArr);
                counter++;
            }
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void createAndAddProductToArray(String[] string){
        String title, category, description;
        double price, formatedPrice;
        Product product;
        DecimalFormat formater = new DecimalFormat("#.##");


        title = string[0];
        description = string[1];
        category = string[2];
        price = Double.parseDouble(string[3]);
        //formatedPrice = Double.parseDouble(formater.format(price));
        
        product = new Product(price, title, category, description);
        EshopData.getProducts().add(product);

    }

    public void panelRemover(JPanel panel){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();

    }
   
    


}