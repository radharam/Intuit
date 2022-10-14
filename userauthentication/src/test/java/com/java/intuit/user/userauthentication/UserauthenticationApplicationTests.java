package com.java.intuit.user.userauthentication;

import com.java.intuit.user.userauthentication.controller.UserAuthController;
import com.java.intuit.user.userauthentication.dto.UserDTO;
import com.java.intuit.user.userauthentication.service.IUserAuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static junit.framework.TestCase.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ UserAuthController.class /*To be able to mock the Constructor, we need to add in the Class that creates the new object*/})
//@SpringBootTest(classes = UserauthenticationApplication.class)
class UserAuthControllerTest {

    @Test
    void contextLoads() {
    }


    @InjectMocks
    private UserAuthController userAuthController;

    @Mock
    private IUserAuthService userAuthServicelowerService;

    @Test
    public void registerUserSuccessTest() throws Exception {
        UserDTO userMock = UserDTO.builder()
                .firstName("Radha")
                .lastName("Kunnattur")
                .password(new char[]{'p','w','d'})
                .email("radzram@gmail.com")
                .build();
        when(userAuthController.registerUser(userMock)).thenReturn("User Added Successfully");

        boolean check = (boolean) Whitebox.invokeMethod(userAuthServicelowerService,
                "registerUser");
        assertEquals(true, check);
    }

    @Test
    public void registerUserFailureTest() throws Exception {
        UserDTO userMock = UserDTO.builder()
                .firstName("Radha")
                .lastName("Kunnattur")
                .password(new char[]{'p','w','d'})
                .email("radzram@gmail.com")
                .build();
        when(userAuthController.registerUser(userMock)).thenReturn("User with this email exists");
        boolean check = (boolean) Whitebox.invokeMethod(userAuthServicelowerService,
                "registerUser");
        assertEquals(false, check);
    }

}
