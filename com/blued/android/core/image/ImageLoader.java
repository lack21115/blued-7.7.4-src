package com.blued.android.core.image;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import java.io.File;

public class ImageLoader {
  private static boolean a = false;
  
  public static ImageWrapper a(IRequestHost paramIRequestHost, int paramInt) {
    return new ImageWrapper(paramIRequestHost, (RequestBuilder)a(paramIRequestHost).e().b(Integer.valueOf(paramInt)).b(DiskCacheStrategy.d));
  }
  
  public static ImageWrapper a(IRequestHost paramIRequestHost, File paramFile) {
    File file = paramFile;
    if (paramFile == null)
      file = new File(""); 
    return new ImageWrapper(paramIRequestHost, (RequestBuilder)a(paramIRequestHost).e().b(file).b(DiskCacheStrategy.a));
  }
  
  public static ImageWrapper a(IRequestHost paramIRequestHost, String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    return new ImageWrapper(paramIRequestHost, (RequestBuilder)a(paramIRequestHost).e().b(str).b(DiskCacheStrategy.a));
  }
  
  protected static RequestManager a(IRequestHost paramIRequestHost) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 67
    //   4: aload_0
    //   5: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;)Ljava/lang/Object;
    //   8: astore_0
    //   9: aload_0
    //   10: ifnull -> 67
    //   13: aload_0
    //   14: instanceof androidx/fragment/app/Fragment
    //   17: ifeq -> 31
    //   20: aload_0
    //   21: checkcast androidx/fragment/app/Fragment
    //   24: invokestatic a : (Landroidx/fragment/app/Fragment;)Lcom/blued/android/core/image/GlideRequests;
    //   27: astore_0
    //   28: goto -> 69
    //   31: aload_0
    //   32: instanceof androidx/fragment/app/FragmentActivity
    //   35: ifeq -> 49
    //   38: aload_0
    //   39: checkcast androidx/fragment/app/FragmentActivity
    //   42: invokestatic a : (Landroidx/fragment/app/FragmentActivity;)Lcom/blued/android/core/image/GlideRequests;
    //   45: astore_0
    //   46: goto -> 69
    //   49: aload_0
    //   50: instanceof android/app/Activity
    //   53: ifeq -> 67
    //   56: aload_0
    //   57: checkcast android/app/Activity
    //   60: invokestatic a : (Landroid/app/Activity;)Lcom/blued/android/core/image/GlideRequests;
    //   63: astore_0
    //   64: goto -> 69
    //   67: aconst_null
    //   68: astore_0
    //   69: aload_0
    //   70: astore_1
    //   71: aload_0
    //   72: ifnonnull -> 82
    //   75: invokestatic d : ()Landroid/content/Context;
    //   78: invokestatic b : (Landroid/content/Context;)Lcom/blued/android/core/image/GlideRequests;
    //   81: astore_1
    //   82: aload_1
    //   83: areturn
  }
  
  private static String a(String paramString1, String paramString2) {
    String str = paramString1;
    if (paramString1.startsWith(paramString2))
      str = paramString1.substring(paramString2.length()); 
    return str;
  }
  
  public static void a(int paramInt) {
    if (AppInfo.d() != null)
      GlideApp.a(AppInfo.d()).a(paramInt); 
  }
  
  public static void a(IRequestHost paramIRequestHost, ImageView paramImageView) {
    if (paramImageView != null)
      a(paramIRequestHost).a((View)paramImageView); 
  }
  
  public static void a(IRequestHost paramIRequestHost, Target<Drawable> paramTarget) {
    if (paramTarget != null)
      a(paramIRequestHost).a(paramTarget); 
  }
  
  public static boolean a() {
    return a;
  }
  
  public static ImageWrapper b(IRequestHost paramIRequestHost, String paramString) {
    String str;
    if (paramString == null) {
      str = "";
    } else {
      str = paramString;
      if (!paramString.startsWith("content://")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("content://");
        stringBuilder.append(paramString);
        str = stringBuilder.toString();
      } 
    } 
    return new ImageWrapper(paramIRequestHost, (RequestBuilder)a(paramIRequestHost).e().b(Uri.parse(str)).b(DiskCacheStrategy.a));
  }
  
  public static void b() {
    if (AppInfo.d() != null)
      GlideApp.a(AppInfo.d()).f(); 
  }
  
  public static ImageWrapper c(IRequestHost paramIRequestHost, String paramString) {
    if (paramString == null) {
      paramString = "";
    } else {
      paramString = a(paramString, "assets://");
    } 
    RequestBuilder requestBuilder = a(paramIRequestHost).e();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("file:///android_asset/");
    stringBuilder.append(paramString);
    return new ImageWrapper(paramIRequestHost, (RequestBuilder)requestBuilder.b(Uri.parse(stringBuilder.toString())).b(DiskCacheStrategy.d));
  }
  
  public static ImageWrapper d(IRequestHost paramIRequestHost, String paramString) {
    if (paramString == null) {
      paramString = "";
    } else {
      paramString = a(paramString, "file://");
    } 
    return a(paramIRequestHost, new File(paramString));
  }
  
  public static interface OnAnimationStateListener {
    void a();
    
    void b();
  }
  
  public static interface OnClearDiskCacheListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */