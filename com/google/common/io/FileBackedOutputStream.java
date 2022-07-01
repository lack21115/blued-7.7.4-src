package com.google.common.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class FileBackedOutputStream extends OutputStream {
  private final int a;
  
  private final boolean b;
  
  @NullableDecl
  private final File c;
  
  private OutputStream d;
  
  private MemoryOutput e;
  
  @NullableDecl
  private File f;
  
  private void a(int paramInt) throws IOException {
    if (this.f == null && this.e.b() + paramInt > this.a) {
      File file = File.createTempFile("FileBackedOutputStream", null, this.c);
      if (this.b)
        file.deleteOnExit(); 
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      fileOutputStream.write(this.e.a(), 0, this.e.b());
      fileOutputStream.flush();
      this.d = fileOutputStream;
      this.f = file;
      this.e = null;
    } 
  }
  
  private InputStream b() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Ljava/io/File;
    //   6: ifnull -> 25
    //   9: new java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: getfield f : Ljava/io/File;
    //   17: invokespecial <init> : (Ljava/io/File;)V
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: new java/io/ByteArrayInputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield e : Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   33: invokevirtual a : ()[B
    //   36: iconst_0
    //   37: aload_0
    //   38: getfield e : Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   41: invokevirtual b : ()I
    //   44: invokespecial <init> : ([BII)V
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: areturn
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	52	finally
    //   25	48	52	finally
  }
  
  public void a() throws IOException {
    File file;
    /* monitor enter ThisExpression{ObjectType{com/google/common/io/FileBackedOutputStream}} */
    try {
    
    } finally {
      StringBuilder stringBuilder;
      Exception exception = null;
      if (this.e == null) {
        this.e = new MemoryOutput();
      } else {
        this.e.reset();
      } 
      this.d = this.e;
      if (this.f != null) {
        file = this.f;
        this.f = null;
        if (!file.delete()) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Could not delete: ");
          stringBuilder.append(file);
          throw new IOException(stringBuilder.toString());
        } 
      } 
    } 
    /* monitor exit ThisExpression{ObjectType{com/google/common/io/FileBackedOutputStream}} */
    throw file;
  }
  
  public void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Ljava/io/OutputStream;
    //   6: invokevirtual close : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public void flush() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Ljava/io/OutputStream;
    //   6: invokevirtual flush : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public void write(int paramInt) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: invokespecial a : (I)V
    //   7: aload_0
    //   8: getfield d : Ljava/io/OutputStream;
    //   11: iload_1
    //   12: invokevirtual write : (I)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	18	finally
  }
  
  public void write(byte[] paramArrayOfbyte) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iconst_0
    //   5: aload_1
    //   6: arraylength
    //   7: invokevirtual write : ([BII)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_3
    //   4: invokespecial a : (I)V
    //   7: aload_0
    //   8: getfield d : Ljava/io/OutputStream;
    //   11: aload_1
    //   12: iload_2
    //   13: iload_3
    //   14: invokevirtual write : ([BII)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
  
  static class MemoryOutput extends ByteArrayOutputStream {
    private MemoryOutput() {}
    
    byte[] a() {
      return this.buf;
    }
    
    int b() {
      return this.count;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\FileBackedOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */