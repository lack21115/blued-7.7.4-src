package android.support.v4.app;

import androidx.core.app.RemoteActionCompat;
import androidx.core.app.RemoteActionCompatParcelizer;
import androidx.versionedparcelable.VersionedParcel;

public final class RemoteActionCompatParcelizer extends RemoteActionCompatParcelizer {
  public static RemoteActionCompat read(VersionedParcel paramVersionedParcel) {
    return RemoteActionCompatParcelizer.read(paramVersionedParcel);
  }
  
  public static void write(RemoteActionCompat paramRemoteActionCompat, VersionedParcel paramVersionedParcel) {
    RemoteActionCompatParcelizer.write(paramRemoteActionCompat, paramVersionedParcel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\android\support\v4\app\RemoteActionCompatParcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */