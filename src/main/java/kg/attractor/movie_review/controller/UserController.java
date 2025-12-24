package kg.attractor.movie_review.controller;

import jakarta.validation.Valid;
import kg.attractor.movie_review.dto.UserDto;
import kg.attractor.movie_review.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getUserList() {
        return userService.getList();
    }

//    @GetMapping("{id}")
//    public UserDto getUserById(@PathVariable int id) {
//        return userService.getUserById(id);
//    }

    @PostMapping
    public void createUser(@RequestBody @Valid UserDto userDto) {
        userService.createUser(userDto);
    }

    @GetMapping("search")
    public UserDto searchUsers(
        @RequestParam(name="email") String email) {
        return userService.searchByEmail(email);
    }
}
