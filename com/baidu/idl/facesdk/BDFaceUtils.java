package com.baidu.idl.facesdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.InputStream;

public class BDFaceUtils {
  public static boolean hasModel(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return false; 
      try {
        InputStream inputStream = paramContext.getAssets().open(paramString);
        if (inputStream != null)
          return true; 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\idl\facesdk\BDFaceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */