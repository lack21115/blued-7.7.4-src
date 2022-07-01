package com.mcxiaoke.packer.common;

import com.mcxiaoke.packer.support.walle.Support;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PackerCommon {
  public static String a(File paramFile) throws IOException {
    return a(paramFile, "CHANNEL", 2054712097);
  }
  
  static String a(File paramFile, String paramString, int paramInt) throws IOException {
    Map<String, String> map = a(paramFile, paramInt);
    return (map == null || map.isEmpty()) ? null : map.get(paramString);
  }
  
  public static Map<String, String> a(File paramFile, int paramInt) throws IOException {
    return a(b(paramFile, paramInt));
  }
  
  public static Map<String, String> a(String paramString) {
    if (paramString == null || paramString.length() == 0)
      return null; 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    String[] arrayOfString = paramString.split("∙");
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      String[] arrayOfString1 = arrayOfString[i].split("∘");
      if (arrayOfString1.length == 2)
        hashMap.put(arrayOfString1[0], arrayOfString1[1]); 
    } 
    return (Map)hashMap;
  }
  
  public static String b(File paramFile, int paramInt) throws IOException {
    byte[] arrayOfByte = c(paramFile, paramInt);
    return (arrayOfByte == null || arrayOfByte.length == 0) ? null : new String(arrayOfByte, "UTF-8");
  }
  
  public static byte[] c(File paramFile, int paramInt) throws IOException {
    return d(paramFile, paramInt);
  }
  
  static byte[] d(File paramFile, int paramInt) throws IOException {
    ByteBuffer byteBuffer = Support.a(paramFile, paramInt);
    if (byteBuffer == null)
      return null; 
    byte[] arrayOfByte1 = "Packer Ng Sig V2".getBytes("UTF-8");
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
    byteBuffer.get(arrayOfByte2);
    if (Arrays.equals(arrayOfByte1, arrayOfByte2)) {
      paramInt = byteBuffer.getInt();
      if (paramInt > 0) {
        arrayOfByte1 = new byte[paramInt];
        byteBuffer.get(arrayOfByte1);
        if (byteBuffer.getInt() == paramInt)
          return arrayOfByte1; 
      } 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\mcxiaoke\packer\common\PackerCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */