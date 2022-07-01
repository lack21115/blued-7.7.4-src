package com.soft.blued.ui.welcome;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.TerminalActivity;

public class WelcomeActivity extends TerminalActivity {
  public static TerminalActivity.WrapIntent a(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    return new TerminalActivity.WrapIntent(paramContext, paramClass, paramBundle, WelcomeActivity.class);
  }
  
  public static void b(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    a(paramContext, paramClass, paramBundle).b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\welcome\WelcomeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */