import { Component, OnInit } from '@angular/core';
import { WarnService } from '../../services/warn.service';
import { Warn } from '../../entity/warn';

@Component({
  selector: 'app-warn',
  templateUrl: './warn.component.html',
  styleUrls: ['./warn.component.css']
})
export class WarnComponent implements OnInit {

  warndata: Warn[];

  constructor(private wServ: WarnService) {

    this.wServ.getWarnings().subscribe( warn => {
      this.warndata = warn;
    });


  }

  ngOnInit() {
  }

}
