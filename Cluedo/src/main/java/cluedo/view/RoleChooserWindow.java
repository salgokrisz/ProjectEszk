package cluedo.view;

import cluedo.Tools.LanguageString.LanguageStrings;
import cluedo.view.board.GameBoard;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



/**
 * This class is responsible for the appearance of the role chooser window. The
 * player can select properties like name, player level etc. from this page.
 * @author bornemis
 */
public class RoleChooserWindow extends AbstractBaseWindow {
    private int chosenPlayerNumber;
    private Map<Integer, PlayerComponent> playerComponents=new HashMap<>();
  
    public RoleChooserWindow() {
        initComponents();
        initPlayerComponents();
    }
    private void initPlayerComponents(){
        playerComponents.put(0, new PlayerComponent(jcbPlayerOnePersonality, jtfPlayerOneName, jcbPlayerOneRole, jcbPlayerOneDifficulty));
        playerComponents.put(1, new PlayerComponent(jcbPlayerTwoPersonality, jtfPlayerTwoName, jcbPlayerTwoRole, jcbPlayerTwoDifficulty));
        playerComponents.put(2, new PlayerComponent(jcbPlayerThreePersonality, jtfPlayerThreeName, jcbPlayerThreeRole, jcbPlayerThreeDifficulty));
        playerComponents.put(3, new PlayerComponent(jcbPlayerFourPersonality, jtfPlayerFourName, jcbPlayerFourRole, jcbPlayerFourDifficulty));
        playerComponents.put(4, new PlayerComponent(jcbPlayerFivePersonality, jtfPlayerFiveName, jcbPlayerFiveRole, jcbPlayerFiveDifficulty));
        playerComponents.put(5, new PlayerComponent(jcbPlayerSixPersonality, jtfPlayerSixName, jcbPlayerSixRole, jcbPlayerSixDifficulty));       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBase = new javax.swing.JPanel();
        jlLogo = new javax.swing.JLabel();
        jbChoose = new javax.swing.JButton();
        jcbPlayerOneRole = new javax.swing.JComboBox<>();
        jlPlayerOne = new javax.swing.JLabel();
        jlPlayerTwo = new javax.swing.JLabel();
        jcbPlayerTwoRole = new javax.swing.JComboBox<>();
        jlPlayerThree = new javax.swing.JLabel();
        jcbPlayerThreeRole = new javax.swing.JComboBox<>();
        jlPlayerFour = new javax.swing.JLabel();
        jcbPlayerFourRole = new javax.swing.JComboBox<>();
        jlPlayerFive = new javax.swing.JLabel();
        jcbPlayerFiveRole = new javax.swing.JComboBox<>();
        jlPlayerSix = new javax.swing.JLabel();
        jcbPlayerSixRole = new javax.swing.JComboBox<>();
        jcbPlayerOnePersonality = new javax.swing.JComboBox<>();
        jcbPlayerTwoPersonality = new javax.swing.JComboBox<>();
        jcbPlayerThreePersonality = new javax.swing.JComboBox<>();
        jcbPlayerFourPersonality = new javax.swing.JComboBox<>();
        jcbPlayerFivePersonality = new javax.swing.JComboBox<>();
        jcbPlayerSixPersonality = new javax.swing.JComboBox<>();
        jtfPlayerOneName = new javax.swing.JTextField();
        jtfPlayerTwoName = new javax.swing.JTextField();
        jtfPlayerThreeName = new javax.swing.JTextField();
        jtfPlayerFourName = new javax.swing.JTextField();
        jtfPlayerFiveName = new javax.swing.JTextField();
        jtfPlayerSixName = new javax.swing.JTextField();
        jcbPlayerOneDifficulty = new javax.swing.JComboBox<>();
        jcbPlayerTwoDifficulty = new javax.swing.JComboBox<>();
        jcbPlayerThreeDifficulty = new javax.swing.JComboBox<>();
        jcbPlayerFourDifficulty = new javax.swing.JComboBox<>();
        jcbPlayerFiveDifficulty = new javax.swing.JComboBox<>();
        jcbPlayerSixDifficulty = new javax.swing.JComboBox<>();
        jlTitle = new javax.swing.JLabel();
        jlName = new javax.swing.JLabel();
        jlRole = new javax.swing.JLabel();
        jlLevel = new javax.swing.JLabel();
        jbMustard = new javax.swing.JButton();
        jbGreen = new javax.swing.JButton();
        jbPeacock = new javax.swing.JButton();
        jbPlum = new javax.swing.JButton();
        jbScarlet = new javax.swing.JButton();
        jbWhite = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        jpBase.setBackground(new java.awt.Color(255, 30, 21));
        jpBase.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cluedolabel.png"))); // NOI18N

        jbChoose.setBackground(new java.awt.Color(180, 0, 0));
        jbChoose.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jbChoose.setText("Ok");
        jbChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbChooseActionPerformed(evt);
            }
        });

        jcbPlayerOneRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Random", "Mustard", "Peacok", "Green", "White", "Scarlet", "Plum" }));

        jlPlayerOne.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlPlayerOne.setText(LanguageStrings.getString("Menu.PlayerOne"));

        jlPlayerTwo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlPlayerTwo.setText(LanguageStrings.getString("Menu.PlayerTwo"));

        jcbPlayerTwoRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Random", "Mustard", "Peacok", "Green", "White", "Scarlet", "Plum" }));

        jlPlayerThree.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlPlayerThree.setText(LanguageStrings.getString("Menu.PlayerThree"));

        jcbPlayerThreeRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Random", "Mustard", "Peacok", "Green", "White", "Scarlet", "Plum" }));

        jlPlayerFour.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlPlayerFour.setText(LanguageStrings.getString("Menu.PlayerFour"));

        jcbPlayerFourRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Random", "Mustard", "Peacok", "Green", "White", "Scarlet", "Plum" }));

        jlPlayerFive.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlPlayerFive.setText(LanguageStrings.getString("Menu.PlayerFive"));

        jcbPlayerFiveRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Random", "Mustard", "Peacok", "Green", "White", "Scarlet", "Plum" }));

        jlPlayerSix.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlPlayerSix.setText(LanguageStrings.getString("Menu.PlayerSix"));

        jcbPlayerSixRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Random", "Mustard", "Peacok", "Green", "White", "Scarlet", "Plum" }));

        jcbPlayerOnePersonality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.PlayerOptionNone"), LanguageStrings.getString("Menu.PlayerOptionHuman"), LanguageStrings.getString("Menu.PlayerOptionAi") }));
        addActionListenerToJcbPlayerPersonality(jcbPlayerOnePersonality, 0);

        jcbPlayerTwoPersonality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.PlayerOptionNone"), LanguageStrings.getString("Menu.PlayerOptionHuman"), LanguageStrings.getString("Menu.PlayerOptionAi") }));
        addActionListenerToJcbPlayerPersonality(jcbPlayerTwoPersonality, 1);

        jcbPlayerThreePersonality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.PlayerOptionNone"), LanguageStrings.getString("Menu.PlayerOptionHuman"), LanguageStrings.getString("Menu.PlayerOptionAi") }));
        addActionListenerToJcbPlayerPersonality(jcbPlayerThreePersonality, 2);

        jcbPlayerFourPersonality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.PlayerOptionNone"), LanguageStrings.getString("Menu.PlayerOptionHuman"), LanguageStrings.getString("Menu.PlayerOptionAi") }));
        addActionListenerToJcbPlayerPersonality(jcbPlayerFourPersonality, 3);

        jcbPlayerFivePersonality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.PlayerOptionNone"), LanguageStrings.getString("Menu.PlayerOptionHuman"), LanguageStrings.getString("Menu.PlayerOptionAi") }));
        addActionListenerToJcbPlayerPersonality(jcbPlayerFivePersonality, 4);

        jcbPlayerSixPersonality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.PlayerOptionNone"), LanguageStrings.getString("Menu.PlayerOptionHuman"), LanguageStrings.getString("Menu.PlayerOptionAi") }));
        addActionListenerToJcbPlayerPersonality(jcbPlayerSixPersonality, 5);

        jcbPlayerOneDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.LevelOptionRandom"), LanguageStrings.getString("Menu.LevelOptionBeginner"), LanguageStrings.getString("Menu.LevelOptionIntermediate")  }));
        jcbPlayerOneDifficulty.setEnabled(false);

        jcbPlayerTwoDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.LevelOptionRandom"), LanguageStrings.getString("Menu.LevelOptionBeginner"), LanguageStrings.getString("Menu.LevelOptionIntermediate")  }));
        jcbPlayerTwoDifficulty.setEnabled(false);

        jcbPlayerThreeDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.LevelOptionRandom"), LanguageStrings.getString("Menu.LevelOptionBeginner"), LanguageStrings.getString("Menu.LevelOptionIntermediate")  }));
        jcbPlayerThreeDifficulty.setEnabled(false);

        jcbPlayerFourDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.LevelOptionRandom"), LanguageStrings.getString("Menu.LevelOptionBeginner"), LanguageStrings.getString("Menu.LevelOptionIntermediate")  }));
        jcbPlayerFourDifficulty.setEnabled(false);

        jcbPlayerFiveDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.LevelOptionRandom"), LanguageStrings.getString("Menu.LevelOptionBeginner"), LanguageStrings.getString("Menu.LevelOptionIntermediate")  }));
        jcbPlayerFiveDifficulty.setEnabled(false);

        jcbPlayerSixDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.LevelOptionRandom"), LanguageStrings.getString("Menu.LevelOptionBeginner"), LanguageStrings.getString("Menu.LevelOptionIntermediate") }));
        jcbPlayerSixDifficulty.setEnabled(false);

        jlTitle.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jlTitle.setText(LanguageStrings.getString("Menu.PlayerTitle"));

        jlName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlName.setText(LanguageStrings.getString("Menu.Name"));

        jlRole.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlRole.setText(LanguageStrings.getString("Menu.Role"));
       
        jlLevel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlLevel.setText(LanguageStrings.getString("Menu.Level"));

        jbMustard.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jbMustard.setForeground(new java.awt.Color(255, 51, 0));
        jbMustard.setText("Mustard");
        addActionListenerToButton(jbMustard);

        jbGreen.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jbGreen.setForeground(new java.awt.Color(0, 51, 0));
        jbGreen.setText("Green");
        addActionListenerToButton(jbGreen);

        jbPeacock.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jbPeacock.setForeground(new java.awt.Color(0, 0, 153));
        jbPeacock.setText("Peacock");
        addActionListenerToButton(jbPeacock);

        jbPlum.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jbPlum.setForeground(new java.awt.Color(102, 0, 153));
        jbPlum.setText("Plum");
        addActionListenerToButton(jbPlum);

        jbScarlet.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jbScarlet.setForeground(new java.awt.Color(204, 0, 0));
        jbScarlet.setText("Scarlet");
        addActionListenerToButton(jbScarlet);

        jbWhite.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jbWhite.setText("White");
        addActionListenerToButton(jbWhite);

        javax.swing.GroupLayout jpBaseLayout = new javax.swing.GroupLayout(jpBase);
        jpBase.setLayout(jpBaseLayout);
        jpBaseLayout.setHorizontalGroup(
            jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBaseLayout.createSequentialGroup()
                .addComponent(jlLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBaseLayout.createSequentialGroup()
                        .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpBaseLayout.createSequentialGroup()
                                    .addComponent(jlPlayerFour, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcbPlayerFourPersonality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jpBaseLayout.createSequentialGroup()
                                    .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpBaseLayout.createSequentialGroup()
                                            .addComponent(jlPlayerTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jcbPlayerTwoPersonality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpBaseLayout.createSequentialGroup()
                                            .addComponent(jlPlayerThree, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jcbPlayerThreePersonality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpBaseLayout.createSequentialGroup()
                                            .addComponent(jlPlayerOne, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jcbPlayerOnePersonality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpBaseLayout.createSequentialGroup()
                                            .addComponent(jlPlayerFive, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jcbPlayerFivePersonality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfPlayerOneName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfPlayerThreeName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfPlayerTwoName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfPlayerFourName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfPlayerFiveName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfPlayerSixName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jpBaseLayout.createSequentialGroup()
                                .addComponent(jlPlayerSix, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbPlayerSixPersonality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(685, 685, 685)))
                        .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbPlayerOneRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPlayerTwoRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPlayerThreeRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlRole, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPlayerFourRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPlayerFiveRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPlayerSixRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(242, 242, 242)
                        .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbPlayerSixDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPlayerFiveDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPlayerFourDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPlayerOneDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPlayerTwoDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPlayerThreeDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(120, Short.MAX_VALUE))
                    .addGroup(jpBaseLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jbMustard, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbPeacock, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbPlum, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbScarlet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTitle)
                            .addComponent(jbChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jpBaseLayout.setVerticalGroup(
            jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBaseLayout.createSequentialGroup()
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBaseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlTitle)
                        .addGap(28, 28, 28)
                        .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlName)
                            .addComponent(jlRole)
                            .addComponent(jlLevel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpBaseLayout.createSequentialGroup()
                        .addComponent(jlLogo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPlayerOne, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayerOnePersonality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPlayerOneName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayerOneRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayerOneDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPlayerTwoPersonality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayerTwoDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPlayerTwoName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPlayerTwo)
                    .addComponent(jcbPlayerTwoRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPlayerThreeDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayerThreeRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayerThreePersonality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPlayerThreeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPlayerThree))
                .addGap(68, 68, 68)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPlayerFour)
                    .addComponent(jcbPlayerFourPersonality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPlayerFourName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayerFourRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayerFourDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPlayerFive)
                    .addComponent(jcbPlayerFivePersonality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPlayerFiveName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayerFiveRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayerFiveDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPlayerSix)
                    .addComponent(jcbPlayerSixPersonality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPlayerSixName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayerSixRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayerSixDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMustard, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPeacock, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPlum, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbScarlet, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBase, javax.swing.GroupLayout.DEFAULT_SIZE, 1336, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 @Override
    protected void resetStringsOnWindow(){
        super.resetStringsOnWindow();
        jlPlayerOne.setText(LanguageStrings.getString("Menu.PlayerOne"));
        jlPlayerTwo.setText(LanguageStrings.getString("Menu.PlayerTwo"));
        jlPlayerThree.setText(LanguageStrings.getString("Menu.PlayerThree"));
        jlPlayerFour.setText(LanguageStrings.getString("Menu.PlayerFour"));
        jlPlayerFive.setText(LanguageStrings.getString("Menu.PlayerFive"));
        jlPlayerSix.setText(LanguageStrings.getString("Menu.PlayerSix"));
        jlTitle.setText(LanguageStrings.getString("Menu.PlayerTitle"));
        jlName.setText(LanguageStrings.getString("Menu.Name"));
        jlRole.setText(LanguageStrings.getString("Menu.Role"));
        jlLevel.setText(LanguageStrings.getString("Menu.Level"));
        jcbPlayerOnePersonality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.PlayerOptionNone"), LanguageStrings.getString("Menu.PlayerOptionHuman"), LanguageStrings.getString("Menu.PlayerOptionAi") }));
        jcbPlayerTwoPersonality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.PlayerOptionNone"), LanguageStrings.getString("Menu.PlayerOptionHuman"), LanguageStrings.getString("Menu.PlayerOptionAi") }));
        jcbPlayerThreePersonality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.PlayerOptionNone"), LanguageStrings.getString("Menu.PlayerOptionHuman"), LanguageStrings.getString("Menu.PlayerOptionAi") }));
        jcbPlayerFourPersonality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.PlayerOptionNone"), LanguageStrings.getString("Menu.PlayerOptionHuman"), LanguageStrings.getString("Menu.PlayerOptionAi") }));
        jcbPlayerFivePersonality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.PlayerOptionNone"), LanguageStrings.getString("Menu.PlayerOptionHuman"), LanguageStrings.getString("Menu.PlayerOptionAi") }));
        jcbPlayerSixPersonality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.PlayerOptionNone"), LanguageStrings.getString("Menu.PlayerOptionHuman"), LanguageStrings.getString("Menu.PlayerOptionAi") }));
        jcbPlayerOneDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.LevelOptionRandom"), LanguageStrings.getString("Menu.LevelOptionBeginner"), LanguageStrings.getString("Menu.LevelOptionIntermediate")  }));
        jcbPlayerTwoDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.LevelOptionRandom"), LanguageStrings.getString("Menu.LevelOptionBeginner"), LanguageStrings.getString("Menu.LevelOptionIntermediate")  }));
        jcbPlayerThreeDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.LevelOptionRandom"), LanguageStrings.getString("Menu.LevelOptionBeginner"), LanguageStrings.getString("Menu.LevelOptionIntermediate")  }));
        jcbPlayerFourDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.LevelOptionRandom"), LanguageStrings.getString("Menu.LevelOptionBeginner"), LanguageStrings.getString("Menu.LevelOptionIntermediate")  }));
        jcbPlayerFiveDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.LevelOptionRandom"), LanguageStrings.getString("Menu.LevelOptionBeginner"), LanguageStrings.getString("Menu.LevelOptionIntermediate")  }));
        jcbPlayerSixDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { LanguageStrings.getString("Menu.LevelOptionRandom"), LanguageStrings.getString("Menu.LevelOptionBeginner"), LanguageStrings.getString("Menu.LevelOptionIntermediate")  }));
    }
    private void jbChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbChooseActionPerformed
        int answer=showConfirmation(LanguageStrings.getString("JOptionPane.SettingsApproval"), null); //TODO: write the concrete role and player number
        if(answer==JOptionPane.YES_OPTION){
              SwingUtilities.invokeLater(() -> {
/*   Trial trial=new Trial();
   trial.setVisible(true);*/

            GameBoard gameBoard = new GameBoard();
            gameBoard.setVisible(true);
            doUponExit();
        });
        }
    }//GEN-LAST:event_jbChooseActionPerformed
      private void addActionListenerToJcbPlayerPersonality(JComboBox comboBox, int serialNumber){
        comboBox.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbPlayerPersonalityActionPerformed(evt, serialNumber);
    }
});
    }
    private void jcbPlayerPersonalityActionPerformed(ActionEvent evt, int serialNumber){
       
        JComboBox comboBox=(JComboBox) evt.getSource();
        String selectedOption=(String)comboBox.getSelectedItem();
       
        playerComponents.get(serialNumber).getJcbDifficultyLevel().setEnabled(selectedOption.equals(LanguageStrings.getString("Menu.PlayerOptionAi")));
  
       
    }private void addActionListenerToButton(JButton button){
    button.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbRoleActionPerfromed(evt);
    }
});
}
    private void jbRoleActionPerfromed(ActionEvent evt){
        //TODO: Give parameters for description and picture link
    JOptionPane.showMessageDialog(this, "description: Special ability of chosen player.", ((JButton)evt.getSource()).getText(), JOptionPane.INFORMATION_MESSAGE/*, new ImageIcon(getClass().getResource(cardInDatabase.getRepresentationLink()))*/);
}
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbChoose;
    private javax.swing.JButton jbGreen;
    private javax.swing.JButton jbMustard;
    private javax.swing.JButton jbPeacock;
    private javax.swing.JButton jbPlum;
    private javax.swing.JButton jbScarlet;
    private javax.swing.JButton jbWhite;
    private javax.swing.JComboBox<String> jcbPlayerFiveDifficulty;
    private javax.swing.JComboBox<String> jcbPlayerFivePersonality;
    private javax.swing.JComboBox<String> jcbPlayerFiveRole;
    private javax.swing.JComboBox<String> jcbPlayerFourDifficulty;
    private javax.swing.JComboBox<String> jcbPlayerFourPersonality;
    private javax.swing.JComboBox<String> jcbPlayerFourRole;
    private javax.swing.JComboBox<String> jcbPlayerOneDifficulty;
    private javax.swing.JComboBox<String> jcbPlayerOnePersonality;
    private javax.swing.JComboBox<String> jcbPlayerOneRole;
    private javax.swing.JComboBox<String> jcbPlayerSixDifficulty;
    private javax.swing.JComboBox<String> jcbPlayerSixPersonality;
    private javax.swing.JComboBox<String> jcbPlayerSixRole;
    private javax.swing.JComboBox<String> jcbPlayerThreeDifficulty;
    private javax.swing.JComboBox<String> jcbPlayerThreePersonality;
    private javax.swing.JComboBox<String> jcbPlayerThreeRole;
    private javax.swing.JComboBox<String> jcbPlayerTwoDifficulty;
    private javax.swing.JComboBox<String> jcbPlayerTwoPersonality;
    private javax.swing.JComboBox<String> jcbPlayerTwoRole;
    private javax.swing.JLabel jlLevel;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlPlayerFive;
    private javax.swing.JLabel jlPlayerFour;
    private javax.swing.JLabel jlPlayerOne;
    private javax.swing.JLabel jlPlayerSix;
    private javax.swing.JLabel jlPlayerThree;
    private javax.swing.JLabel jlPlayerTwo;
    private javax.swing.JLabel jlRole;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JPanel jpBase;
    private javax.swing.JTextField jtfPlayerFiveName;
    private javax.swing.JTextField jtfPlayerFourName;
    private javax.swing.JTextField jtfPlayerOneName;
    private javax.swing.JTextField jtfPlayerSixName;
    private javax.swing.JTextField jtfPlayerThreeName;
    private javax.swing.JTextField jtfPlayerTwoName;
    // End of variables declaration//GEN-END:variables
}
