package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {
  protected static <O, I> I zaa(Field<I, O> paramField, Object paramObject) {
    return (I)((Field.zaa(paramField) != null) ? (Object)paramField.zab((O)paramObject) : paramObject);
  }
  
  private static <O> void zaa(String paramString) {
    if (Log.isLoggable("FastJsonResponse", 6)) {
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 58);
      stringBuilder.append("Output field (");
      stringBuilder.append(paramString);
      stringBuilder.append(") has a null value, but expected a primitive");
      Log.e("FastJsonResponse", stringBuilder.toString());
    } 
  }
  
  private static void zaa(StringBuilder paramStringBuilder, Field paramField, Object paramObject) {
    Class<? extends FastJsonResponse> clazz;
    if (paramField.zaa == 11) {
      clazz = paramField.zag;
      Preconditions.checkNotNull(clazz);
      paramStringBuilder.append(((FastJsonResponse)clazz.cast(paramObject)).toString());
      return;
    } 
    if (((Field)clazz).zaa == 7) {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(JsonUtils.escapeString((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    } 
    paramStringBuilder.append(paramObject);
  }
  
  private final <I, O> void zab(Field<I, O> paramField, I paramI) {
    StringBuilder stringBuilder;
    int i;
    String str = paramField.zae;
    paramI = (I)paramField.zaa(paramI);
    switch (paramField.zac) {
      default:
        i = paramField.zac;
        stringBuilder = new StringBuilder(44);
        stringBuilder.append("Unsupported type for conversion: ");
        stringBuilder.append(i);
        throw new IllegalStateException(stringBuilder.toString());
      case 8:
      case 9:
        if (paramI != null) {
          setDecodedBytesInternal((Field<?, ?>)stringBuilder, str, (byte[])paramI);
          return;
        } 
        zaa(str);
        return;
      case 7:
        setStringInternal((Field<?, ?>)stringBuilder, str, (String)paramI);
        return;
      case 6:
        if (paramI != null) {
          setBooleanInternal((Field<?, ?>)stringBuilder, str, ((Boolean)paramI).booleanValue());
          return;
        } 
        zaa(str);
        return;
      case 5:
        zaa((Field<?, ?>)stringBuilder, str, (BigDecimal)paramI);
        return;
      case 4:
        if (paramI != null) {
          zaa((Field<?, ?>)stringBuilder, str, ((Double)paramI).doubleValue());
          return;
        } 
        zaa(str);
        return;
      case 2:
        if (paramI != null) {
          setLongInternal((Field<?, ?>)stringBuilder, str, ((Long)paramI).longValue());
          return;
        } 
        zaa(str);
        return;
      case 1:
        zaa((Field<?, ?>)stringBuilder, str, (BigInteger)paramI);
        return;
      case 0:
        break;
    } 
    if (paramI != null) {
      setIntegerInternal((Field<?, ?>)stringBuilder, str, ((Integer)paramI).intValue());
      return;
    } 
    zaa(str);
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList) {
    throw new UnsupportedOperationException("Concrete type array not supported");
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> paramField, String paramString, T paramT) {
    throw new UnsupportedOperationException("Concrete type not supported");
  }
  
  public abstract Map<String, Field<?, ?>> getFieldMappings();
  
  protected Object getFieldValue(Field paramField) {
    String str = paramField.zae;
    if (paramField.zag != null) {
      if (getValueObject(paramField.zae) == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Concrete field shouldn't be value object: %s", new Object[] { paramField.zae });
      boolean bool = paramField.zad;
      try {
        char c = Character.toUpperCase(str.charAt(0));
        String str1 = str.substring(1);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 4);
        stringBuilder.append("get");
        stringBuilder.append(c);
        stringBuilder.append(str1);
        str1 = stringBuilder.toString();
        return getClass().getMethod(str1, new Class[0]).invoke(this, new Object[0]);
      } catch (Exception exception) {
        throw new RuntimeException(exception);
      } 
    } 
    return getValueObject(((Field)exception).zae);
  }
  
  protected abstract Object getValueObject(String paramString);
  
  protected boolean isFieldSet(Field paramField) {
    String str;
    if (paramField.zac == 11) {
      if (paramField.zad) {
        str = paramField.zae;
        throw new UnsupportedOperationException("Concrete type arrays not supported");
      } 
      str = ((Field)str).zae;
      throw new UnsupportedOperationException("Concrete types not supported");
    } 
    return isPrimitiveFieldSet(((Field)str).zae);
  }
  
  protected abstract boolean isPrimitiveFieldSet(String paramString);
  
  protected void setBooleanInternal(Field<?, ?> paramField, String paramString, boolean paramBoolean) {
    throw new UnsupportedOperationException("Boolean not supported");
  }
  
  protected void setDecodedBytesInternal(Field<?, ?> paramField, String paramString, byte[] paramArrayOfbyte) {
    throw new UnsupportedOperationException("byte[] not supported");
  }
  
  protected void setIntegerInternal(Field<?, ?> paramField, String paramString, int paramInt) {
    throw new UnsupportedOperationException("Integer not supported");
  }
  
  protected void setLongInternal(Field<?, ?> paramField, String paramString, long paramLong) {
    throw new UnsupportedOperationException("Long not supported");
  }
  
  protected void setStringInternal(Field<?, ?> paramField, String paramString1, String paramString2) {
    throw new UnsupportedOperationException("String not supported");
  }
  
  protected void setStringMapInternal(Field<?, ?> paramField, String paramString, Map<String, String> paramMap) {
    throw new UnsupportedOperationException("String map not supported");
  }
  
  protected void setStringsInternal(Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList) {
    throw new UnsupportedOperationException("String list not supported");
  }
  
  public String toString() {
    Map<String, Field<?, ?>> map = getFieldMappings();
    StringBuilder stringBuilder = new StringBuilder(100);
    for (String str : map.keySet()) {
      Field<Object, ?> field = (Field)map.get(str);
      if (isFieldSet(field)) {
        ArrayList arrayList = (ArrayList)zaa(field, getFieldValue(field));
        if (stringBuilder.length() == 0) {
          stringBuilder.append("{");
        } else {
          stringBuilder.append(",");
        } 
        stringBuilder.append("\"");
        stringBuilder.append(str);
        stringBuilder.append("\":");
        if (arrayList == null) {
          stringBuilder.append("null");
          continue;
        } 
        switch (field.zac) {
          default:
            if (field.zab) {
              ArrayList<ArrayList> arrayList1 = arrayList;
              stringBuilder.append("[");
              int i = 0;
              int j = arrayList1.size();
              while (i < j) {
                if (i > 0)
                  stringBuilder.append(","); 
                arrayList = arrayList1.get(i);
                if (arrayList != null)
                  zaa(stringBuilder, field, arrayList); 
                i++;
              } 
              stringBuilder.append("]");
              continue;
            } 
            break;
          case 10:
            MapUtils.writeStringMapToJson(stringBuilder, (HashMap)arrayList);
            continue;
          case 9:
            stringBuilder.append("\"");
            stringBuilder.append(Base64Utils.encodeUrlSafe((byte[])arrayList));
            stringBuilder.append("\"");
            continue;
          case 8:
            stringBuilder.append("\"");
            stringBuilder.append(Base64Utils.encode((byte[])arrayList));
            stringBuilder.append("\"");
            continue;
        } 
        zaa(stringBuilder, field, arrayList);
      } 
    } 
    if (stringBuilder.length() > 0) {
      stringBuilder.append("}");
    } else {
      stringBuilder.append("{}");
    } 
    return stringBuilder.toString();
  }
  
  public final <O> void zaa(Field<Double, O> paramField, double paramDouble) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, Double.valueOf(paramDouble));
      return;
    } 
    zaa(paramField, paramField.zae, paramDouble);
  }
  
  public final <O> void zaa(Field<Float, O> paramField, float paramFloat) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, Float.valueOf(paramFloat));
      return;
    } 
    zaa(paramField, paramField.zae, paramFloat);
  }
  
  public final <O> void zaa(Field<Integer, O> paramField, int paramInt) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, Integer.valueOf(paramInt));
      return;
    } 
    setIntegerInternal(paramField, paramField.zae, paramInt);
  }
  
  public final <O> void zaa(Field<Long, O> paramField, long paramLong) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, Long.valueOf(paramLong));
      return;
    } 
    setLongInternal(paramField, paramField.zae, paramLong);
  }
  
  public final <O> void zaa(Field<String, O> paramField, String paramString) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, paramString);
      return;
    } 
    setStringInternal(paramField, paramField.zae, paramString);
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, double paramDouble) {
    throw new UnsupportedOperationException("Double not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, float paramFloat) {
    throw new UnsupportedOperationException("Float not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, BigDecimal paramBigDecimal) {
    throw new UnsupportedOperationException("BigDecimal not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, BigInteger paramBigInteger) {
    throw new UnsupportedOperationException("BigInteger not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, ArrayList<Integer> paramArrayList) {
    throw new UnsupportedOperationException("Integer list not supported");
  }
  
  public final <O> void zaa(Field<BigDecimal, O> paramField, BigDecimal paramBigDecimal) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, paramBigDecimal);
      return;
    } 
    zaa(paramField, paramField.zae, paramBigDecimal);
  }
  
  public final <O> void zaa(Field<BigInteger, O> paramField, BigInteger paramBigInteger) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, paramBigInteger);
      return;
    } 
    zaa(paramField, paramField.zae, paramBigInteger);
  }
  
  public final <O> void zaa(Field<ArrayList<Integer>, O> paramField, ArrayList<Integer> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, paramArrayList);
      return;
    } 
    zaa(paramField, paramField.zae, paramArrayList);
  }
  
  public final <O> void zaa(Field<Map<String, String>, O> paramField, Map<String, String> paramMap) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, paramMap);
      return;
    } 
    setStringMapInternal(paramField, paramField.zae, paramMap);
  }
  
  public final <O> void zaa(Field<Boolean, O> paramField, boolean paramBoolean) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, Boolean.valueOf(paramBoolean));
      return;
    } 
    setBooleanInternal(paramField, paramField.zae, paramBoolean);
  }
  
  public final <O> void zaa(Field<byte[], O> paramField, byte[] paramArrayOfbyte) {
    if (Field.zaa(paramField) != null) {
      zab((Field)paramField, paramArrayOfbyte);
      return;
    } 
    setDecodedBytesInternal(paramField, paramField.zae, paramArrayOfbyte);
  }
  
  protected void zab(Field<?, ?> paramField, String paramString, ArrayList<BigInteger> paramArrayList) {
    throw new UnsupportedOperationException("BigInteger list not supported");
  }
  
  public final <O> void zab(Field<ArrayList<BigInteger>, O> paramField, ArrayList<BigInteger> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, paramArrayList);
      return;
    } 
    zab(paramField, paramField.zae, paramArrayList);
  }
  
  protected void zac(Field<?, ?> paramField, String paramString, ArrayList<Long> paramArrayList) {
    throw new UnsupportedOperationException("Long list not supported");
  }
  
  public final <O> void zac(Field<ArrayList<Long>, O> paramField, ArrayList<Long> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, paramArrayList);
      return;
    } 
    zac(paramField, paramField.zae, paramArrayList);
  }
  
  protected void zad(Field<?, ?> paramField, String paramString, ArrayList<Float> paramArrayList) {
    throw new UnsupportedOperationException("Float list not supported");
  }
  
  public final <O> void zad(Field<ArrayList<Float>, O> paramField, ArrayList<Float> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, paramArrayList);
      return;
    } 
    zad(paramField, paramField.zae, paramArrayList);
  }
  
  protected void zae(Field<?, ?> paramField, String paramString, ArrayList<Double> paramArrayList) {
    throw new UnsupportedOperationException("Double list not supported");
  }
  
  public final <O> void zae(Field<ArrayList<Double>, O> paramField, ArrayList<Double> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, paramArrayList);
      return;
    } 
    zae(paramField, paramField.zae, paramArrayList);
  }
  
  protected void zaf(Field<?, ?> paramField, String paramString, ArrayList<BigDecimal> paramArrayList) {
    throw new UnsupportedOperationException("BigDecimal list not supported");
  }
  
  public final <O> void zaf(Field<ArrayList<BigDecimal>, O> paramField, ArrayList<BigDecimal> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, paramArrayList);
      return;
    } 
    zaf(paramField, paramField.zae, paramArrayList);
  }
  
  protected void zag(Field<?, ?> paramField, String paramString, ArrayList<Boolean> paramArrayList) {
    throw new UnsupportedOperationException("Boolean list not supported");
  }
  
  public final <O> void zag(Field<ArrayList<Boolean>, O> paramField, ArrayList<Boolean> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, paramArrayList);
      return;
    } 
    zag(paramField, paramField.zae, paramArrayList);
  }
  
  public final <O> void zah(Field<ArrayList<String>, O> paramField, ArrayList<String> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zab(paramField, paramArrayList);
      return;
    } 
    setStringsInternal(paramField, paramField.zae, paramArrayList);
  }
  
  public static class Field<I, O> extends AbstractSafeParcelable {
    public static final zaj CREATOR = new zaj();
    
    protected final int zaa;
    
    protected final boolean zab;
    
    protected final int zac;
    
    protected final boolean zad;
    
    protected final String zae;
    
    protected final int zaf;
    
    protected final Class<? extends FastJsonResponse> zag;
    
    private final int zah;
    
    private final String zai;
    
    private zal zaj;
    
    private FastJsonResponse.FieldConverter<I, O> zak;
    
    Field(int param1Int1, int param1Int2, boolean param1Boolean1, int param1Int3, boolean param1Boolean2, String param1String1, int param1Int4, String param1String2, zaa param1zaa) {
      this.zah = param1Int1;
      this.zaa = param1Int2;
      this.zab = param1Boolean1;
      this.zac = param1Int3;
      this.zad = param1Boolean2;
      this.zae = param1String1;
      this.zaf = param1Int4;
      if (param1String2 == null) {
        this.zag = null;
        this.zai = null;
      } else {
        this.zag = (Class)SafeParcelResponse.class;
        this.zai = param1String2;
      } 
      if (param1zaa == null) {
        this.zak = null;
        return;
      } 
      this.zak = param1zaa.zaa();
    }
    
    private Field(int param1Int1, boolean param1Boolean1, int param1Int2, boolean param1Boolean2, String param1String, int param1Int3, Class<? extends FastJsonResponse> param1Class, FastJsonResponse.FieldConverter<I, O> param1FieldConverter) {
      this.zah = 1;
      this.zaa = param1Int1;
      this.zab = param1Boolean1;
      this.zac = param1Int2;
      this.zad = param1Boolean2;
      this.zae = param1String;
      this.zaf = param1Int3;
      this.zag = param1Class;
      if (param1Class == null) {
        this.zai = null;
      } else {
        this.zai = param1Class.getCanonicalName();
      } 
      this.zak = param1FieldConverter;
    }
    
    public static Field<byte[], byte[]> forBase64(String param1String, int param1Int) {
      return (Field)new Field<byte, byte>(8, false, 8, false, param1String, param1Int, null, null);
    }
    
    public static Field<Boolean, Boolean> forBoolean(String param1String, int param1Int) {
      return new Field<Boolean, Boolean>(6, false, 6, false, param1String, param1Int, null, null);
    }
    
    public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String param1String, int param1Int, Class<T> param1Class) {
      return new Field<T, T>(11, false, 11, false, param1String, param1Int, param1Class, null);
    }
    
    public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String param1String, int param1Int, Class<T> param1Class) {
      return new Field<ArrayList<T>, ArrayList<T>>(11, true, 11, true, param1String, param1Int, param1Class, null);
    }
    
    public static Field<Double, Double> forDouble(String param1String, int param1Int) {
      return new Field<Double, Double>(4, false, 4, false, param1String, param1Int, null, null);
    }
    
    public static Field<Float, Float> forFloat(String param1String, int param1Int) {
      return new Field<Float, Float>(3, false, 3, false, param1String, param1Int, null, null);
    }
    
    public static Field<Integer, Integer> forInteger(String param1String, int param1Int) {
      return new Field<Integer, Integer>(0, false, 0, false, param1String, param1Int, null, null);
    }
    
    public static Field<Long, Long> forLong(String param1String, int param1Int) {
      return new Field<Long, Long>(2, false, 2, false, param1String, param1Int, null, null);
    }
    
    public static Field<String, String> forString(String param1String, int param1Int) {
      return new Field<String, String>(7, false, 7, false, param1String, param1Int, null, null);
    }
    
    public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String param1String, int param1Int) {
      return new Field<HashMap<String, String>, HashMap<String, String>>(10, false, 10, false, param1String, param1Int, null, null);
    }
    
    public static Field<ArrayList<String>, ArrayList<String>> forStrings(String param1String, int param1Int) {
      return new Field<ArrayList<String>, ArrayList<String>>(7, true, 7, true, param1String, param1Int, null, null);
    }
    
    public static Field withConverter(String param1String, int param1Int, FastJsonResponse.FieldConverter<?, ?> param1FieldConverter, boolean param1Boolean) {
      return new Field<Object, Object>(param1FieldConverter.zaa(), param1Boolean, param1FieldConverter.zab(), false, param1String, param1Int, null, param1FieldConverter);
    }
    
    private final String zae() {
      String str2 = this.zai;
      String str1 = str2;
      if (str2 == null)
        str1 = null; 
      return str1;
    }
    
    private final zaa zaf() {
      FastJsonResponse.FieldConverter<I, O> fieldConverter = this.zak;
      return (fieldConverter == null) ? null : zaa.zaa(fieldConverter);
    }
    
    public int getSafeParcelableFieldId() {
      return this.zaf;
    }
    
    public String toString() {
      Objects.ToStringHelper toStringHelper = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.zah)).add("typeIn", Integer.valueOf(this.zaa)).add("typeInArray", Boolean.valueOf(this.zab)).add("typeOut", Integer.valueOf(this.zac)).add("typeOutArray", Boolean.valueOf(this.zad)).add("outputFieldName", this.zae).add("safeParcelFieldId", Integer.valueOf(this.zaf)).add("concreteTypeName", zae());
      Class<? extends FastJsonResponse> clazz = this.zag;
      if (clazz != null)
        toStringHelper.add("concreteType.class", clazz.getCanonicalName()); 
      FastJsonResponse.FieldConverter<I, O> fieldConverter = this.zak;
      if (fieldConverter != null)
        toStringHelper.add("converterName", fieldConverter.getClass().getCanonicalName()); 
      return toStringHelper.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      int i = SafeParcelWriter.beginObjectHeader(param1Parcel);
      SafeParcelWriter.writeInt(param1Parcel, 1, this.zah);
      SafeParcelWriter.writeInt(param1Parcel, 2, this.zaa);
      SafeParcelWriter.writeBoolean(param1Parcel, 3, this.zab);
      SafeParcelWriter.writeInt(param1Parcel, 4, this.zac);
      SafeParcelWriter.writeBoolean(param1Parcel, 5, this.zad);
      SafeParcelWriter.writeString(param1Parcel, 6, this.zae, false);
      SafeParcelWriter.writeInt(param1Parcel, 7, getSafeParcelableFieldId());
      SafeParcelWriter.writeString(param1Parcel, 8, zae(), false);
      SafeParcelWriter.writeParcelable(param1Parcel, 9, (Parcelable)zaf(), param1Int, false);
      SafeParcelWriter.finishObjectHeader(param1Parcel, i);
    }
    
    public final Field<I, O> zaa() {
      return new Field(this.zah, this.zaa, this.zab, this.zac, this.zad, this.zae, this.zaf, this.zai, zaf());
    }
    
    public final O zaa(I param1I) {
      Preconditions.checkNotNull(this.zak);
      return (O)Preconditions.checkNotNull(this.zak.zab(param1I));
    }
    
    public final void zaa(zal param1zal) {
      this.zaj = param1zal;
    }
    
    public final I zab(O param1O) {
      Preconditions.checkNotNull(this.zak);
      return this.zak.zaa(param1O);
    }
    
    public final boolean zab() {
      return (this.zak != null);
    }
    
    public final FastJsonResponse zac() throws InstantiationException, IllegalAccessException {
      Preconditions.checkNotNull(this.zag);
      Class<? extends FastJsonResponse> clazz = this.zag;
      if (clazz == SafeParcelResponse.class) {
        Preconditions.checkNotNull(this.zai);
        Preconditions.checkNotNull(this.zaj, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
        return new SafeParcelResponse(this.zaj, this.zai);
      } 
      return clazz.newInstance();
    }
    
    public final Map<String, Field<?, ?>> zad() {
      Preconditions.checkNotNull(this.zai);
      Preconditions.checkNotNull(this.zaj);
      return (Map<String, Field<?, ?>>)Preconditions.checkNotNull(this.zaj.zaa(this.zai));
    }
  }
  
  public static interface FieldConverter<I, O> {
    int zaa();
    
    I zaa(O param1O);
    
    int zab();
    
    O zab(I param1I);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\server\response\FastJsonResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */