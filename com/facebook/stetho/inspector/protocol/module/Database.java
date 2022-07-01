package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class Database implements ChromeDevtoolsDomain {
  private static final int MAX_BLOB_LENGTH = 512;
  
  private static final int MAX_EXECUTE_RESULTS = 250;
  
  private static final String UNKNOWN_BLOB_LABEL = "{blob}";
  
  private final ChromePeerManager mChromePeerManager = new ChromePeerManager();
  
  private List<DatabaseDriver2> mDatabaseDrivers = new ArrayList<DatabaseDriver2>();
  
  private final ObjectMapper mObjectMapper;
  
  private final DatabasePeerRegistrationListener mPeerListener = new DatabasePeerRegistrationListener(this.mDatabaseDrivers);
  
  public Database() {
    this.mChromePeerManager.setListener((PeerRegistrationListener)this.mPeerListener);
    this.mObjectMapper = new ObjectMapper();
  }
  
  private static String blobToString(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte.length <= 512 && fastIsAscii(paramArrayOfbyte))
      try {
        return new String(paramArrayOfbyte, "US-ASCII");
      } catch (UnsupportedEncodingException unsupportedEncodingException) {} 
    return "{blob}";
  }
  
  private static boolean fastIsAscii(byte[] paramArrayOfbyte) {
    int j = paramArrayOfbyte.length;
    for (int i = 0; i < j; i++) {
      if ((paramArrayOfbyte[i] & Byte.MIN_VALUE) != 0)
        return false; 
    } 
    return true;
  }
  
  private static ArrayList<String> flattenRows(Cursor paramCursor, int paramInt) {
    boolean bool2;
    boolean bool1 = false;
    if (paramInt >= 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Util.throwIfNot(bool2);
    ArrayList<String> arrayList = new ArrayList();
    int j = paramCursor.getColumnCount();
    for (int i = 0; i < paramInt && paramCursor.moveToNext(); i++) {
      for (int k = 0; k < j; k++) {
        int m = paramCursor.getType(k);
        if (m != 0) {
          if (m != 1) {
            if (m != 2) {
              if (m != 4) {
                arrayList.add(paramCursor.getString(k));
              } else {
                arrayList.add(blobToString(paramCursor.getBlob(k)));
              } 
            } else {
              arrayList.add(String.valueOf(paramCursor.getDouble(k)));
            } 
          } else {
            arrayList.add(String.valueOf(paramCursor.getLong(k)));
          } 
        } else {
          arrayList.add(null);
        } 
      } 
    } 
    if (!paramCursor.isAfterLast())
      for (paramInt = bool1; paramInt < j; paramInt++)
        arrayList.add("{truncated}");  
    return arrayList;
  }
  
  public void add(DatabaseDriver2 paramDatabaseDriver2) {
    this.mDatabaseDrivers.add(paramDatabaseDriver2);
  }
  
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    this.mChromePeerManager.removePeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    this.mChromePeerManager.addPeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult executeSQL(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    ExecuteSQLRequest executeSQLRequest = (ExecuteSQLRequest)this.mObjectMapper.convertValue(paramJSONObject, ExecuteSQLRequest.class);
    DatabaseDescriptorHolder databaseDescriptorHolder = this.mPeerListener.getDatabaseDescriptorHolder(executeSQLRequest.databaseId);
    try {
      return databaseDescriptorHolder.driver.executeSQL(databaseDescriptorHolder.descriptor, executeSQLRequest.query, new BaseDatabaseDriver.ExecuteResultHandler<ExecuteSQLResponse>() {
            public Database.ExecuteSQLResponse handleInsert(long param1Long) throws SQLiteException {
              Database.ExecuteSQLResponse executeSQLResponse = new Database.ExecuteSQLResponse();
              executeSQLResponse.columnNames = Collections.singletonList("ID of last inserted row");
              executeSQLResponse.values = Collections.singletonList(String.valueOf(param1Long));
              return executeSQLResponse;
            }
            
            public Database.ExecuteSQLResponse handleRawQuery() throws SQLiteException {
              Database.ExecuteSQLResponse executeSQLResponse = new Database.ExecuteSQLResponse();
              executeSQLResponse.columnNames = Collections.singletonList("success");
              executeSQLResponse.values = Collections.singletonList("true");
              return executeSQLResponse;
            }
            
            public Database.ExecuteSQLResponse handleSelect(Cursor param1Cursor) throws SQLiteException {
              Database.ExecuteSQLResponse executeSQLResponse = new Database.ExecuteSQLResponse();
              executeSQLResponse.columnNames = Arrays.asList(param1Cursor.getColumnNames());
              executeSQLResponse.values = Database.flattenRows(param1Cursor, 250);
              return executeSQLResponse;
            }
            
            public Database.ExecuteSQLResponse handleUpdateDelete(int param1Int) throws SQLiteException {
              Database.ExecuteSQLResponse executeSQLResponse = new Database.ExecuteSQLResponse();
              executeSQLResponse.columnNames = Collections.singletonList("Modified rows");
              executeSQLResponse.values = Collections.singletonList(String.valueOf(param1Int));
              return executeSQLResponse;
            }
          });
    } catch (RuntimeException runtimeException) {
      LogUtil.e(runtimeException, "Exception executing: %s", new Object[] { executeSQLRequest.query });
      Error error = new Error();
      error.code = 0;
      error.message = runtimeException.getMessage();
      ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
      executeSQLResponse.sqlError = error;
      return executeSQLResponse;
    } 
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getDatabaseTableNames(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) throws JsonRpcException {
    String str = ((GetDatabaseTableNamesRequest)this.mObjectMapper.convertValue(paramJSONObject, GetDatabaseTableNamesRequest.class)).databaseId;
    DatabaseDescriptorHolder databaseDescriptorHolder = this.mPeerListener.getDatabaseDescriptorHolder(str);
    try {
      GetDatabaseTableNamesResponse getDatabaseTableNamesResponse = new GetDatabaseTableNamesResponse();
      getDatabaseTableNamesResponse.tableNames = databaseDescriptorHolder.driver.getTableNames(databaseDescriptorHolder.descriptor);
      return getDatabaseTableNamesResponse;
    } catch (SQLiteException sQLiteException) {
      throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INVALID_REQUEST, sQLiteException.toString(), null));
    } 
  }
  
  public static class AddDatabaseEvent {
    @JsonProperty(required = true)
    public Database.DatabaseObject database;
  }
  
  static class DatabaseDescriptorHolder {
    public final DatabaseDescriptor descriptor;
    
    public final DatabaseDriver2 driver;
    
    public DatabaseDescriptorHolder(DatabaseDriver2 param1DatabaseDriver2, DatabaseDescriptor param1DatabaseDescriptor) {
      this.driver = param1DatabaseDriver2;
      this.descriptor = param1DatabaseDescriptor;
    }
  }
  
  @Deprecated
  public static abstract class DatabaseDriver extends BaseDatabaseDriver<String> {
    public DatabaseDriver(Context param1Context) {
      super(param1Context);
    }
  }
  
  public static class DatabaseObject {
    @JsonProperty(required = true)
    public String domain;
    
    @JsonProperty(required = true)
    public String id;
    
    @JsonProperty(required = true)
    public String name;
    
    @JsonProperty(required = true)
    public String version;
  }
  
  static class DatabasePeerRegistrationListener extends PeersRegisteredListener {
    private final List<DatabaseDriver2> mDatabaseDrivers;
    
    private final SparseArray<Database.DatabaseDescriptorHolder> mDatabaseHolders = new SparseArray();
    
    private final ObjectIdMapper mDatabaseIdMapper = new ObjectIdMapper();
    
    private DatabasePeerRegistrationListener(List<DatabaseDriver2> param1List) {
      this.mDatabaseDrivers = param1List;
    }
    
    public Database.DatabaseDescriptorHolder getDatabaseDescriptorHolder(String param1String) {
      return (Database.DatabaseDescriptorHolder)this.mDatabaseHolders.get(Integer.parseInt(param1String));
    }
    
    public void onFirstPeerRegistered() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield mDatabaseDrivers : Ljava/util/List;
      //   6: invokeinterface iterator : ()Ljava/util/Iterator;
      //   11: astore_2
      //   12: aload_2
      //   13: invokeinterface hasNext : ()Z
      //   18: ifeq -> 113
      //   21: aload_2
      //   22: invokeinterface next : ()Ljava/lang/Object;
      //   27: checkcast com/facebook/stetho/inspector/protocol/module/DatabaseDriver2
      //   30: astore_3
      //   31: aload_3
      //   32: invokevirtual getDatabaseNames : ()Ljava/util/List;
      //   35: invokeinterface iterator : ()Ljava/util/Iterator;
      //   40: astore #4
      //   42: aload #4
      //   44: invokeinterface hasNext : ()Z
      //   49: ifeq -> 12
      //   52: aload #4
      //   54: invokeinterface next : ()Ljava/lang/Object;
      //   59: checkcast com/facebook/stetho/inspector/protocol/module/DatabaseDescriptor
      //   62: astore #5
      //   64: aload_0
      //   65: getfield mDatabaseIdMapper : Lcom/facebook/stetho/inspector/helper/ObjectIdMapper;
      //   68: aload #5
      //   70: invokevirtual getIdForObject : (Ljava/lang/Object;)Ljava/lang/Integer;
      //   73: ifnonnull -> 42
      //   76: aload_0
      //   77: getfield mDatabaseIdMapper : Lcom/facebook/stetho/inspector/helper/ObjectIdMapper;
      //   80: aload #5
      //   82: invokevirtual putObject : (Ljava/lang/Object;)I
      //   85: istore_1
      //   86: aload_0
      //   87: getfield mDatabaseHolders : Landroid/util/SparseArray;
      //   90: iload_1
      //   91: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   94: invokevirtual intValue : ()I
      //   97: new com/facebook/stetho/inspector/protocol/module/Database$DatabaseDescriptorHolder
      //   100: dup
      //   101: aload_3
      //   102: aload #5
      //   104: invokespecial <init> : (Lcom/facebook/stetho/inspector/protocol/module/DatabaseDriver2;Lcom/facebook/stetho/inspector/protocol/module/DatabaseDescriptor;)V
      //   107: invokevirtual put : (ILjava/lang/Object;)V
      //   110: goto -> 42
      //   113: aload_0
      //   114: monitorexit
      //   115: return
      //   116: astore_2
      //   117: aload_0
      //   118: monitorexit
      //   119: aload_2
      //   120: athrow
      // Exception table:
      //   from	to	target	type
      //   2	12	116	finally
      //   12	42	116	finally
      //   42	110	116	finally
    }
    
    public void onLastPeerUnregistered() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield mDatabaseIdMapper : Lcom/facebook/stetho/inspector/helper/ObjectIdMapper;
      //   6: invokevirtual clear : ()V
      //   9: aload_0
      //   10: getfield mDatabaseHolders : Landroid/util/SparseArray;
      //   13: invokevirtual clear : ()V
      //   16: aload_0
      //   17: monitorexit
      //   18: return
      //   19: astore_1
      //   20: aload_0
      //   21: monitorexit
      //   22: aload_1
      //   23: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	19	finally
    }
    
    public void onPeerAdded(JsonRpcPeer param1JsonRpcPeer) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iconst_0
      //   3: istore_2
      //   4: aload_0
      //   5: getfield mDatabaseHolders : Landroid/util/SparseArray;
      //   8: invokevirtual size : ()I
      //   11: istore_3
      //   12: iload_2
      //   13: iload_3
      //   14: if_icmpge -> 129
      //   17: aload_0
      //   18: getfield mDatabaseHolders : Landroid/util/SparseArray;
      //   21: iload_2
      //   22: invokevirtual keyAt : (I)I
      //   25: istore #4
      //   27: aload_0
      //   28: getfield mDatabaseHolders : Landroid/util/SparseArray;
      //   31: iload_2
      //   32: invokevirtual valueAt : (I)Ljava/lang/Object;
      //   35: checkcast com/facebook/stetho/inspector/protocol/module/Database$DatabaseDescriptorHolder
      //   38: astore #6
      //   40: new com/facebook/stetho/inspector/protocol/module/Database$DatabaseObject
      //   43: dup
      //   44: invokespecial <init> : ()V
      //   47: astore #5
      //   49: aload #5
      //   51: iload #4
      //   53: invokestatic valueOf : (I)Ljava/lang/String;
      //   56: putfield id : Ljava/lang/String;
      //   59: aload #5
      //   61: aload #6
      //   63: getfield descriptor : Lcom/facebook/stetho/inspector/protocol/module/DatabaseDescriptor;
      //   66: invokeinterface name : ()Ljava/lang/String;
      //   71: putfield name : Ljava/lang/String;
      //   74: aload #5
      //   76: aload #6
      //   78: getfield driver : Lcom/facebook/stetho/inspector/protocol/module/DatabaseDriver2;
      //   81: invokevirtual getContext : ()Landroid/content/Context;
      //   84: invokevirtual getPackageName : ()Ljava/lang/String;
      //   87: putfield domain : Ljava/lang/String;
      //   90: aload #5
      //   92: ldc 'N/A'
      //   94: putfield version : Ljava/lang/String;
      //   97: new com/facebook/stetho/inspector/protocol/module/Database$AddDatabaseEvent
      //   100: dup
      //   101: invokespecial <init> : ()V
      //   104: astore #6
      //   106: aload #6
      //   108: aload #5
      //   110: putfield database : Lcom/facebook/stetho/inspector/protocol/module/Database$DatabaseObject;
      //   113: aload_1
      //   114: ldc 'Database.addDatabase'
      //   116: aload #6
      //   118: aconst_null
      //   119: invokevirtual invokeMethod : (Ljava/lang/String;Ljava/lang/Object;Lcom/facebook/stetho/inspector/jsonrpc/PendingRequestCallback;)V
      //   122: iload_2
      //   123: iconst_1
      //   124: iadd
      //   125: istore_2
      //   126: goto -> 12
      //   129: aload_0
      //   130: monitorexit
      //   131: return
      //   132: astore_1
      //   133: aload_0
      //   134: monitorexit
      //   135: aload_1
      //   136: athrow
      // Exception table:
      //   from	to	target	type
      //   4	12	132	finally
      //   17	122	132	finally
    }
    
    public void onPeerRemoved(JsonRpcPeer param1JsonRpcPeer) {
      /* monitor enter ThisExpression{InnerObjectType{ObjectType{com/facebook/stetho/inspector/protocol/module/Database}.Lcom/facebook/stetho/inspector/protocol/module/Database$DatabasePeerRegistrationListener;}} */
      /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/facebook/stetho/inspector/protocol/module/Database}.Lcom/facebook/stetho/inspector/protocol/module/Database$DatabasePeerRegistrationListener;}} */
    }
  }
  
  public static class Error {
    @JsonProperty(required = true)
    public int code;
    
    @JsonProperty(required = true)
    public String message;
  }
  
  public static class ExecuteSQLRequest {
    @JsonProperty(required = true)
    public String databaseId;
    
    @JsonProperty(required = true)
    public String query;
  }
  
  public static class ExecuteSQLResponse implements JsonRpcResult {
    @JsonProperty
    public List<String> columnNames;
    
    @JsonProperty
    public Database.Error sqlError;
    
    @JsonProperty
    public List<String> values;
  }
  
  static class GetDatabaseTableNamesRequest {
    @JsonProperty(required = true)
    public String databaseId;
  }
  
  static class GetDatabaseTableNamesResponse implements JsonRpcResult {
    @JsonProperty(required = true)
    public List<String> tableNames;
    
    private GetDatabaseTableNamesResponse() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\Database.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */