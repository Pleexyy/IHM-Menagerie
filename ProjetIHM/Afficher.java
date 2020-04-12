import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Afficher extends JFrame implements ActionListener {
    private JPanel monPanel;
    private AppMenagerie appMenagerie;
    private JButton retour;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Afficher(AppMenagerie appMenagerie, ArrayList<Animal> animaux) {
        this.appMenagerie = appMenagerie;
        monPanel = new JPanel();
        monPanel.setLayout(null);

        retour = new JButton("retour");
        retour.setBackground(new Color(59, 89, 182));
        retour.setForeground(Color.WHITE);
        retour.setFocusPainted(false);
        retour.setFont(new Font("Arial", Font.BOLD, 12));
        retour.setBounds(10, 10, 200, 40);
        retour.addActionListener(this);

        for(int i = 0; i < animaux.size(); i++) {
            JLabel label = new JLabel();
            label.setText(animaux.get(i).toString());
            label.setBounds(100, 100 + i * 20, 200, 40);
            monPanel.add(label);
        }
        monPanel.add(retour);
    }

    public JPanel getJPanel() {
        return this.monPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retour) {
            this.appMenagerie.retour();
        }
    }
}