
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class Extract
        extends JInternalFrame {

    public String encryptedAudioFileName;
    public String encryptedAudioFileDirectory;
    public String encryptedAudioFileString;
    public String inputPasswordDString;
    public String outputTextFileString;
    public Audio audio;
    private JSeparator HSeparator;
    private JButton clearPasswordD;
    private JFileChooser encryptedAudioChooser;
    private JButton encryptedAudioFileButton;
    private JLabel encryptedAudioFileLabel;
    private JButton extractTextButton;
    private JLabel extractedTextFromAudioLabel;
    private JButton finishDButton;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JLabel outputTextFileLabel;
    private JLabel passwordDLabel;
    private JTextField passwordDTextField;
    private JButton playButton;
    private JTextArea showTextArea;
    private JButton stopButton;

    public Extract() {
        initComponents();
        ImageIcon icon = new ImageIcon("images/extract.png");
        setFrameIcon(icon);
        this.finishDButton.setEnabled(false);
        this.stopButton.setEnabled(false);
        this.playButton.setEnabled(false);
        setLocation(Audiosteganography.extractJIFX, Audiosteganography.extractJIFY);
        Audiosteganography.extractJIFX += 20;
        Audiosteganography.extractJIFY += 25;
    }

    private void initComponents() {
        this.encryptedAudioChooser = new JFileChooser();
        this.encryptedAudioFileButton = new JButton();
        this.passwordDTextField = new JTextField();
        this.clearPasswordD = new JButton();
        this.extractTextButton = new JButton();
        this.encryptedAudioFileLabel = new JLabel();
        this.passwordDLabel = new JLabel();
        this.HSeparator = new JSeparator();
        this.finishDButton = new JButton();
        this.playButton = new JButton();
        this.stopButton = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.showTextArea = new JTextArea();
        this.outputTextFileLabel = new JLabel();
        this.extractedTextFromAudioLabel = new JLabel();
        this.jLabel1 = new JLabel();

        this.encryptedAudioChooser.setFileFilter(new MyAudioFileFilter());

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Extract Text From Encrypted Audio");
        setPreferredSize(new Dimension(600, 370));
        addInternalFrameListener(new InternalFrameListener() {
            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                Extract.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.encryptedAudioFileButton.setFont(new Font("Tahoma", 0, 14));
        //this.encryptedAudioFileButton.setIcon(new ImageIcon(getClass().getResource("/images/audioE.png")));
        this.encryptedAudioFileButton.setText("Encryped Audio File (.au)");
        this.encryptedAudioFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Extract.this.encryptedAudioFileButtonActionPerformed(evt);
            }
        });
        this.passwordDTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Extract.this.passwordDTextFieldActionPerformed(evt);
            }
        });
        this.clearPasswordD.setText("Clear");
        this.clearPasswordD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Extract.this.clearPasswordDActionPerformed(evt);
            }
        });
        this.extractTextButton.setFont(new Font("Tahoma", 0, 14));
        //this.extractTextButton.setIcon(new ImageIcon(getClass().getResource("/images/extract.png")));
        this.extractTextButton.setText("Extract Text");
        this.extractTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Extract.this.extractTextButtonActionPerformed(evt);
            }
        });
        this.encryptedAudioFileLabel.setFont(new Font("Tahoma", 0, 12));
        this.encryptedAudioFileLabel.setText("File Not Choosen");

        this.passwordDLabel.setFont(new Font("Tahoma", 0, 12));
        this.passwordDLabel.setText("Password To Decrypt");

        this.finishDButton.setFont(new Font("Tahoma", 0, 14));
        //this.finishDButton.setIcon(new ImageIcon(getClass().getResource("/images/finish.png")));
        this.finishDButton.setText("Finish");
        this.finishDButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Extract.this.finishDButtonActionPerformed(evt);
            }
        });
        // this.playButton.setIcon(new ImageIcon(getClass().getResource("/images/play.png")));
        this.playButton.setText("Play");
        this.playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Extract.this.playButtonActionPerformed(evt);
            }
        });
        //this.stopButton.setIcon(new ImageIcon(getClass().getResource("/images/stop.png")));
        this.stopButton.setText("Stop");
        this.stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Extract.this.stopButtonActionPerformed(evt);
            }
        });
        this.showTextArea.setColumns(20);
        this.showTextArea.setRows(5);
        this.jScrollPane1.setViewportView(this.showTextArea);

        this.outputTextFileLabel.setText("Output Text File Location");

        this.extractedTextFromAudioLabel.setFont(new Font("Tahoma", 0, 14));
        this.extractedTextFromAudioLabel.setText("Extracted Text From Audio");

   //this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/rightArrow.png")));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.extractTextButton, -1, -1, 32767).addComponent(this.clearPasswordD).addComponent(this.encryptedAudioFileButton, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.passwordDTextField, GroupLayout.Alignment.LEADING)).addComponent(this.finishDButton, -2, 219, -2).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.extractedTextFromAudioLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.passwordDLabel).addGroup(layout.createSequentialGroup().addComponent(this.playButton).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.stopButton)).addComponent(this.encryptedAudioFileLabel).addComponent(this.outputTextFileLabel).addComponent(this.jScrollPane1, -2, 281, -2)).addContainerGap(56, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.HSeparator, -1, 584, 32767)));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.encryptedAudioFileLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.playButton).addComponent(this.stopButton))).addComponent(this.encryptedAudioFileButton, -2, 56, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.passwordDTextField, -2, -1, -2).addComponent(this.passwordDLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.clearPasswordD).addGap(30, 30, 30).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.extractTextButton, -2, 47, -2).addComponent(this.outputTextFileLabel)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane1, -2, -1, -2).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.extractedTextFromAudioLabel).addGap(18, 18, 18))).addComponent(this.finishDButton, -2, 47, -2))).addContainerGap(83, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(148, 148, 148).addComponent(this.HSeparator, -2, 10, -2).addContainerGap(250, 32767))));

        pack();
    }

    private void encryptedAudioFileButtonActionPerformed(ActionEvent evt) {
        int returnVal = this.encryptedAudioChooser.showOpenDialog(this);
        if (returnVal == 0) {
            File file = this.encryptedAudioChooser.getSelectedFile();
            this.encryptedAudioFileName = file.getName();
            this.encryptedAudioFileDirectory = file.getParent();

            this.encryptedAudioFileString = file.getAbsolutePath();
            this.encryptedAudioFileLabel.setText(this.encryptedAudioFileString);
        } else {
            System.out.println("File access cancelled by user.");
        }
        this.playButton.setEnabled(true);
    }

    private void clearPasswordDActionPerformed(ActionEvent evt) {
        this.passwordDTextField.setText("");
    }

    private void extractTextButtonActionPerformed(ActionEvent evt) {
        this.inputPasswordDString = this.passwordDTextField.getText();
        if ((this.encryptedAudioFileString != null) && (!this.inputPasswordDString.equals(""))) {
            this.finishDButton.setEnabled(true);
            this.extractTextButton.setEnabled(false);
            this.outputTextFileString = this.encryptedAudioFileDirectory.concat("/ExtractedText-From-" + this.encryptedAudioFileName + ".txt");
            this.outputTextFileLabel.setText(this.outputTextFileString);
            Stego d = new Stego(this.encryptedAudioFileString, this.outputTextFileString, this.inputPasswordDString.toCharArray());
            d.decode();
        } else {
            JOptionPane.showMessageDialog(this, "1. Select Audio File\n2. Enter Password.", "Opps ! Something is missing !", 0);
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.outputTextFileString));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Extract.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            StringBuilder sb = new StringBuilder();
            String lineRead = br.readLine();
            while (lineRead != null) {
                sb.append(lineRead);
                sb.append('\n');
                lineRead = br.readLine();
            }
            String everything = sb.toString();

            this.showTextArea.setText(everything);
            return;
        } catch (IOException ex) {
            Logger.getLogger(Extract.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Extract.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void finishDButtonActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void passwordDTextFieldActionPerformed(ActionEvent evt) {
    }

    private void playButtonActionPerformed(ActionEvent evt) {
        try {
            this.stopButton.setEnabled(true);
            this.playButton.setEnabled(false);
            this.audio = new Audio(this.encryptedAudioFileString);
            this.audio.play();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Embed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Embed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void stopButtonActionPerformed(ActionEvent evt) {
        try {
            this.audio.stop();
        } catch (Exception ex) {
        }
        this.playButton.setEnabled(true);
        this.stopButton.setEnabled(false);
    }

    private void formInternalFrameClosed(InternalFrameEvent evt) {
        try {
            this.audio.stop();
        } catch (Exception ex) {
        }
    }
}
