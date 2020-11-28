package com.miaoc.itools.quant.tools;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Random;


public class mathUtilsTest {
    MathUtils mathUtils = new MathUtils();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void main() {

    }

    @Test
    public void variance() {
        Random random = new Random();
        double dmax=999;//Double.MAX_VALUE;//Double类型的最大值，太大的double值，相乘会达到无穷大
        double dmin=Double.MIN_VALUE;//Double类型的最小值
        int n=100;//假设求取100个doubl数的方差和标准差
        double[] x=new double[n];
        for(int i=0;i<n;i++){//随机生成n个double数
            x[i]=Double.valueOf(Math.floor(random.nextDouble()*(dmax-dmin)));
            System.out.println(x[i]);
        }
        //设置doubl字符串输出格式，不以科学计数法输出
        DecimalFormat df=new DecimalFormat("#,##0.00");//格式化设置
        //计算方差
        double dV=MathUtils.Variance(x);
        System.out.println("方差="+df.format(dV));
    }

    @Test
    public void standardDiviation() {
        Random random = new Random();
        double dmax=999;//Double.MAX_VALUE;//Double类型的最大值，太大的double值，相乘会达到无穷大
        double dmin=Double.MIN_VALUE;//Double类型的最小值
        int n=100;//假设求取100个doubl数的方差和标准差
        double[] x=new double[n];
        for(int i=0;i<n;i++){//随机生成n个double数
            x[i]=Double.valueOf(Math.floor(random.nextDouble()*(dmax-dmin)));
            System.out.println(x[i]);
        }
        //设置doubl字符串输出格式，不以科学计数法输出
        DecimalFormat df=new DecimalFormat("#,##0.00");//格式化设置
        //计算标准差
        double dS=MathUtils.StandardDiviation(x);
        System.out.println("标准差="+df.format(dS));
    }
}