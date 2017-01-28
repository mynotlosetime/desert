/**
 * Created by Дмитрий on 28.01.2017.
 */
import Menu from './app/components/menu/menu';
import imageBoard from './app/components/imageBoard/imageBoard';

let menuTemp = new Menu('hello world');
let imageBoardTemp = imageBoard('hot');
debugger;

document.body.innerHTML += menuTemp.template;
document.body.innerHTML += imageBoardTemp;
export default Menu;