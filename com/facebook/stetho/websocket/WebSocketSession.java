package com.facebook.stetho.websocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class WebSocketSession implements SimpleSession {
  private final SimpleEndpoint mEndpoint;
  
  private final WriteCallback mErrorForwardingWriteCallback = new WriteCallback() {
      public void onFailure(IOException param1IOException) {
        WebSocketSession.this.signalError(param1IOException);
      }
      
      public void onSuccess() {}
    };
  
  private AtomicBoolean mIsOpen = new AtomicBoolean(false);
  
  private final ReadCallback mReadCallback = new ReadCallback() {
      private void handleBinaryFrame(byte[] param1ArrayOfbyte, int param1Int) {
        WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, param1ArrayOfbyte, param1Int);
      }
      
      private void handleClose(byte[] param1ArrayOfbyte, int param1Int) {
        String str;
        if (param1Int >= 2) {
          int i = (param1ArrayOfbyte[0] & 0xFF) << 8 | param1ArrayOfbyte[1] & 0xFF;
          if (param1Int > 2) {
            str = new String(param1ArrayOfbyte, 2, param1Int - 2);
            param1Int = i;
          } else {
            param1ArrayOfbyte = null;
            param1Int = i;
          } 
        } else {
          param1Int = 1006;
          str = "Unparseable close frame";
        } 
        if (!WebSocketSession.this.mSentClose)
          WebSocketSession.this.sendClose(1000, "Received close frame"); 
        WebSocketSession.this.markAndSignalClosed(param1Int, str);
      }
      
      private void handlePing(byte[] param1ArrayOfbyte, int param1Int) {
        WebSocketSession.this.doWrite(FrameHelper.createPongFrame(param1ArrayOfbyte, param1Int));
      }
      
      private void handlePong(byte[] param1ArrayOfbyte, int param1Int) {}
      
      private void handleTextFrame(byte[] param1ArrayOfbyte, int param1Int) {
        WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, new String(param1ArrayOfbyte, 0, param1Int));
      }
      
      public void onCompleteFrame(byte param1Byte, byte[] param1ArrayOfbyte, int param1Int) {
        WebSocketSession webSocketSession;
        if (param1Byte != 1) {
          if (param1Byte != 2) {
            StringBuilder stringBuilder;
            switch (param1Byte) {
              default:
                webSocketSession = WebSocketSession.this;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported frame opcode=");
                stringBuilder.append(param1Byte);
                webSocketSession.signalError(new IOException(stringBuilder.toString()));
                return;
              case 10:
                handlePong((byte[])webSocketSession, param1Int);
                return;
              case 9:
                handlePing((byte[])webSocketSession, param1Int);
                return;
              case 8:
                break;
            } 
            handleClose((byte[])webSocketSession, param1Int);
            return;
          } 
          handleBinaryFrame((byte[])webSocketSession, param1Int);
          return;
        } 
        handleTextFrame((byte[])webSocketSession, param1Int);
      }
    };
  
  private final ReadHandler mReadHandler;
  
  private volatile boolean mSentClose;
  
  private final WriteHandler mWriteHandler;
  
  public WebSocketSession(InputStream paramInputStream, OutputStream paramOutputStream, SimpleEndpoint paramSimpleEndpoint) {
    this.mReadHandler = new ReadHandler(paramInputStream, paramSimpleEndpoint);
    this.mWriteHandler = new WriteHandler(paramOutputStream);
    this.mEndpoint = paramSimpleEndpoint;
  }
  
  private void doWrite(Frame paramFrame) {
    if (signalErrorIfNotOpen())
      return; 
    this.mWriteHandler.write(paramFrame, this.mErrorForwardingWriteCallback);
  }
  
  private void sendClose(int paramInt, String paramString) {
    doWrite(FrameHelper.createCloseFrame(paramInt, paramString));
    markSentClose();
  }
  
  private void signalError(IOException paramIOException) {
    this.mEndpoint.onError(this, paramIOException);
  }
  
  private boolean signalErrorIfNotOpen() {
    if (!isOpen()) {
      signalError(new IOException("Session is closed"));
      return true;
    } 
    return false;
  }
  
  public void close(int paramInt, String paramString) {
    sendClose(paramInt, paramString);
    markAndSignalClosed(paramInt, paramString);
  }
  
  public void handle() throws IOException {
    markAndSignalOpen();
    try {
      this.mReadHandler.readLoop(this.mReadCallback);
      return;
    } catch (EOFException eOFException) {
      markAndSignalClosed(1011, "EOF while reading");
      return;
    } catch (IOException iOException) {
      markAndSignalClosed(1006, null);
      throw iOException;
    } 
  }
  
  public boolean isOpen() {
    return this.mIsOpen.get();
  }
  
  void markAndSignalClosed(int paramInt, String paramString) {
    if (this.mIsOpen.getAndSet(false))
      this.mEndpoint.onClose(this, paramInt, paramString); 
  }
  
  void markAndSignalOpen() {
    if (!this.mIsOpen.getAndSet(true))
      this.mEndpoint.onOpen(this); 
  }
  
  void markSentClose() {
    this.mSentClose = true;
  }
  
  public void sendBinary(byte[] paramArrayOfbyte) {
    doWrite(FrameHelper.createBinaryFrame(paramArrayOfbyte));
  }
  
  public void sendText(String paramString) {
    doWrite(FrameHelper.createTextFrame(paramString));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\websocket\WebSocketSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */