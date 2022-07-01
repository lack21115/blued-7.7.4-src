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
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;

public interface ILiveRoomInfoCallBack {
  String A();
  
  String B();
  
  boolean C();
  
  boolean D();
  
  CharSequence a(CharSequence paramCharSequence, String paramString, LiveRoomConstants.ClickAtLinkListener paramClickAtLinkListener);
  
  String a();
  
  String a(Context paramContext, TextView paramTextView, String paramString);
  
  String a(String paramString);
  
  String a(String paramString, boolean paramBoolean);
  
  void a(double paramDouble);
  
  void a(int paramInt);
  
  void a(Activity paramActivity);
  
  void a(Context paramContext);
  
  void a(Context paramContext, int paramInt);
  
  void a(Context paramContext, TextView paramTextView, int paramInt1, int paramInt2);
  
  void a(Context paramContext, TextView paramTextView, LiveRoomUserModel paramLiveRoomUserModel, int paramInt);
  
  void a(Context paramContext, PayOption._pay_list param_pay_list, String paramString);
  
  void a(Context paramContext, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone, String paramString1, String paramString2, IRequestHost paramIRequestHost);
  
  void a(Context paramContext, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost, boolean paramBoolean);
  
  void a(Context paramContext, LiveRoomData paramLiveRoomData, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap);
  
  void a(Context paramContext, String paramString);
  
  void a(Context paramContext, String paramString, TextView paramTextView, ImageView paramImageView, boolean paramBoolean);
  
  void a(Context paramContext, String paramString1, String paramString2, long paramLong, IRequestHost paramIRequestHost);
  
  void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4);
  
  void a(Context paramContext, boolean paramBoolean, LiveRoomData paramLiveRoomData, Bitmap paramBitmap, String paramString);
  
  void a(Bitmap paramBitmap, long paramLong, Context paramContext, KeyboardListenLinearLayout paramKeyboardListenLinearLayout);
  
  void a(ImageView paramImageView, int paramInt);
  
  void a(ImageView paramImageView, LiveRoomUserModel paramLiveRoomUserModel);
  
  void a(ChattingModel paramChattingModel1, ChattingModel paramChattingModel2);
  
  void a(ChattingModel paramChattingModel, boolean paramBoolean);
  
  void a(BaseFragment paramBaseFragment, String paramString1, String paramString2, int paramInt);
  
  void a(PermissionCallbacks paramPermissionCallbacks);
  
  void a(RecordingOnliveFragment paramRecordingOnliveFragment, int paramInt1, int paramInt2, String paramString, String[] paramArrayOfString);
  
  void a(String paramString, boolean paramBoolean, IRequestHost paramIRequestHost);
  
  boolean a(Context paramContext, View.OnClickListener paramOnClickListener);
  
  String b();
  
  String b(String paramString, boolean paramBoolean);
  
  void b(Context paramContext, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone, String paramString1, String paramString2, IRequestHost paramIRequestHost);
  
  void b(Context paramContext, String paramString);
  
  boolean b(Context paramContext);
  
  boolean b(String paramString);
  
  String c();
  
  String c(Context paramContext, String paramString);
  
  void c(Context paramContext);
  
  String d();
  
  boolean e();
  
  String f();
  
  int g();
  
  int h();
  
  boolean i();
  
  String j();
  
  String k();
  
  String l();
  
  String m();
  
  String n();
  
  boolean o();
  
  void p();
  
  boolean q();
  
  boolean r();
  
  boolean s();
  
  String t();
  
  String u();
  
  String v();
  
  String w();
  
  String x();
  
  String y();
  
  String z();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\live_info\ILiveRoomInfoCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */