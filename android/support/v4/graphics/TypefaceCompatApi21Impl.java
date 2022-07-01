package android.support.v4.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.provider.FontsContractCompat;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
  private static File getFile(ParcelFileDescriptor paramParcelFileDescriptor) {
    try {
      StringBuilder stringBuilder = new StringBuilder("/proc/self/fd/");
      stringBuilder.append(paramParcelFileDescriptor.getFd());
      String str = Os.readlink(stringBuilder.toString());
      return OsConstants.S_ISREG((Os.stat(str)).st_mode) ? new File(str) : null;
    } catch (ErrnoException errnoException) {
      return null;
    } 
  }
  
  public Typeface createFromFontInfo(Context paramContext, CancellationSignal paramCancellationSignal, FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt) {
    if (paramArrayOfFontInfo.length <= 0)
      return null; 
    FontsContractCompat.FontInfo fontInfo = findBestInfo(paramArrayOfFontInfo, paramInt);
    ContentResolver contentResolver = paramContext.getContentResolver();
    try {
      ParcelFileDescriptor parcelFileDescriptor = contentResolver.openFileDescriptor(fontInfo.mUri, "r", paramCancellationSignal);
      try {
        File file = getFile(parcelFileDescriptor);
        if (file == null || !file.canRead()) {
          FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
          try {
            return TypefaceCompatBaseImpl.createFromInputStream(paramContext, fileInputStream);
          } catch (Throwable throwable1) {
            try {
              throw throwable1;
            } finally {}
          } finally {
            paramContext = null;
          } 
          if (file != null) {
            try {
              fileInputStream.close();
            } catch (Throwable throwable) {
              ThrowableExtension.addSuppressed((Throwable)file, throwable);
            } 
          } else {
            throwable.close();
          } 
          throw paramContext;
        } 
        return Typeface.createFromFile(file);
      } catch (Throwable throwable) {
        try {
          throw throwable;
        } finally {}
      } finally {
        paramContext = null;
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
      throw paramContext;
    } catch (IOException iOException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\graphics\TypefaceCompatApi21Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */