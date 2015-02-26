package com.twu.biblioteca;

import static org.mockito.Mockito.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gareth Williams on 2/25/15.
 */
public class BibliotecaAppTest {

    @Test(expected = RuntimeException.class)
    public void shouldCallInitMethod() throws Exception {
        BibliotecaApp mockApp = mock(BibliotecaApp.class);
        doThrow(new RuntimeException()).when(mockApp).init();
        mockApp.init();
        verify(mockApp).init();
    }
}
