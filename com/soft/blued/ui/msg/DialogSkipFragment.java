package com.soft.blued.ui.msg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.soft.blued.ui.find.manager.FlashZegoApiManager;
import com.soft.blued.ui.msg.model.ChannelModel;

public class DialogSkipFragment extends BaseFragment implements View.OnClickListener {
  private ChannelModel d;
  
  private Context e;
  
  private View f;
  
  private CustomDialog g;
  
  private boolean h = false;
  
  private int i = 0;
  
  public static void a(Context paramContext, int paramInt) {
    // Byte code:
    //   0: ldc com/soft/blued/ui/msg/DialogSkipFragment
    //   2: monitorenter
    //   3: new android/os/Bundle
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore_2
    //   11: aload_2
    //   12: ldc 'flag'
    //   14: iload_1
    //   15: invokevirtual putInt : (Ljava/lang/String;I)V
    //   18: aload_2
    //   19: invokestatic a : (Landroid/os/Bundle;)Landroid/os/Bundle;
    //   22: pop
    //   23: aload_0
    //   24: ldc com/soft/blued/ui/msg/DialogSkipFragment
    //   26: aload_2
    //   27: invokestatic b : (Landroid/content/Context;Ljava/lang/Class;Landroid/os/Bundle;)V
    //   30: ldc com/soft/blued/ui/msg/DialogSkipFragment
    //   32: monitorexit
    //   33: return
    //   34: astore_0
    //   35: ldc com/soft/blued/ui/msg/DialogSkipFragment
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   3	30	34	finally
  }
  
  public static void a(Context paramContext, ChannelModel paramChannelModel) {
    // Byte code:
    //   0: ldc com/soft/blued/ui/msg/DialogSkipFragment
    //   2: monitorenter
    //   3: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   6: invokevirtual F : ()Z
    //   9: ifeq -> 44
    //   12: new android/os/Bundle
    //   15: dup
    //   16: invokespecial <init> : ()V
    //   19: astore_2
    //   20: aload_2
    //   21: ldc 'flag'
    //   23: iconst_0
    //   24: invokevirtual putInt : (Ljava/lang/String;I)V
    //   27: aload_2
    //   28: ldc 'CHANNEL'
    //   30: aload_1
    //   31: invokevirtual putSerializable : (Ljava/lang/String;Ljava/io/Serializable;)V
    //   34: aload_0
    //   35: ldc com/soft/blued/ui/msg/DialogSkipFragment
    //   37: aload_2
    //   38: invokestatic b : (Landroid/content/Context;Ljava/lang/Class;Landroid/os/Bundle;)V
    //   41: goto -> 158
    //   44: invokestatic a : ()Lcom/soft/blued/ui/find/manager/FlashZegoApiManager;
    //   47: invokevirtual e : ()Z
    //   50: ifeq -> 85
    //   53: new android/os/Bundle
    //   56: dup
    //   57: invokespecial <init> : ()V
    //   60: astore_2
    //   61: aload_2
    //   62: ldc 'flag'
    //   64: iconst_3
    //   65: invokevirtual putInt : (Ljava/lang/String;I)V
    //   68: aload_2
    //   69: ldc 'CHANNEL'
    //   71: aload_1
    //   72: invokevirtual putSerializable : (Ljava/lang/String;Ljava/io/Serializable;)V
    //   75: aload_0
    //   76: ldc com/soft/blued/ui/msg/DialogSkipFragment
    //   78: aload_2
    //   79: invokestatic b : (Landroid/content/Context;Ljava/lang/Class;Landroid/os/Bundle;)V
    //   82: goto -> 158
    //   85: invokestatic e : ()Lcom/blued/android/module/base/shortvideo/ShortVideoProxy;
    //   88: invokevirtual a : ()Z
    //   91: ifeq -> 126
    //   94: new android/os/Bundle
    //   97: dup
    //   98: invokespecial <init> : ()V
    //   101: astore_2
    //   102: aload_2
    //   103: ldc 'flag'
    //   105: iconst_5
    //   106: invokevirtual putInt : (Ljava/lang/String;I)V
    //   109: aload_2
    //   110: ldc 'CHANNEL'
    //   112: aload_1
    //   113: invokevirtual putSerializable : (Ljava/lang/String;Ljava/io/Serializable;)V
    //   116: aload_0
    //   117: ldc com/soft/blued/ui/msg/DialogSkipFragment
    //   119: aload_2
    //   120: invokestatic b : (Landroid/content/Context;Ljava/lang/Class;Landroid/os/Bundle;)V
    //   123: goto -> 158
    //   126: invokestatic e : ()Lcom/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager;
    //   129: invokevirtual h : ()Z
    //   132: ifeq -> 151
    //   135: aload_0
    //   136: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   139: ldc 2131759450
    //   141: invokevirtual getText : (I)Ljava/lang/CharSequence;
    //   144: invokestatic a : (Ljava/lang/CharSequence;)V
    //   147: ldc com/soft/blued/ui/msg/DialogSkipFragment
    //   149: monitorexit
    //   150: return
    //   151: invokestatic d : ()Landroid/content/Context;
    //   154: aload_1
    //   155: invokestatic a : (Landroid/content/Context;Lcom/soft/blued/ui/msg/model/ChannelModel;)V
    //   158: ldc com/soft/blued/ui/msg/DialogSkipFragment
    //   160: monitorexit
    //   161: return
    //   162: astore_0
    //   163: ldc com/soft/blued/ui/msg/DialogSkipFragment
    //   165: monitorexit
    //   166: aload_0
    //   167: athrow
    // Exception table:
    //   from	to	target	type
    //   3	41	162	finally
    //   44	82	162	finally
    //   85	123	162	finally
    //   126	147	162	finally
    //   151	158	162	finally
  }
  
  public void a() {
    CustomDialog customDialog = this.g;
    if (customDialog != null && customDialog.isShowing())
      this.g.dismiss(); 
    getActivity().finish();
  }
  
  public void k() {
    CustomDialog customDialog = this.g;
    if (customDialog != null && customDialog.isShowing())
      return; 
    this.f.postDelayed(new Runnable(this) {
          public void run() {
            View view1 = LayoutInflater.from(DialogSkipFragment.a(this.a)).inflate(2131493743, null);
            view1.findViewById(2131301409).setVisibility(8);
            TextView textView1 = (TextView)view1.findViewById(2131300611);
            textView1.setText(this.a.getString(2131755577));
            textView1.setOnClickListener(this.a);
            TextView textView2 = (TextView)view1.findViewById(2131301130);
            textView2.setText(2131755597);
            textView2.setOnClickListener(this.a);
            View view2 = view1.findViewById(2131300719);
            TextView textView3 = (TextView)view1.findViewById(2131300703);
            if (DialogSkipFragment.b(this.a) == 0) {
              if ((DialogSkipFragment.c(this.a)).callType == 0 || (DialogSkipFragment.c(this.a)).callType == 1) {
                DialogSkipFragment.a(this.a, true);
                textView3.setText(this.a.getString(2131755785));
                textView2.setText(this.a.getString(2131757775));
                view2.setVisibility(8);
                textView1.setVisibility(8);
              } else {
                DialogSkipFragment.a(this.a, false);
                textView3.setText(this.a.getString(2131755754));
              } 
            } else if (DialogSkipFragment.b(this.a) == 1) {
              textView3.setText(this.a.getString(2131755783));
              textView2.setText(this.a.getString(2131757775));
              view2.setVisibility(8);
              textView1.setVisibility(8);
            } else if (DialogSkipFragment.b(this.a) == 2) {
              textView3.setText(this.a.getString(2131755782));
              textView2.setText(this.a.getString(2131757775));
              view2.setVisibility(8);
              textView1.setVisibility(8);
            } else if (DialogSkipFragment.b(this.a) == 3) {
              textView3.setText(this.a.getString(2131756511));
            } else if (DialogSkipFragment.b(this.a) == 4) {
              textView3.setText(this.a.getString(2131755784));
              textView2.setText(this.a.getString(2131757775));
              view2.setVisibility(8);
              textView1.setVisibility(8);
            } else if (DialogSkipFragment.b(this.a) == 5) {
              textView3.setText(this.a.getString(2131755755));
            } 
            DialogSkipFragment dialogSkipFragment = this.a;
            DialogSkipFragment.a(dialogSkipFragment, new CustomDialog(DialogSkipFragment.a(dialogSkipFragment), 2131821111));
            DialogSkipFragment.d(this.a).a(view1, new CustomDialog.OnBackCallBack(this) {
                  public void a() {
                    this.a.a.getActivity().finish();
                  }
                });
          }
        }300L);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131300611) {
      if (i != 2131301130)
        return; 
      i = this.i;
      if (i == 0) {
        if (!this.h)
          ChannelFragment.a(AppInfo.d(), this.d); 
      } else if (i == 3) {
        if (FlashZegoApiManager.a().e())
          FlashZegoApiManager.a().a(this.d); 
      } else if (i == 5) {
        ShortVideoProxy.e().c();
        ChannelFragment.a(AppInfo.d(), this.d);
      } 
      a();
      return;
    } 
    a();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    paramBundle = getArguments();
    this.i = paramBundle.getInt("flag", 0);
    int i = this.i;
    if (i == 0 || i == 3 || i == 5)
      this.d = (ChannelModel)paramBundle.getSerializable("CHANNEL"); 
    if (this.d == null) {
      i = this.i;
      if (i == 0 || i == 3 || i == 5)
        getActivity().finish(); 
    } 
    this.e = (Context)getActivity();
    View view = this.f;
    if (view == null) {
      this.f = paramLayoutInflater.inflate(2131492936, paramViewGroup, false);
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\DialogSkipFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */