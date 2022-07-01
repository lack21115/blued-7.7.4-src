package com.blued.android.module.media.selector.model;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.media.selector.contract.IBaseCallback;
import com.blued.android.module.media.selector.utils.LogUtils;
import com.blued.android.module.media.selector.utils.ThreadPoolHelper;
import com.blued.android.module.media.selector.utils.ThumbLoader;
import com.blued.android.module.player.media.model.MediaInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AlbumLoadDataModel extends BaseModel<AlbumLoadDataModel.IAlbumLoadDataCallback> implements LoaderManager.LoaderCallbacks<Cursor> {
  private static final String b = AlbumLoadDataModel.class.getSimpleName();
  
  private static String h;
  
  private static String i;
  
  private String c;
  
  private Uri d;
  
  private int e;
  
  private ThumbLoader.GetVideoThumsAsynctack f;
  
  private boolean g;
  
  public AlbumLoadDataModel(Context paramContext, Bundle paramBundle, IAlbumLoadDataCallback paramIAlbumLoadDataCallback) {
    // Byte code:
    //   0: aload_0
    //   1: aload_3
    //   2: invokespecial <init> : (Lcom/blued/android/module/media/selector/contract/IBaseCallback;)V
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield e : I
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield g : Z
    //   15: aload_0
    //   16: getfield a : Lcom/blued/android/module/media/selector/contract/IBaseCallback;
    //   19: ifnonnull -> 23
    //   22: return
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   28: getstatic com/blued/android/module/media/selector/R$string.foudation_media_all_photos : I
    //   31: invokevirtual getString : (I)Ljava/lang/String;
    //   34: putfield c : Ljava/lang/String;
    //   37: aload_0
    //   38: ldc 'external'
    //   40: invokestatic getContentUri : (Ljava/lang/String;)Landroid/net/Uri;
    //   43: putfield d : Landroid/net/Uri;
    //   46: aload_2
    //   47: ifnull -> 74
    //   50: aload_2
    //   51: ldc 'serializeble_data'
    //   53: invokevirtual getSerializable : (Ljava/lang/String;)Ljava/io/Serializable;
    //   56: checkcast com/blued/android/module/media/selector/model/AlbumSelectInfo
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull -> 74
    //   64: aload_1
    //   65: invokestatic setAlbumSelectInfo : (Lcom/blued/android/module/media/selector/model/AlbumSelectInfo;)V
    //   68: iconst_1
    //   69: istore #4
    //   71: goto -> 77
    //   74: iconst_0
    //   75: istore #4
    //   77: iload #4
    //   79: ifeq -> 105
    //   82: aload_0
    //   83: getfield a : Lcom/blued/android/module/media/selector/contract/IBaseCallback;
    //   86: checkcast com/blued/android/module/media/selector/model/AlbumLoadDataModel$IAlbumLoadDataCallback
    //   89: invokeinterface f : ()Landroid/app/Activity;
    //   94: invokevirtual getLoaderManager : ()Landroid/app/LoaderManager;
    //   97: iconst_0
    //   98: aconst_null
    //   99: aload_0
    //   100: invokevirtual restartLoader : (ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;
    //   103: pop
    //   104: return
    //   105: aload_0
    //   106: getfield a : Lcom/blued/android/module/media/selector/contract/IBaseCallback;
    //   109: checkcast com/blued/android/module/media/selector/model/AlbumLoadDataModel$IAlbumLoadDataCallback
    //   112: invokeinterface f : ()Landroid/app/Activity;
    //   117: invokevirtual getLoaderManager : ()Landroid/app/LoaderManager;
    //   120: iconst_0
    //   121: aconst_null
    //   122: aload_0
    //   123: invokevirtual initLoader : (ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;
    //   126: pop
    //   127: return
  }
  
  public static String a() {
    if (TextUtils.isEmpty(h))
      try {
        h = AppInfo.d().getExternalCacheDir().getParentFile().getAbsolutePath();
      } catch (NullPointerException nullPointerException) {
        nullPointerException.printStackTrace();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    if (h == null)
      h = ""; 
    return h;
  }
  
  public static boolean a(String paramString) {
    return (paramString == null) ? false : ((!TextUtils.isEmpty(b()) && paramString.startsWith(b())) ? true : ((!TextUtils.isEmpty(a()) && paramString.startsWith(a()))));
  }
  
  public static String b() {
    if (TextUtils.isEmpty(i))
      try {
        i = AppInfo.d().getCacheDir().getParentFile().getAbsolutePath();
      } catch (NullPointerException nullPointerException) {
        nullPointerException.printStackTrace();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    if (i == null)
      i = ""; 
    return i;
  }
  
  public static int c() {
    return AlbumDataManager.getMediaTypeVideo();
  }
  
  public void a(Loader<Cursor> paramLoader, Cursor paramCursor) {
    LogUtils.c(" onLoadFinished start");
    this.g = AppUtils.b();
    if (this.a == null)
      return; 
    if (paramCursor == null) {
      this.a.a(true, "");
      return;
    } 
    if (this.e == 0) {
      MediaInfo mediaInfo;
      this.e = paramCursor.getCount();
      if (paramCursor.isAfterLast()) {
        this.a.a(true, "");
        return;
      } 
      AlbumDataManager.removeAll();
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      Iterator<MediaInfo> iterator = AlbumDataManager.getSelectImageList().iterator();
      while (true) {
        HashMap<Object, Object> hashMap1 = hashMap;
        if (iterator.hasNext()) {
          mediaInfo = iterator.next();
          hashMap.put(mediaInfo.imagePath, mediaInfo);
          continue;
        } 
        break;
      } 
      while (true) {
        Cursor cursor = paramCursor;
        if (paramCursor.moveToNext()) {
          String str = cursor.getString(cursor.getColumnIndex("_data"));
          try {
            String str1 = (new File(str)).getParentFile().getName();
            int i = cursor.getInt(cursor.getColumnIndex("media_type"));
            int j = cursor.getInt(cursor.getColumnIndex("mime_type"));
            String str2 = cursor.getString(cursor.getColumnIndex("title"));
            long l1 = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            long l2 = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
            long l3 = cursor.getLong(cursor.getColumnIndexOrThrow("duration"));
            int k = cursor.getInt(cursor.getColumnIndexOrThrow("width"));
            int m = cursor.getInt(cursor.getColumnIndexOrThrow("height"));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("media_type=");
            stringBuilder.append(i);
            stringBuilder.append(" path=");
            stringBuilder.append(str);
            LogUtils.a(new Object[] { stringBuilder.toString() });
            if (TextUtils.isEmpty(str))
              continue; 
            if (i == c()) {
              if (!str.endsWith(".mp4"))
                continue; 
              if (this.a == null)
                return; 
              if (l3 < this.a.h() || l3 > this.a.i())
                continue; 
            } 
            MediaInfo mediaInfo1 = new MediaInfo();
            mediaInfo1.id = l1;
            mediaInfo1.media_type = i;
            mediaInfo1.mime_type = j;
            mediaInfo1.title = str2;
            if (i == c()) {
              mediaInfo1.path = str;
              if (this.g && !a(str))
                mediaInfo1.imgUri = Uri.withAppendedPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, String.valueOf(l1)).toString(); 
            } else if (this.g && !a(str)) {
              mediaInfo1.imgUri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, String.valueOf(l1)).toString();
              mediaInfo1.imagePath = str;
            } else {
              mediaInfo1.imagePath = str;
            } 
            mediaInfo1.width = k;
            mediaInfo1.height = m;
            mediaInfo1.size = l2;
            mediaInfo1.videoTime = l3;
            if (mediaInfo.containsKey(mediaInfo1.imagePath))
              mediaInfo1.isSelected = true; 
            AlbumDataManager.putGroupMap(this.c, str1, mediaInfo1);
          } catch (Exception exception) {}
          continue;
        } 
        LogUtils.c(" onLoadFinished cursor end");
        AlbumDataManager.subGroupOfImage();
        this.f = new ThumbLoader.GetVideoThumsAsynctack(new ThumbLoader.OnGetVideoThumsListener<MediaInfo>(this, this.c) {
              public void a(List<MediaInfo> param1List) {
                AlbumDataManager.updateGroupFileList(this.a, param1List);
                param1List = AlbumDataManager.getGroupFileList(this.a);
                AlbumDataManager.setCurrentList(this.a, param1List);
                AppInfo.n().post(new Runnable(this) {
                      public void run() {
                        if (this.a.b.a != null) {
                          boolean bool;
                          AlbumLoadDataModel.IAlbumLoadDataCallback iAlbumLoadDataCallback = this.a.b.a;
                          if (AlbumDataManager.getGroupListSize() <= 0) {
                            bool = true;
                          } else {
                            bool = false;
                          } 
                          iAlbumLoadDataCallback.a(bool, this.a.a);
                        } 
                      }
                    });
              }
            }AlbumDataManager.getGroupFileList(this.c));
        ThreadPoolHelper.a().a((Runnable)this.f);
        return;
      } 
    } 
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle) {
    String str;
    if (this.a == null)
      return null; 
    this.a.e();
    String[] arrayOfString = new String[10];
    arrayOfString[0] = "_id";
    arrayOfString[1] = "_data";
    arrayOfString[2] = "date_added";
    arrayOfString[3] = "media_type";
    arrayOfString[4] = "mime_type";
    arrayOfString[5] = "title";
    arrayOfString[6] = "_size";
    arrayOfString[7] = "duration";
    arrayOfString[8] = "width";
    arrayOfString[9] = "height";
    if (this.a.g() == 2) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(arrayOfString[3]);
      stringBuilder1.append("=");
      stringBuilder1.append(3);
      str = stringBuilder1.toString();
    } else if (this.a.g() == 1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(arrayOfString[3]);
      stringBuilder1.append("=");
      stringBuilder1.append(1);
      str = stringBuilder1.toString();
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(arrayOfString[3]);
      stringBuilder1.append("=");
      stringBuilder1.append(3);
      stringBuilder1.append(" OR ");
      stringBuilder1.append(arrayOfString[3]);
      stringBuilder1.append("=");
      stringBuilder1.append(1);
      str = stringBuilder1.toString();
    } 
    Activity activity = this.a.f();
    Uri uri = this.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(arrayOfString[2]);
    stringBuilder.append(" ASC");
    return (Loader<Cursor>)new CursorLoader((Context)activity, uri, arrayOfString, str, null, stringBuilder.toString());
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
  
  public static interface IAlbumLoadDataCallback extends IBaseCallback {
    void a(boolean param1Boolean, String param1String);
    
    void e();
    
    Activity f();
    
    int g();
    
    long h();
    
    long i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\model\AlbumLoadDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */