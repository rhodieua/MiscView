package com.ex.miscview;

import com.ex.miscview.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTouchListener {
	
	TextView text;
	
	Button b_up;
	Button b_down;
	Button b_left;
	Button b_right;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		text = (TextView)findViewById(R.id.textView1);
		
		RelativeLayout rl = (RelativeLayout)findViewById(R.id.rlayout);
		rl.setRotation(45);
		
		b_up = (Button)findViewById(R.id.up);
		b_up.setOnTouchListener(this);
		b_down = (Button)findViewById(R.id.down);
		b_down.setOnTouchListener(this);
		b_left = (Button)findViewById(R.id.left);
		b_left.setOnTouchListener(this);
		b_right = (Button)findViewById(R.id.right);
		b_right.setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		boolean res = false;
		float xCoord = v.getMeasuredWidth();
		float yCoord = v.getMeasuredHeight();
		float xSide = 0.1f; 
		float ySide = 0.1f;
		String msg = "";
		
		if (v == b_up) {
			xSide = event.getX() - xCoord; 
			ySide = event.getY() - yCoord;
			msg = "Up!";
		} else if (v == b_down) {
			xSide = event.getX(); 
			ySide = event.getY();
			msg = "Down!";
		} else if (v == b_left) {
			xSide = event.getX() - xCoord; 
			ySide = event.getY();
			msg = "Left!";
		} else if (v == b_right) {
			xSide = event.getX(); 
			ySide = event.getY() - yCoord;
			msg = "Right!";
		}
		
		if (Math.sqrt(xSide * xSide + ySide * ySide) < xCoord) {
			text.setText(msg);
		} else {
			text.setText("Missed!");
			res = true;
		}
		
		return res;
	}

}
