package chapter_2_create_destroy_objects.avoid_extra_objects.avoid_extra_objects;

import chapter_2_create_destroy_objects.avoid_extra_objects.RomanNumerals;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumeralsTest {

    @Test
    public void testValidRomanNumerals() {
        assertThat(RomanNumerals.isRomanNumeral("I")).isTrue();
        assertThat(RomanNumerals.isRomanNumeral("IV")).isTrue();
        assertThat(RomanNumerals.isRomanNumeral("IX")).isTrue();
        assertThat(RomanNumerals.isRomanNumeral("XL")).isTrue();
        assertThat(RomanNumerals.isRomanNumeral("XC")).isTrue();
        assertThat(RomanNumerals.isRomanNumeral("CD")).isTrue();
        assertThat(RomanNumerals.isRomanNumeral("CM")).isTrue();
        assertThat(RomanNumerals.isRomanNumeral("MCMXCIV")).isTrue();
    }

    @Test
    public void testInvalidRomanNumerals() {
        assertThat(RomanNumerals.isRomanNumeral("IIII")).isFalse();
        assertThat(RomanNumerals.isRomanNumeral("VV")).isFalse();
        assertThat(RomanNumerals.isRomanNumeral("LL")).isFalse();
        assertThat(RomanNumerals.isRomanNumeral("123")).isFalse();
        assertThat(RomanNumerals.isRomanNumeral("ABC")).isFalse();
        assertThat(RomanNumerals.isRomanNumeral("")).isFalse();
        assertThat(RomanNumerals.isRomanNumeral(null)).isFalse();
    }

    @Test
    public void testLowerCaseRomanNumerals() {
        assertThat(RomanNumerals.isRomanNumeral("i")).isFalse();
        assertThat(RomanNumerals.isRomanNumeral("iv")).isFalse();
    }

}