package com.huawei.hms.support.api.client;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;

public final class Status extends Result implements Parcelable {
  public static final Parcelable.Creator<Status> CREATOR;
  
  public static final Status CoreException;
  
  public static final Status FAILURE;
  
  public static final Status MessageNotFound;
  
  @Deprecated
  public static final Status RESULT_CANCELED;
  
  @Deprecated
  public static final Status RESULT_DEAD_CLIENT;
  
  @Deprecated
  public static final Status RESULT_INTERNAL_ERROR;
  
  @Deprecated
  public static final Status RESULT_INTERRUPTED;
  
  @Deprecated
  public static final Status RESULT_TIMEOUT;
  
  public static final Status SUCCESS = new Status(0);
  
  @Packed
  private Intent intent;
  
  @Packed
  private PendingIntent pendingIntent;
  
  @Packed
  private int statusCode;
  
  @Packed
  private String statusMessage;
  
  static {
    FAILURE = new Status(1);
    RESULT_CANCELED = new Status(16);
    RESULT_DEAD_CLIENT = new Status(18);
    RESULT_INTERNAL_ERROR = new Status(8);
    RESULT_INTERRUPTED = new Status(14);
    RESULT_TIMEOUT = new Status(15);
    MessageNotFound = new Status(404);
    CoreException = new Status(500);
    CREATOR = new Parcelable.Creator() {
        public Status createFromParcel(Parcel param1Parcel) {
          return new Status(param1Parcel.readInt(), param1Parcel.readString(), PendingIntent.readPendingIntentOrNullFromParcel(param1Parcel));
        }
        
        public Status[] newArray(int param1Int) {
          return new Status[param1Int];
        }
      };
  }
  
  public Status(int paramInt) {
    this(paramInt, null);
  }
  
  public Status(int paramInt, String paramString) {
    this.statusCode = paramInt;
    this.statusMessage = paramString;
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent) {
    this.statusCode = paramInt;
    this.statusMessage = paramString;
    this.pendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString, Intent paramIntent) {
    this.statusCode = paramInt;
    this.statusMessage = paramString;
    this.intent = paramIntent;
  }
  
  private static boolean equal(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof Status) {
      paramObject = paramObject;
      return (this.statusCode == ((Status)paramObject).statusCode && equal(this.statusMessage, ((Status)paramObject).statusMessage) && equal(this.pendingIntent, ((Status)paramObject).pendingIntent));
    } 
    return false;
  }
  
  public String getErrorString() {
    return getStatusMessage();
  }
  
  public PendingIntent getResolution() {
    return this.pendingIntent;
  }
  
  public Status getStatus() {
    return this;
  }
  
  public int getStatusCode() {
    return this.statusCode;
  }
  
  public String getStatusMessage() {
    return this.statusMessage;
  }
  
  public boolean hasResolution() {
    return (this.pendingIntent != null || this.intent != null);
  }
  
  public int hashCode() {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.statusCode), this.statusMessage, this.pendingIntent });
  }
  
  public boolean isCanceled() {
    return false;
  }
  
  public boolean isInterrupted() {
    return false;
  }
  
  public boolean isSuccess() {
    return (this.statusCode <= 0);
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt) throws IntentSender.SendIntentException {
    if (hasResolution()) {
      PendingIntent pendingIntent = this.pendingIntent;
      if (pendingIntent != null) {
        paramActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
        return;
      } 
      paramActivity.startActivityForResult(this.intent, paramInt);
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{statusCode: ");
    stringBuilder.append(this.statusCode);
    stringBuilder.append(", statusMessage: ");
    stringBuilder.append(this.statusMessage);
    stringBuilder.append(", pendingIntent: ");
    stringBuilder.append(this.pendingIntent);
    stringBuilder.append(", }");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.statusCode);
    paramParcel.writeString(this.statusMessage);
    PendingIntent pendingIntent = this.pendingIntent;
    if (pendingIntent != null)
      pendingIntent.writeToParcel(paramParcel, paramInt); 
    PendingIntent.writePendingIntentOrNullToParcel(this.pendingIntent, paramParcel);
    Intent intent = this.intent;
    if (intent != null)
      intent.writeToParcel(paramParcel, paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */