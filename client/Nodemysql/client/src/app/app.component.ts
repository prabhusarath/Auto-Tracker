import { Component } from '@angular/core';
import { WarnService } from './services/warn.service';
import { MainService } from './services/main.service';
import { DataService } from './services/data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[WarnService,MainService,DataService]
})
export class AppComponent {
  title = 'app';
}
