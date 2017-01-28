
import * as template from './menu.html';
import './menu.sass';

export default class Menu {

    public template:string;
    
    constructor(options:string){
        console.log(options);
        console.dir(template);
        this.template = template.toString();
    }
}