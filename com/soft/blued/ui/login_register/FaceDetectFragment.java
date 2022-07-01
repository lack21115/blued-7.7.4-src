package com.soft.blued.ui.login_register;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Environment;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import com.baidu.aip.ImageFrame;
import com.baidu.aip.face.CameraImageSource;
import com.baidu.aip.face.DetectRegionProcessor;
import com.baidu.aip.face.FaceDetectManager;
import com.baidu.aip.face.FaceFilter;
import com.baidu.aip.face.FaceProcessor;
import com.baidu.aip.face.ImageSource;
import com.baidu.aip.face.PreviewView;
import com.baidu.aip.face.TexturePreviewView;
import com.baidu.idl.facesdk.FaceInfo;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.constant.CameraContents;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.login_register.model.AdultVerifyModel;
import com.soft.blued.ui.photo.camera.utils.CameraImageUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.third.BaiduFaceDetectUtils;
import com.soft.blued.utils.third.QiniuUploadUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

public class FaceDetectFragment extends MvpFragment {
  private static String i = FaceDetectFragment.class.getName();
  
  @BindView(2131296349)
  TextView abortVerify;
  
  @BindView(2131296631)
  TextView cameraTips;
  
  private Context d;
  
  private FaceDetectManager e;
  
  private DetectRegionProcessor f = new DetectRegionProcessor();
  
  @BindView(2131297152)
  FrameLayout flPreview;
  
  private boolean g = false;
  
  private boolean h = false;
  
  @BindView(2131300235)
  TextureView mTextureView;
  
  @BindView(2131299511)
  TexturePreviewView previewView;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  @BindView(2131301402)
  TextView tvTips;
  
  public static void a(Object paramObject, int paramInt) {
    Context context;
    if (paramObject instanceof Fragment) {
      context = ((Fragment)paramObject).getContext();
    } else {
      context = (Context)paramObject;
    } 
    if (context == null)
      return; 
    PermissionHelper.b(new PermissionCallbacks(paramObject, paramInt) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Bundle bundle = new Bundle();
            Object object = this.a;
            if (object instanceof Activity) {
              TerminalActivity.a((Context)object, FaceDetectFragment.class, bundle, this.b);
              return;
            } 
            if (object instanceof Fragment)
              TerminalActivity.a((Fragment)object, FaceDetectFragment.class, bundle, this.b); 
          }
        });
  }
  
  private void l() {
    CommonAlertDialog.a((Context)getActivity(), "", this.d.getResources().getString(2131755375), this.d.getResources().getString(2131755374), -$$Lambda$FaceDetectFragment$kwxJ4ruRU2zjPQ1tYUccKc0r2Hg.INSTANCE, this.d.getResources().getString(2131755380), null, null);
  }
  
  private void m() {
    if (BaiduFaceDetectUtils.a((Activity)getActivity()) < 200)
      BaiduFaceDetectUtils.a((Activity)getActivity(), 200); 
  }
  
  public boolean V_() {
    l();
    return true;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = (Context)getActivity();
    k();
  }
  
  public void a(FaceFilter.TrackedModel paramTrackedModel) {
    if (paramTrackedModel != null) {
      if (this.g)
        return; 
      if (paramTrackedModel.meetCriteria()) {
        this.tvTips.setVisibility(8);
        FaceInfo faceInfo = paramTrackedModel.getInfo();
        paramTrackedModel.getImageFrame().retain();
        RectF rectF = new RectF((faceInfo.mCenter_x - 2 - faceInfo.mWidth * 3 / 5), (faceInfo.mCenter_y - 2 - faceInfo.mWidth * 3 / 5), (faceInfo.mCenter_x + 2 + faceInfo.mWidth * 3 / 5), (faceInfo.mCenter_y + 2 + faceInfo.mWidth * 3 / 5));
        this.previewView.mapFromOriginalRect(rectF);
        this.g = true;
        this.title.setCenterText(this.d.getResources().getString(2131759209));
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(AppInfo.d().getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        stringBuilder1.append(CameraContents.c);
        stringBuilder1.append(CameraContents.d.format(new Date()));
        String str = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(".jpg");
        str = (new File(stringBuilder2.toString())).getAbsolutePath();
        if (CameraImageUtils.a(paramTrackedModel.cropFace(), str).length() <= 0L) {
          this.g = false;
          return;
        } 
        CameraImageUtils.a(str);
        a(new BluedUIHttpResponse<BluedEntity<AdultVerifyModel, BluedEntityBaseExtra>>(this, (IRequestHost)w_(), str) {
              public boolean onUIFailure(int param1Int, String param1String) {
                if (param1Int == 4036712) {
                  this.b.c(param1String);
                  return true;
                } 
                this.b.title.d();
                return super.onUIFailure(param1Int, param1String);
              }
              
              public void onUIStart() {
                super.onUIStart();
              }
              
              public void onUIUpdate(BluedEntity<AdultVerifyModel, BluedEntityBaseExtra> param1BluedEntity) {
                if (param1BluedEntity != null && param1BluedEntity.hasData()) {
                  Intent intent = new Intent();
                  intent.putExtra("KEY_AV_MODEL", (Serializable)param1BluedEntity.getSingleData());
                  intent.putExtra("KEY_FILE_PATH", this.a);
                  this.b.getActivity().setResult(-1, intent);
                  this.b.getActivity().finish();
                } 
              }
            }str, (IRequestHost)w_());
        return;
      } 
      this.tvTips.setVisibility(0);
      this.tvTips.setText(2131756374);
    } 
  }
  
  public void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, paramString, paramBluedUIHttpResponse, paramIRequestHost) {
          boolean a = false;
          
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              BluedAlbum bluedAlbum = (BluedAlbum)param1BluedEntityA.getSingleData();
              QiniuUploadUtils.a(this.b, bluedAlbum, new QiniuUploadTools.QiNiuListener(this) {
                    public void a(String param2String) {
                      AppMethods.d(2131756082);
                      if (this.a.c != null)
                        this.a.c.onFinish(); 
                    }
                    
                    public void a(String param2String, double param2Double) {}
                    
                    public void a(String param2String1, String param2String2) {
                      LoginRegisterHttpUtils.b(this.a.c, this.a.d, param2String1);
                    }
                    
                    public boolean a() {
                      return false;
                    }
                  });
              return;
            } 
            AppMethods.d(2131756082);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = true;
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            BluedUIHttpResponse bluedUIHttpResponse = this.c;
            if (bluedUIHttpResponse != null)
              bluedUIHttpResponse.onFinish(); 
          }
        }paramIRequestHost);
  }
  
  public void c(String paramString) {
    String str1 = this.d.getResources().getString(2131756377);
    String str2 = this.d.getResources().getString(2131755379);
    String str3 = this.d.getResources().getString(2131755376);
    CommonAlertDialog.a(this.d, str1, paramString, str2, new -$$Lambda$FaceDetectFragment$RXWnB5Dg9ugDKJiPAntuleVXrVU(this), str3, new -$$Lambda$FaceDetectFragment$cA2mQ3Fa5lsqNeHfLYO-_1TBjVA(this), null);
  }
  
  public void k() {
    this.title.setLeftClickListener(new -$$Lambda$FaceDetectFragment$vXFpHkEVpA9rG7s2J_niub3WCbM(this));
    this.title.c();
    this.mTextureView.setOpaque(false);
    this.mTextureView.setKeepScreenOn(true);
    this.e = new FaceDetectManager(this.d);
    CameraImageSource cameraImageSource = new CameraImageSource(this.d);
    cameraImageSource.setPreviewView((PreviewView)this.previewView);
    this.e.setImageSource((ImageSource)cameraImageSource);
    this.e.setOnFaceDetectListener(new FaceDetectManager.OnFaceDetectListener(this) {
          public void onDetectFace(int param1Int, FaceInfo[] param1ArrayOfFaceInfo, ImageFrame param1ImageFrame) {}
        });
    this.e.setOnTrackListener(new -$$Lambda$FaceDetectFragment$rOxpmsmXswaI_9-qtQkQmj12Ctk(this));
    cameraImageSource.getCameraControl().setPermissionCallback(new -$$Lambda$FaceDetectFragment$5UfbGh2b4wO7tLdDTIxRi3ghF6w(this));
    cameraImageSource.getCameraControl().setPreviewView((PreviewView)this.previewView);
    this.e.addPreProcessor((FaceProcessor)this.f);
    this.previewView.setScaleType(PreviewView.ScaleType.FIT_WIDTH);
    int i = getActivity().getWindowManager().getDefaultDisplay().getRotation();
    cameraImageSource.getCameraControl().setDisplayOrientation(i);
    cameraImageSource.getCameraControl().setCameraFacing(1);
    m();
    this.abortVerify.setOnClickListener(new -$$Lambda$FaceDetectFragment$M372l3bB_9EdpdnXLmvT4eieXEI(this));
  }
  
  public void onResume() {
    super.onResume();
    if (this.h) {
      this.e.start();
      this.h = false;
    } 
    CommonTopTitleNoTrans commonTopTitleNoTrans = this.title;
    if (commonTopTitleNoTrans != null)
      commonTopTitleNoTrans.setCenterText(this.d.getResources().getString(2131755384)); 
  }
  
  public void onStop() {
    super.onStop();
    this.e.stop();
    this.h = true;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    a(new Runnable(this) {
          public void run() {
            RectF rectF = new RectF(this.a.flPreview.getLeft(), this.a.flPreview.getTop(), this.a.flPreview.getRight(), this.a.flPreview.getBottom());
            FaceDetectFragment.a(this.a).setDetectedRect(rectF);
            FaceDetectFragment.b(this.a).start();
          }
        }500L);
  }
  
  public int p() {
    return 2131493072;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\FaceDetectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */