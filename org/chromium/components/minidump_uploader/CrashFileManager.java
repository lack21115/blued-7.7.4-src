package org.chromium.components.minidump_uploader;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.chromium.base.Log;

public class CrashFileManager {
  private static final Pattern MINIDUMP_READY_FOR_UPLOAD_PATTERN;
  
  public static final Pattern MINIDUMP_SANS_LOGCAT_PATTERN;
  
  private static final Pattern TMP_PATTERN;
  
  private static final Pattern UPLOADED_MINIDUMP_PATTERN;
  
  private static Comparator sFileComparator;
  
  private final File mCacheDir;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public CrashFileManager(File paramFile) {
    if (paramFile != null) {
      if (paramFile.isDirectory()) {
        this.mCacheDir = paramFile;
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramFile.getAbsolutePath());
      stringBuilder.append(" is not a directory.");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new NullPointerException("Specified context cannot be null.");
  }
  
  private static boolean deleteFile(File paramFile) {
    boolean bool = paramFile.delete();
    if (!bool) {
      StringBuilder stringBuilder = new StringBuilder("Unable to delete ");
      stringBuilder.append(paramFile.getAbsolutePath());
      Log.w("CrashFileManager", stringBuilder.toString(), new Object[0]);
    } 
    return bool;
  }
  
  private void enforceMinidumpStorageRestrictions(int paramInt) {
    File file;
    File[] arrayOfFile = listCrashFiles(MINIDUMP_READY_FOR_UPLOAD_PATTERN);
    ArrayList<File> arrayList = new ArrayList();
    int j = arrayOfFile.length;
    for (int i = 0; i < j; i++) {
      File file1 = arrayOfFile[i];
      String str = file1.getName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("_");
      if (str.startsWith(stringBuilder.toString()))
        arrayList.add(file1); 
    } 
    if (arrayList.size() >= 10) {
      file = arrayList.get(arrayList.size() - 1);
      if (!file.delete()) {
        StringBuilder stringBuilder = new StringBuilder("Couldn't delete old minidump ");
        stringBuilder.append(file.getAbsolutePath());
        Log.w("CrashFileManager", stringBuilder.toString(), new Object[0]);
      } 
      return;
    } 
    if (file.length >= 20) {
      file = file[file.length - 1];
      if (!file.delete()) {
        StringBuilder stringBuilder = new StringBuilder("Couldn't delete old minidump ");
        stringBuilder.append(file.getAbsolutePath());
        Log.w("CrashFileManager", stringBuilder.toString(), new Object[0]);
      } 
    } 
  }
  
  public static boolean isForcedUpload(File paramFile) {
    return paramFile.getName().contains(".forced");
  }
  
  public static void markUploadSkipped(File paramFile) {
    renameCrashDumpFollowingUpload(paramFile, ".skipped");
  }
  
  public static void markUploadSuccess(File paramFile) {
    renameCrashDumpFollowingUpload(paramFile, ".up");
  }
  
  public static int readAttemptNumber(String paramString) {
    int i = readAttemptNumberInternal(paramString);
    return (i >= 0) ? i : 0;
  }
  
  private static int readAttemptNumberInternal(String paramString) {
    int i = paramString.lastIndexOf(".try");
    if (i >= 0) {
      paramString = paramString.substring(i + 4);
      Scanner scanner = (new Scanner(paramString)).useDelimiter("[^0-9]+");
      try {
        i = scanner.nextInt();
        int j = paramString.indexOf(Integer.toString(i));
        return (j == 0) ? i : -1;
      } catch (NoSuchElementException noSuchElementException) {
        return -1;
      } 
    } 
    return -1;
  }
  
  private static void renameCrashDumpFollowingUpload(File paramFile, String paramString) {
    if (!paramFile.renameTo(new File(paramFile.getPath().replace(".dmp", paramString).replace(".forced", paramString)))) {
      StringBuilder stringBuilder = new StringBuilder("Failed to rename ");
      stringBuilder.append(paramFile);
      Log.w("CrashFileManager", stringBuilder.toString(), new Object[0]);
      if (!paramFile.delete()) {
        stringBuilder = new StringBuilder("Failed to delete ");
        stringBuilder.append(paramFile);
        Log.w("CrashFileManager", stringBuilder.toString(), new Object[0]);
      } 
    } 
  }
  
  public static String tryIncrementAttemptNumber(File paramFile) {
    String str = paramFile.getPath();
    int i = readAttemptNumberInternal(str);
    if (i >= 0) {
      StringBuilder stringBuilder1 = new StringBuilder(".try");
      stringBuilder1.append(i);
      String str1 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder(".try");
      stringBuilder2.append(i + 1);
      str = str.replace(str1, stringBuilder2.toString());
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(".try1");
      str = stringBuilder.toString();
    } 
    return paramFile.renameTo(new File(str)) ? str : null;
  }
  
  public final void cleanOutAllNonFreshMinidumpFiles() {
    File[] arrayOfFile = listCrashFiles(UPLOADED_MINIDUMP_PATTERN);
    int j = arrayOfFile.length;
    int k = 0;
    int i;
    for (i = 0; i < j; i++)
      deleteFile(arrayOfFile[i]); 
    arrayOfFile = listCrashFiles(TMP_PATTERN);
    j = arrayOfFile.length;
    for (i = 0; i < j; i++)
      deleteFile(arrayOfFile[i]); 
    arrayOfFile = listCrashFiles(null);
    int m = arrayOfFile.length;
    j = 0;
    i = k;
    while (i < m) {
      File file = arrayOfFile[i];
      k = j;
      if (!file.getName().equals("uploads.log")) {
        long l1 = (new Date()).getTime();
        long l2 = file.lastModified();
        if (TimeUnit.DAYS.convert(l1 - l2, TimeUnit.MILLISECONDS) > 30L) {
          deleteFile(file);
          k = j;
        } else if (j < 10) {
          k = j + 1;
        } else {
          deleteFile(file);
          k = j;
        } 
      } 
      i++;
      j = k;
    } 
  }
  
  public final File copyMinidumpFromFD(FileDescriptor paramFileDescriptor, File paramFile, int paramInt) {
    StringBuilder stringBuilder;
    int i;
    File file2 = getCrashDirectory();
    File file1 = getCrashDirectory();
    if (file1.mkdir() || file1.isDirectory()) {
      i = 1;
    } else {
      i = 0;
    } 
    if (!i) {
      Log.e("CrashFileManager", "Crash directory doesn't exist", new Object[0]);
      return null;
    } 
    if (!paramFile.isDirectory() && !paramFile.mkdir()) {
      stringBuilder = new StringBuilder("Couldn't create ");
      stringBuilder.append(paramFile.getAbsolutePath());
      Log.e("CrashFileManager", stringBuilder.toString(), new Object[0]);
      return null;
    } 
    if (!paramFile.getCanonicalPath().equals(file2.getCanonicalPath())) {
      enforceMinidumpStorageRestrictions(paramInt);
      File file = File.createTempFile("webview_minidump", ".tmp", paramFile);
      try {
      
      } finally {
        stringBuilder = null;
        paramFile = null;
      } 
      if (paramFile != null)
        try {
          paramFile.close();
        } catch (IOException iOException) {
          Log.w("CrashFileManager", "Couldn't close minidump output stream ", new Object[] { iOException });
        }  
      if (file1 != null)
        try {
          file1.close();
        } catch (IOException iOException) {
          Log.w("CrashFileManager", "Couldn't close minidump input stream ", new Object[] { iOException });
        }  
      throw stringBuilder;
    } 
    throw new RuntimeException("The tmp-dir and the crash dir can't have the same paths.");
  }
  
  public final File getCrashDirectory() {
    return new File(this.mCacheDir, "Crash Reports");
  }
  
  public final File[] getMinidumpsReadyForUpload(int paramInt) {
    File[] arrayOfFile = listCrashFiles(MINIDUMP_READY_FOR_UPLOAD_PATTERN);
    ArrayList<File> arrayList = new ArrayList();
    int j = arrayOfFile.length;
    for (int i = 0; i < j; i++) {
      File file = arrayOfFile[i];
      if (readAttemptNumber(file.getName()) < paramInt)
        arrayList.add(file); 
    } 
    return arrayList.<File>toArray(new File[arrayList.size()]);
  }
  
  public final File[] listCrashFiles(Pattern paramPattern) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getCrashDirectory : ()Ljava/io/File;
    //   4: astore_2
    //   5: aload_1
    //   6: ifnull -> 21
    //   9: new org/chromium/components/minidump_uploader/CrashFileManager$2
    //   12: dup
    //   13: aload_1
    //   14: invokespecial <init> : (Ljava/util/regex/Pattern;)V
    //   17: astore_1
    //   18: goto -> 23
    //   21: aconst_null
    //   22: astore_1
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual listFiles : (Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   28: astore_1
    //   29: aload_1
    //   30: ifnonnull -> 76
    //   33: new java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: astore_1
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_1
    //   51: ldc_w ' does not exist or is not a directory'
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc 'CrashFileManager'
    //   60: aload_1
    //   61: invokevirtual toString : ()Ljava/lang/String;
    //   64: iconst_0
    //   65: anewarray java/lang/Object
    //   68: invokestatic w : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: iconst_0
    //   72: anewarray java/io/File
    //   75: areturn
    //   76: aload_1
    //   77: getstatic org/chromium/components/minidump_uploader/CrashFileManager.sFileComparator : Ljava/util/Comparator;
    //   80: invokestatic sort : ([Ljava/lang/Object;Ljava/util/Comparator;)V
    //   83: aload_1
    //   84: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\minidump_uploader\CrashFileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */