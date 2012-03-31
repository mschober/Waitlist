package utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import utils.data.validation.EmailCheck;
import wl.WLTest;

public class EmailTest extends WLTest {

    private static final String[] expectedTrue = {
        "___.______@gmail.com",
        "----.----@gmail.com",
        "mike.schober@gmail.com",
        "mike.schober.will.smith.whatever.whatever.123412.23412@gmail.com",
        "myemail@mike.schober.will.smith.whatever.whatever.123412.23412.com",
        "mike.schober@gmail.com.ab.cd.ef.gh.ij.kl",
        "mike.schober@gmail.commasdfsdafasfea",
        "mike.schober@1234.com",
        "mike.schober@gmail.123assdfaeaw.com",
        "a@b.com",
        "mkyong@yahoo.com",
        "mkyong-100@yahoo.com",
        "mkyong.100@yahoo.com",
        "mkyong111@mkyong.com",
        "mkyong-100@mkyong.net",
        "mkyong.100@mkyong.com.au",
        "mkyong@1.com",
        "mkyong@gmail.com.com"
    };

    private static final String[] expectedFalse = {
        ")(mike.schober@gmail.com",
        "mike.schober@)(gmail.com",
        "mike.schober@gmail.)(com",
        "mkyong",
        "mkyong@.com.my",
        "mkyong123@gmail.a",
        "mkyong123@.com",
        "mkyong123@.com.com",
        ".mkyong@mkyong.com",
        "mkyong()*@gmail.com",
        "mkyong@%*.com",
        "mkyong..2002@gmail.com",
        "mkyong.@gmail.com",
        "mkyong@mkyong@gmail.com",
        "mkyong@gmail.com.1a",
        "mkyong@gmail.com.1a"
    };

    private static final String[] reasons = {
        "",
        "",
        "",
        "",
        "must contains \"@\" symbol",
        "tld can not start with dot \".\"",
        "\".a\" is not a valid tld, last tld must contains at least two characters",
        "tld can not start with dot \".\"",
        "tld can not start with dot \".\"",
        "email’s first character can not start with dot \".\"",
        "email’s is only allow character, digit, underscore and dash",
        "email’s tld is only allow character and digit",
        "double dots \".\" are not allow",
        "email’s last character can not end with dot \".\"",
        "double \"@\" is not allow",
        "-email’s tld which has two characters can not contains digit"
    };

    @Test
    public void isValid() {
        assertTrue(expectedTrue, new RegexEmailValidator());
        assertFalse(expectedFalse, reasons, new RegexEmailValidator());
    }

	@Test
    public void isSimplyValid() {
        assertTrue(expectedTrue, new SimpleEmailValidator());
        assertEquals(expectedFalse.length, reasons.length);
        assertFalse(expectedFalse, reasons, new SimpleEmailValidator());
    }

    private void assertFalse(String[] expectedFalse, String[] reason, EmailValidator validator) {
        int next = 0;
        for(String emailAddress: expectedFalse)
            assertFalse("Failed: " + emailAddress + "\n" + reason[next++], EmailCheck.validate(emailAddress));
    }

    private void assertTrue(String[] expectedTrue, EmailValidator validator) {
        for(String emailAddress: expectedTrue)
            assertTrue("Failed: " + emailAddress, EmailCheck.validate(emailAddress));
    }
}
