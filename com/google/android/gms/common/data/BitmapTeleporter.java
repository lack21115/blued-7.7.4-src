package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
  public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zaa();
  
  private final int zaa;
  
  private ParcelFileDescriptor zab;
  
  private final int zac;
  
  private Bitmap zad;
  
  private boolean zae;
  
  private File zaf;
  
  BitmapTeleporter(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2) {
    this.zaa = paramInt1;
    this.zab = paramParcelFileDescriptor;
    this.zac = paramInt2;
    this.zad = null;
    this.zae = false;
  }
  
  public BitmapTeleporter(Bitmap paramBitmap) {
    this.zaa = 1;
    this.zab = null;
    this.zac = 0;
    this.zad = paramBitmap;
    this.zae = true;
  }
  
  private final FileOutputStream zaa() {
    File file = this.zaf;
    if (file != null)
      try {
        file = File.createTempFile("teleporter", ".tmp", file);
        try {
          FileOutputStream fileOutputStream = new FileOutputStream(file);
          this.zab = ParcelFileDescriptor.open(file, 268435456);
          file.delete();
          return fileOutputStream;
        } catch (FileNotFoundException fileNotFoundException) {}
        throw new IllegalStateException("Temporary file is somehow already deleted");
      } catch (IOException iOException) {
        throw new IllegalStateException("Could not create temporary file", iOException);
      }  
    throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
  }
  
  private static void zaa(Closeable paramCloseable) {
    try {
      paramCloseable.close();
      return;
    } catch (IOException iOException) {
      Log.w("BitmapTeleporter", "Could not close stream", iOException);
      return;
    } 
  }
  
  public Bitmap get() {
    if (!this.zae) {
      DataInputStream dataInputStream = new DataInputStream((InputStream)new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor)Preconditions.checkNotNull(this.zab)));
      try {
        byte[] arrayOfByte = new byte[dataInputStream.readInt()];
        int i = dataInputStream.readInt();
        int j = dataInputStream.readInt();
        Bitmap.Config config = Bitmap.Config.valueOf(dataInputStream.readUTF());
        dataInputStream.read(arrayOfByte);
        zaa(dataInputStream);
        ByteBuffer byteBuffer = ByteBuffer.wrap(arrayOfByte);
        Bitmap bitmap = Bitmap.createBitmap(i, j, config);
        bitmap.copyPixelsFromBuffer(byteBuffer);
        this.zad = bitmap;
        this.zae = true;
      } catch (IOException iOException) {
        throw new IllegalStateException("Could not read from parcel file descriptor", iOException);
      } finally {
        Exception exception;
      } 
    } 
    return this.zad;
  }
  
  public void release() {
    if (!this.zae)
      try {
        ((ParcelFileDescriptor)Preconditions.checkNotNull(this.zab)).close();
        return;
      } catch (IOException iOException) {
        Log.w("BitmapTeleporter", "Could not close PFD", iOException);
      }  
  }
  
  public void setTempDir(File paramFile) {
    if (paramFile != null) {
      this.zaf = paramFile;
      return;
    } 
    throw new NullPointerException("Cannot set null temp directory");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    if (this.zab == null) {
      Bitmap bitmap = (Bitmap)Preconditions.checkNotNull(this.zad);
      ByteBuffer byteBuffer = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
      bitmap.copyPixelsToBuffer(byteBuffer);
      byte[] arrayOfByte = byteBuffer.array();
      DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(zaa()));
      try {
        dataOutputStream.writeInt(arrayOfByte.length);
        dataOutputStream.writeInt(bitmap.getWidth());
        dataOutputStream.writeInt(bitmap.getHeight());
        dataOutputStream.writeUTF(bitmap.getConfig().toString());
        dataOutputStream.write(arrayOfByte);
        zaa(dataOutputStream);
      } catch (IOException iOException) {
        throw new IllegalStateException("Could not write into unlinked file", iOException);
      } finally {}
    } 
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zab, paramInt | 0x1, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zac);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    this.zab = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\data\BitmapTeleporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */