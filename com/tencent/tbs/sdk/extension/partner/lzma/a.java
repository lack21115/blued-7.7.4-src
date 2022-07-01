package com.tencent.tbs.sdk.extension.partner.lzma;

import android.os.Bundle;
import java.io.File;

public class a {
  public static boolean a(Bundle paramBundle) {
    String str = paramBundle.getString("unzip_temp_path");
    if (str == null)
      return false; 
    if (!str.endsWith(File.separator)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(File.separator);
      str = stringBuilder.toString();
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("LzmaHelper.doLzma unzipTempPath=");
    stringBuilder2.append(str);
    stringBuilder2.toString();
    File file = new File(str);
    if (!file.exists())
      return false; 
    boolean bool = a(file, str);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("LzmaHelper.doLzma lzmaRet=");
    stringBuilder1.append(bool);
    stringBuilder1.toString();
    return bool;
  }
  
  public static boolean a(File paramFile, String paramString) {
    for (File file : paramFile.listFiles()) {
      if (file.isDirectory()) {
        a(file, paramString);
      } else if (file.getAbsolutePath().endsWith("_lzma.so")) {
        boolean bool = b(file, paramString);
        if (!bool)
          return bool; 
      } 
    } 
    return true;
  }
  
  public static boolean a(File paramFile, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LzmaHelper.extract srcFile＝");
    stringBuilder.append(paramFile);
    stringBuilder.toString();
    if (!paramFile.exists())
      return false; 
    if (paramString1 == null)
      return false; 
    LzmaDec.loadSo(paramString2);
    LzmaDec lzmaDec = new LzmaDec();
    int i = lzmaDec.Lzma_open(paramFile.getAbsolutePath());
    stringBuilder = new StringBuilder();
    stringBuilder.append("LzmaHelper.extract openSuc=");
    stringBuilder.append(i);
    stringBuilder.toString();
    if (i == 99999)
      return false; 
    while (true) {
      LZFileHeader lZFileHeader = (LZFileHeader)lzmaDec.Lzma_getHeader();
      if (lZFileHeader != null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("LzmaHelper.extract extractPath=");
        stringBuilder1.append(paramString1);
        stringBuilder1.append(" header=");
        stringBuilder1.append(lZFileHeader.getFileNameString());
        stringBuilder1.toString();
        lzmaDec.Lzma_extract(paramString1, lZFileHeader);
        continue;
      } 
      lzmaDec.Lzma_close();
      paramFile.delete();
      return true;
    } 
  }
  
  public static boolean b(File paramFile, String paramString) {
    return a(paramFile, paramString, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\lzma\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */