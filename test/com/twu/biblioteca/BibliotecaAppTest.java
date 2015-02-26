package com.twu.biblioteca;

import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Gareth Williams on 2/25/15.
 */
public class BibliotecaAppTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCallInitMethod() throws Exception {
        BibliotecaApp mockApp = mock(BibliotecaApp.class);
        doThrow(new RuntimeException()).when(mockApp).init();

        exception.expect(RuntimeException.class);
        mockApp.init();
    }
}
