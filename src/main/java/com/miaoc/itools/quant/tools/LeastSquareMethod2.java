package com.miaoc.itools.quant.tools;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

/**
 * @program: formeal
 * @description:
 * @author: Mr.cc
 * @create: 2020-11-23 22:34
 **/

public class LeastSquareMethod2 {

    public static void main(String[] args) {
        WeightedObservedPoints obs = new WeightedObservedPoints();
        obs.add(0.5, 1.75);
        obs.add(1, 2.45);
        obs.add(1.5, 3.81);
        obs.add(2, 4.8);
        obs.add(2.5, 7.0);
        obs.add(3, 8.6);

        // Instantiate a third-degree polynomial fitter.
        // 实例化一个三度多项式健康。
        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(3);

        // Retrieve fitted parameters (coefficients of the polynomial function).
        // 获取安装参数(多项式函数的系数)
        final double[] coeff = fitter.fit(obs.toList());
        String fun = "f(x) = ";
        for (int i = coeff.length - 1; i >= 0; i--) {
            String add = coeff[i] > 0 ? "+" : "";
            String x = i > 0 ? "x^" + i : "";
            if (i == coeff.length - 1) {
                fun += (coeff[i] + x);
            } else {
                fun += (add + coeff[i] + x);
            }
        }
        System.out.println("Function is: " + fun);
    }


}
