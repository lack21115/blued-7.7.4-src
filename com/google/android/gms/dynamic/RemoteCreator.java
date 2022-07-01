package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;

public abstract class RemoteCreator<T> {
  private final String zza;
  
  private T zzb;
  
  public RemoteCreator(String paramString) {
    this.zza = paramString;
  }
  
  protected abstract T getRemoteCreator(IBinder paramIBinder);
  
  protected final T getRemoteCreatorInstance(Context paramContext) throws RemoteCreatorException {
    if (this.zzb == null) {
      Preconditions.checkNotNull(paramContext);
      paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (paramContext != null) {
        ClassLoader classLoader = paramContext.getClassLoader();
        try {
          this.zzb = getRemoteCreator((IBinder)classLoader.loadClass(this.zza).newInstance());
        } catch (ClassNotFoundException classNotFoundException) {
          throw new RemoteCreatorException("Could not load creator class.", classNotFoundException);
        } catch (InstantiationException instantiationException) {
          throw new RemoteCreatorException("Could not instantiate creator.", instantiationException);
        } catch (IllegalAccessException illegalAccessException) {
          throw new RemoteCreatorException("Could not access creator.", illegalAccessException);
        } 
      } else {
        throw new RemoteCreatorException("Could not get remote context.");
      } 
    } 
    return this.zzb;
  }
  
  public static class RemoteCreatorException extends Exception {
    public RemoteCreatorException(String param1String) {
      super(param1String);
    }
    
    public RemoteCreatorException(String param1String, Throwable param1Throwable) {
      super(param1String, param1Throwable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamic\RemoteCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */