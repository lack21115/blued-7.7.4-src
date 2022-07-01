package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;

public class aq {
  public static Bitmap a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      byte[] arrayOfByte = Base64.decode(paramString, 0);
      if (arrayOfByte != null && arrayOfByte.length > 0)
        return BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length); 
    } 
    return null;
  }
  
  public static Drawable a(Context paramContext, String paramString) {
    if (paramContext != null && !TextUtils.isEmpty(paramString)) {
      Resources resources = paramContext.getResources();
      if (resources != null)
        try {
          return resources.getDrawable(resources.getIdentifier(paramString, "drawable", paramContext.getPackageName()));
        } catch (Exception exception) {
          ba.b("Drawable 资源 输入有误");
        }  
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */