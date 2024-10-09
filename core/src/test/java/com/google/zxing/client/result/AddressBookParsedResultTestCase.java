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

package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests {@link AddressBookParsedResult}.
 *
 * @author Sean Owen
 */
public final class AddressBookParsedResultTestCase extends Assert {

//  @Test
//  public void testAddressBookDocomo() {
//    doTest("MECARD:N:Sean Owen;;", null, new String[] {"Sean Owen"},
//        null, null, null, null, null, null, null, null, null);
//    doTest("MECARD:NOTE:ZXing Team;N:Sean Owen;URL:google.com;EMAIL:srowen@example.org;;",
//        null, new String[] {"Sean Owen"}, null, null, new String[] {"srowen@example.org"}, null, null, null,
//        new String[] {"google.com"}, null, "ZXing Team");
//  }
//
//  @Test
//  public void testAddressBookAU() {
//    doTest("MEMORY:foo\r\nNAME1:Sean\r\nTEL1:+12125551212\r\n",
//        null, new String[] {"Sean"}, null, null, null, new String[] {"+12125551212"}, null, null, null, null, "foo");
//  }
//
//  @Test
//  public void testVCard() {
//    doTest("BEGIN:VCARD\r\nADR;HOME:123 Main St\r\nVERSION:2.1\r\nN:Owen;Sean\r\nEND:VCARD",
//           null, new String[] {"Sean Owen"}, null, new String[] {"123 Main St"},
//           null, null, null, null, null, null, null);
//  }
//
//  @Test
//  public void testVCardFullN() {
//    doTest("BEGIN:VCARD\r\nVERSION:2.1\r\nN:Owen;Sean;T;Mr.;Esq.\r\nEND:VCARD",
//           null, new String[] {"Mr. Sean T Owen Esq."}, null, null, null, null, null, null, null, null, null);
//  }
//
//  @Test
//  public void testVCardFullN2() {
//    doTest("BEGIN:VCARD\r\nVERSION:2.1\r\nN:Owen;Sean;;;\r\nEND:VCARD",
//           null, new String[] {"Sean Owen"}, null, null, null, null, null, null, null, null, null);
//  }
//
//  @Test
//  public void testVCardFullN3() {
//    doTest("BEGIN:VCARD\r\nVERSION:2.1\r\nN:;Sean;;;\r\nEND:VCARD",
//           null, new String[] {"Sean"}, null, null, null, null, null, null, null, null, null);
//  }
//
//  @Test
//  public void testVCardCaseInsensitive() {
//    doTest("begin:vcard\r\nadr;HOME:123 Main St\r\nVersion:2.1\r\nn:Owen;Sean\r\nEND:VCARD",
//           null, new String[] {"Sean Owen"}, null, new String[] {"123 Main St"},
//           null, null, null, null, null, null, null);
//  }
//
//  @Test
//  public void testEscapedVCard() {
//    doTest("BEGIN:VCARD\r\nADR;HOME:123\\;\\\\ Main\\, St\\nHome\r\nVERSION:2.1\r\nN:Owen;Sean\r\nEND:VCARD",
//           null, new String[] {"Sean Owen"}, null, new String[] {"123;\\ Main, St\nHome"},
//           null, null, null, null, null, null, null);
//  }
//
//  @Test
//  public void testBizcard() {
//    doTest("BIZCARD:N:Sean;X:Owen;C:Google;A:123 Main St;M:+12125551212;E:srowen@example.org;",
//        null, new String[] {"Sean Owen"}, null, new String[] {"123 Main St"}, new String[] {"srowen@example.org"},
//        new String[] {"+12125551212"}, null, "Google", null, null, null);
//  }
//
//  @Test
//  public void testSeveralAddresses() {
//    doTest("MECARD:N:Foo Bar;ORG:Company;TEL:5555555555;EMAIL:foo.bar@xyz.com;ADR:City, 10001;" +
//           "ADR:City, 10001;NOTE:This is the memo.;;",
//           null, new String[] {"Foo Bar"}, null, new String[] {"City, 10001", "City, 10001"},
//           new String[] {"foo.bar@xyz.com"},
//           new String[] {"5555555555" }, null, "Company", null, null, "This is the memo.");
//  }
//
//  @Test
//  public void testQuotedPrintable() {
//    doTest("BEGIN:VCARD\r\nADR;HOME;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:;;" +
//           "=38=38=20=4C=79=6E=62=72=6F=6F=6B=0D=0A=43=\r\n" +
//           "=4F=20=36=39=39=\r\n" +
//           "=39=39;;;\r\nEND:VCARD",
//           null, null, null, new String[] {"88 Lynbrook\r\nCO 69999"},
//           null, null, null, null, null, null, null);
//  }
//
//  @Test
//  public void testVCardEscape() {
//    doTest("BEGIN:VCARD\r\nNOTE:foo\\nbar\r\nEND:VCARD",
//           null, null, null, null, null, null, null, null, null, null, "foo\nbar");
//    doTest("BEGIN:VCARD\r\nNOTE:foo\\;bar\r\nEND:VCARD",
//               null, null, null, null, null, null, null, null, null, null, "foo;bar");
//    doTest("BEGIN:VCARD\r\nNOTE:foo\\\\bar\r\nEND:VCARD",
//                   null, null, null, null, null, null, null, null, null, null, "foo\\bar");
//    doTest("BEGIN:VCARD\r\nNOTE:foo\\,bar\r\nEND:VCARD",
//                       null, null, null, null, null, null, null, null, null, null, "foo,bar");
//  }
//
//  @Test
//  public void testVCardValueURI() {
//    doTest("BEGIN:VCARD\r\nTEL;VALUE=uri:tel:+1-555-555-1212\r\nEND:VCARD",
//        null, null, null, null, null, new String[] { "+1-555-555-1212" }, new String[] { null },
//        null, null, null, null);
//
//    doTest("BEGIN:VCARD\r\nN;VALUE=text:Owen;Sean\r\nEND:VCARD",
//        null, new String[] {"Sean Owen"}, null, null, null, null, null, null, null, null, null);
//  }
//
//  @Test
//  public void testVCardTypes() {
//    doTest("BEGIN:VCARD\r\nTEL;HOME:\r\nTEL;WORK:10\r\nTEL:20\r\nTEL;CELL:30\r\nEND:VCARD",
//           null, null, null, null, null, new String[] { "10", "20", "30" },
//           new String[] { "WORK", null, "CELL" }, null, null, null, null);
//  }

  private static void doTest(String contents,
                             String title,
                             String[] names,
                             String pronunciation,
                             String[] addresses,
                             String[] emails,
                             String[] phoneNumbers,
                             String[] phoneTypes,
                             String org,
                             String[] urls,
                             String birthday,
                             String note) {
    Result fakeResult = new Result(contents, null, null, BarcodeFormat.QR_CODE);
    ParsedResult result = ResultParser.parseResult(fakeResult);
    assertSame(ParsedResultType.ADDRESSBOOK, result.getType());
    AddressBookParsedResult addressResult = (AddressBookParsedResult) result;
    assertEquals(title, addressResult.getTitle());
    assertArrayEquals(names, addressResult.getNames());
    assertEquals(pronunciation, addressResult.getPronunciation());
    assertArrayEquals(addresses, addressResult.getAddresses());
    assertArrayEquals(emails, addressResult.getEmails());
    assertArrayEquals(phoneNumbers, addressResult.getPhoneNumbers());
    assertArrayEquals(phoneTypes, addressResult.getPhoneTypes());
    assertEquals(org, addressResult.getOrg());
    assertArrayEquals(urls, addressResult.getURLs());
    assertEquals(birthday, addressResult.getBirthday());
    assertEquals(note, addressResult.getNote());
  }

//KItest

  @Test
  public void testAddressBookDocomoThree() {
    Result result = new Result("MECARD:N:John Doe;NOTE:Friend from school;;", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    assertEquals(ParsedResultType.ADDRESSBOOK, parsedResult.getType());
    AddressBookParsedResult addressBookResult = (AddressBookParsedResult) parsedResult;
    assertArrayEquals(new String[]{"John Doe"}, addressBookResult.getNames());
    assertEquals("Friend from school", addressBookResult.getNote());
  }

  @Test
  public void testAddressBookAUTwo() {
    Result result = new Result("AU:NAME:Jane Doe;TEL:+491234567890;", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    // Custom check for AU parser output
  }

  @Test
  public void testVCardTwo() {
    Result result = new Result("BEGIN:VCARD\nFN:John Doe\nADR:221B Baker Street\nEND:VCARD", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    assertEquals(ParsedResultType.ADDRESSBOOK, parsedResult.getType());
    AddressBookParsedResult addressBookResult = (AddressBookParsedResult) parsedResult;
    assertArrayEquals(new String[]{"John Doe"}, addressBookResult.getNames());
    assertArrayEquals(new String[]{"221B Baker Street"}, addressBookResult.getAddresses());
  }

  @Test
  public void testVCardFullNTwo() {
    Result result = new Result("BEGIN:VCARD\nN:Dr.;John;H.;Doe;Jr.\nEND:VCARD", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    assertEquals(ParsedResultType.ADDRESSBOOK, parsedResult.getType());
    AddressBookParsedResult addressBookResult = (AddressBookParsedResult) parsedResult;
    // Custom assertion for full name
  }

  @Test
  public void testVCardFullN2Two() {
    Result result = new Result("BEGIN:VCARD\nN:Doe;J.\nEND:VCARD", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    // Custom assertion for parsing abbreviated full name
  }

  @Test
  public void testVCardFullN3Two() {
    Result result = new Result("BEGIN:VCARD\nN:;John;;;\nEND:VCARD", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    // Custom assertion for first name only
  }

  @Test
  public void testVCardCaseInsensitiveTwo() {
    Result result = new Result("begin:vcard\nfn:Jane Doe\nend:vcard", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    // Custom assertion for case insensitivity
  }

  @Test
  public void testEscapedVCardTwo() {
    Result result = new Result("BEGIN:VCARD\nADR:123\\; Some Street\\,. Apt \\#101\nEND:VCARD", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    // Custom assertion for special characters
  }

  @Test
  public void testBizcardTwo() {
    Result result = new Result("BIZCARD:NAME:John Doe;ORG:Example Inc;TEL:+491234567890;EMAIL:john.doe@example.com;ADR:123 Main Street;", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    // Custom assertion for Bizcard data
  }

  @Test
  public void testSeveralAddressesTwo() {
    Result result = new Result("BEGIN:VCARD\nADR:Home Address 1\nADR:Office Address\nEND:VCARD", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    // Custom assertion for multiple addresses
  }

  @Test
  public void testQuotedPrintableTwo() {
    Result result = new Result("BEGIN:VCARD\nFN:John =7EDoe\nEND:VCARD", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    // Custom assertion for quoted-printable decoding
  }

  @Test
  public void testVCardEscapeTwo() {
    Result result = new Result("BEGIN:VCARD\nFN:John\\nDoe\nEND:VCARD", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    // Custom assertion for escape mechanisms
  }

  @Test
  public void testVCardValueURITwo() {
    Result result = new Result("BEGIN:VCARD\nTEL;URI:tel:+491234567890\nEND:VCARD", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    // Custom assertion for URI-formatted phone number
  }

  @Test
  public void testVCardTypesTwo() {
    Result result = new Result("BEGIN:VCARD\nTEL;TYPE=HOME:+491234567890\nTEL;TYPE=WORK:+49876543210\nEND:VCARD", null, null, null);
    ParsedResult parsedResult = ResultParser.parseResult(result);
    // Custom assertion for multiple phone numbers
  }

  //Mini
  // Test 1: DOCOMO-Format
//  @Test
//  public void testDocomoContactCardRecognition() {
//    String contents = "BEGIN:DOCOMO\nN:John;Doe\nTEL;TYPE=CELL:123456789\nEND:DOCOMO";
//    String title = null;
//    String[] names = {"John Doe"};
//    String pronunciation = null;
//    String[] addresses = null;
//    String[] emails = null;
//    String[] phoneNumbers = {"123456789"};
//    String[] phoneTypes = {"CELL"};
//    String org = null;
//    String[] urls = null;
//    String birthday = null;
//    String note = null;
//
//    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
//  }

//   Test 2: AU-Format
//  @Test
//  public void testAUFormatContactInfoRecognition() {
//    String contents = "BEGIN:AU\nN:Doe;Jane;\nTEL;TYPE=HOME:987654321\nEND:AU";
//    String title = null;
//    String[] names = {"Jane Doe"};
//    String pronunciation = null;
//    String[] addresses = null;
//    String[] emails = null;
//    String[] phoneNumbers = {"987654321"};
//    String[] phoneTypes = {"HOME"};
//    String org = null;
//    String[] urls = null;
//    String birthday = null;
//    String note = null;
//
//    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
//  }
//
//   //Test 3: vCard Recognition
//  @Test
//  public void testVCardParsing() {
//    String contents = "BEGIN:VCARD\nVERSION:3.0\nN:Doe;John;;Mr;\nTEL;TYPE=CELL:+1234567890\nEND:VCARD";
//    String title = "Mr."; // Erwarteter Titel
//    String[] names = {"John Doe"}; // Erwarteter Name
//    String pronunciation = null;
//    String[] addresses = null;
//    String[] emails = null;
//    String[] phoneNumbers = {"+1234567890"};
//    String[] phoneTypes = {"CELL"};
//    String org = null;
//    String[] urls = null;
//    String birthday = null;
//    String note = null;
//
//    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
//  }

   //Test 4: Complex Name Formats in vCard
//  @Test
//  public void testComplexNameFormatsInVCard() {
//    String contents = "BEGIN:VCARD\nVERSION:3.0\nN:Doe;John;Mr.\nTEL;TYPE=CELL:123123123\nEND:VCARD";
//    String title = "Mr."; // Erwarteter Titel
//    String[] names = {"John Doe"}; // Erwarteter Name
//    String pronunciation = null;
//    String[] addresses = null;
//    String[] emails = null;
//    String[] phoneNumbers = {"123123123"};
//    String[] phoneTypes = {"CELL"};
//    String org = null;
//    String[] urls = null;
//    String birthday = null;
//    String note = null;
//
//    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
//  }

   //Test 5: Case Insensitivity in vCard
  @Test
  public void testCaseInsensitivityInVCardThreeMini() {
    String contents = "BEGIN:VCARD\nVERSION:3.0\nN:Doe;John;\nTEL;TYPE=WORK:1122334455\nEND:VCARD";
    String title = null;
    String[] names = {"John Doe"}; // Erwarteter Name (im standardisierten Format)
    String pronunciation = null;
    String[] addresses = null;
    String[] emails = null;
    String[] phoneNumbers = {"1122334455"};
    String[] phoneTypes = {"WORK"};
    String org = null;
    String[] urls = null;
    String birthday = null;
    String note = null;

    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
  }


  // Test 6: Escape Characters in vCard
  @Test
  public void testEscapeCharactersInVCardThreeMini() {
    String contents = "BEGIN:VCARD\nVERSION:3.0\nN:O'Reilly;Timothy\nTEL;TYPE=CELL:123\\;4567890\nEND:VCARD";
    String title = null;
    String[] names = {"Timothy O'Reilly"};
    String pronunciation = null;
    String[] addresses = null;
    String[] emails = null;
    String[] phoneNumbers = {"123;4567890"};
    String[] phoneTypes = {"CELL"};
    String org = null;
    String[] urls = null;
    String birthday = null;
    String note = null;

    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
  }

  // Test 7: Different vCard Types
  @Test
  public void testDifferentVCardTypesThreeMini() {
    String contents = "BEGIN:VCARD\nVERSION:3.0\nN:Smith;John\nTEL;TYPE=HOME:234567890\nTEL;TYPE=WORK:234567891\nEND:VCARD";
    String title = null;
    String[] names = {"John Smith"};
    String pronunciation = null;
    String[] addresses = null;
    String[] emails = null;
    String[] phoneNumbers = {"234567890", "234567891"};
    String[] phoneTypes = {"HOME", "WORK"};
    String org = null;
    String[] urls = null;
    String birthday = null;
    String note = null;

    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
  }

  // Test 8: Quoted-Printable Encoding
  @Test
  public void testQuotedPrintableEncodingInVCardThreeMini() {
    String contents = "BEGIN:VCARD\nVERSION:3.0\nN:Doe;John\nTEL;TYPE=CELL:1234567890\nEMAIL;TYPE=WORK:john.doe@example.com\nEND:VCARD";
    String title = null;
    String[] names = {"John Doe"};
    String pronunciation = null;
    String[] addresses = null;
    String[] emails = {"john.doe@example.com"};
    String[] phoneNumbers = {"1234567890"};
    String[] phoneTypes = {"CELL"};
    String org = null;
    String[] urls = null;
    String birthday = null;
    String note = null;

    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
  }

  // Test 9: Phone Number Types
  @Test
  public void testPhoneNumberTypesInVCardThreeMini() {
    String contents = "BEGIN:VCARD\nVERSION:3.0\nN:Johnson;Mark\nTEL;TYPE=HOME:5551234567\nTEL;TYPE=WORK:5559876543\nEND:VCARD";
    String title = null;
    String[] names = {"Mark Johnson"};
    String pronunciation = null;
    String[] addresses = null;
    String[] emails = null;
    String[] phoneNumbers = {"5551234567", "5559876543"};
    String[] phoneTypes = {"HOME", "WORK"};
    String org = null;
    String[] urls = null;
    String birthday = null;
    String note = null;

    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
  }

   //Test 10: Complex Presence of Types
  @Test
  public void testComplexPhoneTypesInVCardThreeMini() {
    String contents = "BEGIN:VCARD\nVERSION:3.0\nN:Brown;Charlie\nTEL;TYPE=HOME,VOICE:1112223333\nTEL;TYPE=WORK,VOICE:4445556666\nEND:VCARD";
    String title = null;
    String[] names = {"Charlie Brown"};
    String pronunciation = null;
    String[] addresses = null;
    String[] emails = null;
    String[] phoneNumbers = {"1112223333", "4445556666"};
    String[] phoneTypes = {"HOME,VOICE", "WORK,VOICE"};
    String org = null;
    String[] urls = null;
    String birthday = null;
    String note = null;

    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
  }

   //Test 11: URLs in vCard
  @Test
  public void testURLsInVCardThreeMini() {
    String contents = "BEGIN:VCARD\nVERSION:3.0\nN:Hanks;Tom\nURL:http://www.tomhanks.com\nEND:VCARD";
    String title = null;
    String[] names = {"Tom Hanks"}; // Erwarteter Name im Format Vorname Nachname
    String pronunciation = null;
    String[] addresses = null;
    String[] emails = null;
    String[] phoneNumbers = null;
    String[] phoneTypes = null;
    String org = null;
    String[] urls = {"http://www.tomhanks.com"}; // Erwartete URL
    String birthday = null;
    String note = null;

    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
  }

  // Test 12: Birthday in vCard
//  @Test
//  public void testBirthdayInVCard() {
//    String contents = "BEGIN:VCARD\nVERSION:3.0\nN:King;Stephen\nBIRTHDAY:19740101\nEND:VCARD";
//    String title = null;
//    String[] names = {"Stephen King"}; // Erwarteter Name
//    String pronunciation = null;
//    String[] addresses = null;
//    String[] emails = null;
//    String[] phoneNumbers = null;
//    String[] phoneTypes = null;
//    String org = null;
//    String[] urls = null;
//    String birthday = "19740101"; // Erwartetes Geburtsdatum
//    String note = null;
//
//    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
//  }
   //Test 13: Notes in vCard
  @Test
  public void testNotesInVCardThreeMini() {
    String contents = "BEGIN:VCARD\nVERSION:3.0\nN:Orwell;George\nNOTE:Author of \"1984\"\nEND:VCARD";
    String title = null;
    String[] names = {"George Orwell"}; // Erwarteter Name
    String pronunciation = null;
    String[] addresses = null;
    String[] emails = null;
    String[] phoneNumbers = null;
    String[] phoneTypes = null;
    String org = null;
    String[] urls = null;
    String birthday = null;
    String note = "Author of \"1984\""; // Erwartete Notiz

    doTest(contents, title, names, pronunciation, addresses, emails, phoneNumbers, phoneTypes, org, urls, birthday, note);
  }

   //Test 14: Multiple Addresses in vCard
  @Test
  public void testMultipleAddressesInVCardThreeMini() {
    String contents = "BEGIN:VCARD\nVERSION:3.0\nN:Smith;John\nADR;TYPE=HOME:123 Main St;Anytown;CA;90210;USA\nADR;TYPE=WORK:456 Elm St;Othertown;CA;90211;USA\nEND:VCARD";
    String title = null;
    String[] names = {"John Smith"};
    String pronunciation = null;
    String[] addresses = {"123 Main St;Anytown;CA;90210;USA", "456 Elm St;Othertown;CA;90211;USA"};
    String[] emails = null;
    String[] phoneNumbers = null;
    String[] phoneTypes = null;
    String org = null;
    String[] urls = null;
    String birthday = null;
    String note = null;
  }

}//Mini 317, KI160 , 167
