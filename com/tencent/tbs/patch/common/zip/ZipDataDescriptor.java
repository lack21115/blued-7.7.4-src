package com.tencent.tbs.patch.common.zip;

import com.tencent.tbs.patch.json.JSONObject;

public class ZipDataDescriptor {
  public long compressed;
  
  public long crc32;
  
  public long uncompressed;
  
  public static ZipDataDescriptor parse(JSONObject paramJSONObject) {
    ZipDataDescriptor zipDataDescriptor = new ZipDataDescriptor();
    zipDataDescriptor.crc32 = Long.parseLong(paramJSONObject.optString("Crc32"));
    zipDataDescriptor.compressed = Long.parseLong(paramJSONObject.optString("Compressed"));
    zipDataDescriptor.uncompressed = Long.parseLong(paramJSONObject.optString("Uncompressed"));
    return zipDataDescriptor;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\zip\ZipDataDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */