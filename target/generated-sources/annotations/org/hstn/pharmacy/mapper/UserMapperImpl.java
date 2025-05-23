package org.hstn.pharmacy.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.hstn.pharmacy.dto.dtoUser.CreateRequestUser;
import org.hstn.pharmacy.dto.dtoUser.UpdateUserRequest;
import org.hstn.pharmacy.dto.dtoUser.UpdateUserRequestForAdmin;
import org.hstn.pharmacy.dto.dtoUser.UserResponse;
import org.hstn.pharmacy.entity.entityUser.ConfirmationCode;
import org.hstn.pharmacy.entity.entityUser.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-11T22:04:38+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(CreateRequestUser createRequestUser) {
        if ( createRequestUser == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( createRequestUser.getFirstName() );
        user.lastName( createRequestUser.getLastName() );
        user.email( createRequestUser.getEmail() );
        user.password( createRequestUser.getPassword() );
        user.photoLink( createRequestUser.getPhotoLink() );

        user.role( User.Role.USER );
        user.state( User.State.NOT_CONFIRMED );

        return user.build();
    }

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( user.getId() );
        userResponse.firstName( user.getFirstName() );
        userResponse.lastName( user.getLastName() );
        userResponse.email( user.getEmail() );
        if ( user.getRole() != null ) {
            userResponse.role( user.getRole().name() );
        }
        if ( user.getState() != null ) {
            userResponse.state( user.getState().name() );
        }
        userResponse.photoLink( user.getPhotoLink() );

        return userResponse.build();
    }

    @Override
    public List<UserResponse> toResponseList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( users.size() );
        for ( User user : users ) {
            list.add( toResponse( user ) );
        }

        return list;
    }

    @Override
    public User updateUserFromDto(UpdateUserRequest updateUserRequest, User user) {
        if ( updateUserRequest == null && user == null ) {
            return null;
        }

        User.UserBuilder user1 = User.builder();

        if ( updateUserRequest != null ) {
            user1.firstName( updateUserRequest.getFirstName() );
            user1.lastName( updateUserRequest.getLastName() );
            user1.photoLink( updateUserRequest.getPhotoLink() );
            user1.password( updateUserRequest.getPassword() );
        }
        if ( user != null ) {
            user1.email( user.getEmail() );
            user1.role( user.getRole() );
            user1.state( user.getState() );
            Set<ConfirmationCode> set = user.getConfirmationCodes();
            if ( set != null ) {
                user1.confirmationCodes( new LinkedHashSet<ConfirmationCode>( set ) );
            }
        }

        return user1.build();
    }

    @Override
    public User updateUserFromAdminDto(UpdateUserRequestForAdmin updateUserRequestForAdmin, User user) {
        if ( updateUserRequestForAdmin == null && user == null ) {
            return null;
        }

        User.UserBuilder user1 = User.builder();

        if ( updateUserRequestForAdmin != null ) {
            user1.firstName( updateUserRequestForAdmin.getFirstName() );
            user1.lastName( updateUserRequestForAdmin.getLastName() );
            user1.photoLink( updateUserRequestForAdmin.getPhotoLink() );
            user1.password( updateUserRequestForAdmin.getPassword() );
            user1.role( stringToRole( updateUserRequestForAdmin.getRole() ) );
            user1.state( stringToState( updateUserRequestForAdmin.getState() ) );
        }
        if ( user != null ) {
            user1.email( user.getEmail() );
            Set<ConfirmationCode> set = user.getConfirmationCodes();
            if ( set != null ) {
                user1.confirmationCodes( new LinkedHashSet<ConfirmationCode>( set ) );
            }
        }

        return user1.build();
    }
}
