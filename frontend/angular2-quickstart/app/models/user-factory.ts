// models/user-factory.ts
import { Injectable } from '@angular/core';
import {User} from './user';

@Injectable()
export class UserFactory {

  // Uses the User model to create a new User
  create( userInfo: any ) {
    return new User( userInfo );
  }

}