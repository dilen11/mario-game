import java.awt.image.BufferedImage;
import java.util.ArrayList;
 class Mario
{
	
	int x;
	int y;
	final   int w = 65; // mario image hight
	final   int h = 90;  //marip image hight 
	
	int prev_x;
	int prev_y;
	
	double vert_velocity;
	int frame;  // this is frame object 
	int dist;  // this is a distance object 
	int jFlyJUmp;
	static 	BufferedImage[] marioi;
	Mario()
	{
		
		x = 200;  // the position of mario it falls to graoudn
		y = 200;   // y position of mario it falls to ground

		vert_velocity = -12.0; // this is the vertical velocity of the mario it falls in the scren 
		
		marioi = new BufferedImage[5];
		marioi[0] = View.loadImage("mario1.png");
		marioi[1] = View.loadImage("mario2.png");
		marioi[2] = View.loadImage("mario3.png");
		marioi[3] = View.loadImage("mario4.png");
		marioi[4] = View.loadImage("mario5.png");
		
		
		
}
	 
	//final static int  w = 95;
	//final static int  h = 95;
	
//-----------------this is a mario constuctor--------
	
	void jump()
	 {
		vert_velocity =-30;	 
		
	 }
	
	void remember_state()
	{
		prev_x = x;
		prev_y = y;
	}
	
void getOutOfTheTube(Tube t) {
	
    {
        if(x > t.x && prev_x <= t.x) // if he crossed the left side of the tube
        {
            x = t.x;
        }
        else if(x - w < t.x + t.w && prev_x - w >= t.x + t.w) // if he crossed the right side
        {
            x = t.x + t.w + w;
        }
        else if(y > t.y && prev_y <= t.y) // if he crossed the top of the tube
        {
            y = t.y;
        }
        else if(y - h < t.y + t.h && prev_y - h >= t.y + t.h) // if he crossed the bottom
        {
            y = t.y + t.h + h;
        }
        else
            System.out.println("How did I get in here?");
    }
		}	

		

//-----------------
	void update ()
	
	{	// -----------------------------------------------------------
		//--------------this code will change the verticl velocity-----
		
		vert_velocity += 9;  // it wll update the vertical velocity 
		y += vert_velocity;  // it will makes changes with the verticval velocity 
		if (y  >= 400)       // when the position of the erticvl velocity reaches to 400 it will stop and bounces 
		
		{
		vert_velocity = 0.0; 
		y = 400;
		// it will decreses the vertical velocuity and makes it move to the upward directon 	
   frame++;    
		if (frame > 4 )
		{
			frame = 0;
		}	
		}
		}
		}

