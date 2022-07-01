package com.blued.android.module.live_china.live_info;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;

public class LiveRoomInfo {
  public static LiveRoomInfo a;
  
  private ILiveRoomInfoCallBack b;
  
  public static LiveRoomInfo a() {
    if (a == null)
      a = new LiveRoomInfo(); 
    return a;
  }
  
  public static boolean b() {
    LiveRoomInfo liveRoomInfo = a;
    return (liveRoomInfo != null && liveRoomInfo.b != null);
  }
  
  public String A() {
    return this.b.w();
  }
  
  public String B() {
    return this.b.x();
  }
  
  public String C() {
    return this.b.y();
  }
  
  public String D() {
    return this.b.z();
  }
  
  public String E() {
    return this.b.A();
  }
  
  public String F() {
    return this.b.B();
  }
  
  public boolean G() {
    return this.b.C();
  }
  
  public CharSequence a(CharSequence paramCharSequence, String paramString, LiveRoomConstants.ClickAtLinkListener paramClickAtLinkListener) {
    return this.b.a(paramCharSequence, paramString, paramClickAtLinkListener);
  }
  
  public String a(Context paramContext, TextView paramTextView, String paramString) {
    return this.b.a(paramContext, paramTextView, paramString);
  }
  
  public String a(String paramString) {
    return this.b.a(paramString);
  }
  
  public String a(String paramString, boolean paramBoolean) {
    return this.b.a(paramString, paramBoolean);
  }
  
  public void a(double paramDouble) {
    this.b.a(paramDouble);
  }
  
  public void a(int paramInt) {
    this.b.a(paramInt);
  }
  
  public void a(Activity paramActivity) {
    this.b.a(paramActivity);
  }
  
  public void a(Context paramContext) {
    this.b.a(paramContext);
  }
  
  public void a(Context paramContext, int paramInt) {
    this.b.a(paramContext, paramInt);
  }
  
  public void a(Context paramContext, TextView paramTextView, int paramInt1, int paramInt2) {
    this.b.a(paramContext, paramTextView, paramInt1, paramInt2);
  }
  
  public void a(Context paramContext, TextView paramTextView, LiveRoomUserModel paramLiveRoomUserModel, int paramInt) {
    this.b.a(paramContext, paramTextView, paramLiveRoomUserModel, paramInt);
  }
  
  public void a(Context paramContext, PayOption._pay_list param_pay_list, String paramString) {
    this.b.a(paramContext, param_pay_list, paramString);
  }
  
  public void a(Context paramContext, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    this.b.a(paramContext, paramIAddOrRemoveAttentionDone, paramString1, paramString2, paramIRequestHost);
  }
  
  public void a(Context paramContext, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost, boolean paramBoolean) {
    this.b.a(paramContext, paramIAddOrRemoveAttentionDone, paramString1, paramString2, paramString3, paramIRequestHost, paramBoolean);
  }
  
  public void a(Context paramContext, LiveRoomData paramLiveRoomData, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap) {
    this.b.a(paramContext, paramLiveRoomData, paramString1, paramString2, paramString3, paramString4, paramBitmap);
  }
  
  public void a(Context paramContext, String paramString) {
    this.b.a(paramContext, paramString);
  }
  
  public void a(Context paramContext, String paramString, TextView paramTextView, ImageView paramImageView, boolean paramBoolean) {
    this.b.a(paramContext, paramString, paramTextView, paramImageView, paramBoolean);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, long paramLong, IRequestHost paramIRequestHost) {
    this.b.a(paramContext, paramString1, paramString2, paramLong, paramIRequestHost);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {
    this.b.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    this.b.a(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(Context paramContext, boolean paramBoolean, LiveRoomData paramLiveRoomData, Bitmap paramBitmap, String paramString) {
    this.b.a(paramContext, paramBoolean, paramLiveRoomData, paramBitmap, paramString);
  }
  
  public void a(Bitmap paramBitmap, long paramLong, Context paramContext, KeyboardListenLinearLayout paramKeyboardListenLinearLayout) {
    this.b.a(paramBitmap, paramLong, paramContext, paramKeyboardListenLinearLayout);
  }
  
  public void a(ImageView paramImageView, int paramInt) {
    this.b.a(paramImageView, paramInt);
  }
  
  public void a(ImageView paramImageView, LiveRoomUserModel paramLiveRoomUserModel) {
    this.b.a(paramImageView, paramLiveRoomUserModel);
  }
  
  public void a(ChattingModel paramChattingModel1, ChattingModel paramChattingModel2) {
    this.b.a(paramChattingModel1, paramChattingModel2);
  }
  
  public void a(ChattingModel paramChattingModel, boolean paramBoolean) {
    this.b.a(paramChattingModel, paramBoolean);
  }
  
  public void a(BaseFragment paramBaseFragment, String paramString1, String paramString2, int paramInt) {
    this.b.a(paramBaseFragment, paramString1, paramString2, paramInt);
  }
  
  public void a(PermissionCallbacks paramPermissionCallbacks) {
    this.b.a(paramPermissionCallbacks);
  }
  
  public void a(RecordingOnliveFragment paramRecordingOnliveFragment, int paramInt1, int paramInt2, String paramString, String[] paramArrayOfString) {
    this.b.a(paramRecordingOnliveFragment, paramInt1, paramInt2, paramString, paramArrayOfString);
  }
  
  public void a(ILiveRoomInfoCallBack paramILiveRoomInfoCallBack) {
    this.b = paramILiveRoomInfoCallBack;
  }
  
  public void a(String paramString, boolean paramBoolean, IRequestHost paramIRequestHost) {
    this.b.a(paramString, paramBoolean, paramIRequestHost);
  }
  
  public boolean a(Context paramContext, View.OnClickListener paramOnClickListener) {
    return this.b.a(paramContext, paramOnClickListener);
  }
  
  public String b(String paramString, boolean paramBoolean) {
    return this.b.b(paramString, paramBoolean);
  }
  
  public void b(Context paramContext, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    this.b.b(paramContext, paramIAddOrRemoveAttentionDone, paramString1, paramString2, paramIRequestHost);
  }
  
  public void b(Context paramContext, String paramString) {
    this.b.b(paramContext, paramString);
  }
  
  public boolean b(Context paramContext) {
    return this.b.b(paramContext);
  }
  
  public boolean b(String paramString) {
    return this.b.b(paramString);
  }
  
  public String c() {
    return this.b.a();
  }
  
  public String c(Context paramContext, String paramString) {
    return this.b.c(paramContext, paramString);
  }
  
  public void c(Context paramContext) {
    this.b.c(paramContext);
  }
  
  public String d() {
    return this.b.b();
  }
  
  public String e() {
    return this.b.c();
  }
  
  public String f() {
    return this.b.d();
  }
  
  public long g() {
    return CommonStringUtils.c(this.b.d());
  }
  
  public boolean h() {
    return this.b.e();
  }
  
  public boolean i() {
    return this.b.o();
  }
  
  public boolean j() {
    return this.b.i();
  }
  
  public String k() {
    return this.b.j();
  }
  
  public String l() {
    return this.b.k();
  }
  
  public String m() {
    return this.b.n();
  }
  
  public String n() {
    return this.b.l();
  }
  
  public String o() {
    return this.b.m();
  }
  
  public String p() {
    return this.b.f();
  }
  
  public int q() {
    return this.b.g();
  }
  
  public int r() {
    return this.b.h();
  }
  
  public void s() {
    this.b.p();
  }
  
  public boolean t() {
    return this.b.q();
  }
  
  public boolean u() {
    return this.b.r();
  }
  
  public boolean v() {
    return this.b.s();
  }
  
  public boolean w() {
    return this.b.D();
  }
  
  public String x() {
    return this.b.t();
  }
  
  public String y() {
    return this.b.u();
  }
  
  public String z() {
    return this.b.v();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\live_info\LiveRoomInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */