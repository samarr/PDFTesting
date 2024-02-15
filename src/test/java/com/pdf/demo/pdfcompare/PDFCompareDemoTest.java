package com.pdf.demo.pdfcompare;

import de.redsix.pdfcompare.CompareResult;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDFCompareDemoTest extends BaseTest{

    @Test (description = "base.pdf and baseline.pdf are identical. This test asserting that both are same.")
    public void identialPDFtest() {
        String baseFileName = pdfResourcesLocation + "base.pdf";
        String expectedFileName = pdfResourcesLocation + "baseline.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, expectedFileName);
        compareResult.writeTo(outputFolder + "/"+"identical");
        Assert.assertTrue(compareResult.isEqual());
    }
    @Test (description = "In boldname.pdf, name value is in bold. The test is asserting that difference is detected.")
    public void boldFontDifferenceInPDFTest(){
        String baseFileName = pdfResourcesLocation + "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation + "boldname.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolder + "/"+"boldFontDifference");
    }

    @Test (description = "In differencecolor.pdf, one of the word in different color. The test is asserting that" +
            " difference.")
    public void colorDifferenceInPDFTest(){
        String baseFileName = pdfResourcesLocation + "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation + "differentcolor.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolder + "/"+"colorDifference");
    }

    @Test (description = "In highlights.pdf, one of the word is highlighted. The test is asserting that difference.")
    public void highLightedTextInPDFTest(){
        String baseFileName = pdfResourcesLocation + "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation + "highlights.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolder + "/"+"highlightedText");
    }

    @Test (description = "Both PDF have different orientation but identical text and format. The test is asserting the" +
            " difference.")
    public void differentOrientationPDFTest(){
        String baseFileName = pdfResourcesLocation + "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation + "landscape.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolder + "/"+"landscapeOriented");
    }

    @Test (description = "In noborder.pdf table does not have border. The test is asserting the difference.")
    public void zeroBorderSizePDFTest(){
        String baseFileName = pdfResourcesLocation + "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation + "noborder.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolder + "/"+"noBorderComparison");
    }

    @Test (description = "In verticalname.pdf, one of the word is vertically aligned. The test is asserting the difference.")
    public void differentTextAlignmentPDFTest(){
        String baseFileName = pdfResourcesLocation + "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation + "verticalname.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolder + "/"+"differentTextAlignment");
    }

    @Test (description = "In largerfont.pdf one of the word has .5 larger font. The test is asserting the difference.")
    public void differentFontSizePDFTest(){
        String baseFileName = pdfResourcesLocation + "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation + "largerfont.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolder + "/"+"differentFontSize");
    }

    @Test (description = "In largeborder.pdf table has slightly bigger border. The test is asserting the difference.")
    public void differentBorderSizePDFTest(){
        String baseFileName = pdfResourcesLocation + "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation + "largeborder.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolder + "/"+"differentBorderSize");
    }

    @Test (description = "In differenttext.pdf one of the letter is non-English but look almost same. " +
            "The test is asserting the difference.")
    public void diffentTextinPDFTest(){
        String baseFileName = pdfResourcesLocation + "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation + "differenttext.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolder + "/"+"letterDifference");
    }

    @Test (description = "In both the PDF, name is different. However the test is ignoring the text box as per ignore.conf" +
            " and asserting that rest of the PDF are matching.")
    public void differentNameWithIgnoreAreaPDFTest(){
        String baseFileName = pdfResourcesLocation + "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation + "ignorename.pdf";
        String ignoreFileConf = pdfResourcesLocation + "ignore.conf";

        CompareResult compareResult = comparePDFResultWithIgnore(baseFileName, boldLetteredNameFileName, ignoreFileConf);
        Assert.assertTrue(compareResult.isEqual());
        compareResult.writeTo(outputFolder + "/"+"ignoreDifference");
    }

}
