package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.appcompat.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

final class TooltipPopup {
  final View mContentView;
  
  final Context mContext;
  
  final WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();
  
  final TextView mMessageView;
  
  final int[] mTmpAnchorPos = new int[2];
  
  final int[] mTmpAppPos = new int[2];
  
  final Rect mTmpDisplayFrame = new Rect();
  
  TooltipPopup(Context paramContext) {
    this.mContext = paramContext;
    this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tooltip, null);
    this.mMessageView = (TextView)this.mContentView.findViewById(R.id.message);
    this.mLayoutParams.setTitle(getClass().getSimpleName());
    this.mLayoutParams.packageName = this.mContext.getPackageName();
    this.mLayoutParams.type = 1002;
    this.mLayoutParams.width = -2;
    this.mLayoutParams.height = -2;
    this.mLayoutParams.format = -3;
    this.mLayoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
    this.mLayoutParams.flags = 24;
  }
  
  final void hide() {
    if (!isShowing())
      return; 
    ((WindowManager)this.mContext.getSystemService("window")).removeView(this.mContentView);
  }
  
  final boolean isShowing() {
    return (this.mContentView.getParent() != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\TooltipPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */