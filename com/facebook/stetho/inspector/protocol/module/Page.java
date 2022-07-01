package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import com.facebook.stetho.common.ProcessUtil;
import com.facebook.stetho.inspector.domstorage.SharedPreferencesHelper;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.screencast.ScreencastDispatcher;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class Page implements ChromeDevtoolsDomain {
  private final Context mContext;
  
  private final ObjectMapper mObjectMapper = new ObjectMapper();
  
  private ScreencastDispatcher mScreencastDispatcher;
  
  public Page(Context paramContext) {
    this.mContext = paramContext;
  }
  
  private static FrameResourceTree createSimpleFrameResourceTree(String paramString1, String paramString2, String paramString3, String paramString4) {
    Frame frame = new Frame();
    frame.id = paramString1;
    frame.parentId = paramString2;
    frame.loaderId = "1";
    frame.name = paramString3;
    frame.url = "";
    frame.securityOrigin = paramString4;
    frame.mimeType = "text/plain";
    FrameResourceTree frameResourceTree = new FrameResourceTree();
    frameResourceTree.frame = frame;
    frameResourceTree.resources = Collections.emptyList();
    frameResourceTree.childFrames = null;
    return frameResourceTree;
  }
  
  private void notifyExecutionContexts(JsonRpcPeer paramJsonRpcPeer) {
    ExecutionContextDescription executionContextDescription = new ExecutionContextDescription();
    executionContextDescription.frameId = "1";
    executionContextDescription.id = 1;
    ExecutionContextCreatedParams executionContextCreatedParams = new ExecutionContextCreatedParams();
    executionContextCreatedParams.context = executionContextDescription;
    paramJsonRpcPeer.invokeMethod("Runtime.executionContextCreated", executionContextCreatedParams, null);
  }
  
  private void sendWelcomeMessage(JsonRpcPeer paramJsonRpcPeer) {
    Console.ConsoleMessage consoleMessage = new Console.ConsoleMessage();
    consoleMessage.source = Console.MessageSource.JAVASCRIPT;
    consoleMessage.level = Console.MessageLevel.LOG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("_____/\\\\\\\\\\\\\\\\\\\\\\_______________________________________________/\\\\\\_______________________\n ___/\\\\\\/////////\\\\\\____________________________________________\\/\\\\\\_______________________\n  __\\//\\\\\\______\\///______/\\\\\\_________________________/\\\\\\______\\/\\\\\\_______________________\n   ___\\////\\\\\\__________/\\\\\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\\\\\\\___/\\\\\\\\\\\\\\\\\\\\\\_\\/\\\\\\_____________/\\\\\\\\\\____\n    ______\\////\\\\\\______\\////\\\\\\////____/\\\\\\/////\\\\\\_\\////\\\\\\////__\\/\\\\\\\\\\\\\\\\\\\\____/\\\\\\///\\\\\\__\n     _________\\////\\\\\\______\\/\\\\\\_______/\\\\\\\\\\\\\\\\\\\\\\_____\\/\\\\\\______\\/\\\\\\/////\\\\\\__/\\\\\\__\\//\\\\\\_\n      __/\\\\\\______\\//\\\\\\_____\\/\\\\\\_/\\\\__\\//\\\\///////______\\/\\\\\\_/\\\\__\\/\\\\\\___\\/\\\\\\_\\//\\\\\\__/\\\\\\__\n       _\\///\\\\\\\\\\\\\\\\\\\\\\/______\\//\\\\\\\\\\____\\//\\\\\\\\\\\\\\\\\\\\____\\//\\\\\\\\\\___\\/\\\\\\___\\/\\\\\\__\\///\\\\\\\\\\/___\n        ___\\///////////_________\\/////______\\//////////______\\/////____\\///____\\///_____\\/////_____\n         Welcome to Stetho\n          Attached to ");
    stringBuilder.append(ProcessUtil.getProcessName());
    stringBuilder.append("\n");
    consoleMessage.text = stringBuilder.toString();
    Console.MessageAddedRequest messageAddedRequest = new Console.MessageAddedRequest();
    messageAddedRequest.message = consoleMessage;
    paramJsonRpcPeer.invokeMethod("Console.messageAdded", messageAddedRequest, null);
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult canScreencast(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    return new SimpleBooleanResult(true);
  }
  
  @ChromeDevtoolsMethod
  public void clearDeviceOrientationOverride(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void clearGeolocationOverride(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    notifyExecutionContexts(paramJsonRpcPeer);
    sendWelcomeMessage(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getResourceTree(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    String str;
    Iterator<String> iterator = SharedPreferencesHelper.getSharedPreferenceTags(this.mContext).iterator();
    if (iterator.hasNext()) {
      str = iterator.next();
    } else {
      str = "";
    } 
    FrameResourceTree frameResourceTree = createSimpleFrameResourceTree("1", null, "Stetho", str);
    if (frameResourceTree.childFrames == null)
      frameResourceTree.childFrames = new ArrayList<FrameResourceTree>(); 
    for (int i = 1; iterator.hasNext(); i++) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("1.");
      stringBuilder1.append(i);
      String str1 = stringBuilder1.toString();
      String str2 = iterator.next();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Child #");
      stringBuilder2.append(str1);
      FrameResourceTree frameResourceTree1 = createSimpleFrameResourceTree(str1, "1", stringBuilder2.toString(), str2);
      frameResourceTree.childFrames.add(frameResourceTree1);
    } 
    GetResourceTreeParams getResourceTreeParams = new GetResourceTreeParams();
    getResourceTreeParams.frameTree = frameResourceTree;
    return getResourceTreeParams;
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult hasTouchInputs(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    return new SimpleBooleanResult(false);
  }
  
  @ChromeDevtoolsMethod
  public void screencastFrameAck(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void setDeviceMetricsOverride(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void setEmulatedMedia(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void setShowViewportSizeOnResize(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void setTouchEmulationEnabled(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void startScreencast(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    StartScreencastRequest startScreencastRequest = (StartScreencastRequest)this.mObjectMapper.convertValue(paramJSONObject, StartScreencastRequest.class);
    if (this.mScreencastDispatcher == null) {
      this.mScreencastDispatcher = new ScreencastDispatcher();
      this.mScreencastDispatcher.startScreencast(paramJsonRpcPeer, startScreencastRequest);
    } 
  }
  
  @ChromeDevtoolsMethod
  public void stopScreencast(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    ScreencastDispatcher screencastDispatcher = this.mScreencastDispatcher;
    if (screencastDispatcher != null) {
      screencastDispatcher.stopScreencast();
      this.mScreencastDispatcher = null;
    } 
  }
  
  static class ExecutionContextCreatedParams {
    @JsonProperty(required = true)
    public Page.ExecutionContextDescription context;
    
    private ExecutionContextCreatedParams() {}
  }
  
  static class ExecutionContextDescription {
    @JsonProperty(required = true)
    public String frameId;
    
    @JsonProperty(required = true)
    public int id;
    
    private ExecutionContextDescription() {}
  }
  
  static class Frame {
    @JsonProperty(required = true)
    public String id;
    
    @JsonProperty(required = true)
    public String loaderId;
    
    @JsonProperty(required = true)
    public String mimeType;
    
    @JsonProperty
    public String name;
    
    @JsonProperty
    public String parentId;
    
    @JsonProperty(required = true)
    public String securityOrigin;
    
    @JsonProperty(required = true)
    public String url;
    
    private Frame() {}
  }
  
  static class FrameResourceTree {
    @JsonProperty
    public List<FrameResourceTree> childFrames;
    
    @JsonProperty(required = true)
    public Page.Frame frame;
    
    @JsonProperty(required = true)
    public List<Page.Resource> resources;
    
    private FrameResourceTree() {}
  }
  
  static class GetResourceTreeParams implements JsonRpcResult {
    @JsonProperty(required = true)
    public Page.FrameResourceTree frameTree;
    
    private GetResourceTreeParams() {}
  }
  
  static class Resource {}
  
  public enum ResourceType {
    DOCUMENT("Document"),
    FONT("Document"),
    IMAGE("Document"),
    OTHER("Document"),
    SCRIPT("Document"),
    STYLESHEET("Stylesheet"),
    WEBSOCKET("Stylesheet"),
    XHR("Stylesheet");
    
    private final String mProtocolValue;
    
    static {
      FONT = new ResourceType("FONT", 3, "Font");
      SCRIPT = new ResourceType("SCRIPT", 4, "Script");
      XHR = new ResourceType("XHR", 5, "XHR");
      WEBSOCKET = new ResourceType("WEBSOCKET", 6, "WebSocket");
      OTHER = new ResourceType("OTHER", 7, "Other");
      $VALUES = new ResourceType[] { DOCUMENT, STYLESHEET, IMAGE, FONT, SCRIPT, XHR, WEBSOCKET, OTHER };
    }
    
    ResourceType(String param1String1) {
      this.mProtocolValue = param1String1;
    }
    
    @JsonValue
    public String getProtocolValue() {
      return this.mProtocolValue;
    }
  }
  
  public static class ScreencastFrameEvent {
    @JsonProperty(required = true)
    public String data;
    
    @JsonProperty(required = true)
    public Page.ScreencastFrameEventMetadata metadata;
  }
  
  public static class ScreencastFrameEventMetadata {
    @JsonProperty(required = true)
    public int deviceHeight;
    
    @JsonProperty(required = true)
    public int deviceWidth;
    
    @JsonProperty(required = true)
    public int offsetTop;
    
    @JsonProperty(required = true)
    public int pageScaleFactor;
    
    @JsonProperty(required = true)
    public int scrollOffsetX;
    
    @JsonProperty(required = true)
    public int scrollOffsetY;
  }
  
  public static class StartScreencastRequest {
    @JsonProperty
    public String format;
    
    @JsonProperty
    public int maxHeight;
    
    @JsonProperty
    public int maxWidth;
    
    @JsonProperty
    public int quality;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\Page.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */