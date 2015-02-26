package com.twu.biblioteca;

import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Gareth Williams on 2/26/15.
 */
public class DriverTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCallRunMethod() throws Exception {
        Driver mockDriver = mock(Driver.class);
        doThrow(new RuntimeException()).when(mockDriver).run();

        exception.expect(RuntimeException.class);
        mockDriver.run();
    }
}
