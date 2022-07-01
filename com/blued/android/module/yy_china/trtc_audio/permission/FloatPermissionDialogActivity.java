package com.blued.android.module.yy_china.trtc_audio.permission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.trtc_audio.model.FloatPermissionEvent;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class FloatPermissionDialogActivity extends BaseActivity {
  public int e = 0;
  
  CustomDialog f;
  
  View g;
  
  private Handler h = new Handler();
  
  private void a(int paramInt) {
    FloatPermissionEvent floatPermissionEvent = new FloatPermissionEvent();
    floatPermissionEvent.status = paramInt;
    LiveEventBus.get("event_request_float_permission").post(floatPermissionEvent);
  }
  
  private void d() {
    CustomDialog customDialog = this.f;
    if (customDialog != null && customDialog.isShowing())
      this.f.dismiss(); 
    finish();
    overridePendingTransition(0, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      if (Build.VERSION.SDK_INT >= 23) {
        this.h.postDelayed(new Runnable(this) {
              public void run() {
                if (Settings.canDrawOverlays(AppInfo.d())) {
                  FloatPermissionDialogActivity.a(this.a, 0);
                  return;
                } 
                FloatPermissionDialogActivity.a(this.a, 1);
              }
            }1000L);
      } else {
        a(0);
      } 
      d();
    } 
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (getIntent() != null && getIntent().getExtras() != null)
      this.e = getIntent().getExtras().getInt("flag", 0); 
    if (this.e == 0) {
      d();
      return;
    } 
    this.g = LayoutInflater.from((Context)this).inflate(R.layout.float_permission_dialog, null);
    int i = this.e;
    if (1 == i) {
      ((TextView)this.g.findViewById(R.id.tv_title)).setVisibility(8);
      TextView textView = (TextView)this.g.findViewById(R.id.tv_cancel);
      textView.setText(getString(R.string.common_cancel));
      textView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              FloatPermissionDialogActivity.a(this.a);
            }
          });
      textView = (TextView)this.g.findViewById(R.id.tv_ok);
      textView.setText(R.string.setting);
      textView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
              intent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
              this.a.startActivity(intent);
              FloatPermissionDialogActivity.a(this.a);
            }
          });
      ((TextView)this.g.findViewById(R.id.tv_des)).setText(getString(R.string.live_window_permisson_title));
    } else if (2 == i) {
      TextView textView = (TextView)this.g.findViewById(R.id.tv_title);
      textView.setText(R.string.live_float_dialog_title);
      textView.setVisibility(8);
      textView = (TextView)this.g.findViewById(R.id.tv_cancel);
      textView.setText(getString(R.string.common_cancel));
      textView.setVisibility(8);
      this.g.findViewById(R.id.tv_divide).setVisibility(8);
      textView = (TextView)this.g.findViewById(R.id.tv_ok);
      textView.setText(R.string.live_float_dialog_open);
      textView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("package:");
                stringBuilder.append(this.a.getPackageName());
                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(stringBuilder.toString()));
                this.a.startActivityForResult(intent, 1);
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                FloatPermissionDialogActivity.a(this.a);
                return;
              } 
            }
          });
      ((TextView)this.g.findViewById(R.id.tv_des)).setText(getString(R.string.live_float_dialog_des));
    } else {
      d();
    } 
    this.f = new CustomDialog((Context)this, R.style.TranslucentBackground);
    this.f.a(this.g, new CustomDialog.OnBackCallBack(this) {
          public void a() {
            if (this.a.e == 2)
              FloatPermissionDialogActivity.a(this.a, 1); 
            FloatPermissionDialogActivity.a(this.a);
          }
        });
    if (Build.VERSION.SDK_INT >= 21) {
      Window window = getWindow();
      i = window.getDecorView().getSystemUiVisibility();
      if (BluedSkinUtils.c()) {
        i |= 0x10;
      } else {
        i &= 0xFFFFFFEF;
      } 
      window.getDecorView().setSystemUiVisibility(i);
      window.addFlags(-2147483648);
      window.setNavigationBarColor(BluedSkinUtils.a((Context)this, AppInfo.k()));
    } 
  }
  
  public void onCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle) {
    overridePendingTransition(0, 0);
    if (getIntent() != null && getIntent().getExtras() != null)
      this.e = getIntent().getExtras().getInt("flag", 0); 
    if (this.e == 0)
      d(); 
    super.onCreate(paramBundle, paramPersistableBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\trtc_audio\permission\FloatPermissionDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */