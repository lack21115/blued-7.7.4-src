package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.console.RuntimeRepl;
import com.facebook.stetho.inspector.console.RuntimeReplFactory;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import com.facebook.stetho.inspector.jsonrpc.DisconnectReceiver;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.runtime.RhinoDetectingRuntimeReplFactory;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class Runtime implements ChromeDevtoolsDomain {
  private static final Map<JsonRpcPeer, Session> sSessions = Collections.synchronizedMap(new HashMap<JsonRpcPeer, Session>());
  
  private final ObjectMapper mObjectMapper = new ObjectMapper();
  
  private final RuntimeReplFactory mReplFactory;
  
  @Deprecated
  public Runtime() {
    this(new RuntimeReplFactory() {
          public RuntimeRepl newInstance() {
            return new RuntimeRepl() {
                public Object evaluate(String param2String) throws Throwable {
                  return "Not supported with legacy Runtime module";
                }
              };
          }
        });
  }
  
  public Runtime(Context paramContext) {
    this((RuntimeReplFactory)new RhinoDetectingRuntimeReplFactory(paramContext));
  }
  
  public Runtime(RuntimeReplFactory paramRuntimeReplFactory) {
    this.mReplFactory = paramRuntimeReplFactory;
  }
  
  private static String getPropertyClassName(Object paramObject) {
    String str = paramObject.getClass().getSimpleName();
    if (str != null) {
      String str1 = str;
      return (str.length() == 0) ? paramObject.getClass().getName() : str1;
    } 
    return paramObject.getClass().getName();
  }
  
  @Nonnull
  private static Session getSession(JsonRpcPeer paramJsonRpcPeer) {
    // Byte code:
    //   0: ldc com/facebook/stetho/inspector/protocol/module/Runtime
    //   2: monitorenter
    //   3: getstatic com/facebook/stetho/inspector/protocol/module/Runtime.sSessions : Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast com/facebook/stetho/inspector/protocol/module/Runtime$Session
    //   15: astore_2
    //   16: aload_2
    //   17: astore_1
    //   18: aload_2
    //   19: ifnonnull -> 54
    //   22: new com/facebook/stetho/inspector/protocol/module/Runtime$Session
    //   25: dup
    //   26: aconst_null
    //   27: invokespecial <init> : (Lcom/facebook/stetho/inspector/protocol/module/Runtime$1;)V
    //   30: astore_1
    //   31: getstatic com/facebook/stetho/inspector/protocol/module/Runtime.sSessions : Ljava/util/Map;
    //   34: aload_0
    //   35: aload_1
    //   36: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_0
    //   43: new com/facebook/stetho/inspector/protocol/module/Runtime$2
    //   46: dup
    //   47: aload_0
    //   48: invokespecial <init> : (Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;)V
    //   51: invokevirtual registerDisconnectReceiver : (Lcom/facebook/stetho/inspector/jsonrpc/DisconnectReceiver;)V
    //   54: ldc com/facebook/stetho/inspector/protocol/module/Runtime
    //   56: monitorexit
    //   57: aload_1
    //   58: areturn
    //   59: astore_0
    //   60: ldc com/facebook/stetho/inspector/protocol/module/Runtime
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	59	finally
    //   22	54	59	finally
  }
  
  public static int mapObject(JsonRpcPeer paramJsonRpcPeer, Object paramObject) {
    return getSession(paramJsonRpcPeer).getObjects().putObject(paramObject);
  }
  
  @ChromeDevtoolsMethod
  public CallFunctionOnResponse callFunctionOn(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) throws JsonRpcException {
    RemoteObject remoteObject;
    CallFunctionOnRequest callFunctionOnRequest = (CallFunctionOnRequest)this.mObjectMapper.convertValue(paramJSONObject, CallFunctionOnRequest.class);
    Session session = getSession(paramJsonRpcPeer);
    Object object = session.getObjectOrThrow(callFunctionOnRequest.objectId);
    if (callFunctionOnRequest.functionDeclaration.startsWith("function protoList(")) {
      ObjectProtoContainer objectProtoContainer = new ObjectProtoContainer(object);
      remoteObject = new RemoteObject();
      remoteObject.type = ObjectType.OBJECT;
      remoteObject.subtype = ObjectSubType.NODE;
      remoteObject.className = object.getClass().getName();
      remoteObject.description = getPropertyClassName(object);
      remoteObject.objectId = String.valueOf(session.getObjects().putObject(objectProtoContainer));
      CallFunctionOnResponse callFunctionOnResponse = new CallFunctionOnResponse();
      callFunctionOnResponse.result = remoteObject;
      callFunctionOnResponse.wasThrown = Boolean.valueOf(false);
      return callFunctionOnResponse;
    } 
    JsonRpcError.ErrorCode errorCode = JsonRpcError.ErrorCode.INTERNAL_ERROR;
    object = new StringBuilder();
    object.append("Expected protoList, got: ");
    object.append(((CallFunctionOnRequest)remoteObject).functionDeclaration);
    throw new JsonRpcException(new JsonRpcError(errorCode, object.toString(), null));
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult evaluate(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    return getSession(paramJsonRpcPeer).evaluate(this.mReplFactory, paramJSONObject);
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getProperties(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) throws JsonRpcException {
    return getSession(paramJsonRpcPeer).getProperties(paramJSONObject);
  }
  
  @ChromeDevtoolsMethod
  public void releaseObject(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) throws JSONException {
    String str = paramJSONObject.getString("objectId");
    getSession(paramJsonRpcPeer).getObjects().removeObjectById(Integer.parseInt(str));
  }
  
  @ChromeDevtoolsMethod
  public void releaseObjectGroup(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Ignoring request to releaseObjectGroup: ");
    stringBuilder.append(paramJSONObject);
    LogUtil.w(stringBuilder.toString());
  }
  
  static class CallArgument {
    @JsonProperty(required = false)
    public String objectId;
    
    @JsonProperty(required = false)
    public Runtime.ObjectType type;
    
    @JsonProperty(required = false)
    public Object value;
  }
  
  static class CallFunctionOnRequest {
    @JsonProperty
    public List<Runtime.CallArgument> arguments;
    
    @JsonProperty(required = false)
    public Boolean doNotPauseOnExceptionsAndMuteConsole;
    
    @JsonProperty
    public String functionDeclaration;
    
    @JsonProperty(required = false)
    public Boolean generatePreview;
    
    @JsonProperty
    public String objectId;
    
    @JsonProperty(required = false)
    public Boolean returnByValue;
  }
  
  static class CallFunctionOnResponse implements JsonRpcResult {
    @JsonProperty
    public Runtime.RemoteObject result;
    
    @JsonProperty(required = false)
    public Boolean wasThrown;
    
    private CallFunctionOnResponse() {}
  }
  
  static class EvaluateRequest implements JsonRpcResult {
    @JsonProperty(required = true)
    public String expression;
    
    @JsonProperty(required = true)
    public String objectGroup;
  }
  
  static class EvaluateResponse implements JsonRpcResult {
    @JsonProperty
    public Runtime.ExceptionDetails exceptionDetails;
    
    @JsonProperty(required = true)
    public Runtime.RemoteObject result;
    
    @JsonProperty(required = true)
    public boolean wasThrown;
    
    private EvaluateResponse() {}
  }
  
  static class ExceptionDetails {
    @JsonProperty(required = true)
    public String text;
    
    private ExceptionDetails() {}
  }
  
  static class GetPropertiesRequest implements JsonRpcResult {
    @JsonProperty(required = true)
    public String objectId;
    
    @JsonProperty(required = true)
    public boolean ownProperties;
  }
  
  static class GetPropertiesResponse implements JsonRpcResult {
    @JsonProperty(required = true)
    public List<Runtime.PropertyDescriptor> result;
    
    private GetPropertiesResponse() {}
  }
  
  static class ObjectProtoContainer {
    public final Object object;
    
    public ObjectProtoContainer(Object param1Object) {
      this.object = param1Object;
    }
  }
  
  public enum ObjectSubType {
    ARRAY("array"),
    DATE("array"),
    ERROR("array"),
    GENERATOR("array"),
    ITERATOR("array"),
    MAP("array"),
    NODE("array"),
    NULL("null"),
    REGEXP("null"),
    SET("null");
    
    private final String mProtocolValue;
    
    static {
      DATE = new ObjectSubType("DATE", 4, "date");
      MAP = new ObjectSubType("MAP", 5, "map");
      SET = new ObjectSubType("SET", 6, "set");
      ITERATOR = new ObjectSubType("ITERATOR", 7, "iterator");
      GENERATOR = new ObjectSubType("GENERATOR", 8, "generator");
      ERROR = new ObjectSubType("ERROR", 9, "error");
      $VALUES = new ObjectSubType[] { ARRAY, NULL, NODE, REGEXP, DATE, MAP, SET, ITERATOR, GENERATOR, ERROR };
    }
    
    ObjectSubType(String param1String1) {
      this.mProtocolValue = param1String1;
    }
    
    @JsonValue
    public String getProtocolValue() {
      return this.mProtocolValue;
    }
  }
  
  public enum ObjectType {
    OBJECT("object"),
    STRING("object"),
    SYMBOL("object"),
    UNDEFINED("object"),
    BOOLEAN("null"),
    FUNCTION("null"),
    NUMBER("null");
    
    private final String mProtocolValue;
    
    static {
      STRING = new ObjectType("STRING", 3, "string");
      NUMBER = new ObjectType("NUMBER", 4, "number");
      BOOLEAN = new ObjectType("BOOLEAN", 5, "boolean");
      SYMBOL = new ObjectType("SYMBOL", 6, "symbol");
      $VALUES = new ObjectType[] { OBJECT, FUNCTION, UNDEFINED, STRING, NUMBER, BOOLEAN, SYMBOL };
    }
    
    ObjectType(String param1String1) {
      this.mProtocolValue = param1String1;
    }
    
    @JsonValue
    public String getProtocolValue() {
      return this.mProtocolValue;
    }
  }
  
  static class PropertyDescriptor {
    @JsonProperty(required = true)
    public final boolean configurable = false;
    
    @JsonProperty(required = true)
    public final boolean enumerable = true;
    
    @JsonProperty(required = true)
    public final boolean isOwn = true;
    
    @JsonProperty(required = true)
    public String name;
    
    @JsonProperty(required = true)
    public Runtime.RemoteObject value;
    
    @JsonProperty(required = true)
    public final boolean writable = false;
    
    private PropertyDescriptor() {}
  }
  
  public static class RemoteObject {
    @JsonProperty
    public String className;
    
    @JsonProperty
    public String description;
    
    @JsonProperty
    public String objectId;
    
    @JsonProperty
    public Runtime.ObjectSubType subtype;
    
    @JsonProperty(required = true)
    public Runtime.ObjectType type;
    
    @JsonProperty
    public Object value;
  }
  
  static class Session {
    private final ObjectMapper mObjectMapper = new ObjectMapper();
    
    private final ObjectIdMapper mObjects = new ObjectIdMapper();
    
    @Nullable
    private RuntimeRepl mRepl;
    
    private Session() {}
    
    private List<?> arrayToList(Object param1Object) {
      ArrayList<Object> arrayList;
      Class<?> clazz = param1Object.getClass();
      if (clazz.isArray()) {
        if (!clazz.getComponentType().isPrimitive())
          return Arrays.asList((Object[])param1Object); 
        int j = Array.getLength(param1Object);
        arrayList = new ArrayList(j);
        for (int i = 0; i < j; i++)
          arrayList.add(Array.get(param1Object, i)); 
        return arrayList;
      } 
      param1Object = new StringBuilder();
      param1Object.append("Argument must be an array.  Was ");
      param1Object.append(arrayList);
      throw new IllegalArgumentException(param1Object.toString());
    }
    
    private Runtime.EvaluateResponse buildExceptionResponse(Object param1Object) {
      Runtime.EvaluateResponse evaluateResponse = new Runtime.EvaluateResponse();
      evaluateResponse.wasThrown = true;
      evaluateResponse.result = objectForRemote(param1Object);
      evaluateResponse.exceptionDetails = new Runtime.ExceptionDetails();
      evaluateResponse.exceptionDetails.text = param1Object.toString();
      return evaluateResponse;
    }
    
    private Runtime.EvaluateResponse buildNormalResponse(Object param1Object) {
      Runtime.EvaluateResponse evaluateResponse = new Runtime.EvaluateResponse();
      evaluateResponse.wasThrown = false;
      evaluateResponse.result = objectForRemote(param1Object);
      return evaluateResponse;
    }
    
    private Runtime.GetPropertiesResponse getPropertiesForIterable(Iterable<?> param1Iterable, boolean param1Boolean) {
      Runtime.GetPropertiesResponse getPropertiesResponse = new Runtime.GetPropertiesResponse();
      ArrayList<Runtime.PropertyDescriptor> arrayList = new ArrayList();
      Iterator<?> iterator = param1Iterable.iterator();
      int i = 0;
      while (iterator.hasNext()) {
        Object object = iterator.next();
        Runtime.PropertyDescriptor propertyDescriptor = new Runtime.PropertyDescriptor();
        if (param1Boolean) {
          int j = i + 1;
          String str = String.valueOf(i);
          i = j;
        } else {
          param1Iterable = null;
        } 
        propertyDescriptor.name = (String)param1Iterable;
        propertyDescriptor.value = objectForRemote(object);
        arrayList.add(propertyDescriptor);
      } 
      getPropertiesResponse.result = arrayList;
      return getPropertiesResponse;
    }
    
    private Runtime.GetPropertiesResponse getPropertiesForMap(Object param1Object) {
      Runtime.GetPropertiesResponse getPropertiesResponse = new Runtime.GetPropertiesResponse();
      ArrayList<Runtime.PropertyDescriptor> arrayList = new ArrayList();
      param1Object = ((Map)param1Object).entrySet().iterator();
      while (param1Object.hasNext()) {
        Map.Entry entry = param1Object.next();
        Runtime.PropertyDescriptor propertyDescriptor = new Runtime.PropertyDescriptor();
        propertyDescriptor.name = String.valueOf(entry.getKey());
        propertyDescriptor.value = objectForRemote(entry.getValue());
        arrayList.add(propertyDescriptor);
      } 
      getPropertiesResponse.result = arrayList;
      return getPropertiesResponse;
    }
    
    private Runtime.GetPropertiesResponse getPropertiesForObject(Object param1Object) {
      Runtime.GetPropertiesResponse getPropertiesResponse = new Runtime.GetPropertiesResponse();
      ArrayList<Runtime.PropertyDescriptor> arrayList = new ArrayList();
      for (Class<?> clazz = param1Object.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
        String str;
        ArrayList<?> arrayList1 = new ArrayList(Arrays.asList((Object[])clazz.getDeclaredFields()));
        Collections.reverse(arrayList1);
        if (clazz == param1Object.getClass()) {
          str = "";
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(clazz.getSimpleName());
          stringBuilder.append(".");
          str = stringBuilder.toString();
        } 
        for (Field field : arrayList1) {
          if (Modifier.isStatic(field.getModifiers()))
            continue; 
          field.setAccessible(true);
          try {
            Object object = field.get(param1Object);
            Runtime.PropertyDescriptor propertyDescriptor = new Runtime.PropertyDescriptor();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(field.getName());
            propertyDescriptor.name = stringBuilder.toString();
            propertyDescriptor.value = objectForRemote(object);
            arrayList.add(propertyDescriptor);
          } catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
          } 
        } 
      } 
      Collections.reverse(arrayList);
      getPropertiesResponse.result = arrayList;
      return getPropertiesResponse;
    }
    
    private Runtime.GetPropertiesResponse getPropertiesForProtoContainer(Runtime.ObjectProtoContainer param1ObjectProtoContainer) {
      Object object = param1ObjectProtoContainer.object;
      Runtime.RemoteObject remoteObject = new Runtime.RemoteObject();
      remoteObject.type = Runtime.ObjectType.OBJECT;
      remoteObject.subtype = Runtime.ObjectSubType.NODE;
      remoteObject.className = object.getClass().getName();
      remoteObject.description = Runtime.getPropertyClassName(object);
      remoteObject.objectId = String.valueOf(this.mObjects.putObject(object));
      object = new Runtime.PropertyDescriptor();
      ((Runtime.PropertyDescriptor)object).name = "1";
      ((Runtime.PropertyDescriptor)object).value = remoteObject;
      Runtime.GetPropertiesResponse getPropertiesResponse = new Runtime.GetPropertiesResponse();
      getPropertiesResponse.result = new ArrayList<Runtime.PropertyDescriptor>(1);
      getPropertiesResponse.result.add(object);
      return getPropertiesResponse;
    }
    
    @Nonnull
    private RuntimeRepl getRepl(RuntimeReplFactory param1RuntimeReplFactory) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield mRepl : Lcom/facebook/stetho/inspector/console/RuntimeRepl;
      //   6: ifnonnull -> 19
      //   9: aload_0
      //   10: aload_1
      //   11: invokeinterface newInstance : ()Lcom/facebook/stetho/inspector/console/RuntimeRepl;
      //   16: putfield mRepl : Lcom/facebook/stetho/inspector/console/RuntimeRepl;
      //   19: aload_0
      //   20: getfield mRepl : Lcom/facebook/stetho/inspector/console/RuntimeRepl;
      //   23: astore_1
      //   24: aload_0
      //   25: monitorexit
      //   26: aload_1
      //   27: areturn
      //   28: astore_1
      //   29: aload_0
      //   30: monitorexit
      //   31: aload_1
      //   32: athrow
      // Exception table:
      //   from	to	target	type
      //   2	19	28	finally
      //   19	24	28	finally
    }
    
    public Runtime.EvaluateResponse evaluate(RuntimeReplFactory param1RuntimeReplFactory, JSONObject param1JSONObject) {
      Runtime.EvaluateRequest evaluateRequest = (Runtime.EvaluateRequest)this.mObjectMapper.convertValue(param1JSONObject, Runtime.EvaluateRequest.class);
      try {
        return !evaluateRequest.objectGroup.equals("console") ? buildExceptionResponse("Not supported by FAB") : buildNormalResponse(getRepl(param1RuntimeReplFactory).evaluate(evaluateRequest.expression));
      } finally {
        param1RuntimeReplFactory = null;
      } 
    }
    
    public Object getObjectOrThrow(String param1String) throws JsonRpcException {
      Object object = getObjects().getObjectForId(Integer.parseInt(param1String));
      if (object != null)
        return object; 
      object = JsonRpcError.ErrorCode.INVALID_REQUEST;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No object found for ");
      stringBuilder.append(param1String);
      throw new JsonRpcException(new JsonRpcError(object, stringBuilder.toString(), null));
    }
    
    public ObjectIdMapper getObjects() {
      return this.mObjects;
    }
    
    public Runtime.GetPropertiesResponse getProperties(JSONObject param1JSONObject) throws JsonRpcException {
      Runtime.GetPropertiesResponse getPropertiesResponse;
      Runtime.GetPropertiesRequest getPropertiesRequest = (Runtime.GetPropertiesRequest)this.mObjectMapper.convertValue(param1JSONObject, Runtime.GetPropertiesRequest.class);
      if (!getPropertiesRequest.ownProperties) {
        getPropertiesResponse = new Runtime.GetPropertiesResponse();
        getPropertiesResponse.result = new ArrayList<Runtime.PropertyDescriptor>();
        return getPropertiesResponse;
      } 
      Object<?> object2 = (Object<?>)getObjectOrThrow(((Runtime.GetPropertiesRequest)getPropertiesResponse).objectId);
      Object<?> object1 = object2;
      if (object2.getClass().isArray())
        object1 = (Object<?>)arrayToList(object2); 
      return (object1 instanceof Runtime.ObjectProtoContainer) ? getPropertiesForProtoContainer((Runtime.ObjectProtoContainer)object1) : ((object1 instanceof List) ? getPropertiesForIterable((List)object1, true) : ((object1 instanceof Set) ? getPropertiesForIterable((Set)object1, false) : ((object1 instanceof Map) ? getPropertiesForMap(object1) : getPropertiesForObject(object1))));
    }
    
    public Runtime.RemoteObject objectForRemote(Object param1Object) {
      Runtime.RemoteObject remoteObject = new Runtime.RemoteObject();
      if (param1Object == null) {
        remoteObject.type = Runtime.ObjectType.OBJECT;
        remoteObject.subtype = Runtime.ObjectSubType.NULL;
        remoteObject.value = JSONObject.NULL;
        return remoteObject;
      } 
      if (param1Object instanceof Boolean) {
        remoteObject.type = Runtime.ObjectType.BOOLEAN;
        remoteObject.value = param1Object;
        return remoteObject;
      } 
      if (param1Object instanceof Number) {
        remoteObject.type = Runtime.ObjectType.NUMBER;
        remoteObject.value = param1Object;
        return remoteObject;
      } 
      if (param1Object instanceof Character) {
        remoteObject.type = Runtime.ObjectType.NUMBER;
        remoteObject.value = Integer.valueOf(((Character)param1Object).charValue());
        return remoteObject;
      } 
      if (param1Object instanceof String) {
        remoteObject.type = Runtime.ObjectType.STRING;
        remoteObject.value = String.valueOf(param1Object);
        return remoteObject;
      } 
      remoteObject.type = Runtime.ObjectType.OBJECT;
      remoteObject.className = "What??";
      remoteObject.objectId = String.valueOf(this.mObjects.putObject(param1Object));
      if (param1Object.getClass().isArray()) {
        remoteObject.description = "array";
        return remoteObject;
      } 
      if (param1Object instanceof List) {
        remoteObject.description = "List";
        return remoteObject;
      } 
      if (param1Object instanceof Set) {
        remoteObject.description = "Set";
        return remoteObject;
      } 
      if (param1Object instanceof Map) {
        remoteObject.description = "Map";
        return remoteObject;
      } 
      remoteObject.description = Runtime.getPropertyClassName(param1Object);
      return remoteObject;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\Runtime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */