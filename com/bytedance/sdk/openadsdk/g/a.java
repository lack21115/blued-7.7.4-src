package com.bytedance.sdk.openadsdk.g;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.b.a;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.WeakHashMap;

class a extends a {
  private static String b;
  
  private WeakHashMap<String, String> c = new WeakHashMap<String, String>();
  
  private final com.bytedance.sdk.openadsdk.b.a d = (com.bytedance.sdk.openadsdk.b.a)new d();
  
  public static a a() {
    return new a();
  }
  
  private static String b() {
    if (TextUtils.isEmpty(b)) {
      File file = new File(com.bytedance.sdk.adnet.a.b(o.a()), "diskImage");
      file.mkdirs();
      b = file.getAbsolutePath();
    } 
    return b;
  }
  
  public Bitmap a(String paramString) {
    Bitmap bitmap1 = super.a(paramString);
    Bitmap bitmap2 = bitmap1;
    if (bitmap1 == null) {
      File file = new File(b(), paramString);
      bitmap2 = bitmap1;
      if (file.exists()) {
        try {
        
        } finally {
          bitmap2 = null;
          file = null;
        } 
        try {
          File file1;
          t.c("DiskImageCache", "diskImageCache getBitmap error ", (Throwable)bitmap2);
          bitmap2 = null;
          if (file != null) {
            bitmap1 = null;
            file1 = file;
          } else {
            return bitmap2;
          } 
        } finally {
          if (file != null)
            try {
              file.close();
            } catch (IOException iOException) {} 
        } 
      } 
    } 
    return bitmap2;
  }
  
  public String a(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    String str = this.c.get(paramString);
    if (!TextUtils.isEmpty(str))
      return str; 
    str = j.a(paramString);
    this.c.put(paramString, str);
    return str;
  }
  
  public void a(String paramString, Bitmap paramBitmap) {
    if (paramBitmap == null)
      return; 
    super.a(paramString, paramBitmap);
    File file1 = new File(b(), paramString);
    if (file1.exists() && file1.isFile() && file1.length() > 0L)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file1);
    stringBuilder.append(".tmp");
    File file2 = new File(stringBuilder.toString());
    file2.delete();
    try {
      file2.createNewFile();
      FileOutputStream fileOutputStream = new FileOutputStream(file2);
    } finally {
      paramBitmap = null;
    } 
    try {
      t.c("DiskImageCache", "diskImageCache putBitmap error ", (Throwable)paramBitmap);
      file2.delete();
      file1.delete();
      if (stringBuilder == null)
        return; 
    } finally {
      if (iOException != null)
        try {
          iOException.close();
        } catch (IOException iOException1) {} 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */