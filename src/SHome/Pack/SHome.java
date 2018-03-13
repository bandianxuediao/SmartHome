package SHome.Pack;

import java.io.IOException;
import SHome.Pack.Preconfig;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;


import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import SHome.Pack.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;
 

public class SHome extends Activity implements OnGestureListener {
    /** Called when the activity is first created. */
	private Button BtnRelay[];
	private String BtnText[];
	private boolean	BtnStatus[];
	private ViewFlipper myViewFlipper;  
	private GestureDetector myGestureDetector; 
	
	private Button Btn;
	private String	m_sPort;
	private String  m_sIp; 
	private int		m_ComAddr;
	byte LightA[]={0x01,0x05,(byte)0xce,(byte)0x81,0x01,0x00};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        BtnRelay = new Button[15];
        BtnText = new String[15];
        BtnStatus = new boolean[15];
        BtnRelay[0]=(Button)findViewById(R.id.Button01);  
        BtnRelay[0].setOnClickListener(LameClick);
        BtnRelay[1]=(Button)findViewById(R.id.Button02);  
        BtnRelay[1].setOnClickListener(LameClick);
        BtnRelay[2]=(Button)findViewById(R.id.Button03);  
        BtnRelay[2].setOnClickListener(LameClick);
        BtnRelay[3]=(Button)findViewById(R.id.Button04);  
        BtnRelay[3].setOnClickListener(LameClick);
        BtnRelay[4]=(Button)findViewById(R.id.Button05);  
        BtnRelay[4].setOnClickListener(LameClick);
        BtnRelay[5]=(Button)findViewById(R.id.Button06);  
        BtnRelay[5].setOnClickListener(LameClick);        
        BtnRelay[6]=(Button)findViewById(R.id.Button07);  
        BtnRelay[6].setOnClickListener(LameClick);
        BtnRelay[7]=(Button)findViewById(R.id.Button08);  
        BtnRelay[7].setOnClickListener(LameClick);        
        BtnRelay[8]=(Button)findViewById(R.id.Button09);  
        BtnRelay[8].setOnClickListener(LameClick);
        BtnRelay[9]=(Button)findViewById(R.id.Button10);  
        BtnRelay[9].setOnClickListener(LameClick);        
        BtnRelay[10]=(Button)findViewById(R.id.Button11);  
        BtnRelay[10].setOnClickListener(LameClick);
        BtnRelay[11]=(Button)findViewById(R.id.Button12);  
        BtnRelay[11].setOnClickListener(LameClick);        
        
        
        
        BtnRelay[13]=(Button)findViewById(R.id.Button13);  
        BtnRelay[13].setOnClickListener(LameClick);   
        BtnRelay[14]=(Button)findViewById(R.id.Button14);  
        BtnRelay[14].setOnClickListener(LameClick);   
  

    //    myViewFlipper = (ViewFlipper) findViewById(R.id.ViewFlipper01); 
        myGestureDetector =new GestureDetector(this);

        m_sPort = Preconfig.getHostPort(this);
        m_sIp = Preconfig.getHostIp(this);
        m_ComAddr = Integer.parseInt(Preconfig.getDevAddr(this));
        for(int i=0;i<15;i++)
        {
        	BtnText[i] = "";
        	BtnStatus[i] = false;
        }
        

        
        
       ReadText();
 //       BtnRelay[3].setText("全开继电器");
 //       BtnRelay[4].setText("全关继电器");
        
    } 
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { 
       
        	ReadText();

        super.onActivityResult(requestCode, resultCode, data); 
    } 
    public void UpdateButtonText1(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn1k);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn1g);
   
    }
    public void UpdateButtonText2(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn2k);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn2g);
   
    }   
    public void UpdateButtonText3(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn3k);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn3g);
   
    } 
    public void UpdateButtonText4(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn4k);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn4g);
   
    }    
    public void UpdateButtonText5(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn5k);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn5g);
   
    }    
    public void UpdateButtonText6(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn6k);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn6g);
   
    }    
    public void UpdateButtonText7(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn7k);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn7g);
   
    }    
    public void UpdateButtonText8(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn8k);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn8g);
   
    }    
    public void UpdateButtonText9(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn9k);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn9g);
   
    }    
    public void UpdateButtonText10(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn10k);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn10g);
   
    }    
    public void UpdateButtonText11(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn11k);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn11g);
   
    }    
    public void UpdateButtonText12(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn12k);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.btn12g);
   
    }
    public void UpdateButtonText13(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.bhzt);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.qbbh);
   
    }    
    public void UpdateButtonText14(int nChannel,String str)
    {
//    	BtnRelay[nChannel].setText(Preconfig.getRelayText(this, nChannel+1)+str);
    	if(str == "-ON")
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.dkzt);
    	else
    		BtnRelay[nChannel].setBackgroundResource(R.drawable.qbdk);
   
    }    
    
    
    public OnClickListener LameClick=new OnClickListener() {       
        @Override
        public void onClick(View v) {   
        	Btn = (Button)v;
        	switch(Btn.getId())
        	{
	        	case R.id.Button01:	//可调灯
	        	{
	        		if(BtnStatus[0] == false)
	        		{
	        			BtnStatus[0]=true;
	        			if(SendCode(0,1));
//	        				ReadStatus();
	        				UpdateButtonText1(0,"-ON");
	        		}else{
	        			BtnStatus[0]=false;
	        			if(SendCode(0,0));
//	        				ReadStatus();
	        				UpdateButtonText1(0,"-OFF");
	        		}
	        		break;
	        	}
	        	case R.id.Button02:	//可调灯
	        	{
	        		if(BtnStatus[1] == false)
	        		{
	        			BtnStatus[1]=true;
	        			if(SendCode(1,1));
//	        				ReadStatus();
	        				UpdateButtonText2(1,"-ON");
	        		}else{
	        			BtnStatus[1]=false;
	        			if(SendCode(1,0));  
//	        				ReadStatus();
	        				UpdateButtonText2(1,"-OFF");
	        		}
	        		break;
	        	}
	        	case R.id.Button03:	//开面板
	        	{
	        		if(BtnStatus[2] == false)
	        		{
	        			BtnStatus[2]=true;
	        			if(SendCode(2,1));
//	        				ReadStatus();
	        				UpdateButtonText3(2,"-ON");
	        		}else{
	        			BtnStatus[2]=false;
	        			if(SendCode(2,0)) ; 
//	        				ReadStatus();
	        				UpdateButtonText3(2,"-OFF");
	        		}
	        		break;
	        	}
	        	case R.id.Button04:	//关面板
	        	{
	        		if(BtnStatus[3] == false)
	        		{
	        			BtnStatus[3]=true;
	        			if(SendCode(3,1));
//	        				ReadStatus();
	        				UpdateButtonText4(3,"-ON");
	        		}else{
	        			BtnStatus[3]=false;
	        			if(SendCode(3,0)) ; 
//	        				ReadStatus();
	        				UpdateButtonText4(3,"-OFF");
	        		}
	        		break;
	        	}
	        	case R.id.Button05:	//关面板
	        	{
	        		if(BtnStatus[4] == false)
	        		{
	        			BtnStatus[4]=true;
	        			if(SendCode(4,1));
//	        				ReadStatus();
	        				UpdateButtonText5(4,"-ON");
	        		}else{
	        			BtnStatus[4]=false;
	        			if(SendCode(4,0));  
//	        				ReadStatus();
	        				UpdateButtonText5(4,"-OFF");
	        		}
	        		break;
	        	}
	        	case R.id.Button06:	//关面板
	        	{
	        		if(BtnStatus[5] == false)
	        		{
	        			BtnStatus[5]=true;
	        			if(SendCode(5,1));
//	        				ReadStatus();
	        				UpdateButtonText6(5,"-ON");
	        		}else{
	        			BtnStatus[5]=false;
	        			if(SendCode(5,0));  
//	        				ReadStatus();
	        				UpdateButtonText6(5,"-OFF");
	        		}
	        		break;
	        	}	        	
	        	
	        	case R.id.Button07:	//关面板
	        	{
	        		if(BtnStatus[6] == false)
	        		{
	        			BtnStatus[6]=true;
	        			if(SendCode(6,1));
//	        				ReadStatus();
	        				UpdateButtonText7(6,"-ON");
	        		}else{
	        			BtnStatus[6]=false;
	        			if(SendCode(6,0));  
//	        				ReadStatus();
	        				UpdateButtonText7(6,"-OFF");
	        		}
	        		break;
	        	}	        	

	        	case R.id.Button08:	//关面板
	        	{
	        		if(BtnStatus[7] == false)
	        		{
	        			BtnStatus[7]=true;
	        			if(SendCode(7,1));
	        				UpdateButtonText8(7,"-ON");
	        		}else{
	        			BtnStatus[7]=false;
	        			if(SendCode(7,0));
	        				UpdateButtonText8(7,"-OFF");
	        		}
	        		break;
	        	}	        	
	        	
	        	case R.id.Button09:	//关面板
	        	{
	        		if(BtnStatus[8] == false)
	        		{
	        			BtnStatus[8]=true;
	        			if(SendCode(8,1));
	        				UpdateButtonText9(8,"-ON");
	        		}else{
	        			BtnStatus[8]=false;
	        			if(SendCode(8,0));
	        				UpdateButtonText9(8,"-OFF");
	        		}
	        		break;
	        	}	        	
	        	
	        	case R.id.Button10:	//关面板
	        	{
	        		if(BtnStatus[9] == false)
	        		{
	        			BtnStatus[9]=true;
	        			if(SendCode(9,1));
	        				UpdateButtonText10(9,"-ON");
	        		}else{
	        			BtnStatus[9]=false;
	        			if(SendCode(9,0));
	        				UpdateButtonText10(9,"-OFF");
	        		}
	        		break;
	        	}	        	
	        	case R.id.Button11:	//关面板
	        	{
	        		if(BtnStatus[10] == false)
	        		{
	        			BtnStatus[10]=true;
	        			if(SendCode(10,1));
	        				UpdateButtonText11(10,"-ON");
	        		}else{
	        			BtnStatus[10]=false;
	        			if(SendCode(10,0));
	        				UpdateButtonText11(10,"-OFF");
	        		}
	        		break;
	        	}	        	
	        	
	        	case R.id.Button12:	//关面板
	        	{
	        		if(BtnStatus[11] == false)
	        		{
	        			BtnStatus[11]=true;
	        			if(SendCode(11,1));
	        				UpdateButtonText12(11,"-ON");
	        		}else{
	        			BtnStatus[11]=false;
	        			if(SendCode(11,0));
	        				UpdateButtonText12(11,"-OFF");
	        		}
	        		break;
	        	}	        	
	        	
	        	
	        	case R.id.Button13:	//关面板
	        	{
	        		if(BtnStatus[12] == false)
	        		{
	        			BtnStatus[12]=true;
	        			if(SendCode(255,255));
//	        				ReadStatus();
//	        			BtnStatus[5]=false;
//        				UpdateButtonText13(12,"-ON");
	        		}
	        		else{
	        			BtnStatus[12]=false;
	        			if(SendCode(255,255));  
//	        				ReadStatus();
//	        				UpdateButtonText13(12,"-OFF");
	        		}
	        		break;
	        	}
	        	case R.id.Button14:	//关面板
	        	{
	        		if(BtnStatus[13] == false)
	        		{
	        			BtnStatus[13]=true;
	        			if(SendCode1(0,16));
//	        				ReadStatus();
//	        				UpdateButtonText14(13,"ON");
	        		}
	        		else{
	        			BtnStatus[13]=false;
	        			if(SendCode1(0,16));  
//	        				ReadStatus();
//	        				UpdateButtonText14(13,"-OFF");
	        		}
	        		break;
	        	}	        	
	        	
	        	


//		        case R.id.Button19:	
//	        	{
//	        		ReadStatus();
//	        		break;
//	        	}
        	}
        }
    };
    private void ReadText()
    {
    	for(int i=0;i<12;i++)
    	{
    		BtnRelay[i].setText(Preconfig.getRelayText(this, i+1)+BtnText[i]);
     	}

    }
    private void UpdateButton(int nData)
    {
    	for(int i=0;i<12;i++)
    	{
	    	if((nData & (1<<i))==0)
	    	{
	    		UpdateButtonText10(i,"OFF");
	    		BtnStatus[i]=false;
	    	}else{
	    		
	    		UpdateButtonText10(i,"ON");
	    		BtnStatus[i]=true;
	    	}
    	}
    	
    }
    
    //发送网络数据
    private boolean SendCode1(int nCmd,int addr)
    {     

				Socket sck;
				byte[] bSendCode = new byte[6];
				bSendCode[0] = (byte)m_ComAddr;
				bSendCode[1] = 0x06;
				bSendCode[2] = (byte)nCmd;
				bSendCode[3] = (byte)addr;
				bSendCode[4] = (byte)0xae;
				bSendCode[5] = (byte)0x81;
				//bSendCode[6] = (byte)(bSendCode[3]^bSendCode[4]^bSendCode[5]);
				//Toast t2 =Toast.makeText(getApplicationContext(), m_sIp, Toast.LENGTH_SHORT);
				//t2.show();
				try {
					int nPort = Integer.parseInt(m_sPort);					
					sck = new Socket();
					SocketAddress isa = new InetSocketAddress(m_sIp, nPort);     
					sck.connect(isa, 4000);
				
    				InputStream in = sck.getInputStream();
    				OutputStream out = sck.getOutputStream();
    				 
    				out.write(bSendCode);
    				//out.flush();  	
    					  				
    				byte [] buffer = new byte[12]; 
    				//读返回指令
    				int temp = in.read(buffer);
    				if(temp<=0)
    				{
    					Toast t1 =Toast.makeText(getApplicationContext(), "读发送返回码失败!", Toast.LENGTH_SHORT);
    					t1.show();
    					in.close();
    					out.close();  
    					sck.close();
    					return false;
    				}
    				in.close();
    				out.close();  
    				sck.close();
    	
    				return true;
				} catch (IOException e) {
					e.printStackTrace();
					Toast t1 =Toast.makeText(getApplicationContext(), "连接服务器失败!请检查IP地址和端口！", Toast.LENGTH_SHORT);
    				t1.show();
				} 
				
				return false;
            }     
    
    
    
    
    
    
    
    
    //发送网络数据
    private boolean SendCode(int nCmd,int addr)
    {     

				Socket sck;
				byte[] bSendCode = new byte[6];
				bSendCode[0] = (byte)m_ComAddr;
				bSendCode[1] = 0x05;
				bSendCode[2] = (byte)nCmd;
				bSendCode[3] = (byte)addr;
				bSendCode[4] = (byte)0xae;
				bSendCode[5] = (byte)0x81;
				//bSendCode[6] = (byte)(bSendCode[3]^bSendCode[4]^bSendCode[5]);
				//Toast t2 =Toast.makeText(getApplicationContext(), m_sIp, Toast.LENGTH_SHORT);
				//t2.show();
				try {
					int nPort = Integer.parseInt(m_sPort);					
					sck = new Socket();
					SocketAddress isa = new InetSocketAddress(m_sIp, nPort);     
					sck.connect(isa, 4000);
				
    				InputStream in = sck.getInputStream();
    				OutputStream out = sck.getOutputStream();
    				 
    				out.write(bSendCode);
    				//out.flush();  	
    					  				
    				byte [] buffer = new byte[12]; 
    				//读返回指令
    				int temp = in.read(buffer);
    				if(temp<=0)
    				{
    					Toast t1 =Toast.makeText(getApplicationContext(), "读发送返回码失败!", Toast.LENGTH_SHORT);
    					t1.show();
    					in.close();
    					out.close();  
    					sck.close();
    					return false;
    				}
    				in.close();
    				out.close();  
    				sck.close();
    	
    				return true;
				} catch (IOException e) {
					e.printStackTrace();
					Toast t1 =Toast.makeText(getApplicationContext(), "连接服务器失败!请检查IP地址和端口！", Toast.LENGTH_SHORT);
    				t1.show();
				} 
				
				return false;
            } 
    
  	 public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
  	   float velocityY) {
  		 if(e1.getX()-e2.getX()>100){
   			Intent intent = new Intent(SHome.this, Preconfig.class);
  			//SHome.this.startActivity(intent);
  			startActivityForResult(intent, 1);
  			 return true;
  	  }else if(e1.getX()-e2.getX()< -100){
			Intent intent = new Intent(SHome.this, Preconfig.class);
  			//SHome.this.startActivity(intent);
  			startActivityForResult(intent, 1);
  		  return true;
  	  }
  	  return false;
  	 }

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	 @Override
	 public boolean onTouchEvent(MotionEvent event) {
	  // TODO Auto-generated method stub
	  return myGestureDetector.onTouchEvent(event);
	 }

    
}