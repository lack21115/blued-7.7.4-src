package com.blued.android.module.chat.manager;

import android.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.module.chat.contract.IChatRelationDataListener;
import java.util.List;
import java.util.Vector;

public class ChatRelationDataListenerManager {
  private static ChatRelationDataListenerManager instance;
  
  private String TAG = "@@@ module_chat_ChatRelationDataListenerManager";
  
  private List<IChatRelationDataListener> listeners = new Vector<IChatRelationDataListener>();
  
  public static ChatRelationDataListenerManager getInstance() {
    if (instance == null)
      instance = new ChatRelationDataListenerManager(); 
    return instance;
  }
  
  public void onDeleteSessions(final List<Pair<Short, Long>> deleteSessionPairs) {
    AppInfo.n().post(new Runnable() {
          public void run() {
            for (IChatRelationDataListener iChatRelationDataListener : ChatRelationDataListenerManager.this.listeners) {
              if (iChatRelationDataListener != null)
                iChatRelationDataListener.onDeleteSessions(deleteSessionPairs); 
            } 
          }
        });
  }
  
  public void registerChatRelationDataListener(IChatRelationDataListener paramIChatRelationDataListener) {
    if (paramIChatRelationDataListener != null && !this.listeners.contains(paramIChatRelationDataListener))
      this.listeners.add(paramIChatRelationDataListener); 
  }
  
  public void unRegisterChatRelationDataListener(IChatRelationDataListener paramIChatRelationDataListener) {
    if (paramIChatRelationDataListener != null && this.listeners.contains(paramIChatRelationDataListener))
      this.listeners.remove(paramIChatRelationDataListener); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\manager\ChatRelationDataListenerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */