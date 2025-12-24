package kg.attractor.movie_review.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank
    @Email
    private String email;
    private String name;
    @NotBlank
    @Size(min = 5, max = 24, message = "Length must be greater than/equals to 5 and less than/equals to 24 digits")
    @Pattern(
            regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$",
            message = "Should contain at least one UPPERCASE letter, one number"
    )
    private String password;
}
