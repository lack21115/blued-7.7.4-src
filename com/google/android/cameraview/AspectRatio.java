package com.google.android.cameraview;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SparseArrayCompat;

public class AspectRatio implements Parcelable, Comparable<AspectRatio> {
  public static final Parcelable.Creator<AspectRatio> CREATOR;
  
  private static final SparseArrayCompat<SparseArrayCompat<AspectRatio>> a = new SparseArrayCompat(16);
  
  private final int b;
  
  private final int c;
  
  static {
    CREATOR = new Parcelable.Creator<AspectRatio>() {
        public AspectRatio a(Parcel param1Parcel) {
          return AspectRatio.a(param1Parcel.readInt(), param1Parcel.readInt());
        }
        
        public AspectRatio[] a(int param1Int) {
          return new AspectRatio[param1Int];
        }
      };
  }
  
  private AspectRatio(int paramInt1, int paramInt2) {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public static AspectRatio a(int paramInt1, int paramInt2) {
    int i = b(paramInt1, paramInt2);
    paramInt1 /= i;
    paramInt2 /= i;
    SparseArrayCompat sparseArrayCompat = (SparseArrayCompat)a.get(paramInt1);
    if (sparseArrayCompat == null) {
      AspectRatio aspectRatio = new AspectRatio(paramInt1, paramInt2);
      SparseArrayCompat sparseArrayCompat1 = new SparseArrayCompat();
      sparseArrayCompat1.put(paramInt2, aspectRatio);
      a.put(paramInt1, sparseArrayCompat1);
      return aspectRatio;
    } 
    AspectRatio aspectRatio2 = (AspectRatio)sparseArrayCompat.get(paramInt2);
    AspectRatio aspectRatio1 = aspectRatio2;
    if (aspectRatio2 == null) {
      aspectRatio1 = new AspectRatio(paramInt1, paramInt2);
      sparseArrayCompat.put(paramInt2, aspectRatio1);
    } 
    return aspectRatio1;
  }
  
  public static AspectRatio a(String paramString) {
    int i = paramString.indexOf(':');
    if (i != -1)
      try {
        return a(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
      } catch (NumberFormatException numberFormatException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Malformed aspect ratio: ");
        stringBuilder1.append(paramString);
        throw new IllegalArgumentException(stringBuilder1.toString(), numberFormatException);
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Malformed aspect ratio: ");
    stringBuilder.append(paramString);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static int b(int paramInt1, int paramInt2) {
    while (true) {
      int i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt1 != 0) {
        paramInt2 = i % paramInt1;
        continue;
      } 
      return i;
    } 
  }
  
  public int a() {
    return this.b;
  }
  
  public int a(AspectRatio paramAspectRatio) {
    return equals(paramAspectRatio) ? 0 : ((c() - paramAspectRatio.c() > 0.0F) ? 1 : -1);
  }
  
  public boolean a(Size paramSize) {
    int j = b(paramSize.a(), paramSize.b());
    int i = paramSize.a() / j;
    j = paramSize.b() / j;
    return (this.b == i && this.c == j);
  }
  
  public int b() {
    return this.c;
  }
  
  public float c() {
    return this.b / this.c;
  }
  
  public AspectRatio d() {
    return a(this.c, this.b);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool2 = false;
    if (paramObject == null)
      return false; 
    if (this == paramObject)
      return true; 
    boolean bool1 = bool2;
    if (paramObject instanceof AspectRatio) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.b == ((AspectRatio)paramObject).b) {
        bool1 = bool2;
        if (this.c == ((AspectRatio)paramObject).c)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    int i = this.c;
    int j = this.b;
    return i ^ (j >>> 16 | j << 16);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append(":");
    stringBuilder.append(this.c);
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\cameraview\AspectRatio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */