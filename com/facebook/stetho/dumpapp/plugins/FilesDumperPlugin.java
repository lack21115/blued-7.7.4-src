package com.facebook.stetho.dumpapp.plugins;

import android.content.Context;
import android.os.Environment;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.dumpapp.ArgsHelper;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FilesDumperPlugin implements DumperPlugin {
  private static final String NAME = "files";
  
  private final Context mContext;
  
  public FilesDumperPlugin(Context paramContext) {
    this.mContext = paramContext;
  }
  
  private void addFiles(ZipOutputStream paramZipOutputStream, byte[] paramArrayOfbyte, File[] paramArrayOfFile) throws IOException {
    int j = paramArrayOfFile.length;
    for (int i = 0;; i++) {
      if (i < j) {
        File file = paramArrayOfFile[i];
        if (file.isDirectory()) {
          addFiles(paramZipOutputStream, paramArrayOfbyte, file.listFiles());
        } else {
          paramZipOutputStream.putNextEntry(new ZipEntry(relativizePath(getBaseDir(this.mContext).getParentFile(), file)));
          FileInputStream fileInputStream = new FileInputStream(file);
          try {
            copy(fileInputStream, paramZipOutputStream, paramArrayOfbyte);
            fileInputStream.close();
          } finally {
            fileInputStream.close();
          } 
          continue;
        } 
      } else {
        break;
      } 
    } 
  }
  
  private static void copy(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfbyte) throws IOException {
    while (true) {
      int i = paramInputStream.read(paramArrayOfbyte);
      if (i >= 0) {
        paramOutputStream.write(paramArrayOfbyte, 0, i);
        continue;
      } 
      break;
    } 
  }
  
  private void doDownload(PrintStream paramPrintStream, Iterator<String> paramIterator) throws DumpUsageException {
    String str = ArgsHelper.nextArg(paramIterator, "Must specify output file or '-'");
    ArrayList<File> arrayList = new ArrayList();
    while (paramIterator.hasNext())
      arrayList.add(resolvePossibleAppStoragePath(this.mContext, paramIterator.next())); 
    try {
      FileOutputStream fileOutputStream;
      if (!"-".equals(str))
        fileOutputStream = new FileOutputStream(resolvePossibleSdcardPath(str)); 
      ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
      try {
        byte[] arrayOfByte = new byte[2048];
        if (arrayList.size() > 0) {
          addFiles(zipOutputStream, arrayOfByte, arrayList.<File>toArray(new File[arrayList.size()]));
        } else {
          addFiles(zipOutputStream, arrayOfByte, getBaseDir(this.mContext).listFiles());
        } 
      } finally {
        try {
          iOException.close();
        } catch (IOException iOException1) {
          Util.close(fileOutputStream, true);
        } 
      } 
    } catch (IOException iOException) {
      throw new RuntimeException(iOException);
    } 
  }
  
  private void doLs(PrintStream paramPrintStream) throws DumpUsageException {
    File file = getBaseDir(this.mContext);
    if (file.isDirectory())
      printDirectoryText(file, "", paramPrintStream); 
  }
  
  private void doTree(PrintStream paramPrintStream) throws DumpUsageException {
    printDirectoryVisual(getBaseDir(this.mContext), 0, paramPrintStream);
  }
  
  private void doUsage(PrintStream paramPrintStream) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Usage: dumpapp files ");
    stringBuilder.append("<command> [command-options]");
    paramPrintStream.println(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("       dumpapp files ");
    stringBuilder.append("ls");
    paramPrintStream.println(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("       dumpapp files ");
    stringBuilder.append("tree");
    paramPrintStream.println(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("       dumpapp files ");
    stringBuilder.append("download <output.zip> [<path>...]");
    paramPrintStream.println(stringBuilder.toString());
    paramPrintStream.println();
    paramPrintStream.println("dumpapp files ls: List files similar to the ls command");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp files tree: List files similar to the tree command");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp files download: Fetch internal application storage");
    paramPrintStream.println("    <output.zip>: Output location or '-' for stdout");
    paramPrintStream.println("    <path>: Fetch only those paths named (directories fetch recursively)");
  }
  
  private static File getBaseDir(Context paramContext) {
    return paramContext.getFilesDir().getParentFile();
  }
  
  private static void printDirectoryText(File paramFile, String paramString, PrintStream paramPrintStream) {
    File[] arrayOfFile = paramFile.listFiles();
    for (int i = 0; i < arrayOfFile.length; i++) {
      File file = arrayOfFile[i];
      if (file.isDirectory()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append(file.getName());
        stringBuilder.append("/");
        printDirectoryText(file, stringBuilder.toString(), paramPrintStream);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append(file.getName());
        paramPrintStream.println(stringBuilder.toString());
      } 
    } 
  }
  
  private static void printDirectoryVisual(File paramFile, int paramInt, PrintStream paramPrintStream) {
    File[] arrayOfFile = paramFile.listFiles();
    for (int i = 0; i < arrayOfFile.length; i++) {
      printHeaderVisual(paramInt, paramPrintStream);
      File file = arrayOfFile[i];
      paramPrintStream.print("+---");
      paramPrintStream.print(file.getName());
      paramPrintStream.println();
      if (file.isDirectory())
        printDirectoryVisual(file, paramInt + 1, paramPrintStream); 
    } 
  }
  
  private static void printHeaderVisual(int paramInt, PrintStream paramPrintStream) {
    for (int i = 0; i < paramInt; i++)
      paramPrintStream.print("|   "); 
  }
  
  private static String relativizePath(File paramFile1, File paramFile2) {
    String str1 = paramFile1.getAbsolutePath();
    String str2 = paramFile2.getAbsolutePath();
    return str2.startsWith(str1) ? str2.substring(str1.length() + 1) : str2;
  }
  
  private static File resolvePossibleAppStoragePath(Context paramContext, String paramString) {
    return paramString.startsWith("/") ? new File(paramString) : new File(getBaseDir(paramContext), paramString);
  }
  
  private static File resolvePossibleSdcardPath(String paramString) {
    return paramString.startsWith("/") ? new File(paramString) : new File(Environment.getExternalStorageDirectory(), paramString);
  }
  
  public void dump(DumperContext paramDumperContext) throws DumpException {
    Iterator<String> iterator = paramDumperContext.getArgsAsList().iterator();
    String str = ArgsHelper.nextOptionalArg(iterator, "");
    if ("ls".equals(str)) {
      doLs(paramDumperContext.getStdout());
      return;
    } 
    if ("tree".equals(str)) {
      doTree(paramDumperContext.getStdout());
      return;
    } 
    if ("download".equals(str)) {
      doDownload(paramDumperContext.getStdout(), iterator);
      return;
    } 
    doUsage(paramDumperContext.getStdout());
    if ("".equals(str))
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unknown command: ");
    stringBuilder.append(str);
    throw new DumpUsageException(stringBuilder.toString());
  }
  
  public String getName() {
    return "files";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\dumpapp\plugins\FilesDumperPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */