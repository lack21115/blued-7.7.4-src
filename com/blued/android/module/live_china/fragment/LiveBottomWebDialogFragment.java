package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.web.LiveWebCallBack;

public class LiveBottomWebDialogFragment extends BaseDialogFragment {
  public LayoutInflater a;
  
  private Context b;
  
  private View c;
  
  private ImageView d;
  
  private ProgressBar e;
  
  private BluedWebView f;
  
  private OnDismissListener g;
  
  public static LiveBottomWebDialogFragment a(Context paramContext, FragmentManager paramFragmentManager, String paramString) {
    if (BluedWebView.a(paramContext, paramString, (BluedWebView.WebCallback)new LiveWebCallBack()))
      return null; 
    LiveBottomWebDialogFragment liveBottomWebDialogFragment = new LiveBottomWebDialogFragment();
    Bundle bundle = new Bundle();
    bundle.putString("WEB_URL", paramString);
    liveBottomWebDialogFragment.setArguments(bundle);
    liveBottomWebDialogFragment.show(paramFragmentManager, "webDialogFragment");
    return liveBottomWebDialogFragment;
  }
  
  private void f() {
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.e = (ProgressBar)this.c.findViewById(R.id.loading);
    this.d = (ImageView)this.c.findViewById(R.id.loading_bg);
    this.e.setVisibility(0);
    this.d.setVisibility(0);
    WebView webView = (WebView)this.c.findViewById(R.id.web_view);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.setWebViewClient(new WebViewClient());
    webView.setLayerType(2, null);
    webView.setBackgroundColor(0);
    webView.getBackground().setAlpha(0);
    this.f = new BluedWebView((Fragment)this, webView, (ViewGroup)this.c, (BluedWebView.WebCallback)new LiveWebCallBack(this) {
          public void b(BluedWebView param1BluedWebView, String param1String, boolean param1Boolean) {
            LiveBottomWebDialogFragment.a(this.a).setVisibility(8);
            LiveBottomWebDialogFragment.b(this.a).setVisibility(8);
          }
        });
  }
  
  private void g() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      String str = bundle.getString("WEB_URL");
    } else {
      bundle = null;
    } 
    if (!TextUtils.isEmpty((CharSequence)bundle)) {
      this.f.a((String)bundle);
      return;
    } 
    getActivity().finish();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_bottom_web, null);
    Dialog dialog = new Dialog((Context)getActivity(), R.style.transparentFrameWindowStyleLive);
    dialog.requestWindowFeature(1);
    dialog.setContentView(view, new ViewGroup.LayoutParams(DensityUtils.a((Context)getActivity(), 430.0F), -1));
    Window window = dialog.getWindow();
    window.setWindowAnimations(R.style.main_menu_animstyle);
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.x = 0;
    layoutParams.y = getActivity().getWindowManager().getDefaultDisplay().getHeight();
    layoutParams.width = -1;
    layoutParams.height = DensityUtils.a((Context)getActivity(), 430.0F);
    layoutParams.gravity = 5;
    dialog.onWindowAttributesChanged(layoutParams);
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.b = (Context)getActivity();
    this.a = LayoutInflater.from(this.b);
    if (this.c == null) {
      this.c = paramLayoutInflater.inflate(R.layout.dialog_live_bottom_web, paramViewGroup, false);
      f();
    } 
    g();
    return this.c;
  }
  
  public void onDestroy() {
    super.onDestroy();
    OnDismissListener onDismissListener = this.g;
    if (onDismissListener != null)
      onDismissListener.a(); 
  }
  
  public static interface OnDismissListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveBottomWebDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */