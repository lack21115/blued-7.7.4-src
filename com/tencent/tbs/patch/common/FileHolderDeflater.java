package com.tencent.tbs.patch.common;

import com.tencent.tbs.patch.common.patch.FileHolder;
import com.tencent.tbs.patch.common.util.StringUtils;
import java.util.LinkedList;
import java.util.List;

public abstract class FileHolderDeflater {
  private FileDeflateAdapter a;
  
  private List<FileHolder> b;
  
  public FileHolderDeflater(FileDeflateAdapter paramFileDeflateAdapter) {
    this.a = paramFileDeflateAdapter;
  }
  
  protected void a(String paramString1, String paramString2) {
    if (this.b == null)
      this.b = new LinkedList<FileHolder>(); 
    FileDeflateAdapter fileDeflateAdapter = this.a;
    String str = paramString1;
    if (fileDeflateAdapter != null)
      str = fileDeflateAdapter.getSealedName(paramString1); 
    if (!StringUtils.isBlank(str)) {
      this.b.add(new FileHolder(str, paramString2));
      return;
    } 
    throw new PatchException("Unexpected blank sealed name");
  }
  
  protected boolean a(String paramString) {
    FileDeflateAdapter fileDeflateAdapter = this.a;
    return (fileDeflateAdapter == null) ? true : fileDeflateAdapter.shouldAccepted(paramString);
  }
  
  public List<FileHolder> getFileEntries() {
    return this.b;
  }
  
  public abstract void parse(String paramString1, String paramString2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\FileHolderDeflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */