package com.blued.android.core.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

public class FixAndroid7WebviewCrashActivity extends TerminalActivity {
  public static TerminalActivity.WrapIntent a(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    return new TerminalActivity.WrapIntent(paramContext, paramClass, paramBundle, FixAndroid7WebviewCrashActivity.class);
  }
  
  public static void b(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    a(paramContext, paramClass, paramBundle).b();
  }
  
  public AssetManager getAssets() {
    return getResources().getAssets();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\FixAndroid7WebviewCrashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */