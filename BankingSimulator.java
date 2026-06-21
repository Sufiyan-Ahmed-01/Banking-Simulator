import java.io.*;

import javax.swing.*;
import java.awt.*;


//done
class MFrame extends JFrame {
    MFrame() {

        setSize(400, 600);
        // setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// screen 1 login register
class LoginRegister extends JPanel {
    LoginRegister(JPanel x) {
        setLayout(new GridBagLayout());
        add(x);
        

    }
}

class ButtonPanel extends JPanel {

    JButton Lbtn = new JButton("Login");
    JButton Rbtn = new JButton("Register");

    ButtonPanel(JPanel p, CardLayout c) {
        //setBackground(Color.white);
        setLayout(new GridLayout(5, 1, 0, 5));

        setPreferredSize(new Dimension(300, 250));


        JLabel text = new JLabel("Welcome !");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("Arial",Font.BOLD,30));
        add(text);

        JLabel empt1 = new JLabel("");
        add(empt1);

        


        Lbtn.setBackground(Color.decode("#62449D"));
        Lbtn.setForeground(Color.white);
        Lbtn.setFocusPainted(false);
        add(Lbtn);
        Lbtn.addActionListener(e -> {
            c.show(p, "LS");
        });

        Rbtn.setBackground(Color.decode("#62449D"));
        Rbtn.setForeground(Color.white);
        Rbtn.setFocusPainted(false);
        add(Rbtn);
        Rbtn.addActionListener(e -> {
            c.show(p,"RS");


        

        });

    }
}

public class BankingSimulator {
    static int index = -1;
    // ==========LOGIN INFO CLASS==============

    static class Login {

        String password;
        String username;
        double balance;
    };
    // ========================================

    // ===========SCREEN 2 LOGIN SCREEN========

    static class LoginScreen extends JPanel {
        LoginScreen(Login[] users, JPanel p, CardLayout c,DashboardScreen x) {
            setLayout(new GridBagLayout());
            JPanel content = new JPanel();
            content.setPreferredSize(new Dimension(300, 250));

            add(content);
            content.setLayout(new GridLayout(6, 1, 0, 5));

            JLabel us = new JLabel("username");

            JTextField TFusername = new JTextField();
            TFusername.setOpaque(true);
            TFusername.setBackground(Color.WHITE);

            JLabel ps = new JLabel("password");

            JTextField TFpassword = new JTextField();
            TFpassword.setBackground(Color.WHITE);
            TFpassword.setOpaque(true);

            JButton Lbtn = new JButton("Login");
            Lbtn.setBackground(Color.decode("#62449D"));
            Lbtn.setForeground(Color.white);
            Lbtn.setFocusPainted(false);
            Lbtn.setPreferredSize(new Dimension(100, 50));

            Lbtn.addActionListener(e -> {
                String user = TFusername.getText();
                String pass = TFpassword.getText();
                boolean check = login(users, user, pass);
                if (check) {
                    uchanger(users,x);
                    c.show(p, "DS");
                }
            });

            JButton back = new JButton("Back");
            back.setBackground(Color.decode("#62449D"));
            back.setForeground(Color.white);
            back.setFocusPainted(false);
            back.setPreferredSize(new Dimension(100, 50));

            back.addActionListener(e->{
                TFusername.setText("");
                TFpassword.setText("");
                c.show(p,"LR");
            });

            content.add(us);
            content.add(TFusername);
            content.add(ps);
            content.add(TFpassword);
            content.add(Lbtn);
            content.add(back);

        }
    }

    // ========================================

    // ========SCREEN 3 REGISTER===============

    static class RegisterScreen extends JPanel {

        RegisterScreen(Login[] users,JPanel p,CardLayout c) {
            setLayout(new GridBagLayout());
            JPanel content = new JPanel();
            content.setPreferredSize(new Dimension(300, 250));

            add(content);
            content.setLayout(new GridLayout(6, 1, 0, 5));

            JLabel us = new JLabel("username");

            JTextField TFusername = new JTextField();
            TFusername.setOpaque(true);
            TFusername.setBackground(Color.WHITE);

            JLabel ps = new JLabel("password");

            JTextField TFpassword = new JTextField();
            TFpassword.setBackground(Color.WHITE);
            TFpassword.setOpaque(true);

            JButton register = new JButton("Register");
            register.setBackground(Color.decode("#62449D"));
            register.setForeground(Color.white);
            register.setFocusPainted(false);
            register.setPreferredSize(new Dimension(100, 50));

            register.addActionListener(e -> {
                String user = TFusername.getText();
                String pass = TFpassword.getText();
                
                register(users,user,pass,p,c);
                
            });

            JButton back = new JButton("Back");
            back.setBackground(Color.decode("#62449D"));
            back.setForeground(Color.white);
            back.setFocusPainted(false);
            back.setPreferredSize(new Dimension(100, 50));

            back.addActionListener(e->{
                c.show(p,"LR");
            });

            content.add(us);
            content.add(TFusername);
            content.add(ps);
            content.add(TFpassword);
            content.add(register);
            content.add(back);

        }
    }
    // ========================================





    // ===========SCREEN 4 DASHBOARD===========

    static class DashboardScreen extends JPanel{
        JLabel text3 = new JLabel("");

        DashboardScreen(Login[] users,CardLayout c,JPanel p,CheckBalance b){
            //setLayout(new FlowLayout(0,0,0));
            setLayout(new BorderLayout());

            JPanel upper = new JPanel();
            //upper.setBackground(Color.gray);
            upper.setPreferredSize(new Dimension(350,200));
            add(upper,BorderLayout.NORTH);

            JPanel middle = new JPanel();
           //middle.setBackground(Color.PINK);
            //middle.setPreferredSize(new Dimension(300,200));
            add(middle,BorderLayout.CENTER);

            JPanel lower = new JPanel();
            //lower.setBackground(Color.gray);
            lower.setPreferredSize(new Dimension(350,100));
            add(lower,BorderLayout.SOUTH);

            JPanel right = new JPanel();
            //right.setBackground(Color.red);
            right.setPreferredSize(new Dimension(50,0));
            add(right,BorderLayout.EAST);


            JPanel left = new JPanel();
            //left.setBackground(Color.yellow);
            left.setPreferredSize(new Dimension(50,0));
            add(left,BorderLayout.WEST);



            //upper panel work

            upper.setLayout(new FlowLayout(FlowLayout.CENTER,0,3));

            JLabel text1 = new JLabel("");
            text1.setFont(new Font("Arial",Font.BOLD,30));
            text1.setPreferredSize(new Dimension(400,30));
            //text.setHorizontalAlignment(SwingConstants.CENTER);

            JLabel texte = new JLabel("");
            texte.setFont(new Font("Arial",Font.BOLD,30));
            texte.setPreferredSize(new Dimension(400,30));

            JLabel text2 = new JLabel("Welcome !");
            text2.setFont(new Font("Arial",Font.BOLD,30));
            text2.setPreferredSize(new Dimension(400,30));
            text2.setHorizontalAlignment(SwingConstants.CENTER);
            
            
            
            
            
            
            text3.setFont(new Font("Arial",Font.BOLD,20));

            



            upper.add(text1);
            upper.add(texte);
            upper.add(text2);
            upper.add(text3);
            



            //middle panel work 
            middle.setLayout(new GridLayout(5,1,0,5));


            JButton cb = new JButton("Check Balance");
            
            cb.setBackground(Color.decode("#62449D"));
            cb.setForeground(Color.white);
            cb.setFocusPainted(false);
            cb.addActionListener(e->{
                String bal = String.valueOf(users[index].balance);
                b.bl.setText(bal);
                c.show(p,"CB");
            });

            JButton dp = new JButton("Deposit");
            
            dp.setBackground(Color.decode("#62449D"));
            dp.setForeground(Color.white);
            dp.setFocusPainted(false);
            dp.addActionListener(e->{
                c.show(p,"DPS");
            });


            JButton wd = new JButton("Withdrawal");
            
            wd.setBackground(Color.decode("#62449D"));
            wd.setForeground(Color.white);
            wd.setFocusPainted(false);
            wd.addActionListener(e->{
                c.show(p,"WPL");
            });


            JButton tf = new JButton("Transfer");
            
            tf.setBackground(Color.decode("#62449D"));
            tf.setForeground(Color.white);
            tf.setFocusPainted(false);
            tf.addActionListener(e->{
                c.show(p,"TS");
            });


            JButton lg = new JButton("Logout");
            
            lg.setBackground(Color.decode("#62449D"));
            lg.setForeground(Color.white);
            lg.setFocusPainted(false);
            lg.addActionListener(e->{
                SaveData(users);
                index=-1;
                c.show(p,"LR");

            });




            middle.add(cb);
            middle.add(dp);
            middle.add(wd);
            middle.add(tf);
            middle.add(lg);
            

        }


    }



    // ========================================



// =========SCREEN 5 CHECK BALANCE=========

static class CheckBalance extends JPanel{

    JLabel bl = new JLabel("1000");
    CheckBalance(Login[] users ,CardLayout c,JPanel p){

        setLayout(new GridBagLayout());

        JPanel content = new JPanel();
        //content.setBackground(Color.cyan);
        content.setPreferredSize(new Dimension(200,150));
        content.setLayout(new GridLayout(3,1));
        add(content);

        JLabel text1 = new JLabel("Your Balance :");
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setFont(new Font("Arial",Font.BOLD,20));

        //JLabel bl = new JLabel("10000000");
        bl.setHorizontalAlignment(SwingConstants.CENTER);
        bl.setFont(new Font("Arial",Font.BOLD,30));
        bl.setForeground(Color.decode("#32f30b"));

        JButton back = new JButton("Back");
            back.setBackground(Color.decode("#62449D"));
            back.setForeground(Color.white);
            back.setFocusPainted(false);
            //back.setPreferredSize(new Dimension(100, 50));

            back.addActionListener(e->{
                c.show(p,"DS");
            });

        content.add(text1);
        content.add(bl);
        content.add(back);
        
    }

}



// ========================================


// ============SCREEN 6 DEPOSIT============

static class DepositScreen extends JPanel{

    DepositScreen(Login[] users,CardLayout c , JPanel p){


        setLayout(new GridBagLayout());

        JPanel content = new JPanel();
        //content.setBackground(Color.cyan);
        content.setPreferredSize(new Dimension(200,150));
        content.setLayout(new GridLayout(4,1,0,3));
        add(content);

        JLabel text1 = new JLabel("Enter amount :");
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setFont(new Font("Arial",Font.BOLD,20));

        JTextField bl = new JTextField();
        bl.setHorizontalAlignment(SwingConstants.CENTER);
        bl.setOpaque(true);
        bl.setFont(new Font("Arial",Font.BOLD,30));
        bl.setForeground(Color.decode("#32f30b"));

        JButton dp = new JButton("Deposit");
            dp.setBackground(Color.decode("#62449D"));
            dp.setForeground(Color.white);
            dp.setFocusPainted(false);
            //dp.setPreferredSize(new Dimension(100, 50));

            dp.addActionListener(e->{
                try{
                double xbal = Double.parseDouble(bl.getText());
               Deposit(users,xbal);
               bl.setText("");
                }
                catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                null,
                "Enter a valid number!",
                "Error",
                JOptionPane.ERROR_MESSAGE
                );
               bl.setText("");
                }
            });

        JButton back = new JButton("Back");
            back.setBackground(Color.decode("#62449D"));
            back.setForeground(Color.white);
            back.setFocusPainted(false);
            //back.setPreferredSize(new Dimension(100, 50));

            back.addActionListener(e->{
                c.show(p,"DS");
            });

            content.add(text1);
            content.add(bl);
            content.add(dp);
            content.add(back);
        
        
        
    }
    
}

// ========================================





// =======SCREEN 7 WITHDRAWAL SCREEN=======

static class WithdrawalScreen extends JPanel{

    WithdrawalScreen(Login[] users,CardLayout c , JPanel p){


        setLayout(new GridBagLayout());

        JPanel content = new JPanel();
        //content.setBackground(Color.cyan);
        content.setPreferredSize(new Dimension(200,150));
        content.setLayout(new GridLayout(4,1,0,3));
        add(content);

        JLabel text1 = new JLabel("Enter amount :");
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setFont(new Font("Arial",Font.BOLD,20));

        JTextField bl = new JTextField();
        bl.setHorizontalAlignment(SwingConstants.CENTER);
        bl.setOpaque(true);
        bl.setFont(new Font("Arial",Font.BOLD,30));
        bl.setForeground(Color.decode("#f30f0b"));

        JButton dp = new JButton("Withdrawal");
            dp.setBackground(Color.decode("#62449D"));
            dp.setForeground(Color.white);
            dp.setFocusPainted(false);
            //dp.setPreferredSize(new Dimension(100, 50));

            dp.addActionListener(e->{
                try{
                double xbal = Double.parseDouble(bl.getText());
               Withdrawal(users,xbal);
               bl.setText("");
                }
                 catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                null,
                "Enter a valid number!",
                 "Error",
                JOptionPane.ERROR_MESSAGE
                );
                bl.setText("");
                }
            });

        JButton back = new JButton("Back");
            back.setBackground(Color.decode("#62449D"));
            back.setForeground(Color.white);
            back.setFocusPainted(false);
            //back.setPreferredSize(new Dimension(100, 50));

            back.addActionListener(e->{
                bl.setText("");
                c.show(p,"DS");
            });

            content.add(text1);
            content.add(bl);
            content.add(dp);
            content.add(back);
        
        
        
    }
    
}


// ========================================




// ========SCREEN 8 TRANSFER SCREEN========

static class TransferScreen extends JPanel{



    TransferScreen(Login[] users,CardLayout c , JPanel p){


        setLayout(new GridBagLayout());

        JPanel content = new JPanel();
        //content.setBackground(Color.cyan);
        content.setPreferredSize(new Dimension(300,250));
        content.setLayout(new GridLayout(6,1,0,3));
        add(content);

        JLabel text0 = new JLabel("Enter reciever's username");
        //text0.setHorizontalAlignment(SwingConstants.CENTER);
        //text0.setFont(new Font("Arial",Font.BOLD,20));

        JTextField us = new JTextField();
        us.setHorizontalAlignment(SwingConstants.CENTER);
        us.setOpaque(true);
        //us.setFont(new Font("Arial",Font.BOLD,30));

        JLabel text1 = new JLabel("Enter amount :");
        //text1.setHorizontalAlignment(SwingConstants.CENTER);
        //text1.setFont(new Font("Arial",Font.BOLD,20));

        JTextField bl = new JTextField();
        bl.setHorizontalAlignment(SwingConstants.CENTER);
        bl.setOpaque(true);
        //bl.setFont(new Font("Arial",Font.BOLD,30));
        //bl.setForeground(Color.decode("#32f30b"));

        JButton dp = new JButton("Transfer");
            dp.setBackground(Color.decode("#62449D"));
            dp.setForeground(Color.white);
            dp.setFocusPainted(false);
            //dp.setPreferredSize(new Dimension(100, 50));

            dp.addActionListener(e->{
                try{
                double xbal = Double.parseDouble(bl.getText());

               Transfer(users,us.getText(),xbal);
               bl.setText("");
               us.setText("");
                }
                 catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                null,
                "Enter a valid number!",
                "Error",
                JOptionPane.ERROR_MESSAGE
                );
                bl.setText("");
                us.setText("");
}
            });

        JButton back = new JButton("Back");
            back.setBackground(Color.decode("#62449D"));
            back.setForeground(Color.white);
            back.setFocusPainted(false);
            

            back.addActionListener(e->{
                bl.setText("");
                us.setText("");
                c.show(p,"DS");
            });

            content.add(text0);
            content.add(us);
            content.add(text1);
            content.add(bl);
            content.add(dp);
            content.add(back);
        
        
        
    }
    
    
    
}


// ========================================






// ============USERNAME FIXER==============

static void uchanger(Login[]users,DashboardScreen h){
    h.text3.setText(users[index].username);
}
// ========================================


   




    // ==========LOGIN FUNCTION================

    static boolean login(Login[] users, String xusername, String xpassword) {
        boolean status = false;
        boolean found = false;

        // user name is taken now we will find at which index this user name is present
        // int index=-1;

        for (int i = 0; i < users.length; i++) {

            if (users[i] != null && xusername.equals(users[i].username)) {
                index = i;

                found = true;

                break;
            }

        }
        if (!found) {
            JOptionPane.showMessageDialog(
    null,
       "Username not found!",
         "Login Failed",
                JOptionPane.ERROR_MESSAGE
);

        }
        if (found) {
            

            if (xpassword.equals(users[index].password)) {
                ImageIcon icon = new ImageIcon("tick.png");

JOptionPane.showMessageDialog(
    null,
    "Login Successful!",
    "Success",
    JOptionPane.PLAIN_MESSAGE,
    icon
);
                status = true;
            } else {
                JOptionPane.showMessageDialog(
            null,
            "Wrong password!",
            "Login Failed",
            JOptionPane.ERROR_MESSAGE
        );
            }
        }

        return status;
    }

    // ========================================

    // ==========REGISTER FUNCTION============

    static boolean register(Login[] users, String xusername,String xpassword,JPanel p,CardLayout c) {

        if(xusername.trim().isEmpty() || xpassword.trim().isEmpty()){
        JOptionPane.showMessageDialog(
        null,
        "Username and password cannot be empty!",
        "Register Failed",
        JOptionPane.ERROR_MESSAGE
    );
    return false;
}
        
        int FreeIndex = -1;

for(int i = 0; i < users.length; i++){
    if(users[i] == null){
        FreeIndex = i;
        break;
    }
}

if (FreeIndex == -1) {
    JOptionPane.showMessageDialog(
        null,
        "User limit reached!",
        "Register Failed",
        JOptionPane.ERROR_MESSAGE
    );
    return false;
}


        for (int i = 0; i < users.length; i++) {

            if (users[i] != null && xusername.equals(users[i].username)) {

                 JOptionPane.showMessageDialog(
    null,
       "Username already exists !",
         "Login Failed",
                JOptionPane.ERROR_MESSAGE
);
                return false;

            }
        }

        users[FreeIndex] = new Login();

        users[FreeIndex].username = xusername;
        
        users[FreeIndex].password = xpassword;


        ImageIcon icon = new ImageIcon("tick.png");
        JOptionPane.showMessageDialog(
    null,
    "Registered Successfully !",
    "Success",
    JOptionPane.PLAIN_MESSAGE,
    icon
);

        users[FreeIndex].balance = 0;

        SaveData(users);
        c.show(p,"LR");
        return true;
    }
    // =======================================

    

    

    // ===========DEPOSIT=====================
    static void Deposit(Login[] users, double balance) {

        
        
        
        if (balance > 0) {
            users[index].balance += balance;

            ImageIcon icon = new ImageIcon("tick.png");
            JOptionPane.showMessageDialog(
            null,
            "Deposit Successful !",
            "Success",
            JOptionPane.PLAIN_MESSAGE,
            icon
            );

        } else {
            JOptionPane.showMessageDialog(
            null,
            "Enter a valid amount !",
            "Login Failed",
                JOptionPane.ERROR_MESSAGE
            );
        }
        SaveData(users);
    }
    // =======================================

    // ============WITHDRAWAL=================
    static void Withdrawal(Login[] users,double balance) {
        
        
        if (balance <= 0) {
            JOptionPane.showMessageDialog(
            null,
            "Enter a valid amount !",
            "Login Failed",
                JOptionPane.ERROR_MESSAGE
            );


        } else if (users[index].balance >= balance) {
            users[index].balance -= balance;
            ImageIcon icon = new ImageIcon("tick.png");
            JOptionPane.showMessageDialog(
            null,
            "Withdrawal Successful !",
            "Success",
            JOptionPane.PLAIN_MESSAGE,
            icon
            );
        } else {
            JOptionPane.showMessageDialog(
            null,
            "Not sufficient amount !",
            "Login Failed",
                JOptionPane.ERROR_MESSAGE
            );
        }

        
        SaveData(users);
    }
    // =======================================

    // ===========LOAD DATA===================
    static int LoadData(Login[] users) {
        int i = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("USERS.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                users[i] = new Login();
                users[i].username = data[0];
                users[i].password = data[1];
                users[i].balance = Double.parseDouble(data[2]);
                i++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("No data");
        }
        return i;
    }
    // =======================================

    // ============SAVA DATA==================
    static void SaveData(Login[] users) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("USERS.txt"));

            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    bw.write(
                            users[i].username + "," +
                                    users[i].password + "," +
                                    users[i].balance + "\n");
                }

            }
            bw.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // =======================================

    // ============Transfer Money=============

    static void Transfer(Login[] users,String xusername,double xbalance) {

        
        int f = 0;
        
        boolean found = false;
        for (; f < users.length; f++) {
            if ((users[f] != null) && xusername.equals(users[f].username)) {
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(
            null,
            "User not found !",
            "fialed",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        if (f == index) {
            JOptionPane.showMessageDialog(
            null,
            "Self transfer not allowed !",
            "Failed",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        
        if ((found) && (xbalance > 0) && (xbalance <= users[index].balance)) {
            users[f].balance += xbalance;
            users[index].balance -= xbalance;

            ImageIcon icon = new ImageIcon("tick.png");
            JOptionPane.showMessageDialog(
            null,
            "Transfer Successful !",
            "Success",
            JOptionPane.PLAIN_MESSAGE,
            icon
            );

            
            SaveData(users);
        }

        else {
            JOptionPane.showMessageDialog(
            null,
            "Transfer failed !",
            "Failed",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =======================================

    // =======================================
    // ==============MAIN FUNCTION============
    // =======================================
    public static void main(String args[]) {

        // ==========USER ARRAY====================

        Login[] user = new Login[50];

        LoadData(user);
        // ========================================

        // ============USER INTERFACE==============
        // ========================================
        // ========================================
        // main frame
        MFrame f = new MFrame();
        f.setLocationRelativeTo(null);

        CardLayout cl = new CardLayout();
        // main panel
        JPanel mpanel = new JPanel();
        mpanel.setLayout(cl);
        f.add(mpanel);




        // =========SCREEN 8 TRANSFER SCREEN=======
        TransferScreen TS = new TransferScreen(user, cl, mpanel);
        mpanel.add(TS,"TS");
        // ========================================
        
        
        

        // =========SCREEN 7 WITHDRAWAL SCREEN=====

        WithdrawalScreen WPL = new WithdrawalScreen(user, cl, mpanel);
        mpanel.add(WPL,"WPL");
        
        // ========================================
        

        // ============SCREEN 6 DEPOSTI SCREEN=====
        DepositScreen DPS = new DepositScreen(user, cl, mpanel);
        mpanel.add(DPS,"DPS");
        // ========================================

        // =============SCREEN 5 CHECK BALANCE=====
        CheckBalance CB = new CheckBalance(user, cl,mpanel);
        mpanel.add(CB,"CB");

        // ========================================
        

         // ============SCREEN 4 DASHBOARD==========
         DashboardScreen DS = new DashboardScreen(user,cl,mpanel,CB);
         mpanel.add(DS,"DS");
         // ========================================

        // ==========SCREEN 3 REGISTER=============
        RegisterScreen RS = new RegisterScreen(user,mpanel,cl);
        mpanel.add(RS,"RS");
        // ========================================

        // ============SCREEN 2 LOGIN==============

        LoginScreen LS = new LoginScreen(user, mpanel, cl,DS);
        mpanel.add(LS,"LS");
        // ========================================

        // ===========SCREEEN 1 LOGIN/REGISTER=====
        // ========================================

        ButtonPanel bpanel = new ButtonPanel(mpanel, cl);

        LoginRegister LR = new LoginRegister(bpanel);
        mpanel.add(LR, "LR");
        
        cl.show(mpanel, "LR");
        // ========================================

        

        

       


        f.setVisible(true);

        
    }
}
