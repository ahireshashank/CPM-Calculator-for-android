package com.example.keyboardvaluelog;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText t1;
	
	File dir,file,file2;
	String filePath,date;
	Double  cpm;
	float cpm1;
	int array1;
	char  a,b;
	long chartime;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		chartime=0;
		
		t1	= (EditText)findViewById(R.id.myedit_text);
		
		filePath 		= Environment.getExternalStorageDirectory().getAbsolutePath() + "/keyLogData";
		dir				= new File(filePath);
		//final Long chartime = System.currentTimeMillis();
		
		if(!dir.exists()){
        	dir.mkdirs();
        }
        file				= new File(dir, "keyboard_log.txt");
        
        file2                =new File(dir,"charlog.txt");
        
      /* String txt = t1.getText().toString();
    	final String[] txtArray = txt.split("(?!^)");
    	
    	for(int i = 0; i < txtArray.length; i++){

    		Log.d("debug",i+"='"+txtArray[i]+"'");
    		
    		}
    	final int Arraylenght=txtArray.length;*/
    	
    	//final String array = txtArray.toString() ;

        
        t1.addTextChangedListener(new TextWatcher() {
			
			

			
		
			
			
			
			@Override
	     public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				if(chartime==0){
					Log.d("debug","set char time: "+System.currentTimeMillis());
					chartime = System.currentTimeMillis();
				}
				
				Log.d("debug","In onTextChanged():"+s.toString());
				char a = s.charAt(0);
				
				
				
		        char b = s.charAt(s.length()-1);
		        
		       // String charalpha =  +a 
//		        String txt = s.toString();
//		    	final String[] txtArray = txt.split("(?!^)");
		    	
		    	/*Print contents of array
		    	 * for(int i = 0; i < txtArray.length; i++){

		    		Log.d("debug",i+"='"+txtArray[i]+"'");
		    		
		    		}*/
//		    	final int Arraylenght=txtArray.length;
		      	
		        
				if(s.length()>1){
					Log.d("debug","In onTextChanged(): slength >1");
					char c = s.charAt(s.length()-1);
					
					
					
					
					//Log.e("test",""+c);
					try
					   {
					
						SimpleDateFormat outputFormat	= new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS");
						
						Calendar cal1 = Calendar.getInstance();
						date = outputFormat.format(cal1.getTime()).toString();
						
					//	long First = +a+ +System.currentTimeMillis(); 
						//   long Last = +b+    +System.currentTimeMillis();
						  // total = +First+ - +Last;
					   
						
						String key	= "Pressed Key Code:"+c+" Current Time:"+System.currentTimeMillis();
					   String typed = "First char" +a+     "Time" +chartime+   "      Last char" +b+ "Time" +System.currentTimeMillis();
					   
					//final    long total =  System.currentTimeMillis() - chartime;
					   
					   Log.d("debug","final char time: "+System.currentTimeMillis());
					   
				      
				      
				   //    Log.d("debug","# of chars: " + Arraylenght + ", total time: "+total + ", cpm: "+cpm + " [time taken :"+ (total/(60*1000))+ "mins]");
					   
				       FileOutputStream fout = new FileOutputStream(file,true);
				       //FileOutputStream f2out = new FileOutputStream(file2,true);
				       OutputStreamWriter foutWriter = new OutputStreamWriter(fout);
				//       OutputStreamWriter f2outWriter = new OutputStreamWriter(f2out);
				    
				      
		               foutWriter.write("\n"+key);				       
				       foutWriter.close();				       
//				       fout.close();
//				       array1 = (Arraylenght-1) *60 ;
//					      
//					      cpm= array1 ;
//					      final    long total =  System.currentTimeMillis() - chartime;
//					     cpm1  = cpm/total;
					     
					     
					//     f2outWriter.write( "CPM =" +cpm1 );
				       
				       
				   //    f2outWriter.write("/n"+typed+ "TotalTime:  "+total+ "CPM =" +cpm1 );
				     //  Log.d("debug","# of chars: " + Arraylenght + ", total time: "+total + ", cpm: "+cpm + " [time taken :"+ (total/(60*1000))+ "mins]");
				    //   f2outWriter.close();
				      // f2out.close();
				       
				       
				       
				       
				       try{
				    	   
				    	  
				    	   
				    	   String txt = s.toString();
					    	final String[] txtArray = txt.split("(?!^)");
					    	 final int Arraylenght=txtArray.length;
				    	   
				    	   
				    	   array1 = (Arraylenght-1)  ;
						      
						      cpm= (double) array1 ;
						      final    long total =  (System.currentTimeMillis() - chartime);
						     cpm1  = (float) (cpm/total)*60000;
				    	   
				    	   
				    	   
				       FileOutputStream f2out = new FileOutputStream(file2,true);
					      OutputStreamWriter f2outWriter = new OutputStreamWriter(f2out);
						 f2outWriter.write( "CPM =" +cpm1 );
						 f2outWriter.write( "Arrayleng=" +array1);
						 f2outWriter.write( "total =" +total);
						 
						 f2outWriter.close();
					       f2out.close();
				       }
				       
				       
				       catch(IOException e)
				       {
				    	   
				       }
				    } catch(Exception e)
				    {
				    	Log.v("WRITE", "problem"+e);
				    }
					
				/*	FileOutputStream f2out = new FileOutputStream(file2,true);
				      OutputStreamWriter f2outWriter = new OutputStreamWriter(f2out);
					 f2outWriter.write( "CPM =" +cpm1 );
					 f2outWriter.close();
				       f2out.close();*/
				       
					
					
					
					
					
				}else if(s.length()==1){
					char c = s.charAt(0);
					
					
					//Log.e("test",""+c);
					try
					   {
						   
					   String key	= "Pressed Key Code:"+c+" Current Time:"+System.currentTimeMillis();
					   String typed = "First character "+a+" last character"+b;
					   
				       FileOutputStream fOut = new FileOutputStream(file,true);
				       FileOutputStream cout = new FileOutputStream(file2,true);
				       
				       OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
				       OutputStreamWriter CoutWriter = new OutputStreamWriter(cout);
				       CoutWriter.write("/n"+typed);
				       myOutWriter.write("\n"+key);
				       myOutWriter.close();
				       CoutWriter.close();
				       fOut.close();
				       cout.close();
				    } catch(Exception e)
				    {

				    }
				}
				
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				/*Log.e("test",""+s.charAt(s.length()-1));
				
				Log.e("test",""+s.length());*/
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				/*char c = s.charAt(s.length()-1);
				Log.e("test",""+c);
				try
				   {
					   
				   String key	= "Pressed Key Code:"+c+" Current Time:"+System.currentTimeMillis();
				   
			       FileOutputStream fOut = new FileOutputStream(file,true);
			       OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
			       myOutWriter.write("\n"+key);
			       myOutWriter.close();
			       fOut.close();
			    } catch(Exception e)
			    {

			    }*/
			}
		});
        
		
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
