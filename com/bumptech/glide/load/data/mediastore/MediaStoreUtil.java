package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;

public final class MediaStoreUtil {
  public static boolean a(int paramInt1, int paramInt2) {
    return (paramInt1 != Integer.MIN_VALUE && paramInt2 != Integer.MIN_VALUE && paramInt1 <= 512 && paramInt2 <= 384);
  }
  
  public static boolean a(Uri paramUri) {
    return (paramUri != null && "content".equals(paramUri.getScheme()) && "media".equals(paramUri.getAuthority()));
  }
  
  public static boolean b(Uri paramUri) {
    return (a(paramUri) && d(paramUri));
  }
  
  public static boolean c(Uri paramUri) {
    return (a(paramUri) && !d(paramUri));
  }
  
  private static boolean d(Uri paramUri) {
    return paramUri.getPathSegments().contains("video");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\mediastore\MediaStoreUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */