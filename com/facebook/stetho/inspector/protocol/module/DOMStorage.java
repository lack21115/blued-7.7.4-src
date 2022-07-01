package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.domstorage.DOMStoragePeerManager;
import com.facebook.stetho.inspector.domstorage.SharedPreferencesHelper;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class DOMStorage implements ChromeDevtoolsDomain {
  private final Context mContext;
  
  private final DOMStoragePeerManager mDOMStoragePeerManager;
  
  private final ObjectMapper mObjectMapper = new ObjectMapper();
  
  public DOMStorage(Context paramContext) {
    this.mContext = paramContext;
    this.mDOMStoragePeerManager = new DOMStoragePeerManager(paramContext);
  }
  
  private static void assignByType(SharedPreferences.Editor paramEditor, String paramString, Object paramObject) throws IllegalArgumentException {
    if (paramObject instanceof Integer) {
      paramEditor.putInt(paramString, ((Integer)paramObject).intValue());
      return;
    } 
    if (paramObject instanceof Long) {
      paramEditor.putLong(paramString, ((Long)paramObject).longValue());
      return;
    } 
    if (paramObject instanceof Float) {
      paramEditor.putFloat(paramString, ((Float)paramObject).floatValue());
      return;
    } 
    if (paramObject instanceof Boolean) {
      paramEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      return;
    } 
    if (paramObject instanceof String) {
      paramEditor.putString(paramString, (String)paramObject);
      return;
    } 
    if (paramObject instanceof Set) {
      putStringSet(paramEditor, paramString, (Set<String>)paramObject);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unsupported type=");
    stringBuilder.append(paramObject.getClass().getName());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static void putStringSet(SharedPreferences.Editor paramEditor, String paramString, Set<String> paramSet) {
    paramEditor.putStringSet(paramString, paramSet);
  }
  
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    this.mDOMStoragePeerManager.removePeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    this.mDOMStoragePeerManager.addPeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getDOMStorageItems(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) throws JSONException {
    StorageId storageId = (StorageId)this.mObjectMapper.convertValue(paramJSONObject.getJSONObject("storageId"), StorageId.class);
    ArrayList<ArrayList<String>> arrayList = new ArrayList();
    String str = storageId.securityOrigin;
    if (storageId.isLocalStorage)
      for (Map.Entry entry : this.mContext.getSharedPreferences(str, 0).getAll().entrySet()) {
        ArrayList<String> arrayList1 = new ArrayList(2);
        arrayList1.add(entry.getKey());
        arrayList1.add(SharedPreferencesHelper.valueToString(entry.getValue()));
        arrayList.add(arrayList1);
      }  
    GetDOMStorageItemsResult getDOMStorageItemsResult = new GetDOMStorageItemsResult();
    getDOMStorageItemsResult.entries = (List)arrayList;
    return getDOMStorageItemsResult;
  }
  
  @ChromeDevtoolsMethod
  public void removeDOMStorageItem(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) throws JSONException {
    StorageId storageId = (StorageId)this.mObjectMapper.convertValue(paramJSONObject.getJSONObject("storageId"), StorageId.class);
    String str = paramJSONObject.getString("key");
    if (storageId.isLocalStorage)
      this.mContext.getSharedPreferences(storageId.securityOrigin, 0).edit().remove(str).apply(); 
  }
  
  @ChromeDevtoolsMethod
  public void setDOMStorageItem(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) throws JSONException, JsonRpcException {
    StorageId storageId = (StorageId)this.mObjectMapper.convertValue(paramJSONObject.getJSONObject("storageId"), StorageId.class);
    String str2 = paramJSONObject.getString("key");
    String str1 = paramJSONObject.getString("value");
    if (storageId.isLocalStorage) {
      SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(storageId.securityOrigin, 0);
      Object object = sharedPreferences.getAll().get(str2);
      if (object != null) {
        try {
          SharedPreferences.Editor editor = sharedPreferences.edit();
          try {
            assignByType(editor, str2, SharedPreferencesHelper.valueFromString(str1, object));
            editor.apply();
            return;
          } catch (IllegalArgumentException illegalArgumentException) {
            throw new DOMStorageAssignmentException(String.format(Locale.US, "Type mismatch setting %s to %s (expected %s)", new Object[] { str2, str1, object.getClass().getSimpleName() }));
          } 
        } catch (DOMStorageAssignmentException dOMStorageAssignmentException) {
          CLog.writeToConsole((ChromePeerManager)this.mDOMStoragePeerManager, Console.MessageLevel.ERROR, Console.MessageSource.STORAGE, dOMStorageAssignmentException.getMessage());
          if (sharedPreferences.contains(str2)) {
            this.mDOMStoragePeerManager.signalItemUpdated(storageId, str2, str1, SharedPreferencesHelper.valueToString(object));
            return;
          } 
          this.mDOMStoragePeerManager.signalItemRemoved(storageId, str2);
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported: cannot add new key ");
        stringBuilder.append(str2);
        stringBuilder.append(" due to lack of type inference");
        throw new DOMStorageAssignmentException(stringBuilder.toString());
      } 
    } 
  }
  
  static class DOMStorageAssignmentException extends Exception {
    public DOMStorageAssignmentException(String param1String) {
      super(param1String);
    }
  }
  
  public static class DomStorageItemAddedParams {
    @JsonProperty(required = true)
    public String key;
    
    @JsonProperty(required = true)
    public String newValue;
    
    @JsonProperty(required = true)
    public DOMStorage.StorageId storageId;
  }
  
  public static class DomStorageItemRemovedParams {
    @JsonProperty(required = true)
    public String key;
    
    @JsonProperty(required = true)
    public DOMStorage.StorageId storageId;
  }
  
  public static class DomStorageItemUpdatedParams {
    @JsonProperty(required = true)
    public String key;
    
    @JsonProperty(required = true)
    public String newValue;
    
    @JsonProperty(required = true)
    public String oldValue;
    
    @JsonProperty(required = true)
    public DOMStorage.StorageId storageId;
  }
  
  public static class DomStorageItemsClearedParams {
    @JsonProperty(required = true)
    public DOMStorage.StorageId storageId;
  }
  
  static class GetDOMStorageItemsResult implements JsonRpcResult {
    @JsonProperty(required = true)
    public List<List<String>> entries;
    
    private GetDOMStorageItemsResult() {}
  }
  
  public static class StorageId {
    @JsonProperty(required = true)
    public boolean isLocalStorage;
    
    @JsonProperty(required = true)
    public String securityOrigin;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\DOMStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */