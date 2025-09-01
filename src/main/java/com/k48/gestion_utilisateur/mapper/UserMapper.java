package com.k48.gestion_utilisateur.mapper;




import com.k48.gestion_utilisateur.dto.UserRequestDTO;
import com.k48.gestion_utilisateur.dto.UserResponseDTO;
import com.k48.gestion_utilisateur.model.User;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface UserMapper {
    // Ignorer l'ID lors du mappage de UserRequestDTO vers User (car l'ID est généré par la DB)
    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDTO dto);

    UserResponseDTO toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UserRequestDTO dto, @MappingTarget User entity);
}
