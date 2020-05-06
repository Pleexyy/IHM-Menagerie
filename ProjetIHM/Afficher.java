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
            for (int i = 0; i < lesAnimaux.size(); i++) {
                labels.add("Animal n°" + i + " : " + lesAnimaux.get(i).toString());
            }
            final JList<String> listArea = new JList<String>(labels.toArray(new String[labels.size()]));
            listArea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listArea.setFont(new Font("Arial", Font.ITALIC, 14));
            JScrollPane listScroller = new JScrollPane();
            listScroller.setViewportView(listArea);
            listArea.setLayoutOrientation(JList.VERTICAL);
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