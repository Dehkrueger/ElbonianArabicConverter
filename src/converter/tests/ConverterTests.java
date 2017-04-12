package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test
    public void ElbonianToArabicIII() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("III");
        assertEquals(converter.toArabic(), 3);
    }

    @Test
    public void ElbonianToArabicV() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("V");
        assertEquals(converter.toArabic(), 5);
    }

    @Test
    public void ElbonianToArabicvV() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("vV");
        assertEquals(converter.toArabic(), 4);
    }

    @Test
    public void ElbonianToArabicVvV() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("VvV");
        assertEquals(converter.toArabic(), 9);
    }

    @Test
    public void ElbonianToArabicMMDdDXVvV() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter(" MMDdDXVvV ");
        assertEquals(converter.toArabic(), 2919);
    }

    @Test
    public void ElbonianToArabicDdDLlLVvV() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter(" DdDLlLVvV");
        assertEquals(converter.toArabic(), 999);
    }

    @Test
    public void ArabicToElbonian3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3");
        assertEquals(converter.toElbonian(), "III");
    }

    @Test
    public void ArabicToElbonian5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("5");
        assertEquals(converter.toElbonian(), "V");
    }

    @Test
    public void ArabicToElbonian4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("4");
        assertEquals(converter.toElbonian(), "vV");
    }

    @Test
    public void ArabicToElbonian217() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("217");
        assertEquals(converter.toElbonian(), "CCXVII");
    }

    @Test
    public void ArabicToElbonian999() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("999");
        assertEquals(converter.toElbonian(), "DdDLlLVvV");
    }

    @Test
    public void ArabicToElbonian3049() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3049");
        assertEquals(converter.toElbonian(), "MMMlLVvV");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicOoO() throws MalformedNumberException, ValueOutOfBoundsException {
        new ElbonianArabicConverter("VM");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicOoO2() throws MalformedNumberException, ValueOutOfBoundsException {
        new ElbonianArabicConverter("MMDdDLLLLXVvV");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicSpaces() throws MalformedNumberException, ValueOutOfBoundsException {
        new ElbonianArabicConverter("MMDdDL LVvV");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicBadCase1() throws MalformedNumberException, ValueOutOfBoundsException {
        new ElbonianArabicConverter("iI");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicBadCase2() throws MalformedNumberException, ValueOutOfBoundsException {
        new ElbonianArabicConverter("cD");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicBadCase3() throws MalformedNumberException, ValueOutOfBoundsException {
        new ElbonianArabicConverter("dC");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicMultiple4() throws MalformedNumberException, ValueOutOfBoundsException {
        new ElbonianArabicConverter("dDC");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicMultiple9() throws MalformedNumberException, ValueOutOfBoundsException {
        new ElbonianArabicConverter("LlLX");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }
    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("TEST");
    }



}
