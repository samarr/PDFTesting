package com.pdf.demo.pdfcompare;

import de.redsix.pdfcompare.CompareResult;
import de.redsix.pdfcompare.CompareResultImpl;
import de.redsix.pdfcompare.PdfComparator;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {

   static String outputFolderName = "output";
    static String pdfResourcesLocation = "src/test/resources/";

    @BeforeClass
    public static void init()
    {
        try {
            FileUtils.deleteDirectory(new File(outputFolderName));
            Files.createDirectories(Paths.get(outputFolderName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    protected CompareResult comparePDFResult(String baseFile, String actualFile)
    {
        CompareResult compareResult;
        PdfComparator<CompareResultImpl> pdfComparator = new PdfComparator<>(baseFile, actualFile);
        try {
            compareResult = pdfComparator.compare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return compareResult;
    }

    protected CompareResult comparePDFResultWithIgnore(String baseFile, String actualFile, String fileName)
    {
        CompareResult compareResult;
        PdfComparator<CompareResultImpl> pdfComparator = new PdfComparator<>(baseFile, actualFile).withIgnore(fileName);
        try {
            compareResult = pdfComparator.compare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return compareResult;
    }
}
