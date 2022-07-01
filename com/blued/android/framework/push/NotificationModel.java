package com.blued.android.framework.push;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;

public class NotificationModel {
  private Bitmap bitmap;
  
  private Bitmap bitmapDef;
  
  private CharSequence contentText;
  
  private String contentTitle;
  
  private int iconResId;
  
  private int id = 0;
  
  private boolean innerVoiceEnable = true;
  
  private Intent intent;
  
  public int intent_flag = 0;
  
  private boolean remindEnable = true;
  
  private boolean shakeEnable = true;
  
  private Uri soundFileUri;
  
  public NotificationCompat.Style style;
  
  private String tickerText;
  
  private boolean voiceEnable = true;
  
  public Bitmap getBitmap() {
    return this.bitmap;
  }
  
  public Bitmap getBitmapDef() {
    return this.bitmapDef;
  }
  
  public CharSequence getContentText() {
    return this.contentText;
  }
  
  public String getContentTitle() {
    return this.contentTitle;
  }
  
  public int getIconResId() {
    return this.iconResId;
  }
  
  public int getId() {
    return this.id;
  }
  
  public boolean getInnerVoiceEnable() {
    return this.innerVoiceEnable;
  }
  
  public Intent getIntent() {
    return this.intent;
  }
  
  public boolean getRemindEnable() {
    return this.remindEnable;
  }
  
  public boolean getShakeEnable() {
    return this.shakeEnable;
  }
  
  public Uri getSoundFileUri() {
    return this.soundFileUri;
  }
  
  public NotificationCompat.Style getStyle() {
    return this.style;
  }
  
  public String getTickerText() {
    return this.tickerText;
  }
  
  public boolean getVoiceEnable() {
    return this.voiceEnable;
  }
  
  public void setBitmap(Bitmap paramBitmap) {
    this.bitmap = paramBitmap;
  }
  
  public void setBitmapDef(Bitmap paramBitmap) {
    this.bitmapDef = paramBitmap;
  }
  
  public void setContentText(CharSequence paramCharSequence) {
    this.contentText = paramCharSequence;
  }
  
  public void setContentTitle(String paramString) {
    this.contentTitle = paramString;
  }
  
  public void setIconResId(int paramInt) {
    this.iconResId = paramInt;
  }
  
  public void setId(int paramInt) {
    this.id = paramInt;
  }
  
  public void setInnerVoiceEnable(boolean paramBoolean) {
    this.innerVoiceEnable = paramBoolean;
  }
  
  public void setIntent(Intent paramIntent) {
    this.intent = paramIntent;
  }
  
  public void setRemindEnable(boolean paramBoolean) {
    this.remindEnable = paramBoolean;
  }
  
  public void setShakeEnable(boolean paramBoolean) {
    this.shakeEnable = paramBoolean;
  }
  
  public void setSoundFileUri(Uri paramUri) {
    this.soundFileUri = paramUri;
  }
  
  public void setStyle(NotificationCompat.Style paramStyle) {
    this.style = paramStyle;
  }
  
  public void setTickerText(String paramString) {
    this.tickerText = paramString;
  }
  
  public void setVoiceEnable(boolean paramBoolean) {
    this.voiceEnable = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\push\NotificationModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */