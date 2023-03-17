package shop.mtcoding.hiberpc.config.dummy;

import shop.mtcoding.hiberpc.model.user.User;

public class MyDummyEntity {

    protected User newUser(String username) {
        return User.builder().username(username).password("1234").email("ssar@nate.com").build();
    }
}
