package com.k48.gestion_utilisateur.mapper;

import com.k48.gestion_utilisateur.dto.UserRequestDTO;
import com.k48.gestion_utilisateur.dto.UserResponseDTO;
import com.k48.gestion_utilisateur.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-01T11:55:34+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setName( dto.getName() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
        List<String> list = dto.getRoles();
        if ( list != null ) {
            user.setRoles( new ArrayList<String>( list ) );
        }

        return user;
    }

    @Override
    public UserResponseDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId( user.getId() );
        userResponseDTO.setName( user.getName() );
        userResponseDTO.setEmail( user.getEmail() );
        List<String> list = user.getRoles();
        if ( list != null ) {
            userResponseDTO.setRoles( new ArrayList<String>( list ) );
        }

        return userResponseDTO;
    }

    @Override
    public void updateEntityFromDto(UserRequestDTO dto, User entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
        if ( dto.getPassword() != null ) {
            entity.setPassword( dto.getPassword() );
        }
        if ( entity.getRoles() != null ) {
            List<String> list = dto.getRoles();
            if ( list != null ) {
                entity.getRoles().clear();
                entity.getRoles().addAll( list );
            }
        }
        else {
            List<String> list = dto.getRoles();
            if ( list != null ) {
                entity.setRoles( new ArrayList<String>( list ) );
            }
        }
    }
}
