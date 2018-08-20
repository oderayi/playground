import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable }     from 'rxjs/Observable';

import { Hero }           from './hero';

@Injectable()
export class HeroService {

    constructor(private http: Http) { }

    private heroesUrl = 'http://localhost:90/app/server.php';  // URL to web API
    private heroesIndexUrl = this.heroesUrl + '?action=index';
    private heroesCreateUrl = this.heroesUrl + '?action=store';
    private heroesUpdateUrl = this.heroesUrl + '?action=update';
    private heroesDeleteUrl = this.heroesUrl + '?action=destroy';

    getHeroes(): Observable<Hero[]> {
        return this.http
            .get(this.heroesIndexUrl)
            .map(this.extractData)
            .catch(this.handleError);
    }

    addHero(name: string): Observable<Hero> {
        let body = JSON.stringify({ name }); // Convert { name } object to string
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http
            .post(this.heroesCreateUrl, body, options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    private extractData(res: Response): Hero[] {
        let body = res.json();
        return body.data || {};
    }

    private handleError(error: any) {
        // In a real world app, we might use a remote logging infrastructure
        // We'd also dig deeper into the error to get a better message
        let errMsg = (error.message) ? error.message :
            error.status ? `${error.status} - ${error.statusText}` : 'Server error';
        console.error(errMsg); // log to console instead
        return Observable.throw(errMsg);
    }

}
