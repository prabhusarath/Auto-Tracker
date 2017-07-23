import { Component, OnInit } from '@angular/core';
import { MainService } from '../../services/main.service';
import { Main } from '../../entity/main';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  maindata: Main[];

  constructor(private wServ: MainService) {

    this.wServ.getVehicle().subscribe( main => {
      this.maindata = main;
    });

  }

  ngOnInit() {
  }

}
