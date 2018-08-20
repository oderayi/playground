// Model class for Hero
export class Hero {

    constructor(
        public id?: number, 
        public name?: string, 
        public power?: string, 
        public alterEgo?: string,
        public state: string = "inactive") {
    }

   toggleState() {
        this.state = (this.state == 'active') ? 'inactive' : 'active';
        console.log(this.state);
    }
}