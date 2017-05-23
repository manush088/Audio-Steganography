
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Audiosteganography
        extends JFrame {

    public static int embedJIFX = 0;
    public static int embedJIFY = 0;
    public static int extractJIFX = 600;
    public static int extractJIFY = 0;
    private JDesktopPane jdp;
    private JButton EmbedButton;
    private JButton ExtractButton;
    private JButton jButton1;
    private JLabel wallpaperLabel;

    public Audiosteganography() {
        initComponents();
        setExtendedState(getExtendedState() | 0x6);

        setResizable(true);
        setTitle("Audio Steganography");
        ImageIcon icon = new ImageIcon("C:/Users/CHINKI/Documents/NetBeansProjects/AudioSteganography/src/images/as.jpg");
        setIconImage(icon.getImage());

    }

    private void initComponents() {

        this.jdp = new JDesktopPane();
        this.wallpaperLabel = new JLabel();
        this.EmbedButton = new JButton();
        this.ExtractButton = new JButton();
        this.jButton1 = new JButton();

        setDefaultCloseOperation(3);
        setCursor(new Cursor(0));

        this.jdp.setBackground(new java.awt.Color(255, 255, 255));
        this.wallpaperLabel.setIcon(new ImageIcon(getClass().getResource("/images/wallpaper.jpg")));
        this.wallpaperLabel.setBounds(0, 0, 800, 800);
        this.jdp.add(this.wallpaperLabel, JLayeredPane.DEFAULT_LAYER);

        this.EmbedButton.setFont(new Font("Tahoma", 0, 14));
        this.EmbedButton.setText("Embed Text To Audio");
        this.EmbedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Audiosteganography.this.EmbedButtonActionPerformed(evt);
            }
        });
        this.ExtractButton.setFont(new Font("Tahoma", 0, 14));
        this.ExtractButton.setText("Extract Text From Audio");
        this.ExtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Audiosteganography.this.ExtractButtonActionPerformed(evt);
            }
        });
        this.jButton1.setText("Exit");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Audiosteganography.this.jButton1ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jdp).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.EmbedButton, -2, 228, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.ExtractButton, -2, 223, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, 32767).addComponent(this.jButton1, -2, 100, -2).addContainerGap()));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jdp, -1, 408, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.EmbedButton).addComponent(this.ExtractButton)).addComponent(this.jButton1, -2, 30, -2)).addGap(18, 18, 18)));
    }

    private void EmbedButtonActionPerformed(ActionEvent evt) {
        Embed embedJIF = new Embed();
        this.jdp.add(embedJIF);
        embedJIF.show();
    }

    private void ExtractButtonActionPerformed(ActionEvent evt) {
        Extract extractJIF = new Extract();
        this.jdp.add(extractJIF);
        extractJIF.show();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Audiosteganography().setVisible(true);
            }
        });
    }
}
