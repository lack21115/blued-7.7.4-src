package com.blued.android.module.shortvideo.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.FileUtils;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.base.shortvideo.ISaveInterface;
import com.blued.android.module.base.shortvideo.ITranscodingVideoListener;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.external_sense_library.manager.SenseTimeFactory;
import com.blued.android.module.external_sense_library.manager.SenseTimeQiniuEditVideoManager;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.model.FilterItem;
import com.blued.android.module.shortvideo.model.VideoFrameModel;
import com.qiniu.pili.droid.shortvideo.PLShortVideoEditor;
import com.qiniu.pili.droid.shortvideo.PLShortVideoTranscoder;
import com.qiniu.pili.droid.shortvideo.PLVideoEditSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class StvMediaUtils {
  static PLShortVideoEditor a;
  
  static PLShortVideoTranscoder b;
  
  public static EditDataModel a(String paramString) {
    EditDataModel editDataModel = new EditDataModel();
    editDataModel.setSaveVideoPath(paramString);
    editDataModel.isNeedTranscodeAgain(paramString);
    if (!editDataModel.isTranscode()) {
      MediaExtractor mediaExtractor = new MediaExtractor();
      try {
        mediaExtractor.setDataSource(paramString);
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
        paramString = mediaExtractor.getTrackFormat(i).getString("mime");
        if (paramString.startsWith("video/")) {
          if (paramString.equals("video/avc")) {
            (editDataModel.getSerializableData()).p = false;
            return editDataModel;
          } 
          (editDataModel.getSerializableData()).p = true;
          return editDataModel;
        } 
      } 
    } 
    return editDataModel;
  }
  
  public static void a() {
    PLShortVideoTranscoder pLShortVideoTranscoder = b;
    if (pLShortVideoTranscoder != null)
      pLShortVideoTranscoder.cancelTranscode(); 
  }
  
  public static void a(Context paramContext, CommonModel paramCommonModel, EditDataModel.SerializableData paramSerializableData, int paramInt1, int paramInt2, ISaveInterface paramISaveInterface) {
    if (paramCommonModel == null && paramSerializableData == null) {
      if (paramISaveInterface != null)
        paramISaveInterface.a(-1); 
      return;
    } 
    EditDataModel editDataModel = new EditDataModel();
    editDataModel.copyModel(paramCommonModel, paramSerializableData);
    editDataModel.setScreenWidth((paramContext.getResources().getDisplayMetrics()).widthPixels);
    String str = editDataModel.getSerializableData().getVideoPath();
    if (StringUtils.a(str)) {
      if (paramISaveInterface != null)
        paramISaveInterface.a(-1); 
      return;
    } 
    GLSurfaceView gLSurfaceView = new GLSurfaceView(paramContext);
    gLSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
    PLVideoEditSetting pLVideoEditSetting = new PLVideoEditSetting();
    pLVideoEditSetting.setSourceFilepath(str);
    pLVideoEditSetting.setDestFilepath(StvTools.c());
    a = new PLShortVideoEditor(gLSurfaceView, pLVideoEditSetting);
    if (editDataModel.getSerializableData().isHasBgMusic())
      a(editDataModel, a, editDataModel.getSerializableData().getMusicPath()); 
    float f2 = (editDataModel.getSerializableData()).a / 100.0F;
    float f1 = 0.0F;
    if (editDataModel.getSerializableData().isHasBgMusic())
      f1 = (editDataModel.getSerializableData()).b / 100.0F; 
    a.setAudioMixVolume(f2, f1);
    SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = (SenseTimeQiniuEditVideoManager)SenseTimeFactory.createInstance(paramContext, 2);
    FilterItem filterItem = editDataModel.getSerializableData().getSelectedFilter();
    if (filterItem != null) {
      senseTimeQiniuEditVideoManager.enableBeautify(false);
      senseTimeQiniuEditVideoManager.setFilterStyle(filterItem.b());
    } 
    editDataModel.calculateEncodingSize(editDataModel.getVideoBitrate(), editDataModel.getVideoWidth(), editDataModel.getVideoHeight());
    if (editDataModel.getVideoBitrate() != editDataModel.getEncodingVideoBitrate() || editDataModel.getVideoHeight() != editDataModel.getEncodingH() || editDataModel.getVideoWidth() != editDataModel.getEncodingW()) {
      PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(paramContext);
      pLVideoEncodeSetting.setEncodingBitrate(editDataModel.getEncodingVideoBitrate());
      pLVideoEncodeSetting.setEncodingFps(30);
      pLVideoEncodeSetting.setHWCodecEnabled(VideoConfigData.a.booleanValue());
      pLVideoEncodeSetting.setEncodingBitrateMode(PLVideoEncodeSetting.BitrateMode.QUALITY_PRIORITY);
      pLVideoEncodeSetting.setPreferredEncodingSize(editDataModel.getEncodingW(), editDataModel.getEncodingH());
      a.setVideoEncodeSetting(pLVideoEncodeSetting);
    } 
    a.setVideoSaveListener(new PLVideoSaveListener(paramInt1, editDataModel, paramContext, paramISaveInterface) {
          public void onProgressUpdate(float param1Float) {
            ISaveInterface iSaveInterface = this.d;
            if (iSaveInterface != null)
              iSaveInterface.a(param1Float); 
          }
          
          public void onSaveVideoCanceled() {
            ISaveInterface iSaveInterface = this.d;
            if (iSaveInterface != null)
              iSaveInterface.a(); 
            StvMediaUtils.a = null;
          }
          
          public void onSaveVideoFailed(int param1Int) {
            ISaveInterface iSaveInterface = this.d;
            if (iSaveInterface != null)
              iSaveInterface.a(param1Int); 
            StvMediaUtils.a = null;
          }
          
          public void onSaveVideoSuccess(String param1String) {
            int i = this.a;
            if (i == 0 || i == 3) {
              StvMediaUtils.a(this.b, this.c, param1String, this.a, this.d);
            } else {
              StvMediaUtils.a(this.b, param1String, this.c, i, this.d);
            } 
            StvMediaUtils.a = null;
          }
        });
    if (filterItem == null) {
      if (editDataModel.getSerializableData().isHasBgMusic() && paramISaveInterface != null)
        paramISaveInterface.b(); 
      a.save();
      return;
    } 
    if (paramISaveInterface != null)
      paramISaveInterface.b(); 
    a.save(new PLVideoFilterListener(senseTimeQiniuEditVideoManager) {
          public int onDrawFrame(int param1Int1, int param1Int2, int param1Int3, long param1Long, float[] param1ArrayOffloat) {
            return this.a.drawFrame(param1Int1, param1Int2, param1Int3, false);
          }
          
          public void onSurfaceChanged(int param1Int1, int param1Int2) {
            this.a.adjustViewPort(param1Int1, param1Int2);
          }
          
          public void onSurfaceCreated() {
            this.a.onSurfaceCreated();
          }
          
          public void onSurfaceDestroy() {
            this.a.onSurfaceDestroyed();
          }
        });
  }
  
  public static void a(Context paramContext, String paramString) {
    if (!StringUtils.a(paramString)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("photoAlbumScanFile filepath");
      stringBuilder.append(paramString);
      Logger.c("StvMediaUtils", new Object[] { stringBuilder.toString() });
      ThreadManager.a().a(new ThreadExecutor("compressVideoToAndroidQ", paramString, paramContext) {
            public void execute() {
              StvMediaUtils.a(this.a, this.b);
            }
          });
    } 
  }
  
  public static void a(EditDataModel paramEditDataModel, ITranscodingVideoListener paramITranscodingVideoListener) {
    if (paramITranscodingVideoListener != null) {
      if (paramEditDataModel == null)
        return; 
      String str = StvTools.e();
      paramEditDataModel.calculateEncodingSize(paramEditDataModel.getVideoBitrate(), paramEditDataModel.getVideoWidth(), paramEditDataModel.getVideoHeight());
      b = new PLShortVideoTranscoder(AppInfo.d(), paramEditDataModel.getSaveVideoPath(), str);
      b.transcode(paramEditDataModel.getEncodingW(), paramEditDataModel.getEncodingH(), paramEditDataModel.getEncodingVideoBitrate(), new PLVideoSaveListener(paramITranscodingVideoListener, paramEditDataModel) {
            public void onProgressUpdate(float param1Float) {
              this.a.a(this.b.getSaveVideoPath(), (param1Float * 100.0F));
            }
            
            public void onSaveVideoCanceled() {
              this.a.a(false, this.b.getSaveVideoPath(), null);
            }
            
            public void onSaveVideoFailed(int param1Int) {
              this.a.a(false, this.b.getSaveVideoPath(), null);
            }
            
            public void onSaveVideoSuccess(String param1String) {
              this.a.a(true, this.b.getSaveVideoPath(), param1String);
              this.b.setSaveVideoPath(param1String);
            }
          });
    } 
  }
  
  public static void a(EditDataModel paramEditDataModel, PLShortVideoEditor paramPLShortVideoEditor, String paramString) {
    paramEditDataModel.getSerializableData().setHasBgMusic(true);
    paramEditDataModel.getSerializableData().setMusicPath(paramString);
    paramPLShortVideoEditor.setAudioMixFile(paramString);
    a(paramPLShortVideoEditor, paramEditDataModel, paramEditDataModel.getCurrentFgVolume(), 100);
  }
  
  public static void a(PLShortVideoEditor paramPLShortVideoEditor, EditDataModel paramEditDataModel, int paramInt1, int paramInt2) {
    paramEditDataModel.setCurrentFgVolume(paramInt1);
    paramEditDataModel.setCurrentBgVolume(paramInt2);
    if (paramPLShortVideoEditor != null)
      paramPLShortVideoEditor.setAudioMixVolume(paramInt1 / 100.0F, paramInt2 / 100.0F); 
  }
  
  public static void a(String paramString, Context paramContext) {
    if (TextUtils.isEmpty(paramString))
      return; 
    File file = new File(paramString);
    if (!file.exists())
      return; 
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    mediaMetadataRetriever.setDataSource(paramString);
    if (mediaMetadataRetriever.extractMetadata(18) != null && mediaMetadataRetriever.extractMetadata(19) != null) {
      Uri uri1;
      if (mediaMetadataRetriever.extractMetadata(9) == null)
        return; 
      int i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
      int j = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
      int k = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
      long l = System.currentTimeMillis();
      String str1 = file.getName();
      String str2 = file.getName();
      ContentValues contentValues = new ContentValues(9);
      contentValues.put("title", str1);
      contentValues.put("_display_name", str2);
      contentValues.put("datetaken", Long.valueOf(l));
      contentValues.put("date_modified", Long.valueOf(l / 1000L));
      contentValues.put("mime_type", "video/mp4");
      contentValues.put("width", Integer.valueOf(i));
      contentValues.put("height", Integer.valueOf(j));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Integer.toString(i));
      stringBuilder.append("x");
      stringBuilder.append(Integer.toString(j));
      contentValues.put("resolution", stringBuilder.toString());
      contentValues.put("_size", Long.valueOf((new File(paramString)).length()));
      contentValues.put("duration", Integer.valueOf(k));
      if (AppUtils.b()) {
        contentValues.put("relative_path", "DCIM/Camera");
      } else {
        contentValues.put("_data", paramString);
      } 
      ContentResolver contentResolver = paramContext.getContentResolver();
      paramString = null;
      try {
        Uri uri = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        uri1 = uri;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      Uri uri2 = uri1;
      if (uri1 == null)
        try {
          uri2 = contentResolver.insert(MediaStore.Video.Media.INTERNAL_CONTENT_URI, contentValues);
        } catch (Exception exception) {
          exception.printStackTrace();
          uri2 = uri1;
        }  
      if (AppUtils.b())
        try {
          OutputStream outputStream = contentResolver.openOutputStream(uri2);
          FileInputStream fileInputStream = new FileInputStream(file);
          FileUtils.copy(fileInputStream, outputStream);
          fileInputStream.close();
          outputStream.close();
          return;
        } catch (IOException iOException) {
          iOException.printStackTrace();
        }  
    } 
  }
  
  private static void b(EditDataModel paramEditDataModel, int paramInt, ISaveInterface paramISaveInterface) {
    if (paramISaveInterface != null) {
      if (paramEditDataModel == null)
        return; 
      StvResultModel stvResultModel = new StvResultModel();
      stvResultModel.a(true);
      stvResultModel.b(paramEditDataModel.getCoverImgPath());
      stvResultModel.c(paramEditDataModel.getSaveVideoPath());
      stvResultModel.a(paramEditDataModel.getSaveVideoWidth());
      stvResultModel.b(paramEditDataModel.getSaveVideoHeight());
      stvResultModel.a(paramEditDataModel.getSaveDurationMs());
      stvResultModel.b(paramEditDataModel.getVideoSize());
      stvResultModel.d(paramEditDataModel.getSerializableData().getMusicId());
      stvResultModel.c(paramEditDataModel.getSerializableData().getSelectFilterPosition());
      if (paramInt == 1 || paramInt == 7)
        stvResultModel.b(paramEditDataModel.isAutoDelete()); 
      paramISaveInterface.a(stvResultModel);
    } 
  }
  
  private static void b(EditDataModel paramEditDataModel, Context paramContext, String paramString, int paramInt, ISaveInterface paramISaveInterface) {
    String str1 = paramEditDataModel.getSerializableData().getVideoPath();
    String str2 = paramEditDataModel.getNeedDeleteVideoPath();
    boolean bool = paramEditDataModel.getSerializableData().isCanDeleteVideoFile();
    StvThreadPoolHelper.a().a(new StvThreadPoolHelper.StvThread(new Runnable(bool, str1, paramEditDataModel, paramString, str2) {
            public void run() {
              if (this.a && !TextUtils.isEmpty(this.b) && !this.b.equals(this.c.getSerializableData().getOriginalVideoPath()) && !this.b.equals(this.d)) {
                File file = new File(this.b);
                if (file.exists())
                  file.delete(); 
              } 
              if (!TextUtils.isEmpty(this.e) && !this.e.equals(this.c.getSerializableData().getOriginalVideoPath()) && !this.e.equals(this.d)) {
                File file = new File(this.e);
                if (file.exists())
                  file.delete(); 
              } 
            }
          }));
    if (paramEditDataModel.getSerializableData().isAddAblum())
      a(paramContext, paramString); 
    paramEditDataModel.setSaveVideoPath(paramString);
    paramEditDataModel.getSerializableData().setMusicPath(paramEditDataModel.getSerializableData().getMusicPath());
    if (TextUtils.isEmpty(paramEditDataModel.getCoverImgPath())) {
      VideoFrameModel.getInstance().saveVideoFrameByTime(paramEditDataModel.getSaveVideoPath(), paramEditDataModel.getCurrentCoverTime(), new IStvVideoFrameForTimeCallback(paramEditDataModel, paramInt, paramISaveInterface) {
            public void a(String param1String) {
              (new Thread(new Runnable(this, param1String) {
                    public void run() {
                      this.b.a.setCoverImgPath(this.a);
                      StvMediaUtils.a(this.b.a, this.b.b, this.b.c);
                    }
                  })).start();
            }
          });
      return;
    } 
    b(paramEditDataModel, paramInt, paramISaveInterface);
  }
  
  private static void b(EditDataModel paramEditDataModel, String paramString, Context paramContext, int paramInt, ISaveInterface paramISaveInterface) {
    PLShortVideoTranscoder pLShortVideoTranscoder;
    if (paramEditDataModel == null)
      return; 
    if (paramEditDataModel.isNeedTranscodeAgain(paramString)) {
      String str = StvTools.e();
      paramEditDataModel.setNeedDeleteVideoPath(paramString);
      paramEditDataModel.calculateEncodingSize(paramEditDataModel.getVideoBitrate(), paramEditDataModel.getVideoWidth(), paramEditDataModel.getVideoHeight());
      pLShortVideoTranscoder = new PLShortVideoTranscoder(paramContext, paramString, str);
      if (paramISaveInterface != null)
        paramISaveInterface.b(); 
      pLShortVideoTranscoder.transcode(paramEditDataModel.getEncodingW(), paramEditDataModel.getEncodingH(), paramEditDataModel.getEncodingVideoBitrate(), new PLVideoSaveListener(paramEditDataModel, paramContext, paramInt, paramISaveInterface) {
            public void onProgressUpdate(float param1Float) {
              ISaveInterface iSaveInterface = this.d;
              if (iSaveInterface != null)
                iSaveInterface.a(param1Float); 
            }
            
            public void onSaveVideoCanceled() {
              ISaveInterface iSaveInterface = this.d;
              if (iSaveInterface != null)
                iSaveInterface.a(); 
            }
            
            public void onSaveVideoFailed(int param1Int) {
              ISaveInterface iSaveInterface = this.d;
              if (iSaveInterface != null)
                iSaveInterface.a(param1Int); 
            }
            
            public void onSaveVideoSuccess(String param1String) {
              StvMediaUtils.a(this.a, this.b, param1String, this.c, this.d);
            }
          });
      return;
    } 
    if (paramEditDataModel.getSerializableData().getVideoPath().equals(pLShortVideoTranscoder) || pLShortVideoTranscoder.equals(paramEditDataModel.getSerializableData().getOriginalVideoPath())) {
      paramEditDataModel.getSerializableData().setCanDeleteVideoFile(false);
    } else {
      paramEditDataModel.getSerializableData().setCanDeleteVideoFile(true);
    } 
    b(paramEditDataModel, paramContext, (String)pLShortVideoTranscoder, paramInt, paramISaveInterface);
  }
  
  public static byte[] b(String paramString) {
    try {
      FileInputStream fileInputStream = new FileInputStream(new File(paramString));
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        int i = fileInputStream.read(arrayOfByte);
        if (i != -1) {
          byteArrayOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        fileInputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
      } 
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\StvMediaUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */