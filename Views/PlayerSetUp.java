package Views;

import java.util.Random;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import Model.PlayerPiece;
import Model.Players;
import Model.Difficulty;
import Controller.AppLogger;

public class PlayerSetUp extends JFrame implements ActionListener {

    public String titleStr = "Player Set Up";
    int windowWidth = 500;
    int windowHeight = 300;
    static AppLogger logr = AppLogger.getInstance();
    JButton okButton = new JButton("OK");
    JButton exitButton = new JButton("Exit");
    JButton redBtn = new JButton();
    JButton blueBtn = new JButton();
    JButton greenBtn = new JButton();
    JButton magentaBtn = new JButton();
    JTextField nameField = new JTextField();
    String color;
    static PlayerPiece player = new PlayerPiece();
    static PlayerPiece computer = new PlayerPiece();
    static Players players = new Players().getInstance();
    Difficulty lvl = Difficulty.getInstance();
    JRadioButton easyButton = new JRadioButton("Easy");
    JRadioButton normButton = new JRadioButton("Normal");
    JRadioButton hardButton = new JRadioButton("Hard");
    Index indexWindow = Index.getInstance();
    ButtonGroup group = new ButtonGroup();

    public PlayerSetUp() {
        super.setTitle(titleStr);
        initComp();
    }

    private void initComp() {
        mainPanel();
        lastSteps();
    }

    private void lastSteps() {
        pack();

        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(windowWidth, windowHeight);
        this.setVisible(true);
    }

    private void mainPanel() {
        JPanel mP = new JPanel(new GridLayout(4, 1));

        JPanel namePanel = new JPanel(new GridLayout(2, 1));
        JLabel nameLabel = new JLabel("Player Name:");

        addPlaceHolder(nameField, "Name");
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        JPanel btnsPanel = new JPanel(new GridLayout(2, 7));

        JPanel diffPanel = new JPanel(new GridLayout(2, 1));
        JLabel diffLabel = new JLabel("Select Level of Dificulty:");
        JPanel diffBtnPAnel = new JPanel(new GridLayout(1, 3));
        group.add(easyButton);
        group.add(normButton);
        group.add(hardButton);
        easyButton.addActionListener(this);
        normButton.addActionListener(this);
        hardButton.addActionListener(this);
        diffBtnPAnel.add(easyButton);
        diffBtnPAnel.add(normButton);
        diffBtnPAnel.add(hardButton);

        diffPanel.add(diffLabel);
        diffPanel.add(diffBtnPAnel);
        okButton.addActionListener(this);
        exitButton.addActionListener(this);
        btnsPanel.add(new JPanel());
        btnsPanel.add(new JPanel());
        btnsPanel.add(new JPanel());
        btnsPanel.add(new JPanel());
        btnsPanel.add(new JPanel());
        btnsPanel.add(new JPanel());
        btnsPanel.add(new JPanel());
        btnsPanel.add(new JPanel());
        btnsPanel.add(new JPanel());
        btnsPanel.add(okButton);
        btnsPanel.add(new JPanel());
        btnsPanel.add(exitButton);
        btnsPanel.add(new JPanel());
        btnsPanel.add(new JPanel());

        mP.add(namePanel);
        mP.add(diffPanel);
        mP.add(playerColorPicker());
        mP.add(btnsPanel);
        this.add(mP);
    }

    private JPanel playerColorPicker() {
        int btnSize = (windowWidth / 4) - 10;
        Dimension dim = new Dimension(btnSize, btnSize);
        JPanel tmpPanel = new JPanel(new GridLayout(1, 4));

        redBtn.setPreferredSize(dim);
        blueBtn.setPreferredSize(dim);
        greenBtn.setPreferredSize(dim);
        magentaBtn.setPreferredSize(dim);

        try {
            Image redIconFull = new ImageIcon("Assets\\icons\\Pawns\\pawn_red_icon.png").getImage();
            Image blueIconFull = new ImageIcon("Assets\\icons\\Pawns\\pawn_blue_icon.png").getImage();
            Image greenIconFull = new ImageIcon("Assets\\icons\\Pawns\\pawn_green_icon.png").getImage();
            Image magentaIconFull = new ImageIcon("Assets\\icons\\Pawns\\pawn_magenta_icon.png").getImage();

            ImageIcon redIcon = new ImageIcon(
                    redIconFull.getScaledInstance(btnSize / 2, btnSize / 2, Image.SCALE_SMOOTH));
            ImageIcon blueIcon = new ImageIcon(
                    blueIconFull.getScaledInstance(btnSize / 2, btnSize / 2, Image.SCALE_SMOOTH));
            ImageIcon greenIcon = new ImageIcon(
                    greenIconFull.getScaledInstance(btnSize / 2, btnSize / 2, Image.SCALE_SMOOTH));
            ImageIcon magentaIcon = new ImageIcon(
                    magentaIconFull.getScaledInstance(btnSize / 2, btnSize / 2, Image.SCALE_SMOOTH));

            redBtn.setIcon(redIcon);
            blueBtn.setIcon(blueIcon);
            greenBtn.setIcon(greenIcon);
            magentaBtn.setIcon(magentaIcon);

        } catch (Exception e) {
            logr.msgLog(4, "Image Could not Load", e, "Player Set Up");
            redBtn.setText("Red");
            blueBtn.setText("Blue");
            greenBtn.setText("Green");
            magentaBtn.setText("Magenta");
        }

        redBtn.addActionListener(this);
        blueBtn.addActionListener(this);
        greenBtn.addActionListener(this);
        magentaBtn.addActionListener(this);

        tmpPanel.add(redBtn);
        tmpPanel.add(blueBtn);
        tmpPanel.add(greenBtn);
        tmpPanel.add(magentaBtn);

        return tmpPanel;
    }

    private void addPlaceHolder(JTextField txtField, String holder) {
        txtField.setForeground(Color.LIGHT_GRAY);
        txtField.setText(holder);
        txtField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtField.getText().trim().equals(holder)) {
                    txtField.setText("");
                }

                txtField.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtField.getText().trim().equals("")) {
                    txtField.setText(holder);
                }
                if (txtField.getText().trim().equals(holder)) {
                    txtField.setForeground(Color.LIGHT_GRAY);
                }

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        color = PlayerPiece.RED;
        if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == easyButton) {
            lvl.setDifficulty(1);
        } else if (e.getSource() == normButton) {
            lvl.setDifficulty(2);
        } else if (e.getSource() == hardButton) {
            lvl.setDifficulty(3);
        } else if (e.getSource() == redBtn) {
            color = PlayerPiece.RED;
        } else if (e.getSource() == blueBtn) {
            color = PlayerPiece.BLUE;
        } else if (e.getSource() == greenBtn) {
            color = PlayerPiece.GREEN;
        } else if (e.getSource() == magentaBtn) {
            color = PlayerPiece.MAGENTA;
        } else if (e.getSource() == okButton) {
            String name;
            if (nameField.getText().equals("")) {
                name = "Player";
            } else {
                name = nameField.getText();
            }
            player.setPlayer(color, PlayerPiece.PLAYER);
            player.setName(name);

            Random rand = new Random();
            String colorComp;
            while (true) {
                int randCol = rand.nextInt(3);
                if ((randCol == 1) && !(color.equals(PlayerPiece.RED))) {
                    colorComp = PlayerPiece.RED;
                    break;
                }
                if ((randCol == 2) && !(color.equals(PlayerPiece.BLUE))) {
                    colorComp = PlayerPiece.BLUE;
                    break;
                }
                if ((randCol == 3) && !(color.equals(PlayerPiece.GREEN))) {
                    colorComp = PlayerPiece.GREEN;
                    break;
                }
                if ((randCol == 4) && !(color.equals(PlayerPiece.MAGENTA))) {
                    colorComp = PlayerPiece.MAGENTA;
                    break;
                }
            }

            computer.setPlayer(colorComp, PlayerPiece.COMPUTER);
            computer.setName(PlayerPiece.COMPUTER);

            players.setPlayers(player, computer);

            String message = players.getPlayer().getName() + " " + players.getPlayer().getColor() + "\n"
                    + players.getComputer().getName() + " " + players.getComputer().getColor() + "\n"
                    + "Difficulty Level: " + lvl.getDifficultyInt() + " : " + lvl.getDifficultyString();
            System.out.println(message);
            logr.msgLog(5, message, "PlayerSetUp");

            this.setVisible(false);
            
            indexWindow.repaint();
        }
    }

}
