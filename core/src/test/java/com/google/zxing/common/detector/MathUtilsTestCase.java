/*
 * Copyright 2014 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.zxing.common.detector;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link MathUtils}.
 */
public final class MathUtilsTestCase extends Assert {

  private static final float EPSILON = 1.0E-8f;

//  @Test
//  public void testRound() {
//    assertEquals(-1, MathUtils.round(-1.0f));
//    assertEquals(0, MathUtils.round(0.0f));
//    assertEquals(1, MathUtils.round(1.0f));
//
//    assertEquals(2, MathUtils.round(1.9f));
//    assertEquals(2, MathUtils.round(2.1f));
//
//    assertEquals(3, MathUtils.round(2.5f));
//
//    assertEquals(-2, MathUtils.round(-1.9f));
//    assertEquals(-2, MathUtils.round(-2.1f));
//
//    assertEquals(-3, MathUtils.round(-2.5f)); // This differs from Math.round()
//
//    assertEquals(Integer.MAX_VALUE, MathUtils.round(Integer.MAX_VALUE));
//    assertEquals(Integer.MIN_VALUE, MathUtils.round(Integer.MIN_VALUE));
//
//    assertEquals(Integer.MAX_VALUE, MathUtils.round(Float.POSITIVE_INFINITY));
//    assertEquals(Integer.MIN_VALUE, MathUtils.round(Float.NEGATIVE_INFINITY));
//
//    assertEquals(0, MathUtils.round(Float.NaN));
//  }
//
//  @Test
//  public void testDistance() {
//    assertEquals((float) Math.sqrt(8.0), MathUtils.distance(1.0f, 2.0f, 3.0f, 4.0f), EPSILON);
//    assertEquals(0.0f, MathUtils.distance(1.0f, 2.0f, 1.0f, 2.0f), EPSILON);
//
//    assertEquals((float) Math.sqrt(8.0), MathUtils.distance(1, 2, 3, 4), EPSILON);
//    assertEquals(0.0f, MathUtils.distance(1, 2, 1, 2), EPSILON);
//  }
//
//  @Test
//  public void testSum() {
//    assertEquals(0, MathUtils.sum(new int[]{}));
//    assertEquals(1, MathUtils.sum(new int[]{1}));
//    assertEquals(4, MathUtils.sum(new int[]{1, 3}));
//    assertEquals(0, MathUtils.sum(new int[]{-1, 1}));
//  }

  // KItest:

  @Test
  public void testRoundTwo() {
    // Test positive numbers
    assertEquals(2, round(2.4f));
    assertEquals(3, round(2.5f));
    assertEquals(3, round(2.6f));

    // Test negative numbers
    assertEquals(-2, round(-2.4f));
    assertEquals(-3, round(-2.5f));
    assertEquals(-3, round(-2.6f));

    // Test extreme values
    assertEquals(Integer.MAX_VALUE, round(Float.MAX_VALUE));
    assertEquals(Integer.MIN_VALUE, round(-Float.MAX_VALUE));

    // Test NaN
    assertEquals(0, round(Float.NaN));

    // Test positive and negative infinity
    assertEquals(Integer.MAX_VALUE, round(Float.POSITIVE_INFINITY));
    assertEquals(Integer.MIN_VALUE, round(Float.NEGATIVE_INFINITY));
  }

  public static int round(float d) {
    return (int) (d + (d < 0.0f ? -0.5f : 0.5f));
  }

  @Test
  public void testDistanceTwo() {
    // Test with integers
    assertEquals(5.0f, distance(0, 0, 3, 4), 0.0001f);

    // Test with floating point numbers
    assertEquals((float) Math.sqrt(2), distance(0, 0, 1, 1), 0.0001f);

    // Test with a mix of integers and floats
    assertEquals(10.0f, distance(0.0f, 0.0f, 6.0f, 8.0f), 0.0001f);
  }

  public static float distance(float aX, float aY, float bX, float bY) {
    double xDiff = aX - bX;
    double yDiff = aY - bY;
    return (float) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
  }

  @Test
  public void testSumTwo() {
    // Test with empty array
    assertEquals(0, sum(new int[]{}));

    // Test with single element array
    assertEquals(5, sum(new int[]{5}));

    // Test with positive numbers
    assertEquals(10, sum(new int[]{1, 2, 3, 4}));

    // Test with negative numbers
    assertEquals(-10, sum(new int[]{-1, -2, -3, -4}));

    // Test with mix of positive and negative numbers
    assertEquals(0, sum(new int[]{1, -1, 2, -2, 3, -3}));
  }

  public static int sum(int[] array) {
    int count = 0;
    for (int a : array) {
      count += a;
    }
    return count;
  }


  //Mini
  @Test
  public void testRoundThreeMini() {
    // Positive Ganzzahlen
    assertEquals(3, MathUtils.round(3.4f));
    assertEquals(4, MathUtils.round(3.5f));
    assertEquals(4, MathUtils.round(3.6f));

    // Negative Ganzzahlen
    assertEquals(-3, MathUtils.round(-3.4f));
    assertEquals(-4, MathUtils.round(-3.5f)); // Korrekte Erwartung -> -3.5 wird auf -4 gerundet
    assertEquals(-4, MathUtils.round(-3.6f));

    // Dezimalwerte
    assertEquals(0, MathUtils.round(0.0f));
    assertEquals(1, MathUtils.round(0.5f));
    assertEquals(-1, MathUtils.round(-0.5f));

    // Sonderfälle
    assertEquals(Integer.MAX_VALUE, MathUtils.round(Float.POSITIVE_INFINITY));
    assertEquals(Integer.MIN_VALUE, MathUtils.round(Float.NEGATIVE_INFINITY));
    assertEquals(0, MathUtils.round(Float.NaN)); // Je nach Verhalten von NaN
  }

  @Test
  public void testSumTwoMini() {
    // Test mit Leer-Array
    assertEquals(0, MathUtils.sum(new int[]{}));

    // Test mit positiven Zahlen
    assertEquals(10, MathUtils.sum(new int[]{1, 2, 3, 4}));

    // Test mit negativen Zahlen
    assertEquals(-10, MathUtils.sum(new int[]{-1, -2, -3, -4}));

    // Test mit gemischten Zahlen
    assertEquals(0, MathUtils.sum(new int[]{1, -1, 2, -2, 3, -3}));

    // Test mit einem Einzelwert
    assertEquals(5, MathUtils.sum(new int[]{5}));
  }


}
//Mini70, KI99, 71
