package com.blued.android.chat.utils;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.MessageUnpacker;
import org.msgpack.value.ArrayValue;
import org.msgpack.value.MapValue;
import org.msgpack.value.Value;

public class MsgPackHelper {
  private static final String TAG = "Chat_MsgPackHelper";
  
  public static boolean getBooleanValue(Map<String, Object> paramMap, String paramString) {
    return getBooleanValue(paramMap, paramString, false);
  }
  
  public static boolean getBooleanValue(Map<String, Object> paramMap, String paramString, boolean paramBoolean) {
    return ((Boolean)getMapValue(paramMap, paramString, Boolean.class, Boolean.valueOf(paramBoolean))).booleanValue();
  }
  
  public static double getDoubleValue(Map<String, Object> paramMap, String paramString) {
    return getDoubleValue(paramMap, paramString, 0.0D);
  }
  
  public static double getDoubleValue(Map<String, Object> paramMap, String paramString, double paramDouble) {
    return ((Double)getMapValue(paramMap, paramString, Double.class, Double.valueOf(paramDouble))).doubleValue();
  }
  
  public static float getFloatValue(Map<String, Object> paramMap, String paramString) {
    return getFloatValue(paramMap, paramString, 0.0F);
  }
  
  public static float getFloatValue(Map<String, Object> paramMap, String paramString, float paramFloat) {
    return ((Double)getMapValue(paramMap, paramString, Double.class, Double.valueOf(paramFloat))).floatValue();
  }
  
  public static int getIntValue(Map<String, Object> paramMap, String paramString) {
    return getIntValue(paramMap, paramString, 0);
  }
  
  public static int getIntValue(Map<String, Object> paramMap, String paramString, int paramInt) {
    return ((Long)getMapValue(paramMap, paramString, Long.class, Long.valueOf(paramInt))).intValue();
  }
  
  public static List getListValue(Map<String, Object> paramMap, String paramString) {
    return getMapValue(paramMap, paramString, List.class);
  }
  
  public static long getLongValue(Map<String, Object> paramMap, String paramString) {
    return getLongValue(paramMap, paramString, 0L);
  }
  
  public static long getLongValue(Map<String, Object> paramMap, String paramString, long paramLong) {
    return ((Long)getMapValue(paramMap, paramString, Long.class, Long.valueOf(paramLong))).longValue();
  }
  
  private static <T> T getMapValue(Map<String, Object> paramMap, String paramString, Class<T> paramClass) {
    return getMapValue(paramMap, paramString, paramClass, null);
  }
  
  private static <T> T getMapValue(Map<String, Object> paramMap, String paramString, Class<T> paramClass, T paramT) {
    if (paramMap == null)
      return paramT; 
    paramMap = (Map<String, Object>)paramMap.get(paramString);
    if (paramMap != null) {
      if (paramClass.isAssignableFrom(paramMap.getClass()))
        return (T)paramMap; 
      if (paramClass.isAssignableFrom(Double.class) && paramMap instanceof Long)
        return (T)Double.valueOf(((Long)paramMap).doubleValue()); 
      if (paramClass.isAssignableFrom(Long.class) && paramMap instanceof String) {
        try {
          return (T)Long.valueOf((String)paramMap);
        } catch (NumberFormatException numberFormatException) {
          if (ChatManager.debug) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("String to long failed, '");
            stringBuilder.append(paramString);
            stringBuilder.append("' unknown type:");
            stringBuilder.append(paramMap.getClass().getName());
            stringBuilder.append(", need type:");
            stringBuilder.append(paramClass);
            Log.e("Chat_MsgPackHelper", stringBuilder.toString());
            return paramT;
          } 
        } 
      } else {
        if (paramClass.isAssignableFrom(Boolean.class) && paramMap instanceof Boolean)
          return (T)paramMap; 
        if (ChatManager.debug) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("'");
          stringBuilder.append(paramString);
          stringBuilder.append("' unknown type:");
          stringBuilder.append(paramMap.getClass().getName());
          stringBuilder.append(", need type:");
          stringBuilder.append(paramClass);
          Log.e("Chat_MsgPackHelper", stringBuilder.toString());
        } 
      } 
    } 
    return paramT;
  }
  
  public static Map getMapValue(Map<String, Object> paramMap, String paramString) {
    return getMapValue(paramMap, paramString, Map.class);
  }
  
  public static short getShortValue(Map<String, Object> paramMap, String paramString) {
    return getShortValue(paramMap, paramString, (short)0);
  }
  
  public static short getShortValue(Map<String, Object> paramMap, String paramString, short paramShort) {
    return ((Long)getMapValue(paramMap, paramString, Long.class, Long.valueOf(paramShort))).shortValue();
  }
  
  public static String getStringValue(Map<String, Object> paramMap, String paramString) {
    return getStringValue(paramMap, paramString, null);
  }
  
  public static String getStringValue(Map<String, Object> paramMap, String paramString1, String paramString2) {
    return getMapValue(paramMap, paramString1, String.class, paramString2);
  }
  
  private static void packListValue(MessagePacker paramMessagePacker, List paramList) throws IOException {
    paramMessagePacker.packArrayHeader(paramList.size());
    Iterator iterator = paramList.iterator();
    while (iterator.hasNext())
      packValue(paramMessagePacker, iterator.next()); 
  }
  
  public static byte[] packMap(Map<String, Object> paramMap) {
    Object object = null;
    if (paramMap != null) {
      if (paramMap.size() == 0)
        return null; 
      MessageBufferPacker messageBufferPacker = MessagePack.newDefaultBufferPacker();
      try {
        packMapValue((MessagePacker)messageBufferPacker, paramMap);
        messageBufferPacker.flush();
        byte[] arrayOfByte2 = messageBufferPacker.toByteArray();
        byte[] arrayOfByte1 = arrayOfByte2;
        try {
          messageBufferPacker.close();
          return arrayOfByte2;
        } catch (IOException iOException) {
          iOException.printStackTrace();
          return arrayOfByte1;
        } 
      } catch (IOException iOException1) {
        iOException1.printStackTrace();
        iOException1 = iOException;
        messageBufferPacker.close();
        return null;
      } finally {}
      try {
        messageBufferPacker.close();
      } catch (IOException iOException1) {
        iOException1.printStackTrace();
      } 
      throw paramMap;
    } 
    return null;
  }
  
  private static void packMapValue(MessagePacker paramMessagePacker, Map<String, Object> paramMap) throws IOException {
    paramMessagePacker.packMapHeader(paramMap.size());
    for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
      paramMessagePacker.packString((String)entry.getKey());
      packValue(paramMessagePacker, entry.getValue());
    } 
  }
  
  private static void packValue(MessagePacker paramMessagePacker, Object paramObject) throws IOException {
    String str1;
    if (paramObject instanceof Map) {
      packMapValue(paramMessagePacker, (Map<String, Object>)paramObject);
      return;
    } 
    if (paramObject instanceof List) {
      packListValue(paramMessagePacker, (List)paramObject);
      return;
    } 
    if (paramObject instanceof String) {
      paramMessagePacker.packString((String)paramObject);
      return;
    } 
    if (paramObject instanceof Boolean) {
      paramMessagePacker.packBoolean(((Boolean)paramObject).booleanValue());
      return;
    } 
    if (paramObject instanceof Short) {
      paramMessagePacker.packShort(((Short)paramObject).shortValue());
      return;
    } 
    if (paramObject instanceof Integer) {
      paramMessagePacker.packInt(((Integer)paramObject).intValue());
      return;
    } 
    if (paramObject instanceof Long) {
      paramMessagePacker.packLong(((Long)paramObject).longValue());
      return;
    } 
    if (paramObject instanceof Float) {
      paramMessagePacker.packFloat(((Float)paramObject).floatValue());
      return;
    } 
    if (paramObject instanceof Double) {
      paramMessagePacker.packDouble(((Double)paramObject).doubleValue());
      return;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("pack failed, invalid value type:");
    String str2 = "null";
    if (paramObject == null) {
      str1 = "null";
    } else {
      str1 = paramObject.getClass().getSimpleName();
    } 
    stringBuilder2.append(str1);
    Log.e("Chat_MsgPackHelper", stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Invalid value type:");
    if (paramObject == null) {
      paramObject = str2;
    } else {
      paramObject = paramObject.getClass().getSimpleName();
    } 
    stringBuilder1.append((String)paramObject);
    paramMessagePacker.packString(stringBuilder1.toString());
  }
  
  public static void putMapValue(Map<String, Object> paramMap, String paramString, double paramDouble) {
    if (paramMap != null && !TextUtils.isEmpty(paramString))
      paramMap.put(paramString, Double.valueOf(paramDouble)); 
  }
  
  public static void putMapValue(Map<String, Object> paramMap, String paramString, long paramLong) {
    if (paramMap != null && !TextUtils.isEmpty(paramString))
      paramMap.put(paramString, Long.valueOf(paramLong)); 
  }
  
  public static void putMapValue(Map<String, Object> paramMap, String paramString1, String paramString2) {
    if (paramMap != null && !TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2))
      paramMap.put(paramString1, paramString2); 
  }
  
  private static List<Object> unpackArrayValue(ArrayValue paramArrayValue) {
    ArrayList<Object> arrayList = new ArrayList();
    Iterator<Value> iterator = paramArrayValue.iterator();
    while (iterator.hasNext())
      arrayList.add(unpackValue(iterator.next())); 
    return arrayList;
  }
  
  public static Map<String, Object> unpackMap(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder;
    if (paramInt2 <= paramInt1) {
      if (ChatManager.debug) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("unpackMap failed, data length is invalid, offset:");
        stringBuilder.append(paramInt1);
        stringBuilder.append(", length:");
        stringBuilder.append(paramInt2);
        Log.e("Chat_MsgPackHelper", stringBuilder.toString());
      } 
      return null;
    } 
    MessageUnpacker messageUnpacker = MessagePack.newDefaultUnpacker((byte[])stringBuilder, paramInt1, paramInt2 - paramInt1);
    try {
      paramInt2 = messageUnpacker.unpackMapHeader();
      ArrayMap<String, Object> arrayMap1 = new ArrayMap();
      paramInt1 = 0;
      while (paramInt1 < paramInt2) {
        try {
          arrayMap1.put(messageUnpacker.unpackString(), unpackValue((Value)messageUnpacker.unpackValue()));
          paramInt1++;
        } catch (IOException iOException) {
          // Byte code: goto -> 144
        } 
      } 
      ArrayMap<String, Object> arrayMap2 = arrayMap1;
      try {
        messageUnpacker.close();
        return (Map<String, Object>)arrayMap1;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return (Map<String, Object>)arrayMap2;
      } 
    } catch (IOException iOException) {
      stringBuilder = null;
      iOException.printStackTrace();
      StringBuilder stringBuilder1 = stringBuilder;
      messageUnpacker.close();
      return (Map<String, Object>)stringBuilder;
    } finally {}
    try {
      messageUnpacker.close();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    throw stringBuilder;
  }
  
  private static Map<String, Object> unpackMapValue(MapValue paramMapValue) {
    ArrayMap<String, Object> arrayMap = new ArrayMap();
    for (Map.Entry entry : paramMapValue.entrySet()) {
      if (((Value)entry.getKey()).isRawValue()) {
        String str = ((Value)entry.getKey()).asRawValue().asString();
        Object object = unpackValue((Value)entry.getValue());
        if (!TextUtils.isEmpty(str) && object != null)
          arrayMap.put(str, object); 
      } 
    } 
    return (Map<String, Object>)arrayMap;
  }
  
  private static Object unpackValue(Value paramValue) {
    return paramValue.isBooleanValue() ? Boolean.valueOf(paramValue.asBooleanValue().getBoolean()) : (paramValue.isIntegerValue() ? Long.valueOf(paramValue.asIntegerValue().asLong()) : (paramValue.isFloatValue() ? Double.valueOf(paramValue.asFloatValue().toDouble()) : (paramValue.isRawValue() ? paramValue.asRawValue().asString() : (paramValue.isMapValue() ? unpackMapValue(paramValue.asMapValue()) : (paramValue.isArrayValue() ? unpackArrayValue(paramValue.asArrayValue()) : null)))));
  }
  
  public void test() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cha\\utils\MsgPackHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */