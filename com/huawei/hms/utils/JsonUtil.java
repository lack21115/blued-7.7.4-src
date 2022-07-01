package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
  private static final String BYTE_BYTE = "_byte_";
  
  private static final String LIST_FIELD_VALUE = "_value_";
  
  private static final String LIST_ITEM_VALUE = "_list_item_";
  
  private static final String LIST_SIZE = "_list_size_";
  
  private static final String MAP_MAP = "_map_";
  
  private static final String NEXT_ITEM = "_next_item_";
  
  private static final String PRE_PKG = "com.huawei";
  
  private static final String TAG = "JsonUtil";
  
  protected static final int VAL_BYTE = 2;
  
  protected static final int VAL_ENTITY = 0;
  
  protected static final int VAL_LIST = 1;
  
  protected static final int VAL_MAP = 3;
  
  protected static final int VAL_NULL = -1;
  
  protected static final String VAL_TYPE = "_val_type_";
  
  private static String createInnerJsonString(IMessageEntity paramIMessageEntity) throws IllegalAccessException, JSONException {
    Class<?> clazz = paramIMessageEntity.getClass();
    JSONObject jSONObject = new JSONObject();
    while (clazz != null) {
      for (Field field : clazz.getDeclaredFields()) {
        if (field.isAnnotationPresent((Class)Packed.class)) {
          boolean bool = field.isAccessible();
          setAccessible(field, true);
          String str = field.getName();
          Object object = field.get(paramIMessageEntity);
          setAccessible(field, bool);
          disposeType(str, object, jSONObject);
        } 
      } 
      clazz = clazz.getSuperclass();
    } 
    return jSONObject.toString();
  }
  
  public static String createJsonString(IMessageEntity paramIMessageEntity) {
    if (paramIMessageEntity == null) {
      HMSLog.e("JsonUtil", "createJsonString error, the input IMessageEntity is null");
      return "";
    } 
    try {
      return createInnerJsonString(paramIMessageEntity);
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("catch IllegalAccessException ");
      stringBuilder.append(illegalAccessException.getMessage());
      HMSLog.e("JsonUtil", stringBuilder.toString());
      return "";
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("catch JSONException ");
      stringBuilder.append(jSONException.getMessage());
      HMSLog.e("JsonUtil", stringBuilder.toString());
      return "";
    } 
  }
  
  private static boolean disposeType(String paramString, Object paramObject, JSONObject paramJSONObject) throws JSONException, IllegalAccessException {
    if (paramObject instanceof String) {
      paramJSONObject.put(paramString, paramObject);
    } else if (paramObject instanceof Integer) {
      paramJSONObject.put(paramString, ((Integer)paramObject).intValue());
    } else if (paramObject instanceof Short) {
      paramJSONObject.put(paramString, paramObject);
    } else if (paramObject instanceof Long) {
      paramJSONObject.put(paramString, paramObject);
    } else if (paramObject instanceof Float) {
      paramJSONObject.put(paramString, paramObject);
    } else if (paramObject instanceof Double) {
      paramJSONObject.put(paramString, paramObject);
    } else if (paramObject instanceof Boolean) {
      paramJSONObject.put(paramString, paramObject);
    } else if (paramObject instanceof JSONObject) {
      paramJSONObject.put(paramString, paramObject);
    } else if (paramObject instanceof byte[]) {
      writeByte(paramString, (byte[])paramObject, paramJSONObject);
    } else if (paramObject instanceof List) {
      writeList(paramString, (List)paramObject, paramJSONObject);
    } else if (paramObject instanceof Map) {
      writeMap(paramString, (Map)paramObject, paramJSONObject);
    } else {
      if (paramObject instanceof IMessageEntity)
        try {
          paramJSONObject.put(paramString, createInnerJsonString((IMessageEntity)paramObject));
          return true;
        } catch (IllegalAccessException illegalAccessException) {
          paramObject = new StringBuilder();
          paramObject.append("IllegalAccessException , ");
          paramObject.append(illegalAccessException);
          HMSLog.e("JsonUtil", paramObject.toString());
        }  
      return false;
    } 
    return true;
  }
  
  public static Object getInfoFromJsonobject(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return null; 
      try {
        JSONObject jSONObject = new JSONObject(paramString1);
        if (!jSONObject.has(paramString2))
          return null; 
        Object object = jSONObject.get(paramString2);
        boolean bool = object instanceof String;
        if (bool)
          return object; 
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getInfoFromJsonobject:parser json error :");
        stringBuilder.append(paramString2);
        HMSLog.e("JsonUtil", stringBuilder.toString());
      } 
    } 
    return null;
  }
  
  public static int getIntValue(JSONObject paramJSONObject, String paramString) throws JSONException {
    return (paramJSONObject != null && paramJSONObject.has(paramString)) ? paramJSONObject.getInt(paramString) : -1;
  }
  
  private static Object getObjectValue(String paramString, JSONObject paramJSONObject) throws JSONException {
    return paramJSONObject.has(paramString) ? paramJSONObject.get(paramString) : ((paramJSONObject.has("header") && paramJSONObject.getJSONObject("header").has(paramString)) ? paramJSONObject.getJSONObject("header").get(paramString) : ((paramJSONObject.has("body") && paramJSONObject.getJSONObject("body").has(paramString)) ? paramJSONObject.getJSONObject("body").get(paramString) : null));
  }
  
  public static String getStringValue(JSONObject paramJSONObject, String paramString) throws JSONException {
    return (paramJSONObject != null && paramJSONObject.has(paramString)) ? paramJSONObject.getString(paramString) : null;
  }
  
  public static IMessageEntity jsonToEntity(String paramString, IMessageEntity paramIMessageEntity) {
    try {
      Class<?> clazz2 = paramIMessageEntity.getClass();
      JSONObject jSONObject = new JSONObject(paramString);
      Class<?> clazz1 = clazz2;
      label24: while (true) {
        if (clazz1 != null) {
          Field[] arrayOfField = clazz1.getDeclaredFields();
          int j = arrayOfField.length;
          for (int i = 0;; i++) {
            if (i < j) {
              Field field = arrayOfField[i];
              boolean bool = field.isAnnotationPresent((Class)Packed.class);
              if (bool)
                try {
                  readFiled(paramIMessageEntity, field, jSONObject);
                } catch (IllegalAccessException illegalAccessException) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("jsonToEntity, set value of the field exception, field name:");
                  stringBuilder.append(field.getName());
                  HMSLog.e("JsonUtil", stringBuilder.toString());
                }  
            } else {
              clazz1 = clazz1.getSuperclass();
              continue label24;
            } 
          } 
          break;
        } 
        return paramIMessageEntity;
      } 
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("catch JSONException when parse jsonString");
      stringBuilder.append(jSONException.getMessage());
      HMSLog.e("JsonUtil", stringBuilder.toString());
    } 
    return paramIMessageEntity;
  }
  
  private static byte[] readByte(JSONObject paramJSONObject) throws JSONException {
    try {
      return Base64.decode(paramJSONObject.getString("_byte_"));
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("readByte failed : ");
      stringBuilder.append(illegalArgumentException.getMessage());
      HMSLog.e("JsonUtil", stringBuilder.toString());
      return null;
    } 
  }
  
  private static void readFiled(IMessageEntity paramIMessageEntity, Field paramField, JSONObject paramJSONObject) throws JSONException, IllegalAccessException {
    Object object = readJson(paramIMessageEntity, paramField, paramJSONObject);
    if (object != null) {
      boolean bool = paramField.isAccessible();
      setAccessible(paramField, true);
      paramField.set(paramIMessageEntity, object);
      setAccessible(paramField, bool);
    } 
  }
  
  private static Object readJson(IMessageEntity paramIMessageEntity, Field paramField, JSONObject paramJSONObject) throws JSONException, IllegalAccessException {
    Object<Object> object = (Object<Object>)getObjectValue(paramField.getName(), paramJSONObject);
    if (object != null)
      try {
        if (paramField.getType().getName().startsWith("com.huawei") && paramField.getType().newInstance() instanceof IMessageEntity)
          return jsonToEntity((String)object, (IMessageEntity)paramField.getType().newInstance()); 
        if (object instanceof JSONObject && ((JSONObject)object).has("_val_type_")) {
          int i = ((JSONObject)object).getInt("_val_type_");
          if (i == 1 || i == 0)
            return readList(paramField.getGenericType(), (JSONObject)object); 
          if (i == 2)
            return readByte((JSONObject)object); 
          if (i == 3)
            return readMap(paramField.getGenericType(), (JSONObject)object); 
          object = (Object<Object>)new StringBuilder();
          object.append("cannot support type : ");
          object.append(i);
          HMSLog.e("JsonUtil", object.toString());
          return null;
        } 
        return object;
      } catch (InstantiationException instantiationException) {
        HMSLog.e("JsonUtil", "InstantiationException  ");
      }  
    return null;
  }
  
  private static List<Object> readList(Type paramType, JSONObject paramJSONObject) throws JSONException, IllegalAccessException, InstantiationException {
    int j = paramJSONObject.getInt("_list_size_");
    int k = paramJSONObject.getInt("_val_type_");
    ArrayList<IMessageEntity> arrayList = new ArrayList(j);
    for (int i = 0; i < j; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("_list_item_");
      stringBuilder.append(i);
      Object object = paramJSONObject.get(stringBuilder.toString());
      if (k == 0) {
        IMessageEntity iMessageEntity = (IMessageEntity)((Class<Object>)((ParameterizedType)paramType).getActualTypeArguments()[0]).newInstance();
        arrayList.add(jsonToEntity((String)object, iMessageEntity));
      } else if (k == 1) {
        arrayList.add(object);
      } 
    } 
    return (List)arrayList;
  }
  
  private static Map readMap(Type paramType, JSONObject paramJSONObject) throws JSONException, IllegalAccessException, InstantiationException {
    paramType = ((ParameterizedType)paramType).getActualTypeArguments()[1];
    JSONArray jSONArray = new JSONArray(paramJSONObject.getString("_map_"));
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (int i = 0; i < jSONArray.length(); i += 2) {
      if (paramType.newInstance() instanceof IMessageEntity) {
        IMessageEntity iMessageEntity = jsonToEntity(jSONArray.getString(i + 1), paramType.newInstance());
        hashMap.put(jSONArray.get(i), iMessageEntity);
      } else {
        hashMap.put(jSONArray.get(i), jSONArray.get(i + 1));
      } 
    } 
    return hashMap;
  }
  
  private static void setAccessible(final Field field, final boolean flag) {
    AccessController.doPrivileged(new PrivilegedAction() {
          public Object run() {
            field.setAccessible(flag);
            return null;
          }
        });
  }
  
  private static void writeByte(String paramString, byte[] paramArrayOfbyte, JSONObject paramJSONObject) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("_val_type_", 2);
    try {
      jSONObject.put("_byte_", Base64.encode(paramArrayOfbyte));
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("writeByte failed : ");
      stringBuilder.append(illegalArgumentException.getMessage());
      HMSLog.e("JsonUtil", stringBuilder.toString());
    } 
    paramJSONObject.put(paramString, jSONObject);
  }
  
  private static void writeList(String paramString, List<?> paramList, JSONObject paramJSONObject) throws JSONException, IllegalAccessException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("_val_type_", 1);
    jSONObject.put("_list_size_", paramList.size());
    for (int i = 0; i < paramList.size(); i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("_list_item_");
      stringBuilder.append(i);
      disposeType(stringBuilder.toString(), paramList.get(i), jSONObject);
      if (paramList.get(i) instanceof IMessageEntity)
        jSONObject.put("_val_type_", 0); 
    } 
    paramJSONObject.put(paramString, jSONObject);
  }
  
  private static void writeMap(String paramString, Map paramMap, JSONObject paramJSONObject) throws JSONException, IllegalAccessException {
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    JSONArray jSONArray = new JSONArray();
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      Object object = entry.getKey();
      entry = (Map.Entry)entry.getValue();
      if (object instanceof IMessageEntity) {
        jSONArray.put(createInnerJsonString((IMessageEntity)object));
      } else {
        jSONArray.put(object);
      } 
      if (entry instanceof IMessageEntity) {
        jSONArray.put(createInnerJsonString((IMessageEntity)entry));
        continue;
      } 
      jSONArray.put(entry);
    } 
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("_val_type_", 3);
    jSONObject.put("_map_", jSONArray.toString());
    paramJSONObject.put(paramString, jSONObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\JsonUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */