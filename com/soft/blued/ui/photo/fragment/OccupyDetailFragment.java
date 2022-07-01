package com.soft.blued.ui.photo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.soft.blued.ui.photo.manager.AlbumViewDataManager;
import com.soft.blued.ui.photo.observer.AlbumDownLoadObserver;

public class OccupyDetailFragment extends BaseFragment implements AlbumDownLoadObserver.IAlbumDownLoadObserver {
  private View d;
  
  private ProgressBar e;
  
  private int f;
  
  private int g;
  
  private FrameLayout h;
  
  private boolean i;
  
  public static OccupyDetailFragment a(int paramInt1, int paramInt2) {
    OccupyDetailFragment occupyDetailFragment = new OccupyDetailFragment();
    Bundle bundle = new Bundle();
    bundle.putInt("come_code", paramInt1);
    bundle.putInt("current_position", paramInt2);
    occupyDetailFragment.setArguments(bundle);
    return occupyDetailFragment;
  }
  
  private void k() {
    Bundle bundle = getArguments();
    byte b = 0;
    if (bundle != null) {
      i = getArguments().getInt("come_code");
    } else {
      i = 0;
    } 
    this.f = i;
    int i = b;
    if (getArguments() != null)
      i = getArguments().getInt("current_position"); 
    this.g = i;
  }
  
  private void l() {
    this.e = (ProgressBar)this.d.findViewById(2131299159);
    this.h = (FrameLayout)this.d.findViewById(2131299151);
  }
  
  public boolean V_() {
    EventCallbackObserver.a().d();
    return true;
  }
  
  public void a() {
    this.h.setVisibility(0);
    this.e.setVisibility(8);
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493256, paramViewGroup, false);
      k();
      l();
      AlbumDownLoadObserver.a().a(this);
      AlbumViewDataManager.a().e();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    this.i = true;
    return this.d;
  }
  
  public void onDestroy() {
    super.onDestroy();
    AlbumDownLoadObserver.a().b(this);
  }
  
  public void onPause() {
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (this.i && paramBoolean) {
      this.e.setVisibility(0);
      EventCallbackObserver.a().e();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\fragment\OccupyDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */