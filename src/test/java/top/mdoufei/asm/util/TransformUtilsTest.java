package top.mdoufei.asm.util;

import org.junit.Assert;
import org.junit.Test;

public class TransformUtilsTest {

    @Test
    public void transformUtilsTest() {
        Assert.assertEquals("java.lang.String,android.graphics.PointF[]", TransformUtils.bc2Src("Ljava/lang/String;[Landroid/graphics/PointF;"));
        Assert.assertEquals("int,int,int,int", TransformUtils.bc2Src("IIII"));
        Assert.assertEquals("int[],int", TransformUtils.bc2Src("[II"));
        Assert.assertEquals("com.google.zxing.ResultPoint[]", TransformUtils.bc2Src("[Lcom.google.zxing.ResultPoint;"));
        Assert.assertEquals("android.graphics.Bitmap,int", TransformUtils.bc2Src("Landroid.graphics.Bitmap;I"));
        Assert.assertEquals("android.content.Context,java.lang.String,boolean,boolean,boolean", TransformUtils.bc2Src("Landroid.content.Context;Ljava.lang.String;ZZZ"));
        Assert.assertEquals("android.content.Context,java.lang.String", TransformUtils.bc2Src("Landroid.content.Context;Ljava.lang.String;"));
        Assert.assertEquals("int,int,android.content.Intent", TransformUtils.bc2Src("IILandroid.content.Intent;"));
    }
}
