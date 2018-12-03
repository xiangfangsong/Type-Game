package myGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class Game extends JFrame implements WindowListener,ActionListener{
	int boom[] = new int[100];
	JButton button[] = new JButton[100];
	
	public static void main(String[] main) {
		new Game();
	}
	
	public Game() {
		//产生雷
		for(int i = 0;i < 100;i++)
			boom[i] = 0;
		int flag = 0,rnd;
		while(flag != 10) {
			rnd = (int)(Math.random()*100);
			if(boom[rnd]==0)
				boom[rnd] = 1;
			else
				continue;
			flag++;
		}
		
		JFrame frame = new JFrame("扫雷");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//创建菜单
		JMenuBar greenMenuBar = new JMenuBar();
		greenMenuBar.setBackground(new Color(255,255,0));
		greenMenuBar.setPreferredSize(new Dimension(400,20));
		
		JMenu menu = new JMenu("Game");
		JMenuItem menuitem = new JMenuItem("Start");
		menu.add(menuitem);
		menuitem = new JMenuItem("Exit");
		menu.add(menuitem);
		greenMenuBar.add(menu);
		menu = new JMenu("About");
		greenMenuBar.add(menu);
		
		frame.setJMenuBar(greenMenuBar);
		
		//制作按钮
		frame.getContentPane().setLayout(new GridLayout(10,10));
		
		for(int i=0;i<100;i++)
		{
			button[i] = new JButton();
			button[i].setPreferredSize(new Dimension(50,50));
			button[i].setName(i+"");
			button[i].addActionListener(this);
			frame.getContentPane().add(button[i]);
		}
			
		frame.pack();
		frame.setVisible(true);
		
		addWindowListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		int i;
		for(i = 0;i < 100;i++)
			if(arg0.getSource()==button[i])
				break;
		button[i].setBackground(new Color(0,255,0));
		if(boom[i]==1)
		{
			for(int j=0;j < 100;j++)
			{
				if(boom[j]==1)
					button[j].setBackground(new Color(255,0,0));
				else
					button[j].setBackground(new Color(0,255,0));
			}					
		}
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
}
