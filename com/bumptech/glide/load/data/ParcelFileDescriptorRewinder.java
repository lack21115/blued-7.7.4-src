package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

public final class ParcelFileDescriptorRewinder implements DataRewinder<ParcelFileDescriptor> {
  private final InternalRewinder a;
  
  public ParcelFileDescriptorRewinder(ParcelFileDescriptor paramParcelFileDescriptor) {
    this.a = new InternalRewinder(paramParcelFileDescriptor);
  }
  
  public static boolean c() {
    return (Build.VERSION.SDK_INT >= 21);
  }
  
  public void b() {}
  
  public ParcelFileDescriptor d() throws IOException {
    return this.a.rewind();
  }
  
  public static final class Factory implements DataRewinder.Factory<ParcelFileDescriptor> {
    public DataRewinder<ParcelFileDescriptor> a(ParcelFileDescriptor param1ParcelFileDescriptor) {
      return new ParcelFileDescriptorRewinder(param1ParcelFileDescriptor);
    }
    
    public Class<ParcelFileDescriptor> a() {
      return ParcelFileDescriptor.class;
    }
  }
  
  static final class InternalRewinder {
    private final ParcelFileDescriptor a;
    
    InternalRewinder(ParcelFileDescriptor param1ParcelFileDescriptor) {
      this.a = param1ParcelFileDescriptor;
    }
    
    ParcelFileDescriptor rewind() throws IOException {
      try {
        Os.lseek(this.a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
        return this.a;
      } catch (ErrnoException errnoException) {
        throw new IOException(errnoException);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\ParcelFileDescriptorRewinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */