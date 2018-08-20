import { Component } from '@angular/core';
import { User } from './models/user';
import {UserFactory} from './models/user-factory';


@Component({
    selector: "user-form",
    templateUrl: "app/user-form.component.html",
    providers: [User, UserFactory]
})
export class UserFormComponent {

    private user: User;
    private userFactory: UserFactory;

    // We inject the UserFactory
    constructor(userFactory: UserFactory) {
        this.userFactory = userFactory;
    }

    onSubmit(userInfo: any) {
        // Instantiate and save when the form is submitted
        this.user = this.userFactory.create(userInfo);
        this.user.save();
    }

    getUser() {
        this.user.get();
    }

}