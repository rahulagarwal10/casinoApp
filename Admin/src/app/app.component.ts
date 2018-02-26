import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  constructor() {
    let audio = new Audio();
    audio.src = "../../assets/sounds/casino.mp3";
    audio.load();
    audio.play();
    audio.loop=true;
  }
}

