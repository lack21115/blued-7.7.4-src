package com.blued.android.chat.grpc.backup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.db.DBOper;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.blued.android.chat.grpc.backup.annotation.DbTableName;
import com.blued.android.chat.grpc.backup.model.AndroidMsgDbModel;
import com.blued.android.chat.grpc.backup.model.AndroidSessionDbModel;
import com.blued.android.chat.grpc.backup.model.IOSMsgDbModel;
import com.blued.android.chat.grpc.backup.model.IOSSessionDbModel;
import com.blued.android.chat.grpc.utils.ChatLog;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MsgBackupManager {
  public static final int BATCH_COUNT = 1000;
  
  public static final String PLATFORM_ANDROID = "android";
  
  public static final String PLATFORM_IOS = "ios";
  
  public static final String TAG = "MsgBackupManager";
  
  private static volatile MsgBackupManager instance;
  
  private static volatile boolean isRunning;
  
  private final ExecutorService executor = Executors.newSingleThreadExecutor();
  
  private SQLiteDatabase localDatabase;
  
  private ChattingModel restoreLastMsg = null;
  
  private MsgBackupManager() {
    DBOper dBOper = ChatManager.dbOperImpl;
    if (dBOper != null)
      this.localDatabase = dBOper.getReadDatabase(); 
  }
  
  private boolean copyFile(File paramFile, String paramString) {
    if (paramFile != null && paramFile.exists()) {
      if (paramString == null)
        return false; 
      File file = new File(paramString);
      if (file.exists())
        file.delete(); 
      try {
        file.createNewFile();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      try {
        FileChannel fileChannel1 = (new FileInputStream(paramFile)).getChannel();
        FileChannel fileChannel2 = (new FileOutputStream(file)).getChannel();
        fileChannel1.transferTo(0L, fileChannel1.size(), fileChannel2);
        try {
          fileChannel1.close();
          fileChannel2.close();
          return true;
        } catch (IOException iOException) {
          iOException.printStackTrace();
          return true;
        } 
      } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return false;
      } 
    } 
    return false;
  }
  
  protected static MsgBackupManager getInstance() {
    // Byte code:
    //   0: getstatic com/blued/android/chat/grpc/backup/MsgBackupManager.instance : Lcom/blued/android/chat/grpc/backup/MsgBackupManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/chat/grpc/backup/MsgBackupManager
    //   8: monitorenter
    //   9: getstatic com/blued/android/chat/grpc/backup/MsgBackupManager.instance : Lcom/blued/android/chat/grpc/backup/MsgBackupManager;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/chat/grpc/backup/MsgBackupManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/chat/grpc/backup/MsgBackupManager.instance : Lcom/blued/android/chat/grpc/backup/MsgBackupManager;
    //   25: ldc com/blued/android/chat/grpc/backup/MsgBackupManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/chat/grpc/backup/MsgBackupManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/chat/grpc/backup/MsgBackupManager.instance : Lcom/blued/android/chat/grpc/backup/MsgBackupManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void insertRemoteSessionList(List<Object> paramList) {
    ArrayList<SessionModel> arrayList = new ArrayList();
    for (AndroidSessionDbModel androidSessionDbModel : paramList) {
      SessionModel sessionModel;
      paramList = null;
      if (androidSessionDbModel instanceof AndroidSessionDbModel) {
        sessionModel = ((AndroidSessionDbModel)androidSessionDbModel).convertToSessionModel();
      } else if (androidSessionDbModel instanceof IOSSessionDbModel) {
        sessionModel = ((IOSSessionDbModel)androidSessionDbModel).convertToAndroidModel();
      } 
      if (sessionModel != null && !ChatManager.getInstance().sessionExist(SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId)))
        arrayList.add(sessionModel); 
    } 
    ChatManager.getInstance().insertSessionList(arrayList);
  }
  
  private Object parseCursorToObj(Object paramObject, Cursor paramCursor) throws IllegalAccessException, IllegalArgumentException {
    for (Field field : paramObject.getClass().getDeclaredFields()) {
      boolean bool = true;
      field.setAccessible(true);
      String str = field.getName();
      int i = paramCursor.getColumnIndex(str);
      byte b = -1;
      if (i != -1) {
        String str1 = field.getType().getSimpleName();
        switch (str1.hashCode()) {
          case 109413500:
            if (str1.equals("short"))
              b = 3; 
            break;
          case 64711720:
            if (str1.equals("boolean"))
              b = 0; 
            break;
          case 3327612:
            if (str1.equals("long"))
              b = 2; 
            break;
          case 104431:
            if (str1.equals("int"))
              b = 1; 
            break;
          case -1808118735:
            if (str1.equals("String"))
              b = 4; 
            break;
        } 
        if (b != 0) {
          if (b != 1) {
            if (b != 2) {
              if (b != 3) {
                if (b == 4)
                  field.set(paramObject, paramCursor.getString(paramCursor.getColumnIndex(str))); 
              } else {
                field.setShort(paramObject, paramCursor.getShort(paramCursor.getColumnIndex(str)));
              } 
            } else {
              field.setLong(paramObject, paramCursor.getLong(paramCursor.getColumnIndex(str)));
            } 
          } else {
            field.setInt(paramObject, paramCursor.getInt(paramCursor.getColumnIndex(str)));
          } 
        } else {
          if (paramCursor.getInt(paramCursor.getColumnIndex(str)) <= 0)
            bool = false; 
          field.setBoolean(paramObject, bool);
        } 
      } 
    } 
    return paramObject;
  }
  
  private void queryAndInsertMsg(SQLiteDatabase paramSQLiteDatabase, long paramLong1, Class<AndroidMsgDbModel> paramClass, String paramString, long paramLong2) {
    String str1;
    ChattingModel chattingModel;
    String str2;
    String str3;
    if (paramClass.isAnnotationPresent((Class)DbTableName.class)) {
      str1 = ((DbTableName)paramClass.getAnnotation(DbTableName.class)).name();
    } else {
      str1 = paramClass.getSimpleName();
    } 
    if (paramClass == AndroidMsgDbModel.class) {
      str3 = "msgTimestamp";
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadName=");
      stringBuilder.append(paramString);
      stringBuilder.append(" and sessionId = ");
      stringBuilder.append(paramLong1);
      stringBuilder.append(" and ");
      stringBuilder.append("msgTimestamp");
      stringBuilder.append(" > ");
      stringBuilder.append(paramLong2);
      str2 = stringBuilder.toString();
    } else {
      str3 = "sendTime";
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sessionId = ");
      stringBuilder.append(paramLong1);
      stringBuilder.append(" and ");
      stringBuilder.append("sendTime");
      stringBuilder.append(" > ");
      stringBuilder.append(paramLong2);
      str2 = stringBuilder.toString();
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("select * from ");
    stringBuilder1.append(str1);
    stringBuilder1.append(" where ");
    stringBuilder1.append(str2);
    stringBuilder1.append(" order by ");
    stringBuilder1.append(str3);
    stringBuilder1.append(" ASC limit ");
    stringBuilder1.append(1000);
    Cursor cursor = paramSQLiteDatabase.rawQuery(stringBuilder1.toString(), null);
    ArrayList<Object> arrayList = new ArrayList();
    while (cursor.moveToNext()) {
      try {
        arrayList.add(parseCursorToObj(paramClass.newInstance(), cursor));
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QueryAndInsertMsg error: ");
        stringBuilder.append(illegalAccessException);
        ChatLog.e(str, stringBuilder.toString());
      } catch (InstantiationException instantiationException) {
        instantiationException.printStackTrace();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QueryAndInsertMsg error: ");
        stringBuilder.append(instantiationException);
        ChatLog.e(str, stringBuilder.toString());
      } 
    } 
    cursor.close();
    ArrayList<ChattingModel> arrayList1 = new ArrayList();
    int i = 0;
    cursor = null;
    while (i < arrayList.size()) {
      if (paramClass == AndroidMsgDbModel.class) {
        chattingModel = ((AndroidMsgDbModel)arrayList.get(i)).convertChattingModel();
      } else {
        chattingModel = ((IOSMsgDbModel)arrayList.get(i)).covertToAndroidModel();
      } 
      if (this.localDatabase != null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("select msgId from ");
        stringBuilder1.append(ChattingModel.class.getSimpleName());
        stringBuilder1.append(" where msgId = ");
        stringBuilder1.append(chattingModel.msgId);
        stringBuilder1.append(" and msgLocalId = ");
        stringBuilder1.append(chattingModel.msgLocalId);
        stringBuilder1.append(" and msgTimestamp = ");
        stringBuilder1.append(chattingModel.msgTimestamp);
        String str = stringBuilder1.toString();
        Cursor cursor1 = this.localDatabase.rawQuery(str, null);
        if (cursor1.moveToNext()) {
          cursor1.close();
          continue;
        } 
      } 
      arrayList1.add(chattingModel);
      continue;
      i++;
    } 
    String str4 = TAG;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("需要插入数据库中-sessionId: ");
    stringBuilder2.append(paramLong1);
    stringBuilder2.append(" 消息数：");
    stringBuilder2.append(arrayList1.size());
    ChatLog.d(str4, stringBuilder2.toString());
    if (arrayList1.size() > 0) {
      ChatManager.getInstance().insertMsgListFromBackup(arrayList1);
      this.restoreLastMsg = arrayList1.get(arrayList1.size() - 1);
    } 
    if (arrayList.size() >= 1000 && chattingModel != null) {
      queryAndInsertMsg(paramSQLiteDatabase, paramLong1, paramClass, paramString, chattingModel.msgTimestamp);
      return;
    } 
    if (this.restoreLastMsg != null) {
      ChatManager chatManager = ChatManager.getInstance();
      ChattingModel chattingModel1 = this.restoreLastMsg;
      SessionModel sessionModel = chatManager.getSnapSessionModel(chattingModel1.sessionType, chattingModel1.sessionId);
      if (sessionModel != null && sessionModel.lastMsgId == 0L && sessionModel.lastMsgLocalId == 0L)
        SessionModel.setSessionForLastMsg(sessionModel, this.restoreLastMsg); 
    } 
  }
  
  private List<Object> queryRemoteSession(SQLiteDatabase paramSQLiteDatabase, Class<SessionModel> paramClass, String paramString) {
    ArrayList<Object> arrayList = new ArrayList();
    if (paramClass.isAnnotationPresent((Class)DbTableName.class)) {
      str1 = ((DbTableName)paramClass.getAnnotation(DbTableName.class)).name();
    } else {
      str1 = paramClass.getSimpleName();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select * from ");
    stringBuilder.append(str1);
    stringBuilder.append(" where sessionType = ");
    stringBuilder.append(2);
    String str2 = stringBuilder.toString();
    String str1 = str2;
    if (paramClass == SessionModel.class) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append(" and loadName= ");
      stringBuilder1.append(paramString);
      str1 = stringBuilder1.toString();
    } 
    Cursor cursor = paramSQLiteDatabase.rawQuery(str1, null);
    while (true) {
      if (cursor.moveToNext()) {
        try {
          arrayList.add(parseCursorToObj(paramClass.newInstance(), cursor));
        } finally {}
        continue;
      } 
      cursor.close();
      return arrayList;
    } 
  }
  
  private void restoreFromDb(File paramFile, ReserveListener paramReserveListener, Class paramClass1, Class paramClass2, String paramString) {
    try {
      SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(paramFile.getAbsolutePath(), null);
      restoreSession(sQLiteDatabase, paramClass1, paramString);
      restoreMsg(sQLiteDatabase, paramClass2, paramString);
      return;
    } finally {
      paramFile = null;
      if (paramReserveListener != null)
        paramReserveListener.onError(paramFile.toString()); 
    } 
  }
  
  private void restoreMsg(SQLiteDatabase paramSQLiteDatabase, Class<AndroidMsgDbModel> paramClass, String paramString) {
    String str1;
    String str2;
    if (paramClass.isAnnotationPresent((Class)DbTableName.class)) {
      str1 = ((DbTableName)paramClass.getAnnotation(DbTableName.class)).name();
    } else {
      str1 = paramClass.getSimpleName();
    } 
    if (paramClass == AndroidMsgDbModel.class) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("sessionType = 2 and loadName = ");
      stringBuilder1.append(paramString);
      str2 = stringBuilder1.toString();
    } else {
      str2 = "sessionType = 2";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select sessionId ,count(*) as msgCnt from ");
    stringBuilder.append(str1);
    stringBuilder.append(" where ");
    stringBuilder.append(str2);
    stringBuilder.append(" group by(sessionId)");
    Cursor cursor = paramSQLiteDatabase.rawQuery(stringBuilder.toString(), null);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    while (cursor.moveToNext())
      hashMap.put(Long.valueOf(cursor.getLong(cursor.getColumnIndex("sessionId"))), Integer.valueOf(cursor.getInt(cursor.getColumnIndex("msgCnt")))); 
    cursor.close();
    if (hashMap.size() > 0) {
      Iterator<Long> iterator = hashMap.keySet().iterator();
      while (iterator.hasNext()) {
        long l = ((Long)iterator.next()).longValue();
        String str = TAG;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("sessionId : ");
        stringBuilder1.append(l);
        stringBuilder1.append(" 消息数：");
        stringBuilder1.append(hashMap.get(Long.valueOf(l)));
        ChatLog.d(str, stringBuilder1.toString());
        this.restoreLastMsg = null;
        queryAndInsertMsg(paramSQLiteDatabase, l, paramClass, paramString, 0L);
      } 
    } 
  }
  
  private void restoreSession(SQLiteDatabase paramSQLiteDatabase, Class paramClass, String paramString) {
    List<Object> list = queryRemoteSession(paramSQLiteDatabase, paramClass, paramString);
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("远端session个数===");
    stringBuilder.append(list.size());
    ChatLog.d(str, stringBuilder.toString());
    insertRemoteSessionList(list);
  }
  
  public void reserveMsgDb(final String rawPath, final List<Long> selectedSessionIdList, final ReserveListener listener) {
    if (isRunning && isRunning) {
      if (listener != null)
        listener.onError("Task already running !!"); 
      return;
    } 
    isRunning = true;
    if (listener != null)
      listener.onStart(); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (Environment.getExternalStorageState().equals("mounted")) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(Environment.getExternalStorageDirectory());
              stringBuilder1.append(File.separator);
              stringBuilder1.append("blued");
              stringBuilder1.append(File.separator);
              stringBuilder1.append("database");
              String str1 = stringBuilder1.toString();
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("android_");
              stringBuilder2.append((PrivateChatManager.getInstance().getUserInfo()).uid);
              stringBuilder2.append("_");
              stringBuilder2.append((PrivateChatManager.getInstance().getChatAppInfo()).clientType.ordinal());
              String str2 = stringBuilder2.toString();
              File file = new File(str1);
              if (!file.exists())
                file.mkdirs(); 
              StringBuilder stringBuilder3 = new StringBuilder();
              stringBuilder3.append(str1);
              stringBuilder3.append(File.separator);
              stringBuilder3.append(str2);
              String str3 = stringBuilder3.toString();
              if (MsgBackupManager.this.copyFile(new File(rawPath), str3)) {
                try {
                  String str5;
                  SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(str3, null);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("delete from ");
                  stringBuilder.append(ChattingModel.class.getSimpleName());
                  stringBuilder.append(" where loadName != ");
                  stringBuilder.append((PrivateChatManager.getInstance().getUserInfo()).uid);
                  stringBuilder.append(" or msgIsDelete = 1");
                  String str7 = stringBuilder.toString();
                  stringBuilder = new StringBuilder();
                  stringBuilder.append("delete from ");
                  stringBuilder.append(SessionModel.class.getSimpleName());
                  stringBuilder.append(" where  loadName != ");
                  stringBuilder.append((PrivateChatManager.getInstance().getUserInfo()).uid);
                  String str6 = stringBuilder.toString();
                  String str4 = str6;
                  str2 = str7;
                  if (selectedSessionIdList != null) {
                    str4 = str6;
                    str2 = str7;
                    if (selectedSessionIdList.size() > 0) {
                      StringBuilder stringBuilder4 = new StringBuilder();
                      Iterator<Long> iterator = selectedSessionIdList.iterator();
                      while (iterator.hasNext()) {
                        stringBuilder4.append(((Long)iterator.next()).longValue());
                        stringBuilder4.append(",");
                      } 
                      str4 = stringBuilder4.toString();
                      str4 = str4.substring(0, str4.length() - 1);
                      String str = MsgBackupManager.TAG;
                      StringBuilder stringBuilder7 = new StringBuilder();
                      stringBuilder7.append("selectedSessionId====");
                      stringBuilder7.append(str4);
                      ChatLog.d(str, stringBuilder7.toString());
                      StringBuilder stringBuilder5 = new StringBuilder();
                      stringBuilder5.append(str7);
                      stringBuilder5.append(" or sessionId not in ( ");
                      stringBuilder5.append(str4);
                      stringBuilder5.append(" )");
                      str5 = stringBuilder5.toString();
                      StringBuilder stringBuilder6 = new StringBuilder();
                      stringBuilder6.append(str6);
                      stringBuilder6.append(" or sessionId not in ( ");
                      stringBuilder6.append(str4);
                      stringBuilder6.append(" )");
                      str4 = stringBuilder6.toString();
                    } 
                  } 
                  Cursor cursor2 = sQLiteDatabase.rawQuery(str5, null);
                  Cursor cursor1 = sQLiteDatabase.rawQuery(str4, null);
                  if (PrivateChatManager.getInstance().isDebug()) {
                    if (cursor2.moveToFirst()) {
                      str6 = MsgBackupManager.TAG;
                      StringBuilder stringBuilder4 = new StringBuilder();
                      stringBuilder4.append("删除消息数====");
                      stringBuilder4.append(cursor2.getLong(0));
                      ChatLog.d(str6, stringBuilder4.toString());
                    } 
                    if (cursor1.moveToFirst()) {
                      str6 = MsgBackupManager.TAG;
                      StringBuilder stringBuilder4 = new StringBuilder();
                      stringBuilder4.append("删除session数====");
                      stringBuilder4.append(cursor1.getLong(0));
                      ChatLog.d(str6, stringBuilder4.toString());
                    } 
                  } 
                  cursor1.close();
                  cursor2.close();
                } finally {
                  str1 = null;
                  MsgBackupManager.ReserveListener reserveListener = listener;
                } 
              } else {
                MsgBackupManager.ReserveListener reserveListener = listener;
                if (reserveListener != null)
                  reserveListener.onError("Copied file failed !!"); 
              } 
            } else {
              MsgBackupManager.ReserveListener reserveListener = listener;
              if (reserveListener != null)
                reserveListener.onError("External storage disable !!"); 
            } 
            MsgBackupManager.access$102(false);
          }
        });
  }
  
  public void restoreMsgDb(final String filePath, final ReserveListener listener) {
    if (isRunning) {
      if (listener != null)
        listener.onError("Task already running !!"); 
      return;
    } 
    isRunning = true;
    if (listener != null)
      listener.onStart(); 
    this.executor.execute(new Runnable() {
          public void run() {
            MsgBackupManager.ReserveListener reserveListener2;
            StringBuilder stringBuilder;
            File file = new File(filePath);
            if (!file.exists()) {
              reserveListener1 = listener;
              if (reserveListener1 != null)
                reserveListener1.onError("File is not exists !!"); 
              MsgBackupManager.access$102(false);
              return;
            } 
            String[] arrayOfString = file.getName().split("_");
            if (arrayOfString.length != 3) {
              reserveListener1 = listener;
              if (reserveListener1 != null)
                reserveListener1.onError("File's name is illegal !!  The file's name must be similar to: android_123456_0"); 
              MsgBackupManager.access$102(false);
              return;
            } 
            MsgBackupManager.ReserveListener reserveListener3 = reserveListener1[0];
            MsgBackupManager.ReserveListener reserveListener4 = reserveListener1[1];
            MsgBackupManager.ReserveListener reserveListener1 = reserveListener1[2];
            if (TextUtils.isEmpty((CharSequence)reserveListener4) || !reserveListener4.equals((PrivateChatManager.getInstance().getUserInfo()).uid)) {
              reserveListener1 = listener;
              if (reserveListener1 != null)
                reserveListener1.onError("Uid is wrong !! The file's name must be similar to: android_123456_0"); 
              MsgBackupManager.access$102(false);
              return;
            } 
            if (TextUtils.isEmpty((CharSequence)reserveListener1) || !reserveListener1.equals(String.valueOf((PrivateChatManager.getInstance().getChatAppInfo()).clientType.ordinal()))) {
              reserveListener2 = listener;
              if (reserveListener2 != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("ClientType is wrong !! File's clientType is ");
                stringBuilder.append((String)reserveListener1);
                stringBuilder.append(" and current is ");
                stringBuilder.append((PrivateChatManager.getInstance().getChatAppInfo()).clientType.ordinal());
                reserveListener2.onError(stringBuilder.toString());
              } 
              MsgBackupManager.access$102(false);
              return;
            } 
            if ("android".equals(stringBuilder)) {
              MsgBackupManager.this.restoreFromDb((File)reserveListener2, listener, AndroidSessionDbModel.class, AndroidMsgDbModel.class, (String)reserveListener4);
            } else if ("ios".equals(stringBuilder)) {
              MsgBackupManager.this.restoreFromDb((File)reserveListener2, listener, IOSSessionDbModel.class, IOSMsgDbModel.class, (String)reserveListener4);
            } else {
              reserveListener1 = listener;
              if (reserveListener1 != null)
                reserveListener1.onError("File's name is wrong !! The file's name must be similar to : android_123456_0"); 
            } 
            MsgBackupManager.access$102(false);
          }
        });
  }
  
  public static interface ReserveListener {
    void onError(String param1String);
    
    void onReserveSucceed(String param1String);
    
    void onRestoreSucceed();
    
    void onStart();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\grpc\backup\MsgBackupManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */