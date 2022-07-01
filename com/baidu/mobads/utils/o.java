package com.baidu.mobads.utils;

import java.io.File;
import java.util.Comparator;

class o implements Comparator<File> {
  o(n paramn) {}
  
  public int a(File paramFile1, File paramFile2) {
    return Long.valueOf(paramFile1.lastModified()).compareTo(Long.valueOf(paramFile2.lastModified()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */