package com.vscgabriel.application.controller;

import com.vscgabriel.application.dto.UserDTO;
import com.vscgabriel.application.service.UserAppService;
import com.vscgabriel.domain.models.User;
import com.vscgabriel.utils.TokenUtils;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collections;

@Path("/auth")
public class AuthResources {

    @Inject
    UserAppService userAppService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response authenticate(UserCredentials credentials){
        UserDTO user = userAppService.getUserByEmail(credentials.email);
        if (user != null &&  user.getPassword().equals((credentials.password))) {
            String token = TokenUtils.generateToken(user);
            return  Response.ok(new AuthResponse(token)).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    public static class UserCredentials {
        public String email;
        public String password;
    }

    public static class AuthResponse {
        public String token;

        public AuthResponse(String token) {
            this.token = token;
        }
    }

}
