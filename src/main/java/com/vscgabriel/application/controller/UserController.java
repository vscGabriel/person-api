package com.vscgabriel.application.controller;

import com.vscgabriel.application.dto.UserDTO;
import com.vscgabriel.application.service.UserAppService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserAppService userAppService;

    @GET
    @Path("/{id}")
    @Operation(summary = "Get by id", description = "Get user data from the server")
    @APIResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserDTO.class)))
    public UserDTO getUSerById(@PathParam("id") Long id) {
        return userAppService.getPersonById(id);
    }

    @POST
    @Operation(summary = "Create user")
    @APIResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserDTO.class)))
    public Response createUser(UserDTO userDTO) {
        userAppService.createUser(userDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update user")
    @APIResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserDTO.class)))
    public Response updateUser(@PathParam("id") Long id, UserDTO userDTO){
        userAppService.updateUser(id,userDTO);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete user")
    @APIResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserDTO.class)))
    public Response deletePerson(@PathParam("id") Long id) {
        userAppService.deletePerson(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
