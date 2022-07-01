package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.HashSet;

public class aa {
  private static final boolean a;
  
  private static final boolean b = a();
  
  private static int c = -1;
  
  private static int d = -1;
  
  private static int e = -1;
  
  private static Handler f = null;
  
  private static final HashSet<String> g;
  
  private static final HashSet<String> h;
  
  static {
    HashSet<String> hashSet = new HashSet();
    hashSet.add("HUAWEI C8812");
    hashSet.add("HUAWEI C8812E");
    hashSet.add("HUAWEI C8825D");
    hashSet.add("HUAWEI U8825D");
    hashSet.add("HUAWEI C8950D");
    hashSet.add("HUAWEI U8950D");
    g = hashSet;
    hashSet = new HashSet<String>();
    hashSet.add("ZTE V955");
    hashSet.add("ZTE N881E");
    hashSet.add("ZTE N881F");
    hashSet.add("ZTE N880G");
    hashSet.add("ZTE N880F");
    hashSet.add("ZTE V889F");
    h = hashSet;
  }
  
  public static void a(Context paramContext, WebView paramWebView) {
    if (paramContext != null) {
      if (paramWebView == null)
        return; 
      if (paramContext instanceof Activity) {
        Activity activity = (Activity)paramContext;
        if (activity.isFinishing())
          try {
            paramWebView.loadUrl("about:blank");
            if (e > 0) {
              View view = paramWebView.getRootView();
              if (view instanceof ViewGroup) {
                View view1 = ((ViewGroup)view).getChildAt(0);
                view1.setDrawingCacheEnabled(true);
                Bitmap bitmap = Bitmap.createBitmap(view1.getDrawingCache());
                view1.setDrawingCacheEnabled(false);
                ImageView imageView = new ImageView((Context)activity);
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(0);
                ((ViewGroup)view).addView((View)imageView, new ViewGroup.LayoutParams(-1, -1));
              } 
            } 
            return;
          } catch (Exception exception) {
            return;
          }  
      } 
    } 
  }
  
  public static void a(WebView paramWebView) {
    if (paramWebView == null)
      return; 
    paramWebView.setWebChromeClient(null);
    paramWebView.setWebViewClient(null);
    ViewParent viewParent = paramWebView.getParent();
    if (viewParent != null && viewParent instanceof ViewGroup)
      ((ViewGroup)viewParent).removeView((View)paramWebView); 
    paramWebView.removeAllViews();
    try {
      return;
    } finally {
      paramWebView = null;
    } 
  }
  
  private static boolean a() {
    return (a || (Build.VERSION.SDK_INT == 16 && "ZTE N5".equals(Build.MODEL)));
  }
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 16 && ac.e()) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */