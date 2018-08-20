import {
    Component,
    OnInit,
    trigger,
    state,
    style,
    transition,
    animate
} from '@angular/core';
import { Router } from '@angular/router-deprecated'

import { Hero } from "./hero";
import { HeroDetailComponent } from "./hero-detail.component";
import { HeroService } from "./hero.service";
import { HighlightDirective } from "./highlight.directive";

@Component({
    selector: 'heroes',
    templateUrl: "app/heroes.component.html",
    styleUrls: ["app/heroes.component.css"],
    animations: [
        trigger('heroState', [
            state('inactive', style({
                backgroundColor: '#eee',
                transform: 'scale(1)'
            })),
            state('active', style({
                backgroundColor: '#cfd8dc',
                transform: 'scale(1.1)'
            })),
            transition('inactive => active',
                animate('100ms ease-in')),
            transition('active => inactive',
                animate('100ms ease-out'))
        ])
    ],
    directives: [HeroDetailComponent, HighlightDirective],
    providers: [HeroService]
})

export class HeroesComponent implements OnInit {

    heroes: Hero[] = [];
    title = 'Tour of Heroes';
    selectedHero: Hero;
    addingHero: boolean;
    error: any;

    constructor(
        private router: Router,
        private heroService: HeroService) {

        // No heavy lifting codes in constructor
        // No instantiation of a data provider like HeroService in constructor or anywhere for that matter. 
        // Choose dependency injection instead. A word is enough for the wise...

    }

    ngOnInit() {
        this.getHeroes();
    }

    getHeroes() {
        this.heroService
            .getHeroes()
            .then(heroes => this.heroes = heroes);
    }

    onSelect(hero: Hero) {
        this.selectedHero = hero;
    }

    gotoDetail() {
        this.router.navigate(['HeroDetail', { id: this.selectedHero.id }])
    }

    addHero() {
        this.addingHero = true;
        this.selectedHero = null;
    }

    close(savedHero: Hero) {
        this.addingHero = false;
        if (savedHero) { this.getHeroes(); }
    }

    delete(hero: Hero, event: any) {
        event.stopPropagation();
        this.heroService
            .delete(hero)
            .then(res => {
                this.heroes = this.heroes.filter(h => h !== hero);
                if (this.selectedHero === hero) { this.selectedHero = null; }
            })
            .catch(error => this.error = error); // TODO: Display error message
    }

    log(o: Hero) {
        let h = new Hero(3, "Steve", "Holiness", "No", "active");
        o = new Hero(o.id, o.name, o.power, o.state);
        o.toggleState();
        //h.toggleState();
        console.log(o);
        //console.log(o);
    }

}