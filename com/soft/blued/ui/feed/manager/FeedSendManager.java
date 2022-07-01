package com.soft.blued.ui.feed.manager;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.Houyi;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.framework.utils.upload.qiniu.MediaSender;
import com.blued.android.framework.utils.upload.qiniu.SenderListener;
import com.blued.android.framework.utils.upload.qiniu.UploadModel;
import com.google.gson.Gson;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.db.NewFeedDao;
import com.soft.blued.db.model.NewFeedModel;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.discover.observer.DiscoverSquareViewModel;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedExtra;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.feed.observer.RepostListDataObserver;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.FileUtils;
import com.soft.blued.utils.ImageUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.third.QiniuUploadUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeedSendManager {
  private static FeedSendManager a = new FeedSendManager();
  
  private List<NewFeedModel> b = new ArrayList<NewFeedModel>();
  
  private List<NewFeedModel> c = new ArrayList<NewFeedModel>();
  
  private List<String> d = new ArrayList<String>();
  
  private List<String> e = new ArrayList<String>();
  
  private ArrayMap<String, String> f = new ArrayMap();
  
  private int g;
  
  private int h;
  
  private String i;
  
  private String j;
  
  private long k;
  
  public static FeedSendManager a() {
    return a;
  }
  
  private void a(Pair<String, UploadModel> paramPair, NewFeedModel paramNewFeedModel) {
    if (((UploadModel)paramPair.second).type == 0) {
      Logger.e("FeedSend", new Object[] { "pair.second.type " });
      b(paramPair, paramNewFeedModel);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("video===onPartFinish==");
    stringBuilder.append(((UploadModel)paramPair.second).url);
    Logger.e("FeedSend", new Object[] { stringBuilder.toString() });
    if (StringUtils.e(((UploadModel)paramPair.second).url))
      return; 
    String str = (String)paramPair.first;
    if (!StringUtils.e(((UploadModel)paramPair.second).compressPath))
      str = ((UploadModel)paramPair.second).compressPath; 
    FileUtils.a(((UploadModel)paramPair.second).url, str);
    paramNewFeedModel.videoPath = ((UploadModel)paramPair.second).url;
    ThreadManager.a().a(new ThreadExecutor(this, "update-feedModel", paramNewFeedModel) {
          public void execute() {
            NewFeedDao.a().b(this.a);
          }
        });
  }
  
  private void a(BluedIngSelfFeed paramBluedIngSelfFeed, NewFeedModel paramNewFeedModel) {
    LogUtils.c(paramBluedIngSelfFeed.toString());
    paramNewFeedModel.setProgress(100);
    FeedRefreshObserver.a().a(null, 1);
    NewFeedDao.a().c(paramNewFeedModel);
    this.c.remove(paramNewFeedModel);
    this.b.remove(paramNewFeedModel);
    f();
    g();
    paramBluedIngSelfFeed.vip_grade = (UserInfo.a().i()).vip_grade;
    paramBluedIngSelfFeed.is_vip_annual = (UserInfo.a().i()).is_vip_annual;
    paramBluedIngSelfFeed.is_show_vip_page = (UserInfo.a().i()).is_show_vip_page;
    FeedRefreshObserver.a().a(paramBluedIngSelfFeed, 2);
    if (paramNewFeedModel.is_attention_show_dot == 1 && HomeActivity.c != null)
      ((DiscoverSquareViewModel)ViewModelProviders.of((FragmentActivity)HomeActivity.c).get(DiscoverSquareViewModel.class)).b.postValue(null); 
  }
  
  private void a(FeedComment paramFeedComment, NewFeedModel paramNewFeedModel) {
    paramNewFeedModel.setProgress(100);
    FeedRefreshObserver.a().a(null, 1);
    this.c.remove(paramNewFeedModel);
    this.b.remove(paramNewFeedModel);
    f();
    g();
    FeedRefreshObserver.a().a(paramFeedComment, 2);
    if (AppInfo.m()) {
      AppMethods.a("评论成功");
      Log.v("drb", "评论成功");
    } 
  }
  
  private void a(String paramString1, BluedAlbum paramBluedAlbum, String paramString2, NewFeedModel paramNewFeedModel) {
    QiniuUploadUtils.a(paramString1, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this, paramString1, paramString2, paramNewFeedModel) {
          public void a(String param1String) {
            Logger.a("drb", new Object[] { "upLoadByQiNiu onFailure = ", param1String });
            FeedSendManager.a(this.d, this.c);
          }
          
          public void a(String param1String, double param1Double) {
            AppInfo.n().post(new Runnable(this, param1Double) {
                  public void run() {
                    if (this.a <= 1.0D) {
                      FeedSendManager.a(this.b.d, (int)(this.a * 100.0D) / this.b.c.getSize() + FeedSendManager.d(this.b.d));
                      int i = (int)(this.a * 100.0D) / this.b.c.getSize();
                      if (this.a == 1.0D) {
                        FeedSendManager.b(this.b.d, FeedSendManager.d(this.b.d) + i);
                        this.b.c.setProgress(FeedSendManager.e(this.b.d));
                        NewFeedDao.a().b(this.b.c);
                      } 
                      if (FeedSendManager.e(this.b.d) == 100 || FeedSendManager.e(this.b.d) > 99) {
                        if (this.b.c.isVideo == 1) {
                          this.b.c.setProgress(20);
                        } else {
                          this.b.c.setProgress(99);
                        } 
                        FeedRefreshObserver.a().a(null, 1);
                        return;
                      } 
                      if (FeedSendManager.e(this.b.d) != this.b.c.getProgress()) {
                        if (this.b.c.isVideo == 1) {
                          this.b.c.setProgress((int)(FeedSendManager.e(this.b.d) * 0.2D));
                        } else {
                          this.b.c.setProgress(FeedSendManager.e(this.b.d));
                        } 
                        FeedRefreshObserver.a().a(null, 1);
                        return;
                      } 
                    } 
                  }
                });
          }
          
          public void a(String param1String1, String param1String2) {
            ImageFileLoader.a(null).a(this.a, param1String1).a();
            FeedSendManager.b(this.d).remove(this.b);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < FeedSendManager.c(this.d).size(); i++) {
              String str = FeedSendManager.c(this.d).get(i);
              param1String2 = str;
              if (str.equals(this.b)) {
                FeedSendManager.c(this.d).remove(i);
                FeedSendManager.c(this.d).add(i, param1String1);
                param1String2 = param1String1;
              } 
              stringBuffer.append(param1String2);
              stringBuffer.append(";");
            } 
            this.c.setPics(stringBuffer.toString());
            NewFeedDao.a().b(this.c);
            if (FeedSendManager.b(this.d).size() > 0) {
              FeedSendManager.d(this.d, this.c);
              return;
            } 
            if (this.c.isVideo == 1) {
              if (!TextUtils.isEmpty(this.c.videoPath) && !this.c.videoPath.startsWith("http")) {
                FeedSendManager.e(this.d, this.c);
                return;
              } 
              FeedSendManager.b(this.d, this.c);
              return;
            } 
            this.d.d(this.c);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void a(byte[] paramArrayOfbyte, BluedAlbum paramBluedAlbum, NewFeedModel paramNewFeedModel) {
    QiniuUploadUtils.a(paramArrayOfbyte, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this, paramNewFeedModel) {
          public void a(String param1String) {
            FeedSendManager.a(this.b, this.a);
          }
          
          public void a(String param1String, double param1Double) {
            AppInfo.n().post(new Runnable(this, param1Double) {
                  public void run() {
                    double d = this.a;
                    if (d <= 1.0D) {
                      int i = (int)(100.0D * d) + 20;
                      if (d == 1.0D) {
                        this.b.a.setProgress(99);
                        NewFeedDao.a().b(this.b.a);
                      } 
                      if (i == 100 || i > 99) {
                        this.b.a.setProgress(99);
                        FeedRefreshObserver.a().a(null, 1);
                      } else if (i != this.b.a.getProgress()) {
                        this.b.a.setProgress(i);
                        FeedRefreshObserver.a().a(null, 1);
                      } 
                      Logger.a("ddrb", new Object[] { "progress = ", Integer.valueOf(i) });
                    } 
                  }
                });
          }
          
          public void a(String param1String1, String param1String2) {
            FileUtils.a(param1String1, this.a.videoPath);
            this.a.videoPath = param1String1;
            NewFeedDao.a().b(this.a);
            FeedSendManager.b(this.b, this.a);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void b(Pair<String, UploadModel> paramPair, NewFeedModel paramNewFeedModel) {
    if (StringUtils.e(((UploadModel)paramPair.second).url))
      return; 
    String str = ((UploadModel)paramPair.second).url;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("图片上传成功===");
    stringBuilder2.append(str);
    Logger.e("FeedSend", new Object[] { stringBuilder2.toString() });
    ImageFileLoader.a(null).a(((UploadModel)paramPair.second).compressPath, str).a();
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < this.e.size(); i++) {
      String str2 = this.e.get(i);
      String str1 = str2;
      if (str2.equals(paramPair.first)) {
        this.e.remove(i);
        this.e.add(i, str);
        str1 = str;
      } 
      stringBuffer.append(str1);
      stringBuffer.append(";");
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("图片上传成功===");
    stringBuilder1.append(stringBuffer.toString());
    Logger.e("FeedSend", new Object[] { stringBuilder1.toString() });
    paramNewFeedModel.setPics(stringBuffer.toString());
    ThreadManager.a().a(new ThreadExecutor(this, "update-feedModel", paramNewFeedModel) {
          public void execute() {
            NewFeedDao.a().b(this.a);
          }
        });
  }
  
  private BluedIngSelfFeed e(NewFeedModel paramNewFeedModel) {
    if (paramNewFeedModel == null)
      return null; 
    BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
    bluedIngSelfFeed.feed_id = paramNewFeedModel.feed_id;
    bluedIngSelfFeed.is_videos = String.valueOf(paramNewFeedModel.isVideo);
    if (paramNewFeedModel.isVideo == 1) {
      bluedIngSelfFeed.feed_videos = new String[2];
      bluedIngSelfFeed.feed_videos[0] = paramNewFeedModel.localPath;
      bluedIngSelfFeed.feed_videos[1] = paramNewFeedModel.videoPath;
    } 
    bluedIngSelfFeed.feed_pics = new String[1];
    bluedIngSelfFeed.feed_pics[0] = paramNewFeedModel.localPath;
    bluedIngSelfFeed.circle_id = paramNewFeedModel.circle_id;
    bluedIngSelfFeed.circle_title = paramNewFeedModel.circle_title;
    bluedIngSelfFeed.dataType = 1;
    return bluedIngSelfFeed;
  }
  
  private void f(NewFeedModel paramNewFeedModel) {
    String str1 = this.d.get(0);
    String str2 = RecyclingUtils.e("photo");
    Houyi.a().a(str1, str2).a(new Houyi.OnCompressListener(this, str2, str1, paramNewFeedModel) {
          public void a() {}
          
          public void a(String param1String) {
            FeedHttpUtils.a(null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this) {
                  protected BluedEntityA<BluedAlbum> a(String param2String) {
                    BluedEntityA<BluedAlbum> bluedEntityA = (BluedEntityA)super.parseData(param2String);
                    if (bluedEntityA != null)
                      try {
                        if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                          BluedAlbum bluedAlbum = bluedEntityA.data.get(0);
                          FeedSendManager.a(this.a.d, this.a.a, bluedAlbum, this.a.b, this.a.c);
                          Logger.a("drb", new Object[] { "newPath = ", this.a.a });
                          return bluedEntityA;
                        } 
                      } catch (Exception exception) {
                        exception.printStackTrace();
                      }  
                    return bluedEntityA;
                  }
                  
                  public void a(BluedEntityA<BluedAlbum> param2BluedEntityA) {}
                  
                  public void onFailure(Throwable param2Throwable, int param2Int, String param2String) {
                    super.onFailure(param2Throwable, param2Int, param2String);
                    Logger.a("drb", new Object[] { "getTokenForUploadFeed onFailure = ", Integer.valueOf(param2Int) });
                    FeedSendManager.a(this.a.d, this.a.c);
                  }
                });
          }
          
          public void a(Throwable param1Throwable) {
            Logger.a("drb", new Object[] { "onError = ", param1Throwable });
            FeedSendManager.a(this.d, this.c);
          }
        }).a();
  }
  
  private void g(NewFeedModel paramNewFeedModel) {
    AppInfo.n().post(new Runnable(this, paramNewFeedModel) {
          public void run() {
            this.a.setState(0);
            FeedRefreshObserver.a().a(FeedSendManager.c(this.b, this.a), 0);
            NewFeedDao.a().b(this.a);
            FeedSendManager.a(this.b).remove(this.a);
            this.b.f();
          }
        });
  }
  
  private void h(NewFeedModel paramNewFeedModel) {
    FeedHttpUtils.b(null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, paramNewFeedModel) {
          protected BluedEntityA<BluedAlbum> a(String param1String) {
            BluedEntityA<BluedAlbum> bluedEntityA = (BluedEntityA)super.parseData(param1String);
            if (bluedEntityA != null)
              try {
                if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                  BluedAlbum bluedAlbum = bluedEntityA.data.get(0);
                  FeedSendManager.a(this.b, FileUtils.a(this.a.videoPath), bluedAlbum, this.a);
                  return bluedEntityA;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
            return bluedEntityA;
          }
          
          public void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {}
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            FeedSendManager.a(this.b, this.a);
          }
          
          public void onUIStart() {}
        });
  }
  
  private void i() {
    this.d.clear();
    this.e.clear();
    this.g = 0;
    this.h = 0;
  }
  
  private void i(NewFeedModel paramNewFeedModel) {
    String[] arrayOfString;
    if (!(UserInfo.a().i()).uid.equals(String.valueOf(paramNewFeedModel.getLoadName()))) {
      j();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("video====");
    stringBuilder.append((System.currentTimeMillis() - this.k) / 1000L);
    stringBuilder.append("==end==");
    stringBuilder.append(System.currentTimeMillis());
    Logger.e("FeedSend", new Object[] { stringBuilder.toString() });
    String str1 = paramNewFeedModel.videoPath;
    if (!TextUtils.isEmpty(paramNewFeedModel.getPics())) {
      arrayOfString = paramNewFeedModel.getPics().split(";");
    } else {
      arrayOfString = new String[1];
    } 
    BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed>>(this, paramNewFeedModel) {
        public void onSuccess(String param1String) {
          super.onSuccess(param1String);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onSuccess content");
          stringBuilder.append(param1String);
          Logger.e("FeedSend", new Object[] { stringBuilder.toString() });
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          FeedSendManager.a(this.b, this.a);
          Logger.e("FeedSend", new Object[] { "onUIFailure successed" });
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed> param1BluedEntity) {
          if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
            FeedSendManager.a(this.b, (BluedIngSelfFeed)param1BluedEntity.extra, this.a);
            Logger.e("FeedSend", new Object[] { "onUIUpdate successed" });
            return;
          } 
          Logger.e("FeedSend", new Object[] { "else onUIUpdate successed" });
        }
      };
    String str2 = this.i;
    String str3 = this.j;
    double d = paramNewFeedModel.duration;
    FeedHttpUtils.a(bluedUIHttpResponse, paramNewFeedModel, str2, str3, arrayOfString, new String[] { str1 }, String.valueOf(480), String.valueOf(480), d);
  }
  
  private void j() {
    FeedRefreshObserver.a().a(null, 4);
    i();
  }
  
  private void j(NewFeedModel paramNewFeedModel) {
    Logger.a("drb", new Object[] { "feedForward content = ", paramNewFeedModel.getContent() });
    FeedHttpUtils.a(null, new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed>>(this, paramNewFeedModel) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            FeedSendManager.a(this.b, this.a);
          }
          
          public void onUIStart() {}
          
          public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed> param1BluedEntity) {
            if (param1BluedEntity != null)
              try {
                if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
                  FeedSendManager.a(this.b, (BluedIngSelfFeed)param1BluedEntity.extra, this.a);
                  FeedRepost feedRepost = new FeedRepost();
                  feedRepost.feed_id = this.a.feed_id;
                  feedRepost.repost_id = ((BluedIngSelfFeed)param1BluedEntity.getSingleData()).feed_id;
                  feedRepost.repost_uid = UserInfo.a().i().getUid();
                  feedRepost.user_avatar = UserInfo.a().i().getAvatar();
                  feedRepost.user_name = UserInfo.a().i().getName();
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(this.a.getTime());
                  stringBuilder.append("");
                  feedRepost.repost_timestamp = stringBuilder.toString();
                  feedRepost.vbadge = UserInfo.a().i().getVBadge();
                  feedRepost.repost_content = this.a.getContent();
                  feedRepost.repost_also_comment = this.a.repost_also_comment;
                  Logger.a("drb", new Object[] { "feedForward repost_content = ", feedRepost.repost_content });
                  Logger.a("drb", new Object[] { "feedForward forwardContent = ", this.a.forwardContent });
                  RepostListDataObserver.b().a(feedRepost);
                  LiveEventBus.get("feed_add_repost").post(feedRepost);
                  if (((BluedIngSelfFeed)param1BluedEntity.extra).repost_also_comment == 1)
                    this.b.a(this.a.feed_id, feedRepost.repost_content); 
                  UserInfoDataObserver.a().c();
                  return;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
          }
          
          public BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed> parseData(String param1String) {
            return super.parseData(param1String);
          }
        }paramNewFeedModel.feed_id, paramNewFeedModel.getContent(), paramNewFeedModel.allow_comments, paramNewFeedModel.reading_scope, paramNewFeedModel.is_ads, paramNewFeedModel.address, paramNewFeedModel.getLng(), paramNewFeedModel.getLat(), paramNewFeedModel.is_super_topics, paramNewFeedModel.super_did, paramNewFeedModel.share_posting_id, paramNewFeedModel.repost_also_comment);
  }
  
  public void a(NewFeedModel paramNewFeedModel) {
    this.k = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startUpload========");
    stringBuilder.append(this.k);
    Logger.e("FeedSend", new Object[] { stringBuilder.toString() });
    if (paramNewFeedModel == null)
      return; 
    if (paramNewFeedModel.getLoadName() == 0L)
      return; 
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      paramNewFeedModel.setState(1);
      this.b.add(0, paramNewFeedModel);
      if (this.c.size() <= 0) {
        this.c.add(0, paramNewFeedModel);
        f();
      } else {
        this.c.add(0, paramNewFeedModel);
      } 
      FeedRefreshObserver.a().a(null, 3);
      return;
    } 
    throw new RuntimeException("Only the original thread can start upload feed.");
  }
  
  public void a(String paramString1, String paramString2) {
    FeedComment feedComment = new FeedComment();
    BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed(paramString1);
    paramString1 = paramString2;
    if (StringUtils.e(paramString2))
      paramString1 = AppInfo.d().getString(2131756411); 
    FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<FeedComment>>(this, null) {
          public void a(BluedEntityA<FeedComment> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              FeedComment feedComment = param1BluedEntityA.data.get(0);
              LiveEventBus.get("feed_post_meanwhile_comment").post(feedComment);
            } 
          }
        }bluedIngSelfFeed, feedComment, paramString1, null);
  }
  
  public void b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Build.MANUFACTURER);
    stringBuilder.append(Build.MODEL);
    this.j = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("Android");
    stringBuilder.append(Build.VERSION.RELEASE);
    this.i = stringBuilder.toString();
    this.b = NewFeedDao.a().c();
    List<NewFeedModel> list = this.b;
    if (list != null && list.size() > 0) {
      Collections.reverse(this.b);
      for (int i = 0; i < this.b.size(); i++) {
        NewFeedModel newFeedModel = this.b.get(i);
        newFeedModel.setState(0);
        NewFeedDao.a().b(newFeedModel);
      } 
      FeedRefreshObserver.a().a(null, 0);
    } 
  }
  
  public void b(NewFeedModel paramNewFeedModel) {
    paramNewFeedModel.setState(1);
    paramNewFeedModel.isResend = true;
    if (this.c.size() <= 0) {
      Log.d("FendSend", "restartUploadmSendingList.add");
      this.c.add(0, paramNewFeedModel);
      f();
    } else {
      this.c.add(0, paramNewFeedModel);
    } 
    FeedRefreshObserver.a().a(null, 3);
  }
  
  public ArrayMap<String, String> c() {
    return this.f;
  }
  
  public void c(NewFeedModel paramNewFeedModel) {
    List<NewFeedModel> list = this.b;
    if (list != null && list.size() > 0) {
      if (!this.b.remove(paramNewFeedModel))
        for (int i = 0; i < this.b.size(); i++) {
          if (paramNewFeedModel.getId() == ((NewFeedModel)this.b.get(i)).getId()) {
            this.b.remove(i);
            break;
          } 
        }  
      FeedRefreshObserver.a().a(null, 4);
    } 
  }
  
  public List<NewFeedModel> d() {
    return this.b;
  }
  
  public void d(NewFeedModel paramNewFeedModel) {
    BluedUIHttpResponse<BluedEntity<FeedComment, BluedIngSelfFeed>> bluedUIHttpResponse;
    boolean bool1 = (UserInfo.a().i()).uid.equals(String.valueOf(paramNewFeedModel.getLoadName()));
    boolean bool = false;
    if (!bool1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("切换账号====");
      stringBuilder1.append(paramNewFeedModel.getLoadName());
      stringBuilder1.append("=loginInfo==");
      stringBuilder1.append((UserInfo.a().i()).uid);
      Logger.e("FeedSend", new Object[] { stringBuilder1.toString() });
      j();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("time====");
    stringBuilder.append((System.currentTimeMillis() - this.k) / 1000L);
    Logger.e("FeedSend", new Object[] { stringBuilder.toString() });
    String[] arrayOfString1 = new String[this.e.size()];
    for (int i = 0; i < this.e.size(); i++)
      arrayOfString1[i] = this.e.get(i); 
    String[] arrayOfString2 = ImageUtils.a(paramNewFeedModel.localPath);
    if (!StringUtils.e(paramNewFeedModel.extraJSON)) {
      Gson gson = AppInfo.f();
      FeedExtra feedExtra = (FeedExtra)gson.fromJson(paramNewFeedModel.extraJSON, FeedExtra.class);
      if (feedExtra.thumb == null || feedExtra.thumb.size() <= 0)
        feedExtra.thumb = new ArrayList(); 
      if (arrayOfString1.length > 0)
        feedExtra.thumb.add(arrayOfString1[0]); 
      paramNewFeedModel.extraJSON = gson.toJson(feedExtra);
    } 
    if (paramNewFeedModel.is_circle_comment == 1) {
      bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<FeedComment, BluedIngSelfFeed>>(this, paramNewFeedModel) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            BluedHttpUtils.b(param1Throwable, param1Int, param1String);
            FeedSendManager.a(this.b, this.a);
          }
          
          public void onUIUpdate(BluedEntity<FeedComment, BluedIngSelfFeed> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0)
              FeedSendManager.a(this.b, param1BluedEntity.data.get(0), this.a); 
          }
          
          public BluedEntity<FeedComment, BluedIngSelfFeed> parseData(String param1String) {
            return super.parseData(param1String);
          }
        };
      String str1 = paramNewFeedModel.feed_id;
      String str2 = paramNewFeedModel.getContent();
      if (paramNewFeedModel.is_anonym == 1)
        bool = true; 
      FeedHttpUtils.a(bluedUIHttpResponse, str1, str2, arrayOfString1, bool);
      return;
    } 
    FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed>>(this, paramNewFeedModel) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            BluedHttpUtils.b(param1Throwable, param1Int, param1String);
            FeedSendManager.a(this.b, this.a);
          }
          
          public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed> param1BluedEntity) {
            if (param1BluedEntity != null)
              try {
                if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
                  FeedSendManager.a(this.b, (BluedIngSelfFeed)param1BluedEntity.extra, this.a);
                  if (this.a.repost_also_comment == 1) {
                    this.b.a(this.a.feed_id, ((BluedIngSelfFeed)param1BluedEntity.extra).feed_content);
                    return;
                  } 
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
          }
          
          public BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed> parseData(String param1String) {
            return super.parseData(param1String);
          }
        }paramNewFeedModel, this.i, this.j, arrayOfString1, null, (String)bluedUIHttpResponse[0], (String)bluedUIHttpResponse[1], 0.0D);
  }
  
  public int e() {
    return this.b.size();
  }
  
  public void f() {
    i();
    List<NewFeedModel> list = this.c;
    if (list != null && list.size() > 0) {
      Pair<String, String> pair;
      list = this.c;
      int i = 0;
      NewFeedModel newFeedModel = list.get(0);
      String str = newFeedModel.getPics();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Pic====");
      stringBuilder.append(newFeedModel.getPics());
      Logger.e("FeedSend", new Object[] { stringBuilder.toString() });
      stringBuilder = null;
      if (newFeedModel.isVideo == 1) {
        Pair<String, String> pair1;
        if (!TextUtils.isEmpty(str)) {
          String[] arrayOfString = str.split(";");
          stringBuilder = null;
          for (i = 0; i < arrayOfString.length; i++) {
            this.e.add(arrayOfString[i]);
            if (!arrayOfString[i].startsWith("http"))
              pair1 = new Pair(arrayOfString[i], ""); 
          } 
        } 
        pair = new Pair(newFeedModel.videoPath, "");
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("videoPath=====");
        stringBuilder1.append(newFeedModel.videoPath);
        Logger.e("FeedSend", new Object[] { stringBuilder1.toString() });
        VideoUploadManager.a().a(newFeedModel.videoTaskID, pair1, pair, new VideoUploadManager.VideoUploadListener(this, newFeedModel) {
              public void a(String param1String, int param1Int) {
                if (!StringUtils.e(this.a.videoTaskID) && !param1String.equals(this.a.videoTaskID)) {
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("feedModel.videoTaskID");
                  stringBuilder1.append(this.a.videoTaskID);
                  stringBuilder1.append("taskId");
                  stringBuilder1.append(param1String);
                  Logger.e("FeedSend", new Object[] { stringBuilder1.toString() });
                  return;
                } 
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("video===progress==");
                stringBuilder.append(param1Int);
                Logger.e("FeedSend", new Object[] { stringBuilder.toString() });
                this.a.setProgress(param1Int);
                AppInfo.n().post(new Runnable(this) {
                      public void run() {
                        FeedRefreshObserver.a().a(null, 1);
                      }
                    });
              }
              
              public void a(String param1String, boolean param1Boolean, ArrayList<Pair<String, UploadModel>> param1ArrayList, List<Pair<String, String>> param1List) {
                StringBuilder stringBuilder2;
                boolean bool = StringUtils.e(this.a.videoTaskID);
                int i = 0;
                if (!bool && !param1String.equals(this.a.videoTaskID)) {
                  stringBuilder2 = new StringBuilder();
                  stringBuilder2.append("feedModel.videoTaskID");
                  stringBuilder2.append(this.a.videoTaskID);
                  stringBuilder2.append("taskId");
                  stringBuilder2.append(param1String);
                  Logger.e("FeedSend", new Object[] { stringBuilder2.toString() });
                  return;
                } 
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("onFinish succeed ");
                stringBuilder1.append(param1Boolean);
                Logger.e("FeedSend", new Object[] { stringBuilder1.toString() });
                if (stringBuilder2 != null) {
                  while (i < stringBuilder2.size()) {
                    FeedSendManager.a(this.b, stringBuilder2.get(i), this.a);
                    i++;
                  } 
                } else {
                  Logger.e("FeedSend", new Object[] { "onFinish partArrayList is null" });
                } 
                if (param1Boolean) {
                  FeedSendManager.b(this.b, this.a);
                  return;
                } 
                FeedSendManager.a(this.b, this.a);
              }
            });
        return;
      } 
      if (newFeedModel.is_repost == 1) {
        j(newFeedModel);
        return;
      } 
      ArrayList<Pair> arrayList = new ArrayList();
      if (!TextUtils.isEmpty((CharSequence)pair)) {
        String[] arrayOfString = pair.split(";");
        while (i < arrayOfString.length) {
          this.e.add(arrayOfString[i]);
          if (!arrayOfString[i].startsWith("http"))
            arrayList.add(new Pair(arrayOfString[i], "")); 
          i++;
        } 
        if (arrayList.size() == 0) {
          d(newFeedModel);
          return;
        } 
        this.h = newFeedModel.getProgress();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(BluedHttpUrl.n());
        stringBuilder1.append("/blued/qiniu?filter=token&action=ticktocks");
        MediaSender.a(stringBuilder1.toString(), arrayList, true, true, new SenderListener(this, newFeedModel) {
              public void a(String param1String, int param1Int) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("img===progress==");
                stringBuilder.append(param1Int);
                Logger.e("FeedSend", new Object[] { stringBuilder.toString() });
                this.a.setProgress(param1Int);
                AppInfo.n().post(new Runnable(this) {
                      public void run() {
                        FeedRefreshObserver.a().a(null, 1);
                      }
                    });
              }
              
              public void a(String param1String, Pair<String, UploadModel> param1Pair) {
                Logger.e("SendManager", new Object[] { "onPartFinish=======" });
                FeedSendManager.b(this.b, param1Pair, this.a);
              }
              
              public void a(String param1String, boolean param1Boolean, List<Pair<String, String>> param1List) {
                if (param1Boolean) {
                  this.b.d(this.a);
                  return;
                } 
                FeedSendManager.a(this.b, this.a);
              }
            });
        return;
      } 
      d(newFeedModel);
    } 
  }
  
  public void g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/List;
    //   6: ifnull -> 87
    //   9: aload_0
    //   10: getfield b : Ljava/util/List;
    //   13: invokeinterface size : ()I
    //   18: ifle -> 87
    //   21: iconst_0
    //   22: istore_3
    //   23: iconst_0
    //   24: istore_1
    //   25: iload_3
    //   26: istore_2
    //   27: iload_1
    //   28: aload_0
    //   29: getfield b : Ljava/util/List;
    //   32: invokeinterface size : ()I
    //   37: if_icmpge -> 72
    //   40: aload_0
    //   41: getfield b : Ljava/util/List;
    //   44: iload_1
    //   45: invokeinterface get : (I)Ljava/lang/Object;
    //   50: checkcast com/soft/blued/db/model/NewFeedModel
    //   53: invokevirtual getState : ()I
    //   56: ifne -> 105
    //   59: invokestatic a : ()Lcom/soft/blued/ui/find/observer/FeedRefreshObserver;
    //   62: aconst_null
    //   63: iconst_0
    //   64: invokevirtual a : (Ljava/lang/Object;I)V
    //   67: iconst_1
    //   68: istore_2
    //   69: goto -> 72
    //   72: iload_2
    //   73: ifne -> 95
    //   76: invokestatic a : ()Lcom/soft/blued/ui/find/observer/FeedRefreshObserver;
    //   79: aconst_null
    //   80: iconst_5
    //   81: invokevirtual a : (Ljava/lang/Object;I)V
    //   84: goto -> 95
    //   87: invokestatic a : ()Lcom/soft/blued/ui/find/observer/FeedRefreshObserver;
    //   90: aconst_null
    //   91: iconst_5
    //   92: invokevirtual a : (Ljava/lang/Object;I)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: astore #4
    //   100: aload_0
    //   101: monitorexit
    //   102: aload #4
    //   104: athrow
    //   105: iload_1
    //   106: iconst_1
    //   107: iadd
    //   108: istore_1
    //   109: goto -> 25
    // Exception table:
    //   from	to	target	type
    //   2	21	98	finally
    //   27	67	98	finally
    //   76	84	98	finally
    //   87	95	98	finally
  }
  
  public int h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/List;
    //   6: astore #5
    //   8: iconst_0
    //   9: istore_1
    //   10: aload #5
    //   12: ifnull -> 84
    //   15: aload_0
    //   16: getfield b : Ljava/util/List;
    //   19: invokeinterface size : ()I
    //   24: ifle -> 84
    //   27: iconst_0
    //   28: istore_2
    //   29: iload_1
    //   30: aload_0
    //   31: getfield b : Ljava/util/List;
    //   34: invokeinterface size : ()I
    //   39: if_icmpge -> 80
    //   42: aload_0
    //   43: getfield b : Ljava/util/List;
    //   46: iload_1
    //   47: invokeinterface get : (I)Ljava/lang/Object;
    //   52: checkcast com/soft/blued/db/model/NewFeedModel
    //   55: invokevirtual getState : ()I
    //   58: istore #4
    //   60: iload_2
    //   61: istore_3
    //   62: iload #4
    //   64: ifne -> 71
    //   67: iload_2
    //   68: iconst_1
    //   69: iadd
    //   70: istore_3
    //   71: iload_1
    //   72: iconst_1
    //   73: iadd
    //   74: istore_1
    //   75: iload_3
    //   76: istore_2
    //   77: goto -> 29
    //   80: aload_0
    //   81: monitorexit
    //   82: iload_2
    //   83: ireturn
    //   84: aload_0
    //   85: monitorexit
    //   86: iconst_0
    //   87: ireturn
    //   88: astore #5
    //   90: aload_0
    //   91: monitorexit
    //   92: aload #5
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	88	finally
    //   15	27	88	finally
    //   29	60	88	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\manager\FeedSendManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */