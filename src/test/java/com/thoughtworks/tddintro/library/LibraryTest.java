package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */
    private List<String> books;
    private PrintStream printStream;
    private DateTimeFormatter dateTimeFormatter;
    private DateTime time;

    public LibraryTest() {
        stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
    }


    @Before
    public void constructBookList(){
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        time = new DateTime();
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";
        books.add(title);

        Library library = new Library(books, printStream, null);

        library.listBooks();

        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        Library library = new Library(books, printStream, null);
        library.listBooks();
        verify(printStream, never()).println();
    }

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {
        books.add("Book One");
        books.add("Book Two");
        Library library = new Library(books, printStream, null);
        library.listBooks();
        verify(printStream).println("Book One");
        verify(printStream).println("Book Two");
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        when(dateTimeFormatter.print(time)).thenReturn("");
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
        verify(printStream).println(contains(""));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

    }
}