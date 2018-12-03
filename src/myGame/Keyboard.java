package myGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class Keyboard implements KeyListener{
	
	public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        if (e.getKeyCode()==33){
        	//System.out.println("UP");
        	myThread.setSpeed(-100);
        	
    	}
        else if(e.getKeyCode()==34){
        	//System.out.println("DOWN");
        	myThread.setSpeed(+100);
        }
        else
        {
        	String pressKey = (char) e.getKeyCode() + "";
        	for(int i=0;i<game1.number.size();i++){
        		Bean bn = (Bean) game1.number.get(i);
        		if(bn.getStr().equals(pressKey)){
					game1.jpanel1.remove(bn.getLabel());
					game1.jpanel1.repaint();
        			bn.getLabel().setVisible(false);
					//game1.jpanel1.remove(bn.getLabel());
        			game1.number.removeElementAt(i);
        			game1.addScore();
        			System.out.print(game1.score+" ");
        			break;
        		}
        	}
        	if(game1.score == 10 || myThread.fail==1){
        		JOptionPane.showMessageDialog(null, "您的得分为"+game1.score, "游戏结束！", JOptionPane.PLAIN_MESSAGE);
        		System.exit(0);
        	}
        }
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
