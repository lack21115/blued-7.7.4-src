package com.ss.android.socialbase.appdownloader.e.a;

import android.content.pm.PackageInfo;
import java.io.File;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class e {
  public static PackageInfo a(File paramFile) {
    try {
      ZipEntry zipEntry;
      ZipFile zipFile2 = new ZipFile(paramFile);
      Enumeration<? extends ZipEntry> enumeration = zipFile2.entries();
      ZipFile zipFile1 = null;
      paramFile = null;
      while (true) {
        boolean bool = enumeration.hasMoreElements();
        if (bool) {
          ZipEntry zipEntry1 = enumeration.nextElement();
          if (zipEntry1.isDirectory()) {
            ZipEntry zipEntry2 = zipEntry1;
            continue;
          } 
          zipEntry = zipEntry1;
          if (!"AndroidManifest.xml".equals(zipEntry1.getName())) {
            zipEntry = zipEntry1;
            continue;
          } 
        } 
        break;
      } 
      if (zipEntry != null && "AndroidManifest.xml".equals(zipEntry.getName())) {
        a a = new a();
        a.a(zipFile2.getInputStream(zipEntry));
        while (true) {
          int i = a.b();
          if (i != 1) {
            if (i == 2) {
              long l;
              String str;
              PackageInfo packageInfo;
              int j = a.e();
              i = 0;
              zipEntry = null;
              ZipEntry zipEntry1 = zipEntry;
              while (i != j) {
                ZipEntry zipEntry2;
                if ("versionName".equals(a.a(i))) {
                  String str1 = a(a, i);
                  zipFile2 = zipFile1;
                } else if ("versionCode".equals(a.a(i))) {
                  String str1 = a(a, i);
                  zipEntry2 = zipEntry;
                } else {
                  zipFile2 = zipFile1;
                  zipEntry2 = zipEntry;
                  if ("package".equals(a.a(i))) {
                    str = a(a, i);
                    zipEntry2 = zipEntry;
                    zipFile2 = zipFile1;
                  } 
                } 
                i++;
                zipFile1 = zipFile2;
                zipEntry = zipEntry2;
              } 
              try {
                l = Long.parseLong((String)zipFile1);
              } catch (c c) {
                l = -1L;
              } 
              if (l != -1L)
                return packageInfo; 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("versionCode获取失败: ");
              stringBuilder.append((String)packageInfo);
              throw new c(stringBuilder.toString());
            } 
            continue;
          } 
          throw new c("已达到END_DOCUMENT");
        } 
      } 
      throw new c("没有找到AndroidManifest.xml entry");
    } finally {
      paramFile = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("throwable: ");
      stringBuilder.append(paramFile.getMessage());
      stringBuilder.append(paramFile.toString());
    } 
  }
  
  private static String a(int paramInt) {
    return (paramInt >>> 24 == 1) ? "android:" : "";
  }
  
  private static String a(a parama, int paramInt) {
    int i = parama.b(paramInt);
    int j = parama.c(paramInt);
    return (i == 3) ? parama.d(paramInt) : ((i == 2) ? String.format("?%s%08X", new Object[] { a(j), Integer.valueOf(j) }) : ((i >= 16 && i <= 31) ? String.valueOf(j) : String.format("<0x%X, type 0x%02X>", new Object[] { Integer.valueOf(j), Integer.valueOf(i) })));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\e\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */