package org.chromium.media;

import android.media.MediaFormat;
import android.os.Build;
import java.nio.ByteBuffer;

final class MediaFormatBuilder {
  static void addInputSizeInfoToFormat(MediaFormat paramMediaFormat, boolean paramBoolean) {
    if (paramBoolean) {
      paramMediaFormat.setInteger("max-width", paramMediaFormat.getInteger("width"));
      paramMediaFormat.setInteger("max-height", paramMediaFormat.getInteger("height"));
    } 
    if (paramMediaFormat.containsKey("max-input-size"))
      return; 
    int i = paramMediaFormat.getInteger("height");
    int j = i;
    if (paramBoolean) {
      j = i;
      if (paramMediaFormat.containsKey("max-height"))
        j = Math.max(i, paramMediaFormat.getInteger("max-height")); 
    } 
    i = paramMediaFormat.getInteger("width");
    int k = i;
    if (paramBoolean) {
      k = i;
      if (paramMediaFormat.containsKey("max-width"))
        k = Math.max(j, paramMediaFormat.getInteger("max-width")); 
    } 
    String str = paramMediaFormat.getString("mime");
    i = -1;
    switch (str.hashCode()) {
      case 1599127257:
        if (str.equals("video/x-vnd.on2.vp9"))
          i = 3; 
        break;
      case 1599127256:
        if (str.equals("video/x-vnd.on2.vp8"))
          i = 1; 
        break;
      case 1331836730:
        if (str.equals("video/avc"))
          i = 0; 
        break;
      case -1662541442:
        if (str.equals("video/hevc"))
          i = 2; 
        break;
    } 
    byte b = 4;
    switch (i) {
      default:
        return;
      case 2:
      case 3:
        i = k * j;
        j = b;
        break;
      case 1:
        i = k * j;
        j = 2;
        break;
      case 0:
        if ("BRAVIA 4K 2015".equals(Build.MODEL))
          return; 
        i = (k + 15) / 16 * (j + 15) / 16 << 4 << 4;
        j = 2;
        break;
    } 
    paramMediaFormat.setInteger("max-input-size", i * 3 / j * 2);
  }
  
  static void setCodecSpecificData(MediaFormat paramMediaFormat, byte[][] paramArrayOfbyte) {
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      if ((paramArrayOfbyte[i]).length != 0) {
        StringBuilder stringBuilder = new StringBuilder("csd-");
        stringBuilder.append(i);
        paramMediaFormat.setByteBuffer(stringBuilder.toString(), ByteBuffer.wrap(paramArrayOfbyte[i]));
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaFormatBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */