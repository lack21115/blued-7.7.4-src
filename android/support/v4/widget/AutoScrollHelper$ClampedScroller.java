package android.support.v4.widget;

final class AutoScrollHelper$ClampedScroller {
  long mDeltaTime = 0L;
  
  int mDeltaY = 0;
  
  int mEffectiveRampDown;
  
  int mRampDownDuration;
  
  int mRampUpDuration;
  
  long mStartTime = Long.MIN_VALUE;
  
  long mStopTime = -1L;
  
  float mStopValue;
  
  float mTargetVelocityX;
  
  float mTargetVelocityY;
  
  final float getValueAt(long paramLong) {
    if (paramLong < this.mStartTime)
      return 0.0F; 
    if (this.mStopTime < 0L || paramLong < this.mStopTime)
      return AutoScrollHelper.constrain((float)(paramLong - this.mStartTime) / this.mRampUpDuration, 0.0F, 1.0F) * 0.5F; 
    long l = this.mStopTime;
    return 1.0F - this.mStopValue + this.mStopValue * AutoScrollHelper.constrain((float)(paramLong - l) / this.mEffectiveRampDown, 0.0F, 1.0F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\AutoScrollHelper$ClampedScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */