package src;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
class UserAccount extends JPanel {
	
	JButton withdraw, deposite, chk_blc, exit;
	JLabel lbl;
	
    public UserAccount() {
    	lbl=new JLabel("USER  ACCOUNT");
    	lbl.setFont(new Font("Times New Roman", Font.BOLD, 24));
        withdraw = new JButton("Withdraw");
        deposite = new JButton("Deposit");
        chk_blc = new JButton("Check Balance");
        exit=new JButton("Exit");

        add(lbl);
        add(withdraw);
        add(deposite);
        add(chk_blc);
        add(exit);
    }

    public JButton withdrawButton() {
        return withdraw;
    }

    public JButton depositeButton() {
        return deposite;
    }

    public JButton checkbalanceButton() {
        return chk_blc;
    }
    public JButton exitButton() {
    	return exit;
    }
}

@SuppressWarnings("serial")
public class ATMInterface extends JFrame implements ActionListener {

    JDialog dialog;
    JTextArea jarea;
	JButton sub, depo, clk;
    JTextField jtxt;
    int balance = 1000000, w_draw, depost;
    Scanner sc = new Scanner(System.in);

    public ATMInterface() {
        setTitle("ATM Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        UserAccount buttonPanel = new UserAccount();
        add(buttonPanel);

        buttonPanel.withdrawButton().addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });

        buttonPanel.depositeButton().addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                deposit();
            }
        });

        buttonPanel.checkbalanceButton().addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });
        
        buttonPanel.exitButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
    }

    /*------------------------------WithDraw Code-------------------------------------*/
    public void withdraw() {
        dialog = new JDialog(this, true);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter the money to Withdraw..");
        jtxt = new JTextField(20);
        sub = new JButton("Submit");
        jarea = new JTextArea("");
        jarea.setSize(300, 200);
        jarea.setLineWrap(true);
        sub.addActionListener(this);

        panel.add(label);
        panel.add(jtxt);
        panel.add(sub);
        panel.add(jarea);

        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setContentPane(panel);
        dialog.setSize(500, 400);
        dialog.setVisible(true);
    }

    /*------------------------------Deposite Code-------------------------------------*/
    public void deposit() {
        dialog = new JDialog(this, true);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter money to be deposited:");
        jtxt = new JTextField(20);
        depo = new JButton("Deposit");
        jarea = new JTextArea("");
        jarea.setSize(300, 200);
        jarea.setLineWrap(true);
        depo.addActionListener(this);

        panel.add(label);
        panel.add(jtxt);
        panel.add(depo);
        panel.add(jarea);

        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setContentPane(panel);
        dialog.setSize(500, 400);
        dialog.setVisible(true);
    }

    /*------------------------------CheckBalance Code-------------------------------------*/
    public void checkBalance() {
        dialog = new JDialog(this, true);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Check Your Account Balance Here:");
        clk = new JButton("Click");
        jarea = new JTextArea("");
        jarea.setSize(300, 200);
        jarea.setLineWrap(true);
        clk.addActionListener(this);

        panel.add(label);
        panel.add(clk);
        panel.add(jarea);

        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setContentPane(panel);
        dialog.setSize(500, 400);
        dialog.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == sub) 
            {
                w_draw = Integer.parseInt(jtxt.getText());
                if (balance >= w_draw) 
                {
                    balance = balance - w_draw;
                    jarea.setText("Please Collect Your Money");
                } 
                else 
                {
                    jarea.setText("Insufficient Amount");
                }
            } 
            else if (e.getSource() == depo) 
            {
                depost = Integer.parseInt(jtxt.getText());
                balance = balance + depost;
                jarea.setText("Your Money has been successfully deposited");
            }
            else if(e.getSource() == clk) 
            {
            	jarea.setText("Balance: "+balance);
            }
        } 
        catch (NumberFormatException ex) 
        {
            jarea.setText("Please enter the valid input");
        }
    }

    public static void main(String[] args) {    	
    	ATMInterface num=new ATMInterface();
    	num.setVisible(true);
    }
}