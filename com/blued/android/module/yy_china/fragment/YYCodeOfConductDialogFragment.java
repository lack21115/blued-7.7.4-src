package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import java.util.Map;

public class YYCodeOfConductDialogFragment extends MvpFragment<MvpPresenter> implements View.OnClickListener {
  private WebView d;
  
  private TextView e;
  
  private View f;
  
  private OnClickHintFragmentLister g;
  
  private BluedWebView h;
  
  private void k() {
    this.h = new BluedWebView((Fragment)this, this.d, null, new BluedWebView.WebCallback(this) {
          public void a() {}
          
          public void a(BluedWebView param1BluedWebView, int param1Int) {}
          
          public void a(BluedWebView param1BluedWebView, int param1Int, String param1String1, String param1String2) {}
          
          public void a(BluedWebView param1BluedWebView, String param1String) {
            YYCodeOfConductDialogFragment.a(this.a).setText(param1String);
          }
          
          public void a(BluedWebView param1BluedWebView, String param1String, boolean param1Boolean) {}
          
          public void a(String param1String) {}
          
          public void a(String param1String1, String param1String2, Fragment param1Fragment, BluedWebView param1BluedWebView) {}
          
          public void a(String param1String1, String param1String2, String param1String3, String param1String4, int param1Int, Map<String, String> param1Map, BluedWebView param1BluedWebView) {}
          
          public void a(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, String param1String6, String param1String7, String param1String8, String param1String9, BluedWebView param1BluedWebView) {}
          
          public void a(Map<String, String> param1Map, BluedWebView param1BluedWebView) {}
          
          public boolean a(Context param1Context, String param1String) {
            return false;
          }
          
          public boolean a(BluedWebView param1BluedWebView, BluedUrlParser param1BluedUrlParser) {
            if ("yy_close".equals(param1BluedUrlParser.a())) {
              YYCodeOfConductDialogFragment.b(this.a);
              return false;
            } 
            if ("yy_read_norm_agree".equals(param1BluedUrlParser.a()))
              YYCodeOfConductDialogFragment.c(this.a); 
            return false;
          }
          
          public void b() {}
          
          public void b(BluedWebView param1BluedWebView, String param1String, boolean param1Boolean) {}
          
          public boolean b(String param1String) {
            return false;
          }
        });
  }
  
  private void l() {
    if (this.g != null) {
      View view = this.f;
      if (view != null)
        view.setBackgroundColor(16777215); 
      this.g.b();
    } 
  }
  
  private void m() {
    OnClickHintFragmentLister onClickHintFragmentLister = this.g;
    if (onClickHintFragmentLister != null) {
      onClickHintFragmentLister.c();
      l();
    } 
  }
  
  public boolean V_() {
    l();
    return true;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.l.findViewById(R.id.iv_dia_closes).setOnClickListener(this);
    this.l.findViewById(R.id.iv_close).setOnClickListener(this);
    this.l.findViewById(R.id.ll_code_all).setOnClickListener(this);
    this.f = this.l.findViewById(R.id.ll_audience_layout);
    this.e = (TextView)this.l.findViewById(R.id.tv_titl);
    this.d = (WebView)this.l.findViewById(R.id.web);
    this.d.setBackgroundColor(0);
    k();
    this.h.a(YYRoomInfoManager.d().a(-1));
  }
  
  public void a(OnClickHintFragmentLister paramOnClickHintFragmentLister) {
    this.g = paramOnClickHintFragmentLister;
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.iv_dia_closes) {
      l();
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK);
      return;
    } 
    if (paramView.getId() == R.id.iv_close) {
      l();
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK);
    } 
  }
  
  public int p() {
    return R.layout.fragment_yy_code_of_conduct;
  }
  
  public static interface OnClickHintFragmentLister {
    void b();
    
    void c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYCodeOfConductDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */