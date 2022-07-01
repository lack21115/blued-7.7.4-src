package com.blued.android.chat.core.worker.link;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;

public abstract class AbstractLinkerImpl {
  private static final String TAG = "Chat_AbstractLinker";
  
  protected LinkListener linkListener = null;
  
  protected IPackageQueue packageQueue;
  
  private boolean released = false;
  
  private int state;
  
  protected Object stateLocker = new Object();
  
  public static AbstractLinkerImpl createNewLinker(LinkListener paramLinkListener, IPackageQueue paramIPackageQueue) {
    SocketLinkerImpl socketLinkerImpl = new SocketLinkerImpl();
    socketLinkerImpl.registerLinkListener(paramLinkListener);
    socketLinkerImpl.registerPackageQueue(paramIPackageQueue);
    return socketLinkerImpl;
  }
  
  public static boolean isLinkerMatch(AbstractLinkerImpl paramAbstractLinkerImpl) {
    return (paramAbstractLinkerImpl instanceof SocketLinkerImpl);
  }
  
  private void unregisterLinkListener(LinkListener paramLinkListener) {
    if (this.linkListener == paramLinkListener)
      this.linkListener = null; 
  }
  
  protected void changeState(int paramInt) {
    synchronized (this.stateLocker) {
      int i = this.state;
      this.state = paramInt;
      if (i != paramInt) {
        null = this.linkListener;
        if (null != null)
          null.onLinkStateChanged(paramInt); 
      } 
      return;
    } 
  }
  
  public int getState() {
    synchronized (this.stateLocker) {
      return this.state;
    } 
  }
  
  public boolean isLinkFinished() {
    synchronized (this.stateLocker) {
      if (this.state == 3)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public boolean isReleased() {
    return this.released;
  }
  
  public void link() {
    link(false);
  }
  
  public abstract void link(boolean paramBoolean);
  
  public void linkAuthed() {
    changeState(3);
  }
  
  public abstract void notifyPackageHandler();
  
  protected void registerLinkListener(LinkListener paramLinkListener) {
    this.linkListener = paramLinkListener;
  }
  
  protected void registerPackageQueue(IPackageQueue paramIPackageQueue) {
    this.packageQueue = paramIPackageQueue;
  }
  
  public void release() {
    if (ChatManager.debug)
      Log.v("Chat_AbstractLinker", "release"); 
    this.released = true;
    this.linkListener = null;
    this.packageQueue = null;
  }
  
  public abstract void relink(boolean paramBoolean);
  
  public abstract void unlink();
  
  public static interface LinkState {
    public static final int AUTHED = 3;
    
    public static final int LINKED = 2;
    
    public static final int LINKING = 1;
    
    public static final int UNLINK = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\link\AbstractLinkerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */