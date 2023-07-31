package com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.assertion;

import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.logger.LogService;
import org.testng.Assert;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AssertionService {

    LogService LogService = new LogService();

    public void fail(String desc){
        Assert.fail(desc);
        LogService.Assertion("Failing test for following reason: '"+desc+"'");
    }


    public  void assertTrue(boolean var, String desc){
        Assert.assertTrue(var, desc);
        LogService.Assertion("Verified '"+desc+"' as True");
    }

    public  void assertEquals(String var1, String var2, String desc){
        Assert.assertEquals(var1, var2, desc);
        LogService.Assertion("Verified '"+desc+"' as "+var1);
    }

    public  void assertFalse(boolean var, String desc) {
        Assert.assertFalse(var, desc);
        LogService.Assertion("Verified '"+desc+"' as False");
    }

    public  void assertEquals(Object var1, Object var2, String desc) {
        Assert.assertEquals(var1, var2, desc);
        LogService.Assertion("Verified '"+desc+"' as "+var1);
    }

    public  void assertEqualsWithDeviation(double var1, double var2, double deviation,  String desc) {
        LogService.Info("Expected "+desc+ " : "+var2);
        LogService.Info("Actual "+desc+ " : "+var1);
        Assert.assertTrue(Math.abs(var1 - var2) <= deviation, desc);
        LogService.Assertion("Verified '"+desc+"' as '"+var1+"' with a deviation of less than '"+deviation+"'");
    }

    public  void assertEquals(byte[] var0, byte[] var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as "+var0);
    }

    public  void assertEquals(short[] var0, short[] var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as "+var0);
    }

    public  void assertEquals(int[] var0, int[] var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as "+var0);
    }

    public  void assertEquals(boolean[] var0, boolean[] var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as "+var0);
    }

    public  void assertEquals(char[] var0, char[] var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as "+var0);
    }

    public  void assertEquals(float[] var0, float[] var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as "+var0);
    }

    public  void assertEquals(double[] var0, double[] var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as "+var0);
    }

    public  void assertEquals(long[] var0, long[] var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as "+var0);
    }

    public  void assertEquals(double var0, double var2, double var4, String desc) {
        Assert.assertEquals(var0, var2, var4, desc);
        LogService.Assertion("Verified '"+desc+"' as "+var0);
    }

    public  void assertEquals(float var0, float var1, float var2, String desc) {
        Assert.assertEquals(var0, var1, var2, desc);
        LogService.Assertion("Verified '"+desc+"' as "+var0);
    }

    public  void assertEquals(long var0, long var2, String desc) {
        assertEquals((Object)var0, (Object)var2, desc);
    }

    public  void assertEquals(boolean var0, boolean var1, String desc) {
        assertEquals((Object)var0, (Object)var1, desc);
    }

    public  void assertEquals(byte var0, byte var1, String desc) {
        assertEquals((Object)var0, (Object)var1, desc);
    }

    public  void assertEquals(char var0, char var1, String desc) {
        assertEquals((Object)var0, (Object)var1, desc);
    }

    public  void assertEquals(short var0, short var1, String desc) {
        assertEquals(var0, (Object)var1, desc);
    }

    public  void assertEquals(int var0, int var1, String desc) {
        assertEquals(var0, (Object)var1, desc);
    }

    public  void assertNotNull(Object var0, String desc) {
        Assert.assertNotNull(var0, desc);
        LogService.Assertion("Verified '"+desc+"' as Not Null");
    }

    public  void assertNull(Object var0, String desc) {
        Assert.assertNull(var0, desc);
        LogService.Assertion("Verified '"+desc+"' as Null");
    }

    public  void assertSame(Object var0, Object var1, String desc) {
        Assert.assertSame(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as Same");
    }


    public  void assertNotSame(Object var0, Object var1, String desc) {
        Assert.assertSame(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as Not Same");
    }

    public  void assertEquals(Collection<?> var0, Collection<?> var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as '"+var0+"'");
    }

    public  void assertEquals(Iterator<?> var0, Iterator<?> var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as '"+var0+"'");
    }

    public  void assertEquals(Iterable<?> var0, Iterable<?> var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as '"+var0+"'");
    }

    public  void assertEquals(Object[] var0, Object[] var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as '"+var0+"'");
    }

    public  void assertEqualsNoOrder(Object[] var0, Object[] var1, String desc) {
        Assert.assertEqualsNoOrder(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as '"+var0+"' with No Order");
    }

    public void assertEquals(Set<?> var0, Set<?> var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as '"+var0+"'");
    }

    public  void assertEquals(Map<?, ?> var0, Map<?, ?> var1, String desc) {
        Assert.assertEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' as '"+var0+"'");
    }

    public  void assertNotEquals(Object var0, Object var1, String desc) {
        Assert.assertNotEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' is not as '"+var0+"'");
    }


    void assertNotEquals(String var0, String var1, String desc) {
        assertNotEquals((Object)var0, (Object)var1, desc);
    }

    void assertNotEquals(long var0, long var2, String desc) {
        assertNotEquals((Object)var0, (Object)var2, desc);
    }

    void assertNotEquals(boolean var0, boolean var1, String desc) {
        assertNotEquals((Object)var0, (Object)var1, desc);
    }

    void assertNotEquals(byte var0, byte var1, String desc) {
        assertNotEquals((Object)var0, (Object)var1, desc);
    }

    void assertNotEquals(char var0, char var1, String desc) {
        assertNotEquals((Object)var0, (Object)var1, desc);
    }

    void assertNotEquals(short var0, short var1, String desc) {
        assertNotEquals((Object)var0, (Object)var1, desc);
    }

    void assertNotEquals(int var0, int var1, String desc) {
        assertNotEquals((Object)var0, (Object)var1, desc);
    }

    public  void assertNotEquals(float var0, float var1, float var2, String desc) {
        Assert.assertNotEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' is not as '"+var0+"'");
    }

    public  void assertNotEquals(double var0, double var2, double var4, String desc) {
        Assert.assertNotEquals(var0, var2, var4, desc);
        LogService.Assertion("Verified '"+desc+"' is not as '"+var0+"'");
    }

    public  void assertNotEquals(Set<?> var0, Set<?> var1, String desc) {
        Assert.assertNotEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' is not as '"+var0+"'");
    }

    public  void assertNotEquals(Map<?, ?> var0, Map<?, ?> var1, String desc) {
        Assert.assertNotEquals(var0, var1, desc);
        LogService.Assertion("Verified '"+desc+"' is not as '"+var0+"'");
    }

}
