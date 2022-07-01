package com.facebook.stetho.dumpapp.plugins;

import android.content.Context;
import android.os.Debug;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;

public class HprofDumperPlugin implements DumperPlugin {
  private static final String NAME = "hprof";
  
  private final Context mContext;
  
  public HprofDumperPlugin(Context paramContext) {
    this.mContext = paramContext;
  }
  
  private void handlePipeOutput(OutputStream paramOutputStream) throws DumpException {
    File file = this.mContext.getFileStreamPath("hprof-dump.hprof");
    try {
      writeHprof(file);
      try {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
          Util.copy(fileInputStream, paramOutputStream, new byte[2048]);
          return;
        } finally {
          fileInputStream.close();
        } 
      } catch (IOException iOException) {}
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failure copying ");
      stringBuilder.append(file);
      stringBuilder.append(" to dumper output");
      throw new DumpException(stringBuilder.toString());
    } finally {
      if (file.exists())
        file.delete(); 
    } 
  }
  
  private static void truncateAndDeleteFile(File paramFile) throws IOException {
    (new FileOutputStream(paramFile)).close();
    if (paramFile.delete())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to delete ");
    stringBuilder.append(paramFile);
    throw new IOException(stringBuilder.toString());
  }
  
  private void usage(PrintStream paramPrintStream) throws DumpUsageException {
    paramPrintStream.println("Usage: dumpapp hprof [ path ]");
    paramPrintStream.println("Dump HPROF memory usage data from the running application.");
    paramPrintStream.println();
    paramPrintStream.println("Where path can be any of:");
    paramPrintStream.println("  -           Output directly to stdout");
    paramPrintStream.println("  <path>      Full path to a writable file on the device");
    paramPrintStream.println("  <filename>  Relative filename that will be stored in the app internal storage");
    throw new DumpUsageException("Missing path");
  }
  
  private void writeHprof(File paramFile) throws DumpException {
    try {
      truncateAndDeleteFile(paramFile);
      Debug.dumpHprofData(paramFile.getAbsolutePath());
      return;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failure writing to ");
      stringBuilder.append(paramFile);
      stringBuilder.append(": ");
      stringBuilder.append(iOException.getMessage());
      throw new DumpException(stringBuilder.toString());
    } 
  }
  
  public void dump(DumperContext paramDumperContext) throws DumpException {
    String str;
    PrintStream printStream = paramDumperContext.getStdout();
    Iterator<String> iterator = paramDumperContext.getArgsAsList().iterator();
    if (iterator.hasNext()) {
      str = iterator.next();
    } else {
      str = null;
    } 
    if (str == null) {
      usage(printStream);
      return;
    } 
    if ("-".equals(str)) {
      handlePipeOutput(printStream);
      return;
    } 
    File file2 = new File(str);
    File file1 = file2;
    if (!file2.isAbsolute())
      file1 = this.mContext.getFileStreamPath(str); 
    writeHprof(file1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Wrote to ");
    stringBuilder.append(file1);
    printStream.println(stringBuilder.toString());
  }
  
  public String getName() {
    return "hprof";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\dumpapp\plugins\HprofDumperPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */