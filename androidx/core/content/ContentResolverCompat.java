package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;

public final class ContentResolverCompat {
  public static Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, CancellationSignal paramCancellationSignal) {
    if (Build.VERSION.SDK_INT >= 16) {
      if (paramCancellationSignal != null)
        try {
          object = paramCancellationSignal.getCancellationSignalObject();
          return paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (CancellationSignal)object);
        } catch (Exception exception) {
          if (exception instanceof android.os.OperationCanceledException)
            throw new OperationCanceledException(); 
          throw exception;
        }  
    } else {
      if (object != null)
        object.throwIfCanceled(); 
      return exception.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    } 
    Object object = null;
    return exception.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (CancellationSignal)object);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\content\ContentResolverCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */