package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class LocalBroadcastManager {
  private static final Object f = new Object();
  
  private static LocalBroadcastManager g;
  
  private final Context a;
  
  private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> b = new HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>>();
  
  private final HashMap<String, ArrayList<ReceiverRecord>> c = new HashMap<String, ArrayList<ReceiverRecord>>();
  
  private final ArrayList<BroadcastRecord> d = new ArrayList<BroadcastRecord>();
  
  private final Handler e;
  
  private LocalBroadcastManager(Context paramContext) {
    this.a = paramContext;
    this.e = new Handler(this, paramContext.getMainLooper()) {
        public void handleMessage(Message param1Message) {
          if (param1Message.what != 1) {
            super.handleMessage(param1Message);
            return;
          } 
          this.a.a();
        }
      };
  }
  
  public static LocalBroadcastManager getInstance(Context paramContext) {
    synchronized (f) {
      if (g == null)
        g = new LocalBroadcastManager(paramContext.getApplicationContext()); 
      return g;
    } 
  }
  
  void a() {
    while (true) {
      HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> hashMap;
      BroadcastRecord broadcastRecord;
      synchronized (this.b) {
        int i = this.d.size();
        if (i <= 0)
          return; 
        BroadcastRecord[] arrayOfBroadcastRecord = new BroadcastRecord[i];
        this.d.toArray(arrayOfBroadcastRecord);
        this.d.clear();
        for (i = 0; i < arrayOfBroadcastRecord.length; i++) {
          broadcastRecord = arrayOfBroadcastRecord[i];
          int k = broadcastRecord.b.size();
          for (int j = 0; j < k; j++) {
            ReceiverRecord receiverRecord = broadcastRecord.b.get(j);
            if (!receiverRecord.d)
              receiverRecord.b.onReceive(this.a, broadcastRecord.a); 
          } 
        } 
      } 
    } 
  }
  
  public void registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter) {
    synchronized (this.b) {
      ReceiverRecord receiverRecord = new ReceiverRecord(paramIntentFilter, paramBroadcastReceiver);
      ArrayList<ReceiverRecord> arrayList2 = this.b.get(paramBroadcastReceiver);
      ArrayList<ReceiverRecord> arrayList1 = arrayList2;
      if (arrayList2 == null) {
        arrayList1 = new ArrayList(1);
        this.b.put(paramBroadcastReceiver, arrayList1);
      } 
      arrayList1.add(receiverRecord);
      for (int i = 0; i < paramIntentFilter.countActions(); i++) {
        String str = paramIntentFilter.getAction(i);
        arrayList1 = this.c.get(str);
        ArrayList<ReceiverRecord> arrayList = arrayList1;
        if (arrayList1 == null) {
          arrayList = new ArrayList<ReceiverRecord>(1);
          this.c.put(str, arrayList);
        } 
        arrayList.add(receiverRecord);
      } 
      return;
    } 
  }
  
  public boolean sendBroadcast(Intent paramIntent) {
    int i;
    ArrayList<ReceiverRecord> arrayList;
    String str1;
    String str2;
    Uri uri;
    String str3;
    Set set;
    synchronized (this.b) {
      str1 = paramIntent.getAction();
      str2 = paramIntent.resolveTypeIfNeeded(this.a.getContentResolver());
      uri = paramIntent.getData();
      str3 = paramIntent.getScheme();
      set = paramIntent.getCategories();
      if ((paramIntent.getFlags() & 0x8) != 0) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Resolving type ");
        stringBuilder1.append(str2);
        stringBuilder1.append(" scheme ");
        stringBuilder1.append(str3);
        stringBuilder1.append(" of intent ");
        stringBuilder1.append(paramIntent);
        Log.v("LocalBroadcastManager", stringBuilder1.toString());
      } 
      arrayList = this.c.get(paramIntent.getAction());
      if (arrayList != null) {
        if (i) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Action list: ");
          stringBuilder1.append(arrayList);
          Log.v("LocalBroadcastManager", stringBuilder1.toString());
        } 
      } else {
        return false;
      } 
    } 
    StringBuilder stringBuilder = null;
    for (int j = 0; j < arrayList.size(); j++) {
      ReceiverRecord receiverRecord = arrayList.get(j);
      if (i) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Matching against filter ");
        stringBuilder1.append(receiverRecord.a);
        Log.v("LocalBroadcastManager", stringBuilder1.toString());
      } 
      if (receiverRecord.c) {
        if (i)
          Log.v("LocalBroadcastManager", "  Filter's target already added"); 
      } else {
        IntentFilter intentFilter = receiverRecord.a;
        StringBuilder stringBuilder1 = stringBuilder;
        int k = intentFilter.match(str1, str2, str3, uri, set, "LocalBroadcastManager");
        if (k >= 0) {
          if (i) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("  Filter matched!  match=0x");
            stringBuilder.append(Integer.toHexString(k));
            Log.v("LocalBroadcastManager", stringBuilder.toString());
          } 
          if (stringBuilder1 == null) {
            ArrayList arrayList1 = new ArrayList();
          } else {
            stringBuilder = stringBuilder1;
          } 
          stringBuilder.add(receiverRecord);
          receiverRecord.c = true;
        } else if (i) {
          String str;
          if (k != -4) {
            if (k != -3) {
              if (k != -2) {
                if (k != -1) {
                  str = "unknown reason";
                } else {
                  str = "type";
                } 
              } else {
                str = "data";
              } 
            } else {
              str = "action";
            } 
          } else {
            str = "category";
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("  Filter did not match: ");
          stringBuilder2.append(str);
          Log.v("LocalBroadcastManager", stringBuilder2.toString());
        } 
      } 
    } 
    if (stringBuilder != null) {
      for (i = 0; i < stringBuilder.size(); i++)
        ((ReceiverRecord)stringBuilder.get(i)).c = false; 
      this.d.add(new BroadcastRecord(paramIntent, (ArrayList<ReceiverRecord>)stringBuilder));
      if (!this.e.hasMessages(1))
        this.e.sendEmptyMessage(1); 
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_10} */
      return true;
    } 
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_10} */
    return false;
  }
  
  public void sendBroadcastSync(Intent paramIntent) {
    if (sendBroadcast(paramIntent))
      a(); 
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver) {
    synchronized (this.b) {
      ArrayList<ReceiverRecord> arrayList = this.b.remove(paramBroadcastReceiver);
      if (arrayList == null)
        return; 
      for (int i = arrayList.size() - 1;; i--) {
        if (i >= 0) {
          ReceiverRecord receiverRecord = arrayList.get(i);
          receiverRecord.d = true;
          for (int j = 0; j < receiverRecord.a.countActions(); j++) {
            String str = receiverRecord.a.getAction(j);
            ArrayList<ReceiverRecord> arrayList1 = this.c.get(str);
            if (arrayList1 != null) {
              int k;
              for (k = arrayList1.size() - 1;; k--) {
                if (k >= 0) {
                  ReceiverRecord receiverRecord1 = arrayList1.get(k);
                  if (receiverRecord1.b == paramBroadcastReceiver) {
                    receiverRecord1.d = true;
                    arrayList1.remove(k);
                  } 
                } else {
                  if (arrayList1.size() <= 0)
                    this.c.remove(str); 
                  break;
                } 
              } 
            } 
          } 
        } else {
          return;
        } 
      } 
    } 
  }
  
  static final class BroadcastRecord {
    final Intent a;
    
    final ArrayList<LocalBroadcastManager.ReceiverRecord> b;
    
    BroadcastRecord(Intent param1Intent, ArrayList<LocalBroadcastManager.ReceiverRecord> param1ArrayList) {
      this.a = param1Intent;
      this.b = param1ArrayList;
    }
  }
  
  static final class ReceiverRecord {
    final IntentFilter a;
    
    final BroadcastReceiver b;
    
    boolean c;
    
    boolean d;
    
    ReceiverRecord(IntentFilter param1IntentFilter, BroadcastReceiver param1BroadcastReceiver) {
      this.a = param1IntentFilter;
      this.b = param1BroadcastReceiver;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(128);
      stringBuilder.append("Receiver{");
      stringBuilder.append(this.b);
      stringBuilder.append(" filter=");
      stringBuilder.append(this.a);
      if (this.d)
        stringBuilder.append(" DEAD"); 
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\localbroadcastmanager\content\LocalBroadcastManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */