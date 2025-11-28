import java.awt.*;
import javax.swing.*;

public class JRadio {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
          
            JFrame frame = new JFrame("Test RadioButton");
            frame.setSize(400, 150);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            
            
            JLabel label = new JLabel("Voyez les changements de style", SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 16));
            
            
            JRadioButton radioNormal = new JRadioButton("Normal", true); 
            JRadioButton radioGras = new JRadioButton("Gras");
            JRadioButton radioItalique = new JRadioButton("Italique");
            JRadioButton radioGrasItalique = new JRadioButton("Gras/Italique");
            
        
            ButtonGroup groupe = new ButtonGroup();
            groupe.add(radioNormal);
            groupe.add(radioGras);
            groupe.add(radioItalique);
            groupe.add(radioGrasItalique);
            
        
            JPanel panelRadio = new JPanel(new FlowLayout());
            panelRadio.add(radioNormal);
            panelRadio.add(radioGras);
            panelRadio.add(radioItalique);
            panelRadio.add(radioGrasItalique);
            
           
            radioNormal.addActionListener(e -> {
                label.setFont(new Font("Arial", Font.PLAIN, 16));
            });
            
            radioGras.addActionListener(e -> {
                label.setFont(new Font("Arial", Font.BOLD, 16));
            });
            
            radioItalique.addActionListener(e -> {
                label.setFont(new Font("Arial", Font.ITALIC, 16));
            });
            
            radioGrasItalique.addActionListener(e -> {
                label.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 16));
            });
            
           
            frame.add(label, BorderLayout.NORTH);
            frame.add(panelRadio, BorderLayout.CENTER);
            
        
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
