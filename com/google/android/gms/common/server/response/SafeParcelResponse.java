package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
  public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zap();
  
  private final int zaa;
  
  private final Parcel zab;
  
  private final int zac;
  
  private final zal zad;
  
  private final String zae;
  
  private int zaf;
  
  private int zag;
  
  SafeParcelResponse(int paramInt, Parcel paramParcel, zal paramzal) {
    this.zaa = paramInt;
    this.zab = (Parcel)Preconditions.checkNotNull(paramParcel);
    this.zac = 2;
    this.zad = paramzal;
    zal zal1 = this.zad;
    if (zal1 == null) {
      this.zae = null;
    } else {
      this.zae = zal1.zac();
    } 
    this.zaf = 2;
  }
  
  private SafeParcelResponse(SafeParcelable paramSafeParcelable, zal paramzal, String paramString) {
    this.zaa = 1;
    this.zab = Parcel.obtain();
    paramSafeParcelable.writeToParcel(this.zab, 0);
    this.zac = 1;
    this.zad = (zal)Preconditions.checkNotNull(paramzal);
    this.zae = (String)Preconditions.checkNotNull(paramString);
    this.zaf = 2;
  }
  
  public SafeParcelResponse(zal paramzal, String paramString) {
    this.zaa = 1;
    this.zab = Parcel.obtain();
    this.zac = 0;
    this.zad = (zal)Preconditions.checkNotNull(paramzal);
    this.zae = (String)Preconditions.checkNotNull(paramString);
    this.zaf = 0;
  }
  
  public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T paramT) {
    String str = (String)Preconditions.checkNotNull(paramT.getClass().getCanonicalName());
    zal zal1 = new zal((Class)paramT.getClass());
    zaa(zal1, (FastJsonResponse)paramT);
    zal1.zab();
    zal1.zaa();
    return new SafeParcelResponse((SafeParcelable)paramT, zal1, str);
  }
  
  private final Parcel zaa() {
    int i = this.zaf;
    if (i != 0) {
      if (i != 1)
        return this.zab; 
    } else {
      this.zag = SafeParcelWriter.beginObjectHeader(this.zab);
    } 
    SafeParcelWriter.finishObjectHeader(this.zab, this.zag);
    this.zaf = 2;
    return this.zab;
  }
  
  private final void zaa(FastJsonResponse.Field<?, ?> paramField) {
    int i;
    if (paramField.zaf != -1) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      Parcel parcel = this.zab;
      if (parcel != null) {
        i = this.zaf;
        if (i != 0) {
          if (i != 1) {
            if (i != 2)
              throw new IllegalStateException("Unknown parse state in SafeParcelResponse."); 
            throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
          } 
          return;
        } 
        this.zag = SafeParcelWriter.beginObjectHeader(parcel);
        this.zaf = 1;
        return;
      } 
      throw new IllegalStateException("Internal Parcel object is null.");
    } 
    throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
  }
  
  private static void zaa(zal paramzal, FastJsonResponse paramFastJsonResponse) {
    Class<?> clazz = paramFastJsonResponse.getClass();
    if (!paramzal.zaa((Class)clazz)) {
      Map<String, FastJsonResponse.Field<?, ?>> map = paramFastJsonResponse.getFieldMappings();
      paramzal.zaa((Class)clazz, map);
      Iterator<String> iterator = map.keySet().iterator();
      while (iterator.hasNext()) {
        FastJsonResponse.Field field = map.get(iterator.next());
        Class<? extends FastJsonResponse> clazz1 = field.zag;
        if (clazz1 != null)
          try {
            zaa(paramzal, clazz1.newInstance());
          } catch (InstantiationException instantiationException) {
            String str = String.valueOf(((Class)Preconditions.checkNotNull(field.zag)).getCanonicalName());
            if (str.length() != 0) {
              str = "Could not instantiate an object of type ".concat(str);
            } else {
              str = new String("Could not instantiate an object of type ");
            } 
            throw new IllegalStateException(str, instantiationException);
          } catch (IllegalAccessException illegalAccessException) {
            String str = String.valueOf(((Class)Preconditions.checkNotNull(field.zag)).getCanonicalName());
            if (str.length() != 0) {
              str = "Could not access object of type ".concat(str);
            } else {
              str = new String("Could not access object of type ");
            } 
            throw new IllegalStateException(str, illegalAccessException);
          }  
      } 
    } 
  }
  
  private static void zaa(StringBuilder paramStringBuilder, int paramInt, Object paramObject) {
    switch (paramInt) {
      default:
        paramStringBuilder = new StringBuilder(26);
        paramStringBuilder.append("Unknown type = ");
        paramStringBuilder.append(paramInt);
        throw new IllegalArgumentException(paramStringBuilder.toString());
      case 11:
        throw new IllegalArgumentException("Method does not accept concrete type.");
      case 10:
        MapUtils.writeStringMapToJson(paramStringBuilder, (HashMap)Preconditions.checkNotNull(paramObject));
        return;
      case 9:
        paramStringBuilder.append("\"");
        paramStringBuilder.append(Base64Utils.encodeUrlSafe((byte[])paramObject));
        paramStringBuilder.append("\"");
        return;
      case 8:
        paramStringBuilder.append("\"");
        paramStringBuilder.append(Base64Utils.encode((byte[])paramObject));
        paramStringBuilder.append("\"");
        return;
      case 7:
        paramStringBuilder.append("\"");
        paramStringBuilder.append(JsonUtils.escapeString(Preconditions.checkNotNull(paramObject).toString()));
        paramStringBuilder.append("\"");
        return;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
        break;
    } 
    paramStringBuilder.append(paramObject);
  }
  
  private final void zaa(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Object paramObject) {
    if (paramField.zab) {
      paramObject = paramObject;
      paramStringBuilder.append("[");
      int j = paramObject.size();
      int i;
      for (i = 0; i < j; i++) {
        if (i != 0)
          paramStringBuilder.append(","); 
        zaa(paramStringBuilder, paramField.zaa, paramObject.get(i));
      } 
      paramStringBuilder.append("]");
      return;
    } 
    zaa(paramStringBuilder, paramField.zaa, paramObject);
  }
  
  private final void zaa(StringBuilder paramStringBuilder, Map<String, FastJsonResponse.Field<?, ?>> paramMap, Parcel paramParcel) {
    SparseArray sparseArray = new SparseArray();
    for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : paramMap.entrySet())
      sparseArray.put(((FastJsonResponse.Field)entry.getValue()).getSafeParcelableFieldId(), entry); 
    paramStringBuilder.append('{');
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j) {
      int k = SafeParcelReader.readHeader(paramParcel);
      Map.Entry entry = (Map.Entry)sparseArray.get(SafeParcelReader.getFieldId(k));
      if (entry != null) {
        if (i)
          paramStringBuilder.append(","); 
        String str = (String)entry.getKey();
        FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field)entry.getValue();
        paramStringBuilder.append("\"");
        paramStringBuilder.append(str);
        paramStringBuilder.append("\":");
        if (field.zab()) {
          Bundle bundle;
          HashMap<Object, Object> hashMap;
          switch (field.zac) {
            default:
              i = field.zac;
              paramStringBuilder = new StringBuilder(36);
              paramStringBuilder.append("Unknown field out type = ");
              paramStringBuilder.append(i);
              throw new IllegalArgumentException(paramStringBuilder.toString());
            case 11:
              throw new IllegalArgumentException("Method does not accept concrete type.");
            case 10:
              bundle = SafeParcelReader.createBundle(paramParcel, k);
              hashMap = new HashMap<Object, Object>();
              for (String str1 : bundle.keySet())
                hashMap.put(str1, Preconditions.checkNotNull(bundle.getString(str1))); 
              zaa(paramStringBuilder, field, zaa(field, hashMap));
              break;
            case 8:
            case 9:
              zaa(paramStringBuilder, field, zaa(field, SafeParcelReader.createByteArray(paramParcel, k)));
              break;
            case 7:
              zaa(paramStringBuilder, field, zaa(field, SafeParcelReader.createString(paramParcel, k)));
              break;
            case 6:
              zaa(paramStringBuilder, field, zaa(field, Boolean.valueOf(SafeParcelReader.readBoolean(paramParcel, k))));
              break;
            case 5:
              zaa(paramStringBuilder, field, zaa(field, SafeParcelReader.createBigDecimal(paramParcel, k)));
              break;
            case 4:
              zaa(paramStringBuilder, field, zaa(field, Double.valueOf(SafeParcelReader.readDouble(paramParcel, k))));
              break;
            case 3:
              zaa(paramStringBuilder, field, zaa(field, Float.valueOf(SafeParcelReader.readFloat(paramParcel, k))));
              break;
            case 2:
              zaa(paramStringBuilder, field, zaa(field, Long.valueOf(SafeParcelReader.readLong(paramParcel, k))));
              break;
            case 1:
              zaa(paramStringBuilder, field, zaa(field, SafeParcelReader.createBigInteger(paramParcel, k)));
              break;
            case 0:
              zaa(paramStringBuilder, field, zaa(field, Integer.valueOf(SafeParcelReader.readInt(paramParcel, k))));
              break;
          } 
        } else if (field.zad) {
          Parcel[] arrayOfParcel;
          paramStringBuilder.append("[");
          switch (field.zac) {
            default:
              throw new IllegalStateException("Unknown field type out.");
            case 11:
              arrayOfParcel = SafeParcelReader.createParcelArray(paramParcel, k);
              k = arrayOfParcel.length;
              for (i = 0; i < k; i++) {
                if (i > 0)
                  paramStringBuilder.append(","); 
                arrayOfParcel[i].setDataPosition(0);
                zaa(paramStringBuilder, field.zad(), arrayOfParcel[i]);
              } 
              break;
            case 8:
            case 9:
            case 10:
              throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
            case 7:
              ArrayUtils.writeStringArray(paramStringBuilder, SafeParcelReader.createStringArray(paramParcel, k));
              break;
            case 6:
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBooleanArray(paramParcel, k));
              break;
            case 5:
              ArrayUtils.writeArray(paramStringBuilder, (Object[])SafeParcelReader.createBigDecimalArray(paramParcel, k));
              break;
            case 4:
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createDoubleArray(paramParcel, k));
              break;
            case 3:
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createFloatArray(paramParcel, k));
              break;
            case 2:
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createLongArray(paramParcel, k));
              break;
            case 1:
              ArrayUtils.writeArray(paramStringBuilder, (Object[])SafeParcelReader.createBigIntegerArray(paramParcel, k));
              break;
            case 0:
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createIntArray(paramParcel, k));
              break;
          } 
          paramStringBuilder.append("]");
        } else {
          Bundle bundle;
          byte[] arrayOfByte;
          String str1;
          Parcel parcel;
          Set set;
          Iterator<String> iterator;
          switch (field.zac) {
            default:
              throw new IllegalStateException("Unknown field type out");
            case 11:
              parcel = SafeParcelReader.createParcel(paramParcel, k);
              parcel.setDataPosition(0);
              zaa(paramStringBuilder, field.zad(), parcel);
              break;
            case 10:
              bundle = SafeParcelReader.createBundle(paramParcel, k);
              set = bundle.keySet();
              paramStringBuilder.append("{");
              iterator = set.iterator();
              for (i = 1; iterator.hasNext(); i = 0) {
                String str2 = iterator.next();
                if (i == 0)
                  paramStringBuilder.append(","); 
                paramStringBuilder.append("\"");
                paramStringBuilder.append(str2);
                paramStringBuilder.append("\"");
                paramStringBuilder.append(":");
                paramStringBuilder.append("\"");
                paramStringBuilder.append(JsonUtils.escapeString(bundle.getString(str2)));
                paramStringBuilder.append("\"");
              } 
              paramStringBuilder.append("}");
              break;
            case 9:
              arrayOfByte = SafeParcelReader.createByteArray(paramParcel, k);
              paramStringBuilder.append("\"");
              paramStringBuilder.append(Base64Utils.encodeUrlSafe(arrayOfByte));
              paramStringBuilder.append("\"");
              break;
            case 8:
              arrayOfByte = SafeParcelReader.createByteArray(paramParcel, k);
              paramStringBuilder.append("\"");
              paramStringBuilder.append(Base64Utils.encode(arrayOfByte));
              paramStringBuilder.append("\"");
              break;
            case 7:
              str1 = SafeParcelReader.createString(paramParcel, k);
              paramStringBuilder.append("\"");
              paramStringBuilder.append(JsonUtils.escapeString(str1));
              paramStringBuilder.append("\"");
              break;
            case 6:
              paramStringBuilder.append(SafeParcelReader.readBoolean(paramParcel, k));
              break;
            case 5:
              paramStringBuilder.append(SafeParcelReader.createBigDecimal(paramParcel, k));
              break;
            case 4:
              paramStringBuilder.append(SafeParcelReader.readDouble(paramParcel, k));
              break;
            case 3:
              paramStringBuilder.append(SafeParcelReader.readFloat(paramParcel, k));
              break;
            case 2:
              paramStringBuilder.append(SafeParcelReader.readLong(paramParcel, k));
              break;
            case 1:
              paramStringBuilder.append(SafeParcelReader.createBigInteger(paramParcel, k));
              break;
            case 0:
              paramStringBuilder.append(SafeParcelReader.readInt(paramParcel, k));
              break;
          } 
        } 
        i = 1;
      } 
    } 
    if (paramParcel.dataPosition() == j) {
      paramStringBuilder.append('}');
      return;
    } 
    paramStringBuilder = new StringBuilder(37);
    paramStringBuilder.append("Overread allowed size end=");
    paramStringBuilder.append(j);
    throw new SafeParcelReader.ParseException(paramStringBuilder.toString(), paramParcel);
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList) {
    zaa(paramField);
    ArrayList<Parcel> arrayList = new ArrayList();
    ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    paramArrayList = paramArrayList;
    int j = paramArrayList.size();
    int i = 0;
    while (i < j) {
      T t = paramArrayList.get(i);
      i++;
      arrayList.add(((SafeParcelResponse)t).zaa());
    } 
    SafeParcelWriter.writeParcelList(this.zab, paramField.getSafeParcelableFieldId(), arrayList, true);
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, T paramT) {
    zaa(paramField);
    Parcel parcel = ((SafeParcelResponse)paramT).zaa();
    SafeParcelWriter.writeParcel(this.zab, paramField.getSafeParcelableFieldId(), parcel, true);
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
    zal zal1 = this.zad;
    return (zal1 == null) ? null : zal1.zaa((String)Preconditions.checkNotNull(this.zae));
  }
  
  public Object getValueObject(String paramString) {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public boolean isPrimitiveFieldSet(String paramString) {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  protected void setBooleanInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, boolean paramBoolean) {
    zaa(paramField);
    SafeParcelWriter.writeBoolean(this.zab, paramField.getSafeParcelableFieldId(), paramBoolean);
  }
  
  protected void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, byte[] paramArrayOfbyte) {
    zaa(paramField);
    SafeParcelWriter.writeByteArray(this.zab, paramField.getSafeParcelableFieldId(), paramArrayOfbyte, true);
  }
  
  protected void setIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, int paramInt) {
    zaa(paramField);
    SafeParcelWriter.writeInt(this.zab, paramField.getSafeParcelableFieldId(), paramInt);
  }
  
  protected void setLongInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, long paramLong) {
    zaa(paramField);
    SafeParcelWriter.writeLong(this.zab, paramField.getSafeParcelableFieldId(), paramLong);
  }
  
  protected void setStringInternal(FastJsonResponse.Field<?, ?> paramField, String paramString1, String paramString2) {
    zaa(paramField);
    SafeParcelWriter.writeString(this.zab, paramField.getSafeParcelableFieldId(), paramString2, true);
  }
  
  protected void setStringMapInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, Map<String, String> paramMap) {
    zaa(paramField);
    Bundle bundle = new Bundle();
    for (String str : ((Map)Preconditions.checkNotNull(paramMap)).keySet())
      bundle.putString(str, paramMap.get(str)); 
    SafeParcelWriter.writeBundle(this.zab, paramField.getSafeParcelableFieldId(), bundle, true);
  }
  
  protected void setStringsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList) {
    zaa(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    String[] arrayOfString = new String[j];
    int i;
    for (i = 0; i < j; i++)
      arrayOfString[i] = paramArrayList.get(i); 
    SafeParcelWriter.writeStringArray(this.zab, paramField.getSafeParcelableFieldId(), arrayOfString, true);
  }
  
  public String toString() {
    Preconditions.checkNotNull(this.zad, "Cannot convert to JSON on client side.");
    Parcel parcel = zaa();
    parcel.setDataPosition(0);
    StringBuilder stringBuilder = new StringBuilder(100);
    zaa(stringBuilder, (Map<String, FastJsonResponse.Field<?, ?>>)Preconditions.checkNotNull(this.zad.zaa((String)Preconditions.checkNotNull(this.zae))), parcel);
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    StringBuilder stringBuilder;
    Parcelable parcelable;
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    SafeParcelWriter.writeParcel(paramParcel, 2, zaa(), false);
    int j = this.zac;
    if (j != 0) {
      if (j != 1) {
        if (j == 2) {
          parcelable = (Parcelable)this.zad;
        } else {
          stringBuilder = new StringBuilder(34);
          stringBuilder.append("Invalid creation type: ");
          stringBuilder.append(j);
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } else {
        parcelable = (Parcelable)this.zad;
      } 
    } else {
      parcelable = null;
    } 
    SafeParcelWriter.writeParcelable((Parcel)stringBuilder, 3, parcelable, paramInt, false);
    SafeParcelWriter.finishObjectHeader((Parcel)stringBuilder, i);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, double paramDouble) {
    zaa(paramField);
    SafeParcelWriter.writeDouble(this.zab, paramField.getSafeParcelableFieldId(), paramDouble);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, float paramFloat) {
    zaa(paramField);
    SafeParcelWriter.writeFloat(this.zab, paramField.getSafeParcelableFieldId(), paramFloat);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, BigDecimal paramBigDecimal) {
    zaa(paramField);
    SafeParcelWriter.writeBigDecimal(this.zab, paramField.getSafeParcelableFieldId(), paramBigDecimal, true);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, BigInteger paramBigInteger) {
    zaa(paramField);
    SafeParcelWriter.writeBigInteger(this.zab, paramField.getSafeParcelableFieldId(), paramBigInteger, true);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Integer> paramArrayList) {
    zaa(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    int[] arrayOfInt = new int[j];
    int i;
    for (i = 0; i < j; i++)
      arrayOfInt[i] = ((Integer)paramArrayList.get(i)).intValue(); 
    SafeParcelWriter.writeIntArray(this.zab, paramField.getSafeParcelableFieldId(), arrayOfInt, true);
  }
  
  protected final void zab(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigInteger> paramArrayList) {
    zaa(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    BigInteger[] arrayOfBigInteger = new BigInteger[j];
    int i;
    for (i = 0; i < j; i++)
      arrayOfBigInteger[i] = paramArrayList.get(i); 
    SafeParcelWriter.writeBigIntegerArray(this.zab, paramField.getSafeParcelableFieldId(), arrayOfBigInteger, true);
  }
  
  protected final void zac(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Long> paramArrayList) {
    zaa(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    long[] arrayOfLong = new long[j];
    int i;
    for (i = 0; i < j; i++)
      arrayOfLong[i] = ((Long)paramArrayList.get(i)).longValue(); 
    SafeParcelWriter.writeLongArray(this.zab, paramField.getSafeParcelableFieldId(), arrayOfLong, true);
  }
  
  protected final void zad(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Float> paramArrayList) {
    zaa(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    float[] arrayOfFloat = new float[j];
    int i;
    for (i = 0; i < j; i++)
      arrayOfFloat[i] = ((Float)paramArrayList.get(i)).floatValue(); 
    SafeParcelWriter.writeFloatArray(this.zab, paramField.getSafeParcelableFieldId(), arrayOfFloat, true);
  }
  
  protected final void zae(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Double> paramArrayList) {
    zaa(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    double[] arrayOfDouble = new double[j];
    int i;
    for (i = 0; i < j; i++)
      arrayOfDouble[i] = ((Double)paramArrayList.get(i)).doubleValue(); 
    SafeParcelWriter.writeDoubleArray(this.zab, paramField.getSafeParcelableFieldId(), arrayOfDouble, true);
  }
  
  protected final void zaf(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigDecimal> paramArrayList) {
    zaa(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[j];
    int i;
    for (i = 0; i < j; i++)
      arrayOfBigDecimal[i] = paramArrayList.get(i); 
    SafeParcelWriter.writeBigDecimalArray(this.zab, paramField.getSafeParcelableFieldId(), arrayOfBigDecimal, true);
  }
  
  protected final void zag(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Boolean> paramArrayList) {
    zaa(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    boolean[] arrayOfBoolean = new boolean[j];
    int i;
    for (i = 0; i < j; i++)
      arrayOfBoolean[i] = ((Boolean)paramArrayList.get(i)).booleanValue(); 
    SafeParcelWriter.writeBooleanArray(this.zab, paramField.getSafeParcelableFieldId(), arrayOfBoolean, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\server\response\SafeParcelResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */