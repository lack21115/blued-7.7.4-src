package com.baidu.mobads.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;
import java.io.ByteArrayOutputStream;

class g implements IXAdBitmapUtils {
  public String bitmap2tring(Bitmap paramBitmap) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
      return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public Bitmap string2bitmap(String paramString) {
    try {
      byte[] arrayOfByte = Base64.decode(paramString, 0);
      return BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */