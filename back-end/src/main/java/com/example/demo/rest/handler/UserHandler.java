package com.example.demo.rest.handler;

import com.example.demo.entity.User;
import com.example.demo.rest.dto.UserDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;
import com.example.demo.rest.entitymapper.UserMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserHandler {

    private final UserService userService;
    private final UserMapper userMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<User> usersPage = userService.getAll(page, size);
        List<UserDto> usersDtoList = userMapper.toDto(usersPage.getContent());
        PaginatedResultDto<UserDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(usersDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(usersPage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(UserDto dto) {

        Optional<User> existedUsername= userService.getByUserName(dto.getUsername());
        if(existedUsername.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        User user=userMapper.toEntity(dto);
        userService.save(user);
        UserDto usersDto=userMapper.toDto(user);
        return ResponseEntity.created(URI.create("/user/" + usersDto.getId())).body(usersDto);
    }

    public ResponseEntity<?> getById(Integer id) {
        User user = userService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), id));
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    public ResponseEntity<?> delete(Integer id) {
        User user = userService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), id));
        userService.delete(user);
        return ResponseEntity.noContent().build();

    }

    public ResponseEntity<?> update(Integer userId, UserDto usersDto) {
        User user = userService.getById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), userId));
        Optional<User> existedUser=userService.getByUserName(usersDto.getUsername());
        if(existedUser.isPresent() && !existedUser.get().getId().equals(userId)){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        User entity = userMapper.updateEntityFromDto(usersDto, user);
        userService.update(entity);
        return ResponseEntity.ok().build();
    }


}
