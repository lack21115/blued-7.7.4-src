package com.bytedance.sdk.a.b.a.f;

import java.io.File;
import java.io.IOException;

public interface a {
  public static final a a = new a() {
      public void a(File param1File) throws IOException {
        if (!param1File.delete()) {
          if (!param1File.exists())
            return; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("failed to delete ");
          stringBuilder.append(param1File);
          throw new IOException(stringBuilder.toString());
        } 
      }
      
      public void a(File param1File1, File param1File2) throws IOException {
        a(param1File2);
        if (param1File1.renameTo(param1File2))
          return; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("failed to rename ");
        stringBuilder.append(param1File1);
        stringBuilder.append(" to ");
        stringBuilder.append(param1File2);
        throw new IOException(stringBuilder.toString());
      }
      
      public boolean b(File param1File) {
        return param1File.exists();
      }
      
      public long c(File param1File) {
        return param1File.length();
      }
    };
  
  void a(File paramFile) throws IOException;
  
  void a(File paramFile1, File paramFile2) throws IOException;
  
  boolean b(File paramFile);
  
  long c(File paramFile);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */