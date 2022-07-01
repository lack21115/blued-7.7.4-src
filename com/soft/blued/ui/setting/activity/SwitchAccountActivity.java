package com.soft.blued.ui.setting.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import skin.support.SkinCompatManager;

public class SwitchAccountActivity extends BaseFragmentActivity {
  private View c;
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.c = (View)new FrameLayout((Context)this);
    this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.c.setId(2131299753);
    setContentView(this.c);
    if (StatusBarHelper.a((Activity)this, AppInfo.i())) {
      this.c.setFitsSystemWindows(true);
      Drawable drawable = StatusBarHelper.a((Context)this, AppInfo.k(), AppInfo.l(), AppInfo.j(), true);
      getWindow().setBackgroundDrawable(drawable);
      if (SkinCompatManager.a() != null)
        findViewById(16908290).setBackgroundColor(BluedSkinUtils.a((Context)this, AppInfo.k())); 
    } 
    try {
      return;
    } finally {
      paramBundle = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\activity\SwitchAccountActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */