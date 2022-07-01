package android.support.v4.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public final class TypefaceCompatUtil {
  public static void closeQuietly(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {} 
  }
  
  public static ByteBuffer copyToDirectBuffer(Context paramContext, Resources paramResources, int paramInt) {
    File file = getTempFile(paramContext);
    if (file == null)
      return null; 
    try {
      boolean bool = copyToFile(file, paramResources, paramInt);
      if (!bool)
        return null; 
      return mmap(file);
    } finally {
      file.delete();
    } 
  }
  
  public static boolean copyToFile(File paramFile, Resources paramResources, int paramInt) {
    try {
      InputStream inputStream = paramResources.openRawResource(paramInt);
    } finally {
      paramFile = null;
    } 
    closeQuietly((Closeable)paramResources);
    throw paramFile;
  }
  
  public static boolean copyToFile(File paramFile, InputStream paramInputStream) {
    File file2 = null;
    byte[] arrayOfByte = null;
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(paramFile, false);
      try {
        arrayOfByte = new byte[1024];
        while (true) {
          int i = paramInputStream.read(arrayOfByte);
          return true;
        } 
      } catch (IOException null) {
      
      } finally {
        InputStream inputStream;
        paramInputStream = null;
        FileOutputStream fileOutputStream1 = fileOutputStream;
      } 
    } catch (IOException iOException) {
      paramFile = file2;
    } finally {}
    File file1 = paramFile;
    StringBuilder stringBuilder = new StringBuilder("Error copying resource contents to temp file: ");
    file1 = paramFile;
    stringBuilder.append(iOException.getMessage());
    file1 = paramFile;
    Log.e("TypefaceCompatUtil", stringBuilder.toString());
    closeQuietly((Closeable)paramFile);
    return false;
  }
  
  public static File getTempFile(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder(".font");
    stringBuilder.append(Process.myPid());
    stringBuilder.append("-");
    stringBuilder.append(Process.myTid());
    stringBuilder.append("-");
    String str = stringBuilder.toString();
    for (int i = 0; i < 100; i++) {
      File file = paramContext.getCacheDir();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append(i);
      file = new File(file, stringBuilder1.toString());
      try {
        boolean bool = file.createNewFile();
        if (bool)
          return file; 
      } catch (IOException iOException) {}
    } 
    return null;
  }
  
  public static ByteBuffer mmap(Context paramContext, CancellationSignal paramCancellationSignal, Uri paramUri) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    try {
      ParcelFileDescriptor parcelFileDescriptor = contentResolver.openFileDescriptor(paramUri, "r", paramCancellationSignal);
      try {
        FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
        try {
          FileChannel fileChannel = fileInputStream.getChannel();
          long l = fileChannel.size();
          return fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, l);
        } catch (Throwable throwable1) {
          try {
            throw throwable1;
          } finally {}
        } finally {
          paramCancellationSignal = null;
        } 
        if (contentResolver != null) {
          try {
            fileInputStream.close();
          } catch (Throwable throwable) {
            ThrowableExtension.addSuppressed((Throwable)contentResolver, throwable);
          } 
        } else {
          throwable.close();
        } 
        throw paramCancellationSignal;
      } catch (Throwable throwable) {
        try {
          throw throwable;
        } finally {}
      } finally {
        contentResolver = null;
      } 
      if (parcelFileDescriptor != null)
        if (paramCancellationSignal != null) {
          try {
            parcelFileDescriptor.close();
          } catch (Throwable throwable) {
            ThrowableExtension.addSuppressed((Throwable)paramCancellationSignal, throwable);
          } 
        } else {
          throwable.close();
        }  
      throw contentResolver;
    } catch (IOException iOException) {
      return null;
    } 
  }
  
  private static ByteBuffer mmap(File paramFile) {
    try {
      Exception exception;
      FileInputStream fileInputStream = new FileInputStream(paramFile);
      try {
        FileChannel fileChannel = fileInputStream.getChannel();
        long l = fileChannel.size();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, l);
      } catch (Throwable throwable1) {
        try {
          throw throwable1;
        } finally {}
      } finally {
        exception = null;
      } 
      if (paramFile != null) {
        try {
          fileInputStream.close();
        } catch (Throwable throwable) {
          ThrowableExtension.addSuppressed((Throwable)paramFile, throwable);
        } 
      } else {
        throwable.close();
      } 
      throw exception;
    } catch (IOException iOException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\graphics\TypefaceCompatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */