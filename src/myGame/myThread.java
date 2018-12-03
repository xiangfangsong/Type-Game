package myGame;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class myThread implements Runnable {
	JPanel jpanel1;
	String letter;
	JLabel show;
	static int speed;
	static int fail;
	
	public myThread(JPanel jpanel1,String letter,JLabel show){
		this.jpanel1 = jpanel1;
		this.letter = letter;
		this.show = show;
		myThread.speed = 400;
		myThread.fail = 0;
	}
	
	public static void setSpeed(int v){
		if(speed+v > 0)
			speed = speed + v;
	}
	
	public void run() {
		int x= (int)(Math.random()*200+30); //随意的选择；
		int y= 0; //让JLabel从最高处开始下落；
		show.setFont(new java.awt.Font("宋体",Font.PLAIN, 33));
		String pst = letter; //显示在字母
		show.setText(pst);
		jpanel1.add(show);
		boolean fo = true;
		while(fo)
		{
			if(show.isVisible()==false)
				break;
			
			y=y+10;
			show.setBounds(x, y, 33, 33); //可见JLabel每次移动的距离为10；
			try{
				Thread.sleep(speed); //每隔speed ms的时间；
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			if(y >= 350){  //落到一定高度，停止；
				myThread.fail = 1;
				JOptionPane.showMessageDialog(null, "您的得分为"+game1.score, "游戏结束！", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
				break;
			}
		}
	}
}