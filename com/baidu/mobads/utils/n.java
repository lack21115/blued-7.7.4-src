package com.baidu.mobads.utils;

import java.io.File;
import java.util.Arrays;

class n implements Runnable {
  n(m paramm, String paramString) {}
  
  public void run() {
    try {
      File file = new File(this.a);
      if (!file.exists())
        file.mkdirs(); 
      File[] arrayOfFile = file.listFiles();
      if (arrayOfFile != null && arrayOfFile.length > 0) {
        Arrays.sort(arrayOfFile, new o(this));
        long l = 0L;
        int i = arrayOfFile.length - 1;
        while (i >= 0) {
          File file1 = arrayOfFile[i];
          long l1 = l;
          if (file1.exists())
            if (System.currentTimeMillis() - file1.lastModified() > 2592000000L) {
              file1.delete();
              l1 = l;
            } else if (file1.length() + l > m.a()) {
              file1.delete();
              l1 = l;
            } else {
              l1 = file1.length();
              l1 = l + l1;
            }  
          i--;
          l = l1;
        } 
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */