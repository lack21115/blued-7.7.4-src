package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.TerminalActivity;

public class ShowAlbumActivity extends TerminalActivity {
  public static TerminalActivity.WrapIntent a(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    return new TerminalActivity.WrapIntent(paramContext, paramClass, paramBundle, ShowAlbumActivity.class);
  }
  
  public static void b(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    a(paramContext, paramClass, paramBundle).b();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    a(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\ShowAlbumActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */