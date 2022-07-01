package com.blued.android.core.image;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;

public final class GlideApp {
  public static GlideRequests a(Activity paramActivity) {
    return (GlideRequests)Glide.a(paramActivity);
  }
  
  public static GlideRequests a(Fragment paramFragment) {
    return (GlideRequests)Glide.a(paramFragment);
  }
  
  public static GlideRequests a(FragmentActivity paramFragmentActivity) {
    return (GlideRequests)Glide.a(paramFragmentActivity);
  }
  
  public static Glide a(Context paramContext) {
    return Glide.a(paramContext);
  }
  
  public static GlideRequests b(Context paramContext) {
    return (GlideRequests)Glide.b(paramContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\GlideApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */