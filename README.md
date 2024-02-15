# PDF visual comparison tests [![Java CI with Maven](https://github.com/samarr/PDFTesting/actions/workflows/maven.yml/badge.svg)](https://github.com/samarr/PDFTesting/actions/workflows/maven.yml)

The project is boilerplate code for visual comparison of two PDF files and show differences if any.

[PDFCompare](https://github.com/red6/pdfcompare) a java library has been used for the comparison. It renders files and compare them pixel by pixel.

In this project, multiple example test scenarios are created to showcase the capability of the library as well as the implementation pattern. TestNG has been used as test runner.

It is build with Java 19 and Maven. Though, you can downgrade JDK version upto 1.8.


## How to run the tests
Run the following command to execute all the tests.

`mvn clean test`

You can see the difference file (with match and mismatches) in output folder.

## Folders & files information

The core tests of comparison and pre-steps are in [BaseTest](src%2Ftest%2Fjava%2Fcom%2Fpdf%2Fdemo%2Fpdfcompare%2FBaseTest.java) class.

The test scenarios are present in [PDFCompareDemoTest](src%2Ftest%2Fjava%2Fcom%2Fpdf%2Fdemo%2Fpdfcompare%2FPDFCompareDemoTest.java) class.

[base.pdf](src%2Ftest%2Fresources%2Fbase.pdf) against which all the different PDF are getting matched. We are performing an assertFalse(assert match failure) to show that differences are getting caught with the PDFCompare library.
When the PDFs are identical, assertTrue is getting used.

Following scenarios are getting covered so far where differences are present in the test PDF.
* Some words are in bold
* Some characters are in different color
* Some characters are different (non-English letter)
* A word has highlighter
* Identical text but orientation of PDFs are different
* Border of the tables are different
* Font size is slightly bigger for a word
* No color for table border
* Text direction is different
* Skip a section during the comparison
