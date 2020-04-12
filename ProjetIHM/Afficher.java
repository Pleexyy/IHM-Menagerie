import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Afficher extends JFrame implements ActionListener {
    private JPanel monPanel;
    private AppMenagerie appMenagerie;
    private JButton retour;
    private JScrollPane jsp;
    private JLabel label;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Afficher(AppMenagerie appMenagerie, ArrayList<Animal> lesAnimaux) {
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

        if (!lesAnimaux.isEmpty()) {
            for (int i = 0; i < lesAnimaux.size(); i++) {
                label = new JLabel();
                label.setText(i + " - " + lesAnimaux.get(i).toString());
                label.setBounds(100, 100 + i * 20, 200, 40);
                // jsp = new JScrollPane(label, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                //         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                // jsp.setBounds(100, 100, 150, 150);
                // jsp.setVisible(true);
                monPanel.add(label);
            }
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
        if (e.getSource() == retour) {
            this.appMenagerie.retour();
        }
    }
}