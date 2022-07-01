package com.blued.android.chat.core.worker.link;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import com.qiniu.android.dns.DnsManager;

public class SocketLinkerImpl extends AbstractLinkerImpl {
  private static final String TAG = "Chat_SocketLinker";
  
  private Object linkLock = new Object();
  
  private SocketThread managerThread;
  
  private void stopSocketThread() {
    if (this.managerThread != null) {
      if (ChatManager.debug)
        Log.v("Chat_SocketLinker", "stop managerThread"); 
      this.managerThread.setLinker((AbstractLinkerImpl)null);
      if (this.managerThread.isAlive()) {
        this.managerThread.notifyStop();
        try {
          this.managerThread.join(5000L);
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
        } 
      } 
      this.managerThread = null;
    } 
  }
  
  public void link(boolean paramBoolean) {
    if (ChatManager.debug)
      Log.v("Chat_SocketLinker", "link()"); 
    synchronized (this.linkLock) {
      int i = getState();
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("current state:");
        stringBuilder.append(i);
        Log.v("Chat_SocketLinker", stringBuilder.toString());
      } 
      if (i == 0 && !TextUtils.isEmpty(ChatManager.chatHostAddr) && ChatManager.chatHostPort > 0) {
        stopSocketThread();
        changeState(1);
        String str = ChatManager.chatHostAddr;
        i = ChatManager.chatHostPort;
        int j = ChatManager.chatBackupPort;
        DnsManager dnsManager = ChatManager.dnsManager;
        if (paramBoolean) {
          if (!ChatManager.isDnsManagerPrior) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          } 
        } else {
          paramBoolean = ChatManager.isDnsManagerPrior;
        } 
        this.managerThread = new SocketThread(str, i, j, dnsManager, paramBoolean, ChatManager.isSSL);
        this.managerThread.setLinker(this);
        this.managerThread.start();
      } 
      return;
    } 
  }
  
  public void notifyPackageHandler() {
    if (ChatManager.debug)
      Log.v("Chat_SocketLinker", "notifyPackageHandler()"); 
    synchronized (this.linkLock) {
      if (this.managerThread != null)
        this.managerThread.notifyPackage(); 
      return;
    } 
  }
  
  public void release() {
    if (ChatManager.debug)
      Log.v("Chat_SocketLinker", "release()"); 
    super.release();
    synchronized (this.linkLock) {
      stopSocketThread();
      changeState(0);
      return;
    } 
  }
  
  public void relink(boolean paramBoolean) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("relink(), useBackupLink:");
      stringBuilder.append(paramBoolean);
      Log.v("Chat_SocketLinker", stringBuilder.toString());
    } 
    synchronized (this.linkLock) {
      stopSocketThread();
      if (!TextUtils.isEmpty(ChatManager.chatHostAddr) && ChatManager.chatHostPort > 0) {
        String str = ChatManager.chatHostAddr;
        int i = ChatManager.chatHostPort;
        int j = ChatManager.chatBackupPort;
        DnsManager dnsManager = ChatManager.dnsManager;
        if (paramBoolean) {
          if (!ChatManager.isDnsManagerPrior) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          } 
        } else {
          paramBoolean = ChatManager.isDnsManagerPrior;
        } 
        this.managerThread = new SocketThread(str, i, j, dnsManager, paramBoolean, ChatManager.isSSL);
        this.managerThread.setLinker(this);
        this.managerThread.start();
      } 
      return;
    } 
  }
  
  public void unlink() {
    if (ChatManager.debug)
      Log.v("Chat_SocketLinker", "unlink()"); 
    synchronized (this.linkLock) {
      stopSocketThread();
      changeState(0);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\link\SocketLinkerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */