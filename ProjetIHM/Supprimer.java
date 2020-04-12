import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Supprimer extends JFrame implements ActionListener {
    private JPanel monPanel;
    private AppMenagerie appMenagerie;
    private JButton retour, supprimer;
    private JScrollPane jsp;
    private JLabel label, lblNum;
    private JTextField num;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Supprimer(AppMenagerie appMenagerie, ArrayList<Animal> lesAnimaux) {
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

        if (!lesAnimaux.isEmpty()) {
            for (int i = 0; i < lesAnimaux.size(); i++) {
                label = new JLabel();
                label.setText(i + " - " + lesAnimaux.get(i).toString());
                label.setBounds(325, 100 + i * 20, 200, 40);
                // jsp = new JScrollPane(label, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                // JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                // jsp.setBounds(100, 100, 150, 150);
                // jsp.setVisible(true);
                monPanel.add(label);
            }
            lblNum = new JLabel("Numéro de l'animal à supprimer");
            lblNum.setFont(new Font("Arial", Font.BOLD, 14));
            lblNum.setBounds(300, 50, 250, 40);
            num = new JTextField();
            num.setBounds(300, 200, 200, 40);

            supprimer = new JButton("supprimer");
            supprimer.setBounds(300, 250, 200, 40);
            supprimer.setBackground(new Color(59, 89, 182));
            supprimer.setForeground(Color.WHITE);
            supprimer.setFocusPainted(false);
            supprimer.setFont(new Font("Arial", Font.BOLD, 12));
            supprimer.addActionListener(this);

            monPanel.add(lblNum);
            monPanel.add(num);
            monPanel.add(supprimer);
        } else {
            label = new JLabel();
            label.setText("La ménagerie ne contient aucun animaux...");
            label.setBounds(300, 180, 350, 40);
            // monPanel.add(label);
            monPanel.add(label);
        }
        // monPanel.add(jsp);

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
        } else if (source == supprimer) {
            int numAnimal = Integer.parseInt(num.getText());
            this.appMenagerie.supprimerAnimal(numAnimal);
        }
    }
}