package com.examplestudy.depotapp.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDetailServiceImplTest {
    @Mock
    private  UserRepository mockedRepository;
    @Test
    public void shouldReturnFalse(){
        when(mockedRepository.findByLogin("admin")).thenReturn(new User());
        UserDetailServiceImpl service = new UserDetailServiceImpl(mockedRepository);
        Assertions.assertFalse(service.addUser(new User("admin",anyString(),Role.ADMIN)));

    }
    @Test
    public void shouldReturnTrue(){
        when(mockedRepository.findByLogin("otherLogin")).thenReturn(null);
        UserDetailServiceImpl service = new UserDetailServiceImpl(mockedRepository);
        Assertions.assertTrue(service.addUser(new User("otherLogin",anyString(),Role.USER)));

    }

}