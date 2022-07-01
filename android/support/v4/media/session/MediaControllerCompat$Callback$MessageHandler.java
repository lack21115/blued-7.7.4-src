package android.support.v4.media.session;

import android.os.Handler;
import android.os.Message;

final class MediaControllerCompat$Callback$MessageHandler extends Handler {
  private boolean mRegistered;
  
  public final void handleMessage(Message paramMessage) {
    Object object1;
    if (!this.mRegistered)
      return; 
    switch (paramMessage.what) {
      default:
        return;
      case 12:
        ((Integer)paramMessage.obj).intValue();
        return;
      case 11:
        ((Boolean)paramMessage.obj).booleanValue();
        return;
      case 9:
        ((Integer)paramMessage.obj).intValue();
        return;
      case 7:
        object1 = paramMessage.obj;
        return;
      case 6:
        object1 = ((Message)object1).obj;
        return;
      case 5:
        object1 = ((Message)object1).obj;
        return;
      case 4:
        object1 = ((Message)object1).obj;
        return;
      case 3:
        object1 = ((Message)object1).obj;
        return;
      case 2:
        object1 = ((Message)object1).obj;
        return;
      case 1:
        break;
    } 
    Object object2 = ((Message)object1).obj;
    object1.getData();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\MediaControllerCompat$Callback$MessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */