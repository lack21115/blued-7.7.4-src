package com.blued.android.chat.core.pack;

import android.util.SparseArray;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.utils.BytesUtils;

public class BasePackage {
  public static final int CURRENT_VERSION = 3;
  
  public static final int MAX_HEADER_LENGTH = 6;
  
  public static final int MIN_HEADER_LENGTH = 1;
  
  public static final int PACKAGE_TIMEOUT_MAX_MS = 60000;
  
  public static final int PACKAGE_TIMEOUT_MS = 30000;
  
  private static final String TAG = "Chat_BasePackage";
  
  static SparseArray<Class<? extends BasePackage>> packageRecvAckMap;
  
  static SparseArray<Class<? extends BasePackage>> packageRecvMap = new SparseArray();
  
  public boolean ack = false;
  
  public boolean hasPayLoads = false;
  
  public long localId = 0L;
  
  public int msgBodyLength = 0;
  
  public boolean needAck = false;
  
  public long sendTime = 0L;
  
  public boolean sync = false;
  
  public short type = -1;
  
  public short version = 0;
  
  static {
    packageRecvMap.put(2, PingPackage.class);
    packageRecvMap.put(4, PushBasePackage.class);
    packageRecvMap.put(13, BasePackage.class);
    packageRecvMap.put(14, DisconnectPackage.class);
    packageRecvAckMap = new SparseArray();
    packageRecvAckMap.put(1, ConnAckPackage.class);
    packageRecvAckMap.put(3, SendAckPackage.class);
    packageRecvAckMap.put(5, SyncAckPackage.class);
    packageRecvAckMap.put(7, ReqAckPackage.class);
    packageRecvAckMap.put(6, DeleteAckPackage.class);
    packageRecvAckMap.put(2, PingPackage.class);
    packageRecvAckMap.put(14, BasePackage.class);
  }
  
  protected BasePackage() {
    this.version = 3;
  }
  
  public static BasePackage createEmptyHeader() {
    return new BasePackage();
  }
  
  private static Class<? extends BasePackage> getRecvPackTypeClass(BasePackage paramBasePackage) {
    return paramBasePackage.ack ? (Class<? extends BasePackage>)packageRecvAckMap.get(paramBasePackage.type) : (Class<? extends BasePackage>)packageRecvMap.get(paramBasePackage.type);
  }
  
  public static BasePackage parseMsgBody(BasePackage paramBasePackage, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Class<? extends BasePackage> clazz = getRecvPackTypeClass(paramBasePackage);
    if (clazz != null) {
      try {
        BasePackage basePackage = clazz.newInstance();
        basePackage.copyHeader(paramBasePackage);
        if (paramArrayOfbyte != null)
          basePackage.parseMsgData(paramArrayOfbyte, paramInt1, paramInt2); 
        return basePackage;
      } catch (Exception exception) {
        exception.printStackTrace();
        if (ChatManager.debug)
          Log.e("Chat_BasePackage", "parse pack exception", exception); 
      } 
    } else if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("can't get packClass for header:");
      stringBuilder.append(exception);
      Log.e("Chat_BasePackage", stringBuilder.toString());
    } 
    return null;
  }
  
  public static BasePackage parseToPack(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws PackException {
    BasePackage basePackage = new BasePackage();
    int i = basePackage.parseHeader(paramArrayOfbyte, paramInt1, paramInt2);
    return (basePackage.hasPayLoads && basePackage.msgBodyLength > 0) ? parseMsgBody(basePackage, paramArrayOfbyte, paramInt1 + i, paramInt2) : basePackage;
  }
  
  public static String typeToString(BasePackage paramBasePackage) {
    short s = paramBasePackage.type;
    if (s != 13) {
      if (s != 14) {
        StringBuilder stringBuilder;
        switch (s) {
          default:
            stringBuilder = new StringBuilder();
            stringBuilder.append("unknown(");
            stringBuilder.append(paramBasePackage.type);
            stringBuilder.append(")");
            return stringBuilder.toString();
          case 7:
            return "req";
          case 6:
            return "delete";
          case 5:
            if (paramBasePackage instanceof SyncBasePackage) {
              s = ((SyncBasePackage)paramBasePackage).getSyncType();
              if (s != 1) {
                if (s != 2) {
                  if (s != 3) {
                    if (s == 4)
                      return "sync_later"; 
                  } else {
                    return "sync_range";
                  } 
                } else {
                  return "sync_new";
                } 
              } else {
                return "sync_all";
              } 
            } 
            return "sync";
          case 4:
            return "push";
          case 3:
            return "send";
          case 2:
            return "ping";
          case 1:
            break;
        } 
        return "connect";
      } 
      return "disconnect";
    } 
    return "reconnect";
  }
  
  public void copyHeader(BasePackage paramBasePackage) {
    this.type = paramBasePackage.type;
    this.hasPayLoads = paramBasePackage.hasPayLoads;
    this.sync = paramBasePackage.sync;
    this.ack = paramBasePackage.ack;
    this.needAck = paramBasePackage.needAck;
    this.version = paramBasePackage.version;
    this.msgBodyLength = paramBasePackage.msgBodyLength;
  }
  
  public final int getPackLength() {
    return this.hasPayLoads ? (this.msgBodyLength + 6) : 1;
  }
  
  protected BytesData msgDataToByte() {
    return null;
  }
  
  public void parseFixHeader(byte paramByte) {
    this.type = (short)((paramByte & 0xFF) >> 4);
    boolean bool2 = false;
    if ((paramByte & 0x8) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.hasPayLoads = bool1;
    if ((paramByte & 0x4) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.sync = bool1;
    if ((paramByte & 0x2) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.ack = bool1;
    boolean bool1 = bool2;
    if ((paramByte & 0x1) > 0)
      bool1 = true; 
    this.needAck = bool1;
  }
  
  public int parseHeader(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws PackException {
    parseFixHeader(paramArrayOfbyte[paramInt1]);
    int i = paramInt1 + 1;
    paramInt2 = i;
    if (this.hasPayLoads)
      paramInt2 = i + parsePayLoadsHeader(paramArrayOfbyte, i); 
    return paramInt2 - paramInt1;
  }
  
  protected void parseMsgData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws PackException {}
  
  public int parsePayLoadsHeader(byte[] paramArrayOfbyte, int paramInt) throws UnsupportedVersionException {
    this.version = BytesUtils.byteTo1Number(paramArrayOfbyte, paramInt);
    int i = paramInt + 1;
    this.msgBodyLength = (int)BytesUtils.bytesTo4Number(paramArrayOfbyte, i);
    short s = this.version;
    if (s == 3)
      return i + 4 - paramInt; 
    throw new UnsupportedVersionException(s);
  }
  
  public BytesData toBype() {
    int i;
    boolean bool;
    BytesData bytesData1 = msgDataToByte();
    if (bytesData1 == null) {
      i = 0;
    } else {
      i = bytesData1.length;
    } 
    if (i > 0) {
      bool = i + 6;
    } else {
      bool = true;
    } 
    BytesData bytesData2 = new BytesData((short)bool);
    bytesData2.data[0] = (byte)(this.type << 4);
    if (this.sync)
      bytesData2.data[0] = (byte)(bytesData2.data[0] | 0x4); 
    if (this.ack)
      bytesData2.data[0] = (byte)(bytesData2.data[0] | 0x2); 
    if (this.needAck)
      bytesData2.data[0] = (byte)(bytesData2.data[0] | 0x1); 
    if (i > 0) {
      bytesData2.data[0] = (byte)(bytesData2.data[0] | 0x8);
      BytesUtils.numberTo1Byte(bytesData2.data, 1, this.version);
      BytesUtils.numberTo4Bytes(bytesData2.data, 2, i);
      BytesUtils.copy(bytesData1.data, 0, bytesData2.data, 6, bytesData1.length);
      i = bytesData1.length;
    } 
    return bytesData2;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[type:");
    stringBuilder.append(typeToString(this));
    stringBuilder.append(", ack:");
    stringBuilder.append(this.ack);
    stringBuilder.append(", needAck:");
    stringBuilder.append(this.needAck);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public static class PackException extends Exception {
    public PackException() {
      super("unknown packexception");
    }
    
    public PackException(String param1String) {
      super(param1String);
    }
  }
  
  public static interface TYPE {
    public static final int CONNECT = 1;
    
    public static final int DELETE = 6;
    
    public static final int DISCONNECT = 14;
    
    public static final int PING = 2;
    
    public static final int PUSH = 4;
    
    public static final int RECONNECT = 13;
    
    public static final int REQ = 7;
    
    public static final int SEND = 3;
    
    public static final int SYNC = 5;
    
    public static final int UNKNOWN = -1;
  }
  
  public static class UnsupportedVersionException extends PackException {
    public UnsupportedVersionException(short param1Short) {
      super(stringBuilder.toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\BasePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */