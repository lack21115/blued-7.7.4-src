package com.blued.android.core.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import com.blued.android.core.utils.Log;

public class TransparentActivity extends TerminalActivity {
  private Handler d = new Handler();
  
  private ILoadFinishedListener e;
  
  public static TerminalActivity.WrapIntent a(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    return new TerminalActivity.WrapIntent(paramContext, paramClass, paramBundle, TransparentActivity.class);
  }
  
  public static void b(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    a(paramContext, paramClass, paramBundle).b();
  }
  
  public static void b(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle, int paramInt) {
    a(paramContext, paramClass, paramBundle).a(paramInt);
  }
  
  public static void b(Fragment paramFragment, Class<? extends Fragment> paramClass, Bundle paramBundle, int paramInt) {
    a((Context)paramFragment.getActivity(), paramClass, paramBundle).a(paramInt, paramFragment);
  }
  
  public void onCreate(Bundle paramBundle) {
    Log.c("PendingActivity", "onCreate");
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
  }
  
  public void onDestroy() {
    Log.c("PendingActivity", "onDestory");
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    ILoadFinishedListener iLoadFinishedListener = this.e;
    if (iLoadFinishedListener != null)
      iLoadFinishedListener.a(); 
  }
  
  public static interface ILoadFinishedListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\TransparentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */