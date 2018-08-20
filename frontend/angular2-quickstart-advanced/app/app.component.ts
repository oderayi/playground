// Core
import { Component } from "@angular/core";
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from "@angular/router-deprecated";

// Add the RxJS Observable operators we need in this app.
import './rxjs-operators';

// Components
import { HeroesComponent } from "./heroes.component";
import { HeroFormComponent } from "./hero-form.component";
import { UserFormComponent } from "./user-form.component";

// Services
import { HeroService } from "./hero.service";

@Component({
    selector: "app",
    template: `
        <h1>{{title}}</h1>
        <nav>
            <a [routerLink]="['Heroes']">Heroes</a>
        </nav> 
        <router-outlet></router-outlet>
        <hr />
        <hero-form></hero-form>

    `,
    styleUrls: ['app/app.component.css'],
    directives: [
        ROUTER_DIRECTIVES,
        HeroFormComponent
    ],
    providers: [
        ROUTER_PROVIDERS,
        HeroService
    ]
})

@RouteConfig([
    {
        path: '/heroes',
        name: 'Heroes',
        component: HeroesComponent,
        useAsDefault: true
    },
    {
        path: '/user-edit',
        name: 'UserEdit',
        component: UserFormComponent
    },
])


export class AppComponent {
    title = "Tour of Heroes - Advanced";
}