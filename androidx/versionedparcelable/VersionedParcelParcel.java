package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

class VersionedParcelParcel extends VersionedParcel {
  private final SparseIntArray d = new SparseIntArray();
  
  private final Parcel e;
  
  private final int f;
  
  private final int g;
  
  private final String h;
  
  private int i = -1;
  
  private int j = 0;
  
  private int k = -1;
  
  VersionedParcelParcel(Parcel paramParcel) {
    this(paramParcel, paramParcel.dataPosition(), paramParcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
  }
  
  private VersionedParcelParcel(Parcel paramParcel, int paramInt1, int paramInt2, String paramString, ArrayMap<String, Method> paramArrayMap1, ArrayMap<String, Method> paramArrayMap2, ArrayMap<String, Class> paramArrayMap) {
    super(paramArrayMap1, paramArrayMap2, paramArrayMap);
    this.e = paramParcel;
    this.f = paramInt1;
    this.g = paramInt2;
    this.j = this.f;
    this.h = paramString;
  }
  
  protected VersionedParcel a() {
    Parcel parcel = this.e;
    int k = parcel.dataPosition();
    int j = this.j;
    int i = j;
    if (j == this.f)
      i = this.g; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.h);
    stringBuilder.append("  ");
    return new VersionedParcelParcel(parcel, k, i, stringBuilder.toString(), this.a, this.b, this.c);
  }
  
  protected void a(CharSequence paramCharSequence) {
    TextUtils.writeToParcel(paramCharSequence, this.e, 0);
  }
  
  protected CharSequence b() {
    return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
  }
  
  public void closeField() {
    int i = this.i;
    if (i >= 0) {
      i = this.d.get(i);
      int j = this.e.dataPosition();
      this.e.setDataPosition(i);
      this.e.writeInt(j - i);
      this.e.setDataPosition(j);
    } 
  }
  
  public boolean readBoolean() {
    return (this.e.readInt() != 0);
  }
  
  public Bundle readBundle() {
    return this.e.readBundle(getClass().getClassLoader());
  }
  
  public byte[] readByteArray() {
    int i = this.e.readInt();
    if (i < 0)
      return null; 
    byte[] arrayOfByte = new byte[i];
    this.e.readByteArray(arrayOfByte);
    return arrayOfByte;
  }
  
  public double readDouble() {
    return this.e.readDouble();
  }
  
  public boolean readField(int paramInt) {
    while (this.j < this.g) {
      int i = this.k;
      if (i == paramInt)
        return true; 
      if (String.valueOf(i).compareTo(String.valueOf(paramInt)) > 0)
        return false; 
      this.e.setDataPosition(this.j);
      i = this.e.readInt();
      this.k = this.e.readInt();
      this.j += i;
    } 
    return (this.k == paramInt);
  }
  
  public float readFloat() {
    return this.e.readFloat();
  }
  
  public int readInt() {
    return this.e.readInt();
  }
  
  public long readLong() {
    return this.e.readLong();
  }
  
  public <T extends Parcelable> T readParcelable() {
    return (T)this.e.readParcelable(getClass().getClassLoader());
  }
  
  public String readString() {
    return this.e.readString();
  }
  
  public IBinder readStrongBinder() {
    return this.e.readStrongBinder();
  }
  
  public void setOutputField(int paramInt) {
    closeField();
    this.i = paramInt;
    this.d.put(paramInt, this.e.dataPosition());
    writeInt(0);
    writeInt(paramInt);
  }
  
  public void writeBoolean(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void writeBundle(Bundle paramBundle) {
    this.e.writeBundle(paramBundle);
  }
  
  public void writeByteArray(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null) {
      this.e.writeInt(paramArrayOfbyte.length);
      this.e.writeByteArray(paramArrayOfbyte);
      return;
    } 
    this.e.writeInt(-1);
  }
  
  public void writeByteArray(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null) {
      this.e.writeInt(paramArrayOfbyte.length);
      this.e.writeByteArray(paramArrayOfbyte, paramInt1, paramInt2);
      return;
    } 
    this.e.writeInt(-1);
  }
  
  public void writeDouble(double paramDouble) {
    this.e.writeDouble(paramDouble);
  }
  
  public void writeFloat(float paramFloat) {
    this.e.writeFloat(paramFloat);
  }
  
  public void writeInt(int paramInt) {
    this.e.writeInt(paramInt);
  }
  
  public void writeLong(long paramLong) {
    this.e.writeLong(paramLong);
  }
  
  public void writeParcelable(Parcelable paramParcelable) {
    this.e.writeParcelable(paramParcelable, 0);
  }
  
  public void writeString(String paramString) {
    this.e.writeString(paramString);
  }
  
  public void writeStrongBinder(IBinder paramIBinder) {
    this.e.writeStrongBinder(paramIBinder);
  }
  
  public void writeStrongInterface(IInterface paramIInterface) {
    this.e.writeStrongInterface(paramIInterface);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\versionedparcelable\VersionedParcelParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */