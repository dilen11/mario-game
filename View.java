import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
//----------------------------------------------------------------------
//--------------------the view class it will extends j panel---------

class View extends JPanel
{
	
	
	
	Model model;	
	JButton b1;
	//Controller cr;
	
	int scrollPos = 0;
	//static BufferedImage tube_image;
	static 	BufferedImage[] marioi;
	Tube tube;
	


	View(Controller c, Model m)
	{
	//cr = c;
	model = m;
	marioi = new BufferedImage[5];
	//------ this function will load image to our mamory but it will not help at all
	//---to load in the programme because it will create the memory location only
	
	//tube_image = loadImage("tube.png");
	marioi[0] = loadImage("mario1.png");
	marioi[1] = loadImage("mario2.png");
	marioi[2] = loadImage("mario3.png");
	marioi[3] = loadImage("mario4.png");
	marioi[4] = loadImage("mario5.png");
	}
	
	//----------------------------------------------------------------------------------------
    //-------------this function will helps us to load image in our programme-----------------
	static BufferedImage loadImage(String  filename) // load the filename of the program
	{
		BufferedImage im = null;  // bufferimage is not inicilized to anything so it shoululd be inicilized to somethiong
		try 
		{
			im = ImageIO.read(new File(filename));   // this will r
		}
		catch (Exception e )
		{
		  e.printStackTrace(System.err);
		  System.exit(1);
		}       
	return im;
		}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor( new Color(0,0,0));
		g.drawLine(0, 400,1000, 400);
		
		for (int i = 0; i < model.tubes.size(); i++)
		{
			Tube t = model.tubes.get(i);
			
			
			g.drawImage(t.tube_image, t.x + 200 - model.mario.x+ model.mario.w, t.y, null);
			
			
		}
		g.drawImage(marioi[model.mario.frame], 200, model.mario.y -model.mario.h, null);
	}
	
		
		
		/*
		for(int i = findFirstTubeOnScreen(); i < model.tubes.size(); i++)
		{
			Tube t = model.tubes.get(i);
			g.drawImage(tube_image, t.x - scrollPos, t.y, null);
		}
		if (cr.keyRight || cr.keyLeft)
		{
		g.drawImage(marioi[model.mario.frame], 200 , model.mario.y, null);
		}
		else 
		{
		g.drawImage(marioi[0], 200, model.mario.y, null);
		}
		g.setColor(Color.gray);
		g.drawLine(0, 495, 2000, 495);
		}	
		
		
		*/
		//g.drawImage(this.turtle_image, model.turtle_x, model.turtle_y, null);
	
	//-------------------------------------------------------------------------------------------------
	//--------removeButton------------------------------------------------------------------------------
	

	void removeButton()
	{
		this.remove(b1);
		this.repaint();
	}
	//--------------------------------------------------------------//
// this is the scroll object ---------------------------//

	int findFirstTubeOnScreen(){
	int start = 0;
	int end = model.tubes.size();
	while(true)
	{
		int mid = (start + end) / 2;
		if(mid == start)
			return start;
		Tube t = model.tubes.get(mid);
		if(t.x - model.mario.x < -100)
			start = mid;
		else
			end = mid;
	}
	}
	}
