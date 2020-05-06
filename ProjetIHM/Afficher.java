import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Afficher extends JFrame implements ActionListener {
    private JPanel monPanel;
    private AppMenagerie appMenagerie;
    private JButton retour;
    private JLabel label;
    private JTable tableau;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Afficher(AppMenagerie appMenagerie, ArrayList<Animal> lesAnimaux) {
        this.appMenagerie = appMenagerie;
        monPanel = new JPanel(new BorderLayout());
        monPanel.setBackground(Color.white);

        retour = new JButton("retour");
        retour.setBackground(new Color(59, 89, 182));
        retour.setForeground(Color.WHITE);
        retour.setFocusPainted(false);
        retour.setFont(new Font("Arial", Font.BOLD, 12));
        retour.addActionListener(this);

        if (!lesAnimaux.isEmpty()) {
            List<String> labels = new ArrayList<>(25);
            Object data[][] = new Object[50][50];
            for (int i = 0; i < lesAnimaux.size(); i++) {
                labels.add("Animal n°" + i + " : " + lesAnimaux.get(i).toString());
                data[i][0] = lesAnimaux.get(i).getNom();
                data[i][1] = lesAnimaux.get(i).getEspece();
            }
            String[] title = { "Nom de l'animal", "Espèce de l'animal" };
            this.tableau = new JTable(data, title);
            tableau.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
            JScrollPane listScroller = new JScrollPane();
            listScroller.setViewportView(tableau);
            monPanel.add(listScroller);
        } else {
            label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setText("La ménagerie ne contient aucun animal...");
            monPanel.add(label, BorderLayout.CENTER);
        }
        monPanel.add(retour, BorderLayout.SOUTH);
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