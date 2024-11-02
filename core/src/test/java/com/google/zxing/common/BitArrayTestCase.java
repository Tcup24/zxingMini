/*
 * Copyright 2007 ZXing authors
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

package com.google.zxing.common;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

/**
 * @author Sean Owen
 */
public final class BitArrayTestCase extends Assert {

//  @Test
//  public void testGetSet() {
//    BitArray array = new BitArray(33);
//    for (int i = 0; i < 33; i++) {
//      assertFalse(array.get(i));
//      array.set(i);
//      assertTrue(array.get(i));
//    }
//  }
//
//  @Test
//  public void testGetNextSet1() {
//    BitArray array = new BitArray(32);
//    for (int i = 0; i < array.getSize(); i++) {
//      assertEquals(String.valueOf(i), 32, array.getNextSet(i));
//    }
//    array = new BitArray(33);
//    for (int i = 0; i < array.getSize(); i++) {
//      assertEquals(String.valueOf(i), 33, array.getNextSet(i));
//    }
//  }
//
//  @Test
//  public void testGetNextSet2() {
//    BitArray array = new BitArray(33);
//    array.set(31);
//    for (int i = 0; i < array.getSize(); i++) {
//      assertEquals(String.valueOf(i), i <= 31 ? 31 : 33, array.getNextSet(i));
//    }
//    array = new BitArray(33);
//    array.set(32);
//    for (int i = 0; i < array.getSize(); i++) {
//      assertEquals(String.valueOf(i), 32, array.getNextSet(i));
//    }
//  }
//
//  @Test
//  public void testGetNextSet3() {
//    BitArray array = new BitArray(63);
//    array.set(31);
//    array.set(32);
//    for (int i = 0; i < array.getSize(); i++) {
//      int expected;
//      if (i <= 31) {
//        expected = 31;
//      } else if (i == 32) {
//        expected = 32;
//      } else {
//        expected = 63;
//      }
//      assertEquals(String.valueOf(i), expected, array.getNextSet(i));
//    }
//  }
//
//  @Test
//  public void testGetNextSet4() {
//    BitArray array = new BitArray(63);
//    array.set(33);
//    array.set(40);
//    for (int i = 0; i < array.getSize(); i++) {
//      int expected;
//      if (i <= 33) {
//        expected = 33;
//      } else if (i <= 40) {
//        expected = 40;
//      } else {
//        expected = 63;
//      }
//      assertEquals(String.valueOf(i), expected, array.getNextSet(i));
//    }
//  }
//
//  @Test
//  public void testGetNextSet5() {
//    Random r = new Random(0xDEADBEEF);
//    for (int i = 0; i < 10; i++) {
//      BitArray array = new BitArray(1 + r.nextInt(100));
//      int numSet = r.nextInt(20);
//      for (int j = 0; j < numSet; j++) {
//        array.set(r.nextInt(array.getSize()));
//      }
//      int numQueries = r.nextInt(20);
//      for (int j = 0; j < numQueries; j++) {
//        int query = r.nextInt(array.getSize());
//        int expected = query;
//        while (expected < array.getSize() && !array.get(expected)) {
//          expected++;
//        }
//        int actual = array.getNextSet(query);
//        assertEquals(expected, actual);
//      }
//    }
//  }
//
//
//  @Test
//  public void testSetBulk() {
//    BitArray array = new BitArray(64);
//    array.setBulk(32, 0xFFFF0000);
//    for (int i = 0; i < 48; i++) {
//      assertFalse(array.get(i));
//    }
//    for (int i = 48; i < 64; i++) {
//      assertTrue(array.get(i));
//    }
//  }
//
//  @Test
//  public void testSetRange() {
//    BitArray array = new BitArray(64);
//    array.setRange(28, 36);
//    assertFalse(array.get(27));
//    for (int i = 28; i < 36; i++) {
//      assertTrue(array.get(i));
//    }
//    assertFalse(array.get(36));
//  }
//
//  @Test
//  public void testClear() {
//    BitArray array = new BitArray(32);
//    for (int i = 0; i < 32; i++) {
//      array.set(i);
//    }
//    array.clear();
//    for (int i = 0; i < 32; i++) {
//      assertFalse(array.get(i));
//    }
//  }
//
//  @Test
//  public void testFlip() {
//    BitArray array = new BitArray(32);
//    assertFalse(array.get(5));
//    array.flip(5);
//    assertTrue(array.get(5));
//    array.flip(5);
//    assertFalse(array.get(5));
//  }
//
//  @Test
//  public void testGetArray() {
//    BitArray array = new BitArray(64);
//    array.set(0);
//    array.set(63);
//    int[] ints = array.getBitArray();
//    assertEquals(1, ints[0]);
//    assertEquals(Integer.MIN_VALUE, ints[1]);
//  }
//
//  @Test
//  public void testIsRange() {
//    BitArray array = new BitArray(64);
//    assertTrue(array.isRange(0, 64, false));
//    assertFalse(array.isRange(0, 64, true));
//    array.set(32);
//    assertTrue(array.isRange(32, 33, true));
//    array.set(31);
//    assertTrue(array.isRange(31, 33, true));
//    array.set(34);
//    assertFalse(array.isRange(31, 35, true));
//    for (int i = 0; i < 31; i++) {
//      array.set(i);
//    }
//    assertTrue(array.isRange(0, 33, true));
//    for (int i = 33; i < 64; i++) {
//      array.set(i);
//    }
//    assertTrue(array.isRange(0, 64, true));
//    assertFalse(array.isRange(0, 64, false));
//  }
//
//  @Test
//  public void reverseAlgorithmTest() {
//    int[] oldBits = {128, 256, 512, 6453324, 50934953};
//    for (int size = 1; size < 160; size++) {
//      int[] newBitsOriginal = reverseOriginal(oldBits.clone(), size);
//      BitArray newBitArray = new BitArray(oldBits.clone(), size);
//      newBitArray.reverse();
//      int[] newBitsNew = newBitArray.getBitArray();
//      assertTrue(arraysAreEqual(newBitsOriginal, newBitsNew, size / 32 + 1));
//    }
//  }
//
//  @Test
//  public void testClone() {
//    BitArray array = new BitArray(32);
//    array.clone().set(0);
//    assertFalse(array.get(0));
//  }
//
//  @Test
//  public void testEquals() {
//    BitArray a = new BitArray(32);
//    BitArray b = new BitArray(32);
//    assertEquals(a, b);
//    assertEquals(a.hashCode(), b.hashCode());
//    assertNotEquals(a, new BitArray(31));
//    a.set(16);
//    assertNotEquals(a, b);
//    assertNotEquals(a.hashCode(), b.hashCode());
//    b.set(16);
//    assertEquals(a, b);
//    assertEquals(a.hashCode(), b.hashCode());
//  }
//
  private static int[] reverseOriginal(int[] oldBits, int size) {
    int[] newBits = new int[oldBits.length];
    for (int i = 0; i < size; i++) {
      if (bitSet(oldBits, size - i - 1)) {
        newBits[i / 32] |= 1 << (i & 0x1F);
      }
    }
    return newBits;
  }

  private static boolean bitSet(int[] bits, int i) {
    return (bits[i / 32] & (1 << (i & 0x1F))) != 0;
  }

  private static boolean arraysAreEqual(int[] left, int[] right, int size) {
    for (int i = 0; i < size; i++) {
      if (left[i] != right[i]) {
        return false;
      }
    }
    return true;
  }

//  //KItest
  @Test
  public void testGetSetTwo() {
    BitArray bitArray = new BitArray(10);

    for (int i = 0; i < bitArray.getSize(); i++) {
      assertFalse("Initially all bits should be false", bitArray.get(i));
      bitArray.set(i);
      assertTrue("Bit should be set to true", bitArray.get(i));
      bitArray.flip(i);
      assertFalse("Bit should be flipped to false", bitArray.get(i));
    }
  }

  @Test
  public void testGetNextSet1Two() {
    BitArray bitArray = new BitArray(10);

    assertEquals("If no bits are set, getNextSet should return the size", bitArray.getSize(), bitArray.getNextSet(0));
  }

  @Test
  public void testGetNextSet2Two() {
    BitArray bitArray = new BitArray(10);
    bitArray.set(5);

    assertEquals("getNextSet should return the first set bit", 5, bitArray.getNextSet(0));
    assertEquals("getNextSet should return size when no further bits are set", bitArray.getSize(), bitArray.getNextSet(6));
  }

  @Test
  public void testGetNextSet3Two() {
    BitArray bitArray = new BitArray(10);
    bitArray.set(2);
    bitArray.set(5);
    bitArray.set(7);

    assertEquals("getNextSet should return 1st set bit", 2, bitArray.getNextSet(0));
    assertEquals("getNextSet should return 2nd set bit", 5, bitArray.getNextSet(3));
    assertEquals("getNextSet should return 3rd set bit", 7, bitArray.getNextSet(6));
    assertEquals("No more bits set beyond 7", bitArray.getSize(), bitArray.getNextSet(8));
  }

  @Test
  public void testGetNextSet4Two() {
    BitArray bitArray = new BitArray(100);
    bitArray.set(10);
    bitArray.set(50);
    bitArray.set(75);

    assertEquals("Should find first set bit", 10, bitArray.getNextSet(0));
    assertEquals("Should find second set bit", 50, bitArray.getNextSet(11));
    assertEquals("Should find third set bit", 75, bitArray.getNextSet(51));
  }

  //-----------------------------------------------
//  @Test
//  public void testGetNextSet5Two() {
//    BitArray bitArray = new BitArray(100);
//    bitArray.set(20);
//    bitArray.set(40);
//    bitArray.set(60);
//
//    for (int i = 0; i < 100; i += 10) {
//      int nextSet = bitArray.getNextSet(i);
//      assertTrue("getNextSet should return a valid next set bit", nextSet >= i && nextSet <= 60);
//    }
//  }

  //@Test
//  public void reverseAlgorithmTestTwo() {
//    BitArray bitArray = new BitArray(64);
//    bitArray.set(0);
//    bitArray.set(63);
//
//    bitArray.reverse();
//
//    assertFalse("First bit should now be false", bitArray.get(0));
//    assertTrue("Last bit should now be true", bitArray.get(63));
//  }
  //-----------------------------------------------

  @Test
  public void testGetNextSet5Three() {
    BitArray bitArray = new BitArray(100);
    bitArray.set(20);
    bitArray.set(40);
    bitArray.set(60);

    for (int i = 0; i < 100; i += 10) {
      int expected = i <= 20 ? 20 : i <= 40 ? 40 : i <= 60 ? 60 : bitArray.getSize();
      int nextSet = bitArray.getNextSet(i);
      assertEquals("Next set bit should match expected value", expected, nextSet);
    }
  }


  @Test
  public void testSetBulkTwo() {
    BitArray bitArray = new BitArray(32);

    bitArray.setBulk(0, 0xFFFFFFFF);
    for (int i = 0; i < 32; i++) {
      assertTrue("All bits should be set", bitArray.get(i));
    }
  }

  @Test
  public void testSetRangeTwo() {
    BitArray bitArray = new BitArray(10);
    bitArray.setRange(3, 7);

    for (int i = 0; i < 10; i++) {
      if (i >= 3 && i < 7) {
        assertTrue("Bits in range should be set", bitArray.get(i));
      } else {
        assertFalse("Bits outside range should not be set", bitArray.get(i));
      }
    }
  }

  @Test
  public void testClearTwo() {
    BitArray bitArray = new BitArray(10);
    bitArray.setRange(0, 10);
    bitArray.clear();

    for (int i = 0; i < 10; i++) {
      assertFalse("All bits should be cleared", bitArray.get(i));
    }
  }

  @Test
  public void testFlipTwo() {
    BitArray bitArray = new BitArray(10);
    bitArray.flip(5);

    assertTrue("Bit should be flipped to true", bitArray.get(5));
    bitArray.flip(5);
    assertFalse("Bit should be flipped back to false", bitArray.get(5));
  }

  @Test
  public void testGetArrayTwo() {
    BitArray bitArray = new BitArray(32);
    bitArray.setBulk(0, 0xFFFFFFFF);

    int[] bits = bitArray.getBitArray();
    assertArrayEquals("Internal int array should represent all set bits", new int[] { 0xFFFFFFFF }, bits);
  }

  @Test
  public void testIsRangeTwo() {
    BitArray bitArray = new BitArray(10);
    bitArray.setRange(2, 5);

    assertFalse("Range should not be fully set to true", bitArray.isRange(2, 7, true));
    assertTrue("Range 2-5 should be fully set to true", bitArray.isRange(2, 5, true));
  }


  @Test
  public void reverseAlgorithmTestThree() {
    BitArray bitArray = new BitArray(64);
    bitArray.set(0);
    bitArray.set(63);

    bitArray.reverse();

    // Nach dem Umdrehen sollte der erste Bit jetzt gesetzt sein
    assertTrue("First bit should now be true", bitArray.get(0));
    // Und das letzte Bit sollte ebenfalls gesetzt sein
    assertTrue("Last bit should now be true", bitArray.get(63));
  }

  @Test
  public void testCloneTwo() {
    BitArray bitArray = new BitArray(10);
    bitArray.set(5);

    BitArray clone = bitArray.clone();
    assertEquals("Clone should be equal to original", clone, bitArray);

    clone.flip(5);
    assertNotEquals("Modifying clone should not affect original", clone, bitArray);
  }

  @Test
  public void testEqualsTwo() {
    BitArray bitArray1 = new BitArray(10);
    BitArray bitArray2 = new BitArray(10);
    System.out.println(bitArray1);

    assertEquals("Empty bit arrays should be equal", bitArray1, bitArray2);

    bitArray1.set(5);
    System.out.println(bitArray1);
    assertNotEquals("Different bit values should not be equal", bitArray1, bitArray2);

    bitArray2.set(5);
    assertEquals("Identical bit arrays should be equal", bitArray1, bitArray2);
  }





  //Mini
//  private BitArray bitArray;
//
//  @BeforeEach
//  void setUp() {
//    bitArray = new BitArray(64);
//    System.out.println("BitArray wurde initialisiert: " + bitArray);
//  }
//  @Test
//  public void testbefore(){
//    System.out.println("BitArray wurde initialisiert: " + bitArray);
//  }
//
//  @Test
//  public void testGetSetTwoMini() {
//    assertFalse(bitArray.get(0));
//    bitArray.set(0);
//    assertTrue(bitArray.get(0));
//  }
//
//  @Test
//  public void testGetNextSet1TwoMini() {
//    assertEquals(bitArray.getNextSet(0), 64); // Ende des Arrays, wenn nichts gesetzt ist
//  }
//
//  @Test
//  public void testGetNextSet2TwoMini() {
//    bitArray.set(4);
//    assertEquals(bitArray.getNextSet(0), 4); // Nächstes gesetztes Bit ist 4
//  }
//
//  @Test
//  public void testGetNextSet3TwoMini() {
//    bitArray.set(2);
//    bitArray.set(5);
//    assertEquals(bitArray.getNextSet(0), 2); // Erstes gesetztes Bit ist 2
//    assertEquals(bitArray.getNextSet(3), 5); // Nächstes gesetztes Bit ist 5
//  }
//
//  @Test
//  public void testGetNextSet4TwoMini() {
//    bitArray.set(1);
//    bitArray.set(30);
//    assertEquals(bitArray.getNextSet(0), 1); // Weiter entferntes gesetztes Bit
//    assertEquals(bitArray.getNextSet(2), 30); // Nächstes gesetztes Bit ist 30
//  }
//
//  @Test
//  public void testGetNextSet5TwoMini() {
//    for (int i = 0; i < 64; i += 2) {
//      bitArray.set(i); // Setze alle geraden Bits
//    }
//    assertEquals(bitArray.getNextSet(0), 0);
//    assertEquals(bitArray.getNextSet(1), 2);
//    assertEquals(bitArray.getNextSet(5), 6);
//  }
//
//  @Test
//  public void testSetBulkTwoMini() {
//    bitArray.setBulk(0, 0b11111111);
//    assertTrue(bitArray.get(0));
//    assertTrue(bitArray.get(1));
//    assertTrue(bitArray.get(2));
//    assertTrue(bitArray.get(3));
//    assertTrue(bitArray.get(4));
//    assertTrue(bitArray.get(5));
//    assertTrue(bitArray.get(6));
//    assertTrue(bitArray.get(7));
//    assertFalse(bitArray.get(8));
//  }
//
//  @Test
//  public void testSetRangeTwoMini() {
//    bitArray.setRange(5, 10);
//    assertTrue(bitArray.get(5));
//    assertTrue(bitArray.get(6));
//    assertTrue(bitArray.get(7));
//    assertTrue(bitArray.get(8));
//    assertTrue(bitArray.get(9));
//    assertFalse(bitArray.get(10));
//  }
//
//  @Test
//  public void testClearTwoMini() {
//    bitArray.set(3);
//    bitArray.set(5);
//    bitArray.clear();
//    for (int i = 0; i < bitArray.getSize(); i++) {
//      assertFalse(bitArray.get(i));
//    }
//  }
//
//  @Test
//  public void testFlipTwoMini() {
//    bitArray.flip(2);
//    assertTrue(bitArray.get(2));
//    bitArray.flip(2);
//    assertFalse(bitArray.get(2));
//  }
//
//  @Test
//  public void testGetArrayTwoMini() {
//    bitArray.set(3);
//    bitArray.set(4);
//    int[] array = bitArray.getBitArray();
//    assertEquals(0b11000, array[0]); // 11000 entspricht Bit 3 und 4 gesetzt
//  }
//
//  @Test
//  public void testIsRangeTwoMini() {
//    bitArray.setRange(0, 5);
//    assertTrue(bitArray.isRange(0, 5, true));
//    assertFalse(bitArray.isRange(0, 5, false));
//  }
//
//  @Test
//  public void reverseAlgorithmTestTwoMini() {
//    for (int i = 0; i < 10; i++) {
//      bitArray.set(i);
//    }
//    bitArray.reverse();
//    for (int i = 0; i < 10; i++) {
//      assertTrue(bitArray.get(9 - i)); // Die Bits sollten umgekehrt sein
//    }
//  }
//
//  @Test
//  public void testCloneTwoMini() {
//    bitArray.set(3);
//    BitArray clonedArray = bitArray.clone();
//    clonedArray.set(4);
//    assertTrue(bitArray.get(3));
//    assertFalse(bitArray.get(4));
//    assertTrue(clonedArray.get(3));
//    assertTrue(clonedArray.get(4));
//  }
//
//  @Test
//  public void testEqualsTwoMini() {
//    BitArray otherArray = new BitArray(64);
//    assertTrue(bitArray.equals(otherArray));
//    bitArray.set(1);
//    assertFalse(bitArray.equals(otherArray));
//    otherArray.set(1);
//    assertTrue(bitArray.equals(otherArray));
//  }

  //verbessert
  @Test
  public void testGetSetThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        assertFalse(bitArray.get(0)); // Überprüfen, ob das Bit an Position 0 "ausgeschaltet" ist
        bitArray.set(0); // Bit an Position 0 setzen
        assertTrue(bitArray.get(0)); // Überprüfen, ob das Bit jetzt "eingeschaltet" ist
    }

    @Test
    public void testGetNextSet1ThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        assertEquals(bitArray.getNextSet(0), 64); // Ende des Arrays, wenn nichts gesetzt ist
    }

    @Test
    public void testGetNextSet2ThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        bitArray.set(4); // Setze das Bit an Position 4
        assertEquals(bitArray.getNextSet(0), 4); // Nächstes gesetztes Bit ist 4
    }

    @Test
    public void testGetNextSet3ThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        bitArray.set(2); // Setze Bit an Position 2
        bitArray.set(5); // Setze Bit an Position 5
        assertEquals(bitArray.getNextSet(0), 2); // Erstes gesetztes Bit ist 2
        assertEquals(bitArray.getNextSet(3), 5); // Nächstes gesetztes Bit ist 5
    }

    @Test
    public void testGetNextSet4ThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        bitArray.set(1); // Setze Bit an Position 1
        bitArray.set(30); // Setze Bit an Position 30
        assertEquals(bitArray.getNextSet(0), 1); // Weiter entferntes gesetztes Bit
        assertEquals(bitArray.getNextSet(2), 30); // Nächstes gesetztes Bit ist 30
    }

    @Test
    public void testGetNextSet5ThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        for (int i = 0; i < 64; i += 2) {
            bitArray.set(i); // Setze alle geraden Bits
        }
        assertEquals(bitArray.getNextSet(0), 0);
        assertEquals(bitArray.getNextSet(1), 2);
        assertEquals(bitArray.getNextSet(5), 6);
    }

    @Test
    public void testSetBulkThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        bitArray.setBulk(0, 0b11111111); // Setze die ersten 8 Bits
        for (int i = 0; i < 8; i++) {
            assertTrue(bitArray.get(i)); // Überprüfe, ob die Bits gesetzt sind
        }
        assertFalse(bitArray.get(8)); // Das 9. Bit sollte nicht gesetzt sein
    }

    @Test
    public void testSetRangeThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        bitArray.setRange(5, 10); // Setze Bits von 5 bis 9
        for (int i = 5; i < 10; i++) {
            assertTrue(bitArray.get(i)); // Überprüfe, ob die Bits gesetzt sind
        }
        assertFalse(bitArray.get(10)); // Das 10. Bit sollte nicht gesetzt sein
    }

    @Test
    public void testClearThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        bitArray.set(3); // Setze Bit an Position 3
        bitArray.set(5); // Setze Bit an Position 5
        bitArray.clear(); // Lösche alle Bits
        for (int i = 0; i < bitArray.getSize(); i++) {
            assertFalse(bitArray.get(i)); // Überprüfen, ob alle Bits gelöscht sind
        }
    }

    @Test
    public void testFlipThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        bitArray.flip(2); // Flip das Bit an Position 2
        assertTrue(bitArray.get(2)); // Bit sollte jetzt "eingeschaltet" sein
        bitArray.flip(2); // Flip das Bit an Position 2 zurück
        assertFalse(bitArray.get(2)); // Bit sollte jetzt "ausgeschaltet" sein
    }

    @Test
    public void testGetArrayThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        bitArray.set(3); // Setze Bit an Position 3
        bitArray.set(4); // Setze Bit an Position 4
        int[] array = bitArray.getBitArray(); // Hole das zugrunde liegende Bit-Array
        assertEquals(0b11000, array[0]); // 11000 entspricht Bit 3 und 4 gesetzt
    }

    @Test
    public void testIsRangeThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        bitArray.setRange(0, 5); // Setze Bits von 0 bis 4
        assertTrue(bitArray.isRange(0, 5, true)); // Überprüfe, ob der Bereich gesetzt ist
        assertFalse(bitArray.isRange(0, 5, false)); // Überprüfe, ob der Bereich nicht gesetzt ist
    }

    //------------
//    @Test
//    public void reverseAlgorithmTestThreeMini() {
//        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
//        for (int i = 0; i < 10; i++) {
//            bitArray.set(i); // Setze die ersten 10 Bits
//        }
//        bitArray.reverse(); // Kehre die Bit-Reihenfolge um
//        for (int i = 0; i < 10; i++) {
//            assertTrue(bitArray.get(9 - i)); // Die Bits sollten umgekehrt sein
//        }
//    }
  //------------

    @Test
    public void testCloneThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        bitArray.set(3); // Setze Bit an Position 3
        BitArray clonedArray = bitArray.clone(); // Klone das BitArray
        clonedArray.set(4); // Setze Bit an Position 4 im Klon
        assertTrue(bitArray.get(3)); // Überprüfe, ob das Original-Bit gesetzt ist
        assertFalse(bitArray.get(4)); // Das Original sollte Bit 4 nicht gesetzt haben
        assertTrue(clonedArray.get(3)); // Klon sollte ebenfalls Bit 3 gesetzt haben
        assertTrue(clonedArray.get(4)); // Klon sollte Bit 4 gesetzt haben
    }

    @Test
    public void testEqualsThreeMini() {
        BitArray bitArray = new BitArray(64); // Größe 64 Bits für Tests
        BitArray otherArray = new BitArray(64); // Erstelle ein anderes BitArray
        assertTrue(bitArray.equals(otherArray)); // Überprüfe, ob sie gleich sind
        bitArray.set(1); // Setze Bit 1 im Original
        assertFalse(bitArray.equals(otherArray)); // Sie sollten jetzt ungleich sein
        otherArray.set(1); // Setze Bit 1 im anderen Array
        assertTrue(bitArray.equals(otherArray)); // Sie sollten jetzt wieder gleich sein
    }
}//Mini 155, KI 195, 257
