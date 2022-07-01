package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.console.ConsolePeerManager;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import org.json.JSONObject;

public class Console implements ChromeDevtoolsDomain {
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    ConsolePeerManager.getOrCreateInstance().removePeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    ConsolePeerManager.getOrCreateInstance().addPeer(paramJsonRpcPeer);
  }
  
  public static class CallFrame {
    @JsonProperty(required = true)
    public int columnNumber;
    
    @JsonProperty(required = true)
    public String functionName;
    
    @JsonProperty(required = true)
    public int lineNumber;
    
    @JsonProperty(required = true)
    public String url;
    
    public CallFrame() {}
    
    public CallFrame(String param1String1, String param1String2, int param1Int1, int param1Int2) {
      this.functionName = param1String1;
      this.url = param1String2;
      this.lineNumber = param1Int1;
      this.columnNumber = param1Int2;
    }
  }
  
  public static class ConsoleMessage {
    @JsonProperty(required = true)
    public Console.MessageLevel level;
    
    @JsonProperty(required = true)
    public Console.MessageSource source;
    
    @JsonProperty(required = true)
    public String text;
  }
  
  public static class MessageAddedRequest {
    @JsonProperty(required = true)
    public Console.ConsoleMessage message;
  }
  
  public enum MessageLevel {
    DEBUG,
    ERROR,
    LOG("log"),
    WARNING("warning");
    
    private final String mProtocolValue;
    
    static {
      DEBUG = new MessageLevel("DEBUG", 3, "debug");
      $VALUES = new MessageLevel[] { LOG, WARNING, ERROR, DEBUG };
    }
    
    MessageLevel(String param1String1) {
      this.mProtocolValue = param1String1;
    }
    
    @JsonValue
    public String getProtocolValue() {
      return this.mProtocolValue;
    }
  }
  
  public enum MessageSource {
    XML("xml"),
    APPCACHE("warning"),
    CONSOLE_API("warning"),
    CSS("warning"),
    JAVASCRIPT("warning"),
    NETWORK("warning"),
    OTHER("warning"),
    RENDERING("warning"),
    SECURITY("warning"),
    STORAGE("warning");
    
    private final String mProtocolValue;
    
    static {
      CONSOLE_API = new MessageSource("CONSOLE_API", 3, "console-api");
      STORAGE = new MessageSource("STORAGE", 4, "storage");
      APPCACHE = new MessageSource("APPCACHE", 5, "appcache");
      RENDERING = new MessageSource("RENDERING", 6, "rendering");
      CSS = new MessageSource("CSS", 7, "css");
      SECURITY = new MessageSource("SECURITY", 8, "security");
      OTHER = new MessageSource("OTHER", 9, "other");
      $VALUES = new MessageSource[] { XML, JAVASCRIPT, NETWORK, CONSOLE_API, STORAGE, APPCACHE, RENDERING, CSS, SECURITY, OTHER };
    }
    
    MessageSource(String param1String1) {
      this.mProtocolValue = param1String1;
    }
    
    @JsonValue
    public String getProtocolValue() {
      return this.mProtocolValue;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\Console.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */