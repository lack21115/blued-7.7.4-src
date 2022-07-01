package com.squareup.okhttp.internal.framed;

import java.util.Arrays;

public final class Settings {
  static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
  
  static final int COUNT = 10;
  
  static final int CURRENT_CWND = 5;
  
  static final int DEFAULT_INITIAL_WINDOW_SIZE = 65536;
  
  static final int DOWNLOAD_BANDWIDTH = 2;
  
  static final int DOWNLOAD_RETRANS_RATE = 6;
  
  static final int ENABLE_PUSH = 2;
  
  static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
  
  static final int FLOW_CONTROL_OPTIONS = 10;
  
  static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
  
  static final int HEADER_TABLE_SIZE = 1;
  
  static final int INITIAL_WINDOW_SIZE = 7;
  
  static final int MAX_CONCURRENT_STREAMS = 4;
  
  static final int MAX_FRAME_SIZE = 5;
  
  static final int MAX_HEADER_LIST_SIZE = 6;
  
  static final int PERSISTED = 2;
  
  static final int PERSIST_VALUE = 1;
  
  static final int ROUND_TRIP_TIME = 3;
  
  static final int UPLOAD_BANDWIDTH = 1;
  
  private int persistValue;
  
  private int persisted;
  
  private int set;
  
  private final int[] values = new int[10];
  
  void clear() {
    this.persisted = 0;
    this.persistValue = 0;
    this.set = 0;
    Arrays.fill(this.values, 0);
  }
  
  int flags(int paramInt) {
    byte b;
    if (isPersisted(paramInt)) {
      b = 2;
    } else {
      b = 0;
    } 
    int i = b;
    if (persistValue(paramInt))
      i = b | 0x1; 
    return i;
  }
  
  int get(int paramInt) {
    return this.values[paramInt];
  }
  
  int getClientCertificateVectorSize(int paramInt) {
    if ((this.set & 0x100) != 0)
      paramInt = this.values[8]; 
    return paramInt;
  }
  
  int getCurrentCwnd(int paramInt) {
    if ((this.set & 0x20) != 0)
      paramInt = this.values[5]; 
    return paramInt;
  }
  
  int getDownloadBandwidth(int paramInt) {
    if ((this.set & 0x4) != 0)
      paramInt = this.values[2]; 
    return paramInt;
  }
  
  int getDownloadRetransRate(int paramInt) {
    if ((this.set & 0x40) != 0)
      paramInt = this.values[6]; 
    return paramInt;
  }
  
  boolean getEnablePush(boolean paramBoolean) {
    int i = this.set;
    boolean bool = false;
    if ((i & 0x4) != 0) {
      i = this.values[2];
    } else if (paramBoolean) {
      i = 1;
    } else {
      i = 0;
    } 
    paramBoolean = bool;
    if (i == 1)
      paramBoolean = true; 
    return paramBoolean;
  }
  
  int getHeaderTableSize() {
    return ((this.set & 0x2) != 0) ? this.values[1] : -1;
  }
  
  int getInitialWindowSize(int paramInt) {
    if ((this.set & 0x80) != 0)
      paramInt = this.values[7]; 
    return paramInt;
  }
  
  int getMaxConcurrentStreams(int paramInt) {
    if ((this.set & 0x10) != 0)
      paramInt = this.values[4]; 
    return paramInt;
  }
  
  int getMaxFrameSize(int paramInt) {
    if ((this.set & 0x20) != 0)
      paramInt = this.values[5]; 
    return paramInt;
  }
  
  int getMaxHeaderListSize(int paramInt) {
    if ((this.set & 0x40) != 0)
      paramInt = this.values[6]; 
    return paramInt;
  }
  
  int getRoundTripTime(int paramInt) {
    if ((this.set & 0x8) != 0)
      paramInt = this.values[3]; 
    return paramInt;
  }
  
  int getUploadBandwidth(int paramInt) {
    if ((this.set & 0x2) != 0)
      paramInt = this.values[1]; 
    return paramInt;
  }
  
  boolean isFlowControlDisabled() {
    int i = this.set;
    boolean bool = false;
    if ((i & 0x400) != 0) {
      i = this.values[10];
    } else {
      i = 0;
    } 
    if ((i & 0x1) != 0)
      bool = true; 
    return bool;
  }
  
  boolean isPersisted(int paramInt) {
    return ((1 << paramInt & this.persisted) != 0);
  }
  
  boolean isSet(int paramInt) {
    return ((1 << paramInt & this.set) != 0);
  }
  
  void merge(Settings paramSettings) {
    for (int i = 0; i < 10; i++) {
      if (paramSettings.isSet(i))
        set(i, paramSettings.flags(i), paramSettings.get(i)); 
    } 
  }
  
  boolean persistValue(int paramInt) {
    return ((1 << paramInt & this.persistValue) != 0);
  }
  
  Settings set(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 >= this.values.length)
      return this; 
    int i = 1 << paramInt1;
    this.set |= i;
    if ((paramInt2 & 0x1) != 0) {
      this.persistValue |= i;
    } else {
      this.persistValue &= i;
    } 
    if ((paramInt2 & 0x2) != 0) {
      this.persisted |= i;
    } else {
      this.persisted &= i;
    } 
    this.values[paramInt1] = paramInt3;
    return this;
  }
  
  int size() {
    return Integer.bitCount(this.set);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\framed\Settings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */