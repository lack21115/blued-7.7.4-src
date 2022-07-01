package com.huawei.hms.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

public class SafeIntent extends Intent {
  private static final String a = SafeIntent.class.getSimpleName();
  
  public SafeIntent(Intent paramIntent) {
    super(intent);
  }
  
  public String getAction() {
    try {
      return super.getAction();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String getActionReturnNotNull() {
    try {
      String str = super.getAction();
      return (str == null) ? "" : str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public boolean[] getBooleanArrayExtra(String paramString) {
    try {
      return super.getBooleanArrayExtra(paramString);
    } catch (Exception exception) {
      return new boolean[0];
    } 
  }
  
  public boolean[] getBooleanArrayExtraReturnNotNull(String paramString) {
    try {
      boolean[] arrayOfBoolean2 = super.getBooleanArrayExtra(paramString);
      boolean[] arrayOfBoolean1 = arrayOfBoolean2;
      if (arrayOfBoolean2 == null)
        arrayOfBoolean1 = new boolean[0]; 
      return arrayOfBoolean1;
    } catch (Exception exception) {
      return new boolean[0];
    } 
  }
  
  public boolean getBooleanExtra(String paramString, boolean paramBoolean) {
    try {
      return super.getBooleanExtra(paramString, paramBoolean);
    } catch (Exception exception) {
      return paramBoolean;
    } 
  }
  
  public Bundle getBundleExtra(String paramString) {
    try {
      return super.getBundleExtra(paramString);
    } catch (Exception exception) {
      return new Bundle();
    } 
  }
  
  public Bundle getBundleExtraReturnNotNull(String paramString) {
    try {
      Bundle bundle2 = super.getBundleExtra(paramString);
      Bundle bundle1 = bundle2;
      if (bundle2 == null)
        bundle1 = new Bundle(); 
      return bundle1;
    } catch (Exception exception) {
      return new Bundle();
    } 
  }
  
  public byte[] getByteArrayExtra(String paramString) {
    try {
      return super.getByteArrayExtra(paramString);
    } catch (Exception exception) {
      return new byte[0];
    } 
  }
  
  public byte[] getByteArrayExtraReturnNotNull(String paramString) {
    try {
      byte[] arrayOfByte2 = super.getByteArrayExtra(paramString);
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
        arrayOfByte1 = new byte[0]; 
      return arrayOfByte1;
    } catch (Exception exception) {
      return new byte[0];
    } 
  }
  
  public byte getByteExtra(String paramString, byte paramByte) {
    try {
      return super.getByteExtra(paramString, paramByte);
    } catch (Exception exception) {
      return paramByte;
    } 
  }
  
  public char[] getCharArrayExtra(String paramString) {
    try {
      return super.getCharArrayExtra(paramString);
    } catch (Exception exception) {
      return new char[0];
    } 
  }
  
  public char[] getCharArrayExtraReturnNotNull(String paramString) {
    try {
      char[] arrayOfChar2 = super.getCharArrayExtra(paramString);
      char[] arrayOfChar1 = arrayOfChar2;
      if (arrayOfChar2 == null)
        arrayOfChar1 = new char[0]; 
      return arrayOfChar1;
    } catch (Exception exception) {
      return new char[0];
    } 
  }
  
  public char getCharExtra(String paramString, char paramChar) {
    try {
      return super.getCharExtra(paramString, paramChar);
    } catch (Exception exception) {
      return paramChar;
    } 
  }
  
  public CharSequence[] getCharSequenceArrayExtra(String paramString) {
    try {
      return super.getCharSequenceArrayExtra(paramString);
    } catch (Exception exception) {
      return new CharSequence[0];
    } 
  }
  
  public CharSequence[] getCharSequenceArrayExtraReturnNotNull(String paramString) {
    try {
      CharSequence[] arrayOfCharSequence2 = super.getCharSequenceArrayExtra(paramString);
      CharSequence[] arrayOfCharSequence1 = arrayOfCharSequence2;
      if (arrayOfCharSequence2 == null)
        arrayOfCharSequence1 = new CharSequence[0]; 
      return arrayOfCharSequence1;
    } catch (Exception exception) {
      return new CharSequence[0];
    } 
  }
  
  public ArrayList<CharSequence> getCharSequenceArrayListExtra(String paramString) {
    try {
      return super.getCharSequenceArrayListExtra(paramString);
    } catch (Exception exception) {
      return new ArrayList<CharSequence>();
    } 
  }
  
  public ArrayList<CharSequence> getCharSequenceArrayListExtraReturnNotNull(String paramString) {
    try {
      ArrayList<CharSequence> arrayList2 = super.getCharSequenceArrayListExtra(paramString);
      ArrayList<CharSequence> arrayList1 = arrayList2;
      if (arrayList2 == null)
        arrayList1 = new ArrayList(); 
      return arrayList1;
    } catch (Exception exception) {
      return new ArrayList<CharSequence>();
    } 
  }
  
  public CharSequence getCharSequenceExtra(String paramString) {
    try {
      return super.getCharSequenceExtra(paramString);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public CharSequence getCharSequenceExtraReturnNotNull(String paramString) {
    try {
      CharSequence charSequence = super.getCharSequenceExtra(paramString);
      return (charSequence == null) ? "" : charSequence;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public double[] getDoubleArrayExtra(String paramString) {
    try {
      return super.getDoubleArrayExtra(paramString);
    } catch (Exception exception) {
      return new double[0];
    } 
  }
  
  public double[] getDoubleArrayExtraReturnNotNull(String paramString) {
    try {
      double[] arrayOfDouble2 = super.getDoubleArrayExtra(paramString);
      double[] arrayOfDouble1 = arrayOfDouble2;
      if (arrayOfDouble2 == null)
        arrayOfDouble1 = new double[0]; 
      return arrayOfDouble1;
    } catch (Exception exception) {
      return new double[0];
    } 
  }
  
  public double getDoubleExtra(String paramString, double paramDouble) {
    try {
      return super.getDoubleExtra(paramString, paramDouble);
    } catch (Exception exception) {
      return paramDouble;
    } 
  }
  
  public Bundle getExtras() {
    try {
      return super.getExtras();
    } catch (Exception exception) {
      return new Bundle();
    } 
  }
  
  public Bundle getExtrasReturnNotNull() {
    try {
      Bundle bundle2 = super.getExtras();
      Bundle bundle1 = bundle2;
      if (bundle2 == null)
        bundle1 = new Bundle(); 
      return bundle1;
    } catch (Exception exception) {
      return new Bundle();
    } 
  }
  
  public float[] getFloatArrayExtra(String paramString) {
    try {
      return super.getFloatArrayExtra(paramString);
    } catch (Exception exception) {
      return new float[0];
    } 
  }
  
  public float[] getFloatArrayExtraReturnNotNull(String paramString) {
    try {
      float[] arrayOfFloat2 = super.getFloatArrayExtra(paramString);
      float[] arrayOfFloat1 = arrayOfFloat2;
      if (arrayOfFloat2 == null)
        arrayOfFloat1 = new float[0]; 
      return arrayOfFloat1;
    } catch (Exception exception) {
      return new float[0];
    } 
  }
  
  public float getFloatExtra(String paramString, float paramFloat) {
    try {
      return super.getFloatExtra(paramString, paramFloat);
    } catch (Exception exception) {
      return paramFloat;
    } 
  }
  
  public int[] getIntArrayExtra(String paramString) {
    try {
      return super.getIntArrayExtra(paramString);
    } catch (Exception exception) {
      return new int[0];
    } 
  }
  
  public int[] getIntArrayExtraReturnNotNull(String paramString) {
    try {
      int[] arrayOfInt2 = super.getIntArrayExtra(paramString);
      int[] arrayOfInt1 = arrayOfInt2;
      if (arrayOfInt2 == null)
        arrayOfInt1 = new int[0]; 
      return arrayOfInt1;
    } catch (Exception exception) {
      return new int[0];
    } 
  }
  
  public int getIntExtra(String paramString, int paramInt) {
    try {
      return super.getIntExtra(paramString, paramInt);
    } catch (Exception exception) {
      return paramInt;
    } 
  }
  
  public ArrayList<Integer> getIntegerArrayListExtra(String paramString) {
    try {
      return super.getIntegerArrayListExtra(paramString);
    } catch (Exception exception) {
      return new ArrayList<Integer>();
    } 
  }
  
  public ArrayList<Integer> getIntegerArrayListExtraReturnNotNull(String paramString) {
    try {
      ArrayList<Integer> arrayList2 = super.getIntegerArrayListExtra(paramString);
      ArrayList<Integer> arrayList1 = arrayList2;
      if (arrayList2 == null)
        arrayList1 = new ArrayList(); 
      return arrayList1;
    } catch (Exception exception) {
      return new ArrayList<Integer>();
    } 
  }
  
  public long[] getLongArrayExtra(String paramString) {
    try {
      return super.getLongArrayExtra(paramString);
    } catch (Exception exception) {
      return new long[0];
    } 
  }
  
  public long[] getLongArrayExtraReturnNotNull(String paramString) {
    try {
      long[] arrayOfLong2 = super.getLongArrayExtra(paramString);
      long[] arrayOfLong1 = arrayOfLong2;
      if (arrayOfLong2 == null)
        arrayOfLong1 = new long[0]; 
      return arrayOfLong1;
    } catch (Exception exception) {
      return new long[0];
    } 
  }
  
  public long getLongExtra(String paramString, long paramLong) {
    try {
      return super.getLongExtra(paramString, paramLong);
    } catch (Exception exception) {
      return paramLong;
    } 
  }
  
  public Parcelable[] getParcelableArrayExtra(String paramString) {
    try {
      return super.getParcelableArrayExtra(paramString);
    } catch (Exception exception) {
      return new Parcelable[0];
    } 
  }
  
  public Parcelable[] getParcelableArrayExtraReturnNotNull(String paramString) {
    try {
      Parcelable[] arrayOfParcelable2 = super.getParcelableArrayExtra(paramString);
      Parcelable[] arrayOfParcelable1 = arrayOfParcelable2;
      if (arrayOfParcelable2 == null)
        arrayOfParcelable1 = new Parcelable[0]; 
      return arrayOfParcelable1;
    } catch (Exception exception) {
      return new Parcelable[0];
    } 
  }
  
  public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String paramString) {
    try {
      return super.getParcelableArrayListExtra(paramString);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public <T extends Parcelable> T getParcelableExtra(String paramString) {
    try {
      return (T)super.getParcelableExtra(paramString);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public Serializable getSerializableExtra(String paramString) {
    try {
      return super.getSerializableExtra(paramString);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public short[] getShortArrayExtra(String paramString) {
    try {
      return super.getShortArrayExtra(paramString);
    } catch (Exception exception) {
      return new short[0];
    } 
  }
  
  public short[] getShortArrayExtraReturnNotNull(String paramString) {
    try {
      short[] arrayOfShort2 = super.getShortArrayExtra(paramString);
      short[] arrayOfShort1 = arrayOfShort2;
      if (arrayOfShort2 == null)
        arrayOfShort1 = new short[0]; 
      return arrayOfShort1;
    } catch (Exception exception) {
      return new short[0];
    } 
  }
  
  public short getShortExtra(String paramString, short paramShort) {
    try {
      return super.getShortExtra(paramString, paramShort);
    } catch (Exception exception) {
      return paramShort;
    } 
  }
  
  public String[] getStringArrayExtra(String paramString) {
    try {
      return super.getStringArrayExtra(paramString);
    } catch (Exception exception) {
      return new String[0];
    } 
  }
  
  public String[] getStringArrayExtraReturnNotNull(String paramString) {
    try {
      String[] arrayOfString2 = super.getStringArrayExtra(paramString);
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null)
        arrayOfString1 = new String[0]; 
      return arrayOfString1;
    } catch (Exception exception) {
      return new String[0];
    } 
  }
  
  public ArrayList<String> getStringArrayListExtra(String paramString) {
    try {
      return super.getStringArrayListExtra(paramString);
    } catch (Exception exception) {
      return new ArrayList<String>();
    } 
  }
  
  public ArrayList<String> getStringArrayListExtraReturnNotNull(String paramString) {
    try {
      ArrayList<String> arrayList2 = super.getStringArrayListExtra(paramString);
      ArrayList<String> arrayList1 = arrayList2;
      if (arrayList2 == null)
        arrayList1 = new ArrayList(); 
      return arrayList1;
    } catch (Exception exception) {
      return new ArrayList<String>();
    } 
  }
  
  public String getStringExtra(String paramString) {
    try {
      return super.getStringExtra(paramString);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String getStringExtraReturnNotNull(String paramString) {
    try {
      paramString = super.getStringExtra(paramString);
      return (paramString == null) ? "" : paramString;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public boolean hasExtra(String paramString) {
    try {
      return super.hasExtra(paramString);
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\ui\SafeIntent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */