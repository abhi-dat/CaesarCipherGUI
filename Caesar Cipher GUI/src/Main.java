import javax.swing.*;
public class Main {
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                char shifted = (char) ((character - base + shift) % 26 + base);
                result.append(shifted);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("Caesar Cipher");
        frame.setSize(315, 160);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel label = new JLabel("Enter the message: ");
        label.setBounds(0,0,250,25);

        JLabel label1 = new JLabel("Enter the number of shift:");
        label1.setBounds(0,30,250,25 );

        JTextField textField =new JTextField();
        textField.setBounds(115, 5,150, 20);

        JTextField textField1 = new JTextField();
        textField1.setBounds(150,35,150,20);

        JButton button  = new JButton("Encrypt");
        button.setBounds(105, 60,90,25);

        JLabel label2 = new JLabel("Encrypted Message:");
        label2.setBounds(0, 90, 250,25);

        JLabel label3 = new JLabel();
        label3.setBounds(125, 90,250,25);

        frame.add(label);
        frame.add(label1);
        frame.add(textField);
        frame.add(textField1);
        frame.add(button);
        frame.add((label2));
        frame.add(label3);

        button.addActionListener(e -> {
            String name = textField.getText();
            int shift = Integer.parseInt(textField1.getText());
            label3.setText(encrypt(name,shift));
        });
    }
}
