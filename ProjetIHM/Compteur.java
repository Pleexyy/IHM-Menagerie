import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Compteur extends JFrame implements ActionListener {
    private JPanel monPanel;
    private AppMenagerie appMenagerie;
    private JButton retour;
    private JLabel label;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Compteur(AppMenagerie appMenagerie, ArrayList<Animal> lesAnimaux) {
        this.appMenagerie = appMenagerie;
        monPanel = new JPanel();
        monPanel.setLayout(null);
        monPanel.setBackground(Color.white);

        retour = new JButton("retour");
        retour.setBackground(new Color(59, 89, 182));
        retour.setForeground(Color.WHITE);
        retour.setFocusPainted(false);
        retour.setFont(new Font("Arial", Font.BOLD, 12));
        retour.setBounds(10, 10, 200, 40);
        retour.addActionListener(this);

        label = new JLabel();
        label.setBounds(290, 180, 350, 40);

        if (lesAnimaux.size() == 1) {
            label.setText("La ménagerie accueille actuellement " + lesAnimaux.size() + " animal");
        } else if (!lesAnimaux.isEmpty()) {
            label.setText(" La ménagerie accueille actuellement " + lesAnimaux.size() + " animaux");
        } else {
            label.setText("La ménagerie ne contient aucun animal...");
        }
        monPanel.add(label);
        monPanel.add(retour);
    }

    public JPanel getJPanel() {
        return this.monPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == retour) {
            this.appMenagerie.retour();
        }
    }
}