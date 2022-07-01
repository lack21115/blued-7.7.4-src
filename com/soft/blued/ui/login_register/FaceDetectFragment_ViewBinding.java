package com.soft.blued.ui.login_register;

import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.baidu.aip.face.TexturePreviewView;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class FaceDetectFragment_ViewBinding implements Unbinder {
  private FaceDetectFragment b;
  
  public FaceDetectFragment_ViewBinding(FaceDetectFragment paramFaceDetectFragment, View paramView) {
    this.b = paramFaceDetectFragment;
    paramFaceDetectFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramFaceDetectFragment.previewView = (TexturePreviewView)Utils.a(paramView, 2131299511, "field 'previewView'", TexturePreviewView.class);
    paramFaceDetectFragment.cameraTips = (TextView)Utils.a(paramView, 2131296631, "field 'cameraTips'", TextView.class);
    paramFaceDetectFragment.flPreview = (FrameLayout)Utils.a(paramView, 2131297152, "field 'flPreview'", FrameLayout.class);
    paramFaceDetectFragment.abortVerify = (TextView)Utils.a(paramView, 2131296349, "field 'abortVerify'", TextView.class);
    paramFaceDetectFragment.mTextureView = (TextureView)Utils.a(paramView, 2131300235, "field 'mTextureView'", TextureView.class);
    paramFaceDetectFragment.tvTips = (TextView)Utils.a(paramView, 2131301402, "field 'tvTips'", TextView.class);
  }
  
  public void unbind() {
    FaceDetectFragment faceDetectFragment = this.b;
    if (faceDetectFragment != null) {
      this.b = null;
      faceDetectFragment.title = null;
      faceDetectFragment.previewView = null;
      faceDetectFragment.cameraTips = null;
      faceDetectFragment.flPreview = null;
      faceDetectFragment.abortVerify = null;
      faceDetectFragment.mTextureView = null;
      faceDetectFragment.tvTips = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\FaceDetectFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */