package com.soft.blued.ui.live.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.ImageView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.soft.blued.ui.live.fragment.LiveApplySimpleFragment;
import com.soft.blued.ui.live.fragment.LiveApplyVerifyFragment;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.dialog.BluedAlertDialog;

public class LiveUtils {
  public static final int[] a = new int[] { 
      1, 5, 15, 30, 50, 100, 200, 400, 650, 1000, 
      1500, 2100, 2800, 3800, 5000, 8000, 12000, 17000, 23000, 30000, 
      38000, 47000, 57000, 70000, 88000, 114000, 150000, 198000, 261000, 342000, 
      453000, 606000, 783000 };
  
  public static NearbyLiveSourceModel b;
  
  public static int a(Context paramContext, ImageView paramImageView, int paramInt, boolean paramBoolean) {
    if (paramInt >= 0) {
      int i = paramInt;
      if (paramInt >= 99)
        i = 99; 
      if (i < 10) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("00");
        stringBuilder1.append(i);
        str = stringBuilder1.toString();
      } else if (i < 100) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("0");
        stringBuilder1.append(i);
        str = stringBuilder1.toString();
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(i);
        stringBuilder1.append("");
        str = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("anchor_rich");
      stringBuilder.append(str);
      String str = stringBuilder.toString();
      paramInt = paramContext.getResources().getIdentifier(str, "drawable", paramContext.getPackageName());
      if (paramImageView != null) {
        paramImageView.setImageResource(paramInt);
        if (i == 0 && paramBoolean) {
          paramImageView.setVisibility(8);
          return paramInt;
        } 
        paramImageView.setVisibility(0);
      } 
      return paramInt;
    } 
    if (paramImageView != null)
      paramImageView.setVisibility(8); 
    return -1;
  }
  
  public static String a() {
    NearbyLiveSourceModel nearbyLiveSourceModel = b;
    return (nearbyLiveSourceModel == null) ? "" : nearbyLiveSourceModel.b;
  }
  
  public static String a(int paramInt) {
    return b(paramInt);
  }
  
  public static void a(Context paramContext, BluedLiveState paramBluedLiveState) {
    if (paramBluedLiveState == null)
      return; 
    int i = paramBluedLiveState.is_permission;
    int j = UserRelationshipUtils.a(paramBluedLiveState.block, paramBluedLiveState.vbadge, paramBluedLiveState.verify, paramBluedLiveState.mobile);
    if (AudioChannelManager.e().h()) {
      AppMethods.a(paramContext.getResources().getText(2131759450));
      return;
    } 
    if (paramBluedLiveState.avatar_v_status == 0) {
      CommonAlertDialog.a(paramContext, "", paramContext.getResources().getString(2131758199), paramContext.getResources().getString(2131759123), new DialogInterface.OnClickListener(paramContext) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              ModifyUserInfoFragment.a(this.a, 602, true);
            }
          }paramContext.getResources().getString(2131756057), null, null);
      return;
    } 
    if (paramBluedLiveState.avatar_v_status == 2) {
      CommonAlertDialog.a(paramContext, "", paramContext.getResources().getString(2131757216), paramContext.getResources().getString(2131756188), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
          },  null, 1);
      return;
    } 
    if (2 == i || 1 == i) {
      if (j == 1) {
        CommonAlertDialog.a(paramContext, "", paramContext.getResources().getString(2131755056), paramContext.getResources().getString(2131756188), new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
            },  null, 1);
        return;
      } 
      if (j == 3) {
        CommonAlertDialog.a(paramContext, "", paramContext.getResources().getString(2131755071), paramContext.getResources().getString(2131755121), new DialogInterface.OnClickListener(paramContext) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                TerminalActivity.d(this.a, LinkMobileFragment.class, null);
              }
            }paramContext.getResources().getString(2131756057), null, null);
        return;
      } 
      if (j == 2) {
        CommonAlertDialog.a(paramContext, "", paramContext.getResources().getString(2131755072), paramContext.getResources().getString(2131756188), new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
            },  null, 1);
        return;
      } 
      if (j == 4) {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(paramContext);
        builder.a(paramContext.getResources().getString(2131758515)).b(paramContext.getResources().getString(2131755043)).a(paramContext.getResources().getString(2131755044), new DialogInterface.OnClickListener(paramContext, paramBluedLiveState) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                LiveApplySimpleFragment.a(this.a, this.b);
              }
            }).b(paramContext.getResources().getString(2131755045), new DialogInterface.OnClickListener(paramContext) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                ModifyUserInfoFragment.a(this.a, 602, true);
              }
            }).a(true).b(true).a(null).a(0);
        builder.a().show();
        return;
      } 
      RecordingOnliveFragment.a(paramContext, paramBluedLiveState.is_official);
      return;
    } 
    if (paramBluedLiveState.verify == 0) {
      if (paramBluedLiveState.has_audited == 0) {
        LiveApplyVerifyFragment.a(paramContext, paramBluedLiveState);
        return;
      } 
      CommonAlertDialog.a(paramContext, "", paramContext.getResources().getString(2131757206), paramContext.getResources().getString(2131756188), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
          },  null, 1);
      return;
    } 
    if (paramBluedLiveState.verify == 2) {
      LiveApplySimpleFragment.a(paramContext, paramBluedLiveState);
      return;
    } 
    if (paramBluedLiveState.has_audited == 0) {
      LiveApplyVerifyFragment.a(paramContext, paramBluedLiveState);
      return;
    } 
    LiveApplySimpleFragment.a(paramContext, paramBluedLiveState);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt) {
    b = new NearbyLiveSourceModel();
    NearbyLiveSourceModel nearbyLiveSourceModel = b;
    nearbyLiveSourceModel.b = paramString1;
    nearbyLiveSourceModel.a = paramString2;
    nearbyLiveSourceModel.c = paramInt;
  }
  
  public static String b() {
    NearbyLiveSourceModel nearbyLiveSourceModel = b;
    return (nearbyLiveSourceModel == null) ? "" : nearbyLiveSourceModel.a;
  }
  
  private static String b(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getLevelName richLevel=");
    stringBuilder.append(paramInt);
    Log.v("pk", stringBuilder.toString());
    if (paramInt == 30)
      return "男爵"; 
    if (paramInt == 31)
      return "子爵"; 
    if (paramInt == 32)
      return "伯爵"; 
    if (paramInt == 33)
      return "公爵"; 
    if (paramInt == 34)
      return "国王"; 
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    return stringBuilder.toString();
  }
  
  public static int c() {
    NearbyLiveSourceModel nearbyLiveSourceModel = b;
    return (nearbyLiveSourceModel == null) ? 0 : nearbyLiveSourceModel.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\liv\\utils\LiveUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */