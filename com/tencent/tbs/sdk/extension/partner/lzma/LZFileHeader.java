package com.tencent.tbs.sdk.extension.partner.lzma;

import android.text.TextUtils;
import java.io.File;
import java.util.Date;

public class LZFileHeader {
  public static final short LHD_DIRECTORY = 224;
  
  public static final short LHD_PASSWORD = 4;
  
  public static final short LHD_UNICODE = 512;
  
  public static final short LHD_WINDOWMASK = 224;
  
  private static final byte NEWLHD_SIZE = 32;
  
  private static final byte SALT_SIZE = 8;
  
  private Date aTime;
  
  private Date arcTime;
  
  private Date cTime;
  
  private int fileAttr;
  
  private int fileCRC;
  
  private String fileNameW;
  
  private int highPackSize;
  
  private int highUnpackSize;
  
  public boolean isSaved;
  
  private Object mContextObject;
  
  private String mFileName;
  
  private int mFileTime;
  
  private int mFlags;
  
  private long mFullPackSize;
  
  private long mFullUnpackSize;
  
  private int mNativeContext;
  
  public long mPositionInFile;
  
  private Date mTime;
  
  private short nameSize;
  
  private int recoverySectors;
  
  private final byte[] salt;
  
  private byte[] subData;
  
  private int subFlags;
  
  private byte unpMethod;
  
  private long unpSize;
  
  private byte unpVersion;
  
  public LZFileHeader(String paramString, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2) {
    String[] arrayOfString;
    this.salt = new byte[8];
    this.recoverySectors = -1;
    this.mContextObject = null;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("FileName:");
    stringBuilder.append(paramString);
    stringBuilder.toString();
    this.mFlags = paramInt2;
    this.mFileTime = paramInt1;
    this.mFullPackSize = paramLong1;
    this.mFullUnpackSize = paramLong2;
    this.mPositionInFile = paramLong3;
    if (paramString.indexOf("..") >= 0) {
      arrayOfString = paramString.split(File.separator);
      for (paramInt1 = 0; paramInt1 < arrayOfString.length; paramInt1++) {
        if (!TextUtils.isEmpty(arrayOfString[paramInt1]) && !arrayOfString[paramInt1].equalsIgnoreCase("..")) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(this.mFileName);
          stringBuilder.append(arrayOfString[paramInt1]);
          this.mFileName = stringBuilder.toString();
          if (paramInt1 < arrayOfString.length - 1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.mFileName);
            stringBuilder.append(File.separator);
            this.mFileName = stringBuilder.toString();
          } 
        } 
      } 
    } else {
      this.mFileName = (String)arrayOfString;
    } 
  }
  
  public Date getATime() {
    return this.aTime;
  }
  
  public Date getArcTime() {
    return this.arcTime;
  }
  
  public Date getCTime() {
    return this.cTime;
  }
  
  public String getComment() {
    return null;
  }
  
  public long getCompressedSize() {
    return this.mFullPackSize;
  }
  
  public Object getContextOject() {
    return this.mContextObject;
  }
  
  public long getCrc() {
    return this.fileCRC;
  }
  
  public int getFileAttr() {
    return this.fileAttr;
  }
  
  public int getFileCRC() {
    return this.fileCRC;
  }
  
  public String getFileNameString() {
    return this.mFileName;
  }
  
  public String getFileNameW() {
    return this.fileNameW;
  }
  
  public long getFullPackSize() {
    return this.mFullPackSize;
  }
  
  public long getFullUnpackSize() {
    return this.mFullUnpackSize;
  }
  
  public int getHighPackSize() {
    return this.highPackSize;
  }
  
  public int getHighUnpackSize() {
    return this.highUnpackSize;
  }
  
  public Date getMTime() {
    return this.mTime;
  }
  
  public int getMethod() {
    return this.unpMethod;
  }
  
  public String getName() {
    return this.mFileName;
  }
  
  public short getNameSize() {
    return this.nameSize;
  }
  
  public int getRecoverySectors() {
    return this.recoverySectors;
  }
  
  public byte[] getSalt() {
    return this.salt;
  }
  
  public byte[] getSubData() {
    return this.subData;
  }
  
  public int getSubFlags() {
    return this.subFlags;
  }
  
  public long getTime() {
    return this.mTime.getTime();
  }
  
  public long getUnCompressedSize() {
    return this.mFullUnpackSize;
  }
  
  public byte getUnpMethod() {
    return this.unpMethod;
  }
  
  public long getUnpSize() {
    return this.unpSize;
  }
  
  public byte getUnpVersion() {
    return this.unpVersion;
  }
  
  public boolean isDirectory() {
    return ((this.mFlags & 0xE0) == 224);
  }
  
  public boolean isEncrypted() {
    return ((this.mFlags & 0x4) != 0);
  }
  
  public boolean isUnicode() {
    return ((this.mFlags & 0x200) != 0);
  }
  
  public void setATime(Date paramDate) {
    this.aTime = paramDate;
  }
  
  public void setArcTime(Date paramDate) {
    this.arcTime = paramDate;
  }
  
  public void setCTime(Date paramDate) {
    this.cTime = paramDate;
  }
  
  public void setContextObject(Object paramObject) {
    this.mContextObject = paramObject;
  }
  
  public void setFileAttr(int paramInt) {
    this.fileAttr = paramInt;
  }
  
  public void setFileNameW(String paramString) {
    this.fileNameW = paramString;
  }
  
  public void setMTime(Date paramDate) {
    this.mTime = paramDate;
  }
  
  public String toString() {
    return super.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\lzma\LZFileHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */