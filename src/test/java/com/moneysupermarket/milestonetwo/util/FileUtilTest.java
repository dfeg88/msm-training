package com.moneysupermarket.milestonetwo.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

class FileUtilTest {

    private FileUtil fileUtil = new FileUtil();

    @BeforeEach
    void setUp() {

    }

    @Test
    void shouldThrowNullPointerExceptionIfCsvFileDoesNotExist() {
        Assertions.assertThrows(NullPointerException.class, () -> fileUtil.getCsvFile(""));
    }

    @Test
    void shouldReturnFilePathIfFileExists() {
        String actual = fileUtil.getCsvFile("TEST_DATA");
        String expected = "test/resources/TEST_DATA.csv";

        assertThat(actual).contains(expected);
    }
}