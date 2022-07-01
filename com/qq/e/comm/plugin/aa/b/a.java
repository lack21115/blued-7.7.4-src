package com.qq.e.comm.plugin.aa.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.p.b;
import com.qq.e.comm.plugin.p.e;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.plugin.y.u;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

public class a {
  private static Map<String, WeakReference<Bitmap>> a = new LinkedHashMap<String, WeakReference<Bitmap>>();
  
  public static void a(ViewGroup paramViewGroup) {
    if (b()) {
      ak.a("BGBlurHelper", "BG Blur disable");
      return;
    } 
    if (paramViewGroup != null) {
      View view2 = paramViewGroup.findViewWithTag("blurImage");
      View view1 = paramViewGroup.findViewWithTag("blurBG");
      if (view2 != null)
        view2.setVisibility(0); 
      if (view1 != null)
        view1.setVisibility(0); 
    } 
  }
  
  public static void a(ViewGroup paramViewGroup, String paramString, f paramf) {
    a(paramViewGroup, paramString, paramf, false);
  }
  
  public static void a(ViewGroup paramViewGroup, String paramString, f paramf, int paramInt, boolean paramBoolean) {
    String str;
    if (b()) {
      str = "BG Blur disable";
    } else if (str == null || TextUtils.isEmpty(paramString)) {
      str = "viewGroup or imgUrl null";
    } else if (Build.VERSION.SDK_INT < 17) {
      str = "RenderScript nonsupport SDK level";
    } else {
      View view1 = str.findViewWithTag("blurImage");
      View view2 = str.findViewWithTag("blurBG");
      if (view1 != null && view2 != null) {
        view1.setVisibility(0);
        view2.setVisibility(0);
        str = "already do blur, just show.";
      } else {
        if (paramBoolean) {
          b((ViewGroup)str, paramString, paramInt);
          return;
        } 
        if (paramf != null) {
          str.postDelayed(new Runnable(paramf, (ViewGroup)str, paramString, paramInt) {
                public void run() {
                  if (this.a != null) {
                    ViewGroup viewGroup = this.b;
                    if (viewGroup == null)
                      return; 
                    int i = viewGroup.getMeasuredWidth();
                    int j = this.a.getMeasuredHeight();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("containWidth : ");
                    stringBuilder.append(i);
                    stringBuilder.append(" ,containHeight : ");
                    stringBuilder.append(j);
                    ak.a("BGBlurHelper", stringBuilder.toString());
                    int k = this.a.getMeasuredWidth();
                    int m = this.a.getMeasuredHeight();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("videoWidth : ");
                    stringBuilder.append(k);
                    stringBuilder.append(" ,videoHeight : ");
                    stringBuilder.append(m);
                    ak.a("BGBlurHelper", stringBuilder.toString());
                    if (i > k || j > m) {
                      a.a(this.b, this.c, this.d);
                      return;
                    } 
                    ak.a("BGBlurHelper", "no need blur");
                    return;
                  } 
                }
              }50L);
          return;
        } 
        return;
      } 
    } 
    ak.a("BGBlurHelper", str);
  }
  
  public static void a(ViewGroup paramViewGroup, String paramString, f paramf, boolean paramBoolean) {
    a(paramViewGroup, paramString, paramf, Color.parseColor("#88444444"), paramBoolean);
  }
  
  private static Bitmap b(Bitmap paramBitmap, Context paramContext) {
    if (Build.VERSION.SDK_INT >= 17) {
      RenderScript renderScript = RenderScript.create(paramContext);
      if (renderScript != null) {
        Allocation allocation = Allocation.createFromBitmap(renderScript, paramBitmap);
        if (allocation != null) {
          ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, allocation.getElement());
          if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.setInput(allocation);
            scriptIntrinsicBlur.setRadius(5.0F);
            scriptIntrinsicBlur.forEach(allocation);
            allocation.copyTo(paramBitmap);
          } 
        } 
        renderScript.destroy();
      } 
    } 
    return paramBitmap;
  }
  
  public static void b(ViewGroup paramViewGroup) {
    if (b()) {
      ak.a("BGBlurHelper", "BG Blur disable");
      return;
    } 
    if (paramViewGroup != null) {
      View view2 = paramViewGroup.findViewWithTag("blurImage");
      View view1 = paramViewGroup.findViewWithTag("blurBG");
      if (view2 != null)
        view2.setVisibility(4); 
      if (view1 != null)
        view1.setVisibility(4); 
    } 
  }
  
  private static void b(ViewGroup paramViewGroup, String paramString, int paramInt) {
    long l = System.currentTimeMillis();
    ImageView imageView1 = new ImageView(paramViewGroup.getContext());
    imageView1.setTag("blurImage");
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    imageView1.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ImageView imageView2 = new ImageView(paramViewGroup.getContext());
    imageView2.setTag("blurBG");
    imageView2.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
    imageView2.setBackgroundColor(paramInt);
    paramViewGroup.addView((View)imageView2, 0);
    WeakReference<Bitmap> weakReference = a.get(paramString);
    if (weakReference != null && weakReference.get() != null) {
      ak.a("BGBlurHelper", "BG Blur hit cache");
      b(imageView1, weakReference.get(), paramViewGroup, l);
      return;
    } 
    com.qq.e.comm.plugin.p.a.a().a(paramString, imageView1, new b(l, paramViewGroup, imageView1) {
          public void a(String param1String, int param1Int, Exception param1Exception) {}
          
          public void a(String param1String, ImageView param1ImageView, e param1e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("BG Blur download image cost : ");
            stringBuilder.append(System.currentTimeMillis() - this.a);
            ak.a("BGBlurHelper", stringBuilder.toString());
            t.a.submit(new Runnable(this, param1e, param1String) {
                  public void run() {
                    Bitmap bitmap = this.a.a();
                    if (bitmap == null)
                      return; 
                    bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    Matrix matrix = new Matrix();
                    matrix.preScale(0.25F, 0.25F);
                    bitmap = a.a(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false), this.c.b.getContext());
                    a.a().put(this.b, new WeakReference<Bitmap>(bitmap));
                    (new Handler(Looper.getMainLooper())).post(new Runnable(this, bitmap) {
                          public void run() {
                            a.a(this.b.c.c, this.a, this.b.c.b, this.b.c.a);
                          }
                        });
                  }
                });
          }
        });
  }
  
  private static void b(ImageView paramImageView, Bitmap paramBitmap, ViewGroup paramViewGroup, long paramLong) {
    if (paramBitmap != null && !paramBitmap.isRecycled()) {
      if (paramViewGroup == null)
        return; 
      paramImageView.setImageBitmap(paramBitmap);
      paramImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.addView((View)paramImageView, 0);
      paramLong = System.currentTimeMillis() - paramLong;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("BG Blur cost : ");
      stringBuilder.append(paramLong);
      ak.a("BGBlurHelper", stringBuilder.toString());
      u.a(100282, (int)paramLong / 50, null);
    } 
  }
  
  private static boolean b() {
    return (GDTADManager.getInstance().getSM().getInteger("videoBGBlur", 1) == 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\aa\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */