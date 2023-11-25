package com.karizma.recettes.models.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private Long id;
    @NotNull(message = "Le champ ne peut pas être nul.")
    private String firstName;
    @NotNull(message = "Le champ ne peut pas être nul.")
    private String lastName;
    @Email
    private String email;

    @NotBlank (message = "Le mot de passe ne peut pas être vide.")
    @Size (min = 6, max = 20, message = "Le mot de passe doit avoir entre 6 et 20 caractères.")
    private String password;
}
