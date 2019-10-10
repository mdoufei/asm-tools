
# ASM Utils

Library for handle Java bytecode.

## Type Transform
 - Method params type transform 
      * Ljava/lang/String;[Landroid/graphics/PointF;   ->   java.lang.String,android.graphics.PointF[]
      * IIII -> int,int,int,int
      * [II -> int[],int
      * [Lcom.google.zxing.ResultPoint; -> com.google.zxing.ResultPoint[]
      * Landroid.graphics.Bitmap;I -> android.graphics.Bitmap,int
      * Landroid.content.Context;Ljava.lang.String;ZZZ -> android.content.Context,java.lang.String,boolean,boolean,boolean
      * Landroid.content.Context;Ljava.lang.String; -> android.content.Context,java.lang.String
      * IILandroid.content.Intent; -> int,int,android.content.Intent