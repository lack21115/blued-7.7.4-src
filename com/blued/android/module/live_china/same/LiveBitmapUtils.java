package com.blued.android.module.live_china.same;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.module.live_china.R;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class LiveBitmapUtils {
  public static int a(Context paramContext, ImageView paramImageView, int paramInt) {
    return a(paramContext, paramImageView, paramInt, true);
  }
  
  public static int a(Context paramContext, ImageView paramImageView, int paramInt, boolean paramBoolean) {
    if (paramInt >= 0) {
      int i = paramInt;
      if (paramInt >= 34)
        i = 34; 
      if (i < 10) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("00");
        stringBuilder1.append(i);
        str = stringBuilder1.toString();
      } else if (i < 100) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("0");
        stringBuilder1.append(i);
        str = stringBuilder1.toString();
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(i);
        stringBuilder1.append("");
        str = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("rich");
      stringBuilder.append(str);
      String str = stringBuilder.toString();
      paramInt = paramContext.getResources().getIdentifier(str, "drawable", paramContext.getPackageName());
      if (paramImageView != null) {
        paramImageView.setImageResource(paramInt);
        if (i == 0 && paramBoolean) {
          paramImageView.setVisibility(8);
          return paramInt;
        } 
        paramImageView.setVisibility(0);
      } 
      return paramInt;
    } 
    if (paramImageView != null)
      paramImageView.setVisibility(8); 
    return -1;
  }
  
  public static Bitmap a(String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, options);
    int i = options.outWidth / paramInt;
    paramInt = options.outHeight / paramInt;
    if (i > 1 || paramInt > 1)
      if (i > paramInt) {
        options.inSampleSize = i;
      } else {
        options.inSampleSize = paramInt;
      }  
    options.inJustDecodeBounds = false;
    try {
      return BitmapFactory.decodeFile(paramString, options);
    } catch (OutOfMemoryError outOfMemoryError) {
      MemoryRequest.a().b();
      return null;
    } 
  }
  
  public static Drawable a() {
    return AppInfo.d().getResources().getDrawable(R.drawable.icon_live_manager);
  }
  
  public static Drawable a(Context paramContext, int paramInt) {
    paramInt = a(paramContext, (ImageView)null, paramInt);
    return (paramInt != -1) ? paramContext.getResources().getDrawable(paramInt) : null;
  }
  
  public static void a(Bitmap paramBitmap, String paramString, int paramInt) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      paramBitmap.compress(Bitmap.CompressFormat.PNG, paramInt, byteArrayOutputStream);
      FileOutputStream fileOutputStream = new FileOutputStream(paramString);
      fileOutputStream.write(byteArrayOutputStream.toByteArray());
      Logger.a("drb", new Object[] { "baos.size() = ", Integer.valueOf(byteArrayOutputStream.size()) });
      fileOutputStream.flush();
      fileOutputStream.close();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\same\LiveBitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */