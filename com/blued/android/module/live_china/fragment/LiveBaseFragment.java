package com.blued.android.module.live_china.fragment;

import android.animation.Animator;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.GrabBoxModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveRoomUtils;
import com.blued.android.module.live_china.view.BubbleLayout;
import com.blued.android.module.live_china.view.GrabBoxView;
import com.blued.android.module.live_china.view.LiveActivityView;
import com.blued.android.module.live_china.view.LiveMakeFriendManageView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import java.util.List;

public abstract class LiveBaseFragment extends KeyBoardFragment implements LiveChatInfoListener {
  public View e;
  
  public BubbleLayout f;
  
  public LottieAnimationView o;
  
  public GrabBoxView p;
  
  public LiveMakeFriendManageView q;
  
  public LiveMakeLoverOkDialogFragment r;
  
  protected Bundle s;
  
  public short t = 4;
  
  public long u;
  
  protected boolean v = false;
  
  public boolean w;
  
  public int x;
  
  private LiveActivityView y;
  
  public int A() {
    return this.x;
  }
  
  public boolean B() {
    return (A() == 1);
  }
  
  public void C() {
    if (isAdded())
      for (Fragment fragment : getChildFragmentManager().getFragments()) {
        if (fragment instanceof PlayingOnliveBaseModeFragment)
          ((PlayingOnliveBaseModeFragment)fragment).l(); 
      }  
  }
  
  public void D() {}
  
  protected void L_() {}
  
  public void M_() {
    if (LiveRoomManager.a().h() != null)
      this.y.setData((LiveRoomManager.a().h()).activity); 
  }
  
  protected void a(Bundle paramBundle) {}
  
  public void a(LiveMakeLoverFansModel paramLiveMakeLoverFansModel1, LiveMakeLoverFansModel paramLiveMakeLoverFansModel2, String paramString) {
    LiveMakeLoverOkDialogFragment liveMakeLoverOkDialogFragment = this.r;
    if (liveMakeLoverOkDialogFragment != null && liveMakeLoverOkDialogFragment.isVisible())
      this.r.dismiss(); 
    if (!TextUtils.isEmpty(paramString)) {
      ImageFileLoader.a((IRequestHost)w_()).a(paramString).a(new -$$Lambda$LiveBaseFragment$dG0EyI1sI1PezApui2aJuVjQFNo(this, paramLiveMakeLoverFansModel1, paramLiveMakeLoverFansModel2)).a();
      return;
    } 
    a(paramLiveMakeLoverFansModel1, paramLiveMakeLoverFansModel2, "", false);
  }
  
  public void a(LiveMakeLoverFansModel paramLiveMakeLoverFansModel1, LiveMakeLoverFansModel paramLiveMakeLoverFansModel2, String paramString, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public abstract void a(String paramString1, String paramString2);
  
  public void a_(int paramInt) {
    if (z()) {
      BubbleLayout bubbleLayout = this.f;
      if (bubbleLayout != null)
        bubbleLayout.a(false, paramInt); 
    } 
  }
  
  protected abstract void a_(ChattingModel paramChattingModel);
  
  public void b(List<GrabBoxModel> paramList) {
    if (paramList != null && paramList.size() > 0) {
      this.p.setData(paramList);
      return;
    } 
    this.p.setVisibility(8);
  }
  
  public void b_(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setLiveState:");
    stringBuilder.append(paramInt);
    Log.v("pk", stringBuilder.toString());
    this.x = paramInt;
  }
  
  public abstract void b_(List<LiveFriendModel> paramList);
  
  public abstract void c(String paramString);
  
  public void d(String paramString) {
    if (this.w)
      return; 
    this.o.setVisibility(0);
    this.o.a(new Animator.AnimatorListener(this) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {
            LiveBaseFragment liveBaseFragment = this.a;
            liveBaseFragment.w = false;
            liveBaseFragment.o.setVisibility(8);
          }
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {
            this.a.w = true;
          }
        });
    this.o.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.s = getArguments();
    if (this.s == null)
      this.s = new Bundle(); 
    v();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(t(), paramViewGroup, false);
      a(paramBundle);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onJoinLive(JoinLiveResult paramJoinLiveResult, String paramString1, String paramString2, String paramString3) {}
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    w();
    L_();
  }
  
  public void onViewerDataChanged(long paramLong, List<ProfileData> paramList) {}
  
  public void onViewerEntrance(EntranceData paramEntranceData, long paramLong) {
    a(new -$$Lambda$LiveBaseFragment$88BoYcFY_YTnH2Ivg1pti7FXzHs(paramEntranceData, paramLong));
  }
  
  protected abstract int t();
  
  protected void u() {
    this.f = (BubbleLayout)this.e.findViewById(R.id.ll_bubble);
    this.o = (LottieAnimationView)this.e.findViewById(R.id.animation_view);
    this.p = (GrabBoxView)this.e.findViewById(R.id.grab_box_view);
    this.q = (LiveMakeFriendManageView)this.e.findViewById(R.id.live_make_friend_manage_view);
    this.y = (LiveActivityView)this.e.findViewById(R.id.liveActivityView);
    this.y.a((BaseFragment)this);
    String[] arrayOfString = LiveRoomPreferences.d().split(";");
    this.f.a(arrayOfString);
    this.p.a((BaseFragment)this);
  }
  
  protected void v() {}
  
  protected void w() {
    LiveEventBus.get(LiveEventBusUtil.b, ChattingModel.class).observe((LifecycleOwner)this, new -$$Lambda$k01KcCdosCNlZoaI3Am5p1bNq-8(this));
  }
  
  public abstract void y();
  
  protected boolean z() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */