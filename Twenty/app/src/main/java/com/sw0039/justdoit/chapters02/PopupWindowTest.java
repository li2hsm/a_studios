package com.sw0039.justdoit.chapters02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;

import com.sw0039.justdoit.R;


public class PopupWindowTest extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_pop);
		// 装载R.layout.popup对应的界面布局
		View root = this.getLayoutInflater().inflate(R.layout.popup, null);
		// 创建PopupWindow对象
		final PopupWindow popup = new PopupWindow(root, 560, 720);
		Button button = (Button) findViewById(R.id.bn);
		button.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// 以下拉方式显示
				// popup.showAsDropDown(v);
				//将PopupWindow显示在指定位置
				popup.showAtLocation(findViewById(R.id.bn),
					Gravity.CENTER, 20,20);
			}
		});
		// 获取PopupWindow中的“关闭”按钮
		root.findViewById(R.id.close).setOnClickListener(
			new OnClickListener()
			{
				public void onClick(View v)
				{
					// 关闭PopupWindow
					popup.dismiss(); // ①
				}
			});
	}
}
