// Core
import { Component } from "@angular/core";
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from "@angular/router-deprecated";

// Components
import { DashboardComponent } from "./dashboard.component";
import { HeroesComponent } from "./heroes.component";
import { HeroDetailComponent } from "./hero-detail.component";
import { HeroFormComponent } from "./hero-form.component";
import { UserFormComponent } from "./user-form.component";

// Services
import { HeroService } from "./hero.service";

@Component({
    selector: "app",
    template: `
        <h1>{{title}}</h1>
        <nav>
            <a [routerLink]="['Dashboard']">Dashboard</a>
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
        path: '/dashboard',
        name: 'Dashboard',
        component: DashboardComponent,
        useAsDefault: true
    },
    {
        path: '/heroes',
        name: 'Heroes',
        component: HeroesComponent
    },
    {
        path: '/detail/:id',
        name: 'HeroDetail',
        component: HeroDetailComponent
    },
    {
        path: '/user-edit',
        name: 'UserEdit',
        component: UserFormComponent
    },
])


export class AppComponent {
    title = "Tour of Heroes";
}