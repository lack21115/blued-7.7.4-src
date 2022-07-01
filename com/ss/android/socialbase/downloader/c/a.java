package com.ss.android.socialbase.downloader.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ss.android.socialbase.downloader.downloader.b;
import java.io.File;

public class a extends SQLiteOpenHelper {
  private static volatile a a;
  
  private boolean b = false;
  
  private a() {
    super(b.B(), "downloader.db", null, 12);
  }
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/c/a.a : Lcom/ss/android/socialbase/downloader/c/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/c/a
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/c/a.a : Lcom/ss/android/socialbase/downloader/c/a;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/c/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/c/a.a : Lcom/ss/android/socialbase/downloader/c/a;
    //   25: ldc com/ss/android/socialbase/downloader/c/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/c/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/c/a.a : Lcom/ss/android/socialbase/downloader/c/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public SQLiteDatabase getReadableDatabase() {
    Context context = b.B();
    if (!this.b && context != null) {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/data/data/");
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("/database/main/");
        File file = new File(stringBuilder.toString());
        if (!file.exists())
          file.mkdir(); 
        super.getReadableDatabase().execSQL("PRAGMA temp_store_directory = tempDir");
        this.b = true;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      return super.getReadableDatabase();
    } 
    return super.getReadableDatabase();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloader( _id INTEGER PRIMARY KEY, url TEXT, savePath TEXT, tempPath TEXT, name TEXT, chunkCount INTEGER, status INTEGER, curBytes INTEGER, totalBytes INTEGER, eTag TEXT, onlyWifi INTEGER, force INTEGER, retryCount INTEGER, extra TEXT, mimeType TEXT, title TEXT, notificationEnable INTEGER, notificationVisibility INTEGER, isFirstDownload INTEGER, isFirstSuccess INTEGER, needHttpsToHttpRetry INTEGER, downloadTime INTEGER, packageName TEXT, md5 TEXT, retryDelay INTEGER, curRetryTime INTEGER, retryDelayStatus INTEGER, defaultHttpServiceBackUp INTEGER, chunkRunnableReuse INTEGER, retryDelayTimeArray TEXT, chunkDowngradeRetry INTEGER, backUpUrlsStr TEXT, backUpUrlRetryCount INTEGER, realDownloadTime INTEGER, retryScheduleMinutes INTEGER, independentProcess INTEGER, auxiliaryJsonobjectString TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloadChunk( _id INTEGER, chunkIndex INTEGER, startOffset INTEGER, curOffset INTEGER, endOffset INTEGER, chunkContentLen INTEGER, hostChunkIndex INTEGER )");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    if (com.ss.android.socialbase.downloader.f.a.a())
      com.ss.android.socialbase.downloader.f.a.a("onDowngrade"); 
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    switch (paramInt1) {
      default:
        return;
      case 1:
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD mimeType TEXT");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD title TEXT");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD notificationEnable INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD notificationVisibility INTEGER");
      case 2:
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD isFirstDownload INTEGER");
      case 3:
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD isFirstSuccess INTEGER");
      case 4:
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD needHttpsToHttpRetry INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD downloadTime INTEGER");
      case 5:
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD packageName TEXT");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD md5 TEXT");
      case 6:
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD retryDelay INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD curRetryTime INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD retryDelayStatus INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD defaultHttpServiceBackUp INTEGER");
      case 7:
        paramSQLiteDatabase.execSQL("ALTER TABLE downloadChunk ADD chunkContentLen INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloadChunk ADD hostChunkIndex INTEGER");
      case 8:
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD chunkRunnableReuse INTEGER");
      case 9:
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD retryDelayTimeArray TEXT");
      case 10:
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD chunkDowngradeRetry INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD backUpUrlsStr TEXT");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD backUpUrlRetryCount INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD realDownloadTime INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD retryScheduleMinutes INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD independentProcess INTEGER");
        break;
      case 11:
        break;
    } 
    paramSQLiteDatabase.execSQL("ALTER TABLE downloader ADD auxiliaryJsonobjectString TEXT");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */