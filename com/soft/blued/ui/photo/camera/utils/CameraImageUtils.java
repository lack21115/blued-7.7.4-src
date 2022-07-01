package com.soft.blued.ui.photo.camera.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import com.blued.android.core.AppInfo;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.soft.blued.user.UserInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class CameraImageUtils {
  public static Bitmap a(int paramInt) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inPurgeable = true;
    options.inInputShareable = true;
    return BitmapFactory.decodeStream(AppInfo.d().getResources().openRawResource(paramInt), null, options);
  }
  
  public static Bitmap a(String paramString, float paramFloat) {
    Bitmap bitmap1 = BitmapFactory.decodeFile(paramString);
    int i = bitmap1.getWidth();
    Bitmap bitmap2 = Bitmap.createBitmap(i, (int)(i / paramFloat), Bitmap.Config.ARGB_8888);
    Paint paint = new Paint();
    Matrix matrix = new Matrix();
    (new Canvas(bitmap2)).drawBitmap(bitmap1, matrix, paint);
    bitmap1.recycle();
    return bitmap2;
  }
  
  public static File a(Bitmap paramBitmap, String paramString) {
    File file = new File(paramString);
    if (paramBitmap == null)
      return file; 
    if (file.exists())
      file.delete(); 
    try {
      file.createNewFile();
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      if (paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
        fileOutputStream.flush();
        fileOutputStream.close();
      } 
      return file;
    } catch (Exception exception) {
      return file;
    } 
  }
  
  public static File a(byte[] paramArrayOfbyte, String paramString) {
    File file = new File(paramString);
    if (file.exists())
      file.delete(); 
    try {
      file.createNewFile();
      FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsoluteFile());
      fileOutputStream.write(paramArrayOfbyte);
      fileOutputStream.flush();
      fileOutputStream.close();
      return file;
    } catch (Exception exception) {
      exception.printStackTrace();
      return file;
    } 
  }
  
  public static void a(String paramString) {
    try {
      ExifInterface exifInterface = new ExifInterface(paramString);
      Random random = new Random();
      long l = System.currentTimeMillis();
      int i = random.nextInt(10000);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(UserInfo.a().i().getUid());
      stringBuilder1.append(":");
      stringBuilder1.append(AppInfo.b);
      stringBuilder1.append(":");
      stringBuilder1.append(BluedDeviceIdentity.a().e());
      stringBuilder1.append(":");
      stringBuilder1.append(l);
      String str = HMACUtils.a(stringBuilder1.toString(), String.valueOf(i));
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("{\"t\":\"");
      stringBuilder2.append(l);
      stringBuilder2.append("\",\"r\":\"");
      stringBuilder2.append(i);
      stringBuilder2.append("\",\"h\":\"");
      stringBuilder2.append(str);
      stringBuilder2.append("\"}");
      exifInterface.setAttribute("UserComment", stringBuilder2.toString());
      exifInterface.saveAttributes();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\camer\\utils\CameraImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */