package com.pdf.demo.pdfcompare;

import de.redsix.pdfcompare.CompareResult;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDFCompareDemoTest extends BaseTest{

    @Test
    public void identialPDFtest() {
        String baseFileName = pdfResourcesLocation+ "base.pdf";
        String expectedFileName = pdfResourcesLocation+"baseline.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, expectedFileName);
        compareResult.writeTo(outputFolderName+"/"+"identical");
        Assert.assertTrue(compareResult.isEqual());
    }
    @Test
    public void boldFontDifferenceInPDFTest(){
        String baseFileName = pdfResourcesLocation+ "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation+ "boldname.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolderName+"/"+"boldFontDifference");
    }

    @Test
    public void colorDifferenceinPDFTest(){
        String baseFileName = pdfResourcesLocation+ "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation+ "differentcolor.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolderName+"/"+"colorDifference");
    }

    @Test
    public void highLightedTextInPDFTest(){
        String baseFileName = pdfResourcesLocation+ "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation+ "highlights.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolderName+"/"+"highlightedText");
    }

    @Test
    public void differentOrientationPDFTest(){
        String baseFileName = pdfResourcesLocation+ "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation+ "landscape.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolderName+"/"+"landscapeOriented");
    }

    @Test
    public void zeroBorderSizePDFTest(){
        String baseFileName = pdfResourcesLocation+ "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation+ "noborder.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolderName+"/"+"noBorderComparison");
    }

    @Test
    public void differentTextAlignmentPDFTest(){
        String baseFileName = pdfResourcesLocation+ "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation+ "verticalname.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolderName+"/"+"differentTextAlignment");
    }

    @Test
    public void differentFontSizePDFTest(){
        String baseFileName = pdfResourcesLocation+ "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation+ "largerfont.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolderName+"/"+"differentFontSize");
    }

    @Test
    public void differentBorderSizePDFTest(){
        String baseFileName = pdfResourcesLocation+ "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation+ "largeborder.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolderName+"/"+"differentBorderSize");
    }

    @Test
    public void diffentTextinPDFTest(){
        String baseFileName = pdfResourcesLocation+ "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation+ "differenttext.pdf";

        CompareResult compareResult = comparePDFResult(baseFileName, boldLetteredNameFileName);
        Assert.assertFalse(compareResult.isEqual());
        compareResult.writeTo(outputFolderName+"/"+"letterDifference");
    }

    @Test
    public void differentNameWithIgnoreAreaPDFTest(){
        String baseFileName = pdfResourcesLocation+ "base.pdf";
        String boldLetteredNameFileName = pdfResourcesLocation+ "ignorename.pdf";
        String ignoreFileConf = pdfResourcesLocation + "ignore.conf";

        CompareResult compareResult = comparePDFResultWithIgnore(baseFileName, boldLetteredNameFileName, ignoreFileConf);
        Assert.assertTrue(compareResult.isEqual());
        compareResult.writeTo(outputFolderName+"/"+"ignoreDifference");
    }



}
