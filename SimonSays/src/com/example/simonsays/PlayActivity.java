package com.example.simonsays;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.example.simonsays.R.layout;
import android.os.Bundle;
import android.os.Handler;
import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends Activity
{
    TableLayout tableLay;
    private List<Objects> pickedobjects = new ArrayList<Objects>();  
    private ImageButton[] currentButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        
        //index for keys from config
        //getIntent().getExtras().getString("user");
        //getIntent().getExtras().getString("numOfObjects");
        //getIntent().getExtras().getString("square");
        //getIntent().getExtras().getString("triangle");
        //getIntent().getExtras().getString("circle");
        //getIntent().getExtras().getString("red");
        //getIntent().getExtras().getString("blue");
        //getIntent().getExtras().getString("green");
        //getIntent().getExtras().getString("purple");
        //getIntent().getExtras().getString("orange");
        //getIntent().getExtras().getString("yellow");
        //getIntent().getExtras().getString("layout");
        //getIntent().getExtras().getString("objectSize");             
        
        
        int numOfObjects = Integer.parseInt(getIntent().getExtras().getString("numOfObjects"));
        String[] color = getColors();
        String size = (String) getIntent().getExtras().get("objectSize");
       // String size = getIntent().getExtras().getString("objectSize");
        String[] shape = getShapes();
        populateList(numOfObjects, color, size, shape);
        Score score = new Score(numOfObjects);
        Player player = new Player(getIntent().getExtras().getString("user"), score);

        AI testAI = new AI(pickedobjects, this);
        
        //TextView;
        
//        testAI.addNewShapeToList();
//        testAI.addNewShapeToList();
//        testAI.addNewShapeToList();      
//        
        if(getIntent().getExtras().getString("layout").contains("grid"))
        {
            Grid g = new Grid(pickedobjects,numOfObjects,this);
            g.createGrid();
            setcurrentButtons(g.getButtons());
        }
        if(getIntent().getExtras().getString("layout").contains("diamond"))
        {
            Diamond d = new Diamond(pickedobjects,numOfObjects,this);
            d.createDiamond();
            setcurrentButtons(d.getButtons());
        }
        testAI.setbuttons(currentButtons);
        testAI.addNewButtonToPattern();
        testAI.showPattern();

    }// end of onCreate
    public static int getImageId(Context context, String imageName) 
    {        
        return context.getResources().getIdentifier("R.drawable." + imageName, null, context.getPackageName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.play, menu);
        return true;
    }
    
    private String[] getColors()
    {
        String[] result;
        int size = 0;
        int currentIndex = 0;
        if(getIntent().getExtras().getString("red") != null)
        {
            size++;
        }
        if(getIntent().getExtras().getString("blue") != null)
        {
            size++;
        }
        if(getIntent().getExtras().getString("green") != null)
        {
            size++;
        }
        if(getIntent().getExtras().getString("purple") != null)
        {
            size++;
        }
        if(getIntent().getExtras().getString("orange") != null)
        {
            size++;
        }
        if(getIntent().getExtras().getString("yellow") != null)
        {
            size++;
        }
        
        result = new String[size];

        if(getIntent().getExtras().getString("red") != null)
        {
            result[currentIndex] = "red";
            currentIndex++;
        }
        if(getIntent().getExtras().getString("blue") != null)
        {
            result[currentIndex] = "blue";
            currentIndex++;
        }

        if(getIntent().getExtras().getString("purple") != null)
        {
            result[currentIndex] = "purple";
            currentIndex++;
        }
        if(getIntent().getExtras().getString("orange") != null)
        {
            result[currentIndex] = "orange";
            currentIndex++;
        }
        if(getIntent().getExtras().getString("yellow") != null)
        {
            result[currentIndex] = "yellow";
            currentIndex++;
        }
        if(getIntent().getExtras().getString("green") != null)
        {
          result[currentIndex] = "green";
          currentIndex++;
        }        
        return result;
    }
    
    private String[] getShapes()
    {
        String[] result;
        int size = 0;
        int currentIndex = 0;
        if(getIntent().getExtras().getString("square") != null)
        {
            size++;
        }
        
        if(getIntent().getExtras().getString("triangle") != null)
        {
            size++;
        }
        
        if(getIntent().getExtras().getString("circle") != null)
        {
            size++;
        }
        
        result = new String[size];
        
        if(getIntent().getExtras().getString("square") != null)
        {
            result[currentIndex] = "square";
            currentIndex++;
        }
        
        if(getIntent().getExtras().getString("triangle") != null)
        {
            result[currentIndex] = "triangle";
            currentIndex++;
        }
        
        if(getIntent().getExtras().getString("circle") != null)
        {
            result[currentIndex] = "circle";
            currentIndex++;
        }
        
        return result;
    }
    
    public void populateList(int num, String[] color, String size, String[] shape)
    {
        Random r = new Random();
        for(int i = 0; i < num; i++)
        {         
            int j = r.nextInt(color.length);
            int k = r.nextInt(shape.length);
            pickedobjects.add(new Objects(shape[k], color[j], size, i));
        }       
    }
    
    public void setcurrentButtons(ImageButton[] ibarray)
    {
        currentButtons = ibarray;
    }
    
    

}
