package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TradingApplication extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public TradingApplication(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JButton retrieve = new JButton("Atualizar");
		JButton buy = new JButton("Comprar");
		JButton sell = new JButton("Vender");
		
		// Create and set up a frame window
 
        // Define the panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setSize(700, 600);
        GroupLayout layout = new GroupLayout(panel);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);
 
        // Set for horizontal and vertical group
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createSequentialGroup().addGroup(layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(buy).addComponent(retrieve).addComponent(sell))));
        layout.setVerticalGroup(
                layout.createSequentialGroup().addComponent(buy).addComponent(retrieve).addComponent(sell));
        // Set the window to be visible as the default to be false
        
        this.add(panel);
        this.pack();
        this.setVisible(true);		
	}
	
	public static void main(String[] args) {
		
		new TradingApplication("Trading project");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
