package com.lz.demo.controllers;

import com.lz.demo.models.CardDetails;
import org.junit.*;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.ModelAndViewAssert.assertSortAndCompareListModelAttribute;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

public class CardSortControllersTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    MultipartFile input;

    final String testCSV = "bank1,2356-1236-4566-2346,APR-1942\nbank2,1433-1235-6543-2135,JAN-2000";

    @Before
    public void setUp() throws IOException {
        when(input.getBytes()).thenReturn(testCSV.getBytes());
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(input);
    }

    @Test
    public void testCardSortController() throws IOException {

        final CardSortController csc = new CardSortController();
        final ModelAndView mav = csc.handleRequest(input);
        verify(input).getBytes();

        assertViewName(mav,"cardsortresponse");

        final List<CardDetails> expected = asList(
                new CardDetails("bank1", "2356-1236-4566-2346", "APR-1942"),
                new CardDetails("bank2", "1433-1235-6543-2135", "JAN-2000"));

        assertSortAndCompareListModelAttribute(
                mav,
                "results",
                expected,
                null);



    }
}
