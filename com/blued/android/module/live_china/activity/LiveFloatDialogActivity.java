package com.blued.android.module.live_china.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;

public class LiveFloatDialogActivity extends BaseActivity {
  public int e = 0;
  
  public long f;
  
  CustomDialog g;
  
  public View h;
  
  private void g() {
    CustomDialog customDialog = this.g;
    if (customDialog != null && customDialog.isShowing())
      this.g.dismiss(); 
    finish();
    LiveRoomInfo.a().a((Activity)this);
  }
  
  public void d() {
    ((TextView)this.h.findViewById(R.id.tv_des)).setText(getString(R.string.live_float_dialog_des));
  }
  
  public void e() {
    LiveFloatManager.a().a(this.f);
  }
  
  public void f() {
    LiveFloatManager.a().m();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt1 == 1) {
      if (Build.VERSION.SDK_INT >= 23) {
        if (Settings.canDrawOverlays(AppInfo.d())) {
          e();
        } else {
          f();
        } 
      } else {
        e();
      } 
      g();
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (getIntent() != null && getIntent().getExtras() != null) {
      this.e = getIntent().getExtras().getInt("flag", 0);
      if (this.e == 2)
        this.f = getIntent().getExtras().getLong("timer", 0L); 
    } 
    if (this.e == 0) {
      g();
      return;
    } 
    this.h = LayoutInflater.from((Context)this).inflate(R.layout.layout_common_dialog, null);
    int i = this.e;
    if (1 == i) {
      ((TextView)this.h.findViewById(R.id.tv_title)).setVisibility(8);
      TextView textView = (TextView)this.h.findViewById(R.id.tv_cancel);
      textView.setText(getString(R.string.live_window_permisson_cancel));
      textView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              LiveFloatDialogActivity.a(this.a);
            }
          });
      textView = (TextView)this.h.findViewById(R.id.tv_ok);
      textView.setText(R.string.live_window_permisson_ok);
      textView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
              intent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
              this.a.startActivity(intent);
              LiveFloatDialogActivity.a(this.a);
            }
          });
      ((TextView)this.h.findViewById(R.id.tv_des)).setText(getString(R.string.live_window_permisson_title));
    } else if (2 == i) {
      TextView textView = (TextView)this.h.findViewById(R.id.tv_title);
      textView.setText(R.string.live_float_dialog_title);
      textView.setVisibility(8);
      textView = (TextView)this.h.findViewById(R.id.tv_cancel);
      textView.setText(getString(R.string.biao_v4_cancel));
      textView.setVisibility(8);
      this.h.findViewById(R.id.tv_divide).setVisibility(8);
      textView = (TextView)this.h.findViewById(R.id.tv_ok);
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
                LiveFloatDialogActivity.a(this.a);
                return;
              } 
            }
          });
      d();
    } else {
      g();
    } 
    this.g = new CustomDialog((Context)this, R.style.TranslucentBackground);
    this.g.a(this.h, new CustomDialog.OnBackCallBack(this) {
          public void a() {
            if (this.a.e == 2)
              this.a.f(); 
            LiveFloatDialogActivity.a(this.a);
          }
        });
    if (Build.VERSION.SDK_INT >= 21) {
      Window window = this.g.getWindow();
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
    LiveRoomInfo.a().a((Activity)this);
    if (getIntent() != null && getIntent().getExtras() != null) {
      this.e = getIntent().getExtras().getInt("flag", 0);
      if (this.e == 2)
        this.f = getIntent().getExtras().getLong("timer", 0L); 
    } 
    if (this.e == 0)
      g(); 
    super.onCreate(paramBundle, paramPersistableBundle);
  }
  
  public void onResume() {
    super.onResume();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\activity\LiveFloatDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */