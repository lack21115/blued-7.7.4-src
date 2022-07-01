package com.huawei.hianalytics.ab.bc.gh;

import com.huawei.hianalytics.ab.ab.bc;
import com.huawei.hianalytics.ab.bc.kl.de;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.File;
import java.io.IOException;

public class ab {
  private String ab = bc.fg().getFilesDir().getPath();
  
  private String ab(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.ab);
    stringBuilder.append("/hms/component/".replace("component", paramString));
    return stringBuilder.toString();
  }
  
  private void ab(String paramString1, String paramString2) {
    File file2 = new File(ab(paramString1));
    String str = ab(paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("hianalytics_");
    stringBuilder.append(paramString1);
    File file1 = new File(str, stringBuilder.toString());
    if (!file2.exists() && file2.mkdirs())
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "file directory is mkdirs"); 
    if (ab(file1)) {
      de.ab(file1, paramString2);
      return;
    } 
    com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "refreshComponent():file is not found,and file is create failed");
  }
  
  private boolean ab(File paramFile) {
    if (paramFile.exists())
      return true; 
    try {
      return paramFile.createNewFile();
    } catch (IOException iOException) {
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "create new file error!");
      return false;
    } 
  }
  
  private char[] ab(String paramString1, String paramString2, String paramString3, String paramString4) {
    byte[] arrayOfByte1 = HexUtil.a(paramString1);
    byte[] arrayOfByte2 = HexUtil.a(paramString2);
    byte[] arrayOfByte3 = HexUtil.a(paramString3);
    byte[] arrayOfByte4 = HexUtil.a(paramString4);
    int j = arrayOfByte1.length;
    int i = j;
    if (j > arrayOfByte2.length)
      i = arrayOfByte2.length; 
    j = i;
    if (i > arrayOfByte3.length)
      j = arrayOfByte3.length; 
    i = j;
    if (j > arrayOfByte4.length)
      i = arrayOfByte4.length; 
    char[] arrayOfChar = new char[i];
    for (j = 0; j < i; j++)
      arrayOfChar[j] = (char)(arrayOfByte1[j] ^ arrayOfByte2[j] ^ arrayOfByte3[j] ^ arrayOfByte4[j]); 
    return arrayOfChar;
  }
  
  private String bc(String paramString) {
    String str = ab(paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("hianalytics_");
    stringBuilder.append(paramString);
    File file = new File(str, stringBuilder.toString());
    if (ab(file))
      return de.ab(file); 
    str = EncryptUtil.b(128);
    de.ab(file, str);
    return str;
  }
  
  private boolean bc() {
    long l = com.huawei.hianalytics.ab.bc.ij.ab.ab(bc.fg(), "Privacy_MY", "assemblyFlash", -1L);
    if (-1L == l) {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "First init components");
      return true;
    } 
    return (System.currentTimeMillis() - l > 31536000000L);
  }
  
  private static boolean bc(File paramFile) {
    int i = 0;
    if (paramFile != null && paramFile.exists()) {
      if (!paramFile.isDirectory())
        return false; 
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null) {
        if (arrayOfFile.length == 0)
          return false; 
        int j = arrayOfFile.length;
        while (i < j) {
          File file = arrayOfFile[i];
          if (file.isFile()) {
            if (!file.delete()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("delete file failed : ");
              stringBuilder.append(file.getName());
              com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", stringBuilder.toString());
            } 
          } else if (file.isDirectory()) {
            bc(file);
          } 
          i++;
        } 
        return paramFile.delete();
      } 
    } 
    return false;
  }
  
  public static boolean cd() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bc.fg().getFilesDir().getPath());
    stringBuilder.append("/");
    stringBuilder.append("hms");
    return bc(new File(stringBuilder.toString()));
  }
  
  private String de() {
    return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
  }
  
  public String ab() {
    String str1;
    String str2;
    String str3;
    String str4;
    String str5 = de();
    if (bc()) {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "refresh components");
      str4 = EncryptUtil.b(128);
      ab("aprpap", str4);
      str3 = EncryptUtil.b(128);
      ab("febdoc", str3);
      str2 = EncryptUtil.b(128);
      ab("marfil", str2);
      str1 = EncryptUtil.b(128);
      ab("maywnj", str1);
      com.huawei.hianalytics.ab.bc.ij.ab.bc(bc.fg(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
    } else {
      str4 = bc("aprpap");
      str3 = bc("febdoc");
      str2 = bc("marfil");
      str1 = bc("maywnj");
    } 
    return HexUtil.a(PBKDF2.a(ab(str4, str3, str2, str5), HexUtil.a(str1), 10000, 16));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\gh\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */