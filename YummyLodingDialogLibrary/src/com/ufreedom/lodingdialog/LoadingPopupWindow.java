package com.ufreedom.lodingdialog;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

public class LoadingPopupWindow extends PopupWindow {

	private Context context;

	

	private View vLoadingPanle;
	private View vErrorPanle;
	private View vCanclePanel;
	private View vFinishedPanel;

	private View parent;

	protected LoadingPopupWindow(Context context, View parentView,
			View contentView) {
		super(contentView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

		this.context = context;
		this.parent = parentView;

		vLoadingPanle = contentView.findViewById(R.id.vLodingPanel);
		vErrorPanle = contentView.findViewById(R.id.vErrorPanel);
		vCanclePanel = contentView.findViewById(R.id.vCanclePanel);
		vFinishedPanel = contentView.findViewById(R.id.vFinishedPanel);

	}

	public void showLoading() {

		vErrorPanle.setVisibility(View.GONE);
		vCanclePanel.setVisibility(View.GONE);
		vFinishedPanel.setVisibility(View.GONE);
		vLoadingPanle.setVisibility(View.VISIBLE);

		this.showAtLocation(parent, Gravity.CENTER, 0, 0);

	}

	public void showError() {

		vErrorPanle.setVisibility(View.VISIBLE);
		vCanclePanel.setVisibility(View.GONE);
		vFinishedPanel.setVisibility(View.GONE);
		vLoadingPanle.setVisibility(View.GONE);

		this.showAtLocation(parent, Gravity.CENTER, 0, 0);

	}

	public void showCancle() {

		vErrorPanle.setVisibility(View.GONE);
		vCanclePanel.setVisibility(View.VISIBLE);
		vFinishedPanel.setVisibility(View.GONE);
		vLoadingPanle.setVisibility(View.GONE);

		this.showAtLocation(parent, Gravity.CENTER, 0, 0);

	}

	public void showFinished() {

		vErrorPanle.setVisibility(View.GONE);
		vCanclePanel.setVisibility(View.GONE);
		vFinishedPanel.setVisibility(View.VISIBLE);
		vLoadingPanle.setVisibility(View.GONE);

		this.showAtLocation(parent, Gravity.CENTER, 0, 0);

	}

	public static class Builder {

		LoadingParams loadingParams;
		private Context context;
		private View parent;
		public Builder(Context context, View parentView) {
			this.context = context;
			parent = parentView;
			loadingParams = new LoadingParams();
		}

		public Builder setLoadingInfo(String info) {

			loadingParams.loadingInfo = info;

			return this;
		}

		public Builder setErrorInfo(String info) {

			loadingParams.errorInfo = info;
			return this;

		}

		public Builder setFinishedInfo(String info) {

			loadingParams.finishedInfo = info;

			return this;
		}

		public Builder setCancleInfo(String info) {

			loadingParams.cancleInfo = info;

			return this;
		}

		public LoadingPopupWindow createLoadingDialog() {

			View contentView = LayoutInflater.from(context).inflate(R.layout.popup_window_loading, null);

			TextView vLoadingInfo = (TextView) contentView
					.findViewById(R.id.vLodingInfo);
			vLoadingInfo.setText(loadingParams.loadingInfo);

			TextView vFinishedInfo = (TextView) contentView
					.findViewById(R.id.vFinishedInfo);
			vFinishedInfo.setText(loadingParams.finishedInfo);

			TextView vErrorInfo = (TextView) contentView
					.findViewById(R.id.vErrorInfo);
			vErrorInfo.setText(loadingParams.errorInfo);

			TextView vCancleInfo = (TextView) contentView
					.findViewById(R.id.vCancleInfo);
			vCancleInfo.setText(loadingParams.cancleInfo);

			return new LoadingPopupWindow(context, parent, contentView);

		}

	}

	private static class LoadingParams {

		public String loadingInfo = "";
		public String errorInfo = "";
		public String finishedInfo = "";
		public String cancleInfo = "";

	}

}
