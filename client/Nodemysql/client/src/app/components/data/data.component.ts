import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data.service';
import { Data } from '../../entity/data';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.css']
})
export class DataComponent implements OnInit {

  data: Data[];

  constructor(private wServ: DataService) {

    this.wServ.getData().subscribe( data => {
      this.data = data;
    });
  }

  ngOnInit() {
  }

}
