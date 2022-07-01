package com.soft.blued.ui.feed.manager;

import android.util.Log;
import androidx.core.util.Pair;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.upload.qiniu.MediaSender;
import com.blued.android.framework.utils.upload.qiniu.SenderListener;
import com.blued.android.framework.utils.upload.qiniu.UploadModel;
import com.soft.blued.http.BluedHttpUrl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VideoUploadManager {
  private static String a = "FeedSend";
  
  private static VideoUploadManager b = new VideoUploadManager();
  
  private String c;
  
  private String d;
  
  private HashMap<String, UploadData> e;
  
  private VideoUploadListener f;
  
  public VideoUploadManager() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/qiniu?filter=token&action=ticktocks");
    this.c = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/qiniu?filter=token&action=videos&ops=ticktocks");
    this.d = stringBuilder.toString();
    this.e = new HashMap<String, UploadData>();
  }
  
  public static VideoUploadManager a() {
    return b;
  }
  
  private UploadData b(String paramString) {
    return (this.e.get(paramString) != null) ? this.e.get(paramString) : new UploadData();
  }
  
  public void a(Pair<String, String> paramPair1, Pair<String, String> paramPair2, VideoUploadListener paramVideoUploadListener) {
    Log.d(a, "uploadVideo");
    if (paramVideoUploadListener != null)
      this.f = paramVideoUploadListener; 
    MediaSender.a(this.c, this.d, paramPair1, paramPair2, new SenderListener(this) {
          public void a(String param1String, int param1Int) {
            VideoUploadManager.UploadData uploadData = VideoUploadManager.a(this.a, param1String);
            uploadData.a = param1Int;
            VideoUploadManager.a(this.a).put(param1String, uploadData);
            if (VideoUploadManager.b(this.a) != null)
              VideoUploadManager.b(this.a).a(param1String, param1Int); 
            String str = VideoUploadManager.b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sendVideo onProcess taskId");
            stringBuilder.append(param1String);
            Log.d(str, stringBuilder.toString());
          }
          
          public void a(String param1String, Pair<String, UploadModel> param1Pair) {
            VideoUploadManager.UploadData uploadData = VideoUploadManager.a(this.a, param1String);
            uploadData.b.add(param1Pair);
            VideoUploadManager.a(this.a).put(param1String, uploadData);
            String str = VideoUploadManager.b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sendVideo onPartFinish taskId");
            stringBuilder.append(param1String);
            Log.d(str, stringBuilder.toString());
            if (((UploadModel)param1Pair.second).type == 0) {
              param1String = VideoUploadManager.b();
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("sendVideo onPartFinish pair first");
              stringBuilder1.append((String)param1Pair.first);
              Log.d(param1String, stringBuilder1.toString());
            } 
          }
          
          public void a(String param1String, boolean param1Boolean, List<Pair<String, String>> param1List) {
            ArrayList arrayList;
            VideoUploadManager.UploadData uploadData = VideoUploadManager.a(this.a, param1String);
            if (uploadData != null) {
              arrayList = uploadData.b;
            } else {
              arrayList = null;
            } 
            uploadData.d = Boolean.valueOf(param1Boolean);
            uploadData.c = param1List;
            VideoUploadManager.a(this.a).put(param1String, uploadData);
            if (VideoUploadManager.b(this.a) != null)
              VideoUploadManager.b(this.a).a(param1String, param1Boolean, arrayList, param1List); 
            String str = VideoUploadManager.b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sendVideo onFinish taskId");
            stringBuilder.append(param1String);
            Log.d(str, stringBuilder.toString());
          }
        });
  }
  
  public void a(String paramString) {
    MediaSender.a(paramString);
    this.e.remove(paramString);
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("cancleUploadVideo taskId");
    stringBuilder.append(paramString);
    Log.d(str, stringBuilder.toString());
  }
  
  public void a(String paramString, Pair<String, String> paramPair1, Pair<String, String> paramPair2, VideoUploadListener paramVideoUploadListener) {
    UploadData uploadData;
    if (!StringUtils.a(paramString) && this.e.containsKey(paramString)) {
      if (paramVideoUploadListener == null)
        return; 
      this.f = paramVideoUploadListener;
      uploadData = this.e.get(paramString);
      if (uploadData != null && uploadData.a == 100) {
        this.f.a(paramString, uploadData.d.booleanValue(), uploadData.b, uploadData.c);
        return;
      } 
    } else {
      a((Pair<String, String>)uploadData, paramPair2, paramVideoUploadListener);
    } 
  }
  
  public static class UploadData implements Serializable {
    int a;
    
    ArrayList<Pair<String, UploadModel>> b = new ArrayList<Pair<String, UploadModel>>();
    
    List<Pair<String, String>> c;
    
    Boolean d;
  }
  
  public static interface VideoUploadListener {
    void a(String param1String, int param1Int);
    
    void a(String param1String, boolean param1Boolean, ArrayList<Pair<String, UploadModel>> param1ArrayList, List<Pair<String, String>> param1List);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\manager\VideoUploadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */