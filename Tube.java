import java.awt.image.BufferedImage;

//-------------------------------------------------------------------------------------------------------
//------------------------------This is a Tube Class ---------------------------------------------------
class Tube
 {
	int x;   
	int y;
	int w = 55;
	int h = 400;
	 static BufferedImage tube_image = null;
	 
//---------------------------------------------------------------------------------------------------------
//----------------------this is a tube constructor which initializes its two parameters to  its components 	
	
	Tube (int x_Comp, int y_Comp)
	{
		x = x_Comp;
		y = y_Comp;
		
		if (tube_image == null)
		{
		
		tube_image = View.loadImage("tube.png");
		}
		
	}
		
	
	
	
//----------------------------------------------------------------------------------------------
//--------------this constructor helps us to store Marshall file in the programmer-----------		
		 
	Tube (Json ob)
	{
		    x = (int )ob.getLong("x");
			y = (int )ob.getLong("Y");
	}
// ------------------------------------------------------------------------------------------------
//--------------------------this is a marshal constructor----------------------------------------

    Json marshal()
     {
        Json ob = Json.newObject();
		
		ob.add("x",x);
		ob.add("Y",y);
		
		return ob;	
			
	 }
//------------------------------------------------------------------------------------
//-----------------------------this function clicks on me---------------------------	 
	
	boolean isThatClickInMe ( int click_x, int click_y )
	
	{
		
		// click on the left side of tube  click x is the position in the screen and x is the position of tube 
		if(click_x < x )  return false;
		
		// click on right side of tube 
		if (click_x > x + w ) return false;
		if (click_y < y)  return false;
		if (click_y > y + h) return false;
		
		return true;
	
	}
}