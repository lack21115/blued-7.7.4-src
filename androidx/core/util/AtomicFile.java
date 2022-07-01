package androidx.core.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {
  private final File a;
  
  private final File b;
  
  public AtomicFile(File paramFile) {
    this.a = paramFile;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramFile.getPath());
    stringBuilder.append(".bak");
    this.b = new File(stringBuilder.toString());
  }
  
  private static boolean a(FileOutputStream paramFileOutputStream) {
    try {
      paramFileOutputStream.getFD().sync();
      return true;
    } catch (IOException iOException) {
      return false;
    } 
  }
  
  public void delete() {
    this.a.delete();
    this.b.delete();
  }
  
  public void failWrite(FileOutputStream paramFileOutputStream) {
    if (paramFileOutputStream != null) {
      a(paramFileOutputStream);
      try {
        paramFileOutputStream.close();
        this.a.delete();
        this.b.renameTo(this.a);
        return;
      } catch (IOException iOException) {
        Log.w("AtomicFile", "failWrite: Got exception:", iOException);
      } 
    } 
  }
  
  public void finishWrite(FileOutputStream paramFileOutputStream) {
    if (paramFileOutputStream != null) {
      a(paramFileOutputStream);
      try {
        paramFileOutputStream.close();
        this.b.delete();
        return;
      } catch (IOException iOException) {
        Log.w("AtomicFile", "finishWrite: Got exception:", iOException);
      } 
    } 
  }
  
  public File getBaseFile() {
    return this.a;
  }
  
  public FileInputStream openRead() throws FileNotFoundException {
    if (this.b.exists()) {
      this.a.delete();
      this.b.renameTo(this.a);
    } 
    return new FileInputStream(this.a);
  }
  
  public byte[] readFully() throws IOException {
    FileInputStream fileInputStream = openRead();
    try {
      byte[] arrayOfByte = new byte[fileInputStream.available()];
      int i = 0;
      while (true) {
        int j = fileInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
        if (j <= 0)
          return arrayOfByte; 
        j = i + j;
        int k = fileInputStream.available();
        i = j;
        if (k > arrayOfByte.length - j) {
          byte[] arrayOfByte1 = new byte[k + j];
          System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, j);
          arrayOfByte = arrayOfByte1;
          i = j;
        } 
      } 
    } finally {
      fileInputStream.close();
    } 
  }
  
  public FileOutputStream startWrite() throws IOException {
    if (this.a.exists())
      if (!this.b.exists()) {
        if (!this.a.renameTo(this.b)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Couldn't rename file ");
          stringBuilder.append(this.a);
          stringBuilder.append(" to backup file ");
          stringBuilder.append(this.b);
          Log.w("AtomicFile", stringBuilder.toString());
        } 
      } else {
        this.a.delete();
      }  
    try {
      return new FileOutputStream(this.a);
    } catch (FileNotFoundException fileNotFoundException) {
      if (this.a.getParentFile().mkdirs())
        try {
          return new FileOutputStream(this.a);
        } catch (FileNotFoundException fileNotFoundException1) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Couldn't create ");
          stringBuilder1.append(this.a);
          throw new IOException(stringBuilder1.toString());
        }  
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Couldn't create directory ");
      stringBuilder.append(this.a);
      throw new IOException(stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cor\\util\AtomicFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */