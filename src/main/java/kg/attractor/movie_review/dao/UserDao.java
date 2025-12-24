package kg.attractor.movie_review.dao;

import kg.attractor.movie_review.dto.UserDto;
import kg.attractor.movie_review.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<User> getUsers() {
        String sql = "SELECT * FROM USER_TABLE";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

//    public Optional<User> getUserById(int id) {
//        String sql= "SELECT * FROM users WHERE id = ?";
//
//        return Optional.ofNullable(
//                DataAccessUtils.singleResult(
//                        jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), id)
//                )
//        );
//    }

    public void create(UserDto userDto) {
        String sql = "insert into USER_TABLE(email, USERNAME, password) values(?,?,?)";

        jdbcTemplate.update(sql, userDto.getEmail(), userDto.getName(), userDto.getPassword());
    }

    public Optional<User> searchByName(String email) {
        String sql = "SELECT * FROM USER_TABLE WHERE email like :email";

        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource()
                                        .addValue("email", "%"+ email + "%"), //%Alex%
                                new BeanPropertyRowMapper<>(User.class))
                )
        );
    }
}
