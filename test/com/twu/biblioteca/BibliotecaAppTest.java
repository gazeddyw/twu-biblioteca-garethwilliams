package com.twu.biblioteca;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;
import org.mockito.Mock;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Gareth Williams on 2/25/15.
 */
public class BibliotecaAppTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private BibliotecaApp ba;

    @Mock
    private Driver mockDriver;

    @Before
    public void setup() {
        initMocks(this);
        ba = new BibliotecaApp();
    }

    @Test
    public void shouldCallRunMethod() throws Exception {
        //Driver mockDriver = mock(Driver.class);
        exception.expect(Exception.class);
        doThrow(new Exception()).when(mockDriver).run();
        ba.init();
        verify(mockDriver).run();
    }
}
