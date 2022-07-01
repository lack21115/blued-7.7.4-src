package com.qq.e.comm.plugin.j.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;

abstract class a {
  protected final InputStream a;
  
  protected final File b;
  
  protected final c c;
  
  protected String d;
  
  public a(InputStream paramInputStream, File paramFile, c paramc) {
    this.a = paramInputStream;
    this.b = paramFile;
    this.c = paramc;
  }
  
  public int a() {
    StringBuilder stringBuilder;
    String str;
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(this.b, true);
      try {
        int i = a(fileOutputStream);
        try {
          return i;
        } finally {
          fileOutputStream = null;
        } 
      } catch (SocketTimeoutException null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("SocketTimeoutExceptionWhileDoPartitionRW:");
        stringBuilder.append(iOException.getMessage());
        this.d = stringBuilder.toString();
        return 16777216;
      } catch (SocketException null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("UnknowSocketExceptionWhileDoPartitionRW:");
        stringBuilder.append(iOException.getMessage());
        this.d = stringBuilder.toString();
        return 4194304;
      } catch (IOException null) {
        stringBuilder = new StringBuilder();
        str = "UnknowIOExceptionWhileDoPartitionRW:";
      } 
    } catch (IOException iOException) {
      stringBuilder = new StringBuilder();
      str = "UnKnownExceptionWhileCreateOutputStreamForPartitionFile:";
    } 
    stringBuilder.append(str);
    stringBuilder.append(iOException.getMessage());
    this.d = stringBuilder.toString();
    return 2;
  }
  
  protected abstract int a(FileOutputStream paramFileOutputStream) throws IOException;
  
  public String b() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */