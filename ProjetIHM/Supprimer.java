import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Supprimer extends JFrame implements ActionListener {
    private JPanel monPanel;
    private AppMenagerie appMenagerie;
    private JButton retour, supprimer;
    private JLabel label, lblNum;
    private JTextField num;
    private JList<String> list;
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
            lblNum = new JLabel("Numéro de l'animal à supprimer");
            lblNum.setFont(new Font("Arial", Font.BOLD, 14));
            num = new JTextField();

            List<String> labels = new ArrayList<>(lesAnimaux.size());
            for (int i = 0; i < lesAnimaux.size(); i++) {
                labels.add("Animal n°" + i + " : " + lesAnimaux.get(i).getNom().toString());
            }
            list = new JList<String>(labels.toArray(new String[labels.size()]));
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setFont(new Font("Arial", Font.ITALIC, 14));
            JScrollPane listScroller = new JScrollPane();
            listScroller.setViewportView(list);
            list.setLayoutOrientation(JList.VERTICAL);
            listScroller.setBounds(125, 100, 300, 300);
            list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            monPanel.add(listScroller);

            supprimer = new JButton("supprimer");
            supprimer.setBounds(445, 235, 200, 40);
            supprimer.setBackground(new Color(59, 89, 182));
            supprimer.setForeground(Color.WHITE);
            supprimer.setFocusPainted(false);
            supprimer.setFont(new Font("Arial", Font.BOLD, 12));
            supprimer.addActionListener(this);

            monPanel.add(lblNum, BorderLayout.EAST);
            monPanel.add(num, BorderLayout.NORTH);
            monPanel.add(supprimer, BorderLayout.EAST);
        } else {
            label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setText("La ménagerie ne contient aucun animal...");
            label.setBounds(290, 180, 350, 40);
            monPanel.add(label);
        }
        monPanel.add(retour, BorderLayout.SOUTH);
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
            int numAnimal = list.getSelectedIndex();
            System.out.println("Index selectionné : " + numAnimal);
            if (list.getSelectedIndices().length > 0) {
                int[] selectedIndices = list.getSelectedIndices();
                for (int i = selectedIndices.length - 1; i >= 0; i--) {
                    this.appMenagerie.supprimerAnimal(numAnimal);
                }
            }
        }
    }
}