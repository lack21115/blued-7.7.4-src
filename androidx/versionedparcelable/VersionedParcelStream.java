package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;

class VersionedParcelStream extends VersionedParcel {
  private static final Charset f = Charset.forName("UTF-16");
  
  int d;
  
  int e;
  
  private final DataInputStream g;
  
  private final DataOutputStream h;
  
  private DataInputStream i;
  
  private DataOutputStream j;
  
  private FieldBuffer k;
  
  private boolean l;
  
  private int m;
  
  public VersionedParcelStream(InputStream paramInputStream, OutputStream paramOutputStream) {
    this(paramInputStream, paramOutputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
  }
  
  private VersionedParcelStream(InputStream paramInputStream, OutputStream paramOutputStream, ArrayMap<String, Method> paramArrayMap1, ArrayMap<String, Method> paramArrayMap2, ArrayMap<String, Class> paramArrayMap) {
    super(paramArrayMap1, paramArrayMap2, paramArrayMap);
    DataOutputStream dataOutputStream;
    this.d = 0;
    this.m = -1;
    this.e = -1;
    paramArrayMap1 = null;
    if (paramInputStream != null) {
      paramInputStream = new DataInputStream(new FilterInputStream(this, paramInputStream) {
            public int read() throws IOException {
              if (this.a.e == -1 || this.a.d < this.a.e) {
                int i = super.read();
                VersionedParcelStream versionedParcelStream = this.a;
                versionedParcelStream.d++;
                return i;
              } 
              throw new IOException();
            }
            
            public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
              if (this.a.e == -1 || this.a.d < this.a.e) {
                param1Int1 = super.read(param1ArrayOfbyte, param1Int1, param1Int2);
                if (param1Int1 > 0) {
                  VersionedParcelStream versionedParcelStream = this.a;
                  versionedParcelStream.d += param1Int1;
                } 
                return param1Int1;
              } 
              throw new IOException();
            }
            
            public long skip(long param1Long) throws IOException {
              if (this.a.e == -1 || this.a.d < this.a.e) {
                param1Long = super.skip(param1Long);
                if (param1Long > 0L) {
                  VersionedParcelStream versionedParcelStream = this.a;
                  versionedParcelStream.d += (int)param1Long;
                } 
                return param1Long;
              } 
              throw new IOException();
            }
          });
    } else {
      paramInputStream = null;
    } 
    this.g = (DataInputStream)paramInputStream;
    ArrayMap<String, Method> arrayMap = paramArrayMap1;
    if (paramOutputStream != null)
      dataOutputStream = new DataOutputStream(paramOutputStream); 
    this.h = dataOutputStream;
    this.i = this.g;
    this.j = this.h;
  }
  
  private void a(int paramInt, String paramString, Bundle paramBundle) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown type ");
        stringBuilder.append(paramInt);
        throw new RuntimeException(stringBuilder.toString());
      case 14:
        paramBundle.putFloatArray((String)stringBuilder, f());
        return;
      case 13:
        paramBundle.putFloat((String)stringBuilder, readFloat());
        return;
      case 12:
        paramBundle.putLongArray((String)stringBuilder, e());
        return;
      case 11:
        paramBundle.putLong((String)stringBuilder, readLong());
        return;
      case 10:
        paramBundle.putIntArray((String)stringBuilder, d());
        return;
      case 9:
        paramBundle.putInt((String)stringBuilder, readInt());
        return;
      case 8:
        paramBundle.putDoubleArray((String)stringBuilder, g());
        return;
      case 7:
        paramBundle.putDouble((String)stringBuilder, readDouble());
        return;
      case 6:
        paramBundle.putBooleanArray((String)stringBuilder, c());
        return;
      case 5:
        paramBundle.putBoolean((String)stringBuilder, readBoolean());
        return;
      case 4:
        paramBundle.putStringArray((String)stringBuilder, b(new String[0]));
        return;
      case 3:
        paramBundle.putString((String)stringBuilder, readString());
        return;
      case 2:
        paramBundle.putBundle((String)stringBuilder, readBundle());
        return;
      case 1:
        paramBundle.putBundle((String)stringBuilder, readBundle());
        return;
      case 0:
        break;
    } 
    paramBundle.putParcelable((String)stringBuilder, null);
  }
  
  private void a(Object paramObject) {
    if (paramObject == null) {
      writeInt(0);
      return;
    } 
    if (paramObject instanceof Bundle) {
      writeInt(1);
      writeBundle((Bundle)paramObject);
      return;
    } 
    if (paramObject instanceof String) {
      writeInt(3);
      writeString((String)paramObject);
      return;
    } 
    if (paramObject instanceof String[]) {
      writeInt(4);
      a((String[])paramObject);
      return;
    } 
    if (paramObject instanceof Boolean) {
      writeInt(5);
      writeBoolean(((Boolean)paramObject).booleanValue());
      return;
    } 
    if (paramObject instanceof boolean[]) {
      writeInt(6);
      a((boolean[])paramObject);
      return;
    } 
    if (paramObject instanceof Double) {
      writeInt(7);
      writeDouble(((Double)paramObject).doubleValue());
      return;
    } 
    if (paramObject instanceof double[]) {
      writeInt(8);
      a((double[])paramObject);
      return;
    } 
    if (paramObject instanceof Integer) {
      writeInt(9);
      writeInt(((Integer)paramObject).intValue());
      return;
    } 
    if (paramObject instanceof int[]) {
      writeInt(10);
      a((int[])paramObject);
      return;
    } 
    if (paramObject instanceof Long) {
      writeInt(11);
      writeLong(((Long)paramObject).longValue());
      return;
    } 
    if (paramObject instanceof long[]) {
      writeInt(12);
      a((long[])paramObject);
      return;
    } 
    if (paramObject instanceof Float) {
      writeInt(13);
      writeFloat(((Float)paramObject).floatValue());
      return;
    } 
    if (paramObject instanceof float[]) {
      writeInt(14);
      a((float[])paramObject);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unsupported type ");
    stringBuilder.append(paramObject.getClass());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  protected VersionedParcel a() {
    return new VersionedParcelStream(this.i, this.j, this.a, this.b, this.c);
  }
  
  protected void a(CharSequence paramCharSequence) {
    if (this.l)
      return; 
    throw new RuntimeException("CharSequence cannot be written to an OutputStream");
  }
  
  protected CharSequence b() {
    return null;
  }
  
  public void closeField() {
    FieldBuffer fieldBuffer = this.k;
    if (fieldBuffer != null)
      try {
        if (fieldBuffer.a.size() != 0)
          this.k.a(); 
        this.k = null;
        return;
      } catch (IOException iOException) {
        throw new VersionedParcel.ParcelException(iOException);
      }  
  }
  
  public boolean isStream() {
    return true;
  }
  
  public boolean readBoolean() {
    try {
      return this.i.readBoolean();
    } catch (IOException iOException) {
      throw new VersionedParcel.ParcelException(iOException);
    } 
  }
  
  public Bundle readBundle() {
    int j = readInt();
    if (j < 0)
      return null; 
    Bundle bundle = new Bundle();
    for (int i = 0; i < j; i++) {
      String str = readString();
      a(readInt(), str, bundle);
    } 
    return bundle;
  }
  
  public byte[] readByteArray() {
    try {
      int i = this.i.readInt();
      if (i > 0) {
        byte[] arrayOfByte = new byte[i];
        this.i.readFully(arrayOfByte);
        return arrayOfByte;
      } 
      return null;
    } catch (IOException iOException) {
      throw new VersionedParcel.ParcelException(iOException);
    } 
  }
  
  public double readDouble() {
    try {
      return this.i.readDouble();
    } catch (IOException iOException) {
      throw new VersionedParcel.ParcelException(iOException);
    } 
  }
  
  public boolean readField(int paramInt) {
    try {
      while (true) {
        if (this.m == paramInt)
          return true; 
        if (String.valueOf(this.m).compareTo(String.valueOf(paramInt)) > 0)
          return false; 
        if (this.d < this.e)
          this.g.skip((this.e - this.d)); 
        this.e = -1;
        int k = this.g.readInt();
        this.d = 0;
        int j = k & 0xFFFF;
        int i = j;
        if (j == 65535)
          i = this.g.readInt(); 
        this.m = k >> 16 & 0xFFFF;
        this.e = i;
      } 
    } catch (IOException iOException) {
      return false;
    } 
  }
  
  public float readFloat() {
    try {
      return this.i.readFloat();
    } catch (IOException iOException) {
      throw new VersionedParcel.ParcelException(iOException);
    } 
  }
  
  public int readInt() {
    try {
      return this.i.readInt();
    } catch (IOException iOException) {
      throw new VersionedParcel.ParcelException(iOException);
    } 
  }
  
  public long readLong() {
    try {
      return this.i.readLong();
    } catch (IOException iOException) {
      throw new VersionedParcel.ParcelException(iOException);
    } 
  }
  
  public <T extends Parcelable> T readParcelable() {
    return null;
  }
  
  public String readString() {
    try {
      int i = this.i.readInt();
      if (i > 0) {
        byte[] arrayOfByte = new byte[i];
        this.i.readFully(arrayOfByte);
        return new String(arrayOfByte, f);
      } 
      return null;
    } catch (IOException iOException) {
      throw new VersionedParcel.ParcelException(iOException);
    } 
  }
  
  public IBinder readStrongBinder() {
    return null;
  }
  
  public void setOutputField(int paramInt) {
    closeField();
    this.k = new FieldBuffer(paramInt, this.h);
    this.j = this.k.b;
  }
  
  public void setSerializationFlags(boolean paramBoolean1, boolean paramBoolean2) {
    if (paramBoolean1) {
      this.l = paramBoolean2;
      return;
    } 
    throw new RuntimeException("Serialization of this object is not allowed");
  }
  
  public void writeBoolean(boolean paramBoolean) {
    try {
      this.j.writeBoolean(paramBoolean);
      return;
    } catch (IOException iOException) {
      throw new VersionedParcel.ParcelException(iOException);
    } 
  }
  
  public void writeBundle(Bundle paramBundle) {
    if (paramBundle != null)
      try {
        Set set = paramBundle.keySet();
        this.j.writeInt(set.size());
        for (String str : set) {
          writeString(str);
          a(paramBundle.get(str));
        } 
        return;
      } catch (IOException iOException) {
        throw new VersionedParcel.ParcelException(iOException);
      }  
    this.j.writeInt(-1);
  }
  
  public void writeByteArray(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null)
      try {
        this.j.writeInt(paramArrayOfbyte.length);
        this.j.write(paramArrayOfbyte);
        return;
      } catch (IOException iOException) {
        throw new VersionedParcel.ParcelException(iOException);
      }  
    this.j.writeInt(-1);
  }
  
  public void writeByteArray(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null)
      try {
        this.j.writeInt(paramInt2);
        this.j.write(paramArrayOfbyte, paramInt1, paramInt2);
        return;
      } catch (IOException iOException) {
        throw new VersionedParcel.ParcelException(iOException);
      }  
    this.j.writeInt(-1);
  }
  
  public void writeDouble(double paramDouble) {
    try {
      this.j.writeDouble(paramDouble);
      return;
    } catch (IOException iOException) {
      throw new VersionedParcel.ParcelException(iOException);
    } 
  }
  
  public void writeFloat(float paramFloat) {
    try {
      this.j.writeFloat(paramFloat);
      return;
    } catch (IOException iOException) {
      throw new VersionedParcel.ParcelException(iOException);
    } 
  }
  
  public void writeInt(int paramInt) {
    try {
      this.j.writeInt(paramInt);
      return;
    } catch (IOException iOException) {
      throw new VersionedParcel.ParcelException(iOException);
    } 
  }
  
  public void writeLong(long paramLong) {
    try {
      this.j.writeLong(paramLong);
      return;
    } catch (IOException iOException) {
      throw new VersionedParcel.ParcelException(iOException);
    } 
  }
  
  public void writeParcelable(Parcelable paramParcelable) {
    if (this.l)
      return; 
    throw new RuntimeException("Parcelables cannot be written to an OutputStream");
  }
  
  public void writeString(String paramString) {
    if (paramString != null)
      try {
        byte[] arrayOfByte = paramString.getBytes(f);
        this.j.writeInt(arrayOfByte.length);
        this.j.write(arrayOfByte);
        return;
      } catch (IOException iOException) {
        throw new VersionedParcel.ParcelException(iOException);
      }  
    this.j.writeInt(-1);
  }
  
  public void writeStrongBinder(IBinder paramIBinder) {
    if (this.l)
      return; 
    throw new RuntimeException("Binders cannot be written to an OutputStream");
  }
  
  public void writeStrongInterface(IInterface paramIInterface) {
    if (this.l)
      return; 
    throw new RuntimeException("Binders cannot be written to an OutputStream");
  }
  
  static class FieldBuffer {
    final ByteArrayOutputStream a = new ByteArrayOutputStream();
    
    final DataOutputStream b = new DataOutputStream(this.a);
    
    private final int c;
    
    private final DataOutputStream d;
    
    FieldBuffer(int param1Int, DataOutputStream param1DataOutputStream) {
      this.c = param1Int;
      this.d = param1DataOutputStream;
    }
    
    void a() throws IOException {
      int i;
      this.b.flush();
      int j = this.a.size();
      int k = this.c;
      if (j >= 65535) {
        i = 65535;
      } else {
        i = j;
      } 
      this.d.writeInt(k << 16 | i);
      if (j >= 65535)
        this.d.writeInt(j); 
      this.a.writeTo(this.d);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\versionedparcelable\VersionedParcelStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */