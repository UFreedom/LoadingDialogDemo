package com.ufreedom.lodingdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	private LoadingPopupWindow loadingPopupWindow;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = this;
		
		
		loadingPopupWindow = new LoadingPopupWindow.Builder(context,
				findViewById(R.id.vParent))
		        .setCancleInfo("取消啦")
				.setErrorInfo("加载出错欧").
				 setFinishedInfo("加载完毕啦")
				.setLoadingInfo("正在加载欧").createLoadingDialog();

	}

	public void onLoadingClick(View view) {
		loadingPopupWindow.showLoading();
	}
	
	public void onDestoryClick(View view){
		loadingPopupWindow.dismiss();
	}

	public void onFinishedClick(View view) {
		loadingPopupWindow.showFinished();
	}

	public void onErrorClick(View view) {
		loadingPopupWindow.showError();
	}

	public void onCancleClick(View view) {
		loadingPopupWindow.showCancle();
	}

}
