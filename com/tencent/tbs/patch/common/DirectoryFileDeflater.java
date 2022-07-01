package com.tencent.tbs.patch.common;

import java.io.File;
import java.util.LinkedList;

public class DirectoryFileDeflater extends FileHolderDeflater {
  public DirectoryFileDeflater() {
    super(new DefaultFileDeflateAdapter());
  }
  
  public void parse(String paramString1, String paramString2) {
    File file = new File(paramString2);
    if (file.exists()) {
      LinkedList<File> linkedList = new LinkedList();
      File[] arrayOfFile = file.listFiles();
      if (arrayOfFile != null) {
        int j = arrayOfFile.length;
        for (int i = 0; i < j; i++) {
          File file1 = arrayOfFile[i];
          if (file1.isDirectory()) {
            linkedList.add(file1);
          } else {
            String str1 = file1.getAbsolutePath();
            String str2 = str1.replace(paramString2, "");
            if (a(str2))
              a(str2, str1); 
          } 
        } 
      } 
      while (!linkedList.isEmpty()) {
        arrayOfFile = ((File)linkedList.removeFirst()).listFiles();
        if (arrayOfFile != null) {
          int j = arrayOfFile.length;
          for (int i = 0; i < j; i++) {
            File file1 = arrayOfFile[i];
            if (file1.isDirectory()) {
              linkedList.add(file1);
            } else {
              String str1 = file1.getAbsolutePath();
              String str2 = str1.replace(paramString2, "");
              if (a(str2))
                a(str2, str1); 
            } 
          } 
        } 
      } 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Dir: ");
    stringBuilder.append(paramString2);
    stringBuilder.append(" not exist");
    throw new PatchException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\DirectoryFileDeflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */