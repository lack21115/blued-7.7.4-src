package com.tencent.tbs.patch.common;

public class DefaultFileDeflateAdapter extends FileDeflateAdapter {
  public String getSealedName(String paramString) {
    return paramString;
  }
  
  public boolean shouldAccepted(String paramString) {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\DefaultFileDeflateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */