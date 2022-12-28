import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// This program generates a harmless virus message window.
// Although this doesn't pose any threats - PLEASE DO NOT REPLICATE WITH MALICIOUS INTENTS.
// Thank you :)
// Made by Toasty
public class Main extends JFrame implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    private static final int WIDTH = 875;
    private static final int HEIGHT = 400;
    private JTextField usernameField;
    private JTextField passwordField;

    // This constructor instantiates the window immediately.
    private Main() {
        setTitle("Windows Defender - Security Warning");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getBackgroundColor();
        createContents();
        setVisible(true);
    }

    // This method creates the contents of the window.
    private void createContents() {
        JLabel warningLabel = new JLabel("YOUR DEVICE IS UNDER THREAT!");
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        usernameField = new JTextField(12);
        passwordField = new JTextField(12);
        JTextArea message = new JTextArea(0, 100);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        warningLabel.setFont(new Font("Monospaced", Font.BOLD, 22));
        // Utilization of text block.
        message.setText("""
                YOUR COMPUTER HAS DETECTED A VIRUS! SHUTTING DOWN THE COMPUTER WILL RESULT IN IT BEING LOCKED\s
                PERMANENTLY. PLEASE ENTER YOUR WINDOWS USERNAME AND PASSWORD TO UNLOCK THE COMPUTER.\s
                THEN GO TO SETTINGS > PRIVACY AND SECURITY > WINDOWS SECURITY > OPEN WINDOWS SECURITY.""".indent(3));
        message.setFont(new Font("Monospaced", Font.ITALIC, 14));
        message.setLayout(new FlowLayout());
        message.setEditable(false);
        message.setLineWrap(true);
        message.setBackground(Color.BLACK);
        message.setForeground(Color.white);
        usernameLabel.setFont(new Font("DialogInput", Font.BOLD, 12));
        usernameField.setBorder(border);
        passwordLabel.setFont(new Font("DialogInput", Font.BOLD, 12));
        passwordField.setBorder(border);
        add(warningLabel);
        add(message);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        usernameField.addActionListener(new Listener());
        passwordField.addActionListener(new Listener());

    }

    // This method changes the window's background color.
    public void getBackgroundColor() {
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.RED);
    }

    // Event-Handling
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Main responseFrame = new Main();
            Main enterInformationFrame = new Main();
            if (usernameField.getText().isEmpty() || usernameField.getText().length() <= 2 ||
                    usernameField.getText().length() >= 16 || passwordField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(enterInformationFrame, "Please enter valid and/or complete " +
                                "information.",
                        "Windows Defender", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println(usernameField.getText());
                System.out.println(passwordField.getText());
                JOptionPane.showMessageDialog(responseFrame, "Data Files Corrupted.",
                        "Error 375", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        Main helloFrame = new Main();
        JOptionPane.showMessageDialog(helloFrame, "A virus has been detected!",
                "Warning!", JOptionPane.WARNING_MESSAGE);
    }
}