import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
//---------------------------------------------------------------
//--------------------this is a model class----------------------

class Model
{ 
	int dest_x;
	int dest_y;
	Mario mario;
	ArrayList<Tube> tubes;
	
//---------------------------------------------------------------
//------------------------------this is a model constructor -----	  
 
	Model()
	{
		tubes = new ArrayList<Tube>();
		mario = new Mario();
	}
//--------------------------------------------------------------------------
//----------------------this is a update function------------------------	
	public void update()
	{ 
		mario.update();	
		for (Iterator <Tube> it = tubes.iterator(); it.hasNext(); )
		{ 
			Tube t = it.next();
		if (doIntersect ( mario.x - mario.w , mario.y, mario.w, mario.h,
					 t.x, t.y, t.w, t.h))// this is colliosion detect)
			mario.getOutOfTheTube(t);
		}
	}
	
//--------------------------------------------------------------------
//---------------------------this is a remove tube function------------

	void removeTube(int position)

	
	{
		tubes.remove(position);
	}
//----------------------------------------------------------------------------------------------
//----this is a marshal class------------------------------------------------------------	
	Json marshal()
     {
        Json ob = Json.newObject();
		
		ob.add("dest_x", dest_x);
		ob.add("dest_y", dest_y);
		Json tubesList = Json.newList();
		ob.add("tubes",tubesList);
        for(int i = 0; i < tubes.size(); i++)
        tubesList.add(tubes.get(i).marshal());
   
		return  ob;
     }	
	//--------------------------------------------------------------------------------------------//
	//--------this will unmarshal the tube-------------------------------------------------------//
	
	 void unmarshal (Json ob) 
	 {	  
		 tubes = new ArrayList <Tube> ();
		 Json jsonList = ob.get("tubes");
		 for (int i = 0; i < jsonList.size(); i++)
		 {
		 tubes.add(new Tube(jsonList.get(i)));
			 
		 }	 
		 }	
//-------------------------------------------------------------------------------------------------------//
//--------this will set the destination of the tube-----------------------------------------------------//
	
	public void setDestination(int x, int y)
	{
		this.dest_x = x;
		this.dest_y = y;
	}
	
//---------------------------------------------------------------------------------------------------//
//------------ this function will make new tube -------------------------------------------------------------------//
//   	
	/*
	  void make_Tube ()
	  {  
		Tube t = new Tube(dest_x, dest_y);
		tubes.add(t);
	 TubeComparator tc = new TubeComparator();
       tubes.sort(tc);
	  }
	/*   
       for(int i = 0; i < tubes.size(); i++)
           System.out.println("X-Cordi: " + tubes.get(i).x);
		System.out.println("------------------------------------------------------------");
	  }
	 */ 
	  
//--------------------------------------------------------------------------------------------//
//--------------this is mouse click function -------------------------------------------------//	    
  void mouse_click(int x , int y )
  {
	  
	boolean  theTubeIsclicked = false;
	  for (int i = 0; i  < tubes.size(); i++)
	  {
		  
		  Tube t = tubes.get(i);
		  if (t.isThatClickInMe(x, y))
	   {
			  theTubeIsclicked = true;
			  removeTube(i);
			  return;
	  }
	  }
	  if(!theTubeIsclicked)
	  {
		  Tube t = new Tube(x, y);
			tubes.add(t);
		 TubeComparator tc = new TubeComparator();
	       tubes.sort(tc);
	  }  
       }
//---------------------------------------------------------------------------
//-----------------treaky buisness -------------------------------------------
	
// this is a collision dictator function
 
    public static boolean doIntersect ( int x1, int y1,
    		int w1, int h1, int x2, int y2, int w2, int h2)    // this is colliosion detection functon
    	{   	
	if (x1 + w1 < x2) return false ;
	if (x1 > x2 + w2) return false ;
	 if (y1 + h1 < y2) return false ;
	 if (y1 + y2 < h2) return false ;
	 return true;
    	}

void rememberState()

{
	mario.remember_state();
}

}

//----------------------------------------------------------------------------------
//--------------------this is a tube comprator--------------------------------------

class TubeComparator implements Comparator<Tube>
{
	public int compare(Tube a, Tube b)
	{
		if(a.x < b.x)
			return -1;
		else if(a.x > b.x)
			return 1;
		else
			return 0;
	}

	public boolean equals(Object ob)
	{
		return false;
	}
	
	
	
}

   




