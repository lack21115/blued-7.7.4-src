package com.qiniu.android.storage.persistent;

import com.qiniu.android.http.custom.DnsCacheKey;
import com.qiniu.android.storage.Recorder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DnsCacheFile implements Recorder {
  public String directory;
  
  public File f;
  
  public DnsCacheFile(String paramString) throws IOException {
    this.directory = paramString;
    this.f = new File(paramString);
    if (!this.f.exists()) {
      if (this.f.mkdirs())
        return; 
      throw new IOException("mkdir failed");
    } 
    if (this.f.isDirectory())
      return; 
    throw new IOException("does not mkdir");
  }
  
  public void del(String paramString) {
    if (paramString != null)
      (new File(this.directory, paramString)).delete(); 
  }
  
  public byte[] get(String paramString) {
    File file = new File(this.directory, paramString);
    try {
      byte[] arrayOfByte = new byte[(int)file.length()];
      try {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
          int i = fileInputStream.read(arrayOfByte);
        } catch (IOException null) {}
      } catch (IOException null) {
        file = null;
      } 
    } catch (IOException iOException) {
      File file1 = null;
      file = file1;
    } 
    iOException.printStackTrace();
    boolean bool = false;
  }
  
  public String getFileName() {
    File[] arrayOfFile = this.f.listFiles();
    if (arrayOfFile == null)
      return null; 
    int j = arrayOfFile.length;
    int i = 1;
    if (j == 1)
      return arrayOfFile[0].getName(); 
    if (arrayOfFile.length > 1) {
      String str;
      long l = 0L;
      DnsCacheKey dnsCacheKey = null;
      while (i < arrayOfFile.length) {
        String str1;
        String str2 = arrayOfFile[i].getName();
        DnsCacheKey dnsCacheKey1 = DnsCacheKey.toCacheKey(str2);
        if (dnsCacheKey1 == null)
          return null; 
        long l2 = Long.parseLong(dnsCacheKey1.getCurrentTime());
        dnsCacheKey1 = dnsCacheKey;
        long l1 = l;
        if (l2 > l) {
          del((String)dnsCacheKey);
          str1 = str2;
          l1 = l2;
        } 
        i++;
        str = str1;
        l = l1;
      } 
      return str;
    } 
    return null;
  }
  
  public void set(String paramString, byte[] paramArrayOfbyte) {
    File[] arrayOfFile = this.f.listFiles();
    if (arrayOfFile == null)
      return; 
    if (arrayOfFile.length > 0)
      for (int i = 0; i < arrayOfFile.length; i++)
        del(arrayOfFile[i].getName());  
    File file = new File(this.directory, paramString);
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      try {
        fileOutputStream.write(paramArrayOfbyte);
      } catch (IOException null) {}
    } catch (IOException iOException) {
      file = null;
    } 
    iOException.printStackTrace();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\storage\persistent\DnsCacheFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */