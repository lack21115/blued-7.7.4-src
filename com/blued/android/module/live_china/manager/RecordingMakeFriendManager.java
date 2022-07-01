package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.LiveMakeFriendCardView;
import java.util.ArrayList;
import java.util.List;

public class RecordingMakeFriendManager {
  public static int a = 0;
  
  public static int b = 0;
  
  public static double c = 0.9D;
  
  public List<LiveFriendModel> d = new ArrayList<LiveFriendModel>();
  
  private Context e;
  
  private RecordingOnliveFragment f;
  
  private int g;
  
  public RecordingMakeFriendManager(RecordingOnliveFragment paramRecordingOnliveFragment) {
    this.f = paramRecordingOnliveFragment;
    this.e = paramRecordingOnliveFragment.getContext();
    this.g = AppInfo.l / 2;
    a = (int)(this.g * c);
    int i = this.f.cc;
    b = DensityUtils.a(this.e, '');
  }
  
  public void a() {
    this.f.b_(0);
    this.f.S.d();
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.f.bs.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = (FrameLayout.LayoutParams)this.f.bt.getLayoutParams();
    layoutParams.width = -1;
    layoutParams.height = -1;
    this.f.bt.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.f.C.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.aU();
    this.f.aV();
    this.f.bt.setBackgroundResource(R.color.transparent);
    this.f.bE.setVisibility(8);
    this.f.bF.setVisibility(8);
    this.f.bG.setVisibility(8);
    this.f.bJ.setVisibility(8);
    this.f.bK.setVisibility(8);
    this.f.bL.setVisibility(8);
    this.f.bX.setVisibility(8);
    this.f.bZ.setVisibility(8);
    this.f.aW.setVisibility(8);
    this.f.aX.setVisibility(8);
    this.f.aY.setVisibility(8);
    Log.v("==record", "stopMakeFriends");
    this.f.S.h();
    this.d.clear();
  }
  
  public void a(int paramInt) {
    if (this.d.size() > paramInt) {
      LiveFriendModel liveFriendModel = this.d.get(paramInt);
      if (!TextUtils.isEmpty(liveFriendModel.uid)) {
        (new LiveMakeFriendCardView((BaseFragment)this.f)).a(liveFriendModel, paramInt);
        Logger.a("pk", new Object[] { "friendModel.voice = ", Integer.valueOf(liveFriendModel.voice) });
      } 
    } 
  }
  
  public void a(LiveFriendModel paramLiveFriendModel) {
    this.f.b_(5);
    this.f.S.d();
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.setMargins(0, b, 0, 0);
    this.f.bs.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = (FrameLayout.LayoutParams)this.f.bt.getLayoutParams();
    layoutParams.width = -1;
    layoutParams.height = a * 2;
    this.f.bt.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(this.g, a);
    this.f.C.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(this.g, a);
    layoutParams.leftMargin = this.g;
    this.f.bE.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.bJ.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(this.g, a);
    layoutParams.topMargin = a;
    this.f.bF.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.bK.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(this.g, a);
    layoutParams.topMargin = a;
    layoutParams.leftMargin = this.g;
    this.f.bG.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.bL.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.l(5);
    this.f.bE.setVisibility(0);
    this.f.bF.setVisibility(0);
    this.f.bG.setVisibility(0);
    this.f.bJ.setVisibility(0);
    this.f.bK.setVisibility(0);
    this.f.bL.setVisibility(0);
    this.f.bX.setVisibility(0);
    this.f.bZ.setVisibility(0);
    this.f.aW.setVisibility(0);
    this.f.aX.setVisibility(0);
    this.f.aY.setVisibility(0);
    this.f.aT.setVisibility(8);
    this.f.aU.setVisibility(8);
    this.f.aV.setVisibility(8);
    this.f.aL.setVisibility(8);
    this.f.S.a(3, paramLiveFriendModel.target_stream);
  }
  
  public void a(List<LiveFriendModel> paramList) {
    this.d = paramList;
    if (this.d != null)
      for (int i = 0; i < this.d.size(); i++) {
        LiveFriendModel liveFriendModel = this.d.get(i);
        if (i == 0)
          if (!TextUtils.isEmpty(liveFriendModel.uid)) {
            this.f.bM.setVisibility(0);
            this.f.bM.setText(liveFriendModel.name);
            this.f.aW.setVisibility(8);
          } else {
            this.f.bM.setVisibility(8);
            if (this.f.aW.getVisibility() == 8) {
              this.f.aW.setVisibility(0);
              this.f.aF.setVisibility(8);
            } 
          }  
        if (i == 1)
          if (!TextUtils.isEmpty(liveFriendModel.uid)) {
            this.f.bN.setVisibility(0);
            this.f.bN.setText(liveFriendModel.name);
            this.f.aX.setVisibility(8);
          } else {
            this.f.bN.setVisibility(8);
            if (this.f.aX.getVisibility() == 8) {
              this.f.aX.setVisibility(0);
              this.f.aG.setVisibility(8);
            } 
          }  
        if (i == 2)
          if (!TextUtils.isEmpty(liveFriendModel.uid)) {
            this.f.bO.setVisibility(0);
            this.f.bO.setText(liveFriendModel.name);
            this.f.aY.setVisibility(8);
          } else {
            this.f.bO.setVisibility(8);
            if (this.f.aY.getVisibility() == 8) {
              this.f.aY.setVisibility(0);
              this.f.aH.setVisibility(8);
            } 
          }  
      }  
  }
  
  public void a(boolean paramBoolean) {
    LiveRoomHttpUtils.g(new BluedUIHttpResponse(this, (IRequestHost)this.f.w_(), paramBoolean) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            if (this.a)
              RecordingMakeFriendManager.a(this.b).J(); 
          }
        });
  }
  
  public void b() {
    if (this.f.aP())
      a(false); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\RecordingMakeFriendManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */