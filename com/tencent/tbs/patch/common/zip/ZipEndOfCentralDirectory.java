package com.tencent.tbs.patch.common.zip;

import com.tencent.tbs.patch.common.util.Base64;
import com.tencent.tbs.patch.json.JSONObject;

public final class ZipEndOfCentralDirectory {
  public byte[] archiveComment;
  
  public long archiveCommentLength;
  
  public long dirOffset;
  
  public long dirSize;
  
  public short diskId;
  
  public short numEntries;
  
  public short numStruct;
  
  public short startDiskId;
  
  public static ZipEndOfCentralDirectory parse(JSONObject paramJSONObject) {
    ZipEndOfCentralDirectory zipEndOfCentralDirectory = new ZipEndOfCentralDirectory();
    zipEndOfCentralDirectory.diskId = Short.parseShort(paramJSONObject.optString("DiskID"));
    zipEndOfCentralDirectory.startDiskId = Short.parseShort(paramJSONObject.optString("StartDiskID"));
    zipEndOfCentralDirectory.numEntries = Short.parseShort(paramJSONObject.optString("NumEntries"));
    zipEndOfCentralDirectory.numStruct = Short.parseShort(paramJSONObject.optString("NumStruct"));
    zipEndOfCentralDirectory.dirSize = Long.parseLong(paramJSONObject.optString("DirSize"));
    zipEndOfCentralDirectory.dirOffset = Long.parseLong(paramJSONObject.optString("DirOffset"));
    zipEndOfCentralDirectory.archiveCommentLength = Long.parseLong(paramJSONObject.optString("ArchiveCommentLen"));
    zipEndOfCentralDirectory.archiveComment = Base64.decode(paramJSONObject.optString("ArchiveComment"), 2);
    return zipEndOfCentralDirectory;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\zip\ZipEndOfCentralDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */