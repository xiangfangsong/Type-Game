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
		int x= (int)(Math.random()*200+30); //�����ѡ��
		int y= 0; //��JLabel����ߴ���ʼ���䣻
		show.setFont(new java.awt.Font("����",Font.PLAIN, 33));
		String pst = letter; //��ʾ����ĸ
		show.setText(pst);
		jpanel1.add(show);
		boolean fo = true;
		while(fo)
		{
			if(show.isVisible()==false)
				break;
			
			y=y+10;
			show.setBounds(x, y, 33, 33); //�ɼ�JLabelÿ���ƶ��ľ���Ϊ10��
			try{
				Thread.sleep(speed); //ÿ��speed ms��ʱ�䣻
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			if(y >= 350){  //�䵽һ���߶ȣ�ֹͣ��
				myThread.fail = 1;
				JOptionPane.showMessageDialog(null, "���ĵ÷�Ϊ"+game1.score, "��Ϸ������", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
				break;
			}
		}
	}
}