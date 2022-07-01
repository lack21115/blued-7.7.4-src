package com.baidu.aip.face;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import java.io.IOException;

public class FileImageSource extends ImageSource {
  private String filePath;
  
  private static int getExifOrientation(String paramString) {
    try {
      ExifInterface exifInterface = new ExifInterface(paramString);
    } catch (IOException iOException) {
      iOException = null;
    } 
    if (iOException != null) {
      int i = iOException.getAttributeInt("Orientation", -1);
      if (i != -1)
        if (i != 3) {
          if (i != 6) {
            if (i == 8)
              return 270; 
          } else {
            return 90;
          } 
        } else {
          return 180;
        }  
    } 
    return 0;
  }
  
  private Bitmap getImageThumbnail(String paramString, int paramInt1, int paramInt2) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    boolean bool = true;
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, options);
    options.inJustDecodeBounds = false;
    int j = options.outHeight;
    int i = options.outWidth / paramInt1;
    paramInt2 = j / paramInt2;
    paramInt1 = paramInt2;
    if (i < paramInt2)
      paramInt1 = i; 
    if (paramInt1 <= 0)
      paramInt1 = bool; 
    options.inSampleSize = paramInt1;
    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    return BitmapFactory.decodeFile(paramString, options);
  }
  
  public void setFilePath(String paramString) {
    this.filePath = paramString;
  }
  
  public void start() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial start : ()V
    //   4: aload_0
    //   5: aload_0
    //   6: getfield filePath : Ljava/lang/String;
    //   9: sipush #960
    //   12: sipush #960
    //   15: invokespecial getImageThumbnail : (Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   18: astore_3
    //   19: aload_0
    //   20: getfield filePath : Ljava/lang/String;
    //   23: invokestatic getExifOrientation : (Ljava/lang/String;)I
    //   26: istore_1
    //   27: iload_1
    //   28: bipush #90
    //   30: if_icmpeq -> 49
    //   33: iload_1
    //   34: sipush #180
    //   37: if_icmpeq -> 49
    //   40: aload_3
    //   41: astore_2
    //   42: iload_1
    //   43: sipush #270
    //   46: if_icmpne -> 81
    //   49: new android/graphics/Matrix
    //   52: dup
    //   53: invokespecial <init> : ()V
    //   56: astore_2
    //   57: aload_2
    //   58: iload_1
    //   59: i2f
    //   60: invokevirtual postRotate : (F)Z
    //   63: pop
    //   64: aload_3
    //   65: iconst_0
    //   66: iconst_0
    //   67: aload_3
    //   68: invokevirtual getWidth : ()I
    //   71: aload_3
    //   72: invokevirtual getHeight : ()I
    //   75: aload_2
    //   76: iconst_1
    //   77: invokestatic createBitmap : (Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   80: astore_2
    //   81: aload_2
    //   82: invokevirtual getWidth : ()I
    //   85: aload_2
    //   86: invokevirtual getHeight : ()I
    //   89: imul
    //   90: newarray int
    //   92: astore #4
    //   94: aload_2
    //   95: aload #4
    //   97: iconst_0
    //   98: aload_2
    //   99: invokevirtual getWidth : ()I
    //   102: iconst_0
    //   103: iconst_0
    //   104: aload_2
    //   105: invokevirtual getWidth : ()I
    //   108: aload_2
    //   109: invokevirtual getHeight : ()I
    //   112: invokevirtual getPixels : ([IIIIIII)V
    //   115: invokestatic getInstance : ()Lcom/baidu/aip/FaceDetector;
    //   118: invokevirtual clearTrackedFaces : ()V
    //   121: new com/baidu/aip/ImageFrame
    //   124: dup
    //   125: invokespecial <init> : ()V
    //   128: astore_3
    //   129: aload_3
    //   130: aload #4
    //   132: invokevirtual setArgb : ([I)V
    //   135: aload_3
    //   136: aload_2
    //   137: invokevirtual getWidth : ()I
    //   140: invokevirtual setWidth : (I)V
    //   143: aload_3
    //   144: aload_2
    //   145: invokevirtual getHeight : ()I
    //   148: invokevirtual setHeight : (I)V
    //   151: aload_0
    //   152: invokevirtual getListeners : ()Ljava/util/ArrayList;
    //   155: invokevirtual iterator : ()Ljava/util/Iterator;
    //   158: astore_2
    //   159: aload_2
    //   160: invokeinterface hasNext : ()Z
    //   165: ifeq -> 186
    //   168: aload_2
    //   169: invokeinterface next : ()Ljava/lang/Object;
    //   174: checkcast com/baidu/aip/face/OnFrameAvailableListener
    //   177: aload_3
    //   178: invokeinterface onFrameAvailable : (Lcom/baidu/aip/ImageFrame;)V
    //   183: goto -> 159
    //   186: invokestatic getInstance : ()Lcom/baidu/aip/FaceDetector;
    //   189: invokevirtual clearTrackedFaces : ()V
    //   192: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\FileImageSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */