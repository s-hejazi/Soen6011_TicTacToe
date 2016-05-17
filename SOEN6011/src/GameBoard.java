import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
public class GameBoard extends JFrame implements ActionListener {

	private JPanel contentPane;
	JButton btnOnGameBoard[] = new JButton[10];
	
	JPanel gameBoardPannel = new JPanel(),
	menuPannel = new JPanel(),
	scoreBoardPannel = new JPanel(),
	playerTurnPannel = new JPanel(),
	helpPanel = new JPanel();
	
	JLabel lblPlayerMove=new JLabel(),
	lblPlayer2Score = new JLabel("Player 2: 1"),
	lblPlayer1Score = new JLabel("Player 1: 0"),
	lblScoreBoard = new JLabel("Score Board");
	
	JMenuBar newGameMenu = new JMenuBar();
	JMenuItem mnNewGame = new JMenuItem("New Game  "),
	mnHelp = new JMenuItem("Help "),
	mnExitGame=new JMenuItem("Exit ");
	
	JTextArea helpText = new JTextArea();
	
	int checkPlayer=0;
	String turn, player1="Player 1", player2="Player 2";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameBoard frame = new GameBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameBoard() {
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		gameBoardPannel.setBounds(25, 56, 314, 191);
		contentPane.add(gameBoardPannel);
		gameBoardPannel.setLayout(new GridLayout(0, 3, 0, 0));
		
		menuPannel.setBounds(0, 0, 498, 49);
		contentPane.add(menuPannel);
		menuPannel.setLayout(null);
		newGameMenu.setBounds(10, 11, 418, 24);
				
		menuPannel.add(newGameMenu);
		newGameMenu.setToolTipText("");
		mnNewGame.setBackground(Color.WHITE);
		mnNewGame.setAlignmentX(Component.LEFT_ALIGNMENT);
				
		mnNewGame.setToolTipText("Start new game");
		newGameMenu.add(mnNewGame);
		mnHelp.setBackground(Color.WHITE);
		newGameMenu.add(mnHelp);
		mnExitGame.setBackground(Color.WHITE);
		newGameMenu.add(mnExitGame);
		
		helpPanel.setVisible(false);
		helpPanel.setBounds(100, 71, 250, 200);
		
		contentPane.add(helpPanel);
				
		scoreBoardPannel.setBorder(new LineBorder(new Color(0, 0, 0)));
		scoreBoardPannel.setBounds(373, 56, 125, 83);
		contentPane.add(scoreBoardPannel);
		scoreBoardPannel.setLayout(null);
				
		lblPlayer2Score.setBounds(23, 58, 108, 14);
		scoreBoardPannel.add(lblPlayer2Score);
		
		lblPlayer1Score.setBounds(23, 33, 108, 14);
		scoreBoardPannel.add(lblPlayer1Score);
				
		lblScoreBoard.setBounds(23, 8, 91, 14);
		scoreBoardPannel.add(lblScoreBoard);
				
		playerTurnPannel.setBounds(388, 150, 110, 49);
		contentPane.add(playerTurnPannel);
		playerTurnPannel.setLayout(null);
		//lblNewLabel.setBounds(0, 11, 110, 14);
		lblPlayerMove.setBounds(0, 11, 110, 14);
		playerTurnPannel.add(lblPlayerMove);
		//clearAllPannels();
		lblPlayerMove.setText("Turn: Player 1");
		for(int i = 0 ; i < 9 ; i++){
			btnOnGameBoard[i]=new JButton();
			
			btnOnGameBoard[i].setFont(new Font("Tahoma", Font.BOLD, 40));
			btnOnGameBoard[i].addActionListener(this);
			btnOnGameBoard[i].setBackground(new Color(0,0,0));
			btnOnGameBoard[i].setForeground(new Color(255,255,255));
			gameBoardPannel.add(btnOnGameBoard[i]);
			
		}
		
		mnExitGame.addActionListener(this);
		mnHelp.addActionListener(this);
		mnNewGame.addActionListener(this);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object checkClick=e.getSource();
		//if(checkClick==mnNewGame)
		//{ 	
			//clearAllPannels();
			//gameBoardPannel.setVisible(true);
			//scoreBoardPannel.setVisible(true);
			//playerTurnPannel.setVisible(true);
			for (int i = 0; i < 9 ; i++) {
				if(checkClick==btnOnGameBoard[i] && checkPlayer < 9 ){
					if(checkPlayer % 2 == 0){
						btnOnGameBoard[i].setText("X");
						//btnOnGameBoard[i].setEnabled(false);
					}
					else{
						btnOnGameBoard[i].setForeground(new Color(255,0,0));
						btnOnGameBoard[i].setText("0");	
						//btnOnGameBoard[i].setEnabled(false);
					}
					checkPlayerTurn();
					checkPlayer++;
				}
			}
		//}
		if(checkClick==mnHelp){
			getHelp();
		}
		if(checkClick==mnExitGame){
			if(0==JOptionPane.showConfirmDialog(null,"Are you sure","Exit Game",0))System.exit(0);
		}
	}
	public void checkPlayerTurn() {
		if(checkPlayer % 2 == 0) {
		turn = player2;
		} else {
		turn = player1;
		}
		lblPlayerMove.setText("Turn: " + turn);
	}
	public void getHelp(){
		clearAllPannels();
		helpPanel.setVisible(true);
		helpText.setText(" The player who \n succeeds in \n placing three\n of their \n marks in a \n horizontal, \n vertical, or \n diagonal row \n wins the \n game. ");
		helpPanel.add(helpText);
	}
	
	public void clearAllPannels(){
		gameBoardPannel.setVisible(false);
		scoreBoardPannel.setVisible(false);
		playerTurnPannel.setVisible(false);
		helpPanel.setVisible(false);
	}
	
}
