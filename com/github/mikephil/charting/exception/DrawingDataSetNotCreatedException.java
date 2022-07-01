package com.github.mikephil.charting.exception;

public class DrawingDataSetNotCreatedException extends RuntimeException {
  public DrawingDataSetNotCreatedException() {
    super("Have to create a new drawing set first. Call ChartData's createNewDrawingDataSet() method");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\exception\DrawingDataSetNotCreatedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */