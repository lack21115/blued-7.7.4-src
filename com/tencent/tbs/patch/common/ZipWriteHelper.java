package com.tencent.tbs.patch.common;

import com.tencent.tbs.patch.common.util.FileUtils;
import com.tencent.tbs.patch.common.util.StringUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipWriteHelper implements Closeable {
  public static final int BUFFER = 8192;
  
  private ZipOutputStream a;
  
  private String b;
  
  public ZipWriteHelper(String paramString) {
    this.b = paramString;
  }
  
  public void close() {
    FileUtils.closeQuietly(this.a);
  }
  
  public void flush() {
    try {
      this.a.flush();
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
  }
  
  public long getDefaultTime() {
    return (new Date(80, 0, 0, 0, 0, 0)).getTime();
  }
  
  public void open(int paramInt) {
    if (paramInt >= 0 && paramInt <= 9) {
      this.a = new ZipOutputStream(new FileOutputStream(this.b));
      this.a.setLevel(paramInt);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Compress level must between 0 and 9, current is ");
    stringBuilder.append(paramInt);
    throw new IOException(stringBuilder.toString());
  }
  
  public void putByteEntry(String paramString, byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null && paramArrayOfbyte.length != 0) {
      BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(paramArrayOfbyte));
      ZipEntry zipEntry = new ZipEntry(paramString);
      zipEntry.setTime(getDefaultTime());
      zipEntry.setExtra(null);
      this.a.putNextEntry(zipEntry);
      byte[] arrayOfByte = new byte[8192];
      while (true) {
        int i = bufferedInputStream.read(arrayOfByte, 0, 8192);
        if (i != -1) {
          this.a.write(arrayOfByte, 0, i);
          continue;
        } 
        this.a.closeEntry();
        FileUtils.closeQuietly(bufferedInputStream);
        break;
      } 
    } 
  }
  
  public void putFileEntry(String paramString1, String paramString2) {
    if (FileUtils.isExist(paramString2))
      try {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(paramString2));
        ZipEntry zipEntry = new ZipEntry(paramString1);
        zipEntry.setTime(getDefaultTime());
        zipEntry.setExtra(null);
        this.a.putNextEntry(zipEntry);
        byte[] arrayOfByte = new byte[8192];
        while (true) {
          int i = bufferedInputStream.read(arrayOfByte, 0, 8192);
          if (i != -1) {
            this.a.write(arrayOfByte, 0, i);
            continue;
          } 
          this.a.flush();
          this.a.closeEntry();
          FileUtils.closeQuietly(bufferedInputStream);
          return;
        } 
      } catch (IOException iOException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Entry: ");
        stringBuilder1.append(paramString1);
        stringBuilder1.append(",");
        stringBuilder1.append(paramString2);
        stringBuilder1.append(",");
        stringBuilder1.append(iOException.getMessage());
        throw new PatchException(stringBuilder1.toString());
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Entry: ");
    stringBuilder.append(paramString1);
    stringBuilder.append(",");
    stringBuilder.append(paramString2);
    stringBuilder.append(" not exist");
    throw new PatchException(stringBuilder.toString());
  }
  
  public void putStringEntry(String paramString1, String paramString2) {
    if (!StringUtils.isBlank(paramString2))
      putByteEntry(paramString1, paramString2.getBytes()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\ZipWriteHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */