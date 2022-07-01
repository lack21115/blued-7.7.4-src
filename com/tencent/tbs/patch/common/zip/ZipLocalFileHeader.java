package com.tencent.tbs.patch.common.zip;

import com.tencent.tbs.patch.common.util.Base64;
import com.tencent.tbs.patch.json.JSONObject;

public final class ZipLocalFileHeader {
  public int compressedSize;
  
  public int crc32;
  
  public byte[] extra;
  
  public int extraLength;
  
  public int genFlag;
  
  public int method;
  
  public int minVersion;
  
  public int modifiedDate;
  
  public int modifiedTime;
  
  public byte[] name;
  
  public int nameLength;
  
  public int uncompressedSize;
  
  public static ZipLocalFileHeader parse(JSONObject paramJSONObject) {
    ZipLocalFileHeader zipLocalFileHeader = new ZipLocalFileHeader();
    zipLocalFileHeader.minVersion = Integer.parseInt(paramJSONObject.optString("MinVersion"));
    zipLocalFileHeader.genFlag = Integer.parseInt(paramJSONObject.optString("GenFlag"));
    zipLocalFileHeader.method = Integer.parseInt(paramJSONObject.optString("Method"));
    zipLocalFileHeader.modifiedTime = Integer.parseInt(paramJSONObject.optString("ModifiedTime"));
    zipLocalFileHeader.modifiedDate = Integer.parseInt(paramJSONObject.optString("ModifiedDate"));
    zipLocalFileHeader.crc32 = Integer.parseInt(paramJSONObject.optString("CRC32"));
    zipLocalFileHeader.compressedSize = Integer.parseInt(paramJSONObject.optString("CompressedSize"));
    zipLocalFileHeader.uncompressedSize = Integer.parseInt(paramJSONObject.optString("UncompressedSize"));
    zipLocalFileHeader.nameLength = Integer.parseInt(paramJSONObject.optString("NameLen"));
    zipLocalFileHeader.extraLength = Integer.parseInt(paramJSONObject.optString("ExtraLen"));
    zipLocalFileHeader.name = Base64.decode(paramJSONObject.optString("Name"), 2);
    zipLocalFileHeader.extra = Base64.decode(paramJSONObject.optString("Extra"), 2);
    return zipLocalFileHeader;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mV=");
    stringBuilder.append(this.minVersion);
    stringBuilder.append(", flag=");
    stringBuilder.append(this.genFlag);
    stringBuilder.append(", method=");
    stringBuilder.append(this.method);
    stringBuilder.append(", time=");
    stringBuilder.append(this.modifiedTime);
    stringBuilder.append(", date=");
    stringBuilder.append(this.modifiedDate);
    stringBuilder.append(", crc=");
    stringBuilder.append(this.crc32);
    stringBuilder.append(", cprSize=");
    stringBuilder.append(this.compressedSize);
    stringBuilder.append(", uncrpSize=");
    stringBuilder.append(this.uncompressedSize);
    stringBuilder.append(", nameLen=");
    stringBuilder.append(this.nameLength);
    stringBuilder.append(", exLen=");
    stringBuilder.append(this.extraLength);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\zip\ZipLocalFileHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */