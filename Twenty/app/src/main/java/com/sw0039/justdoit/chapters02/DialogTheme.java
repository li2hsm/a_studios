package com.sw0039.justdoit.chapters02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.sw0039.justdoit.R;


public class DialogTheme extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_dialog_theme);
		Button bn = (Button) findViewById(R.id.bn);
		// 为按钮绑定事件监听器
		bn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				// 结束该Activity
				finish();
			}
		});
	}
}
