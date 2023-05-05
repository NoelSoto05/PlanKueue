package com.PlanKueue.springbootPlanKueue.controllers;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.PlanKueue.springbootPlanKueue.models.Account;

class RegisterTest {

    private Register registerController;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        registerController = new Register();
    }

    @Test
    void testShowRegistrationForm() {
        String viewName = registerController.showRegistrationForm();
        assert (viewName.equals("register"));
    }

    @Test
    void testProcessRegistration_withErrors() {
        when(bindingResult.hasErrors()).thenReturn(true);

        String viewName = registerController.processRegistration(new Account(), bindingResult);

        verifyNoInteractions(model);

        assert(viewName.equals("register"));
    }

    @Test
    void testProcessRegistration_withoutErrors() {
        when(bindingResult.hasErrors()).thenReturn(false);

        String viewName = registerController.processRegistration(new Account(), bindingResult);

        verifyNoInteractions(model);

        assert(viewName.equals("redirect:/login"));
    }

}
