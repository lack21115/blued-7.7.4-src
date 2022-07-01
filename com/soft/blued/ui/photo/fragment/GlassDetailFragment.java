package com.soft.blued.ui.photo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.view.ViewDragHelperLayout;
import com.blued.android.module.player.media.observer.EventCallbackObserver;

public class GlassDetailFragment extends BaseFragment {
  ViewDragHelperLayout.OnLayoutStateListener d = new ViewDragHelperLayout.OnLayoutStateListener(this) {
      public void a() {
        if (this.a.getActivity() != null) {
          this.a.getActivity().finish();
          this.a.getActivity().overridePendingTransition(0, 0);
        } 
        EventCallbackObserver.a().b();
      }
      
      public void a(int param1Int) {
        EventCallbackObserver.a().a(param1Int);
      }
      
      public void b() {
        EventCallbackObserver.a().c();
      }
      
      public void c() {}
      
      public void d() {}
    };
  
  private View e;
  
  private ViewDragHelperLayout f;
  
  private ProgressBar g;
  
  private TextView h;
  
  private ImageView i;
  
  private int j;
  
  private int k;
  
  private String l;
  
  private int m;
  
  public static GlassDetailFragment a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    GlassDetailFragment glassDetailFragment = new GlassDetailFragment();
    Bundle bundle = new Bundle();
    bundle.putString("url", paramString);
    bundle.putBoolean("islocal", paramBoolean);
    bundle.putInt("come_code", paramInt1);
    bundle.putInt("current_position", paramInt2);
    bundle.putInt("album_count", paramInt3);
    glassDetailFragment.setArguments(bundle);
    return glassDetailFragment;
  }
  
  private void a() {
    Bundle bundle = getArguments();
    boolean bool = false;
    if (bundle != null) {
      i = getArguments().getInt("come_code");
    } else {
      i = 0;
    } 
    this.j = i;
    if (getArguments() != null) {
      i = getArguments().getInt("album_count");
    } else {
      i = 0;
    } 
    this.m = i;
    if (getArguments() != null) {
      String str = getArguments().getString("url");
    } else {
      bundle = null;
    } 
    this.l = (String)bundle;
    int i = bool;
    if (getArguments() != null)
      i = getArguments().getInt("current_position"); 
    this.k = i;
  }
  
  private void k() {
    this.f = (ViewDragHelperLayout)this.e.findViewById(2131301640);
    this.g = (ProgressBar)this.e.findViewById(2131299159);
    this.f.setOnLayoutStateListener(this.d);
    this.i = (ImageView)this.e.findViewById(2131296493);
    this.h = (TextView)this.e.findViewById(2131299172);
    l();
  }
  
  private void l() {
    TextView textView = this.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getString(2131756918));
    stringBuilder.append("(");
    stringBuilder.append(this.m);
    stringBuilder.append(getString(2131755277));
    stringBuilder.append(")");
    textView.setText(stringBuilder.toString());
    ImageLoader.a((IRequestHost)w_(), this.l).d().a(this.i);
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
  }
  
  public boolean V_() {
    EventCallbackObserver.a().d();
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493133, paramViewGroup, false);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void onPause() {
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
    this.f.setScrollDisable(true);
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\fragment\GlassDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */