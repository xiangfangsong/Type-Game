package myGame;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class game1 extends JFrame{
	JPanel contentPane;
	public static JPanel jpanel1 = new JPanel();
	static int score = 0; //Íæ¼ÒµÃ·Ö
	public static Vector number;
	
	public game1(){
		gameInit();
		this.addKeyListener(new Keyboard()); //¼àÌý¼üÅÌ
		
		number = new Vector();
		for(int i=0;i<10;i++){
			String str = (char)((int)(Math.random()*26+65))+"";
			JLabel show = new JLabel();
			myThread letter = new myThread(jpanel1,str,show);
			new Thread(letter).start();
			Bean bean = new Bean();
		    bean.setStr(str);
		    bean.setShow(show);
		    number.add(bean);
			try{
				Thread.sleep((int)(Math.random()*1000+500)); 
			}catch(InterruptedException e){
				e.printStackTrace();
			}	
		}		
	}
	
	private void gameInit(){
		contentPane = (JPanel)getContentPane();
		contentPane.setLayout(null);
		setSize(new Dimension(500, 500));
		setTitle("alphabet game");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jpanel1.setBounds(new Rectangle(4, 4, 400, 400));
		contentPane.add(jpanel1);
	}

	public static void addScore(){
		score = score + 1;
	}
	
	public static void main(String[] args){
		new game1();
	}

}
