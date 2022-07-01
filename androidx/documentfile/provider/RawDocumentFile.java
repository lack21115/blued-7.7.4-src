package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class RawDocumentFile extends DocumentFile {
  private File a;
  
  RawDocumentFile(DocumentFile paramDocumentFile, File paramFile) {
    super(paramDocumentFile);
    this.a = paramFile;
  }
  
  private static String a(String paramString) {
    int i = paramString.lastIndexOf('.');
    if (i >= 0) {
      paramString = paramString.substring(i + 1).toLowerCase();
      paramString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      if (paramString != null)
        return paramString; 
    } 
    return "application/octet-stream";
  }
  
  private static boolean a(File paramFile) {
    File[] arrayOfFile = paramFile.listFiles();
    boolean bool = true;
    if (arrayOfFile != null) {
      int j = arrayOfFile.length;
      int i = 0;
      bool = true;
      while (i < j) {
        File file = arrayOfFile[i];
        boolean bool1 = bool;
        if (file.isDirectory())
          bool1 = bool & a(file); 
        bool = bool1;
        if (!file.delete()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Failed to delete ");
          stringBuilder.append(file);
          Log.w("DocumentFile", stringBuilder.toString());
          bool = false;
        } 
        i++;
      } 
    } 
    return bool;
  }
  
  public boolean canRead() {
    return this.a.canRead();
  }
  
  public boolean canWrite() {
    return this.a.canWrite();
  }
  
  public DocumentFile createDirectory(String paramString) {
    File file = new File(this.a, paramString);
    return (file.isDirectory() || file.mkdir()) ? new RawDocumentFile(this, file) : null;
  }
  
  public DocumentFile createFile(String paramString1, String paramString2) {
    String str1;
    String str2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString1);
    paramString1 = paramString2;
    if (str2 != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append(".");
      stringBuilder.append(str2);
      str1 = stringBuilder.toString();
    } 
    File file = new File(this.a, str1);
    try {
      file.createNewFile();
      return new RawDocumentFile(this, file);
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to createFile: ");
      stringBuilder.append(iOException);
      Log.w("DocumentFile", stringBuilder.toString());
      return null;
    } 
  }
  
  public boolean delete() {
    a(this.a);
    return this.a.delete();
  }
  
  public boolean exists() {
    return this.a.exists();
  }
  
  public String getName() {
    return this.a.getName();
  }
  
  public String getType() {
    return this.a.isDirectory() ? null : a(this.a.getName());
  }
  
  public Uri getUri() {
    return Uri.fromFile(this.a);
  }
  
  public boolean isDirectory() {
    return this.a.isDirectory();
  }
  
  public boolean isFile() {
    return this.a.isFile();
  }
  
  public boolean isVirtual() {
    return false;
  }
  
  public long lastModified() {
    return this.a.lastModified();
  }
  
  public long length() {
    return this.a.length();
  }
  
  public DocumentFile[] listFiles() {
    ArrayList<RawDocumentFile> arrayList = new ArrayList();
    File[] arrayOfFile = this.a.listFiles();
    if (arrayOfFile != null) {
      int j = arrayOfFile.length;
      for (int i = 0; i < j; i++)
        arrayList.add(new RawDocumentFile(this, arrayOfFile[i])); 
    } 
    return arrayList.<DocumentFile>toArray(new DocumentFile[arrayList.size()]);
  }
  
  public boolean renameTo(String paramString) {
    File file = new File(this.a.getParentFile(), paramString);
    if (this.a.renameTo(file)) {
      this.a = file;
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\documentfile\provider\RawDocumentFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */