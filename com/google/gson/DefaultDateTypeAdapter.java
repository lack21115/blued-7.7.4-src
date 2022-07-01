package com.google.gson;

import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
  private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
  
  private final List<DateFormat> dateFormats = new ArrayList<DateFormat>();
  
  private final Class<? extends Date> dateType;
  
  public DefaultDateTypeAdapter(int paramInt1, int paramInt2) {
    this(Date.class, paramInt1, paramInt2);
  }
  
  DefaultDateTypeAdapter(Class<? extends Date> paramClass) {
    this.dateType = verifyDateType(paramClass);
    this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
    if (!Locale.getDefault().equals(Locale.US))
      this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2)); 
    if (JavaVersion.isJava9OrLater())
      this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2)); 
  }
  
  DefaultDateTypeAdapter(Class<? extends Date> paramClass, int paramInt) {
    this.dateType = verifyDateType(paramClass);
    this.dateFormats.add(DateFormat.getDateInstance(paramInt, Locale.US));
    if (!Locale.getDefault().equals(Locale.US))
      this.dateFormats.add(DateFormat.getDateInstance(paramInt)); 
    if (JavaVersion.isJava9OrLater())
      this.dateFormats.add(PreJava9DateFormatProvider.getUSDateFormat(paramInt)); 
  }
  
  public DefaultDateTypeAdapter(Class<? extends Date> paramClass, int paramInt1, int paramInt2) {
    this.dateType = verifyDateType(paramClass);
    this.dateFormats.add(DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US));
    if (!Locale.getDefault().equals(Locale.US))
      this.dateFormats.add(DateFormat.getDateTimeInstance(paramInt1, paramInt2)); 
    if (JavaVersion.isJava9OrLater())
      this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(paramInt1, paramInt2)); 
  }
  
  DefaultDateTypeAdapter(Class<? extends Date> paramClass, String paramString) {
    this.dateType = verifyDateType(paramClass);
    this.dateFormats.add(new SimpleDateFormat(paramString, Locale.US));
    if (!Locale.getDefault().equals(Locale.US))
      this.dateFormats.add(new SimpleDateFormat(paramString)); 
  }
  
  private Date deserializeToDate(String paramString) {
    synchronized (this.dateFormats) {
      Iterator<DateFormat> iterator = this.dateFormats.iterator();
      while (true) {
        if (iterator.hasNext()) {
          DateFormat dateFormat = iterator.next();
          try {
            return dateFormat.parse(paramString);
          } catch (ParseException parseException) {
            continue;
          } 
        } 
        try {
          return ISO8601Utils.parse(paramString, new ParsePosition(0));
        } catch (ParseException parseException) {
          throw new JsonSyntaxException(paramString, parseException);
        } 
      } 
    } 
  }
  
  private static Class<? extends Date> verifyDateType(Class<? extends Date> paramClass) {
    if (paramClass != Date.class && paramClass != Date.class) {
      if (paramClass == Timestamp.class)
        return paramClass; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Date type must be one of ");
      stringBuilder.append(Date.class);
      stringBuilder.append(", ");
      stringBuilder.append(Timestamp.class);
      stringBuilder.append(", or ");
      stringBuilder.append(Date.class);
      stringBuilder.append(" but was ");
      stringBuilder.append(paramClass);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    return paramClass;
  }
  
  public Date read(JsonReader paramJsonReader) throws IOException {
    if (paramJsonReader.peek() == JsonToken.NULL) {
      paramJsonReader.nextNull();
      return null;
    } 
    Date date = deserializeToDate(paramJsonReader.nextString());
    Class<? extends Date> clazz = this.dateType;
    if (clazz == Date.class)
      return date; 
    if (clazz == Timestamp.class)
      return new Timestamp(date.getTime()); 
    if (clazz == Date.class)
      return new Date(date.getTime()); 
    throw new AssertionError();
  }
  
  public String toString() {
    DateFormat dateFormat = this.dateFormats.get(0);
    if (dateFormat instanceof SimpleDateFormat) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("DefaultDateTypeAdapter(");
      stringBuilder1.append(((SimpleDateFormat)dateFormat).toPattern());
      stringBuilder1.append(')');
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DefaultDateTypeAdapter(");
    stringBuilder.append(dateFormat.getClass().getSimpleName());
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
  
  public void write(JsonWriter paramJsonWriter, Date paramDate) throws IOException {
    if (paramDate == null) {
      paramJsonWriter.nullValue();
      return;
    } 
    synchronized (this.dateFormats) {
      paramJsonWriter.value(((DateFormat)this.dateFormats.get(0)).format(paramDate));
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\DefaultDateTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */