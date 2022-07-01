package com.soft.blued.ui.msg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.VideoChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.view.tip.dialog.BottomSheetDialogFragment;

public class VideoChatDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener, VideoChatHelper.CallInfoListener {
  private Context a;
  
  private View b;
  
  private LinearLayout c;
  
  private TextView d;
  
  private TextView e;
  
  private TextView f;
  
  private TextView g;
  
  private TextView h;
  
  private TextView i;
  
  private long j;
  
  private VideoChatHelper k;
  
  private void f() {
    this.c = (LinearLayout)this.b.findViewById(2131298099);
    this.d = (TextView)this.b.findViewById(2131300624);
    this.e = (TextView)this.b.findViewById(2131300625);
    this.f = (TextView)this.b.findViewById(2131301450);
    this.g = (TextView)this.b.findViewById(2131301492);
    this.h = (TextView)this.b.findViewById(2131301510);
    this.i = (TextView)this.b.findViewById(2131300611);
    this.c.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }
  
  private void g() {
    ThreadManager.a().a(new ThreadExecutor(this, "startConnect") {
          public void execute() {
            if (VideoChatDialogFragment.a(this.a) != null)
              VideoChatDialogFragment.a(this.a).getLeftTimeAndCount(); 
          }
        });
  }
  
  public void a(long paramLong) {
    this.j = paramLong;
  }
  
  public void onCallClose(int paramInt) {}
  
  public void onCallLeftTime(int paramInt1, int paramInt2) {
    this.b.post(new Runnable(this, paramInt1, paramInt2) {
          public void run() {
            if (this.a > 0 && this.b > 0) {
              String str;
              VideoChatDialogFragment.b(this.c).setVisibility(8);
              VideoChatDialogFragment.c(this.c).setVisibility(8);
              VideoChatDialogFragment.d(this.c).setVisibility(0);
              if (this.a < 60) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(String.format(VideoChatDialogFragment.e(this.c).getString(2131755813), new Object[] { String.valueOf(this.b) }));
                stringBuilder.append("/");
                stringBuilder.append(String.format(VideoChatDialogFragment.e(this.c).getString(2131755817), new Object[] { String.valueOf(this.a) }));
                str = stringBuilder.toString();
              } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(String.format(VideoChatDialogFragment.e(this.c).getString(2131755813), new Object[] { String.valueOf(this.b) }));
                stringBuilder.append("/");
                stringBuilder.append(String.format(VideoChatDialogFragment.e(this.c).getString(2131755815), new Object[] { String.valueOf(this.a / 60) }));
                str = stringBuilder.toString();
              } 
              VideoChatDialogFragment.d(this.c).setText(str);
              return;
            } 
            VideoChatDialogFragment.d(this.c).setVisibility(8);
            VideoChatDialogFragment.b(this.c).setVisibility(8);
            VideoChatDialogFragment.c(this.c).setVisibility(0);
            VideoChatDialogFragment.c(this.c).setText(2131755819);
          }
        });
  }
  
  public void onCallLeftTimeFail() {
    this.b.post(new Runnable(this) {
          public void run() {
            VideoChatDialogFragment.d(this.a).setVisibility(8);
            VideoChatDialogFragment.b(this.a).setVisibility(0);
            VideoChatDialogFragment.c(this.a).setVisibility(0);
            VideoChatDialogFragment.c(this.a).setText(2131755816);
          }
        });
  }
  
  public void onClick(View paramView) {
    ChannelModel channelModel;
    switch (paramView.getId()) {
      default:
        return;
      case 2131301510:
        channelModel = new ChannelModel();
        channelModel.callType = 1;
        channelModel.remoteUid = (int)this.j;
        channelModel.chat_sdk_type = (UserInfo.a().i()).chat_sdk_type;
        DialogSkipFragment.a(AppInfo.d(), channelModel);
        dismiss();
        return;
      case 2131301492:
        channelModel = new ChannelModel();
        channelModel.callType = 0;
        channelModel.remoteUid = (int)this.j;
        channelModel.chat_sdk_type = (UserInfo.a().i()).chat_sdk_type;
        DialogSkipFragment.a(AppInfo.d(), channelModel);
        dismiss();
        return;
      case 2131300611:
        dismiss();
        return;
      case 2131298099:
        break;
    } 
    g();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setStyle(0, 2131820776);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.a = (Context)getActivity();
    View view = this.b;
    if (view == null) {
      this.b = paramLayoutInflater.inflate(2131493035, paramViewGroup, false);
      f();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.b.getParent()).removeView(this.b);
    } 
    this.k = new VideoChatHelper(VideoChatHelper.ROLE.CALLER, 0L, "", 2, (UserInfo.a().i()).chat_sdk_type, this);
    g();
    return this.b;
  }
  
  public void onSwitchToAudio() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\VideoChatDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */